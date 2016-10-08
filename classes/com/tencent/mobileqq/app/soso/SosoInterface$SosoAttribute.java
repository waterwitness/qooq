package com.tencent.mobileqq.app.soso;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class SosoInterface$SosoAttribute
{
  public String a;
  public boolean a;
  public String b;
  public String c;
  public String d;
  
  public SosoInterface$SosoAttribute(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public SosoAttribute a()
  {
    return new SosoAttribute(this.jdField_a_of_type_JavaLangString, this.b, this.c, this.d, this.jdField_a_of_type_Boolean);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\soso\SosoInterface$SosoAttribute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */