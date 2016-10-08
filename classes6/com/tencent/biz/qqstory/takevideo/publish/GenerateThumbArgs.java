package com.tencent.biz.qqstory.takevideo.publish;

import android.app.Activity;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public class GenerateThumbArgs
{
  public final double a;
  public final float a;
  public final int a;
  public final RMVideoStateMgr a;
  public final String a;
  public final WeakReference a;
  public final double b;
  
  public GenerateThumbArgs(Activity paramActivity, RMVideoStateMgr paramRMVideoStateMgr, String paramString, float paramFloat, int paramInt, double paramDouble1, double paramDouble2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr = paramRMVideoStateMgr;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Double = paramDouble1;
    this.b = paramDouble2;
  }
  
  public String toString()
  {
    return "GenerateThumbArgs{mFileDir='" + this.jdField_a_of_type_JavaLangString + '\'' + ", mRatioWH=" + this.jdField_a_of_type_Float + ", mOrientation=" + this.jdField_a_of_type_Int + ", mLatitude=" + this.jdField_a_of_type_Double + ", mLongitude=" + this.b + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\publish\GenerateThumbArgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */