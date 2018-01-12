package com.example.xushiyun.fastec;

import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.latte.activities.ProxyActivity;
import com.example.latte.app.Latte;
import com.example.latte.delegates.LatteDelegate;
import com.example.latte.ec.launcher.LauncherDelegate;
import com.example.latte.ec.launcher.LauncherScrollDelegate;
import com.example.latte.ec.sign.SignUpDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.hide();
        }
    }

    @Override
    public LatteDelegate setRootDelegate() {
        return new SignUpDelegate();
    }
}
