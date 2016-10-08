package com.tencent.biz.qqstory.support.report;

import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import iui;

public class MonitorReport
{
  public static final int a = 2444469;
  private static final String a = "Q.qqstory.MonitorReport";
  public static final int b = 2444470;
  public static final int c = 2444471;
  public static final int d = 2444472;
  public static final int e = 2444473;
  public static final int f = 2444474;
  public static final int g = 2444475;
  public static final int h = 2444476;
  
  public MonitorReport()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(int paramInt)
  {
    a(paramInt, 1);
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    b(paramInt1, paramInt2);
  }
  
  private static void b(int paramInt1, int paramInt2)
  {
    MonitorValueRequest localMonitorValueRequest = new MonitorValueRequest();
    localMonitorValueRequest.a(paramInt1, paramInt2);
    CmdTaskManger.a().a(localMonitorValueRequest, new iui());
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\support\report\MonitorReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */