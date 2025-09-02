package kku.sqa.lab.api;

import java.util.List;

public interface BookCatalogueService {
	
	public List<String> getBookCatalogue(String month, String keyword);
}
