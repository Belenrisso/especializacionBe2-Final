package com.msbills.repositories;

import com.msbills.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BillRepository extends JpaRepository<Bill, String> {

   // Optional<Bill> findById(String id);
   List<Bill> findAllBycustomerBill(String userId);


}
