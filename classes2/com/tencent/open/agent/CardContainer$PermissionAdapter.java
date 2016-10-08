package com.tencent.open.agent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.agent.datamodel.AgentBaseAdapter;
import java.util.List;

public class CardContainer$PermissionAdapter
  extends AgentBaseAdapter
{
  protected CardContainer$PermissionAdapter(CardContainer paramCardContainer)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int getCount()
  {
    if (this.a.getTag() != null) {
      return 1;
    }
    return this.a.jdField_a_of_type_JavaUtilList.size();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903513, paramViewGroup, false);
      paramViewGroup = new BindGroupActivity.ViewHolder();
      paramViewGroup.a = ((TextView)paramView.findViewById(2131298891));
      paramView.setTag(paramViewGroup);
    }
    while (this.a.getTag() != null)
    {
      paramViewGroup.a.setText("● 获得你与QQ通讯录绑定的电话号码");
      return paramView;
      paramViewGroup = (BindGroupActivity.ViewHolder)paramView.getTag();
    }
    CardContainer.Permission localPermission = (CardContainer.Permission)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramViewGroup.a.setText("● " + localPermission.a);
    return paramView;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\agent\CardContainer$PermissionAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */