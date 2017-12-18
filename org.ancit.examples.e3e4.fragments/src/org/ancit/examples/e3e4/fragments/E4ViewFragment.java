 
package org.ancit.examples.e3e4.fragments;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.widgets.Composite;

public class E4ViewFragment {
	@Inject
	public E4ViewFragment() {
		
	}
	
	@Inject
	ESelectionService selectionService;
	
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
				
			}
		});
	}
	
	
	
	
}