package ConectaMongoDB;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class ConectaMongoDB {

    String database = "senai";
    String collection = "seupizza";

    public void getValues() {
        System.out.println("getValues");
        String uri = "mongodb://localhost";
        MongoClient mongo = MongoClients.create(uri);
        MongoDatabase db = mongo.getDatabase(database);

        MongoCollection<Document> docs = db.getCollection(collection);
        for (Document doc : docs.find()) {
            System.out.println("item: " + doc);
        }
        System.out.println("getValues ok");
    }

    public void insertValues(String nome_completo, String email, String telefone, String mensagem,
                             String contato_escolhido, String motivo_contato, boolean receber_novidades) {
        System.out.println("insertValues");
        String uri = "mongodb://localhost";
        MongoClient mongo = MongoClients.create(uri);

        MongoDatabase db = mongo.getDatabase(database);
        MongoCollection<Document> docs = db.getCollection(collection);

        Document docBuilder = new Document();
        docBuilder.append("nome_completo", nome_completo);
        docBuilder.append("email", email);
        docBuilder.append("telefone", telefone);
        docBuilder.append("mensagem", mensagem);
        docBuilder.append("contato_escolhido", contato_escolhido);
        docBuilder.append("motivo_contato", motivo_contato);
        docBuilder.append("receber_novidades", receber_novidades);
        docs.insertOne(docBuilder);//insere no mongo o conteúdo de doc
        System.out.println("insertValues ok");
    }

}
