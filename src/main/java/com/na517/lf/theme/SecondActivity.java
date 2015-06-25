package com.na517.lf.theme;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class SecondActivity extends BaseActivity {

    private Button mBtnChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mBtnChange = (Button) findViewById(R.id.btn_second_change);
        mBtnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SPHelper.setTheme(SecondActivity.this, mThemeId == R.style.FirstTheme ? R.style.SecondTheme : R.style.FirstTheme);
                reload();
            }
        });
    }
}
