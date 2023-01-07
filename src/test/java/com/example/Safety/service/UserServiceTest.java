package com.example.Safety.service;

import com.example.Safety.api.User;
import com.example.Safety.persistenceSQL.UserEntity;
import com.example.Safety.persistenceSQL.UserRepository;
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
class UserServiceTest implements WithAssertions {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserService test;

   /* @Autowired
    private UserService service;

    @MockBean
    private UserRepository repository;*/

    //DeleteById
    @Test
    @DisplayName("should return true if delete was successful")
    void should_return_true_if_delete_was_successful() {
        // given
        Long givenId = 6L;
        doReturn(true).when(repository).existsById(givenId);

        // when
        boolean result = test.deleteById(givenId);

        // then
        verify(repository).deleteById(givenId);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("should return false if person to delete does not exist")
    void should_return_false_if_user_to_delete_does_not_exist() {
        // given
        Long givenId = 6L;
        doReturn(false).when(repository).existsById(givenId);

        // when
        boolean result = test.deleteById(givenId);

        // then
        verifyNoMoreInteractions(repository);
        assertThat(result).isFalse();
    }





    @Test
    @DisplayName("should find a user by  id")
    void thisTestGet() {
        var user1 = new User(6L, "Karla", "Jörger", "FEMALE", 0, false, null, "Germany",  "karlaj", "123456789");
        doReturn(Optional.of(user1)).when(repository).findById(6L);


        User actual = test.findById(6L);

        assertEquals(actual.getFirstName(), "Karla");
    }





}
