package com.test.routeApp.service;


import com.test.routeApp.model.RoutingResponseDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class RoutingServiceTest {

    @Autowired
    RoutingServiceImp routingService;


    @Test
    public void getRoutTest(){

        RoutingResponseDto responseDto =  routingService.getRout("CZE","ITA");

        System.out.println(responseDto.getRoute());

        Assertions.assertNotNull(responseDto);
        Assertions.assertEquals(true,responseDto.getRoute().size()>0);

    }

    @Test
    public void getRoutTestTwo(){

        RoutingResponseDto responseDto =  routingService.getRout("CZE","TUR");

        System.out.println(responseDto.getRoute());

        Assertions.assertNotNull(responseDto);
        Assertions.assertEquals(true,responseDto.getRoute().size()>0);

    }

}
