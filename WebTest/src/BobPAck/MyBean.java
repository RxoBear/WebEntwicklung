/*
 * MyBean.java
 * JSF 2.3 template
 */

package BobPAck;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


/* Erweiterung fuer Glassfish
import javax.faces.annotation.FacesConfig;
import static javax.faces.annotation.FacesConfig.Version.JSF_2_3;
@FacesConfig(
		// Activates CDI build-in beans
		version = JSF_2_3 
)*/

/**
 * Backing bean der JSF-Seite vorlage.xhtml
 *
 * @author Wolfgang Lang
 * @version 2019-10-21
 */
@Named
@RequestScoped
public class MyBean implements Serializable {
	
	private String name = "";
	
	private static final long serialVersionUID = 1L;
    
  public MyBean() {
    System.out.println( "MyBean.<init>..."  );
    System.out.println( (new Date()).toString() );
    
  }
  

  
  @PostConstruct
  public void init() { System.out.println( "@PostConstruct.MyBean" ); }
  
  public void preRenderAction()  {
  	System.out.println( "MyBean.preRenderAction"  );
  }  
  
  public void postRenderAction() { 
  	System.out.println( "MyBean.postRenderAction" ); 
  } 
  
  public void setSearch(String name) { this.name = name; }
  public String getSearch() {return name; }
  
  public Date getDate() { return new Date(); }
  
  public String getText() { return " Wenn du mehr wissen willst, schreibe mir!"; }
}
