package com.gily2k.inputs;

import com.pi4j.io.gpio.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
public class ButtonInput {
    GpioController gpio = null;
    GpioPinDigitalInput momButton = null;
    GpioPinDigitalOutput led = null;

    public ButtonInput() {
        gpio = GpioFactory.getInstance();
        momButton = gpio.provisionDigitalInputPin(RaspiPin.GPIO_02, "mom-button", PinPullResistance.PULL_DOWN);
        led = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.LOW);
    }

    @Scheduled(fixedRate = 100)
    public void tickMomButton() {
        Date now = new Date();
        PinState state = momButton.getState();
        System.out.println(String.format("tick [%s] -> %s", now.toString(), state));
        if (momButton.isHigh()) {
            led.setState(PinState.HIGH);
        }else {
            led.setState(PinState.LOW);
        }
    }


}
