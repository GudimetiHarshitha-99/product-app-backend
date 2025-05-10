package com.codinghub.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codinghub.model.PracticeModel;
import com.codinghub.repository.PracticeRepository;

@Service
public class PracticeService {
	
//	public List<PracticeModel> Productlist=new ArrayList<>(Arrays.asList(
//			new PracticeModel(1,"Laptop",30000),
//			new PracticeModel(2,"Mobile",20000),
//			new PracticeModel(3,"Television",50000)
//			));
	
	@Autowired
	private PracticeRepository practicerepo;
	
	public List<PracticeModel> getData()
	{
		return practicerepo.findAll();
	}
	
	public PracticeModel getDataById(Integer id)
	{
		
		return practicerepo.findById(id).orElse(null);
	}

	public PracticeModel sendData(PracticeModel practicemodel) 
	{
		return practicerepo.save(practicemodel);
		
	}

//	public PracticeModel updateData(Integer id,PracticeModel practicemodel) {
////		for(PracticeModel p:Productlist)
////		{
////			if(p.getId()==id)
////			{
////				p.setPrice(practicemodel.getPrice());
////				return p;
////			}
////		}
////		return null;
//		
//		PracticeModel existing = practicerepo.findById(practicemodel.getId()).orElse(null);
//        existing.setName(practicemodel.getName());
//        existing.setPrice(practicemodel.getPrice());
//        return practicerepo.save(existing);
//		
//		
//		
//	}
	
	
	public PracticeModel updateData(Integer id, PracticeModel practicemodel) {
	    PracticeModel existing = practicerepo.findById(id).orElse(null);
	    if (existing != null) {
	        existing.setName(practicemodel.getName());
	        existing.setPrice(practicemodel.getPrice());
	        return practicerepo.save(existing);
	    } else {
	        return null; 
	    }
	}

	
	public String deleteData(Integer id)
	{
		practicerepo.deleteById(id);
		return "Deleted the data successfully";
	}
}
