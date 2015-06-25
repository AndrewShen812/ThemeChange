package com.na517.lf.theme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * 项目名称：LianfengApp
 * 类描述：BaseActivity
 * 创建人：lianfeng
 * 创建时间：2015/6/25 16:23
 * 修改人：lianfeng
 * 修改时间：2015/6/25 16:23
 * 修改备注：
 * 版本：V1.0
 */
public class BaseActivity extends Activity {

    public int mThemeId = R.style.FirstTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            mThemeId =SPHelper.getTheme(this);
        }
        else {
            mThemeId = savedInstanceState.getInt("ThemeId");
        }
        setTheme(mThemeId);
        super.onCreate(savedInstanceState);

        Log.i("LF", "call onCreate.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mThemeId != SPHelper.getTheme(this)) {
            reload();
        }

        Log.i("LF", "call onResume.");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("ThemeId", mThemeId);

        Log.i("LF", "call onSaveInstanceState.");
    }

    protected void reload() {
        Log.i("LF", "call reload.");

        Intent intent = getIntent();
        overridePendingTransition(0, 0);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        finish();
        overridePendingTransition(0, 0);
        startActivity(intent);
    }
}
