 
package org.ancit.examples.e3e4.views;

import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.ancit.examples.e3e4.services.ExampleSelectionService;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.widgets.Composite;

public class E4View {
	
	@Inject
	ESelectionService selectionService;
	
	@Inject
	ExampleSelectionService exampleSelectionService;
	
	@Inject
	public E4View() {
		
	}
	
	@PostConstruct
	public void postConstruct(Composite parent) {
		ListViewer listViewer = new ListViewer(parent);
		listViewer.setContentProvider(ArrayContentProvider.getInstance());
		listViewer.setLabelProvider(new LabelProvider());
		listViewer.setInput(new String[] {"One", "Two", "Three"});
		
		listViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				selectionService.setSelection(event.getSelection());
				
				exampleSelectionService.setSelection(event.getSelection());
			}
		});
	}
	
	@Inject
	public void setSelection(@Named(IServiceConstants.ACTIVE_SELECTION) @Optional IStructuredSelection selection) {
		System.out.println("E4 View : Selection Listener : "+selection);
	}
	
	@Inject
	public void setExampleSelection(@Named(ExampleSelectionService.MY_SELECTION) @Optional Object object) {
		System.out.println("E4 View : Custom Selection Service" +  object);
	}
	
	
}