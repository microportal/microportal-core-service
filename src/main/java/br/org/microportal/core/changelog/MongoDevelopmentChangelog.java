package br.org.microportal.core.changelog;

import br.org.microportal.core.model.ApplicationDocument;
import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;

@Slf4j
@ChangeLog(order = "001")
public class MongoDevelopmentChangelog {

    @ChangeSet(author = "devuser", id = "dev-change-001", order = "001")
    public void developmentData001(MongoTemplate mongoTemplate) {
        ApplicationDocument commonsApp = new ApplicationDocument();
        commonsApp.setName("core-ui");
        commonsApp.setPath("");
        commonsApp.setIndexUrl("/core-ui/index.js");
        commonsApp.setStoreUrl("/core-ui/store.js");
        commonsApp.setService(false);

        mongoTemplate.insert(commonsApp);
    }
}
