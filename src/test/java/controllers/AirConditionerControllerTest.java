package controllers;

import static org.mockito.Mockito.*;

import com.codepoetmedia.controllers.AirConditionerController;
import com.codepoetmedia.services.AirConditionerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AirConditionerControllerTest {

    private AirConditionerController acController;
    private AirConditionerServiceImpl mockAcService;

    @BeforeEach
    public void setUp() {
        // Mock the AirConditionerService
        mockAcService = mock(AirConditionerServiceImpl.class);

        // Initialize the AirConditionerController with the mocked service
        acController = new AirConditionerController(mockAcService);
    }

    @Test
    public void testTurnOnAirConditioner() {
        // Act
        acController.turnOn();

        // Assert
        verify(mockAcService, times(1)).turnOn();
    }

    @Test
    public void testTurnOffAirConditioner() {
        // Act
        acController.turnOff();

        // Assert
        verify(mockAcService, times(1)).turnOff();
    }

    @Test
    public void testSetTemperature() {
        // Arrange
        String temperature = "22.5";
        Double tempDouble = Double.parseDouble(temperature);

        // Act
        acController.setTemperature(temperature);

        // Assert
        verify(mockAcService, times(1)).setTemperature(tempDouble);
    }
}