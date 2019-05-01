package com.appsfromholland.blindwallsgallery;

import java.util.ArrayList;

public class MuralFactory {

    private ArrayList<Mural> dataset = new ArrayList<>();
    private static MuralFactory instance = null;

    public static MuralFactory getInstance() {
        if( instance == null ) {
            instance = new MuralFactory();
        }
        return instance;
    }

    private MuralFactory() {
        refreshDataSet();
    }

    private void refreshDataSet() {

    }

}
