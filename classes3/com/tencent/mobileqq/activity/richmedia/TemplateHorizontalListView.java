package com.tencent.mobileqq.activity.richmedia;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.OverScroller;

public class TemplateHorizontalListView
  extends HorizontalListView
{
  public TemplateHorizontalListView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public TemplateHorizontalListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected boolean a()
  {
    if (!this.h) {}
    for (;;)
    {
      return false;
      if (getChildAt(0) != null)
      {
        int i = this.i;
        int j = getChildAt(1).getMeasuredWidth();
        int k = i % j;
        if (k <= j * 0.5D) {
          i -= k;
        }
        while (this.a.a(this.i + getScrollX(), 0, i, i, 0, 0))
        {
          invalidate();
          return true;
          i = i - k + j;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\richmedia\TemplateHorizontalListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */