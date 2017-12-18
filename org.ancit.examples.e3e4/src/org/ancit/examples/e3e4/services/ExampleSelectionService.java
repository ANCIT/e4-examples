package org.ancit.examples.e3e4.services;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.ui.PlatformUI;

public class ExampleSelectionService {
	
	public static final String MY_SELECTION = "MySelection";

	public void setSelection(Object object) {
		IEclipseContext context = PlatformUI.getWorkbench().getService(IEclipseContext.class);
		context.set(MY_SELECTION, object);
	}

}
