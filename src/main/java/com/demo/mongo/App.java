package com.demo.mongo;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		MongoClient mongoClient = new MongoClient();
		MongoDatabase db = mongoClient.getDatabase("students");
		MongoCollection<Document> collection = db.getCollection("grades");
		Document doc = collection.find().first();
		System.out.println("doc = " + doc);

		//Bson filter = new Document("score", new Document("$gte", 65));
		Bson filter = Filters.eq("type", "homework");
		Bson sort = Sorts.orderBy(Sorts.ascending("student_id"), Sorts.ascending("score"));

		List<Document> l = collection.find(filter).sort(sort).into(new ArrayList<Document>());

		for (int i = 0; i < l.size(); i+=2) {
			//System.out.println("Output ::: " + l.get(i));
			//collection.deleteOne(Filters.eq("_id", l.get(i).get("_id")));
		}
		
		System.out.println("Count ::: " + l.size());
		for (int i = 0; i < l.size(); i++) {
			System.out.println("Output ::: " + l.get(i));
		}

	}
}
