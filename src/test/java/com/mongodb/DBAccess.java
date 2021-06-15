package com.mongodb;

import java.util.HashMap;

import com.mongodb.client.MongoDatabase;

public class DBAccess {

  private static MongoClient mongoClient;
  private static DBAccess dbAccess;
  private static HashMap<String, MongoDatabase> dbs = new HashMap<String, MongoDatabase>();

  private DBAccess() {


    try {
     // String uri = System.getProperty("MONGO_URI");
      String uri = "mongodb+srv://nimbly-admin:6HC640DohEFcP9vB@nimbly-cluster-back.pzwft.gcp.mongodb.net/nimbly";
      if (uri == null) {
        throw new Exception("missing mongo uri");
      }
      MongoClientOptions opt = MongoClientOptions.builder()
          .connectionsPerHost(20)
          .build();

      mongoClient = new MongoClient(uri, opt);
      System.out.println("connected to mongo");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static MongoClient getConnection() {
    if (dbAccess == null) {
      dbAccess = new DBAccess();
    }

    return mongoClient;
  }

  public static MongoDatabase getDatabase(String dbName) {
    if (dbAccess == null) {
      dbAccess = new DBAccess();
    }

    MongoDatabase db = dbs.get(dbName);
    if (db == null) {
      db = mongoClient.getDatabase(dbName);
      dbs.put(dbName, db);
    }

    return db;
  }

  public static void close() {
    mongoClient.close();
  }

  public static void main(String[] args) {

    System.out.println("DBAccess");
  }
}
