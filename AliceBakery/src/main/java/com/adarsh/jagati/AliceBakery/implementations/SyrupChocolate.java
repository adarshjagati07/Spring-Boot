package com.adarsh.jagati.AliceBakery.implementations;

import com.adarsh.jagati.AliceBakery.interfaces.Syrup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("chocolate-syrup")
public class SyrupChocolate implements Syrup {

    @Override
    public String getSyrupType() {
        return "Chocolate Syrup";
    }
}
