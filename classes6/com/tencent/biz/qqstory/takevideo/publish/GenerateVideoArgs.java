package com.tencent.biz.qqstory.takevideo.publish;

import android.app.Activity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public class GenerateVideoArgs
{
  public final double a;
  public final int a;
  public final String a;
  public final WeakReference a;
  public final int b;
  public final int c;
  public final int d;
  
  public GenerateVideoArgs(Activity paramActivity, String paramString, int paramInt1, int paramInt2, double paramDouble, int paramInt3, int paramInt4)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_Double = paramDouble;
    this.c = paramInt3;
    this.d = paramInt4;
  }
  
  public String toString()
  {
    return "GenerateArgs[video:" + this.jdField_a_of_type_JavaLangString + "]";
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\publish\GenerateVideoArgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */