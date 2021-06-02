package in.ashokit.service;



import java.util.List;

import in.ashokit.dto.Contact;


public interface ContactService {
 boolean saveContact(Contact c);
 List<Contact> getAllContacts();
 Contact getContactbyId(Integer cid);
 //boolean updateContact(Contact c);
 boolean deleteContact(Integer id);
}
