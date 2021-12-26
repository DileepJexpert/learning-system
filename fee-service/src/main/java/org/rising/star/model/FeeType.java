package org.rising.star.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
@Data
@NoArgsConstructor

@AllArgsConstructor
@Document(collation = "feeTypes")
public class FeeType {

    @Id
    String id;
    String schoolName;
    String feeType;
    String feeName;
    String description;
    String paymentMode;
    String debitAccount;
    String creditAccount;

}
