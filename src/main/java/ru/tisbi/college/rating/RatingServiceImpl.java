package ru.tisbi.college.rating;

import org.springframework.stereotype.Service;
import ru.tisbi.college.groups.Group;
import ru.tisbi.college.groups.GroupRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    private final GroupRepository groups;

    public RatingServiceImpl(GroupRepository groups) {
        this.groups = groups;
    }

    @Override
    public List<RatingPosition> getRatingPositions() {
        var ratingPositions = new ArrayList<RatingPosition>();
        for (var group : groups.findAll()) {
            var position = getRatingPositionOf(group);
            ratingPositions.add(position);
        }
        sortPositionsByRating(ratingPositions);
        return ratingPositions;
    }

    private void sortPositionsByRating(ArrayList<RatingPosition> ratingPositions) {
        ratingPositions.sort(Comparator.comparingInt(RatingPosition::points));
    }

    private RatingPosition getRatingPositionOf(Group group) {
        var groupRating = calculateGroupRating(group);
        return new RatingPosition(groupRating, group.getTitle());
    }

    private int calculateGroupRating(Group group) {
        int rating = 0;
        for (var student : group.getStudents()) {
            for (var events : student.getEvents()) {
                rating += events.getPoints();
            }
        }
        return rating;
    }

}
