package be.odisee.oxyplast.service;

import java.util.Collection;

import be.odisee.oxyplast.domain.Persoon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service("userContextService")
public class UserContextServiceImpl implements UserContextService {

    @Autowired
    protected ProjectToevoegenService PJS=null; // ready for dependency injection

    @Override
    public Persoon getAuthenticatedPersoon() {
    
    	UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    String username = principal.getUsername();
	    System.out.println("DEBUG: Username uit Principal is "+username);
	
	    Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
	    for (GrantedAuthority authority : authorities){
	    	System.out.println("DEBUG: Granted authority is "+authority.getAuthority());
	    }
	    Persoon thePersoon = PJS.zoekPersoonMetEmailadres(username);
	    return thePersoon;
    }
}
