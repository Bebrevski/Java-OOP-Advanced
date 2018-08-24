package p01_system_resources;

import java.time.LocalTime;

public class GreetingClock {

    private LocalTime time;

    public GreetingClock() {
        this.time = LocalTime.now();
    }

    public void greeting() {
        if (time.getHour() < 12) {
            System.out.println("Good morning...");
        } else if (time.getHour() < 18) {
            System.out.println("Good afternoon...");
        } else {
            System.out.println("Good evening...");
        }
    }
}
