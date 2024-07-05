package com.example.katas.christmas_delivery;

import java.util.List;
import java.util.stream.IntStream;

public class ToyMachine {
    private final Elf elf;
    private final MrsClaus claus;

    public ToyMachine(Elf elf, MrsClaus claus) {
        this.elf = elf;
        this.claus = claus;
    }

    public void startDelivering() {
        var present = createToy();
        elf.givesPresent(present);
    }

    private Present createToy() {
        return new Present("toy1");
    }

    public void startBatchDelivering(int presentsNumber) {
        var presents = createPresents(presentsNumber);
        claus.givesPresent(presents);
    }

    private List<Present> createPresents(int presentsNumber) {
        return IntStream.range(0, presentsNumber).mapToObj(n -> new Present("toy" + (n + 1))).toList();
    }

}
