package com.test.routeApp.controller;

import com.test.routeApp.model.RoutingResponseDto;
import com.test.routeApp.service.RoutingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/routing")
@AllArgsConstructor
public class RoutingController {

   private final RoutingService routingService;

   @GetMapping("/{origin}/{destination}")
    public RoutingResponseDto getRoutingWithTwoDestination(@PathVariable("origin")String origin
           ,@PathVariable("destination") String destination){
        RoutingResponseDto responseDto = routingService.getRout(origin,destination);
        return  responseDto;
    }
}
