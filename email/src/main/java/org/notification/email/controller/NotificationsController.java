package org.notification.email.controller;

import org.notification.email.entity.Notifications;
import org.notification.email.entity.Status;
import org.notification.email.entity.Type;
import org.notification.email.repository.NotificationsRepository;
import org.notification.email.service.NotificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class NotificationsController {

    private final NotificationsRepository notificationsRepository;
    private final NotificationsService notificationsService;

    @Autowired
    public NotificationsController(NotificationsRepository notificationsRepository, NotificationsService notificationsService) {
        this.notificationsRepository = notificationsRepository;
        this.notificationsService = notificationsService;
    }


    @RequestMapping(value="/send", method = RequestMethod.GET)
    public ModelAndView notificationsRequest(ModelAndView modelAndView, Notifications notifications){
        modelAndView.setViewName("send");
        return modelAndView;
    }

    @RequestMapping(value="/send", method=RequestMethod.POST)
    public ModelAndView registerNotification(ModelAndView modelAndView, Notifications notifications){

        notifications.getNotificationType();
        notifications.getRecipient();
        notifications.getMessage();
        notifications.setStatusValue(Status.WAIT);

        notificationsRepository.save(notifications);

        modelAndView.addObject("Recipient", notifications.getRecipient());
        modelAndView.setViewName("welldone");

        return modelAndView;

    }

    @RequestMapping("/status")
    public ModelAndView findAll (){
        List<Notifications> notify = notificationsService.findAll();
        ModelAndView modelAndView = new ModelAndView("status");
        modelAndView.addObject("notify", notify);
        return modelAndView;
    }

}