package ru.tisbi.college.groups;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/groups")
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping
    public void addGroup(@RequestBody AddGroupDto addGroupDto) {
        groupService.addGroup(addGroupDto);
    }

    @GetMapping
    public Collection<GroupDto> getGroups() {
        return groupService.getGroups();
    }

}
