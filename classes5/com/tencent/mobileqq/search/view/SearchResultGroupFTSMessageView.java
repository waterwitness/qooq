package com.tencent.mobileqq.search.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.List;

public class SearchResultGroupFTSMessageView
  extends SearchResultGroupMessageView
{
  public SearchResultGroupFTSMessageView(ViewGroup paramViewGroup)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130904942, paramViewGroup, false);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131296812));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new FTSMessageSearchResultView(this.jdField_b_of_type_AndroidViewView.findViewById(2131298780)));
    this.jdField_a_of_type_JavaUtilList.add(new FTSMessageSearchResultView(this.jdField_b_of_type_AndroidViewView.findViewById(2131298781)));
    this.jdField_a_of_type_JavaUtilList.add(new FTSMessageSearchResultView(this.jdField_b_of_type_AndroidViewView.findViewById(2131298782)));
    this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131304833);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131304842));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\view\SearchResultGroupFTSMessageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */