package com.tencent.biz.qqstory.takevideo.label;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.EmoticonUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class QQStoryAddVideoLabelViewPart$EditTextWatcher
  implements TextWatcher
{
  public QQStoryAddVideoLabelViewPart$EditTextWatcher(QQStoryAddVideoLabelViewPart paramQQStoryAddVideoLabelViewPart)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    String str = EmoticonUtils.a(paramEditable.toString(), 30);
    if (str.length() < paramEditable.length()) {
      paramEditable.replace(0, paramEditable.length(), str);
    }
    this.a.b = paramEditable.toString();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    paramCharSequence = paramCharSequence.toString();
    this.a.b = paramCharSequence;
    SLog.b("Q.qqstory.record.label.QQStoryAddVideoLabelView", "keyword = " + this.a.b);
    if (this.a.a != null) {
      this.a.a.a(this.a.b);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\label\QQStoryAddVideoLabelViewPart$EditTextWatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */