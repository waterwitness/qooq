package cooperation.photoplus;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;
import ydl;

public class PhotoPlusModule
  extends QIPCModule
{
  private static PhotoPlusModule a;
  public static final String a = "PhotoPlusModule";
  public static final String b = "PhotoPlusModule";
  public static final String c = "action_get_sticker_templates";
  public static final String d = "action_exit_sticker";
  public static final String e = "param_sticker_templates";
  
  private PhotoPlusModule()
  {
    super("PhotoPlusModule");
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static PhotoPlusModule a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new PhotoPlusModule();
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPlusModule", 2, "[onCall] action = " + paramString + ", params = " + paramBundle + ", callbackId=" + paramInt);
    }
    paramBundle = BaseApplicationImpl.a.a();
    if (!QQAppInterface.class.isInstance(paramBundle)) {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoPlusModule", 2, "[onCall] get app failed.");
      }
    }
    do
    {
      return null;
      paramBundle = (PhotoPlusManager)paramBundle.getManager(168);
      if ("action_get_sticker_templates".equals(paramString))
      {
        paramBundle.b(true);
        ThreadManager.a(new ydl(this, paramBundle, paramInt), null, true);
        return null;
      }
    } while (!"action_exit_sticker".equals(paramString));
    paramBundle.b(false);
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\photoplus\PhotoPlusModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */