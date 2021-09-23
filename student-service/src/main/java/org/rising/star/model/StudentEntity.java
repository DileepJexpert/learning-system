package org.rising.star.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
public class StudentEntity {
	
		@Id
		private String studentId;
	    private String userName;
	    private String firstName;
	    private String lastName;
	    private boolean enabled;
	    private String gender;
	    private String email;
		
	    
		public StudentEntity() {
			//super();
			// TODO Auto-generated constructor stub
		}
		public StudentEntity(String studentId, String userName, String firstName, String lastName, boolean enabled,
				String gender, String email) {
			super();
			this.studentId = studentId;
			this.userName = userName;
			this.firstName = firstName;
			this.lastName = lastName;
			this.enabled = enabled;
			this.gender = gender;
			this.email = email;
		}
		public String getStudentId() {
			return studentId;
		}
		public void setStudentId(String studentId) {
			this.studentId = studentId;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public boolean isEnabled() {
			return enabled;
		}
		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
	    
	    

}
