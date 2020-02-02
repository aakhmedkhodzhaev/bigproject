package com.codding.edemail.controller;


import com.codding.edemail.model.model;
import com.codding.edemail.repository.modelRepository;
import com.codding.edemail.service.mailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class modelController {

    private final modelRepository mRepository;
    private final mailSenderService msService;

    @Autowired
    public modelController(@Qualifier("modelRepository") modelRepository mRepository, mailSenderService msService) {
        this.mRepository = mRepository;
        this.msService = msService;
    }

    @RequestMapping(value="/send", method=RequestMethod.GET)
    public ModelAndView notificationRequest(ModelAndView modelAndView, model md){
        modelAndView.addObject("model", md);
        modelAndView.setViewName("send");
        return modelAndView;

    }

    @RequestMapping(value="/send", method=RequestMethod.POST)
    public ModelAndView registerNotification(ModelAndView modelAndView, model md){

        mRepository.save(md);

        SimpleMailMessage email = new SimpleMailMessage();

        email.setTo(md.getRecipient());
        email.setSubject("email");
        email.setFrom("aakhmedkhodzhaev@gmail.com");
        email.setText(md.getMessage());

        msService.sendEmail(email);

        modelAndView.addObject("Recipient", md.getRecipient());
        modelAndView.setViewName("notificationwelldone");

        return modelAndView;

    }

}