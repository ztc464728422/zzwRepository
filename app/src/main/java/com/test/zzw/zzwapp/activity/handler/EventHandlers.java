package com.test.zzw.zzwapp.activity.handler;

import android.view.View;
import android.widget.Toast;


/**
 * Created by zzw on 2017/6/1.
 */

public class EventHandlers {
    public void handleClick(View view) {
        Toast.makeText(view.getContext(), "you clicked the view", Toast.LENGTH_LONG).show();
    }
}
