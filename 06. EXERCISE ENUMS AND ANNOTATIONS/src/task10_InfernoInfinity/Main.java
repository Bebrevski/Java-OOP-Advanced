package task10_InfernoInfinity;

import task10_InfernoInfinity.constants.Constants;
import task10_InfernoInfinity.weapons.Axe;
import task10_InfernoInfinity.weapons.Knife;
import task10_InfernoInfinity.weapons.Sword;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Weapon> weapons = new HashMap<>();

        try {
            String input;
            while (!"END".equals(input = reader.readLine())) {
                String[] tokens = input.split(";");
                String command = tokens[0];

                Weapon currentWeapon;
                switch (command) {
                    case Constants.CREATE:
                        weapons.put(tokens[2], createWeapon(tokens[1], tokens[2]));
                        break;
                    case Constants.ADD:
                        currentWeapon = weapons.get(tokens[1]);
                        currentWeapon.insertGem(Integer.parseInt(tokens[2]), tokens[3]);
                        break;
                    case Constants.REMOVE:
                        currentWeapon = weapons.get(tokens[1]);
                        currentWeapon.removeGem(Integer.parseInt(tokens[2]));
                        break;
                    case Constants.PRINT:
                        currentWeapon = weapons.get(tokens[1]);
                        System.out.println(currentWeapon);
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static Weapon createWeapon(String type, String name) {
        switch (type) {
            case Constants.AXE:
                return new Axe(name, type);
            case Constants.SWORD:
                return new Sword(name, type);
            case Constants.KNIFE:
                return new Knife(name, type);
            default:
                return null;
        }
    }
}
