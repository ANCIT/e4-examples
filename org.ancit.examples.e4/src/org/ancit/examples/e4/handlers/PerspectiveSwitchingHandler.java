
package org.ancit.examples.e4.handlers;

import java.util.List;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;

public class PerspectiveSwitchingHandler {
	@Execute
	public void execute(MWindow window, EPartService partService, EModelService modelService,
			@Named("org.ancit.examples.e4.commandparameter.perspectiveparameter") String perspectiveId) {
		List<MPerspective> perspectives = modelService.findElements(window, perspectiveId, MPerspective.class, null);

		// switch to perspective with the ID if found
		if (!perspectives.isEmpty()) {
			partService.switchPerspective(perspectives.get(0));
		}
	}

}