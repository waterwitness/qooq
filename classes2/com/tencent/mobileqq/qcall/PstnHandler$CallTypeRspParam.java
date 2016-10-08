package com.tencent.mobileqq.qcall;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class PstnHandler$CallTypeRspParam
{
  public int a;
  public long a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  
  public PstnHandler$CallTypeRspParam(int paramInt1, int paramInt2, long paramLong, String paramString1, String paramString2, String paramString3, int paramInt3, String paramString4, int paramInt4)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_d_of_type_JavaLangString = paramString4;
    this.jdField_d_of_type_Int = paramInt4;
  }
  
  public String toString()
  {
    return "CallTypeRspParam{retCode=" + this.jdField_a_of_type_Int + ", callType=" + this.jdField_b_of_type_Int + ", peerCallId=" + this.jdField_a_of_type_Long + ", callbackId='" + this.jdField_a_of_type_JavaLangString + '\'' + ", callbackPrompt='" + this.jdField_b_of_type_JavaLangString + '\'' + ", callbackPhone='" + this.jdField_c_of_type_JavaLangString + '\'' + ", ability=" + this.jdField_c_of_type_Int + ", toPhone='" + this.jdField_d_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\qcall\PstnHandler$CallTypeRspParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */