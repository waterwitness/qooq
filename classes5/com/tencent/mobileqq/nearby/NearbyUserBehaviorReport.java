package com.tencent.mobileqq.nearby;

import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;

public class NearbyUserBehaviorReport
{
  public static final int a = 0;
  public static final String a = "actNearbyUserBehavior";
  public static final boolean a = false;
  public static final int b = 1;
  public static final String b = "param_OPS";
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  public static final int h = 7;
  public static final int i = 8;
  public static final int j = 9;
  public static final int k = 10;
  public static final int l = 11;
  private long jdField_a_of_type_Long;
  private int[] jdField_a_of_type_ArrayOfInt;
  private int m;
  private int n;
  
  public NearbyUserBehaviorReport()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.m = 0;
    this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    this.n = 0;
    this.jdField_a_of_type_ArrayOfInt = new int[11];
    DatingUtil.a("NearbyUserBehaviorReport", new Object[] { "init", Long.valueOf(this.jdField_a_of_type_Long) });
  }
  
  public void a(int paramInt)
  {
    if ((paramInt == 0) && (this.n != 0)) {
      b(2);
    }
    this.n = paramInt;
  }
  
  public void a(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null)
    {
      DatingUtil.b("NearbyUserBehaviorReport", new Object[] { "doReport app is null" });
      return;
    }
    long l1 = Math.abs(NetConnInfoCenter.getServerTimeMillis() - this.jdField_a_of_type_Long) / 1000L;
    StringBuilder localStringBuilder = new StringBuilder(22);
    int i1 = 0;
    while (i1 < 11)
    {
      if (i1 > 0) {
        localStringBuilder.append('-');
      }
      localStringBuilder.append(this.jdField_a_of_type_ArrayOfInt[i1]);
      i1 += 1;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_OPS", localStringBuilder.toString());
    StatisticCollector.a(BaseApplicationImpl.getContext()).a(paramAppInterface.a(), "actNearbyUserBehavior", true, l1, this.m, localHashMap, "");
    DatingUtil.a("NearbyUserBehaviorReport", new Object[] { "doReport", Long.valueOf(l1), Integer.valueOf(this.m), localStringBuilder });
  }
  
  public void b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 11))
    {
      this.m += 1;
      this.jdField_a_of_type_ArrayOfInt[paramInt] = (paramInt + 1);
    }
    DatingUtil.a("NearbyUserBehaviorReport", new Object[] { "addOps", Integer.valueOf(paramInt), this.jdField_a_of_type_ArrayOfInt });
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\NearbyUserBehaviorReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */