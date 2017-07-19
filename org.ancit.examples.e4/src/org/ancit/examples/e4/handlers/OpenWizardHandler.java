 
package org.ancit.examples.e4.handlers;

import org.ancit.examples.e4.wizards.SampleWizard;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;

public class OpenWizardHandler {
	@Execute
	public void execute(Shell shell) {
		IEclipseContext context = EclipseContextFactory.create();

		IWizard wizard = ContextInjectionFactory.make(SampleWizard.class, context);
		WizardDialog dialog = new WizardDialog(shell, wizard);
		dialog.open();
	}
		
}