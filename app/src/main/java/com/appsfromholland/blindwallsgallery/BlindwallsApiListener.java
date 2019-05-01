package com.appsfromholland.blindwallsgallery;

public interface BlindwallsApiListener {

    public void onMuralAvailable(Mural mural);
    public void onMuralError(Error error);

}
