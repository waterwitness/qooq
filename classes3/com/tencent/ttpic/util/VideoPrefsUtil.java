package com.tencent.ttpic.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class VideoPrefsUtil
{
  public static final String PREFS_KEY_DOWNGRADE_LEVEL = "prefs_key_downgrade_level";
  public static final String PREFS_KEY_IS_MATERIAL_MUTE = "prefs_key_is_material_mute";
  private static SharedPreferences mPrefs;
  
  public static SharedPreferences getDefaultPrefs()
  {
    return mPrefs;
  }
  
  public static int getDowngradeLevel()
  {
    return getDefaultPrefs().getInt("prefs_key_downgrade_level", 0);
  }
  
  public static boolean getMaterialMute()
  {
    return getDefaultPrefs().getBoolean("prefs_key_is_material_mute", false);
  }
  
  public static void init(Context paramContext)
  {
    mPrefs = PreferenceManager.getDefaultSharedPreferences(paramContext);
  }
  
  public static void setDowngradeLevel(int paramInt)
  {
    getDefaultPrefs().edit().putInt("prefs_key_downgrade_level", paramInt).apply();
  }
  
  public static void setMaterialMute(boolean paramBoolean)
  {
    getDefaultPrefs().edit().putBoolean("prefs_key_is_material_mute", paramBoolean).apply();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\util\VideoPrefsUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */