package com.cybertek.services.carpet;

import com.cybertek.enums.City;
import com.cybertek.interfaces.carpetPrices.Carpet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@Component
public class carpetTX implements Carpet {

    public static final Map<City, BigDecimal> sqPriceForCity=new HashMap<>();


    static{   // to create Dummy Data

        sqPriceForCity.put(City.AUSTIN,new BigDecimal("4.32"));
        sqPriceForCity.put(City.DALLAS,new BigDecimal("5.32"));
        sqPriceForCity.put(City.SAN_ANTONIO,new BigDecimal("6.32"));

    }
    @Override
    public BigDecimal getSqFtPrice(City city) {
        // Map to Set
        BigDecimal defaultValue=BigDecimal.ZERO;

        Optional<Map.Entry<City, BigDecimal>> collect = sqPriceForCity.entrySet().stream().filter(x -> x.getKey() == city).findFirst();
        return collect.isPresent() ? collect.get().getValue() : defaultValue;

        //isPresent looking for NullPointerException
    }
}
