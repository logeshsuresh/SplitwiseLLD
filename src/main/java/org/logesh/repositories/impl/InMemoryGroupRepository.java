package org.logesh.repositories.impl;

import org.logesh.models.Group;
import org.logesh.repositories.GroupRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryGroupRepository implements GroupRepository {

    private final Map<String, Group> groupMap = new HashMap<>();

    @Override
    public Optional<Group> findById(String groupId) {
        return Optional.of(this.groupMap.get(groupId));
    }

    @Override
    public void save(Group group) {
        this.groupMap.put(group.getGroupId(), group);
    }

}
