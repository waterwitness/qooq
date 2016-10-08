package com.tencent.mobileqq.msf.core.net;

import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class k
  extends Thread
{
  k(h paramh) {}
  
  public void a()
  {
    Looper.myLooper().quit();
  }
  
  public void run()
  {
    try
    {
      
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "tcpdump Report show toast begin");
      }
      Toast.makeText(BaseApplication.getContext(), "有网络异常抓包文件，请rtx bobbyzhang,thx!", 1).show();
      new Handler().postDelayed(new l(this), 20000L);
      Looper.loop();
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "tcpdump Report show toast end");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "tcpdump Report exception" + localException, localException);
        }
      }
    }
    this.a.z = false;
    this.a.A = null;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\core\net\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */