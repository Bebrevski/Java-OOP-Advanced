package task3_CoffeeMachine;

import task3_CoffeeMachine.enums.CoffeeSize;
import task3_CoffeeMachine.enums.CoffeeType;
import task3_CoffeeMachine.enums.Coin;
import task5_CodingTracker.Author;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoffeeMachine {
    private List<Coffee> machine;
    private int money;

    public CoffeeMachine() {
        this.machine = new ArrayList<>();
    }

    @Author(name = "Stefan")
    public void buyCoffee(String size, String type) {
        Coffee coffee = new Coffee(
                Enum.valueOf(CoffeeSize.class, size.toUpperCase()),
                Enum.valueOf(CoffeeType.class, type.toUpperCase()));

        if (coffee.getPrice() <= this.money) {
            this.machine.add(coffee);
            this.money = 0;
        }
    }

    @Author(name = "Pesho")
    public void insertCoin(String coin) {
        this.money += Enum.valueOf(Coin.class, coin.toUpperCase()).getValue();
    }

    @Author(name = "Gosho")
    public Iterable<Coffee> coffeesSold() {
        return Collections.unmodifiableList(this.machine);
    }
}
