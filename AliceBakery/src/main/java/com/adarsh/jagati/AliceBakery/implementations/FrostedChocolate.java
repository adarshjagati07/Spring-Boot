package com.adarsh.jagati.AliceBakery.implementations;

import com.adarsh.jagati.AliceBakery.interfaces.Frosting;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("chocolate-frosting")
public class FrostedChocolate implements Frosting {

    @Override
    public String getFrostingType() {
        return "Chocolate Frosting";
    }
}
