package com.codding.edemail.controller;

import com.codding.edemail.model.model;
import com.codding.edemail.model.smsstatus;
import com.codding.edemail.service.smsstatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

public class smsstatusController {

    private final smsstatusService ssService;

    @Autowired
    public smsstatusController(smsstatusService ssService){
        this.ssService=ssService;
    }


    @GetMapping("/status")
    public String findAll(Model model){
        List<smsstatus> ss = ssService.findAll();
        model.addAttribute("status", ss);
        return "smsstatus";
    }

    @GetMapping("/smsstatusId/{id}")
    public String findById(@PathVariable("id") Long transferId, Model model){
        smsstatus ss = ssService.findById(transferId);
        model.addAttribute("users", ss);
        return "/smsstatusId";
    }

    @GetMapping("smsstatus-delete/{id}")
    public String deleteSmssend(@PathVariable("id") Long transfer_id){
        ssService.deleteById(transfer_id);
        return "redirect:/smsstatus";
    }

}