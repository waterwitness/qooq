package com.tencent.mobileqq.msf.core.c;

import com.tencent.feedback.eup.CrashHandleListener;
import com.tencent.qphone.base.util.QLog;

class o
  implements CrashHandleListener
{
  o(m paramm) {}
  
  public byte[] getCrashExtraData(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong)
  {
    return null;
  }
  
  public String getCrashExtraMessage(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.StatReport", 2, "getCrashExtraMessage." + m.a(this.a).toString());
    }
    return m.a(this.a).toString();
  }
  
  public boolean onCrashHandleEnd(boolean paramBoolean)
  {
    return true;
  }
  
  public void onCrashHandleStart(boolean paramBoolean)
  {
    this.a.a();
    this.a.b();
  }
  
  public boolean onCrashSaving(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong, String paramString4, String paramString5, String paramString6)
  {
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\core\c\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */