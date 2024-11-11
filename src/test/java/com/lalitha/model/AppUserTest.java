package com.lalitha.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppUserTest {
    private AppUser appUser;

    @BeforeEach
    void setUp() {
        appUser=new AppUser("user1","Lexicon@123",AppRole.ROLE_APP_USER);
    }

    @Test
    void getUsername() {
        assertEquals("user1",appUser.getUsername());
    }

    @Test
    void setUsername() {
        appUser.setUsername("user2");
        assertEquals("user2",appUser.getUsername());
    }

    @Test
    void getPassword() {
        assertEquals("Lexicon@123",appUser.getPassword());
    }

    @Test
    void setPassword() {
        appUser.setPassword("Lexicon@1234");
        assertEquals("Lexicon@1234",appUser.getPassword());

    }

    @Test
    void getRole() {
        assertEquals(AppRole.ROLE_APP_USER,appUser.getRole());
    }

    @Test
    void setRole() {
        appUser.setRole(AppRole.ROLE_APP_ADMIN);
        assertEquals(AppRole.ROLE_APP_ADMIN,appUser.getRole());
    }
}
