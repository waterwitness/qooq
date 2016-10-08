package com.tencent.mobileqq.vas;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.unique;

public class SignatureTemplateInfo
{
  public int a;
  public SignatureTemplateInfo.ImageItem a;
  @unique
  public String a;
  public SignatureTemplateInfo.DynamicItem[] a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  public String p;
  public String q;
  public String r;
  public String s;
  
  public SignatureTemplateInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SignatureTemplateInfo(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if (paramString.equals("0"))
    {
      this.jdField_b_of_type_JavaLangString = "默认模板";
      this.jdField_a_of_type_Int = 1;
      this.jdField_b_of_type_Int = -1;
      this.e = "#000000";
      this.p = "#000000";
    }
    this.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem = new SignatureTemplateInfo.DynamicItem[5];
    int i1 = 0;
    while (i1 < 5)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[i1] = new SignatureTemplateInfo.DynamicItem(this);
      i1 += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vas\SignatureTemplateInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */