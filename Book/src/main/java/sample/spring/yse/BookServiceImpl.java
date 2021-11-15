package sample.spring.yse;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	BookDAO bookDAO;
	
	@Override
	public String create(Map<String, Object> map) {
	    int affectRowCount = this.bookDAO.insert(map);
	    if (affectRowCount ==  1) {
	        return map.get("book_id").toString();
	    }
	    return null;

	}
	
	@Override
	public Map<String, Object> detail(Map<String, Object> map) {
		return this.bookDAO.selectDetail(map);
	}
	
	public boolean edit(Map<String, Object> map) {
		int affectRowCount = this.bookDAO.update(map);
		return affectRowCount == 1;
	}
}
