package fitnessapp.controller;

import fitnessapp.model.WorkOut;
import fitnessapp.service.WorkOutService;
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

public class WorkOutControllerTest {

    private WorkOutService service = mock(WorkOutService.class);
    private WorkOutController controller;

    @Before
    public void startUp() {
        controller = new WorkOutController(service);
    }

    @Test
    public void getById_workOutIsNotPresent_returnsNotFound() {
        when(service.getById(any(long.class))).thenReturn(Optional.empty());

        ResponseEntity response = controller.getById(any(long.class));

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void getById_workOutIsPresent_returnsOk() {
        when(service.getById(any(long.class))).thenReturn(Optional.of(new WorkOut()));

        ResponseEntity response = controller.getById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void getAll_listIsEmpty_returnsNoContent() {
        when(service.getAll()).thenReturn(new ArrayList<>());

        ResponseEntity response = controller.getAll();

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    public void getAll_listIsFilled_returnsOk() {
        when(service.getAll()).thenReturn(Arrays.asList(new WorkOut(), new WorkOut()));

        ResponseEntity response = controller.getAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void save_workOutCreated_returnsCreated() {
        when(service.save(any(WorkOut.class))).thenReturn(true);

        ResponseEntity response = controller.save(new WorkOut());

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    public void save_workOutNotAccepted_returnsConflict() {
        when(service.save(any(WorkOut.class))).thenReturn(false);

        ResponseEntity response = controller.save(any(WorkOut.class));

        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    }

    @Test
    public void update_workOutNotPresent_returnsNotFound() {
        when(service.getById(any(long.class))).thenReturn(Optional.empty());

        ResponseEntity response = controller.update(any(long.class));

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void update_accepted_returnsAccepted() {
        when(service.getById(any(long.class))).thenReturn(Optional.of(new WorkOut()));
        when(service.update(any(WorkOut.class))).thenReturn(true);

        ResponseEntity response = controller.update(1);

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
    }

    @Test
    public void update_notAccepted_returnsConflict() {
        when(service.getById(any(long.class))).thenReturn(Optional.of(new WorkOut()));
        when(service.update(any(WorkOut.class))).thenReturn(false);

        ResponseEntity response = controller.update(1);

        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    }

    @Test
    public void delete_workOutNotPresent_returnsNotFound(){
        when(service.getById(any(long.class))).thenReturn(Optional.empty());

        ResponseEntity response = controller.delete(1);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void delete_accepted_returnsAccepted(){
        when(service.getById(any(long.class))).thenReturn(Optional.of(new WorkOut()));
        when(service.delete(any(WorkOut.class))).thenReturn(true);

        ResponseEntity response = controller.delete(1);

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
    }

    @Test
    public void delete_notAccepted_returnsConflict(){
        when(service.getById(any(long.class))).thenReturn(Optional.of(new WorkOut()));
        when(service.delete(any(WorkOut.class))).thenReturn(false);

        ResponseEntity response = controller.delete(1);

        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    }

    @Test
    public void getByUserId_noWorkOutsPresent_returnsNoContent(){
        when(service.getByUserId(any(long.class))).thenReturn(new ArrayList<>());

        ResponseEntity response = controller.getByUserId(1);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    public void getByUserId_workOutsArePresent_returnsOK(){
        when(service.getByUserId(any(long.class))).thenReturn(Arrays.asList(new WorkOut(), new WorkOut()));

        ResponseEntity response = controller.getByUserId(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}