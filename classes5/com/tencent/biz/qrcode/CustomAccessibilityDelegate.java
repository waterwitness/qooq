package com.tencent.biz.qrcode;

import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityNodeProvider;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import jaj;

public class CustomAccessibilityDelegate
  extends View.AccessibilityDelegate
{
  private static final String jdField_a_of_type_JavaLangString = "AccessibilityDelegate";
  private View jdField_a_of_type_AndroidViewView;
  private CustomAccessibilityDelegate.CallBack jdField_a_of_type_ComTencentBizQrcodeCustomAccessibilityDelegate$CallBack;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  
  public CustomAccessibilityDelegate(View paramView, CustomAccessibilityDelegate.CallBack paramCallBack)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRunnable = new jaj(this);
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentBizQrcodeCustomAccessibilityDelegate$CallBack = paramCallBack;
  }
  
  public AccessibilityNodeProvider getAccessibilityNodeProvider(View paramView)
  {
    return new CustomAccessibilityDelegate.FocusNextAccessibiltyProvider(this);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\qrcode\CustomAccessibilityDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */