package com.tencent.mobileqq.app.fms;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class SearchCostStatistics
{
  public static final String a = "SearchMessageStatistic_FTS";
  public static final String b = "SearchMessageStatistic";
  public static final String c = "RecentSearchStatistic";
  public int a;
  public long a;
  public int b;
  public int c;
  public int d;
  
  public SearchCostStatistics()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("M_size=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(",C_size=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",R_size=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",K_len=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",time=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\fms\SearchCostStatistics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */