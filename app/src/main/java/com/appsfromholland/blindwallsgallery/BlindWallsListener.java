package com.appsfromholland.blindwallsgallery;

public interface BlindWallsListener {

    void onMuralAvailable(Mural mural);

    void unMuralError(String errorMessage);

}
