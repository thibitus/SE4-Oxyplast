package be.odisee.oxyplast.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Date;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * @author Lesuisse
 * @version 1.0
 * @created 31-Dec-2015 11:35:30
 */
@Entity
@Table(name="project")
public class Project implements Serializable{

	private static final long serialVersionUID = 1L;
	@JsonProperty("id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="teamid")
	private int teamId;
	
	//private String Rentabiliteit;
	
	@Column
	//@Index(name="IProject_status",columnNames="Status")
	private String status;
	@JsonProperty("title")
	@Column
	//@Index(name="IProject_naam",columnNames="Naam")
	
	private String naam;
	@JsonProperty("start")
	@Column(name="startdatum")
	private Date startdate;


	@JsonProperty("end")
	@Column(name="einddatum")
	private Date enddate;
	
    public Date getStartdate() {
		return startdate;
	}




	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}




	public Date getEnddate() {
		return enddate;
	}




	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}




	@OneToMany(fetch=FetchType.EAGER, mappedBy="project")
    private Set<Prototype> m_Prototype= new HashSet<Prototype>();
    
    @OneToMany(fetch=FetchType.EAGER, mappedBy="project")
    private Set<Bestelling> m_bestelling= new HashSet<Bestelling>();
	
	//public Prototype m_Prototype;
	//public Team m_Team;
   // @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
   // private List<Prototype> prototypes = new ArrayList<>();

	public Project(){

	}
	
	public Project(String naam){
		this.naam = naam;
		this.status = "gestart";
	}




	/**
	 * 
	 * @param TeamID
	 * @param Status
	 */
	public Project(int id, int teamId, String status, String naam, Date startdate, Date enddate){
		this.teamId = teamId;
		this.status = status;
		this.naam = naam;
		this.id = id;
		this.startdate = startdate;
		this.enddate = enddate;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public int getTeamId() {
		return teamId;
	}




	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public String getNaam() {
		return naam;
	}




	public void setNaam(String naam) {
		this.naam = naam;
	}
	




	

	/**
	 * 
	 * @param Prototype
	 * @return 
	 */
	/*public void PrototypeToevoegen(Prototype Prototype){

	}
*/
	/**
	 * 
	 * @param Kost
	 * @param Opbrengst
	 */
	/*public int RendementBerekenen(Kost Kost, Opbrengst Opbrengst){
		
		
		return 0;
	}
	*/

	/**
	 * 
	 * @param TeamID
	 * @return 
	 */
	/*public void TeamToevoegen(int TeamID){

	}
	*/
	

	/**
	 * 
	 * @param TeamID
	 */
	/*public TeamVerwijderen(int TeamID){

	}
	*/

}