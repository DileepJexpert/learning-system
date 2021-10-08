package org.rising.star.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.rising.star.model.CreateStudentRestModel;
import org.rising.star.model.StudentEntity;
import org.rising.star.model.StudentInfoDTO;
import org.rising.star.repository.StudentRepository;
import org.rising.star.repository.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
@Slf4j
public class StudentController {
	
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	@GetMapping("/students")
	  public ResponseEntity<List<StudentEntity>> getAllTutorials(@RequestParam(required = false) String title) {
		log.info("StudentController ----------------------- Caliculation begins");
	    try {
	      List<CreateStudentRestModel> students = new ArrayList<CreateStudentRestModel>();
	      List<StudentEntity> studentsList = new ArrayList<StudentEntity>();

	      CreateStudentRestModel createStudentRestModel = new CreateStudentRestModel();
	      ModelMapper mapper = new ModelMapper();
	    	StudentEntity studentInfo = mapper.map(createStudentRestModel, StudentEntity.class);
			  if (title == null) 
				   studentRepository.findAll().forEach(studentsList::add);
			  else 
			//  studentRepository.findByTitleContaining(title).forEach(students::add);
			 
	      if (students.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(studentsList, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	@GetMapping("/students/fetch")
	  public Mono<String> getAllStudents(ServerHttpRequest request , ServerHttpResponse response) {
		 Mono<String> data = Mono.just("the only is return");
	    try {
	     System.out.println("dff  ----ffff"+request);
	     HttpHeaders headers = request.getHeaders();
	     
	     headers.forEach((k,v) ->{
	     System.out.println(k +"-------"+v);
	     }
	   
	     
	     );
	    
	    } catch (Exception e) {
	    	  System.out.println("dff  ----ffff"+data);
	    }
		return data;
	  }


	@PostMapping("/students")
	  public ResponseEntity<StudentInfoDTO> createTutorial(@RequestBody CreateStudentRestModel createStudentRest) {
		
	    try {
	    	ModelMapper mapper = new ModelMapper();
	    	StudentInfoDTO studentInfoDto = mapper.map(createStudentRest, StudentInfoDTO.class);
	    	 studentInfoDto =	studentService.save(studentInfoDto);
	 //     StudentEntity _tutorial = studentService.save(new S(tutorial.getTitle(), tutorial.getDescription(), false));
	      return new ResponseEntity<>(studentInfoDto, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	@PutMapping("/students/{id}")
	  public ResponseEntity<StudentEntity> updateTutorial(@PathVariable("id") String id, @RequestBody StudentEntity tutorial) {
	    Optional<StudentEntity> studentEntityData = studentRepository.findById(id);

	    if (studentEntityData.isPresent()) {
	      StudentEntity _tutorial = studentEntityData.get();
	      return new ResponseEntity<>(studentRepository.save(_tutorial), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }

	  @DeleteMapping("/students/{id}")
	  public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") String id) {
	    try {
	    	studentRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	  @DeleteMapping("/students")
	  public ResponseEntity<HttpStatus> deleteAllTutorials() {
	    try {
	    	studentRepository.deleteAll();
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	  @GetMapping("/students/published")
	  public ResponseEntity<List<StudentEntity>> findByPublished() {
	    try {
	      List<StudentEntity> students = studentRepository.findAll();

	      if (students.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(students, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }




}
