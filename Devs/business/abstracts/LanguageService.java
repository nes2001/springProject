package kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.entities.concretes.Language;


public interface LanguageService {
	List<Language> getAll();
     
	void insert(Language language);
	void delete(int id);
	void update(Language existLanguage, Language newLanguage);
	List<Language> printList();
	Language getLanguageByID(int id);
	void isNameEmpty(Language language);
	void isNameAlreadyExist(Language language);

}
