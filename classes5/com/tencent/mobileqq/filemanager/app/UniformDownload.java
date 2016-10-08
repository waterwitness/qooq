package com.tencent.mobileqq.filemanager.app;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import rwf;

public class UniformDownload
{
  public static final String a = "UniformDownloadMgr<FileAssistant>";
  public static boolean a = false;
  public static final String b = "_filesize";
  public static final String c = "_filetype";
  public static final String d = "_buttontype";
  public static final String e = "param_user_agent";
  public static final String f = "param_content_des";
  public static final String g = "param_mime_type";
  public static final String h = "param_refer_url";
  public static final String i = "param_source_id";
  public static final String j = "param_content_memo";
  public static final String k = "param_icon_path";
  public static final String l = "param_isqbdownload";
  public Activity a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Boolean = true;
  }
  
  private UniformDownload(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public static void a(Activity paramActivity, String paramString, Bundle paramBundle)
  {
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL]. >>>gotoDownload. url:" + paramString);
    if ((paramActivity == null) || (paramString == null) || (paramBundle == null))
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL]. gotoDownload. param error:");
      return;
    }
    new UniformDownload(paramActivity).a(paramString, paramBundle);
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    UniformDownloadUtil.a(paramString, new rwf(this, paramBundle, paramString, paramBundle.getLong("_filesize"), paramBundle.getLong("_buttontype", 0L)));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\app\UniformDownload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */