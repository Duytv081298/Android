package com.android.btvn_buoi5;

import android.widget.Button;

public class Box {
    private Button id ;
    private boolean status;

    public Box(Button id, boolean status) {
        this.id = id;
        this.status = status;
    }

    public Button getId() {
        return id;
    }

    public void setId(Button id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
