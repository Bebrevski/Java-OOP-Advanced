package task3_CoffeeMachine;

import task3_CoffeeMachine.enums.CoffeeSize;
import task3_CoffeeMachine.enums.CoffeeType;

public class Coffee {
    private CoffeeSize size;
    private CoffeeType type;

    public Coffee(CoffeeSize size, CoffeeType type) {
        this.size = size;
        this.type = type;
    }

    public int getPrice(){
        return this.size.getPrice();
    }

    @Override
    public String toString() {
        return String.format("%s %s"
                , this.size.toString()
                , this.type.toString());
    }
}
