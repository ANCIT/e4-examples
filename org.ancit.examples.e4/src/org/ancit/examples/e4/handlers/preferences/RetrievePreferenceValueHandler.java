 
package org.ancit.examples.e4.handlers.preferences;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.extensions.Preference;

public class RetrievePreferenceValueHandler {
	@Execute
	public void execute(@Preference(nodePath="org.ancit.examples.e4", value="Message") String message) {
		System.out.println("Message "+message);
	}
		
}