package vttp2023.batch3.csf.assessment.cnserver.controllers;

import java.io.IOException;
import java.io.StringReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import vttp2023.batch3.csf.assessment.cnserver.UploadUtil.FileUploadUtil;
import vttp2023.batch3.csf.assessment.cnserver.models.News;
import vttp2023.batch3.csf.assessment.cnserver.repositories.NewsRepository;

@RestController
@RequestMapping(path="/news-server")
@CrossOrigin
public class NewsController {

	@Autowired
	private NewsRepository newsRepo;

	News newsForm;
	News savedNews;

	 @PostMapping("/form/image")
    public RedirectView postNews(News newsForm,
            @RequestParam("image") MultipartFile multipartFile) throws IOException {
         
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        newsForm.setImage(fileName);
         
        News savedNews = newsRepo.save(newsForm);
 
        String uploadDir = "form-photos/" + savedNews.getId();
 
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
         
        return new RedirectView("/form", true);
    }

	@PostMapping(path="/form", consumes = MediaType.APPLICATION_JSON_VALUE
			, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> postNews(@RequestBody String payload) {
		JsonReader reader = Json.createReader(new StringReader(payload));
		JsonObject newsForm = reader.readObject();
		System.out.printf(">>>> newsForm: %s\n", newsForm);
		if (((this.newsForm.getTitle().trim().length())<5) || ((this.newsForm.getDescription().trim().length())<5) || (this.newsForm.getImage() == null)) {
			// catch
			return ResponseEntity.status(400)
				.body(
					Json.createObjectBuilder()
						.add("title", "Cannot submit %s".formatted(newsForm.getString("title")))
						.build().toString()
				);} else {

		//then
		return ResponseEntity.ok(
			Json.createObjectBuilder()
				.add("title", "%s saved".formatted(savedNews.getString("title")))
				.build().toString()
		)
				}
		;
	}
}



	// TODO: Task 1



	// TODO: Task 2


	// TODO: Task 3

}
