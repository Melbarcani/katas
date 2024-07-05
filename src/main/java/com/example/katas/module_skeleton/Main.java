package com.example.katas.module_skeleton;


public class Main {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();

        // Ajout d'utilisateurs
        userManager.addUser(new User(1, "Alice"));
        userManager.addUser(new User(2, "Bob"));

        // Recherche d'un utilisateur
        System.out.println(userManager.findUser(1));

        // Suppression d'un utilisateur
        userManager.removeUser(1);
        System.out.println(userManager.findUser(1));
    }
}

