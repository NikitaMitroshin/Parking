import carInfo.Colour;
import carInfo.Model;

import java.util.ArrayList;
import java.util.List;

public class Parking {

    private int numberOfSpots;

    private List<Car> cars = new ArrayList<>();

    public Parking(int numberOfSpots) {
        this.numberOfSpots = numberOfSpots;
    }

    public int getNumberOfSpots() {
        return numberOfSpots;
    }

    public void setNumberOfSpots(int numberOfSpots) {
        this.numberOfSpots = numberOfSpots;
    }

//    Должна быть возможность поставить автомобиль на парковку
    public boolean addCar(Car car) {
        if (cars.size() < numberOfSpots && isCarValidToPark(car)) {
            return cars.add(car);
        }
        return false;
     }

    public boolean isCarValidToPark(Car car) {
        if (car.isHasPricep() || car.getWeight() > 3000) {
            return false;
        }
        return true;
    }

    //    Должна быть возможность выве3ти автомобиль с парковки
    public boolean removeCarFromParking(Car car) {
        boolean wasRemoved = cars.remove(car);
        if (wasRemoved) {
            numberOfSpots--;
            return true;
        }
        return false;
    }

//    Должна быть возможность найти одинаковые автомобили на парковке.
    public List<Car> findEqualCars(Model model, Colour colour) {
        List<Car> result = new ArrayList<>();
        if (model == null || colour == null) {
            return result;
        }
        for (Car car : cars) {
            if (model == car.getModel() &&  colour == car.getColour()) {
                result.add(car);
            }
        }
        return result;
    }

//    Должна быть возможность посчитать количество белых автомобилей на парковке
    public List<Car> findCarsOfColour(Colour colour) {
        List<Car> result = new ArrayList<>();
        if (colour == null) {
            return result;
        }
        for (Car car : cars) {
            if (colour == car.getColour()) {
                result.add(car);
            }
        }
        return result;
    }

    public void increaseSpots(int n) {
        numberOfSpots += n;
    }

    public void decreaseSpots(int n) {
        numberOfSpots -= n;
    }
}
