package org.notification.email.controller;

import org.notification.email.entity.Notifications;
import org.notification.email.repository.NotificationsRepository;
import org.notification.email.service.NotificationsService;
import org.notification.email.service.mailSenderService;
import org.notification.email.tasks.ScheduledTasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class NotificationsController {

    private final NotificationsRepository notificationsRepository;
    private final mailSenderService msService;
    private final NotificationsService notificationsService;

    private ScheduledTasks scheduledTasks;

    @Autowired
    public NotificationsController(NotificationsRepository notificationsRepository, mailSenderService msService, NotificationsService notificationsService/*, ScheduledTasks scheduledTasks*/) {
        this.notificationsRepository = notificationsRepository;
        this.msService = msService;
        this.notificationsService = notificationsService;
//      this.scheduledTasks = scheduledTasks;
    }


    @RequestMapping(value="/send", method = RequestMethod.GET)
    public ModelAndView notificationsRequest(ModelAndView modelAndView, Notifications notifications){
        modelAndView.addObject("Notifications", notifications);
        modelAndView.setViewName("send");
        return modelAndView;
    }

    @RequestMapping(value="/send", method=RequestMethod.POST)
    public ModelAndView registerNotification(ModelAndView modelAndView, Notifications notifications){

        notificationsRepository.save(notifications);

        SimpleMailMessage email = new SimpleMailMessage();

        email.setTo(notifications.getRecipient());
        email.setSubject("email");
        email.setFrom("aakhmedkhodzhaev@gmail.com");
        email.setText(notifications.getMessage());

        msService.sendEmail(email);

        modelAndView.addObject("Recipient", notifications.getRecipient());
        modelAndView.setViewName("welldone");

        return modelAndView;

    }

    @RequestMapping("/status"   )
    public ModelAndView findAll (){
      /*Iterable<Notifications> notify;
        notify = notificationsRepository.findAll();*/
        List<Notifications> notify = notificationsService.findAll();
        ModelAndView modelAndView = new ModelAndView("status");
        modelAndView.addObject("notify", notify);
        notificationsRepository.findByStatus("Wait");
        scheduledTasks.sentNotifications();
        return modelAndView;
    }

}