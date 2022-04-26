package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/payment/v2/order")
public class TestController {

    @PostMapping(path = "/{packageSeq}")
    public void makeDirectOrderInfo(@PathVariable int packageSeq, @RequestParam(required = false) Integer presentProductSeq) {
        log.info("packageSeq={} ", packageSeq);
        log.info("presentProductSeq={}", presentProductSeq);
    }

    @DeleteMapping(path = "/delete")
    public void delete(@RequestBody List<Integer> packageSeq) {
        log.info(packageSeq.toString());
    }

}
