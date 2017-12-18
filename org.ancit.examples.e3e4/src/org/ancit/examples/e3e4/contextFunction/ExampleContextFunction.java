package org.ancit.examples.e3e4.contextFunction;

import org.ancit.examples.e3e4.services.ExampleSelectionService;
import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;

public class ExampleContextFunction extends ContextFunction {

	@Override
	public Object compute(IEclipseContext context, String contextKey) {
		ExampleSelectionService service = ContextInjectionFactory.make(ExampleSelectionService.class, context);
		context.set(ExampleSelectionService.class.getName(), service);

		return service;
	}

}
