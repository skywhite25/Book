package sample.spring.yse;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping(value = "/create")
	public ModelAndView create() {
		return new ModelAndView("book/create");
	}
	
	 
	@PostMapping(value = "create")
	public ModelAndView createPost(@RequestParam Map<String, Object> map) {
	    ModelAndView mav = new ModelAndView();

	    String bookId = this.bookService.create(map);
	    if (bookId == null) {
	        mav.setViewName("redirect:/create");
	    }else {
	        mav.setViewName("redirect:/detail?bookId=" + bookId); 
	    }  

	    return mav;
	}
	
	@GetMapping(value = "/detail")
	public ModelAndView detail(@RequestParam Map<String, Object> map) {
	    Map<String, Object> detailMap = this.bookService.detail(map);

	    ModelAndView mav = new ModelAndView();
	    mav.addObject("data", detailMap);
	    String bookId = map.get("bookId").toString();
	    mav.addObject("bookId", bookId);
	    mav.setViewName("/book/detail");
	    return mav;
	}
	
	@PutMapping(value = "/update")  
	public ModelAndView update(@RequestParam Map<String, Object> map) {  
	Map<String, Object> detailMap = this.bookService.detail(map);  

	ModelAndView mav = new ModelAndView();  
	mav.addObject("data", detailMap);  
	mav.setViewName("/book/update");  
	return mav;  
	} 
	
	@PostMapping(value = "update")
	public ModelAndView updatePost(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		
		boolean isUpdateSuccess = this.bookService.edit(map);
		if (isUpdateSuccess) {
			String bookId = map.get("bookId").toString();
			mav.setViewName("redirect:/detail?bookId=" + bookId);
		} else {
			mav = this.update(map);
		}
		
	return mav;
	}
	
	@PostMapping(value = "delete")
	public ModelAndView deletePost(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		
		boolean isDeleteSuccess = this.bookService.remove(map);
		if(isDeleteSuccess) {
			mav.setViewName("redirect:/list");
		} else {
			String bookId = map.get("bookId").toString();
			mav.setViewName("redirect:/detail?bookId=" + bookId);
		}
		return mav;
	}
	
	@GetMapping(value = "list")
	public ModelAndView list(@RequestParam Map<String, Object> map) {
		List<Map<String, Object>> list = this.bookService.list(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", list);
		
		if(map.containsKey("keyword")) {
			mav.addObject("keyword", map.get("keyword"));
		}
		
		mav.setViewName("/book/list");
		return mav;
	}
	
}

