package com.tencent.mobileqq.search.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.List;

public class SearchResultGroupView
  implements ISearchResultGroupView
{
  private TextView a;
  protected List a;
  protected View b;
  protected TextView b;
  
  public SearchResultGroupView()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SearchResultGroupView(ViewGroup paramViewGroup, int paramInt)
  {
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup, false);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131296812));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new SearchResultView(this.jdField_b_of_type_AndroidViewView.findViewById(2131298780)));
    this.jdField_a_of_type_JavaUtilList.add(new SearchResultView(this.jdField_b_of_type_AndroidViewView.findViewById(2131298781)));
    this.jdField_a_of_type_JavaUtilList.add(new SearchResultView(this.jdField_b_of_type_AndroidViewView.findViewById(2131298782)));
  }
  
  public View a()
  {
    return this.jdField_b_of_type_AndroidViewView;
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public TextView b()
  {
    return this.jdField_b_of_type_AndroidWidgetTextView;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\view\SearchResultGroupView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */