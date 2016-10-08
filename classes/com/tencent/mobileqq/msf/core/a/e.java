package com.tencent.mobileqq.msf.core.a;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.f;
import com.tencent.mobileqq.msf.core.w;
import com.tencent.mobileqq.msf.sdk.l;
import com.tencent.msf.service.protocol.serverconfig.k;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class e
  extends Thread
{
  e(d paramd, String paramString1, String paramString2)
  {
    super(paramString1);
  }
  
  public void run()
  {
    for (;;)
    {
      com.tencent.msf.service.protocol.serverconfig.a locala;
      Object localObject;
      try
      {
        locala = (com.tencent.msf.service.protocol.serverconfig.a)d.a(this.b).k();
        if (QLog.isColorLevel()) {
          QLog.i("MSF.C.SsoListManager", 2, "zip file start");
        }
        localObject = f.a(locala.b.a, locala.b.b, locala.b.c, locala.b.d, locala.c.a, locala.c.b, locala.c.c, locala.c.d, this.a);
        if (QLog.isColorLevel()) {
          QLog.i("MSF.C.SsoListManager", 2, "zip file finish");
        }
        com.tencent.mobileqq.msf.core.b.a.a(com.tencent.mobileqq.msf.core.b.a.i, this.a, com.tencent.mobileqq.msf.core.b.a.e, false, new Object[0]);
        if (localObject == null) {
          continue;
        }
        localObject = new File((String)localObject);
        boolean bool = ((File)localObject).exists();
        if (!bool) {
          break label278;
        }
      }
      catch (Exception localException1) {}
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("MSF.C.SsoListManager", 2, "report file start");
        }
        f.a(this.b.j.sender.f(), (File)localObject, locala.f, this.a);
        if (QLog.isColorLevel()) {
          QLog.i("MSF.C.SsoListManager", 2, "report file finish");
        }
      }
      catch (Exception localException2)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("MSF.C.SsoListManager", 2, "report log error " + localException2, localException2);
        continue;
      }
      ((File)localObject).deleteOnExit();
      continue;
      if (QLog.isColorLevel())
      {
        QLog.w("MSF.C.SsoListManager", 2, "handle report log error " + localException1, localException1);
        continue;
        label278:
        if (QLog.isColorLevel()) {
          QLog.w("MSF.C.SsoListManager", 2, "zip file not existed.");
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\core\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */