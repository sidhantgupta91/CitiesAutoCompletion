
package com.sidhant.response;

import java.util.List;

public class CitiesResponseModel {

	private List<String> cities;

	public List<String> getCities() {
		return cities;
	}

	public void setCities(List<String> cities) {
		this.cities = cities;
	}
	
	@Override
	public String toString() {
		return this.cities.toString();
	}
}
