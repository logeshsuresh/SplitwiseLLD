package org.logesh.repositories;

import org.logesh.models.Group;

import java.util.Optional;

public interface GroupRepository {
    Optional<Group> findById(String groupId);
    void save(Group group);
}
