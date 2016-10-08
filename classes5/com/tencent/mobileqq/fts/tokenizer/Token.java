package com.tencent.mobileqq.fts.tokenizer;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class Token
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString;
  private int c;
  
  public Token(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_JavaLangString = "word";
    this.c = 1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public Token(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this.jdField_b_of_type_JavaLangString = "word";
    this.c = 1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  public int a()
  {
    return this.c;
  }
  
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("Increment must be zero or greater: " + paramInt);
    }
    this.c = paramInt;
  }
  
  public final int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public final String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public final int c()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("(" + this.jdField_a_of_type_JavaLangString + "," + this.jdField_a_of_type_Int + "," + this.jdField_b_of_type_Int);
    if (!this.jdField_b_of_type_JavaLangString.equals("word")) {
      localStringBuffer.append(",type=" + this.jdField_b_of_type_JavaLangString);
    }
    if (this.c != 1) {
      localStringBuffer.append(",posIncr=" + this.c);
    }
    localStringBuffer.append(")");
    return localStringBuffer.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\fts\tokenizer\Token.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */