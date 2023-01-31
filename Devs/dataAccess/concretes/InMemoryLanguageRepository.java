package kodlama.io.Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Language;
@Repository
public class InMemoryLanguageRepository implements LanguageRepository {


	List<Language> languages;
	
	
	@Autowired
	public InMemoryLanguageRepository() {

	
	languages=new ArrayList<Language>();
	languages.add(new Language(1,"C#"));
	languages.add(new Language(2,"Python"));
	languages.add(new Language(3,"C"));
	
	
}



	@Override
	public List<Language> getAll() {
		// TODO Auto-generated method stub
		return languages;
	}



	@Override
	public void insert(Language language) {

		languages.add(language);
		
	}



	@Override
	public void delete(int id) {
languages.remove(id);
	}



	@Override
	public void update(Language existLanguage, Language newLanguage) {
languages.set(existLanguage.getId(), newLanguage);		
	}



	@Override
	public List<Language> printList() {
		// TODO Auto-generated method stub
		return languages;
	}



	@Override
	public Language getLanguageByID(int id) {
		return languages.get(id);
	}



	
}