package com.wellsfargo.copymongo.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertManyResult;
import com.mongodb.client.result.InsertOneResult;
import org.bson.BsonDocument;
import org.bson.BsonValue;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeeCollection {
  private final static String COLLECTION_NAME = "employee";
  private final MongoCollection<Document> collection;

  public EmployeeCollection(String dbName) {
    MongoConnection mongoConnection = new MongoConnection(dbName);
    this.collection = mongoConnection.getMongoDatabase().getCollection(COLLECTION_NAME);
  }

  public BsonValue save(Map<String, Object> employee) {
    Document doc = new Document();
    for (Map.Entry<String, Object> field : employee.entrySet()) {
      doc.append(field.getKey(), field.getValue());
    }
    InsertOneResult result = this.collection.insertOne(doc);
    return result.getInsertedId();
  }

  public Map<Integer, BsonValue> save(List<Map<String, Object>> employees) {
    List<Document> docs = new ArrayList<>();
    employees.forEach(objMap -> {
      Document doc = new Document();
      objMap.entrySet().forEach(field -> {
        doc.append(field.getKey(), field.getValue());
      });
      docs.add(doc);
    });
    InsertManyResult result = this.collection.insertMany(docs);
    return result.getInsertedIds();
  }

  public long deleteAll() {
    BsonDocument query = new BsonDocument();
    DeleteResult result = this.collection.deleteMany(query);
    return result.getDeletedCount();
  }
}
