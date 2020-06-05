package com.gily2k.controller;

import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LedController {


    @RequestMapping("/")
    public String greeting() {
        return "Hello world!";
    }

    @RequestMapping("/start")
    public String startListen() {

        return "Ok";
    }

//    @RequestMapping("/light")
//    public String light() {
//        if (pin == null) {
//            GpioController gpio = GpioFactory.getInstance();
//
//            pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.LOW);
//        }
//
//        pin.toggle();
//
//        return GpioFactory.getInstance().getState(pin).toString();
//    }

}