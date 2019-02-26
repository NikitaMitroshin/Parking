import carInfo.KPP;
import carInfo.Colour;
import carInfo.Model;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private int weight;
    private boolean hasPricep;
    private Colour colour;
    private KPP kppType;
    private Model model;

    public Car(int weight, boolean hasPricep, Colour colour, KPP kppType, Model model) {
        this.weight = weight;
        this.hasPricep = hasPricep;
        this.colour = colour;
        this.kppType = kppType;
        this.model = model;
    }

    public int getWeight() {
        return weight;
    }

    public boolean isHasPricep() {
        return hasPricep;
    }

    public Colour getColour() {
        return colour;
    }

    public KPP getKppType() {
        return kppType;
    }

    public Model getModel() {
        return model;
    }

    // Автомобили одинаковые если они одной марки (VW, Audi, Kia и тд) И одного цвета.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return colour == car.colour &&
                model == car.model;
    }

    @Override
    public int hashCode() {
        return Objects.hash(colour, model);
    }

    // Должна быть возможность отсортировать автомобили по алфавиту по имени марки.
    @Override
    public int compareTo(Car o) {
        return this.getModel().toString().compareTo(o.getModel().toString());
    }
}
