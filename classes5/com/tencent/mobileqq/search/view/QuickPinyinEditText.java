package com.tencent.mobileqq.search.view;

import android.content.Context;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class QuickPinyinEditText
  extends EditText
{
  public static final String a = "com.sohu.inputmethod.sogou.search.enter";
  public static final String b = "com.sohu.inputmethod.sogou.send.input";
  public static final String c = "com.sohu.inputmethod.sogou";
  private static final String d = "QuickPinyinEditText";
  private static String e;
  
  public QuickPinyinEditText(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QuickPinyinEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QuickPinyinEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(String paramString)
  {
    if (paramString == null) {}
    int i;
    int j;
    Editable localEditable;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QuickPinyinEditText", 2, "updateInputtingText : " + paramString);
      }
      i = getSelectionStart();
      j = getSelectionEnd();
      localEditable = getText();
      if (j > i)
      {
        localEditable.replace(i, j, paramString);
        setSelection(i, paramString.length() + i);
        e = paramString;
        return;
      }
    } while (j != i);
    localEditable.insert(i, paramString);
    setSelection(i, paramString.length() + i);
    e = paramString;
  }
  
  private boolean a()
  {
    String str = Settings.Secure.getString(getContext().getContentResolver(), "default_input_method");
    return (str != null) && (str.contains("com.sohu.inputmethod.sogou"));
  }
  
  public void a()
  {
    if ((!TextUtils.isEmpty(e)) && (a()))
    {
      ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).sendAppPrivateCommand(this, "com.sohu.inputmethod.sogou.search.enter", null);
      setSelection(getText().length());
    }
  }
  
  public boolean onPrivateIMECommand(String paramString, Bundle paramBundle)
  {
    if (("com.sohu.inputmethod.sogou.send.input".equals(paramString)) && (a()) && (paramBundle != null)) {
      a(paramBundle.getString("req"));
    }
    return super.onPrivateIMECommand(paramString, paramBundle);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    a();
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\view\QuickPinyinEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */