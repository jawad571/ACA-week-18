package co7217.week18.entity.generator

/**
 * serialization of entities using explicit traversal: not used in exercises nor in slides
 */

import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.resource.XtextResourceSet

import com.google.inject.Injector
import co7217.week18.entity.EntityDslStandaloneSetup
import co7217.week18.entity.entityDsl.AbstractElement
import co7217.week18.entity.entityDsl.DataType
import co7217.week18.entity.entityDsl.DomainModel
import co7217.week18.entity.entityDsl.Entity
import co7217.week18.entity.entityDsl.Feature
import co7217.week18.entity.entityDsl.Import
import co7217.week18.entity.entityDsl.PackageDeclaration
import co7217.week18.entity.entityDsl.Visibility

class EntityGenerator_ExplicitTraversal_Serialization {
	
	def static void main(String[] args) {
		// do this only once per application
		Injector injector = new EntityDslStandaloneSetup().createInjectorAndDoEMFRegistration();
		
		// obtain a resourceset from the injector
		XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
		
		// load a resource by URI, in this case from the file system
		Resource resource = resourceSet.getResource(URI.createFileURI("src/main/resources/week18/example1.dmodel"), true);
		
		DomainModel model = resource.getContents().get(0)
		
		
		String text = ''
		
		text += processElements(model.elements)
		
		File output = new File('src/main/resources/output.dmodel')
		output.createNewFile()
		output << text
	}
	
	def static String processElements(List<AbstractElement> list) {
		String text = ''
		for (el in list) {
			text += processElement(el)
		}
		return text
	}
	
	def static String processElement(AbstractElement el) {
		String text = ''
		
		/**
		 * TODO: create your model to text transformation logic HERE.
		 * 
		 * Feel free to use all the facilities of the Groovy language.
		 * 
		 */
		
		return text
	}
	
}
