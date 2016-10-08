package com.tencent.tmassistantsdk.internal.c;

import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistant.common.a.b;
import com.tencent.tmassistantbase.a.f;
import com.tencent.tmassistantbase.a.m;
import java.util.ArrayList;
import java.util.List;

public abstract class a
  implements c
{
  protected d a = null;
  protected int b = 0;
  protected final List<byte[]> c = new ArrayList();
  
  public void a()
  {
    this.a = null;
    this.c.clear();
  }
  
  public void a(JceStruct paramJceStruct)
  {
    try
    {
      m.c("BaseReportManager", "enter:" + paramJceStruct);
      if (paramJceStruct != null)
      {
        paramJceStruct = com.tencent.tmassistant.common.a.c(paramJceStruct);
        e().a(paramJceStruct);
      }
      m.c("BaseReportManager", "exit");
      return;
    }
    finally {}
  }
  
  public void a(d paramd, boolean paramBoolean)
  {
    m.c("BaseReportManager", "enter");
    m.c("BaseReportManager", "result:" + paramBoolean);
    if ((!paramBoolean) && (this.c != null) && (this.c.size() > 0))
    {
      m.c("BaseReportManager", "reback DB!");
      e().a(this.c);
    }
    this.a = null;
    this.c.clear();
    if ((paramBoolean) && (g()) && (this.b < 5))
    {
      m.c("BaseReportManager", "reportlog go on,result:" + paramBoolean + " count:" + this.b);
      c();
      this.b += 1;
    }
    m.c("BaseReportManager", "exit");
  }
  
  public void b()
  {
    if (this.a != null)
    {
      this.a.a();
      this.a = null;
    }
  }
  
  public void c()
  {
    try
    {
      m.c("BaseReportManager", "enter");
      if (!f.a().j())
      {
        m.c("BaseReportManager", "Not WiFi");
        m.c("BaseReportManager", "exit");
      }
      for (;;)
      {
        return;
        if (this.a == null) {
          break;
        }
        m.c("BaseReportManager", "reportRequst is sending out");
        m.c("BaseReportManager", "exit");
      }
      this.a = new d();
    }
    finally {}
    this.a.a(this);
    m.c("BaseReportManager", " request:" + this.a + " reportManager:" + getClass().getName());
    b localb = e().a(1000);
    m.c("BaseReportManager", "readLogDataAndSendToServer,wrappterCount:" + localb.b.size());
    if (localb != null) {
      if (localb.b.size() <= 0) {
        break label248;
      }
    }
    for (;;)
    {
      if (!bool) {
        this.a = null;
      }
      m.c("BaseReportManager", "exit");
      break;
      this.c.addAll(localb.b);
      boolean bool = this.a.a(f(), localb);
      e().b(localb.a);
      continue;
      label248:
      bool = false;
    }
  }
  
  public void d()
  {
    this.b = 0;
  }
  
  protected abstract com.tencent.tmassistant.common.a.a e();
  
  protected abstract byte f();
  
  protected abstract boolean g();
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmassistantsdk\internal\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */