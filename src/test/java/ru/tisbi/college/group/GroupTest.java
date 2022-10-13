package ru.tisbi.college.group;

import org.junit.jupiter.api.Test;
import ru.tisbi.college.groups.Group;
import ru.tisbi.college.groups.Specialization;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupTest {

    @Test
    public void groupCode() {
        // Arrange
        var underTest = new Group(
                new Specialization("ПМ"),
                Year.of(2019),
                false,
                2
        );

        // Act
        var result = underTest.getTitle();

        // Assert
        assertEquals("ПМ-191.2", result);
    }

}
