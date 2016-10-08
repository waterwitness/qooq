package com.tencent.biz.qqstory.pgc.view;

import android.content.Context;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.DisplayUtil;

public class DiscoverFrameLayoutLargeThreeLeft
  extends BaseDiscoverFrameLayout
{
  public DiscoverFrameLayoutLargeThreeLeft(Context paramContext, int paramInt1, int paramInt2, AdapterView.OnItemClickListener paramOnItemClickListener, AdapterView.OnItemLongClickListener paramOnItemLongClickListener, DiscoverItem.OnItemTouchListener paramOnItemTouchListener)
  {
    super(paramContext, paramInt1, paramInt2, paramOnItemClickListener, paramOnItemLongClickListener);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    int i = (paramInt1 - DisplayUtil.a(getContext(), 4.0F)) / 3;
    int j = DisplayUtil.a(getContext(), 2.0F);
    paramInt2 = paramInt2 * 2 / 3;
    int k = (paramInt2 - DisplayUtil.a(getContext(), 2.0F)) / 2;
    super.addView(new DiscoverItem(getContext(), 36, this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener, this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemLongClickListener, paramOnItemTouchListener), new FrameLayout.LayoutParams(paramInt1 - i - j, paramInt2));
    paramContext = new DiscoverItem(getContext(), 22, this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener, this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemLongClickListener, paramOnItemTouchListener);
    paramOnItemClickListener = new FrameLayout.LayoutParams(i, k);
    paramOnItemClickListener.leftMargin = (paramInt1 - i);
    super.addView(paramContext, paramOnItemClickListener);
    paramContext = new DiscoverItem(getContext(), 22, this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener, this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemLongClickListener, paramOnItemTouchListener);
    paramOnItemClickListener = new FrameLayout.LayoutParams(i, k);
    paramOnItemClickListener.leftMargin = (paramInt1 - i);
    paramOnItemClickListener.topMargin = (DisplayUtil.a(getContext(), 2.0F) + k);
    super.addView(paramContext, paramOnItemClickListener);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\pgc\view\DiscoverFrameLayoutLargeThreeLeft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */