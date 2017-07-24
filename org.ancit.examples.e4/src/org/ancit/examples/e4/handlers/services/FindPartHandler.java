 
package org.ancit.examples.e4.handlers.services;

import java.util.List;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EModelService;

public class FindPartHandler {
	@Execute
	public void execute(MApplication application, EModelService service) {
		List<MPart> findElements = service.findElements(application, "org.ancit.examples.e4.part.0", MPart.class, null);
		System.out.println("Found part(s) : " + findElements.size());
	}
		
}