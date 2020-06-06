package com.gily2k.controller;


import com.pi4j.io.gpio.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LedController {
    private GpioController gpio = GpioFactory.getInstance();
    final GpioPinDigitalOutput led = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.LOW);

    @RequestMapping("/led/blink")
    public String blink() {
        led.blink(5000, 2000);
        return "blink";
    }

    @RequestMapping("/led/toggle")
    public String startListen() {
        led.toggle();
        return led.getState().getName();
    }


}