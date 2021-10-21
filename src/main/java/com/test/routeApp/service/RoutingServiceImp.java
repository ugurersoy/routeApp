package com.test.routeApp.service;

import com.test.routeApp.exception.RouteNotFountException;
import com.test.routeApp.model.CountryResponseDto;
import com.test.routeApp.model.RoutingResponseDto;
import com.test.routeApp.wscaller.WsCountriesCaller;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RoutingServiceImp implements RoutingService{

    private final WsCountriesCaller wsCountriesCaller;

    private final String errorMessage = "Route not fount";


    @Override
    public RoutingResponseDto getRout(String origin, String destination) {

        List<CountryResponseDto> countryList = wsCountriesCaller.getRoutingWithDestination();

        CountryResponseDto originItem = countryList.stream().filter(it->it.getCca3().equals(origin)).collect(Collectors.toList()).get(0);

        if(originItem.getBorders().size()>0) {
            CountryResponseDto destinationItem = countryList.stream().filter(it -> it.getCca3().equals(destination)).collect(Collectors.toList()).get(0);

            if (destinationItem.getBorders().size()>0){

                List<List<String>> it = new ArrayList<>();
                for(String item : originItem.getBorders()) {
                    List <String> lst =  routeFinder(destination,origin,countryList,item, new ArrayList<>(),new ArrayList<>());

                   if(lst!=null) {
                       it.add(lst);
                   }
                }

                 System.out.println(it);

                   if(it.size()>0){
                       RoutingResponseDto responseDto = new RoutingResponseDto();
                       List<String> responseRoute = new ArrayList<>();
                       responseRoute.add(origin);

                       Optional<List<String>> newItem = it.stream().min(Comparator.comparingInt(List::size));
                       responseRoute.addAll(newItem.get());
                       responseRoute.add(destination);
                       responseDto.setRoute(responseRoute);
                       return responseDto;

                   }else {
                       throw new RouteNotFountException(errorMessage);
                   }

            }else {
                throw new RouteNotFountException(errorMessage);
            }

        }else {
            throw new RouteNotFountException(errorMessage);
        }
    }



    private List<String> routeFinder(String destination,String origin, List<CountryResponseDto> countryList,String borderCountry,List<String> list,List<String> orderList){

        CountryResponseDto countryBorder = countryList.stream().filter(it->it.getCca3().equals(borderCountry)).collect(Collectors.toList()).get(0);

        list.add(countryBorder.getCca3());
        orderList.add(origin);
        if(countryBorder.getBorders().contains(destination))
        {
            return list;
        }else {
            for(String item : countryBorder.getBorders()) {
                if(orderList.contains(item)||list.contains(item)){
                    continue;
                }


               return routeFinder(destination, countryBorder.getCca3(),countryList,item,list,orderList);
            }
        }

        return null;
    }


}
