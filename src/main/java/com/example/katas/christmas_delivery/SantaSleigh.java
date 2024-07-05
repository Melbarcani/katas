package com.example.katas.christmas_delivery;

import java.util.ArrayList;
import java.util.List;

public class SantaSleigh {
    private static final List<Present> presents = new ArrayList<>();

    public static void packsOnto(Present present){
        presents.add(present);
    }

}
