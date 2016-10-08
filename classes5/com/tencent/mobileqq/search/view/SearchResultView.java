package com.tencent.mobileqq.search.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class SearchResultView
  implements ISearchResultView
{
  protected View a;
  protected ImageView a;
  protected TextView a;
  protected ImageView b;
  protected TextView b;
  protected TextView c;
  protected TextView d;
  
  public SearchResultView(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    a();
  }
  
  public SearchResultView(ViewGroup paramViewGroup, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup, false);
    a();
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public ImageView a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297123));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298783));
    this.c = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298722));
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131304841);
    if (localView != null) {
      this.d = ((TextView)localView);
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131296303));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298784));
  }
  
  public ImageView b()
  {
    return this.jdField_b_of_type_AndroidWidgetImageView;
  }
  
  public TextView e()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public TextView f()
  {
    return this.jdField_b_of_type_AndroidWidgetTextView;
  }
  
  public TextView g()
  {
    return this.c;
  }
  
  public TextView h()
  {
    return this.d;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\view\SearchResultView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */