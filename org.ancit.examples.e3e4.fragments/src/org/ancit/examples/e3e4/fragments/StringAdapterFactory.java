package org.ancit.examples.e3e4.fragments;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.views.properties.IPropertySource;

public class StringAdapterFactory implements IAdapterFactory {

	private static final Class<?>[] adapterList = new Class<?>[] { IPropertySource.class };

	
	@Override
	public <T> T getAdapter(Object adaptableObject, Class<T> adapterType) {
		if (adapterType== IPropertySource.class && adaptableObject instanceof String){
            return adapterType.cast(new StringPropertySource((String) adaptableObject));
        }
		return null;
	}

	@Override
	public Class<?>[] getAdapterList() {
		// TODO Auto-generated method stub
		return adapterList;
	}

}
