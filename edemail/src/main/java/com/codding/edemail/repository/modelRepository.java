package com.codding.edemail.repository;

import com.codding.edemail.model.model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("modelRepository")
public interface modelRepository extends JpaRepository<model, Long> {
      //  model findByRecipientId(String reipientId);
}