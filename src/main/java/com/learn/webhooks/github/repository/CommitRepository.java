package com.learn.webhooks.github.repository;

import com.learn.webhooks.github.entities.CommitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommitRepository extends JpaRepository<CommitEntity, String> {
    public List<CommitEntity> getCommitsByAuthorEmail(String authorEmail);
}
