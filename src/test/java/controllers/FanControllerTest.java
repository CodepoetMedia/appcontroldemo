package controllers;

import static org.mockito.Mockito.*;

import com.codepoetmedia.controllers.FanController;
import com.codepoetmedia.services.FanServiceImpl;
import com.codepoetmedia.models.FanSpeed;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FanControllerTest {

    private FanController fanController;
    private FanServiceImpl mockFanService;

    @BeforeEach
    public void setUp() {
        // Mock the FanService
        mockFanService = mock(FanServiceImpl.class);

        // Initialize the FanController with the mocked service
        fanController = new FanController(mockFanService);
    }

    @Test
    public void testTurnOffFan() {
        // Act
        fanController.turnOff();

        // Assert
        verify(mockFanService, times(1)).setFanSpeed(FanSpeed.OFF);
    }

    @Test
    public void testSetFanSpeed() {
        // Arrange
        FanSpeed speed = FanSpeed.HIGH;
        String speedString = "2";

        // Act
        fanController.setSpeed(speedString);

        // Assert
        verify(mockFanService, times(1)).setFanSpeed(speed);
    }
}