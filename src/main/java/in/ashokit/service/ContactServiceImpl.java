package in.ashokit.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.dto.Contact;
import in.ashokit.entity.ContactDtlsRepository;
import in.ashokit.entity.ContactEntity;
import in.ashokit.exception.PhoneBookAppException;

@Service
public class ContactServiceImpl implements ContactService {
@Autowired
	private ContactDtlsRepository contactRepo;
	@Override
	public boolean saveContact(Contact c) {
		// TODO Auto-generated method stub
		boolean isSaved =false;
		try {
			//int i= 10/0;
			ContactEntity entity= new ContactEntity();
			BeanUtils.copyProperties(c, entity); 
			ContactEntity savedEntity = contactRepo.save(entity);
			if(savedEntity.getContactId()!=null) {
				isSaved=true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new PhoneBookAppException("Failed To Save");
		}
		
		/*
		 * if(c.getContactId()!=null) { Optional<ContactEntity> findById =
		 * contactRepo.findById(c.getContactId()); entity=findById.get();
		 * BeanUtils.copyProperties(c, entity); }
		 */
		return isSaved;
	}

	@Override
	public List<Contact> getAllContacts() {
		// TODO Auto-generated method stub
		List<ContactEntity> entities=contactRepo.findAll();
		//List<Contact> contacts=new ArrayList<Contact>();
		//java 8 Streams API
		return entities.stream().map(entity ->{
		Contact contact=new Contact();	
		BeanUtils.copyProperties(entity, contact);
		return contact;
		}).collect(Collectors.toList());
		
	}

	@Override
	public Contact getContactbyId(Integer cid) {
		// TODO Auto-generated method stub
		Optional<ContactEntity> findById = contactRepo.findById(cid);
		if(findById.isPresent()) {
			ContactEntity entity=findById.get();
			Contact c=new Contact();
			BeanUtils.copyProperties(entity, c);
			return c;
		}
		
		return null;
	}

	
	@Override
	public boolean deleteContact(Integer id) {
		// TODO Auto-generated method stub
		contactRepo.deleteById(id);
		return true;
	}

}
