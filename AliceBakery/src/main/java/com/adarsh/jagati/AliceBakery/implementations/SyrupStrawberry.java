package com.adarsh.jagati.AliceBakery.implementations;

import com.adarsh.jagati.AliceBakery.interfaces.Syrup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("strawberry-syrup")
public class SyrupStrawberry implements Syrup {

    @Override
    public String getSyrupType() {
        return "Syrup Strawberry";
    }
}
