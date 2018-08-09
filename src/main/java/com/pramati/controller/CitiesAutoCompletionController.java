
package com.pramati.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pramati.response.CitiesResponseModel;
import com.pramati.service.ICitiesSuggestionService;

@Controller
public class CitiesAutoCompletionController
{

    @Autowired
    private ICitiesSuggestionService citiesSuggestionService;


    @RequestMapping (value = "/suggest_cities" , method = RequestMethod.GET)
    @ResponseBody
    public CitiesResponseModel suggestCities (@RequestParam(name = "start") String start,
            @RequestParam (name = "atmost") Integer atmost) {
        if (StringUtils.isEmpty(start) || atmost == 0) {
            return new CitiesResponseModel();
        }
        List<String> cityList= citiesSuggestionService.getCityList(start.toUpperCase(), atmost);
        return new CitiesResponseModel(cityList);
    }
}
