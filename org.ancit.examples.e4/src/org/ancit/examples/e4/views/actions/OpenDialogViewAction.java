 
package org.ancit.examples.e4.views.actions;

import org.eclipse.e4.core.contexts.Active;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MDialog;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.EPartService.PartState;

public class OpenDialogViewAction {
	@Execute
	public void execute(EPartService partService, EModelService modelService,@Active MWindow window) {
		MDialog mDialog = (MDialog) modelService.find("org.ancit.examples.e4.dialog.sampledialog", window);
		MPart mPart = (MPart) mDialog.getChildren().get(0);
		partService.showPart(mPart, PartState.ACTIVATE);
	}
		
}