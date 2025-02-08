package com.balabali.devops.test.model.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(
    collection = PersonEntity.DOCUMENT_NAME
)
public class PersonEntity {

    public static final String DOCUMENT_NAME = "persons";

    @Id
    @Field("_id")
    private ObjectId id;

    @Field("firstName")
    private String firstName;

    @Field("middleName")
    private String middleName;

    @Field("lastname")
    private String lastName;

    @Field("modifiedAt")
    private String modifiedAt;

    @Field("createdAt")
    private String createdAt;

    public PersonEntity(
        String firstName,
        String middleName,
        String lastName
    ) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.modifiedAt = new SimpleDateFormat("yyyy-MM-dd")
            .format(
                Calendar.getInstance().getTime()
            );
        this.createdAt = new SimpleDateFormat("yyyy-MM-dd")
            .format(
                Calendar.getInstance().getTime()
            );
    }
}
