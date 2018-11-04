package br.org.portal.portalapi.config;

import com.github.mongobee.Mongobee;
import com.mongodb.MongoClient;
import cz.jirutka.spring.embedmongo.EmbeddedMongoFactoryBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.IOException;

@Slf4j
@Configuration
public class EmbeddedMongoConfig {

    private static final String MONGO_DB_HOST = "localhost";

    private static final String MONGO_DB_NAME = "embeded_db";

    @Bean
    public MongoClient mongoClient() throws IOException {
        EmbeddedMongoFactoryBean mongo = new EmbeddedMongoFactoryBean();
        mongo.setBindIp(MONGO_DB_HOST);
        return mongo.getObject();
    }

    @Bean
    public MongoTemplate mongoTemplate() throws IOException {
        return new MongoTemplate(mongoClient(), MONGO_DB_NAME);
    }

    @Bean
    public Mongobee mongobee(Environment environment) throws Exception {
        log.debug("Creatingo Mongobee bean for testing.");

        Mongobee runner = new Mongobee(mongoClient());
        runner.setDbName(MONGO_DB_NAME);
        runner.setMongoTemplate(mongoTemplate());
        runner.setSpringEnvironment(environment);
        runner.setChangeLogsScanPackage("br.org.portal.portalapi.changelog");
        return runner;
    }
}
