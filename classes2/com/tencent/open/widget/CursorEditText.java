package com.tencent.open.widget;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.widget.EditText;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class CursorEditText
  extends EditText
{
  protected Class a;
  
  public CursorEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void onSelectionChanged(int paramInt1, int paramInt2)
  {
    int k = 0;
    int j = 0;
    if (this.a == null) {
      return;
    }
    Editable localEditable = super.getEditableText();
    Object[] arrayOfObject = localEditable.getSpans(0, localEditable.length(), this.a);
    int m = arrayOfObject.length;
    int i = 0;
    Object localObject;
    while (i < m)
    {
      localObject = arrayOfObject[i];
      int n = localEditable.getSpanStart(localObject);
      if ((paramInt1 < localEditable.getSpanEnd(localObject)) && (paramInt1 > n))
      {
        i = arrayOfObject.length;
        paramInt1 = j;
        while (paramInt1 < i)
        {
          localObject = arrayOfObject[paramInt1];
          j = localEditable.getSpanStart(localObject);
          k = localEditable.getSpanEnd(localObject);
          if ((paramInt2 < k) && (paramInt2 > j))
          {
            super.setSelection(k);
            return;
          }
          paramInt1 += 1;
        }
        super.setSelection(paramInt2);
        return;
      }
      i += 1;
    }
    j = arrayOfObject.length;
    i = k;
    while (i < j)
    {
      localObject = arrayOfObject[i];
      k = localEditable.getSpanStart(localObject);
      if ((paramInt2 < localEditable.getSpanEnd(localObject)) && (paramInt2 > k))
      {
        super.setSelection(paramInt1);
        return;
      }
      i += 1;
    }
    super.setSelection(paramInt1, paramInt2);
  }
  
  public void setSpannedClassToSkip(Class paramClass)
  {
    this.a = paramClass;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\widget\CursorEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */