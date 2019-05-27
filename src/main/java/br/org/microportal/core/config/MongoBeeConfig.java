package br.org.microportal.core.config;

import com.github.mongobee.Mongobee;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Slf4j
@Configuration
@Profile("!test")
public class MongoBeeConfig extends AbstractMongoConfiguration {

    @Value("${spring.data.mongodb.uri}")
    private String uri;

    @Value("${spring.data.mongodb.database}")
    private String databaseName;

    @Override
    public MongoClient mongoClient() {
        return new MongoClient(new MongoClientURI(uri));
    }

    @Override
    protected String getDatabaseName() {
        return databaseName;
    }

    @Bean
    public Mongobee mongobee(Environment environment) throws Exception {
        log.debug("Creatingo Mongobee bean");

        Mongobee runner = new Mongobee(uri);
        runner.setDbName(getDatabaseName());
        runner.setMongoTemplate(mongoTemplate());
        runner.setSpringEnvironment(environment);
        runner.setChangeLogsScanPackage("br.org.microportal.core.changelog");
        return runner;
    }
}
