package org.example;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "REPERTORY")
public interface Repertory {

    @GetMapping("/repertory")
    String repertory();
}
