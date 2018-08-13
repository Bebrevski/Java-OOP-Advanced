package pr01HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line;
        try {
            while (!"HARVEST".equals(line = reader.readLine())) {
                String finalLine = line;
                Arrays.stream(RichSoilLand.class.getDeclaredFields())
                        .filter(f -> finalLine.equals("private") ?
                                     Modifier.isPrivate(f.getModifiers()) :
                                     finalLine.equals("protected") ?
                                     Modifier.isProtected(f.getModifiers()) : !finalLine.equals("public") || Modifier.isPublic(f.getModifiers()))
                        .forEach(f -> System.out.println(String.format("%s %s %s"
                                , Modifier.toString(f.getModifiers())
                                , f.getType().getSimpleName()
                                , f.getName())));
            }
        } catch (IOException ex) {
            System.out.println(Arrays.toString(ex.getStackTrace()));
        }
    }
}
