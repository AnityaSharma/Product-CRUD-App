package productcrudapp.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public RedirectView home() {
		RedirectView redirectView = new RedirectView();
		System.out.println("Running Controller");
		redirectView.setUrl("indexx");
		return redirectView;
	}

}
