package com.elsoft.kafkaone.consumer.repo;

import com.elsoft.kafkaone.consumer.entities.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikimediaDataRepository extends JpaRepository<WikimediaData, Long> {
}