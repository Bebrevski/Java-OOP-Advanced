package task9_TrafficLights;

import java.util.List;
import java.util.stream.Collectors;

public class TrafficLight {

    private List<Light> lights;

    public TrafficLight(List<Light> lights) {
        this.lights = lights;
    }

    public void changeLight() {
        for (int i = 0; i < this.lights.size(); i++) {
            switch (this.lights.get(i)) {
                case YELLOW:
                    this.lights.set(i, Light.RED);
                    break;
                case GREEN:
                    this.lights.set(i, Light.YELLOW);
                    break;
                case RED:
                    this.lights.set(i, Light.GREEN);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public String toString() {
        return this.lights.stream().map(Light::toString).collect(Collectors.joining(" "));
    }
}
