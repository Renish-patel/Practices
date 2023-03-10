package springMVC.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String home() {
		System.out.println("this is home url");
		return "index";
	}

	@RequestMapping("/about")
	public String about() {
		System.out.println("this known as about");
		return "about";
	}

	@RequestMapping("/services")
	public String services(Model model) {
		List<String> Friends = new ArrayList<String>();
		Friends.add("deep");
		Friends.add("hello");
		Friends.add("hii");
		
		model.addAttribute("f",Friends);
		
		
		System.out.println("this is about services ");
		return "services";

	}

	@RequestMapping("/help")
	public String help(Model model) {
		
		model.addAttribute("name","renish");
		model.addAttribute("id",31121);
		System.out.println("this help");
		return "help";
	}

}
