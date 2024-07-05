package com.example.katas.christmas_delivery;

public record Elf() {
    private static final int DELIVERING_TIME = 2000;
    public void givesPresent(Present present){
        try {
            Thread.sleep(DELIVERING_TIME);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        SantaSleigh.packsOnto(present);
    }
}
