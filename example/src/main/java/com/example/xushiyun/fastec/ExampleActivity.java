package com.example.xushiyun.fastec;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.latte.activities.ProxyActivity;
import com.example.latte.app.Latte;
import com.example.latte.delegates.LatteDelegate;
import com.example.latte.ec.launcher.LauncherDelegate;

public class ExampleActivity extends ProxyActivity {


    @Override
    public LatteDelegate setRootDelegate() {
        return new LauncherDelegate();
    }
}
