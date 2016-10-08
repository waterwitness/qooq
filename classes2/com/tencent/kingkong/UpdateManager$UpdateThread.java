package com.tencent.kingkong;

import android.os.Looper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import kfc;

public class UpdateManager$UpdateThread
  extends Thread
{
  public static final String a = "PATCH_JSON_STRING";
  public static final String b = "PATCH_FORCE_UPDATE";
  private kfc a;
  
  public UpdateManager$UpdateThread()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Looper.prepare();
    this.a = new kfc();
    Looper.loop();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\kingkong\UpdateManager$UpdateThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */