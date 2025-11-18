package corbaServer;

import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import service.BanqueImpl;

import javax.naming.*;
import javax.naming.Context;

public class BanqueServer {

    public static void main(String[] args) {
        try {
            // a
            ORB orb = ORB.init(args, null);
            System.out.println("ORB initialisé.");

            // b
            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPOA.the_POAManager().activate();
            System.out.println("POA activé.");

            // c
            Context jndiContext = new InitialContext();
            System.out.println("Contexte JNDI créé.");

            // d
            BanqueImpl banqueServant = new BanqueImpl();

            // e
            org.omg.CORBA.Object ref = rootPOA.servant_to_reference(banqueServant);

            jndiContext.rebind("Banque", ref);
            System.out.println("Servant enregistré dans JNDI.");

            // f
            System.out.println("Serveur prêt et en attente des requêtes...");
            orb.run();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
