package com.codinghub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.codinghub.model.PracticeModel;
import com.codinghub.service.PracticeService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class PracticeController {
	
	@Autowired
	private PracticeService practiceservice;
	
	@GetMapping("/")
	public List<PracticeModel> getData()
	{
		return practiceservice.getData();
	}
	
	@GetMapping("/{id}")
	public PracticeModel getDataById(@PathVariable Integer id)
	{
		return practiceservice.getDataById(id);
	}
	
	
	@PostMapping("/send")
	public String sendData(@RequestBody PracticeModel practicemodel) 
	{
		practiceservice.sendData(practicemodel);
		return "Data send successfully";
	}
	
	@PutMapping("/{id}")
	public String updateData(@PathVariable Integer id,@RequestBody PracticeModel practicemodel)
	{
		practiceservice.updateData(id, practicemodel);
		return "Updated data successfully";
	}
	
	
	@DeleteMapping("/{id}")
	public String deleteData(@PathVariable Integer id)
	{
		practiceservice.deleteData(id);
		return "Product removed successfully";
	}
	
	

}
