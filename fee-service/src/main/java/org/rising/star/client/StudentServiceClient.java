package org.rising.star.client;

import java.util.List;

import org.rising.star.model.StudentEntity;
//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


//@FeignClient(name = "student-service")
public interface StudentServiceClient {
	
	
	@RequestMapping(value = "/api/students", method = RequestMethod.GET)
	 public ResponseEntity<List<StudentEntity>> getAllProducts();

	 @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
	 public StudentEntity getProduct(@PathVariable("id") int productId);

}
