package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages")
	
public class LanguagesController {
	
	private LanguageService languageService;

	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	
	
	@PostMapping(
			value="/insert",
			consumes="application/json",
			produces="application/json")
	public void insert(@RequestBody Language language) {
		languageService.insert(language);
	}
	
	
	
	
	
	/*@GetMapping("/getAll")
	public List<Language> getAll(){
		return languageService.getAll();
	}
*/
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id")int id) {
		languageService.delete(id);
	}
	
	@GetMapping("/printList")
	public List<Language> printList(){
		return languageService.printList();
	}
	
@GetMapping("/getLanguageByID/{id}")
public Language getLanguageByID(@PathVariable("id") int id) {
	return languageService.getLanguageByID(id);
}

}
