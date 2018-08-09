
package com.sidhant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sidhant.response.CitiesResponseModel;
import com.sidhant.service.ICitiesSuggestionService;

@Controller
public class CitiesAutoCompletionController {

    @Autowired
    private ICitiesSuggestionService citiesSuggestionService;

    @RequestMapping (value = "/suggest_cities" , method = RequestMethod.GET, produces=MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String suggestCities (@RequestParam(name = "start") String start, @RequestParam(name = "atmost") Integer atmost) {
        if (StringUtils.isEmpty(start) || atmost == 0) {
        	
            return "";
        }
        List<String> cityList= citiesSuggestionService.getCityList(start.toUpperCase(), atmost);
        CitiesResponseModel response = new CitiesResponseModel();
        response.setCities(cityList);
        return response.toString();
    }
}
