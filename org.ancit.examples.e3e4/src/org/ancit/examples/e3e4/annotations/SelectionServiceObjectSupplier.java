package org.ancit.examples.e3e4.annotations;

import org.eclipse.e4.core.di.suppliers.ExtendedObjectSupplier;
import org.eclipse.e4.core.di.suppliers.IObjectDescriptor;
import org.eclipse.e4.core.di.suppliers.IRequestor;

public class SelectionServiceObjectSupplier extends ExtendedObjectSupplier {

	@Override
	public Object get(IObjectDescriptor descriptor, IRequestor requestor, boolean track, boolean group) {
		SelectionServiceAnnotation qualifier = descriptor.getQualifier(SelectionServiceAnnotation.class);
		return qualifier.message();
	}

}
