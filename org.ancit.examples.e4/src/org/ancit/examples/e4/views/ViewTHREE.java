
package org.ancit.examples.e4.views;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.ancit.examples.e4.annotations.ContactAnnotation;
import org.ancit.examples.e4.model.Contact;
import org.eclipse.e4.ui.services.EMenuService;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class ViewTHREE {
	@Inject
	public ViewTHREE() {
	}

	@PostConstruct
	public void postConstruct(Composite parent, EMenuService menuService, @ContactAnnotation(name="EclipseContacts") Contact contact) {
		TableViewer viewer = new TableViewer(parent, SWT.FULL_SELECTION | SWT.MULTI);
		System.out.println(contact.getName());
		menuService.registerContextMenu(viewer.getControl(), "org.ancit.examples.e4.popupmenu.clickmepopup");
	}
}