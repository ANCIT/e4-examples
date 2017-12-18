 
package org.ancit.examples.e3e4.handlers;

import javax.inject.Inject;

import org.ancit.examples.e3e4.annotations.SelectionServiceAnnotation;
import org.eclipse.e4.core.di.annotations.Execute;

public class E4DirectItemAction {
	
	@Inject
	@SelectionServiceAnnotation(message="ClassLevelInjection") String message;
	
	@Execute
	public void execute() {
		System.out.println(message);
	}
		
}