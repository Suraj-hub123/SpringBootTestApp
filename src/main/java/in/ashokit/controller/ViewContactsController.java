package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.ashokit.dto.Contact;
import in.ashokit.entity.ContactEntity;
import in.ashokit.service.ContactService;
@Controller
public class ViewContactsController {
	@Autowired
	private ContactService service;
	@RequestMapping("/editContact")
	public String editContact(@RequestParam("cid")Integer contactId,Model model) {
		Contact c=service.getContactbyId(contactId);
		model.addAttribute("contact",c );
		return "contactInfo.jsp";
		
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateContact(@ModelAttribute ContactEntity c,Model model) {
		return null;
		
	}
	@RequestMapping("/deleteContact")
	public String deleteContact(@RequestParam("cid")Integer contactId) {
		boolean isDeleted = service.deleteContact(contactId);
		if(isDeleted) {
			return "redirect:/viewContacts";
		}
		return null;
		
	}


}
