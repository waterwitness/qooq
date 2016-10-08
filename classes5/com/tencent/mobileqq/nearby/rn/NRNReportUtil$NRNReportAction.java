package com.tencent.mobileqq.nearby.rn;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class NRNReportUtil$NRNReportAction
{
  public int a;
  public long a;
  public BaseBusi a;
  public String a;
  public boolean a;
  public long[] a;
  public long b;
  public String b;
  
  public NRNReportUtil$NRNReportAction(String paramString1, String paramString2, BaseBusi paramBaseBusi, long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqNearbyRnBaseBusi = paramBaseBusi;
  }
  
  public NRNReportUtil$NRNReportAction(String paramString1, String paramString2, BaseBusi paramBaseBusi, boolean paramBoolean, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqNearbyRnBaseBusi = paramBaseBusi;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(40);
    localStringBuilder.append("[tag=").append(this.jdField_a_of_type_JavaLangString).append(",uin=").append(this.jdField_b_of_type_JavaLangString).append(",busi=").append(this.jdField_a_of_type_ComTencentMobileqqNearbyRnBaseBusi).append(",suc=").append(this.jdField_a_of_type_Boolean).append(",errorCode=").append(this.jdField_a_of_type_Int).append(",cost=").append(this.jdField_a_of_type_Long).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\rn\NRNReportUtil$NRNReportAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */