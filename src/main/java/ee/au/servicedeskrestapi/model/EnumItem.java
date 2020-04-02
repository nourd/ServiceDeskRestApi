package ee.au.servicedeskrestapi.model;

import java.io.Serializable;


public class EnumItem implements Serializable {
    private String name;

    public EnumItem(final String name) {
        this.name = name;
    }

    public String getName() {
		return name;
	}

	public void setNmae(String name) {
		this.name = name;
	}




}