package in.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import in.ashokit.dto.Contact;
import in.ashokit.entity.ContactEntity;
import in.ashokit.service.ContactService;

@Controller
//@ComponentScan(basePackages = {"in.ashokit.controller"})
public class ContactInfoController {
	@Autowired
	private ContactService contactService;
	@GetMapping(value= {"/","/addContact"})
	public String loadForm(Model model) {
		Contact c=new Contact();
		model.addAttribute("contact",c);
		return "contactInfo.jsp";
	}
	@PostMapping(value= "/saveContact")
	public String handleSubmitBtn(@ModelAttribute("contact")Contact c,Model m) {
		boolean isSave = contactService.saveContact(c);
		if(isSave) {
			m.addAttribute("succMsg","Contact Saved");
		}
		else {
			m.addAttribute("errMsg","Failed To Save");
		}
		return "contactInfo.jsp";
	}
	
	@GetMapping("/viewContacts")
	public String handleViewContactsLink(ContactEntity c,Model model) {
		List<Contact> contactsList = contactService.getAllContacts();
		model.addAttribute("contacts",contactsList);
		return "viewContacts.jsp";
	}
	

}
