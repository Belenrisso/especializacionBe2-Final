package com.msbills.controller;

import com.msbills.models.Bill;
import com.msbills.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bills")
@RequiredArgsConstructor
public class BillController {


    private final BillService service;

    @GetMapping("/all")
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public ResponseEntity<List<Bill>> getAll() {
        return ResponseEntity.ok().body(service.getAllBill());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bill> findBillById(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(service.getBillByID(id));
    }


    @PostMapping("/save")
    @PreAuthorize("hasAnyAuthority('GROUP_PROVIDERS')")
    public ResponseEntity<Bill> createBill(@RequestBody Bill bill) {
        return ResponseEntity.ok().body(service.saveBill(bill));
    }
}
