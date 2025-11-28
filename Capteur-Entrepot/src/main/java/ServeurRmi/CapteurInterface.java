package ServeurRmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CapteurInterface extends Remote {
    String getNomEntrepot() throws RemoteException;
    double getTemperature() throws RemoteException;
    double getHumidite() throws RemoteException;
}
