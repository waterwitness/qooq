package com.tencent.mobileqq.hotchat.anim;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class HeartAnimator$Config
{
  public static float b = 0.0F;
  public static final int i = 32;
  public static final int k = 27;
  public float a;
  public int a;
  public boolean a;
  public int b;
  public int c = 20;
  public int d = 10;
  public int e = 8;
  public int f = 150;
  public int g = 300;
  public int h = 32;
  public int j = 27;
  public int l = 3000;
  public int m;
  public int n;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_b_of_type_Float = 1.0F;
  }
  
  private HeartAnimator$Config()
  {
    this.jdField_a_of_type_Int = 250;
  }
  
  public HeartAnimator$Config(HeartLayout paramHeartLayout)
  {
    this.jdField_a_of_type_Int = 250;
    this.jdField_a_of_type_Float = paramHeartLayout.getContext().getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Int = ((int)((paramHeartLayout.getWidth() - this.jdField_a_of_type_Float * 32.0F) / 2.0F));
    this.jdField_b_of_type_Int = ((int)(this.jdField_a_of_type_Float * 27.0F));
    this.h = ((int)(this.jdField_a_of_type_Float * 32.0F));
    this.j = ((int)(this.jdField_a_of_type_Float * 27.0F));
    this.c = ((int)(this.jdField_a_of_type_Float * 20.0F));
    this.d = ((int)(this.jdField_a_of_type_Float * 10.0F));
    this.f = ((int)(this.jdField_a_of_type_Float * 150.0F));
    this.g = ((int)(this.jdField_a_of_type_Float * 300.0F));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\hotchat\anim\HeartAnimator$Config.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */