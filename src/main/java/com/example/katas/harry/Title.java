package com.example.katas.harry;

public enum Title {
    SORCERERS_STONE("Harry Potter à l'école des sorciers"),
    CHAMBER_OF_SECRETS("Harry Potter et la Chambre des secrets"),
    PRISONER_OF_AZKABAN("Harry Potter et le Prisonnier d'Azkaban"),
    GOBLET_OF_FIRE("Harry Potter et la Coupe de feu"),
    ORDER_OF_THE_PHOENIX("Harry Potter et l'Ordre du Phénix");

    private final String title;


    Title(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
