package com.tencent.mobileqq.persistence.fts;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class FTSQueryArgs
{
  public int a;
  public String a;
  public boolean a;
  public String[] a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  
  public FTSQueryArgs(String paramString, Class paramClass, String[] paramArrayOfString, boolean paramBoolean, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
    this.jdField_a_of_type_Int = 0;
    this.b = -1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.c = paramClass.getName().replace('.', '/');
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\persistence\fts\FTSQueryArgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */