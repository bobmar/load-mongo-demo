package com.wellsfargo.copymongo.dao;

import com.mongodb.client.*;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MongoConnection {
  private String uri = "mongodb://192.168.50.41:27017/";

  private final MongoDatabase mongoDatabase;
  public MongoConnection(String dbName) {
    MongoClient mongoClient = MongoClients.create(uri);
    this.mongoDatabase = mongoClient.getDatabase(dbName);
  }

  protected MongoDatabase getMongoDatabase() {
    return this.mongoDatabase;
  }
}
