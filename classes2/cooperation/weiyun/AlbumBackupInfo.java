package cooperation.weiyun;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class AlbumBackupInfo
{
  private static final String a = "plugin_enable_state";
  
  public AlbumBackupInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private static String a(String paramString1, String paramString2)
  {
    return paramString1 + paramString2;
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext.getSharedPreferences("weiyun.pref.plugin.albumbackup.options", AlbumBackupConst.a).edit().putBoolean(a(paramString, "plugin_enable_state"), paramBoolean).commit();
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("weiyun.pref.plugin.albumbackup.options", AlbumBackupConst.a).getBoolean(a(paramString, "plugin_enable_state"), false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\weiyun\AlbumBackupInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */