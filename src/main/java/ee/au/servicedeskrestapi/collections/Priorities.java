package ee.au.servicedeskrestapi.collections;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ee.au.servicedeskrestapi.model.EnumItem;




@XmlRootElement
public class Priorities {

    private List<EnumItem> priorities;

	@XmlElement
	public List<EnumItem> getPrioritiesList() {
		if (priorities == null) {
            priorities = new ArrayList<>();
            
            /*
            Will be replaced to populate from NamedQuery 
            String sql = "SELECT name FROM SELECT * FROM servicedesk.priorities";
            */
            
// Temp solution
            priorities.add(new EnumItem("very low"));
            priorities.add(new EnumItem("low"));
            priorities.add(new EnumItem("medium"));
            priorities.add(new EnumItem("high"));
            priorities.add(new EnumItem("very high"));
//End Temp solution
        }       
		return priorities;
	}

}