
package org.ancit.examples.e4.views;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.services.EMenuService;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class ViewTHREE {
	@Inject
	public ViewTHREE() {
	}

	@PostConstruct
	public void postConstruct(Composite parent, EMenuService menuService) {
		TableViewer viewer = new TableViewer(parent, SWT.FULL_SELECTION | SWT.MULTI);

		menuService.registerContextMenu(viewer.getControl(), "org.ancit.examples.e4.popupmenu.clickmepopup");
	}

}