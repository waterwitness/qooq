package com.tencent.biz.qqstory.storyHome.qqstorylist.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class UGCLayout
  extends ViewGroup
{
  public static final String a = "UGCLayout";
  protected ArrayList a;
  
  public UGCLayout(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a();
  }
  
  public UGCLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public UGCLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.a = new ArrayList(6);
  }
  
  public ArrayList a()
  {
    return this.a;
  }
  
  public void a(View paramView)
  {
    if (this.a.size() == 6)
    {
      SLog.e("UGCLayout", "add child view error!");
      this.a.remove(0);
    }
    this.a.add(paramView);
    addView(paramView);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = UIUtils.a(getContext(), 1.0F);
    switch (getChildCount())
    {
    case 0: 
    default: 
    case 1: 
      View localView;
      do
      {
        return;
        localView = getChildAt(0);
      } while (localView == null);
      localView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    case 2: 
      getChildAt(0).layout(paramInt1, paramInt2, paramInt3 / 2 - i, paramInt4);
      getChildAt(1).layout(i + paramInt3 / 2, paramInt2, paramInt3, paramInt4);
      return;
    case 3: 
      getChildAt(0).layout(paramInt1, paramInt2, paramInt3 * 2 / 3 - i, paramInt4);
      getChildAt(1).layout(paramInt3 * 2 / 3 + i, paramInt2, paramInt3, paramInt4 / 2 - i);
      getChildAt(2).layout(paramInt3 * 2 / 3 + i, paramInt4 / 2 + i, paramInt3, paramInt4 - i);
      return;
    case 4: 
      getChildAt(0).layout(paramInt1, paramInt2, paramInt3 * 2 / 3 - i, paramInt4 * 804 / 1272 - i);
      getChildAt(1).layout(paramInt3 * 2 / 3 + i, paramInt2, paramInt3, paramInt4 * 402 / 1272 - i);
      getChildAt(2).layout(paramInt3 * 2 / 3 + i, paramInt4 * 402 / 1272 + i, paramInt3, paramInt4 * 804 / 1272 - i - i);
      getChildAt(3).layout(paramInt1, i + paramInt4 * 804 / 1272, paramInt3, paramInt4);
      return;
    case 5: 
      getChildAt(0).layout(paramInt1, paramInt2, paramInt3 * 2 / 3 - i, paramInt4 * 804 / 1400 - i);
      getChildAt(1).layout(paramInt3 * 2 / 3 + i, paramInt2, paramInt3, paramInt4 * 402 / 1400 - i);
      getChildAt(2).layout(paramInt3 * 2 / 3 + i, paramInt4 * 402 / 1400 + i, paramInt3, paramInt4 * 804 / 1400 - i * 3);
      getChildAt(3).layout(paramInt1, paramInt4 * 804 / 1400 + i, paramInt3 / 2 - i, paramInt4);
      getChildAt(4).layout(paramInt3 / 2 + i, i + paramInt4 * 804 / 1400, paramInt3, paramInt4);
      return;
    }
    getChildAt(0).layout(paramInt1, paramInt2, paramInt3 * 2 / 3 - i, paramInt4 / 2);
    getChildAt(1).layout(paramInt3 * 2 / 3 + i, paramInt2, paramInt3, paramInt4 / 4 - i);
    getChildAt(2).layout(paramInt3 * 2 / 3 + i, paramInt4 / 4 + i, paramInt3, paramInt4 / 2 - i * 2);
    getChildAt(3).layout(paramInt1, paramInt4 / 2 + i, paramInt3 / 3 - i, paramInt4 * 3 / 4);
    getChildAt(4).layout(paramInt1, paramInt4 * 3 / 4 + i, paramInt3 / 3 - i, paramInt4 - i);
    getChildAt(5).layout(paramInt3 / 3 + i, i + paramInt4 / 2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = 0;
    super.onMeasure(paramInt1, paramInt2);
    View.MeasureSpec.getMode(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt2);
    int k = View.MeasureSpec.getSize(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt2);
    int n = UIUtils.a(getContext(), 1.0F);
    paramInt2 = j;
    switch (this.a.size())
    {
    default: 
      paramInt2 = j;
    case 0: 
      if (m != 1073741824) {
        break;
      }
    }
    for (paramInt1 = i;; paramInt1 = paramInt2)
    {
      setMeasuredDimension(k, paramInt1);
      return;
      getChildAt(0).measure(paramInt1, View.MeasureSpec.makeMeasureSpec(UIUtils.a(getContext(), 232.0F), 1073741824));
      paramInt2 = UIUtils.a(getContext(), 234.0F);
      break;
      getChildAt(0).measure(View.MeasureSpec.makeMeasureSpec(k / 2 - n, 1073741824), View.MeasureSpec.makeMeasureSpec(UIUtils.a(getContext(), 298.0F), 1073741824));
      getChildAt(1).measure(View.MeasureSpec.makeMeasureSpec(k / 2 - n, 1073741824), View.MeasureSpec.makeMeasureSpec(UIUtils.a(getContext(), 298.0F), 1073741824));
      paramInt2 = UIUtils.a(getContext(), 300.0F);
      break;
      getChildAt(0).measure(View.MeasureSpec.makeMeasureSpec(k * 2 / 3 - n, 1073741824), View.MeasureSpec.makeMeasureSpec(UIUtils.a(getContext(), 400.0F), 1073741824));
      getChildAt(1).measure(View.MeasureSpec.makeMeasureSpec(k / 3 - n, 1073741824), View.MeasureSpec.makeMeasureSpec(UIUtils.a(getContext(), 200.0F), 1073741824));
      getChildAt(2).measure(View.MeasureSpec.makeMeasureSpec(k / 3 - n, 1073741824), View.MeasureSpec.makeMeasureSpec(UIUtils.a(getContext(), 200.0F), 1073741824));
      paramInt2 = UIUtils.a(getContext(), 402.0F);
      break;
      getChildAt(0).measure(View.MeasureSpec.makeMeasureSpec(k * 2 / 3 - n, 1073741824), View.MeasureSpec.makeMeasureSpec(UIUtils.a(getContext(), 400.0F), 1073741824));
      getChildAt(1).measure(View.MeasureSpec.makeMeasureSpec(k / 3 - n, 1073741824), View.MeasureSpec.makeMeasureSpec(UIUtils.a(getContext(), 200.0F), 1073741824));
      getChildAt(2).measure(View.MeasureSpec.makeMeasureSpec(k / 3 - n, 1073741824), View.MeasureSpec.makeMeasureSpec(UIUtils.a(getContext(), 200.0F), 1073741824));
      getChildAt(3).measure(View.MeasureSpec.makeMeasureSpec(k, 1073741824), View.MeasureSpec.makeMeasureSpec(UIUtils.a(getContext(), 232.0F), 1073741824));
      paramInt2 = UIUtils.a(getContext(), 636.0F);
      break;
      getChildAt(0).measure(View.MeasureSpec.makeMeasureSpec(k * 2 / 3 - n, 1073741824), View.MeasureSpec.makeMeasureSpec(UIUtils.a(getContext(), 400.0F), 1073741824));
      getChildAt(1).measure(View.MeasureSpec.makeMeasureSpec(k / 3 - n, 1073741824), View.MeasureSpec.makeMeasureSpec(UIUtils.a(getContext(), 200.0F), 1073741824));
      getChildAt(2).measure(View.MeasureSpec.makeMeasureSpec(k / 3 - n, 1073741824), View.MeasureSpec.makeMeasureSpec(UIUtils.a(getContext(), 200.0F), 1073741824));
      getChildAt(3).measure(View.MeasureSpec.makeMeasureSpec(k / 2 - n, 1073741824), View.MeasureSpec.makeMeasureSpec(UIUtils.a(getContext(), 298.0F), 1073741824));
      getChildAt(4).measure(View.MeasureSpec.makeMeasureSpec(k / 2 - n, 1073741824), View.MeasureSpec.makeMeasureSpec(UIUtils.a(getContext(), 298.0F), 1073741824));
      paramInt2 = UIUtils.a(getContext(), 702.0F);
      break;
      getChildAt(0).measure(View.MeasureSpec.makeMeasureSpec(k * 2 / 3 - n, 1073741824), View.MeasureSpec.makeMeasureSpec(UIUtils.a(getContext(), 400.0F), 1073741824));
      getChildAt(1).measure(View.MeasureSpec.makeMeasureSpec(k / 3 - n, 1073741824), View.MeasureSpec.makeMeasureSpec(UIUtils.a(getContext(), 200.0F), 1073741824));
      getChildAt(2).measure(View.MeasureSpec.makeMeasureSpec(k / 3 - n, 1073741824), View.MeasureSpec.makeMeasureSpec(UIUtils.a(getContext(), 200.0F), 1073741824));
      getChildAt(3).measure(View.MeasureSpec.makeMeasureSpec(k / 3 - n, 1073741824), View.MeasureSpec.makeMeasureSpec(UIUtils.a(getContext(), 200.0F), 1073741824));
      getChildAt(4).measure(View.MeasureSpec.makeMeasureSpec(k / 3 - n, 1073741824), View.MeasureSpec.makeMeasureSpec(UIUtils.a(getContext(), 200.0F), 1073741824));
      getChildAt(5).measure(View.MeasureSpec.makeMeasureSpec(k * 2 / 3 - n, 1073741824), View.MeasureSpec.makeMeasureSpec(UIUtils.a(getContext(), 400.0F), 1073741824));
      paramInt2 = UIUtils.a(getContext(), 804.0F);
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\view\UGCLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */