package com.example.Safety.service;

import com.example.Safety.api.Guardian;

import com.example.Safety.persistenceSQL.GuardianRepository;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class GuardianServiceTest implements WithAssertions {

    @Mock
    private GuardianRepository repository;

    @InjectMocks
    private GuardianService test;

   /* @Autowired
    private UserService service;

    @MockBean
    private UserRepository repository;*/

    //DeleteById
    @Test
    @DisplayName("should return true if delete was successful")
    void should_return_true_if_delete_was_successful() {
        //Actual
        Long givenId = 33L;
        doReturn(true).when(repository).existsById(givenId);

        //Expected
        boolean result = test.deleteById(givenId);

        //Comparing Actual and Expected
        verify(repository).deleteById(givenId);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("should return false if guardian to delete does not exist")
    void should_return_false_if_guardian_to_delete_does_not_exist() {
        //Actual
        Long givenId = 6L;
        doReturn(false).when(repository).existsById(givenId);

        // Expected
        boolean result = test.deleteById(givenId);

        //Comparing Actual and Expected
        verifyNoMoreInteractions(repository);
        assertThat(result).isFalse();
    }








}
