package com.balabali.devops.test.repository;

import com.balabali.devops.test.model.entity.PersonEntity;
import com.balabali.devops.test.repository.custom.PersonEntityCustomRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * The PersonRepository interface is a Spring Data repository that extends two other interfaces:
 * MongoRepository and PersonEntityCustomRepository. This setup allows the PersonRepository to inherit
 * the capabilities of both interfaces.
 *
 * @author Bayu Dwiyan Satria
 * @version 0.0.1
 * @since 0.0.1
 */
@Repository
public interface PersonRepository
    extends MongoRepository<PersonEntity, String>, PersonEntityCustomRepository {

}
