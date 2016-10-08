package com.tencent.mobileqq.structmsg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class AbsStructMsgTextElement$RichText
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public int c;
  public int d;
  public int e;
  public int f;
  
  public AbsStructMsgTextElement$RichText()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected RichText a()
  {
    RichText localRichText = new RichText();
    localRichText.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localRichText.b = this.b;
    localRichText.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localRichText.d = this.d;
    localRichText.e = this.e;
    localRichText.f = this.f;
    localRichText.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    return localRichText;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\AbsStructMsgTextElement$RichText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */