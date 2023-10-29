package web.servies;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarServiceImpl implements CarService {
    private  static int CAR_COUNT;
    public List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car(++CAR_COUNT,"Lada", 10));
        cars.add(new Car(++CAR_COUNT,"Volvo", 15));
        cars.add(new Car(++CAR_COUNT,"Polo", 20));
        cars.add(new Car(++CAR_COUNT,"BMV", 25));
        cars.add(new Car(++CAR_COUNT,"Nissan", 30));
    }

    @Override
    public List<Car> listCars(List<Car> cars, int count) {
        if (count < 0) {
            throw new IllegalArgumentException("Недопустимое значение параметра count");
        } if (count >= 5) {
            return cars;
        } else {
            return cars.subList(0, count);
        }
    }
    @Override
    public List<Car> getcar() {
        return cars;
    }
}
