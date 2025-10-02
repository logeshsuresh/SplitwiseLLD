package org.logesh.repositories;

import org.logesh.models.Group;

import java.util.List;
import java.util.Optional;

public interface GroupRepository {
    Optional<Group> findById(String groupId);
    List<Group> findAll();
    void save(Group group);
}
