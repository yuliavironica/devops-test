package com.balabali.devops.test.repository.custom;

import com.balabali.devops.test.model.entity.PersonEntity;

/**
 * The PersonRepository interface is a Spring Data repository that extends two other interfaces:
 * MongoRepository and PersonEntityCustomRepository. This setup allows the PersonRepository to inherit
 * the capabilities of both interfaces.
 *
 * @author Bayu Dwiyan Satria
 * @version 0.0.1
 * @since 0.0.1
 */
public interface PersonEntityCustomRepository {

    PersonEntity findOne(String id);
}
