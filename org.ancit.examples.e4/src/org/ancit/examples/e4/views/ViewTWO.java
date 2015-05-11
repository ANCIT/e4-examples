 
package org.ancit.examples.e4.views;

import javax.inject.Inject;
import javax.inject.Named;
import javax.annotation.PostConstruct;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.services.internal.events.EventBroker;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;

public class ViewTWO {
	private Text text;
	@Inject
	public ViewTWO() {
		//TODO Your code here
	}
	
	@Inject
	EventBroker eventBroker;
	private Object firstElement;
	
	@PostConstruct
	public void postConstruct(Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		
		text = new Text(parent, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		text.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				eventBroker.post("UPDATE", text.getText());				
			}
		});
	}
	
	@Inject
	public void setSelection(@Named(IServiceConstants.ACTIVE_SELECTION) @Optional ISelection selection) {
		if(selection instanceof IStructuredSelection) {
			IStructuredSelection sSelection = (IStructuredSelection)selection;
			firstElement = sSelection.getFirstElement();
			System.out.println(firstElement);
			text.setText(firstElement.toString());
		}
	}
	
	
	
	
}