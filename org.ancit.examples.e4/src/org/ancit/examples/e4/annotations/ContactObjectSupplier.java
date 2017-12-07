package org.ancit.examples.e4.annotations;

import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import org.ancit.examples.e4.model.AddressBook;
import org.ancit.examples.e4.model.Contact;
import org.eclipse.e4.core.di.suppliers.ExtendedObjectSupplier;
import org.eclipse.e4.core.di.suppliers.IObjectDescriptor;
import org.eclipse.e4.core.di.suppliers.IRequestor;
import org.osgi.service.component.annotations.Component;

@Component(service=ExtendedObjectSupplier.class,
property="dependency.injection.annotation=org.ancit.examples.e4.annotations.ContactAnnotation")
public class ContactObjectSupplier extends ExtendedObjectSupplier {

	@Inject
	@Named("LoadedAddressBook")
    private AddressBook addressBook;

	@Override
	public Object get(IObjectDescriptor descriptor, IRequestor requestor, boolean track, boolean group) {
		// get the DirectTodo from the IObjectDescriptor
        ContactAnnotation uniqueTodo = descriptor.getQualifier(ContactAnnotation.class);

        // get the id from the DirectTodo (default is 0)
        String name = uniqueTodo.name();

        // get the Todo, which has the given id or null, if there is no Todo with the given id
        Contact contact = addressBook.getContact(name);

        return contact;

	}

}
