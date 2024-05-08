package com.example.motos;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomMot", types = { Moto.class })

public interface MotoProjection {
	public String getNomMoto();

}
