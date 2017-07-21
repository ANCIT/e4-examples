
package org.ancit.examples.e4.handlers.preferences;

import javax.inject.Named;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.widgets.Shell;
import org.osgi.service.prefs.BackingStoreException;

public class AddPreferenceValueHandler {
	@Execute
	public void execute(@Preference(nodePath = "org.ancit.examples.e4") IEclipsePreferences pref, @Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {

		InputDialog iDialog = new InputDialog(shell, "Pref Dialog", "Enter Value for Message",
				pref.get("Message", "Default Value"), null);
		if (iDialog.open() == IDialogConstants.OK_ID) {
			pref.put("Message", iDialog.getValue());
			try {
				pref.flush();
			} catch (BackingStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}