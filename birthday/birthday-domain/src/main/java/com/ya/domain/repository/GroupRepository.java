package com.ya.domain.repository;

import com.ya.domain.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Max on 07.05.2015.
 */
public interface GroupRepository extends JpaRepository<Group, String> {
}
