package ServeurRmi;



import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.*;

import java.io.FileInputStream;
import java.rmi.Naming;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class FirebaseRMIWriter1 {
    public static void main(String[] args) {
        try {
            FileInputStream serviceAccount = new FileInputStream("chemin/vers/cle-privee.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://Capteur-Entrepot.firebaseio.com")
                    .build();

            FirebaseApp.initializeApp(options);
            DatabaseReference db = FirebaseDatabase.getInstance().getReference();

            // Connecte aux entrepôts RMI
            for (int i = 1; i <= 3; i++) {
                CapteurInterface entrepot = (CapteurInterface) Naming.lookup("rmi://localhost:1098/Entrepot" + i);
                String nom = entrepot.getNomEntrepot();
                double temp = entrepot.getTemperature();
                double hum = entrepot.getHumidite();

                db.child(nom).setValueAsync(new Mesure(temp, hum));
                System.out.println("Mesure envoyée pour " + nom);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
