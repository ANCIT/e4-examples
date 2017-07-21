 
package org.ancit.examples.e4.views.actions;

import org.eclipse.e4.core.contexts.Active;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

public class ClickMeAction {
	@Execute
	public void execute(@Active Shell shell) {
		MessageDialog.openInformation(shell, "Information Dialog", "Click ME Action - Dialog");
	}
	
		
}