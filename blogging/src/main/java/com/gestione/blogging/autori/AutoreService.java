package com.gestione.blogging.autori;

import com.gestione.blogging.response.GeneralResponse;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;


import java.util.List;

@Service
@RequiredArgsConstructor
public class AutoreService {
	private final AutoreRepository autoreRepository;

	//GET /authors => ritorna la lista di autori
	public List<Autore> findAll () {
		return autoreRepository.findAll();
	}

	//GET /blogPosts /123 => ritorna un singolo blog post
	public Autore findById (Long id) {
		return autoreRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Autore not found with id " + id));
	}

	//POST /blogPosts => crea un nuovo blog post
	public GeneralResponse save (AutoreRequest request) {
		Autore autore = new Autore();
		BeanUtils.copyProperties(request, autore);
		autoreRepository.save(autore);
		GeneralResponse resp = new GeneralResponse();
		BeanUtils.copyProperties(autore, resp);
		return resp;
	}

	//PUT /blogPosts /123 => modifica lo specifico blog post
	public Autore update (Long id, AutoreRequest request) {
		Autore entity = findById(id);
		BeanUtils.copyProperties(request, entity);
		autoreRepository.save(entity);
		return entity;
	}

	//DELETE /blogPosts /123 => cancella lo specifico blog post
	public void delete (Long id) {
		Autore autore = findById(id);
		autoreRepository.deleteById(id);
	}
}
