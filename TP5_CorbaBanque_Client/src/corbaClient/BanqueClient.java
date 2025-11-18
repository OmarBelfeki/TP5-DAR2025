package corbaClient;

import corbaBanque.IBanqueRemote;
import corbaBanque.IBanqueRemoteHelper;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;

import javax.naming.*;
import javax.naming.Context;

public class BanqueClient {

    public static void main(String[] args) {
        try {
            // a
            ORB orb = ORB.init(args, null);
            System.out.println("ORB initialisé côté client.");

            // b
            Context jndiContext = new InitialContext();
            System.out.println("Contexte JNDI récupéré.");

            // c
            org.omg.CORBA.Object objRef = (org.omg.CORBA.Object) jndiContext.lookup("Banque");
            System.out.println("Référence distante récupérée.");

            // d
            IBanqueRemote banque = IBanqueRemoteHelper.narrow(objRef);
            System.out.println("Stub CORBA créé.");

            // e
            System.out.println("=== Test du service bancaire ===");

            // Exemple
            double solde = banque.consulterSolde("123456");
            System.out.println("Solde du compte 123456 : " + solde);

            banque.ajouterArgent("123456", 500);
            System.out.println("Ajout de 500 au compte 123456.");

            banque.retirerArgent("123456", 200);
            System.out.println("Retrait de 200 du compte 123456.");

            solde = banque.consulterSolde("123456");
            System.out.println("Solde final du compte 123456 : " + solde);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
