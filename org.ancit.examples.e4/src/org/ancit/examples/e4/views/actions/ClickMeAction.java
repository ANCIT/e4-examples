 
package org.ancit.examples.e4.views.actions;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

public class ClickMeAction {
	@Execute
	public void execute() {
		MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Information Dialog", "Click ME Action - Dialog");
	}
	
		
}