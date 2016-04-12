package be.odisee.oxyplast.service;

import java.util.ArrayList;
import java.util.List;

import be.odisee.oxyplast.dao.SessieDao;
import be.odisee.oxyplast.domain.Sessie;
import be.odisee.oxyplast.dao.RolDao;
import be.odisee.oxyplast.domain.Rol;
import be.odisee.oxyplast.dao.PersoonDao;
import be.odisee.oxyplast.domain.Persoon;
import be.odisee.oxyplast.dao.ProjectDao;
import be.odisee.oxyplast.domain.*;
import utilities.RolNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

@Service("ProjectToevoegenService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly=true)
public class ProjectBeheerImplementatieService implements ProjectToevoegenService {
	public Klant klant;
	public Aanvraag aanvraag;
	public Project project;
	public Accountverantwoordelijke accountverantwoordelijke;
	public Onderzoeker onderzoeker;
	public Opbrengst opbrengst;
	public Prototype prototype;
	public Werknemer werknemer;
	
	private ProjectDao projectDao;
	private SessieDao sessieDao;
    private RolDao rolDao;
    private PersoonDao persoonDao;
	
	public ArrayList<Klant> klanten = new ArrayList<Klant>();
	public ArrayList<Project> projecten = new ArrayList<Project>();
	public ProjectBeheerImplementatieService(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param Aanvraag
	 */
	public Aanvraag AanvraagIndienen(String Aanvraag){
			//aanvraag = new Aanvraag(Aanvraag, 1);	
			return aanvraag;
	}

	/**
	 * 
	 * @param Formule
	 */
	public void BepaalFormule(String Formule){

	}

	/**
	 * 
	 * @param feedback
	 */
	public void FeedbackToevoegen(String feedback){

	}

	/**
	 * 
	 * @param Achternaam
	 * @param Bedrijfsnaam
	 * @param Email
	 * @param Voornaam
	 */

	/**
	 * 
	 * @param Formule
	 * @param ProjectID
	 */
	public void PrototypeToevoegen(String Formule, int ProjectID){

	}

	/**
	 * 
	 * @param Kosten
	 * @param Opbrengsten
	 */
	public void RendementBerekenen(double Kosten, double Opbrengsten){

	}

	/**
	 * 
	 * @param Team
	 * @param Status
	 * @param Naam
	 */
	@Transactional(propagation= Propagation.REQUIRED,readOnly=false)
	public Project StartProject(int id, int teamId, String status, String naam){
		return this.projectDao.saveProject(id, teamId, status, naam);
	}

	

	public Boolean getAanvraagAanvaard() {
		// TODO Auto-generated method stub
		// We gaan wat vals spelen
		//aanvraag.setAanvaard();
		//return aanvraag.getAanvaard();
		return null;
	}

	public int getAantalProjecten() {
		// TODO Auto-generated method stub
		return projecten.size();
	}
	@Transactional(propagation= Propagation.REQUIRED,readOnly=false)
	public Project zoekProject(int id) {
		// TODO Auto-generated method stub
		System.out.println("DEBUG PJS (zoek): "+projectDao.getProjectById(id));
		return projectDao.getProjectById(id);
		
	}
	@Autowired
    public void setProjectDao(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }
	@Override
	public List<Project> geefAlleProjectenTerug() {
		// TODO Auto-generated method stub
		return projectDao.getAllProjects();
	}

    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
	public void verwijderProject(Project p) {
		System.out.println("DEBUG PJS: "+p.getNaam());
		this.projectDao.deleteProject(p);	
	}

    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
	public void aanpassenProject(Project p) {
		this.projectDao.updateProject(p);
		
	}

    @Autowired
    public void setSessieDao(SessieDao sessieDao) {
        this.sessieDao = sessieDao;
    }
    public Sessie voegSessieToe(int id, String titel) {
        return sessieDao.saveSessie(id, "actief", titel);
    }
    public Sessie voegSessieToe(String titel) {
        return sessieDao.saveSessie("actief", titel);
    }

    public Sessie zoekSessieMetId(int id){
        return sessieDao.getSessieById(id);
    }
    public Persoon voegPersoonToe(int id, String voornaam, String familienaam, String emailadres, String paswoord) {
        return persoonDao.savePersoon(id,"actief",voornaam,familienaam,emailadres,paswoord);
    }

    public Persoon voegPersoonToe(String voornaam, String familienaam, String emailadres, String paswoord) {
        return persoonDao.savePersoon("aktief",voornaam,familienaam,emailadres,paswoord);
    }

    public Persoon zoekPersoonMetId(int id){
        return persoonDao.getPersoonById(id);
    }

    public Persoon zoekPersoonMetEmailadres(String emailadres){
        return persoonDao.getPersoonByEmailadres(emailadres);
    }

    @Override
    public List<Persoon> geefAllePersonen() {
        return persoonDao.getAllPersons();
    }

    @Override
    public Rol voegRolToe(String type, int sessieId, int persoonId, String usernaam) throws RolNotFoundException {
        Sessie deSessie = zoekSessieMetId(sessieId);
        Persoon dePersoon = zoekPersoonMetId(persoonId);
        Rol deRol = dePersoon.voegRolToe(type, "actief", usernaam, deSessie);
        deRol = rolDao.saveRol(deRol);
        return deRol;
    }

    public Rol zoekRolMetId(int id) {
        return rolDao.getRolById(id);
    }

    public Rol zoekRolMetUserid(String userid) {
        return rolDao.getRolByUserid(userid);
    }

	@Override
	public Prototype voegPrototypeToe(int prototypeId, int sessieId, int OnderzoekerId, String formule) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Prototype voegPrototypeToe(int sessieId, int OnderzoekerId, String formule) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Prototype zoekPrototypeMetId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Aanvraag voegAanvraagToe(int id, int AanvraagId, int klantId, String type, String aanvraag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Aanvraag voegAanvraagToe(int AanvraagId, int klantId, String type, String aanvraag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Aanvraag zoekAanvraagMetId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean verwijderAanvraag(Aanvraag aanvraag) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void toonSessieResultaten(Sessie sessie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getAantalKlanten() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Klant zoekKlant(String Naam) {
		// TODO Auto-generated method stub
		return null;
	}
	

	}
	




