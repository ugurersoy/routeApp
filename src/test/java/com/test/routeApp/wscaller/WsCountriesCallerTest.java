package com.test.routeApp.wscaller;

import com.test.routeApp.model.CountryResponseDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class WsCountriesCallerTest {

    @Autowired
    WsCountriesCaller wsCountriesCaller;

    @Test
    public void getRoutingWithDestinationTest(){
        List<CountryResponseDto>  countryListResponseDto = wsCountriesCaller.getRoutingWithDestination();
        Assertions.assertEquals(true,countryListResponseDto.size()>0);
        Assert.notNull(countryListResponseDto,"E");
    }

}
