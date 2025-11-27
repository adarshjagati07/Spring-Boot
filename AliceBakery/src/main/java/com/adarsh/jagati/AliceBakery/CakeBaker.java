package com.adarsh.jagati.AliceBakery;

import com.adarsh.jagati.AliceBakery.interfaces.Frosting;
import com.adarsh.jagati.AliceBakery.interfaces.Syrup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CakeBaker {
    private Frosting frost;
    private Syrup syrup;

    public CakeBaker(@Qualifier("strawberry-frosting")Frosting frost, @Qualifier("chocolate-syrup") Syrup syrup){
        this.frost = frost;
        this.syrup = syrup;
    }

    public void bakeCake() {
        System.out.println("Baking cake with "+ frost.getFrostingType() + " and " + syrup.getSyrupType());
    }
}
