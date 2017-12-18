 
package org.ancit.examples.e3e4.views;

import javax.inject.Inject;
import javax.inject.Named;
import javax.annotation.PostConstruct;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;

public class E4View {
	@Inject
	public E4View() {
		
	}
	
	@PostConstruct
	public void postConstruct(Composite parent) {
		
	}
	
	@Inject
	public void setSelection(@Named(IServiceConstants.ACTIVE_SELECTION) @Optional IStructuredSelection selection) {
		System.out.println("E4 View : Selection Listener : "+selection);
	}
	
	
	
	
}