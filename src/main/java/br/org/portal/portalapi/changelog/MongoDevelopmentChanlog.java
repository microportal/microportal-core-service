package br.org.portal.portalapi.changelog;

import br.org.portal.portalapi.model.ApplicationDocument;
import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;

@Slf4j
@ChangeLog(order = "001")
public class MongoDevelopmentChanlog {

    @ChangeSet(author = "devuser", id = "dev-change-001", order = "001")
    public void developmentData001(MongoTemplate mongoTemplate) {
        ApplicationDocument commonsApp = new ApplicationDocument();
        commonsApp.setName("portal-commons");
        commonsApp.setPath("");
        commonsApp.setIndexUrl("/portal-commons/index.js");
        commonsApp.setStoreUrl("/portal-commons/store.js");
        commonsApp.setService(false);

        mongoTemplate.insert(commonsApp);
    }
}
