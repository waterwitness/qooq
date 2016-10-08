package com.tencent.biz.qqstory.takevideo.publish;

import android.app.Activity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public class GenerateBackgroundMusicArgs
{
  public final int a;
  public final String a;
  public final WeakReference a;
  public final boolean a;
  public final int b;
  
  public GenerateBackgroundMusicArgs(Activity paramActivity, String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public String toString()
  {
    return "GenerateArgs[backgroundMusic:" + this.jdField_a_of_type_JavaLangString + "]";
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\publish\GenerateBackgroundMusicArgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */