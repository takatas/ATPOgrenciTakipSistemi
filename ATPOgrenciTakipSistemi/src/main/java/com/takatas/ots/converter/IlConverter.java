package com.takatas.ots.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.takatas.ots.entity.Il;
import com.takatas.ots.service.YerlesimService;
import com.takatas.ots.util.YerlesimTip;

@Controller("ilConverter")
@Scope("request")
public class IlConverter implements Converter{

	@Autowired
	private transient YerlesimService yerlesimService;
	
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,String value) {
		 if(value != null && value.trim().length() > 0) {
	            try {
	                return yerlesimService.getById(YerlesimTip.IL, Long.parseLong(value));
	            } catch(Exception e) {
	                e.printStackTrace();
	            }
	        }else {
	            return null;
	        }
		 return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) {
		if(object != null) {
            return String.valueOf(((Il) object).getId());
        }else {
            return null;
        }
	}


}
