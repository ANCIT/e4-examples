package org.ancit.examples.e4.wizards;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;

public class SampleWizard extends Wizard {

	
	@Override
	public boolean performFinish() {
		return true;
	}
	
	@Override
	public void addPage(IWizardPage page) {
		addPage(new SampleWizardPage("Page 1"));
	}

}
