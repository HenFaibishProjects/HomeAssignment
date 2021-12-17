//package infra.dbConnection;
//
//import com.mongodb.ConnectionString;
//import com.mongodb.MongoClientSettings;
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//import com.mongodb.client.MongoDatabase;
//
//
//
//public class MdbSpringBootApplication  {
//
//    ConnectionString connectionString = new ConnectionString("mongodb+srv://hen:zoomaccount1!@cluster0.ftmvn.mongodb.net/Users?retryWrites=true&w=majority");
//    MongoClientSettings settings = MongoClientSettings.builder()
//            .applyConnectionString(connectionString)
//            .build();
//    MongoClient mongoClient = MongoClients.create(settings);
//    MongoDatabase database = mongoClient.getDatabase("userHa");
//
//}
