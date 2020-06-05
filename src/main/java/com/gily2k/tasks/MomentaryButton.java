package com.gily2k.tasks;

import com.pi4j.io.gpio.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MomentaryButton {
//    final GpioController gpio = GpioFactory.getInstance();
//    GpioPinDigitalInput myButton = gpio.provisionDigitalInputPin(RaspiPin.GPIO_01,
//            "MyButton",
//            PinPullResistance.PULL_UP);
//
//    GpioPinDigitalOutput myLed = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "MyLED", PinState.LOW);
//
//    @Scheduled(fixedRate=100)
//    public void checkButton() {
//        Date now = new Date();
//        System.out.println(String.format("Button check [%s] button state -> %s", now, myButton.getState()));
//        if (myButton.isHigh()) {
//            myLed.setState(PinState.HIGH);
//        } else {
//            myLed.setState(PinState.LOW);
//        }
//
//    }

}
