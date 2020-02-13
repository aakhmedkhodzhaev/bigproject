package org.notification.email.controller;

import java.util.List;

import org.notification.email.entity.Notification;
import org.notification.email.entity.Status;
import org.notification.email.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class NotificationsController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationsController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/send")
    public ModelAndView notificationsRequest(ModelAndView modelAndView){
        modelAndView.setViewName("send");
        return modelAndView;
    }

    @PostMapping("/send")
    public ModelAndView registerNotification(ModelAndView modelAndView, Notification notification){

        notification.setStatusValue(Status.WAIT);

        notificationService.saveNotify(notification);

        modelAndView.addObject("Recipient", notification.getRecipient());
        modelAndView.setViewName("welldone");

        return modelAndView;

    }

    @GetMapping("/status")
    public ModelAndView findAll (){
        List<Notification> notify = notificationService.findAll();
        ModelAndView modelAndView = new ModelAndView("status");
        modelAndView.addObject("notify", notify);
        return modelAndView;
    }

}