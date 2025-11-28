package ServeurRmi;


public class Mesure {
    public double temperature;
    public double humidite;

    public Mesure() {} // Firebase en a besoin

    public Mesure(double temperature, double humidite) {
        this.temperature = temperature;
        this.humidite = humidite;
    }
}
