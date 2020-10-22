package BobPAck;


import java.io.Serializable;
import java.util.Date;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;


@Named
@SessionScoped
public class MyBarwert implements Serializable {
	
  private static final long serialVersionUID = 1L;
  private final String CLASSNAME = getClass().getName();
  
  final static String IMG_0 = "resources/img/money_0.jpg";
  final static String IMG_1 = "resources/img/money_1.jpg";
  final static Locale DEFAULT_LOCALE = Locale.GERMAN;
  
  private double k = 100.0, b = 87.06, z = 2.0; //Kapital, Barwert und Zins in %
  private int n = 7; // Jahre
  private String imgMoney = IMG_0;
  private int imgCounter = 0;
  private Locale locale = DEFAULT_LOCALE;
  
  public MyBarwert() {System.out.println( "Constructor " + CLASSNAME + " at " + 
                                                           new Date() + "..." );  
  }
  
  @PostConstruct
  public void init() { 
  	System.out.println( "@PostConstruct." + CLASSNAME ); 
  	locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
  	if( locale == null ) locale = DEFAULT_LOCALE;
  	System.out.println( "locale: " + locale ); 
  }
  
  public void preRenderAction()  { 
  	System.out.println( "MyBean.preRenderAction"  ); }  
  public void postRenderAction() { 
  	System.out.println( "MyBean.postRenderAction" ); } 
  
  public Locale getLocale() { return locale; }
  
  public double getK() { return k; }
  public void setK( double k ) { this.k = k; }
  
  public double getB() { return b; }
  //public void setB( double b ) { this.b = b; }

  public double getZ() { return z; }
  public void setZ( double z ) { this.z = z; }

  public int getN() { return n; }
  public void setN( int n ) { this.n = n; }  
  
  public String getImgMoney() { 
    
    if( imgCounter == 0 ) {
      imgMoney = IMG_0;
      imgCounter = 1;
    }
    else{
      imgMoney = IMG_1;
      imgCounter = 0;        
    }
    
    return imgMoney;
  }
  
  public void setImgMoney( String s ) { imgMoney = s; }

  /* Version für action event:
  public String berechneBarwert(){
    b = k / ( Math.pow( 1 + z / 100.0, (double) n ) );
    
    return null;
  }*/

  public void berechneBarwert( ActionEvent ae ) {
    b = k / ( Math.pow( 1 + z / 100.0, (double) n ) );
  }
}