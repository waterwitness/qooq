package com.tencent.tmdownloader.internal.b;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.tmassistant.common.jce.GetCallerSettingRequest;
import com.tencent.tmassistant.common.jce.GetCallerSettingResponse;
import com.tencent.tmassistantbase.a.m;

public class a
  implements com.tencent.tmdownloader.internal.c.b
{
  protected static a a = null;
  protected static final String b = a.class.getSimpleName();
  protected com.tencent.tmdownloader.internal.c.a c = null;
  protected SharedPreferences d = null;
  protected Handler e = null;
  
  public static a a()
  {
    try
    {
      if (a == null) {
        a = new a();
      }
      a locala = a;
      return locala;
    }
    finally {}
  }
  
  public void a(GetCallerSettingRequest paramGetCallerSettingRequest, GetCallerSettingResponse paramGetCallerSettingResponse, boolean paramBoolean)
  {
    this.c = null;
    if (paramBoolean) {
      if ((paramGetCallerSettingResponse != null) && (paramGetCallerSettingResponse.ret == 0)) {
        if (this.d != null)
        {
          m.c(b, "response  isSwitch = " + paramGetCallerSettingResponse.isSwitch + ",beginTime = " + paramGetCallerSettingResponse.beginTime + ",endTime = " + paramGetCallerSettingResponse.endTime);
          paramGetCallerSettingRequest = this.d.edit();
          paramGetCallerSettingRequest.putInt("setting_key_switch", paramGetCallerSettingResponse.isSwitch);
          paramGetCallerSettingRequest.putLong("setting_key_begin_time", paramGetCallerSettingResponse.beginTime);
          paramGetCallerSettingRequest.putLong("setting_key_end_time", paramGetCallerSettingResponse.endTime);
          paramGetCallerSettingRequest.commit();
        }
      }
    }
    for (;;)
    {
      c();
      return;
      m.c(b, "onCallerSettingHttpRequestFinish response is null !");
      continue;
      m.c(b, "onCallerSettingHttpRequestFinish failed!");
    }
  }
  
  public void b()
  {
    if (this.c != null) {
      return;
    }
    this.c = new com.tencent.tmdownloader.internal.c.a();
    this.c.a(this);
    this.c.b();
    m.c(b, "send CallerSettingHttpRequest!");
  }
  
  public void c()
  {
    long l3 = System.currentTimeMillis();
    int i;
    long l2;
    if (this.d != null)
    {
      i = this.d.getInt("setting_key_switch", 1);
      l2 = this.d.getLong("setting_key_begin_time", 0L);
    }
    for (long l1 = this.d.getLong("setting_key_end_time", 0L);; l1 = 0L)
    {
      if ((i == 0) && (l2 < l1))
      {
        double d1 = Math.random();
        l3 = l2 % 86400000L - l3 % 86400000L;
        if (l3 > 0L)
        {
          l1 = ((l1 - l2) * d1) + l3;
          m.c(b, "tmp = " + l3 + ",delayMillis = " + l1);
          this.e.postDelayed(new b(this), l1);
        }
      }
      return;
      l2 = 0L;
      i = 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmdownloader\internal\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */