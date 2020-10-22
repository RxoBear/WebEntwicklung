package BobPAck;

import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("mb")
@SessionScoped

public class MyCount implements Serializable {

	private static final long serialVersionUID = 1L;

	int nCount = 0;

	public MyCount() {
		System.out.println("MbCount.<init>...");
		System.out.println((new Date()).toString());
	}

	@PostConstruct
	public void init() {
		System.out.println("@PostConstruct.MyBean");
	}

	public void preRenderAction() {
		System.out.println("MyBean.preRenderAction");
	}

	public void postRenderAction() {
		System.out.println("MyBean.postRenderAction");
	}

	public int getCount() {
		return ++nCount;
	}

	public Date getDate() {
		return new Date();
	}
}