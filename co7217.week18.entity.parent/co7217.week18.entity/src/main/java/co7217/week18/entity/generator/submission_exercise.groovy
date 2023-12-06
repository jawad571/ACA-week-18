package co7217.week18.entity.generator

/**
 * Serialization of entities using the DSL: used in slides
 */
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.resource.XtextResourceSet

import com.google.inject.Injector
import co7217.week18.entity.EntityDslStandaloneSetup
import co7217.week18.entity.entityDsl.DataType
import co7217.week18.entity.entityDsl.DomainModel
import co7217.week18.entity.entityDsl.Entity
import co7217.week18.entity.entityDsl.Feature
import co7217.week18.entity.entityDsl.Import
import co7217.week18.entity.entityDsl.PackageDeclaration

class submission_exercise {
	
	def static void main(String[] args) {
		/** EXAMPLE 1 */
		def path1 = 'src/main/resources/week18/example1.dmodel'
		println (solution(path1))

		/** EXAMPLE 1 */
		def path2 = 'src/main/resources/week18/example2.dmodel'
		println (solution(path2))
		
	}
	
	def static solution = { path ->
		String text = ''
		
		// do this only once per application
		Injector injector = new EntityDslStandaloneSetup().createInjectorAndDoEMFRegistration();
		
		// obtain a resourceset from the injector
		XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
		
		// load a resource by URI, in this case from the file system
		Resource resource = resourceSet.getResource(URI.createFileURI(path), true);
		
		DomainModel model = resource.getContents().get(0)
		
		
		text += traverse(model)
		
		println(text)
		
		text
	}
	
	def static String traverse(List<EObject> list) {
		String text = ''
		for (obj in list) {
			text += traverse(obj)
		}
		text
	} 
	
	def static String traverse(EObject obj) {
		String text = ''
		
		switch(obj) {
			case DomainModel : 
				/** 
				 * TODO: write any code that may be missing here
				 */
				break
				
			case PackageDeclaration :
				/** 
				 * TODO: write any code that may be missing here
				 */
				break
				
			case DataType :
				/** 
				 * TODO: write any code that may be missing here
				 */
				break
				
			case Entity :
				/** 
				 * TODO: write any code that may be missing here
				 */
				break
				
			/** 
			 * TODO: add any cases that may be missing here
			 */
		}
		
		text
	}
	
	def static generate(EObject obj) {
		String text = ''
		switch(obj) {
			case PackageDeclaration :
				/** 
				 * TODO: write any code that may be missing here
				 */
				break
				
			case DataType :
				/** 
				 * TODO: write any code that may be missing here
				 */
				break
				
			case Entity :
				/** 
				 * TODO: write any code that may be missing here
				 */
				break
				
			/** 
			 * TODO: add any cases that may be missing here
			 */
		}
		
		text
	}
	
}
