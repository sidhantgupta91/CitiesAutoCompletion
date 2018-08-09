
package com.sidhant.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.sidhant.constants.Constant;

@Service
public class CityListCache {
	
    private Map<Character,List<String>> cityMap = new HashMap<>();

    public List<String> getCityForCharacter (char initChar) {
        List<String> cities = cityMap.get(initChar);
        if (cities != null) {
            List<String> cityList = new ArrayList<>(cities);
            return cityList;
        }
        return null;
    }

    @PostConstruct
    public void initCityCache () {
        String cityCSV = Constant.CITY_NAMES;
        String [] cities = cityCSV.split(",");
        for (String city : cities ) {
            city = city.toUpperCase();
            if (!cityMap.containsKey(city.charAt(0))) {
                cityMap.put(city.charAt(0), new ArrayList<>());
            }
            cityMap.get(city.charAt(0)).add(city);
        }
    }
}
