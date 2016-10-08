package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.biz.lebasearch.SearchProtocol.WordItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import icf;
import java.util.Iterator;
import java.util.List;

public class ReadInJoySearchTipsContainer
  extends ViewGroup
  implements View.OnClickListener
{
  private static final int jdField_a_of_type_Int = 14;
  private static final int jdField_b_of_type_Int = 20;
  private static final int c = 20;
  private static final int d = 15;
  private static final int e = 12;
  private static final int f = 16;
  private static final int g = 16;
  private static final int h = 5;
  public ReadInJoySearchTipsContainer.OnTipClickListener a;
  private List jdField_a_of_type_JavaUtilList;
  private List jdField_b_of_type_JavaUtilList;
  private int i;
  private int j;
  
  public ReadInJoySearchTipsContainer(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.i = ViewUtils.a(260.0F);
    this.j = 5;
    a();
  }
  
  public ReadInJoySearchTipsContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.i = ViewUtils.a(260.0F);
    this.j = 5;
    a();
  }
  
  private void a()
  {
    this.i = (getResources().getDisplayMetrics().widthPixels / 2);
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if ((paramString1 != null) && (TextUtils.isEmpty(paramString1.trim()))) {
      return;
    }
    Button localButton = new Button(getContext());
    localButton.setBackgroundResource(2130842847);
    GradientDrawable localGradientDrawable = (GradientDrawable)((android.graphics.drawable.DrawableContainer.DrawableContainerState)((android.graphics.drawable.StateListDrawable)localButton.getBackground()).getConstantState()).getChildren()[1];
    if (paramInt2 != 0)
    {
      localGradientDrawable.setStroke(1, paramInt2);
      localButton.setPadding(ViewUtils.a(15.0F), ViewUtils.a(5.0F), ViewUtils.a(15.0F), ViewUtils.a(6.0F));
      localButton.setText(paramString1);
      localButton.setTextSize(14.0F);
      localButton.setSingleLine();
      localButton.setEllipsize(TextUtils.TruncateAt.valueOf("MIDDLE"));
      localButton.setMaxWidth(this.i);
      if (paramInt1 == 0) {
        break label182;
      }
    }
    for (;;)
    {
      localButton.setTextColor(paramInt1);
      localButton.setOnClickListener(this);
      localButton.setTag(paramString1);
      if (!TextUtils.isEmpty(paramString2)) {
        localButton.setContentDescription(paramString2);
      }
      super.addView(localButton);
      return;
      paramInt2 = -3355444;
      break;
      label182:
      paramInt1 = -16777216;
    }
  }
  
  protected int a(int paramInt)
  {
    int i8 = (int)DisplayUtils.a(getContext(), 15.0F);
    int i3 = (int)DisplayUtils.a(getContext(), 20.0F);
    int i9 = (int)DisplayUtils.a(getContext(), 20.0F);
    int i10 = (int)DisplayUtils.a(getContext(), 12.0F);
    int i1 = (int)DisplayUtils.a(getContext(), 16.0F);
    int i11 = (int)DisplayUtils.a(getContext(), 16.0F);
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
  
  public void a(List paramList)
  {
    removeAllViews();
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ReadInJoySearchTipsContainer.TipsInfo localTipsInfo = (ReadInJoySearchTipsContainer.TipsInfo)paramList.next();
      a(localTipsInfo.word, localTipsInfo.textColor, localTipsInfo.frameColor, localTipsInfo.contentDescription);
    }
  }
  
  public void b(List paramList)
  {
    removeAllViews();
    this.b = paramList;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SearchProtocol.WordItem localWordItem = (SearchProtocol.WordItem)paramList.next();
      a(localWordItem.word, localWordItem.textColor, localWordItem.textColor, localWordItem.contentDescription);
    }
  }
  
  public void onClick(View paramView)
  {
    icf localicf = new icf(this, Looper.getMainLooper());
    Message localMessage = localicf.obtainMessage();
    localMessage.obj = paramView.getTag();
    localicf.sendMessage(localMessage);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i4 = (int)DisplayUtils.a(getContext(), 15.0F);
    int n = (int)DisplayUtils.a(getContext(), 20.0F);
    int i5 = (int)DisplayUtils.a(getContext(), 12.0F);
    paramInt4 = (int)DisplayUtils.a(getContext(), 16.0F);
    int i6 = (int)DisplayUtils.a(getContext(), 16.0F);
    int i7 = getChildCount();
    int k = 0;
    int m = 1;
    paramInt2 = paramInt4;
    for (;;)
    {
      View localView;
      int i8;
      int i9;
      int i3;
      int i1;
      if (k < i7)
      {
        localView = getChildAt(k);
        i8 = localView.getMeasuredWidth();
        i9 = localView.getMeasuredHeight();
        i3 = m;
        i1 = n;
        i2 = paramInt2;
        if (paramInt2 + i8 <= paramInt3 - paramInt1 - i6) {
          break label159;
        }
        i1 = n + (i9 + i4);
        i3 = m + 1;
        if (i3 <= this.j) {}
      }
      else
      {
        return;
      }
      int i2 = paramInt4;
      label159:
      localView.layout(i2, i1, i8 + i2, i9 + i1);
      k += 1;
      paramInt2 = i5 + i8 + i2;
      m = i3;
      n = i1;
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
  
  public void setOnTipsClickListener(ReadInJoySearchTipsContainer.OnTipClickListener paramOnTipClickListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer$OnTipClickListener = paramOnTipClickListener;
  }
  
  public void setmMaxLines(int paramInt)
  {
    this.j = paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\view\ReadInJoySearchTipsContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */