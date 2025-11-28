package ServeurRmi;


import java.awt.Desktop;
import java.net.URI;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServeurRMI {
    public static void main(String[] args) {
        try {
            // Crée la registry sur le port 1099
            LocateRegistry.createRegistry(1097);

            // Lier les entrepôts
            Naming.rebind("rmi://localhost:1097/Entrepot1", new EntrepotImpl("Entrepôt Nord"));
            Naming.rebind("rmi://localhost:1097/Entrepot2", new EntrepotImpl("Entrepôt Sud"));
            Naming.rebind("rmi://localhost:1097/Entrepot3", new EntrepotImpl("Entrepôt Est"));

            System.out.println("✅ Serveur RMI prêt !");
       
  Thread.sleep(1000);
            
            ouvrirUserHTML();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void ouvrirUserHTML() {
        try {
              
            String filePath = "file:///C:/Users/MOUMEN/eclipse-workspace/Servers/Capteur-Entrepot/src/main/webapp/User.html";
            
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                desktop.browse(new URI(filePath));
                System.out.println("📱 Ouverture de User.html...");
            } else {
                System.out.println("❌ Desktop non supporté sur ce système");
            }
        } catch (Exception e) {
            System.out.println("⚠️ Impossible d'ouvrir User.html automatiquement");
            System.out.println("Ouvrez manuellement : http://localhost:8080/Capteur-Entrepot/User.html");
            e.printStackTrace();
        }
    }
}

        
       

