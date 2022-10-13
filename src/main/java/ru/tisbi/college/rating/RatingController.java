package ru.tisbi.college.rating;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rating")
public class RatingController {

    private final RatingService rating;

    public RatingController(RatingService rating) {
        this.rating = rating;
    }

    @GetMapping
    public List<RatingPosition> getRating() {
        return rating.getRatingPositions();
    }

}