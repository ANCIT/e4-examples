 
package org.ancit.examples.e4.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.EPartService.PartState;

public class OpenViewHandler {
	@Execute
	public void execute(EPartService service) {
		MPart part = service.createPart("org.ancit.examples.e4.partdescriptor.dynamicpart");
		part.setLabel("Sample View - Descriptor");
		
		service.showPart(part, PartState.ACTIVATE);
	}
		
}