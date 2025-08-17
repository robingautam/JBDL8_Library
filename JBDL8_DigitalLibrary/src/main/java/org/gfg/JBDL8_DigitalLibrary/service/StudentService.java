package org.gfg.JBDL8_DigitalLibrary.service;

import org.gfg.JBDL8_DigitalLibrary.model.Address;
import org.gfg.JBDL8_DigitalLibrary.model.Student;
import org.gfg.JBDL8_DigitalLibrary.model.StudentStatus;
import org.gfg.JBDL8_DigitalLibrary.repository.StudentRepository;
import org.gfg.JBDL8_DigitalLibrary.request.StudentCreationRequest;
import org.gfg.JBDL8_DigitalLibrary.response.StudentCreationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;


    public StudentCreationResponse createStudent(StudentCreationRequest studentCreationRequest){
        String name = studentCreationRequest.getName();
        String email = studentCreationRequest.getEmail();
        String mobileNo = studentCreationRequest.getMobileNo();
        String dob = studentCreationRequest.getDob();
        Address address = studentCreationRequest.getAddress();


        Student student = Student.builder().name(name).email(email).mobileNo(mobileNo).dob(dob).address(address).build();
        student.setStudentStatus(StudentStatus.ACTIVE);
        int rowsUpdated = 0;
        try {
            rowsUpdated = studentRepository.createStudentInDatabase(student);
        }
        catch (Exception ex){
            System.out.println("Exception: "+ex);
            rowsUpdated = 0;
        }

        StudentCreationResponse studentCreationResponse = new StudentCreationResponse();
        studentCreationResponse.setName(name);
        studentCreationResponse.setEmail(email);

        if (rowsUpdated==0){
             studentCreationResponse = new StudentCreationResponse();
            studentCreationResponse.setStatus("FAILED");
            studentCreationResponse.setMessage("Data Not Insrted");
            return studentCreationResponse;
        }
        studentCreationResponse.setStatus("SUCCESS");
        studentCreationResponse.setMessage("Data Inserted successfully");
        return studentCreationResponse;
    }
}
