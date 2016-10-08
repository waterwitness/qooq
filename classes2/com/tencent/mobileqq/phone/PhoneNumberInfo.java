package com.tencent.mobileqq.phone;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class PhoneNumberInfo
{
  public String a;
  public String b;
  public String c;
  
  public PhoneNumberInfo(String paramString1, String paramString2, String paramString3)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  public String toString()
  {
    return "PhoneInfo{countryCode='" + this.a + '\'' + ", areaCode='" + this.b + '\'' + ", rawPhoneNum='" + this.c + '\'' + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\phone\PhoneNumberInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */