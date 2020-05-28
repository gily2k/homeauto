package com.gily2k.controller;

import com.pi4j.io.gpio.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LedController {

    private static GpioPinDigitalOutput pin;

    @RequestMapping("/")
    public String greeting() {
        return "Hello world!";
    }

    @RequestMapping("/light")
    public String light() {
        if (pin == null) {
            GpioController gpio = GpioFactory.getInstance();

            pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.HIGH);
        }

        pin.pulse(3000);

        return GpioFactory.getInstance().getState(pin).toString();
    }

}