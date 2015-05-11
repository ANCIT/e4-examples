package org.ancit.examples.e4.views;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ITreeContentProvider;

public class ViewONE {
	private static class TreeContentProvider implements ITreeContentProvider {
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
		public void dispose() {
		}
		public Object[] getElements(Object inputElement) {
			return getChildren(inputElement);
		}
		public Object[] getChildren(Object parentElement) {
			return new Object[] { "item_0", "item_1", "item_2" };
		}
		public Object getParent(Object element) {
			return null;
		}
		public boolean hasChildren(Object element) {
			return getChildren(element).length > 0;
		}
	}
	private static class ViewerLabelProvider extends LabelProvider {
		public Image getImage(Object element) {
			return super.getImage(element);
		}
		public String getText(Object element) {
			return super.getText(element);
		}
	}
	
	@Inject
	ESelectionService selectionService;

	public ViewONE() {
	}

	/**
	 * Create contents of the view part.
	 */
	@PostConstruct
	public void createControls(Composite parent) {
		
		TreeViewer treeViewer = new TreeViewer(parent, SWT.BORDER);
		Tree tree = treeViewer.getTree();
		treeViewer.setContentProvider(new TreeContentProvider());
		treeViewer.setLabelProvider(new ViewerLabelProvider());
		treeViewer.setInput(new Object());
		
		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				selectionService.setSelection(event.getSelection());
			}
		});
	}
	
	@Inject
	public void getNotified(@UIEventTopic("UPDATE") @Optional Object string) {
		System.out.println(string);
	}

	@PreDestroy
	public void dispose() {
	}

	@Focus
	public void setFocus() {
		// TODO	Set the focus to control
	}

}
