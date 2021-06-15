package script;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.BulkWriteOptions;
import com.mongodb.client.model.UpdateOneModel;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.WriteModel;
import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.DBAccess;
import com.mongodb.bulk.BulkWriteResult;
import static com.mongodb.client.model.Filters.*;
import java.util.ArrayList;
import java.util.List;

public class Cleaner {
  // organization id that is being using in automated test
  private final String targetOrganizationID = "";
  private final String dbName = "nimbly";


  private List<String> getIDsFromMgoDocuments(String key, FindIterable<Document> documents) {
    List<String> ids = new ArrayList<String>();

    MongoCursor<Document> cursor = documents.iterator();

    try {
      while (cursor.hasNext()) {
        Document document = cursor.next();

        String id = document.getString(key);
        ids.add(id);
      }
    } finally {
      cursor.close();
    }

    return ids;
  }

  private List<Document> getDocuments(FindIterable<Document> iterable) {

    MongoCursor<Document> cursor = iterable.iterator();

    List<Document> documents = new ArrayList<Document>();

    try {
      while (cursor.hasNext()) {
        Document document = cursor.next();

        documents.add(document);
      }
    } finally {
      cursor.close();
    }

    return documents;
  }

  /**
   * Store items to remove at a separate table so it can be audited first to prevent unwanted
   * removal
   */
  private void storeItemsToRemove(String collectionName, List<Document> docs) {
    MongoCollection<Document> collection = DBAccess.getDatabase("automation_removal")
        .getCollection(collectionName);

    List<WriteModel<Document>> items = new ArrayList<WriteModel<Document>>();

    for (Document d : docs) {
      // get origin ObjectID as reference in new document in new collection
      Object oid = d.get("_id");
      d.append("ref_id", oid);

      Document filterDoc = new Document();
      filterDoc.append("ref_id", oid);

      Document updateDoc = new Document();
      updateDoc.append("$set", d);

      UpdateOptions updateOptions = new UpdateOptions();
      updateOptions.upsert(true);

      items.add(
          new UpdateOneModel<Document>(
              filterDoc,
              updateDoc,
              updateOptions));
    }

    BulkWriteResult result = collection.bulkWrite(
        items,
        new BulkWriteOptions().ordered(false));

  }

  public void cleanSitesByPrefix(String prefix) {
    MongoCollection<Document> siteCol = DBAccess.getDatabase(dbName).getCollection("sites");

    String pattern = "^" + prefix;
    Bson filter = and(eq("organizationID", targetOrganizationID), regex("name", pattern));

    FindIterable<Document> it = siteCol.find(filter);
    List<Document> documents = getDocuments(it);

    System.out.printf("found %d sites", documents.size());

    storeItemsToRemove("sites", documents);

  }

  public void cleanDepartmentsByPrefix(String prefix) {
    MongoCollection<Document> deptCol = DBAccess.getDatabase(dbName).getCollection("departments");

    String pattern = "^" + prefix;
    Bson filter = and(eq("organizationID", targetOrganizationID), regex("name", pattern));

    FindIterable<Document> it = deptCol.find(filter);
    List<Document> documents = getDocuments(it);

    System.out.printf("found %d departments", documents.size());

    storeItemsToRemove("departments", documents);

  }

  public void cleanUsersByPrefix(String prefix) {
    MongoCollection<Document> userCol = DBAccess.getDatabase(dbName)
        .getCollection("users");

    Bson filter = and(
        eq("organizationID", targetOrganizationID),
        regex("displayName", "^" + prefix));

    FindIterable<Document> it = userCol.find(filter);
    List<Document> documents = getDocuments(it);

    System.out.printf("found %d users", documents.size());

    storeItemsToRemove("users", documents);

  }

  public void cleanQuestionnaireByPrefix(String prefix) {
    MongoCollection<Document> questionnaireIndexCol = DBAccess.getDatabase(dbName)
        .getCollection("questionnaireindexes");

    Bson filter = and(
        eq("organizationID", targetOrganizationID),
        regex("title", "^" + prefix));

    FindIterable<Document> it = questionnaireIndexCol.find(filter);
    List<Document> documents = getDocuments(it);

    System.out.printf("found %d questionnaires", documents.size());

    storeItemsToRemove("questionnaireindexes", documents);
  }

  public static void main(String[] args) {

    DBAccess.getDatabase("test");
  }
}
