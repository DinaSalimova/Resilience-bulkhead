package com.resiliencepattern.bulkhead.controller;

import com.resiliencepattern.bulkhead.ExternalAPICaller;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ResilientAppController {
    private final ExternalAPICaller externalAPICaller;

    @Autowired
    public ResilientAppController(ExternalAPICaller externalAPICaller) {
        this.externalAPICaller = externalAPICaller;
    }

    @GetMapping("/bulkhead")
    @Bulkhead(name="bulkheadApi")
    public String bulkheadApi() {
        return externalAPICaller.callApi();
    }
}
