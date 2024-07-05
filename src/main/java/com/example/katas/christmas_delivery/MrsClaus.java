package com.example.katas.christmas_delivery;

import java.util.List;

public class MrsClaus {

    private final ElfFactory elfFactory;

    public MrsClaus(ElfFactory elfFactory) {
        this.elfFactory = elfFactory;
    }


    public void givesPresent(List<Present> presents) {
        presents.forEach(
                present -> Thread.startVirtualThread(() -> {
                    var elf = elfFactory.createElf();
                    elf.givesPresent(present);
                })
        );
    }
}
