package com.appsfromholland.blindwallsgallery;

public interface BlindwallsApiListener {
    void onMuralAvailable(Mural mural);
    void onMuralError(Error error);
}
