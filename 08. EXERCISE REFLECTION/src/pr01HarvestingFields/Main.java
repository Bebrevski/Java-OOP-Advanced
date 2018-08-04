package pr01HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while (!"HARVEST".equals(input = reader.readLine())) {
            String finalInput = input;
            Arrays.stream(RichSoilLand.class.getDeclaredFields())
                    .filter(f -> Modifier.toString(f.getModifiers()).equals(generateRequiredModifier(finalInput, f)))
                    .forEach(f -> System.out.println(String.format("%s %s %s"
                            , Modifier.toString(f.getModifiers())
                            , f.getType().getSimpleName()
                            , f.getName())));
        }
    }

    private static String generateRequiredModifier(String finalInput, Field f) {
        return finalInput.equals("all") ? Modifier.toString(f.getModifiers()) : finalInput;
    }
}
