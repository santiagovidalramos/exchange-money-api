package com.svidal.repository;

import com.svidal.entity.Change;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChangeRepository extends JpaRepository<Change, Long> {
    Change findBySourceAndDestiny(String source, String destiny);
}
