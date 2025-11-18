package service;

import corbaBanque.Compte;
import corbaBanque.IBanqueRemotePOA;

public class BanqueImpl extends IBanqueRemotePOA {

    @Override
    public void creerCompte(Compte cpte) {

    }

    @Override
    public void verser(int code, float mt) {

    }

    @Override
    public void retirer(int code, float mt) {

    }

    @Override
    public Compte getCompte(int code) {
        return null;
    }

    @Override
    public Compte[] getComptes() {
        return new Compte[0];
    }

    @Override
    public double conversion(float mt) {
        return 0;
    }
}
