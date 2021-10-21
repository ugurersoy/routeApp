package com.test.routeApp.service;


import com.test.routeApp.model.RoutingResponseDto;

public interface RoutingService {

    RoutingResponseDto getRout(String origin,String destination);
}
