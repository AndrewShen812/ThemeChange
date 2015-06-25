package com.na517.lf.theme;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * save the preference value
 *
 * @author <a href="mailto:kris@matchmovegames.com">Kris.lee</a>
 * @since  2011-10-9  3:49:31 pm
 * @version 1.0.0
 */
public class SPHelper {

	public static final String KEY_THEME			= "theme";
	
    private static SharedPreferences.Editor mEditor = null;
    private static SharedPreferences mdPreferences = null;
    
	public SPHelper(Context context)
	{
	}
    private static SharedPreferences.Editor getEditor(Context paramContext) {
        if (mEditor == null)
            mEditor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
        return mEditor;
    }

    private static SharedPreferences getSharedPreferences(Context paramContext) {
        if (mdPreferences == null)
            mdPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
        return mdPreferences;
    }
    public static int getTheme(Context context){
        return SPHelper.getSharedPreferences(context).getInt(KEY_THEME, R.style.FirstTheme);
    }

    public static void setTheme(Context context, int theme){
        getEditor(context).putInt(KEY_THEME, theme).commit();
    }

}
