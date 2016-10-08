package com.tencent.biz.qqstory.pgc.view;

import android.content.Context;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.DisplayUtil;

public class DiscoverFrameLayoutTwo
  extends BaseDiscoverFrameLayout
{
  public DiscoverFrameLayoutTwo(Context paramContext, int paramInt1, int paramInt2, AdapterView.OnItemClickListener paramOnItemClickListener, AdapterView.OnItemLongClickListener paramOnItemLongClickListener, DiscoverItem.OnItemTouchListener paramOnItemTouchListener)
  {
    super(paramContext, paramInt1, paramInt2, paramOnItemClickListener, paramOnItemLongClickListener);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    paramInt1 = (paramInt1 - DisplayUtil.a(getContext(), 2.0F)) / 2;
    paramInt2 /= 2;
    super.addView(new DiscoverItem(getContext(), 22, this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener, this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemLongClickListener, paramOnItemTouchListener), new FrameLayout.LayoutParams(paramInt1, paramInt2));
    paramContext = new DiscoverItem(getContext(), 22, this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener, this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemLongClickListener, paramOnItemTouchListener);
    paramOnItemClickListener = new FrameLayout.LayoutParams(paramInt1, paramInt2);
    paramOnItemClickListener.leftMargin = (DisplayUtil.a(getContext(), 2.0F) + paramInt1);
    super.addView(paramContext, paramOnItemClickListener);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\pgc\view\DiscoverFrameLayoutTwo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */