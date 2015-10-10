package com.ipowertec.abigear.presentation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AlarmController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AlarmController.class);

    @RequestMapping("/alarm/setalarm")
    public ModelAndView setAlarmPage() {
        LOGGER.debug("Getting alarm page");
        return new ModelAndView("setalarm");
    }
}
