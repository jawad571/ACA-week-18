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
import co7217.week18.entity.entityDsl.AbstractElement
import co7217.week18.entity.entityDsl.DataType
import co7217.week18.entity.entityDsl.DomainModel
import co7217.week18.entity.entityDsl.Entity
import co7217.week18.entity.entityDsl.Feature
import co7217.week18.entity.entityDsl.Import
import co7217.week18.entity.entityDsl.PackageDeclaration
import co7217.week18.entity.entityDsl.Visibility

class EntityGenerator_Visitor_Serialization {
	
	def static void main(String[] args) {
		
		// do this only once per application
		Injector injector = new EntityDslStandaloneSetup().createInjectorAndDoEMFRegistration();
		
		// obtain a resourceset from the injector
		XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
		
		// load a resource by URI, in this case from the file system
		Resource resource = resourceSet.getResource(URI.createFileURI("src/main/resources/week18/example1.dmodel"), true);
		
		DomainModel model = resource.getContents().get(0)
		
		String text = ''
		text += traverse(model)
		println(text)
		
		File output = new File('src/main/resources/output.dmodel')
		output.createNewFile()
		output << text
	
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
				text += traverse(obj.elements)
				break
				
			case PackageDeclaration :
				text += generate(obj)
				break
				
			case DataType :
				text += generate(obj)
				break
				
			case Entity :
				text += generate(obj)
				break
				
			case Import :
				text += generate(obj)
				break
			
			case Feature :
				text += generate(obj)
				break
		}
		
		text
	}
	
	def static generate(EObject obj) {
		String text = ''
		switch(obj) {
			case PackageDeclaration :
				text += """package ${obj.name} {
  ${traverse(obj.elements)}
}
"""
				
				break
				
			case DataType :
				text += """datatype ${obj.name}
"""
				break
				
			case Entity :
				text += """entity ${obj.name}""" 
				if (obj.superType != null) {
					text += """ extends ${obj.superType.name}"""
				}
				text += """ {
"""
				text += traverse(obj.features)
				text += """
}
"""
				break
				
			case Import :
				text += """import ${obj.importedNamespace}
"""
				break
			case Feature :
				text+= """  ${obj.modifier==Visibility.PUBLIC?'':obj.modifier}${obj.many?' many':''} ${obj.name} : ${obj.type.name}
"""
				break
		}
		
		text
	}
	
}
