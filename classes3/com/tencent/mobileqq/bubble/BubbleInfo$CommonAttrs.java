package com.tencent.mobileqq.bubble;

import android.graphics.Rect;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Arrays;

public class BubbleInfo$CommonAttrs
{
  public static final int a = 50;
  public static final boolean a = true;
  public static final int b = 1;
  public Rect a;
  public AnimationConfig a;
  public String a;
  public String[] a;
  public String b;
  public boolean b;
  public int c;
  public boolean c;
  public int d;
  public int e;
  public int f;
  public int g;
  
  public BubbleInfo$CommonAttrs()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.d = 1;
    this.jdField_b_of_type_Boolean = true;
    this.e = 50;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.f = -1;
    this.jdField_c_of_type_Boolean = true;
    this.g = 1;
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public String toString()
  {
    return "CommonAttrs [key=" + this.jdField_b_of_type_JavaLangString + ", mRect=" + this.jdField_a_of_type_AndroidGraphicsRect + ", count=" + this.jdField_c_of_type_Int + ", duration=" + this.e + ", align=" + this.f + ", mBigImgPath=" + this.jdField_a_of_type_JavaLangString + ", repeatCount=" + this.d + ", mAnimationPath=" + Arrays.toString(this.jdField_a_of_type_ArrayOfJavaLangString) + "]";
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\bubble\BubbleInfo$CommonAttrs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */