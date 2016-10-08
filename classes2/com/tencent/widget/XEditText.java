package com.tencent.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class XEditText
  extends EditText
{
  public XEditText(Context paramContext)
  {
    super(paramContext);
  }
  
  public XEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    InputConnection localInputConnection = super.onCreateInputConnection(paramEditorInfo);
    if ((localInputConnection != null) && ((getInputType() & 0x20000) == 131072) && (getImeOptions() != 0))
    {
      paramEditorInfo.imeOptions &= 0xBFFFFFFF;
      paramEditorInfo.inputType &= 0xFFFDFFFF;
    }
    return localInputConnection;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\XEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */