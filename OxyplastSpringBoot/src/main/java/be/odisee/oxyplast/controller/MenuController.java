package be.odisee.oxyplast.controller;

import be.odisee.oxyplast.domain.Persoon;
import be.odisee.oxyplast.domain.Rol;

import be.odisee.oxyplast.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MenuController {

    @Autowired
    protected ProjectBeheerImplementatieService PJS=null; // ready for dependency injection
    
    @Autowired
    protected UserContextService userContextService=null;

    @RequestMapping(value={"/login","/login.html"},method=RequestMethod.GET)
    public String login(ModelMap model){
    	return "/login";
    }
    // je zal naar login.jsp gaan

    
    @RequestMapping(value={"/logout","/logoutSuccess.html"},method=RequestMethod.GET)
    public String logout(ModelMap model){
    	return "/logoutSuccess";
    }
    // je zal naar logoutSuccess.jsp gaan

    @RequestMapping(value={"/accessDenied","/accessDenied.html"},method=RequestMethod.GET)
    public String accessDenied(ModelMap model){
    	return "/accessDenied";
    }
    // je zal naar accessDenied.jsp gaan

    @RequestMapping(value={"/menu.html"},method=RequestMethod.GET)
    public String menu(ModelMap model){
        Persoon dePersoon=null;
        dePersoon = userContextService.getAuthenticatedPersoon();
        model.addAttribute("persoon",dePersoon);
        return "/menu";
    }
    // je zal naar menu.jsp gaan

    @RequestMapping(value={"/rol.html"},method=RequestMethod.GET)
    @PostAuthorize("#model.get('rol').persoon.emailadres == authentication.principal.username")
    public String indexVoorRol(@RequestParam("id") Integer id, ModelMap model){
        Rol deRol = PJS.zoekRolMetId(id);
        model.addAttribute("rol",deRol);
        if (deRol.getType().equals("Administrator")) return "redirect:/admin/index.html?rolid="+deRol.getRolid();
        if (deRol.getType().equals("Organisator")) return "redirect:/organisator/index.html?rolid="+deRol.getRolid();
        return "redirect:/brainstorm/index.html?rolid="+deRol.getRolid(); // voor de andere rollen
    }
    // je zal gaan naar de pagina conform uw rol
    
}
