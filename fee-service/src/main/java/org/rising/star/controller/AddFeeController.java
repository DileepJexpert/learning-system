package org.rising.star.controller;

import java.util.ArrayList;
import java.util.List;
import org.rising.star.client.StudentServiceClient;
import org.rising.star.model.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.retry.annotation.Retry;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/fee")
public class AddFeeController {

	@Autowired
	private StudentServiceClient studentServiceClient;
	
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AddFeeController.class);
	@GetMapping("/fetch")
	@Retry(name="studentSearch")
	  public ResponseEntity<ResponseEntity<List<StudentEntity>>> getAllStudents() {
		log.info("StudentController ----------------------- Caliculation begins");
		 Mono<String> data = Mono.just("the only is return");
	    try {
	     System.out.println("dff  ----ffff------------------1 1111111111");
	     return ResponseEntity.ok(studentServiceClient.getAllProducts());
	    
	    } catch (Exception e) {
	    	  System.out.println("dff  ----ffff"+data);
	    }
		return ResponseEntity.ok(studentServiceClient.getAllProducts());
	  }
	@GetMapping("/fetchthrow")
	@Retry(name = "throwingException")
	public ResponseEntity<String> searchFlightsThrowingException() throws Exception {
		List list = new ArrayList();
						list.add(1);
						list.add(2);
						list.add(3);
		if(list.get(2).equals(3)) {
			return new ResponseEntity<>(
			          "Year of birth cannot be in the future", 
			          HttpStatus.OK);
		}
		return null;
		
		
	  
	}
}
