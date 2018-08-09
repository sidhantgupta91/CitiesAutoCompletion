
package com.sidhant.serviceImpl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sidhant.cache.CityListCache;
import com.sidhant.service.ICitiesSuggestionService;

@Service
public class CitiesSuggestionService implements ICitiesSuggestionService {
	
    @Autowired
    private CityListCache cityCache;

    @Override 
    public List<String> getCityList(String intialChar, Integer limit) {
    	
        List<String> elligibleCities = cityCache.getCityForCharacter(intialChar.charAt(0));
        if (elligibleCities != null ) {
            List<String> qualifiedList = fetchMatchingCityList (intialChar , elligibleCities);
            return qualifiedList.size() > limit ? qualifiedList.subList(0,limit) : qualifiedList;
        }
        return null;

    }

    private List<String> fetchMatchingCityList(String initialChar, List<String> elligibleCities) {
        if(initialChar.length() > 1) {
            char[] charArr = initialChar.toCharArray();
            for(int i=1;i<charArr.length;i++) {
                Iterator<String> cityItr = elligibleCities.iterator();
                while(cityItr.hasNext()) {
                    String city = cityItr.next();
                    if(city.charAt(i) != charArr[i]){
                        cityItr.remove();
                    }
                }
            }
        }

        return elligibleCities;
    }


}
