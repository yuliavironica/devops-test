package com.balabali.devops.test.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

/**
 * MongoDB Config
 *
 * @author Bayu Dwiyan Satria
 * @version 0.0.1
 * @since 0.0.1
 */
@Configuration()
public class MongoDBConfig extends AbstractMongoClientConfiguration {

    /**
     * MongoDB Host
     */
    @Value("${spring.data.mongodb.host}")
    private String host;

    /**
     * MongoDB Port
     */
    @Value("${spring.data.mongodb.port}")
    private String port;

    /**
     * MongoDB Username
     */
    @Value("${spring.data.mongodb.username}")
    private String username;

    /**
     * MongoDB Password
     */
    @Value("${spring.data.mongodb.password}")
    private String password;

    /**
     * MongoDB Database
     */
    @Value("${spring.data.mongodb.database}")
    private String database;

    /**
     * MongoDB Authentication Databases
     */
    @Value("${spring.data.mongodb.authentication-database}")
    private String authDatabase;

    /**
     * The mongoClientSetting method in the MongoDBConfig class is responsible for configuring the
     * settings for the MongoDB client. This method returns an instance of MongoClientSettings,
     * which is a configuration object used to customize the behavior of the MongoDB client.
     *
     * @return Mongo Client Settings
     * @see MongoClientSettings
     */
    @NotNull
    private MongoClientSettings mongoClientSetting() {
        return MongoClientSettings.builder()
            .applyConnectionString(this.buildConnectionString())
            .build();
    }

    /**
     * The mongoClient method in the MongoDBConfig class is a Spring @Bean method that creates and
     * configures a MongoClient instance.
     *
     * @return MongoClient
     * @see MongoClient
     */
    @Bean
    @NotNull
    public MongoClient mongoClient() {
        return MongoClients.create(this.mongoClientSetting());
    }

    /**
     * The mongoTemplate method in the MongoDBConfig class is a Spring @Bean method that creates and
     * configures a MongoTemplate instance.
     *
     * @return indicating that it returns an object that should be registered as a bean in the
     * Spring application context.
     * @see MongoTemplate
     * @see SimpleMongoClientDatabaseFactory
     * @since 0.0.1
     */
    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(
            new SimpleMongoClientDatabaseFactory(this.mongoClient(), database));
    }

    /**
     * The getDatabaseName method in the MongoDBConfig class is an overridden method from the
     * AbstractMongoClientConfiguration class.
     *
     * @return MongoDB database that the application will connect to.
     * @since 0.0.1
     */
    @Override
    @NotNull
    protected String getDatabaseName() {
        return database;
    }

    /**
     * The buildConnectionString method in the MongoDBConfig class is responsible for constructing a
     * ConnectionString object that encapsulates the MongoDB connection details. This method is
     * annotated with @NotNull, indicating that it should not return a null value.
     *
     * @return MongoDB ConnectionString.
     * @see ConnectionString
     * @since 0.0.1
     */
    @NotNull
    private ConnectionString buildConnectionString() {
        return new ConnectionString(
            String.format(
                "mongodb://%s:%s@%s:%s/%s?authSource=%s&ssl=false&retrywrites=false",
                username, password, host, port, database, authDatabase
            )
        );
    }
}
