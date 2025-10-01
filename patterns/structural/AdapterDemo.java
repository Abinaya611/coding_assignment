//package structural;

// Existing class with incompatible interface
class FahrenheitThermometer {
    public double readF() { return 98.24; } // Fahrenheit
}

// Target interface
interface CelsiusSensor {
    double readC();
}

// Adapter
class FahrenheitToCelsiusAdapter implements CelsiusSensor {
    private final FahrenheitThermometer fTherm;
    public FahrenheitToCelsiusAdapter(FahrenheitThermometer fTherm) { this.fTherm = fTherm; }
    @Override public double readC() {
        return (fTherm.readF() - 32) * 5.0 / 9.0;
    }
}

public class AdapterDemo {
    public static void main(String[] args) {
        FahrenheitThermometer f = new FahrenheitThermometer();
        CelsiusSensor adapter = new FahrenheitToCelsiusAdapter(f);
        System.out.printf("Temperature in Celsius: %.2f°C%n", adapter.readC());
    }
}
