package com.example.motos.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.motos.Moto;
import com.example.motos.Type;
import com.example.motos.service.MotoService;

import jakarta.validation.Valid;

@Controller
public class MotoController {
	
    @Autowired
    MotoService motoService;

    @RequestMapping("/listeMotos") 
    public String listeMotos(ModelMap modelMap, 
    @RequestParam(name = "page", defaultValue = "0") String pageParam, 
    @RequestParam(name = "size", defaultValue = "3") String sizeParam) { 
        int page = Integer.parseInt(pageParam);
        int size = Integer.parseInt(sizeParam);
        Page<Moto> prods = motoService.getAllMotosParPage(page, size); 
        modelMap.addAttribute("motos", prods); 
        modelMap.addAttribute("pages", new int[prods.getTotalPages()]);  
        modelMap.addAttribute("currentPage", page);    
        return "listeMotos";  
    } 

	@RequestMapping("/showCreate")
	
	public String showCreate(ModelMap modelMap) {
	    modelMap.addAttribute("moto", new Moto());

	    List<Type> types = motoService.getAllTypes();
	    modelMap.addAttribute("mode", "new");
	    modelMap.addAttribute("types", types); // Ajout de l'attribut "types"
	    return "formMoto";
	}

	@RequestMapping("/saveMoto")
	public String saveMoto(@Valid Moto moto, BindingResult bindingResult,
	                        @RequestParam(name = "page", defaultValue = "0") int page,
	                        @RequestParam(name = "size", defaultValue = "2") int size) {
	    int currentPage;
	    boolean isNew = false;
	    if (bindingResult.hasErrors()) return "formMoto";
	    if (moto.getIdMotot() == null) //ajout
	        isNew = true;
	    motoService.saveMoto(moto);
	    if (isNew) //ajout
	    {
	        Page<Moto> motos = motoService.getAllMotosParPage(page, size);
	        currentPage = motos.getTotalPages() - 1;
	    } else //modif
	        currentPage = page;
	    return "redirect:/listeMotos?page=" + currentPage + "&size=" + size;
	}





    @RequestMapping("/supprimerMoto")
    public String supprimerMoto(@RequestParam("id") Long id, 
    ModelMap modelMap, 
    @RequestParam (name="page",defaultValue = "0") int page, 
    @RequestParam (name="size", defaultValue = "2") int size) 
    { 
    motoService.deleteMotoById(id); 
    Page<Moto> prods = motoService.getAllMotosParPage(page, size); 
	modelMap.addAttribute("motos", prods); 
	modelMap.addAttribute("pages", new int[prods.getTotalPages()]);  
	modelMap.addAttribute("currentPage", page);  
	modelMap.addAttribute("size", size);  
	return "listeMotos";  


    		} 


	@RequestMapping("/modifierMoto")
	public String editerMoto(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size) {
		Moto p = motoService.getMoto(id);
		List<Type> cats =motoService.getAllTypes();
		modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("moto", p);
		modelMap.addAttribute("types", cats);
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("size", size);
		
		return "formMoto";
	}
	  

    @RequestMapping("/updateMoto")
    public String updateMoto(@ModelAttribute("moto") Moto moto,
                             @RequestParam("date") String date,
                             ModelMap modelMap) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCreation = dateFormat.parse(String.valueOf(date));
        moto.setDateCreation(dateCreation);
        motoService.updateMoto(moto);
        List<Moto> motos = motoService.getAllMotos();
        modelMap.addAttribute("motos", motos);
        return "listeMotos";
    }
    @GetMapping(value = "/") 
    public String welcome() { 
    return "index"; 
    } 
}
