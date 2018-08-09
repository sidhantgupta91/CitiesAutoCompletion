
package com.pramati.service;

import java.util.List;

public interface ICitiesSuggestionService
{
    List<String> getCityList (String intialChar, Integer limit);
}
