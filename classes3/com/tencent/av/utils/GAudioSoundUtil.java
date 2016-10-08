package com.tencent.av.utils;

import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class GAudioSoundUtil
{
  public static final String a = "qav_gaudio_muted.mp3";
  public static final String b = "qav_gaudio_cancel_muted.mp3";
  public static final String c = "qav_peer_phone_calling.mp3";
  private static final String d = "GAudioSoundUtil";
  
  public GAudioSoundUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a()
  {
    File localFile = BaseApplicationImpl.a.getFilesDir();
    if (localFile == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("GAudioSoundUtil", 2, "[sound_early] getFilesDir is null");
      }
      return "";
    }
    return localFile.getParent() + "/qav/sound_early/";
  }
  
  public static void a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GAudioSoundUtil", 2, "[sound_early] trigger early download");
    }
    Object localObject2 = a();
    Object localObject1 = new File((String)localObject2, "qav_gaudio_muted.mp3");
    File localFile = new File((String)localObject2, "qav_gaudio_cancel_muted.mp3");
    localObject2 = new File((String)localObject2, "qav_peer_phone_calling.mp3");
    if ((!((File)localObject1).exists()) || (!localFile.exists()) || (!((File)localObject2).exists()))
    {
      localObject1 = new Intent("tencent.video.v2q.downloadGAudioSound");
      ((Intent)localObject1).setPackage(paramContext.getPackageName());
      paramContext.sendBroadcast((Intent)localObject1);
    }
  }
  
  public static boolean a(String paramString)
  {
    return new File(a(), paramString).exists();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\utils\GAudioSoundUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */