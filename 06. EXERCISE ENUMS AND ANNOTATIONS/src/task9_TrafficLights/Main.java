package task9_TrafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Light> lights = new ArrayList<>();
        String[] input = reader.readLine().split(" ");

        for (String s : input) {
            Light light = Enum.valueOf(Light.class, s.toUpperCase());
            lights.add(light);
        }

        TrafficLight trafficLight = new TrafficLight(lights);

        int lines = Integer.parseInt(reader.readLine());

        for (int i = 0; i < lines; i++) {
            trafficLight.changeLight();
            System.out.println(trafficLight);
        }
    }
}
