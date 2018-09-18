package ink.terminal.my.data;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author CircuitRCAY
 * Database loader and utilities
 */
public class DBHelper {

    private static Morphia morphia = new Morphia();
    private static Datastore datastore = null;

    private static Logger logger = LoggerFactory.getLogger(DBHelper.class);

    public DBHelper() {
        morphia.mapPackage("ink.terminal.my.objects");
        initDatastore();
    }

    private void initDatastore() {
        MongoClient client;

        logger.info("Local database detected. Connecting...");
        client = new MongoClient("localhost", 27017);
        datastore = morphia.createDatastore(client, "myterminalink");
        datastore.ensureIndexes();
        logger.info("Database connected!");
    }
}
