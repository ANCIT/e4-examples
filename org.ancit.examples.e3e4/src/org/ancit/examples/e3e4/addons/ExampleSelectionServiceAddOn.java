 
package org.ancit.examples.e3e4.addons;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.ancit.examples.e3e4.services.ExampleSelectionService;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.di.extensions.EventTopic;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.internal.e4.compatibility.SelectionService;

public class ExampleSelectionServiceAddOn {

	@Inject
	@Optional
	public void applicationStarted(
			@EventTopic(UIEvents.UILifeCycle.APP_STARTUP_COMPLETE) Event event) {
		// TODO Modify the UIEvents.UILifeCycle.APP_STARTUP_COMPLETE EventTopic to a certain event you want to listen to.
	}
	
	@PostConstruct
	public void init(IEclipseContext context) {
		context.set(ExampleSelectionService.class.getName(),
				new ExampleSelectionService());
	}

}
