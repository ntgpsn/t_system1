/**
 * 
 */
package test.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 * @author wangleicd
 *
 */
@ControllerAdvice(basePackages = "com.digitalchina.sqjr.edu.pay.controller")  
public class JsonpAdvice extends AbstractJsonpResponseBodyAdvice {
	public JsonpAdvice() {  
		  
        super("jsonpcallback","jsonp","callback");  
    }  
}
