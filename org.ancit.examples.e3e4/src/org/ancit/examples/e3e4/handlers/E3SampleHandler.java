package org.ancit.examples.e3e4.handlers;

import javax.inject.Inject;

import org.ancit.examples.e3e4.annotations.SelectionServiceAnnotation;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class E3SampleHandler extends AbstractHandler {
	
	@Inject
	@SelectionServiceAnnotation(message="ClassLevelInjection") String message;
	
	/**
	 * The constructor.
	 */
	public E3SampleHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		MessageDialog.openInformation(
				window.getShell(),
				"E3E4",
				"Hello, Eclipse world "+message);
		return null;
	}
}
