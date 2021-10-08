package org.rising.star.repository;



import org.modelmapper.ModelMapper;
import org.rising.star.model.StudentEntity;
import org.rising.star.model.StudentInfoDTO;
import org.rising.star.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public StudentInfoDTO save(StudentInfoDTO studentInfoDTO) {
		// TODO Auto-generated method stub
		ModelMapper mapper = new ModelMapper();
		StudentEntity studentEntity =	mapper.map(studentInfoDTO, StudentEntity.class);
		
		studentEntity = this.studentRepository.save(studentEntity);
		return studentInfoDTO;
	}

}
