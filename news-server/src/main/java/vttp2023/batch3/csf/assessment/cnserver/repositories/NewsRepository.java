package vttp2023.batch3.csf.assessment.cnserver.repositories;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import jakarta.json.Json;
import vttp2023.batch3.csf.assessment.cnserver.models.News;

@Repository
public class NewsRepository {

	public static final String A_ID = "id";
	public static final String C_TAGS = "tags";
	public static final String A_POSTDATE = "postdate";
	public static final String A_TITLE = "title";
	public static final String A_DESCRIPTION = "description";
	public static final String A_IMAGE = "image";
	public static final String A_OBJECTID = "_id";
	public static final String C_NEWS = "news";

/*
	db.news.insert({ _id: "A_OBJECTID", postDate: "A_POSTDATE", title: "A_TITLE", description: "A_DESCRIPTION", image: "A_IMAGE", tags: "C_TAGS"  })
	}

	*/
	// TODO: Task 1 
	// Write the native Mongo query in the comment above the method
	@Autowired
	private MongoTemplate template;


    

	

	/* 
	
	

	db.news.aggregate(
   [ {$count}
	
	{ $sort : postdate }
	{ $sort : { tagcount : -1 } }
	{ $limit : 10 }

  ]
*/

	// TODO: Task 2 
	// Write the native Mongo query in the comment above the method
	Query query = new Query();



	/* db.news.aggregate(
   [
	{ $sort : { tags : 1 } }
  ]
*/


	// TODO: Task 3
	// Write the native Mongo query in the comment above the method

	JsonObject object = Json.createObjectBuilder()
								.add("title", savedNews.getTitle())
								.add("image", savedNews.getImage())
								.add("description", savedNews.getDescription())
								.add("id", savedNews.getId())
								.add("tags", savedNews.getTags())
								.build();

}
