package com.tencent.mobileqq.nearby;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class NearbyReportManager$ReportRecord
{
  public int a;
  public long a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  
  public NearbyReportManager$ReportRecord(long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mTinyID:").append(this.jdField_a_of_type_Long).append(",mPosition:").append(this.jdField_a_of_type_Int).append(",mAlgotithmID:").append(this.b).append(",mEnterCount:").append(this.c).append(",mProfileCardDuration:").append(this.d).append(",mVisitPhotoCount:").append(this.e).append(",mOpflag:").append(this.f).append("|").append(Integer.toBinaryString(this.f));
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\NearbyReportManager$ReportRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */