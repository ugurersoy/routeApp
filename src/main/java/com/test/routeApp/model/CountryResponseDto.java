package com.test.routeApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryResponseDto {
    String cca3;
    List<String> borders;
}
