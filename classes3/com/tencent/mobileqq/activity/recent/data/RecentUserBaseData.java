package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class RecentUserBaseData
  extends RecentBaseData
{
  protected static final String h = "%s,%s,%d条未读,%s";
  protected static final String i = "%s,%s,%s";
  public RecentUser a;
  
  public RecentUserBaseData(RecentUser paramRecentUser)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (paramRecentUser == null) {
      throw new NullPointerException("RecentUser is null");
    }
    this.a = paramRecentUser;
    switch (this.a.type)
    {
    }
    for (;;)
    {
      d();
      this.K &= 0xFF0F;
      if (this.a.showUpTime != 0L) {
        break;
      }
      this.K |= 0x10;
      return;
      this.K |= 0x1000;
      continue;
      this.K |= 0x2000;
    }
    this.K |= 0x20;
  }
  
  public int a()
  {
    return this.a.type;
  }
  
  public long a()
  {
    return this.a.lastmsgtime;
  }
  
  public RecentUser a()
  {
    return this.a;
  }
  
  public String a()
  {
    return this.a.uin;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.K &= 0xFF0F;
    if ((this.a.showUpTime == 0L) && (Long.MAX_VALUE - this.a.lastmsgtime > 4L))
    {
      this.K |= 0x10;
      return;
    }
    this.K |= 0x20;
  }
  
  public void a(RecentUser paramRecentUser)
  {
    this.a = paramRecentUser;
  }
  
  public final boolean a()
  {
    return (this.G == 1) || (this.G == 4);
  }
  
  public long b()
  {
    return this.a.lastmsgdrafttime;
  }
  
  public int c()
  {
    return this.a.msgType;
  }
  
  public String c()
  {
    return this.a.troopUin;
  }
  
  public int d()
  {
    return this.K;
  }
  
  public void d()
  {
    switch (this.a.type)
    {
    }
    do
    {
      return;
    } while (!a());
    this.K &= 0xFFF0FFFF;
    if (this.H != 0)
    {
      this.K |= 0x10000;
      return;
    }
    this.K |= 0x20000;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\data\RecentUserBaseData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */