package com.tencent.biz.qrcode.activity;

import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class QRCardActivity$NumberSpan
  extends URLSpan
{
  public QRCardActivity$NumberSpan(QRCardActivity paramQRCardActivity, String paramString)
  {
    super(paramString);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    String str = getURL();
    if (!TextUtils.isEmpty(str))
    {
      if (!Pattern.compile("\\d{5,}").matcher(str).matches()) {
        break label42;
      }
      QRCardActivity.a(this.a, paramView.getContext(), 3, str, null);
    }
    label42:
    while (!Pattern.compile(QRCardActivity.t).matcher(str).matches()) {
      return;
    }
    this.a.a(str);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(this.a.d);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\qrcode\activity\QRCardActivity$NumberSpan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */