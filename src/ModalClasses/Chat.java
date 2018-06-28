package ModalClasses;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Chat 
{
		
	@Id
	@Column(name="chat_id")
	private int chatId;
	
	
	@OneToMany(mappedBy="chat",cascade=CascadeType.ALL)
	private Collection<Message> messages;

}
