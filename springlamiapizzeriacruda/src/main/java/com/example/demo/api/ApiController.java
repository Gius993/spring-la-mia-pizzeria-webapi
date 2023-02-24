package com.example.demo.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Pizza;
import com.example.demo.repo.Pizzarepo;

@RestController
@CrossOrigin
@RequestMapping("/api/pizze")
public class ApiController {
	@Autowired
	 Pizzarepo pizzarepo;
	
	

	@GetMapping()		
	public List<Pizza> index() {
		return pizzarepo.findAll();
	}
	
	@GetMapping("{id}")		
	public ResponseEntity<Pizza> detail(@PathVariable("id") Integer id) {
		Optional<Pizza> res=pizzarepo.findById(id);
		if (res.isPresent()) 
			return new ResponseEntity<Pizza>(res.get(), HttpStatus.OK);
	    else
	    	return new ResponseEntity<Pizza>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/create")
	public Pizza create(@RequestBody Pizza pizza) {
		return pizzarepo.save(pizza);
	}	
	@PutMapping("{id}")	
	public Pizza update(@RequestBody Pizza pizza,
			@PathVariable("id") Integer id) {
		Pizza p=pizzarepo.getReferenceById(id);
		p.setId(id);
		//....
		return pizzarepo.save(p);
	}
	
	@DeleteMapping("{id}")	
	public void delete(
			@PathVariable("id") Integer id) {
		pizzarepo.deleteById(id);
	}
		
}
