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

public class HW22 {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		MongoClient mongoClient = new MongoClient();
		MongoDatabase db = mongoClient.getDatabase("students");
		MongoCollection<Document> collection = db.getCollection("grades");
		Document doc = collection.find().first();
		System.out.println("doc = " + doc);

		//Bson filter = new Document("score", new Document("$gte", 65));
		Bson filter = Filters.gte("score", 65);
		Bson sort = Sorts.ascending("score");

		List<Document> l = collection.find(filter).sort(sort).into(new ArrayList<Document>());

		System.out.println("Count ::: " + l.size());
		for (int i = 0; i < l.size(); i++) {
			System.out.println("Output ::: " + l.get(i));
		}

	}
}
