package com.tencent.mobileqq.search.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class SearchResultGroupMessageView
  extends SearchResultGroupView
{
  protected View a;
  protected TextView a;
  
  public SearchResultGroupMessageView()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SearchResultGroupMessageView(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2130904944);
    this.jdField_a_of_type_AndroidViewView = this.b.findViewById(2131304833);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131304842));
  }
  
  public View b()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public TextView c()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\view\SearchResultGroupMessageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */