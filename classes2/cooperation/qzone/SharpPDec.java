package cooperation.qzone;

import android.content.Context;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.startup.step.UpdateAvSo;
import com.tencent.qphone.base.util.QLog;

public class SharpPDec
{
  private static int a = -1;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private native int GetVersion();
  
  public static int a(Context paramContext)
  {
    int i = b(paramContext);
    QLog.i("-------cooperation.SharpPDec", 1, "------version:" + i);
    if (i >= 12) {
      return 1;
    }
    return 0;
  }
  
  private static boolean a(Context paramContext, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (!UpdateAvSo.a(paramContext, paramString)) {
        return false;
      }
      bool1 = bool2;
      bool2 = UpdateAvSo.a(paramContext, paramString, true);
      bool1 = bool2;
      QLog.i("-------cooperation.SharpPDec", 4, "load from qq original");
      return bool2;
    }
    catch (UnsatisfiedLinkError paramContext)
    {
      paramContext.printStackTrace();
    }
    return bool1;
  }
  
  public static int b(Context paramContext)
  {
    int i = -1;
    if (a != -1) {
      i = a;
    }
    for (;;)
    {
      return i;
      try
      {
        if (!a(paramContext, "TcHevcDec")) {
          continue;
        }
        a = new SharpPDec().GetVersion();
        return a;
      }
      catch (UnsatisfiedLinkError paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\SharpPDec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */