package ee.au.servicedeskrestapi.model;

import java.io.Serializable;


public class EnumItem implements Serializable {
    public String name;

    public EnumItem(final String name) {
        this.name = name;
    }


}