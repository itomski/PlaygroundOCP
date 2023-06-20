package de.lubowiecki;

import java.util.ListResourceBundle;

public class keys_en extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        /*
        btn1 = Save
        btn2 = Delete
        btn3 = Update
        */
        return new Object[][]{
                {"btn1", "SaveLRB"},
                {"btn2", "DeleteLRB"},
                {"btn3", "UpdateLRB"},
        };
    }
}
