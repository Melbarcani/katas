package com.example.katas.module_skeleton;

import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

public class UserManagerTest {

    @Test
    public void testAddUser() {
        UserManager userManager = new UserManager();
        User user = new User(1, "Alice");
        userManager.addUser(user);
        assertEquals(Optional.of(user), userManager.findUser(1));
    }

    @Test
    public void testRemoveUser() {
        UserManager userManager = new UserManager();
        User user = new User(1, "Alice");
        userManager.addUser(user);
        userManager.removeUser(1);
        assertEquals(Optional.empty(), userManager.findUser(1));
    }

    @Test
    public void testFindUser() {
        UserManager userManager = new UserManager();
        User user = new User(1, "Alice");
        userManager.addUser(user);
        assertEquals(Optional.of(user), userManager.findUser(1));
    }
}
