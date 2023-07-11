package productcrudapp.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/first")
	public String home() {
		System.out.println("Running Controller");
		return "indexx";
	}

}
