package com.gily2k.controller;

import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LedController {
    private GpioController gpio = GpioFactory.getInstance();
    final GpioPinDigitalInput myButton = gpio.provisionDigitalInputPin(RaspiPin.GPIO_01, PinPullResistance.PULL_DOWN);

    @RequestMapping("/")
    public String greeting() {
        return "Hello world!";
    }

    @RequestMapping("/start")
    public String startListen() {
        myButton.addListener(new GpioPinListenerDigital() {
            @Override
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                System.out.println(" --> GPIO PIN STATE CHANGE: " + event.getPin() + " = " + event.getState());
            }

        });
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