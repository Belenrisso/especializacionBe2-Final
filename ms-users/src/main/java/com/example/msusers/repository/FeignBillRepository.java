package com.example.msusers.repository;

import com.example.msusers.configuration.feign.OAuthFeignConfig;
import com.example.msusers.domain.Bill;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name= "ms-bills",url = "http://localhost:8086", configuration = OAuthFeignConfig.class)
public interface FeignBillRepository {


    @RequestMapping(method = RequestMethod.GET,value = "/bills/{id}")
    ResponseEntity<List<Bill>> findById(@PathVariable("id") String id);


}
