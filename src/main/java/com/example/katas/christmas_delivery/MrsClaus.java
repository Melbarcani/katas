package com.example.katas.christmas_delivery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MrsClaus {

    private final ElfFactory elfFactory;
    private final FamilyInMemoryRepository familyRepository;

    public MrsClaus(ElfFactory elfFactory, FamilyInMemoryRepository familyRepository) {
        this.elfFactory = elfFactory;
        this.familyRepository = familyRepository;
    }


    public void givesPresent(List<Present> presents) {
        presents.forEach(
                present -> Thread.startVirtualThread(() -> {
                    var elf = elfFactory.createElf();
                    elf.givesPresent(present);
                })
        );
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

    private Consumer<FamilyDelivery> updateFamilyPresents(List<Present> presents, Present p, Map<FamilyDelivery, List<Present>> familiesPresents) {
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
