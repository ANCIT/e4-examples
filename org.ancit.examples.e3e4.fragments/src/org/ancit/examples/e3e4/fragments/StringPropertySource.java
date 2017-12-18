package org.ancit.examples.e3e4.fragments;

import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;

public class StringPropertySource implements IPropertySource {
	
	private String string;

	public StringPropertySource(String string) {
		this.string = string;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object getEditableValue() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public IPropertyDescriptor[] getPropertyDescriptors() {
		return new IPropertyDescriptor[] {
                new TextPropertyDescriptor("string", "String Value")};
	}

	@Override
	public Object getPropertyValue(Object id) {
		if (id.equals("string")) {
            return new String(string);
        }

		return null;
	}

	@Override
	public boolean isPropertySet(Object id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void resetPropertyValue(Object id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPropertyValue(Object id, Object value) {
		// TODO Auto-generated method stub

	}

}
