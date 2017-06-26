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

public class HW25 {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		MongoClient mongoClient = new MongoClient();
		MongoDatabase db = mongoClient.getDatabase("video");
		MongoCollection<Document> collection = db.getCollection("movieDetails");
		Document doc = collection.find().first();
		System.out.println("doc = " + doc);

		
		//Bson filter = new Document("score", new Document("$gte", 65));
		Bson filter = Filters.eq("countries.1", "Sweden");
		//Bson sort = Sorts.orderBy(Sorts.ascending("student_id"), Sorts.ascending("score"));

		List<Document> l = collection.find(filter).into(new ArrayList<Document>());
		
		System.out.println("Count ::: " + l.size());
		for (int i = 0; i < l.size(); i++) {
			System.out.println("Output ::: " + l.get(i));
		}

	}
}
