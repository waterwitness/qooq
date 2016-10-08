package com.tencent.biz.widgets;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.biz.lebasearch.SearchProtocol.WordItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DisplayUtils;
import java.util.Iterator;
import java.util.List;
import jiw;

public class ActiveSearchTipsContainer
  extends ViewGroup
  implements View.OnClickListener
{
  public static final int a = 1000;
  public static final String a = "ActiveSearchTipsContainer";
  private static final int b = 14;
  private static final int c = 10;
  private static final int d = 10;
  private static final int e = 6;
  private static final int f = 6;
  private static final int g = 15;
  private static final int h = 15;
  private static final int i = 3;
  public ActiveSearchTipsContainer.OnTipClickListener a;
  private List a;
  private int j;
  
  public ActiveSearchTipsContainer(Context paramContext)
  {
    super(paramContext);
    this.j = 3;
  }
  
  public ActiveSearchTipsContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.j = 3;
  }
  
  protected int a(int paramInt)
  {
    int i8 = (int)DisplayUtils.a(getContext(), 6.0F);
    int i3 = (int)DisplayUtils.a(getContext(), 10.0F);
    int i9 = (int)DisplayUtils.a(getContext(), 10.0F);
    int i10 = (int)DisplayUtils.a(getContext(), 6.0F);
    int i1 = (int)DisplayUtils.a(getContext(), 15.0F);
    int i11 = (int)DisplayUtils.a(getContext(), 15.0F);
    int i12 = getChildCount();
    int i2 = 0;
    int n = i1;
    int k = i3;
    int i4 = 1;
    for (;;)
    {
      int m = k;
      int i13;
      int i14;
      int i6;
      if (i2 < i12)
      {
        View localView = getChildAt(i2);
        i13 = localView.getMeasuredWidth();
        i14 = localView.getMeasuredHeight();
        m = k;
        if (i2 == 0) {
          m = k + i14;
        }
        k = m;
        i6 = i4;
        i5 = i3;
        i7 = n;
        if (n + i13 <= paramInt - i11) {
          break label202;
        }
        i6 = i4 + 1;
        if (i6 <= this.j) {}
      }
      else
      {
        return m + i9;
      }
      int i5 = i3 + (i14 + i8);
      k = i5 + i14;
      int i7 = i1;
      label202:
      i2 += 1;
      n = i10 + i13 + i7;
      i4 = i6;
      i3 = i5;
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if ((paramString1 != null) && (TextUtils.isEmpty(paramString1.trim()))) {
      return;
    }
    Button localButton = new Button(getContext());
    localButton.setBackgroundResource(2130839276);
    localButton.setText(paramString1);
    localButton.setTextSize(14.0F);
    if (paramInt != 0) {}
    for (;;)
    {
      localButton.setTextColor(paramInt);
      localButton.setOnClickListener(this);
      localButton.setTag(paramString1);
      if (!TextUtils.isEmpty(paramString2)) {
        localButton.setContentDescription(paramString2);
      }
      super.addView(localButton);
      return;
      paramInt = -16777216;
    }
  }
  
  public void a(List paramList)
  {
    removeAllViews();
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SearchProtocol.WordItem localWordItem = (SearchProtocol.WordItem)paramList.next();
      a(localWordItem.word, localWordItem.textColor, localWordItem.contentDescription);
    }
  }
  
  public void onClick(View paramView)
  {
    jiw localjiw = new jiw(this, Looper.getMainLooper());
    if (localjiw != null)
    {
      Message localMessage = localjiw.obtainMessage();
      localMessage.obj = paramView.getTag();
      localjiw.sendMessage(localMessage);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i3 = (int)DisplayUtils.a(getContext(), 6.0F);
    paramInt2 = (int)DisplayUtils.a(getContext(), 10.0F);
    int i4 = (int)DisplayUtils.a(getContext(), 6.0F);
    int m = (int)DisplayUtils.a(getContext(), 15.0F);
    int i5 = (int)DisplayUtils.a(getContext(), 15.0F);
    int i6 = getChildCount();
    int n = 0;
    paramInt4 = m;
    int k = 1;
    View localView;
    int i7;
    int i8;
    if (n < i6)
    {
      localView = getChildAt(n);
      i7 = localView.getMeasuredWidth();
      i8 = localView.getMeasuredHeight();
      if (paramInt4 + i7 <= paramInt3 - paramInt1 - i5) {
        break label239;
      }
      k += 1;
      if (k <= this.j) {}
    }
    else
    {
      return;
    }
    paramInt4 = paramInt2 + (i8 + i3);
    int i1 = m;
    paramInt2 = k;
    k = i1;
    for (;;)
    {
      localView.layout(k, paramInt4, k + i7, paramInt4 + i8);
      ReportController.b(null, "CliOper", "", "", "0X8004AB3", "0X8004AB3", 0, 0, ((SearchProtocol.WordItem)this.jdField_a_of_type_JavaUtilList.get(n)).id, null, null, null);
      n += 1;
      i1 = k + (i4 + i7);
      k = paramInt2;
      paramInt2 = paramInt4;
      paramInt4 = i1;
      break;
      label239:
      i1 = k;
      int i2 = paramInt2;
      k = paramInt4;
      paramInt2 = i1;
      paramInt4 = i2;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int n = 0;
    int i2 = View.MeasureSpec.getMode(paramInt1);
    int k = View.MeasureSpec.getSize(paramInt1);
    int i1 = View.MeasureSpec.getMode(paramInt2);
    int m = View.MeasureSpec.getSize(paramInt2);
    super.measureChildren(paramInt1, paramInt2);
    switch (i2)
    {
    default: 
      paramInt2 = n;
      paramInt1 = m;
      switch (i1)
      {
      }
      break;
    }
    for (paramInt1 = a(k);; paramInt1 = a(k))
    {
      super.setMeasuredDimension(paramInt2, paramInt1);
      return;
      paramInt2 = k;
      break;
    }
  }
  
  public void setMaxLines(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setOnTipsClickListener(ActiveSearchTipsContainer.OnTipClickListener paramOnTipClickListener)
  {
    this.jdField_a_of_type_ComTencentBizWidgetsActiveSearchTipsContainer$OnTipClickListener = paramOnTipClickListener;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\widgets\ActiveSearchTipsContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */