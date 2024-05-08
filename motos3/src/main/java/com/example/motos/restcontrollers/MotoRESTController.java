package com.example.motos.restcontrollers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.motos.Moto;
import com.example.motos.service.MotoService;
@RestController
@RequestMapping("/api")
@CrossOrigin
public class MotoRESTController {
	@Autowired
	MotoService motoService;
	@RequestMapping(method = RequestMethod.GET)
	public List<Moto> getAllMotos() {
	return motoService.getAllMotos();
	
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Moto getMotoById(@PathVariable("id") Long id) {
	return motoService.getMoto(id);
	 }
	@RequestMapping(method = RequestMethod.POST)
	public Moto createMoto(@RequestBody Moto moto) {
	return motoService.saveMoto(moto);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public Moto updateMoto(@RequestBody Moto moto) {
	return motoService.updateMoto	(moto);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteMoto(@PathVariable("id") Long id)
	{
		motoService.deleteMotoById(id);
	}

	
	@RequestMapping(value="/prodscat/{idtype}",method = RequestMethod.GET)
	public List<Moto> getMotosByCatId(@PathVariable("idtype") Long idtype) {
	return motoService.findByTypeIdType(idtype);
	}

	

}
