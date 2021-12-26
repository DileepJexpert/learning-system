package org.rising.star.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Data
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor
@Document(collation = "feeDetails")
public class FeeDetails {
    @Id
    String id;
    String schoolName;

     List<FeeType> feeTypes;

      List<Grade> grades;

}
