package com.tencent.biz.qqstory.pgc.view;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.FrameLayout;
import com.tencent.biz.qqstory.pgc.model.RecommendItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class BaseDiscoverFrameLayout
  extends FrameLayout
{
  protected AdapterView.OnItemClickListener a;
  protected AdapterView.OnItemLongClickListener a;
  
  public BaseDiscoverFrameLayout(Context paramContext, int paramInt1, int paramInt2, AdapterView.OnItemClickListener paramOnItemClickListener, AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = paramOnItemClickListener;
    this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemLongClickListener = paramOnItemLongClickListener;
  }
  
  public void setChildrenVisible()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() != 0) {
        localView.setVisibility(0);
      }
      i += 1;
    }
  }
  
  public void setRecommendItem(int paramInt, RecommendItem... paramVarArgs)
  {
    int i = 0;
    while (i < getChildCount())
    {
      ((DiscoverItem)getChildAt(i)).setVisibility(4);
      i += 1;
    }
    i = 0;
    while ((i < paramVarArgs.length) && (i < getChildCount()))
    {
      ((DiscoverItem)getChildAt(i)).setVisibility(0);
      ((DiscoverItem)getChildAt(i)).setRecommendItem(paramInt + i, paramVarArgs[i]);
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\pgc\view\BaseDiscoverFrameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */