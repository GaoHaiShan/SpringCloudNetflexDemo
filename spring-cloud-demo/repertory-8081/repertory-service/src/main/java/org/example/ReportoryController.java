package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportoryController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/repertory")
    String repertory(){
        System.out.println(port);
        return "库存";
    }

}
