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
import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
        //Actual

        var userEntity = Mockito.mock(UserEntity.class);

        //List<Long> guardianId = new ArrayList<>();
        // guardianId.add(null);
        // var user = test.fetchUsers();
        //doReturn(List.of(new GuardianEntity())).when(userEntity).getGuardianId();


        var users = List.of(
                new User(6L, "Karla", "Jörger", "FEMALE", 0, false, "Germany",  "karlaj", "#123456789")
                //new User(6L, "Karla", "Jörger", "FEMALE", 0, false, null, "Germany",  "karlaj", "#123456789")
        );


        doReturn(users).when(userService).findAll();

        //Expected: Get - Request
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
                .andExpect(jsonPath("$[0].country").value("Germany"))
                .andExpect(jsonPath("$[0].userName").value("karlaj"))
                .andExpect(jsonPath("$[0].password").value("#123456789"));
    }


    @Test
    @DisplayName("should return 404 if user is not found")
    void should_return_404_if_user_is_not_found() throws Exception {
        //Actual
        doReturn(null).when(userService).findById(anyLong());

        //Expected: GET - Request  +   //Comparing Actual and Expected
        mockMvc.perform(get("/api/v1/user/1000")).andExpect(status().isNotFound());
    }


    @Test
    @DisplayName("should return 201 http status and Location header when creating a user")
    void should_return_201_http_status_and_location_header_when_creating_a_user() throws Exception {
        //Actual
        String userToCreateAsJson = "{\"id\":400,\"firstName\":\"Maria\",\"lastName\":\"Jörger\"}";
       var user = new User(400L,"Maria","Jörger");
       doReturn(user).when(userService).create(any());

        //Expected: POST - Request
       mockMvc.perform(
                       post("/api/v1/user")
                              .contentType(MediaType.APPLICATION_JSON).content(userToCreateAsJson)
                )

               //Comparing Actual and Expected
                .andExpect(status().isCreated())
               .andExpect(header().exists("Location"))
               .andExpect(header().string("Location", Matchers.equalTo(("/api/v1/persons/" + user.getId()))));
            //     .andExpect(header().string("Location", Matchers.containsString(Long.toString(person.getId()))));

    }

    @Test
    @DisplayName("should validate create user request")
    void should_validate_create_user_request() throws Exception {
        //Actual
        String userToCreateAsJson = "{\"id\":200,\"firstName\":\"Bernd\",\"lastName\":\"V\"}";

        //Expected: POST - Request
        mockMvc.perform(
                        post("/api/v1/user")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(userToCreateAsJson)
                )
                //Comparing Actual and Expected
                .andExpect(status().isBadRequest());
    }


    @Test
    public void testFinfByIdRoute() throws Exception {
        //Actual
        User user1 = new User(6L, "Karla", "Jörger");
        user1.setId(6L);
        when(userService.findById(42L)).thenReturn(user1);

        //Expected: GET - Request
        String expected = "{\"id\":6,\"firstName\":\"Karla\",\"lastName\":\"Jörger\"}";

        //Comparing Actual and Expected
        this.mockMvc.perform(get("/user/6"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString(expected)));
    }



}
