package be.odisee.oxyplast.dao;

import org.springframework.stereotype.Repository;

import be.odisee.oxyplast.domain.Sessie;


@Repository("sessieDao")
public class SessieHibernateDao extends HibernateDao implements SessieDao {


    public Sessie saveSessie(int id, String status, String titel) {
        Sessie sessie = new Sessie(id, status, titel);
        sessionSaveObject(sessie);
        return sessie;
    }

    public Sessie saveSessie(String status, String titel) {
        Sessie sessie = new Sessie(status, titel);
        sessionSaveObject(sessie);
        return sessie;
    }

    public Sessie getSessieById(int sessieId) {
        return (Sessie) sessionGetObjectById("Sessie", sessieId);
    }


}
