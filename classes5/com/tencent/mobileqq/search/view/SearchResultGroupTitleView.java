package com.tencent.mobileqq.search.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import unf;

public class SearchResultGroupTitleView
  extends SearchResultGroupView
{
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public SearchResultGroupTitleView(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130903375, paramViewGroup, false);
    this.b.setOnTouchListener(new unf(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.b.findViewById(2131297123));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView = this.b.findViewById(2131298342);
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public void a(boolean paramBoolean)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\view\SearchResultGroupTitleView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */