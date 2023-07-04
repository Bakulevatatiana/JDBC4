package service;

import model.City;

import java.util.List;

public interface CityDao {


    City add(City city);

    City getById(int id);

    List<City> getAllCity();

    void deleteCity(City city);

    City updateCity(City city);
}
