package com.test.routeApp.wscaller;

import com.test.routeApp.model.CountryResponseDto;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class WsCountriesCaller {

    final String uri = "https://raw.githubusercontent.com/mledoze/countries/master/countries.json";

    public List<CountryResponseDto> getRoutingWithDestination(){

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(messageConverters);
        CountryResponseDto[] result = restTemplate.getForObject(uri, CountryResponseDto[].class);

        System.out.println(result);

       return Arrays.asList(result);
     }


}
