package web.servies;

import web.model.Car;

import java.util.List;

public interface CarService {
    List<Car> listCars(List<Car> cars, int count);
    List<Car> getcar();
}
