package vttp2023.batch3.csf.assessment.cnserver.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.metrics.StartupStep.Tags;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mongodb.lang.NonNull;

import jakarta.json.Json;
import vttp2023.batch3.csf.assessment.cnserver.models.News;
import vttp2023.batch3.csf.assessment.cnserver.models.TagCount;
import vttp2023.batch3.csf.assessment.cnserver.repositories.ImageRepository;
import vttp2023.batch3.csf.assessment.cnserver.repositories.NewsRepository;

@Service
public class NewsService {
	@Autowired
	NewsRepository newsRepo;
	
	@Autowired
	ImageRepository imageRepo;
	
	private String id;
	private long postDate;
	private String title;
	private String description;
	private String image;
	private List<String> tags; 
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
public ResponseEntity<byte[]> getImage(@PathVariable("id") String id) {
    byte[] image = imageRepo.getImage(id);
    return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
}




	// TODO: Task 1
	// Do not change the method name and the return type
	// You may add any number of parameters
	// Returns the news id
	public String postNews(@RequestParam @NonNull @Min(5) String title, @RequestParam(required=true) String image, @RequestParam(required=true) @Min(5) String description, @RequestParam(required=false) String tags  ) {
		this.newsForm.save();
		return "";
	}
	 
	// TODO: Task 2
	// Do not change the method name and the return type
	// You may add any number of parameters
	// Returns a list of tags and their associated count
	public List<TagCount> getTags(/* Any number of parameters */) {
		return new LinkedList<>();
	}

	// TODO: Task 3
	// Do not change the method name and the return type
	// You may add any number of parameters
	// Returns a list of news

	
	

	public List<News> getNewsByTag(List<News> list, String tag) {
		Collection<News> newsCollection;
		ArrayList<News> newArrayList;
		LinkedList<News> lL;
		for (News savedNews : newArrayList) {
			for(String indivtag : savedNews.getTags()) {
			if (indivtag == tag){ 
				LinkedList<News>() 

				lL.add(savedNews);
			} else {
				break;
			}

		}
		lL = new LinkedList<>();

		return new LinkedList<>();
	}
}
	
}

		ListIterator<News> newsIterator = savedNews.listIterator();

		while(newsIterator.hasNext()) {
			if(savedNews.getTags() = tag){
				

			}
public void setTags(List<String> tags) { this.tags = tags; }
	public List<String> getTags() { return this.tags; }
