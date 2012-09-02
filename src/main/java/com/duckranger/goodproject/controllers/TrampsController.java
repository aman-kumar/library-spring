package com.duckranger.goodproject.controllers;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.duckranger.goodproject.service.TrampsService;

@Controller
public class TrampsController {
    private static final Logger logger = LoggerFactory
            .getLogger(TrampsController.class);


    @Autowired
    private TrampsService trampsService;

    @RequestMapping(value = "/aman", method = RequestMethod.GET)
    public String list(Model model) {
        logger.info("Listing walks");
        model.addAttribute("tramps", trampsService.findAll());
        return "tramps/list";
    }

}
