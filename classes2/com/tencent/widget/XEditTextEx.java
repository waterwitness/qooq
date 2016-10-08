package com.tencent.widget;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class XEditTextEx
  extends XEditText
{
  private static final String jdField_a_of_type_JavaLangString = XEditTextEx.class.getSimpleName();
  private XEditTextEx.OnPrivateIMECommandListener jdField_a_of_type_ComTencentWidgetXEditTextEx$OnPrivateIMECommandListener;
  public XEditTextEx.SizeChangedCallback a;
  public Object a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public XEditTextEx(Context paramContext)
  {
    super(paramContext);
  }
  
  public XEditTextEx(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    String str = TextUtils.c(getText().toString());
    paramAccessibilityNodeInfo.setText(str);
    paramAccessibilityNodeInfo.setContentDescription(str);
  }
  
  public boolean onPrivateIMECommand(String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "onPrivateIMECommand(), action:" + paramString + " data:" + paramBundle);
    }
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx$OnPrivateIMECommandListener != null) {
      return this.jdField_a_of_type_ComTencentWidgetXEditTextEx$OnPrivateIMECommandListener.a(paramString, paramBundle);
    }
    return super.onPrivateIMECommand(paramString, paramBundle);
  }
  
  public void setOnPrivateIMECommandListener(XEditTextEx.OnPrivateIMECommandListener paramOnPrivateIMECommandListener)
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx$OnPrivateIMECommandListener = paramOnPrivateIMECommandListener;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\XEditTextEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */