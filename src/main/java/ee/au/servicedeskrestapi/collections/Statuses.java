package ee.au.servicedeskrestapi.collections;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ee.au.servicedeskrestapi.model.EnumItem;




@XmlRootElement
public class Statuses {

    private List<EnumItem> statuses;

	@XmlElement
	public List<EnumItem> getStatusesList() {
		if (statuses == null) {
            statuses = new ArrayList<>();
            
            /*

            Will be replaced to populate from NamedQuery 
            String sql = "SELECT * FROM SELECT * FROM servicedesk.statuses";
            


            */

            statuses.add(new EnumItem("open"));
            statuses.add(new EnumItem("progress"));
            statuses.add(new EnumItem("close"));

        }
        
        
		return statuses;
	}

}