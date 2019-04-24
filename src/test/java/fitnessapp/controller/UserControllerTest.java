package fitnessapp.controller;

import fitnessapp.model.User;
import fitnessapp.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserControllerTest {

    private UserService service = mock(UserService.class);
    private UserController controller;

    @Before
    public void setUp(){
        controller = new UserController(service);
    }

    @Test
    public void getById_UserIsPresent_returnsOKAndUser(){
        when(service.getById(any(long.class))).thenReturn(Optional.of(new User()));

        ResponseEntity response = controller.getById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void getById_userIsNotPresent_returnsNotFound(){
        when(service.getById(any(long.class))).thenReturn(Optional.empty());

        ResponseEntity response = controller.getById(1);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void getAll_listIsEmpty_returnsNoContent(){
        when(service.getAll()).thenReturn(new ArrayList<>());

        ResponseEntity response = controller.getAll();

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    public void getAll_listIsFilled_returnsOk(){
        when(service.getAll()).thenReturn(Arrays.asList(new User(), new User()));

        ResponseEntity response = controller.getAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void save_userIsSaved_returnCreated(){
        when(service.save(any(User.class))).thenReturn(true);

        ResponseEntity response = controller.save(new User());

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    public void save_userIsNotSaved_returnsConflict(){
        when(service.save(any(User.class))).thenReturn(false);

        ResponseEntity response = controller.save(new User());

        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    }

    @Test
    public void update_userIsNotUpdated_returnsConflict(){
        when(service.getById(any(long.class))).thenReturn(Optional.of(new User()));
        when(service.update(any(User.class))).thenReturn(false);

        ResponseEntity response = controller.update(1);

        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    }

    @Test
    public void update_userIsUpdated_returnsAccepted(){
        when(service.getById(any(long.class))).thenReturn(Optional.of(new User()));
        when(service.update(any(User.class))).thenReturn(true);

        ResponseEntity response = controller.update(1);

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
    }

    @Test
    public void update_userNotInDataBase_returnsNotFound(){
        when(service.getById(any(long.class))).thenReturn(Optional.empty());

        ResponseEntity response = controller.update(1);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

    }

    @Test
    public void delete_userIsNotDeleted_returnsConflict(){
        when(service.getById(any(long.class))).thenReturn(Optional.of(new User()));
        when(service.delete(any(User.class))).thenReturn(false);

        ResponseEntity response = controller.delete(1);

        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    }

    @Test
    public void delete_userIsDeleted_returnsAccepted(){
        when(service.getById(any(long.class))).thenReturn(Optional.of(new User()));
        when(service.delete(any(User.class))).thenReturn(true);

        ResponseEntity response = controller.delete(1);

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
    }

    @Test
    public void delete_userNotPresentInDB_returnsNotFound(){
        when(service.getById(any(long.class))).thenReturn(Optional.empty());

        ResponseEntity response = controller.delete(1);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }


}