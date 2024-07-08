package com.example.katas.christmas_delivery;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class MrsClaus {

    private final FamilyInMemoryRepository familyRepository;

    private final Queue<Elf> availableElfs;
    private final Queue<Present> waitingPresents;

    public MrsClaus(ElfFactory elfFactory, FamilyInMemoryRepository familyRepository, int numberOfElfs) {
        this.familyRepository = familyRepository;
        this.availableElfs = new ConcurrentLinkedQueue<>();
        IntStream.range(0, numberOfElfs).forEach(i -> availableElfs.add(elfFactory.createElf()));
        waitingPresents = new ConcurrentLinkedQueue<>();
    }


    public void givesPresent(List<Present> presents) {
        presents.forEach(
                present -> {
                    var elf = availableElfs.poll();
                    if (elf != null) {
                        Thread.startVirtualThread(() -> {
                            elf.givesPresent(present);
                            onElfBecomesAvailable(elf);
                        });
                    } else {
                        waitingPresents.add(present);
                    }
                });
    }

    public void onElfBecomesAvailable(Elf elf) {
        availableElfs.add(elf);
        var present = waitingPresents.poll();
        if (present != null) {
            elf.givesPresent(present);
            onElfBecomesAvailable(elf);
        }
    }

    public void givesPresentPerFamily(List<Present> presents) {
        var families = familyRepository.getNonDeliveredFamilies();
        Map<FamilyDelivery, List<Present>> familiesPresents = new HashMap<>();
        presents.forEach(p ->
                families.stream()
                        .filter(f -> f.presentNames().contains(p.name()))
                        .findFirst()
                        .ifPresent(updateFamilyPresents(presents, p, familiesPresents)));
    }

    private Consumer<FamilyDelivery> updateFamilyPresents(List<Present> presents, Present
            p, Map<FamilyDelivery, List<Present>> familiesPresents) {
        return foundFamily -> {
            var updatedPresents = familiesPresents.get(foundFamily);
            updatedPresents.add(p);
            if (foundFamily.presentNames().size() == updatedPresents.size()) {
                givesPresent(presents);
                familyDeliveredEvent(foundFamily);
            }
            familiesPresents.put(foundFamily, updatedPresents);
        };
    }

    private void familyDeliveredEvent(FamilyDelivery family) {
        familyRepository.familyDelivered(family);
    }
}
