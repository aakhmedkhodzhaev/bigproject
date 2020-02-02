package com.codding.edemail.repository;

import com.codding.edemail.model.smsstatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("smsstatusRepository")
public interface smsstatusRepository extends JpaRepository<smsstatus, Long> {

    @Modifying
    @Query("update transfers t set t.status_id=:Value where t.transfer_id=:id")
    int setValue(@Param("id") Long id, @Param("value") String value);
//  smsstatus findAllByTransferId(Long transfer_id);

}