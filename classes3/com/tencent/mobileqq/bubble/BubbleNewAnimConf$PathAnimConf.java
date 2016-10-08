package com.tencent.mobileqq.bubble;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class BubbleNewAnimConf$PathAnimConf
  extends BubbleNewAnimConf
{
  public float a;
  public boolean a;
  public float b;
  public boolean b;
  public float c;
  public float d;
  public float e;
  public float f;
  public int f;
  public float g;
  public int g;
  public float h;
  public int h;
  public int i;
  public int j;
  public int k;
  
  public BubbleNewAnimConf$PathAnimConf()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = 100;
    this.jdField_h_of_type_Int = 100;
    this.k = 1;
  }
  
  public PathAnimConf a()
  {
    PathAnimConf localPathAnimConf = new PathAnimConf();
    localPathAnimConf.jdField_a_of_type_Float = this.c;
    localPathAnimConf.jdField_b_of_type_Float = this.jdField_d_of_type_Float;
    localPathAnimConf.c = this.jdField_a_of_type_Float;
    localPathAnimConf.jdField_d_of_type_Float = this.jdField_b_of_type_Float;
    this.jdField_a_of_type_JavaLangString += "reverse";
    boolean bool;
    if (!this.jdField_a_of_type_Boolean)
    {
      bool = true;
      localPathAnimConf.jdField_a_of_type_Boolean = bool;
      localPathAnimConf.jdField_e_of_type_Int = this.jdField_e_of_type_Int;
      localPathAnimConf.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localPathAnimConf.jdField_g_of_type_Int = this.jdField_h_of_type_Int;
      localPathAnimConf.jdField_h_of_type_Int = this.jdField_g_of_type_Int;
      localPathAnimConf.i = this.j;
      localPathAnimConf.j = this.i;
      if (!this.jdField_b_of_type_Boolean) {
        break label214;
      }
      localPathAnimConf.jdField_e_of_type_Float = this.jdField_e_of_type_Float;
      localPathAnimConf.jdField_g_of_type_Float = this.jdField_g_of_type_Float;
      localPathAnimConf.jdField_f_of_type_Float = this.jdField_f_of_type_Float;
    }
    for (localPathAnimConf.jdField_h_of_type_Float = this.jdField_h_of_type_Float;; localPathAnimConf.jdField_h_of_type_Float = this.jdField_f_of_type_Float)
    {
      localPathAnimConf.jdField_f_of_type_Int = this.jdField_f_of_type_Int;
      localPathAnimConf.jdField_b_of_type_Boolean = this.jdField_b_of_type_Boolean;
      localPathAnimConf.k = this.k;
      localPathAnimConf.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      localPathAnimConf.jdField_d_of_type_Int = this.jdField_d_of_type_Int;
      return localPathAnimConf;
      bool = false;
      break;
      label214:
      localPathAnimConf.jdField_e_of_type_Float = this.jdField_g_of_type_Float;
      localPathAnimConf.jdField_g_of_type_Float = this.jdField_e_of_type_Float;
      localPathAnimConf.jdField_f_of_type_Float = this.jdField_h_of_type_Float;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\bubble\BubbleNewAnimConf$PathAnimConf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */