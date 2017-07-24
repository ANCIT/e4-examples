 
package org.ancit.examples.e4.addons;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.ancit.examples.e4.model.AddressBook;
import org.ancit.examples.e4.model.Contact;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.di.extensions.EventTopic;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.osgi.service.event.Event;

import org.eclipse.e4.core.services.events.IEventBroker;

public class AddressBookAddOn {

	@Inject
	@Optional
	public void applicationStarted(
			@EventTopic(UIEvents.UILifeCycle.APP_STARTUP_COMPLETE) Event event) {
		// TODO Modify the UIEvents.UILifeCycle.APP_STARTUP_COMPLETE EventTopic to a certain event you want to listen to.
	}
	
	@PostConstruct
	public void init(IEclipseContext context) {
		
		AddressBook book = ContextInjectionFactory.make(AddressBook.class, context);
		Contact contact = new Contact();
		contact.setName("Malai");
		book.getContacts().add(contact);
		context.set("LoadedBook", book);
		
	}

}
