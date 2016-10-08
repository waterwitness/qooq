package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.emosm.view.DragSortAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class GroupEditeDragSortAdapter
  extends DragSortAdapter
{
  public GroupEditeDragSortAdapter(Context paramContext, List paramList)
  {
    super(paramContext, paramList);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2130904186, null);
    }
    paramViewGroup.setVisibility(0);
    paramViewGroup.findViewById(2131296816).setVisibility(8);
    ((TextView)paramViewGroup.findViewById(2131301744)).setText(((Groups)this.jdField_a_of_type_JavaUtilList.get(paramInt)).group_name);
    return paramViewGroup;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\adapter\GroupEditeDragSortAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */