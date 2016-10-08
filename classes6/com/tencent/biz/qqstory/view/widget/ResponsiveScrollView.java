package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ResponsiveScrollView
  extends ScrollView
{
  private ResponsiveScrollView.OnEndScrollListener jdField_a_of_type_ComTencentBizQqstoryViewWidgetResponsiveScrollView$OnEndScrollListener;
  private boolean jdField_a_of_type_Boolean;
  
  public ResponsiveScrollView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ResponsiveScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ResponsiveScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public ResponsiveScrollView.OnEndScrollListener a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetResponsiveScrollView$OnEndScrollListener;
  }
  
  public void fling(int paramInt)
  {
    super.fling(paramInt);
    this.jdField_a_of_type_Boolean = true;
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.jdField_a_of_type_Boolean) && ((Math.abs(paramInt2 - paramInt4) < 2) || (paramInt2 >= getMeasuredHeight()) || (paramInt2 == 0)))
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetResponsiveScrollView$OnEndScrollListener != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetResponsiveScrollView$OnEndScrollListener.a(paramInt1, paramInt2);
      }
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void setOnEndScrollListener(ResponsiveScrollView.OnEndScrollListener paramOnEndScrollListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetResponsiveScrollView$OnEndScrollListener = paramOnEndScrollListener;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\view\widget\ResponsiveScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */