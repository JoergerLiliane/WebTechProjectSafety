package com.example.Safety.api.config;
import com.example.Safety.api.User;
import com.example.Safety.api.UserRestController;
import com.example.Safety.persistenceSQL.GuardianEntity;
import com.example.Safety.persistenceSQL.UserEntity;
import com.example.Safety.service.UserService;
import com.example.Safety.service.UserTransformer;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.assertj.core.api.WithAssertions;



@WebMvcTest(UserRestController.class)
class UserRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    public UserService userService;


    @Test
    @DisplayName("should return found users from user service")
    void should_return_found_user_from_user_service() throws Exception {
        // given

        var userEntity = Mockito.mock(UserEntity.class);

        //List<Long> guardianId = new ArrayList<>();
        // guardianId.add(null);
        // var user = test.fetchUsers();
        //doReturn(List.of(new GuardianEntity())).when(userEntity).getGuardianId();


        var users = List.of(
                new User(6L, "Karla", "Jörger", "FEMALE", 0, false, null, "Germany",  "karlaj", "123456789")

        );


        doReturn(users).when(userService).findAll();

        // when Get Methode
        mockMvc.perform(get("/api/v1/user"))
                // then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].id").value(6))
                .andExpect(jsonPath("$[0].firstName").value("Karla"))
                .andExpect(jsonPath("$[0].lastName").value("Jörger"))
                .andExpect(jsonPath("$[0].gender").value("FEMALE"))
                .andExpect(jsonPath("$[0].phoneNumber").value(0))
                .andExpect(jsonPath("$[0].isUser").value(false))
                .andExpect(jsonPath("$[0].guardianId").value(null))
                .andExpect(jsonPath("$[0].country").value("Germany"))
                .andExpect(jsonPath("$[0].userName").value("karlaj"))
                .andExpect(jsonPath("$[0].password").value("#123456789"));
    }


    @Test
    @DisplayName("should return 404 if user is not found")
    void should_return_404_if_user_is_not_found() throws Exception {
        // given
        doReturn(null).when(userService).findById(anyLong());

        // when
        mockMvc.perform(get("/api/v1/user/400"))
                // then
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("should return 201 http status and Location header when creating a user")
    void should_return_201_http_status_and_location_header_when_creating_a_user() throws Exception {
        // given
        String userToCreateAsJson = "{\"firstName\": \"Maria\", \"lastName\":\"Jörger\", \"gender\":\"FEMALE\", \"phoneNUmber\": 0,\"isUser\":false,  \"country\":\"France\",\"userName\":\"karlamj\"}";
      // var user = new User(400L, null, null, null, 0, false, null, null, null, null);
       // doReturn(user).when(userService).create(any());

        // when
       // mockMvc.perform(
                       // post("/api/v1/user")
                             //   .contentType(MediaType.APPLICATION_JSON)
                               // .content(userToCreateAsJson)
                //)
                // then
                //.andExpect(status().isCreated())
               // .andExpect(header().exists("Location"))
              //  .andExpect(header().string("Location", Matchers.equalTo(("/api/v1/persons/" + user.getId()))));
//            .andExpect(header().string("Location", Matchers.containsString(Long.toString(person.getId()))));

    }

    @Test
    @DisplayName("should validate create user request")
    void should_validate_create_user_request() throws Exception {
        // given
        String personToCreateAsJson = "{\"firstName\": \"a\", \"lastName\":\"\", \"gender\":\"MALE\", \"phoneNumber\"0}";

        // when
        mockMvc.perform(
                        post("/api/v1/user")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(personToCreateAsJson)
                )
                // then
                .andExpect(status().isBadRequest());
    }


    @Test
    @DisplayName("should return user finById ")
    void should_return_found_user() throws Exception {



    }



}
