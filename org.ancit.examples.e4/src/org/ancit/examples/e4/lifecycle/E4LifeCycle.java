package org.ancit.examples.e4.lifecycle;

import org.ancit.examples.e4.model.AddressBook;
import org.ancit.examples.e4.model.Contact;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.workbench.lifecycle.PostContextCreate;

public class E4LifeCycle {

	@PostContextCreate
	void postContextCreate(IEclipseContext workbenchContext) {
		AddressBook book = ContextInjectionFactory.make(AddressBook.class, workbenchContext);
		workbenchContext.set(AddressBook.class, book);
		
		AddressBook loadedAddressBook = ContextInjectionFactory.make(AddressBook.class, workbenchContext);
		Contact contact = new Contact();
		contact.setName("EclipseContacts");
		loadedAddressBook.getContacts().add(contact);
		workbenchContext.set("LoadedAddressBook", loadedAddressBook);
	}

}
