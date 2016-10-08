package com.tencent.biz.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class MultiActionDoneEditText
  extends EditText
{
  public MultiActionDoneEditText(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public MultiActionDoneEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    InputConnection localInputConnection = super.onCreateInputConnection(paramEditorInfo);
    int i = paramEditorInfo.imeOptions & 0xFF;
    if ((i & 0x6) != 0)
    {
      paramEditorInfo.imeOptions = (i ^ paramEditorInfo.imeOptions);
      paramEditorInfo.imeOptions |= 0x6;
    }
    if ((paramEditorInfo.imeOptions & 0x40000000) != 0) {
      paramEditorInfo.imeOptions &= 0xBFFFFFFF;
    }
    return localInputConnection;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\widgets\MultiActionDoneEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */