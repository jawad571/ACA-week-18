/*
 * generated by Xtext 2.32.0
 */
package co7217.week18.entity.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;

public abstract class AbstractEntityDslValidator extends AbstractDeclarativeValidator {
	
	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> result = new ArrayList<EPackage>();
		result.add(co7217.week18.entity.entityDsl.EntityDslPackage.eINSTANCE);
		return result;
	}
}