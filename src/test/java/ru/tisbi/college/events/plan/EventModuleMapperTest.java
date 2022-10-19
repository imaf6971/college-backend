package ru.tisbi.college.events.plan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventModuleMapperTest {

    @Test
    void toDto() {
        // Arrange
        var eventModule = new EventModule();
        eventModule.setNumber("1.1");
        eventModule.setTitle("Title");

        // Act
        var result = EventModuleMapper.toDto(eventModule);

        // Assert
        assertEquals(
                result,
                new EventModuleDto("1.1", "Title")
        );
    }

}