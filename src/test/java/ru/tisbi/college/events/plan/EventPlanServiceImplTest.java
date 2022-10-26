package ru.tisbi.college.events.plan;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static java.time.Month.DECEMBER;
import static java.time.Month.JULY;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EventPlanServiceImplTest {

    @Mock
    private static EventPlanRepository planRepository;

    @Mock
    private static EventModuleRepository moduleRepository;

    private static EventPlanService underTest;

    @BeforeEach
    void setUp() {
        underTest = new EventPlanServiceImpl(planRepository, moduleRepository);
    }

    @Test
    @DisplayName("Saves some EventPlan to repository")
    void savesSomeEventPlanToRepository() {
        // Arrange
        var createEventPlanDto = new CreateEventPlanDto(
                1L,
                "test",
                DECEMBER
        );
        when(moduleRepository.findById(1L))
                .thenReturn(Optional.of(new EventModule()));

        // Act
        underTest.planEvent(createEventPlanDto);

        // Assert
        verify(planRepository, times(1))
                .save(any());
    }

    @Test
    @DisplayName("Saves right EventPlan to repository")
    void savesRightEntity() {
        // Arrange
        var createEventPlanDto = new CreateEventPlanDto(
                1L,
                "test",
                DECEMBER
        );
        when(moduleRepository.findById(1L))
                .thenReturn(Optional.of(new EventModule()));

        // Act
        underTest.planEvent(createEventPlanDto);

        // Assert
        verify(planRepository, times(1))
                .save(argThat(eventPlan ->
                        eventPlan.getTitle().equals("test") &&
                                eventPlan.getMonth().equals(DECEMBER)
                ));
    }

    @Test
    @DisplayName("EventPlan by month")
    void a() {
        // Arrange


        // Act
        var result = underTest.getEventPlanByMonth(DECEMBER);
    }

    private List<EventModule> setUpModules() {
        var a = new EventPlan("abc", DECEMBER);
        a.setId(1L);

        var b = new EventPlan("def", JULY);
        b.setId(2L);


        // TODO
        return null;
    }


}