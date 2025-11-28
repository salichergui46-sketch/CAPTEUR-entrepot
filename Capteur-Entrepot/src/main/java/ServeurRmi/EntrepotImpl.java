package ServeurRmi;



import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

public class EntrepotImpl extends UnicastRemoteObject implements CapteurInterface {
    private String nom;
    private Random rand = new Random();

    protected EntrepotImpl(String nom) throws RemoteException {
        super();
        this.nom = nom;
    }

    public String getNomEntrepot() throws RemoteException {
        return nom;
    }

    public double getTemperature() throws RemoteException {
        return 15 + rand.nextDouble() * 10; // 15°C à 25°C
    }

    public double getHumidite() throws RemoteException {
        return 30 + rand.nextDouble() * 50; // 30% à 80%
    }
}
