package be.odisee.oxyplast.dao;
import be.odisee.oxyplast.domain.Onderzoeker;
import java.util.List;
public interface OnderzoekerDao {



	    public Onderzoeker saveOnderzoeker(int id,  String naam, String voornaam, int teamid);
	    public Onderzoeker getOnderzoekerById(int id);
	    public List<Onderzoeker> getAllOnderzoekers(int id);
	    public void updateOnderzoeker(Onderzoeker o);    
	    public void deleteOnderzoeker(Onderzoeker o);

	    
	    

	

}
