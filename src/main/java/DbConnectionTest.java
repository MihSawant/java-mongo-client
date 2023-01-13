import com.mongodb.MongoException;
import com.mongodb.client.MongoClients;
import org.bson.BsonDocument;
import org.bson.BsonInt64;

public class DbConnectionTest {

    private static String URL = System.getenv("URL");


    public static void main(String[] args) {
        try(var mongoClient = MongoClients.create(URL)){
            var db = mongoClient.getDatabase("unigo");

            try{
                // trying to ping
                var command = new BsonDocument("ping", new BsonInt64(1));
                var res = db.runCommand(command);
            }catch (MongoException e){
                System.out.println(e.getMessage());
            }

        }
    }
}
