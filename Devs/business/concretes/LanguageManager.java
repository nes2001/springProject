package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {

	private LanguageRepository languageRepository;
	 private final String ALERT_EMPTY = "Programlama dili boş olamaz";
	 private final String ALERT_RECURE = "Programlama ismi daha önce kaydedilmiş";
	
	
	
	
	
	
	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}








	@Override
	public List<Language> getAll() {
		// TODO Auto-generated method stub
		return languageRepository.getAll();
	}








	@Override
	public void insert(Language language) {
		
		isNameEmpty(language);
        isNameAlreadyExist(language);
		
		
		languageRepository.insert(language);
	}








	@Override
	public void delete(int id) {
		
		languageRepository.delete(id);
	}















	@Override
	public List<Language> printList() {
		return languageRepository.printList();
	}








	@Override
	public Language getLanguageByID(int id) {
		return languageRepository.getLanguageByID(id);
	}
	 @Override
	    public void isNameEmpty(Language language) {
	        if (language.getName().trim().isEmpty()){
	            try {
	                throw new Exception(ALERT_EMPTY);
	            } catch (Exception e) {
	                throw new RuntimeException(e);
	            }
	        }
	    }

	    @Override
	    public void isNameAlreadyExist(Language language) {
	        List<Language> allLanguages = languageRepository.getAll();
	        for (Language languageItem: allLanguages) {
	            if (languageItem.getName().equals(language.getName())){
	                try {
	                    throw new Exception(ALERT_RECURE);
	                } catch (Exception e) {
	                    throw new RuntimeException(e);
	                }
	            }
	        }
	    }








		@Override
		public void update(Language existLanguage, Language newLanguage) {
			 isNameEmpty(newLanguage);
				
				languageRepository.update(existLanguage,newLanguage);			
		}








		


}
