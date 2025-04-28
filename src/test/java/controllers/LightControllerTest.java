package controllers;

import static org.mockito.Mockito.*;
import com.codepoetmedia.controllers.LightController;
import com.codepoetmedia.services.LightServiceImpl;
import com.codepoetmedia.models.LightStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LightControllerTest {

    private LightController lightController;
    private LightServiceImpl mockLightService;

    @BeforeEach
    public void setUp() {
        // Mock the LightService
        mockLightService = mock(LightServiceImpl.class);

        // Initialize the LightController with the mocked service
        lightController = new LightController(mockLightService);
    }

    @Test
    public void testSetLight_On() {
        // Act
        lightController.setLight("ON");

        // Assert
        verify(mockLightService, times(1)).setLight(LightStatus.ON);
    }


    @Test
    public void testSetLight_Off() {
        // Act
        lightController.setLight("OFF");

        // Assert
        verify(mockLightService, times(1)).setLight(LightStatus.OFF);
    }


    @Test
    public void testToggleLight() {
        // Act
        lightController.toggleLight();

        // Assert
        verify(mockLightService, times(1)).toggleLight();
    }
}