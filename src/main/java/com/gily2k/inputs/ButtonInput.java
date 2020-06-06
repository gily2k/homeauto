package com.gily2k.inputs;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.pi4j.io.gpio.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
public class ButtonInput {
    final GpioController gpio = GpioFactory.getInstance();
    private GpioPinDigitalInput momButton = gpio.provisionDigitalInputPin(RaspiPin.GPIO_02, "mom-button", PinPullResistance.PULL_DOWN);

    @Scheduled(fixedRate = 500)
    public void tickMomButton() {
        Date now = new Date();
        System.out.println(String.format("tick [%s] -> %s", now.toString(), momButton.getState().getName()));
    }


}
