package cooperation.weiyun;

import android.os.Build.VERSION;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class AlbumBackupConst
{
  public static final int a;
  public static final String a = "Weiyun.AlbumBackup";
  public static final String b = "weiyun.pref.plugin.albumbackup.options";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (Build.VERSION.SDK_INT >= 11) {}
    for (int i = 4;; i = 0)
    {
      a = i;
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\weiyun\AlbumBackupConst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */