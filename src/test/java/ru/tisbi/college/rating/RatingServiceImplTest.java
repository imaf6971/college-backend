package ru.tisbi.college.rating;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.tisbi.college.groups.Group;
import ru.tisbi.college.groups.GroupRepository;
import ru.tisbi.college.groups.Specialization;

import java.time.Year;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RatingServiceImplTest {

    @Mock
    GroupRepository repository;

    RatingService underTest;

    @BeforeAll
    void setUp() {
        underTest = new RatingServiceImpl(repository);
        when(repository.findAll())
                .thenReturn(List.of(
                        new Group(
                                new Specialization("IS"),
                                Year.now(),
                                false,
                                1
                        )));
    }

    @Test
    void getRatingPositions() {

    }
}