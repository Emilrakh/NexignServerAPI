package server.NexignServerAPI.tests;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import server.NexignServerAPI.exception.ResourceNotFoundException;

import server.NexignServerAPI.repository.UserRepository;
import server.NexignServerAPI.services.UserService;


import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static org.mockito.ArgumentMatchers.*;


@SpringBootTest
class TestNexignServerAPI {
    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    public void whenUserIDNotExist() {
        Mockito.when(userRepository.findById(anyLong())).thenReturn(Optional.empty());
        Long userID = ThreadLocalRandom.current().nextLong(10000, Long.MAX_VALUE);
        try {
            userService.getUserById(userID);
            Assertions.fail("exception wasn't thrown");
        } catch (Exception e) {
            Assertions.assertEquals(ResourceNotFoundException.class, e.getClass(), "smth wrong");
            Assertions.assertEquals( userID + "ID not found", e.getMessage(), "smth wrong");
        }
        Mockito.verify(userRepository).findById(eq(userID));
        Mockito.verifyNoMoreInteractions(userRepository);
    }
}

