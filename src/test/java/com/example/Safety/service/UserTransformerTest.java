package com.example.Safety.service;

import com.example.Safety.persistenceSQL.Gender;
import com.example.Safety.persistenceSQL.GuardianEntity;
import com.example.Safety.persistenceSQL.UserEntity;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.doReturn;

public class UserTransformerTest implements WithAssertions {

    private final UserTransformer test = new UserTransformer();

    @Test
    @DisplayName("should transformUserEntity to User")
    void should_transform_user_entity_to_user() {
        // given

        var userEntity = Mockito.mock(UserEntity.class);
        doReturn(6L).when(userEntity).getId();
        doReturn("Karla").when(userEntity).getFirstName();
        doReturn("Jörger").when(userEntity).getLastName();
        doReturn(Gender.FEMALE).when(userEntity).getGender();
        doReturn(0).when(userEntity).getPhoneNumber();
        doReturn(false).when(userEntity).isUser();
        doReturn(List.of(new GuardianEntity())).when(userEntity).getGuardianId();
        doReturn("Germany").when(userEntity).getCountry();
        doReturn("karlaj").when(userEntity).getUserName();
        doReturn("#123456789").when(userEntity).getPassword();



        // when
        var user = test.entityIntoUser(userEntity);

        // then
        assertThat(user.getId()).isEqualTo(6L);
        assertThat(user.getFirstName()).isEqualTo("Karla");
        assertThat(user.getLastName()).isEqualTo("Jörger");
        assertThat(user.getGender()).isEqualTo("FEMALE");
        assertThat(user.getPhoneNumber()).isEqualTo(0);
        assertThat(user.isUser()).isEqualTo(false);
        assertThat(user.getGuardianId()).hasSize(1);
        assertThat(user.getCountry()).isEqualTo("Germany");
        assertThat(user.getUserName()).isEqualTo("karlaj");
        assertThat(user.getPassWord()).isEqualTo("#123456789");



    }

}
