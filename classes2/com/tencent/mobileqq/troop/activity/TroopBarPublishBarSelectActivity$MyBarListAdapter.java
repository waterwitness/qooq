package com.tencent.mobileqq.troop.activity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopBarMyBar;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.XBaseAdapter;
import java.util.ArrayList;

public class TroopBarPublishBarSelectActivity$MyBarListAdapter
  extends XBaseAdapter
{
  protected LayoutInflater a;
  
  public TroopBarPublishBarSelectActivity$MyBarListAdapter(TroopBarPublishBarSelectActivity paramTroopBarPublishBarSelectActivity, Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishBarSelectActivity.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishBarSelectActivity.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903700, null);
      paramViewGroup = new TroopBarPublishBarSelectActivity.MyBarListAdapter.ViewHolder(this);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131299762));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296829));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299765));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131299764));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      TroopBarMyBar localTroopBarMyBar = (TroopBarMyBar)this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishBarSelectActivity.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localTroopBarMyBar.v);
      paramView.setContentDescription(localTroopBarMyBar.v);
      paramView.setFocusable(true);
      paramView.setFocusableInTouchMode(true);
      try
      {
        Object localObject = URLDrawable.getDrawable(localTroopBarMyBar.w);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        if (localTroopBarMyBar.l == 1)
        {
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          localObject = paramViewGroup.jdField_b_of_type_AndroidWidgetImageView;
          if (localTroopBarMyBar.equals(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishBarSelectActivity.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar)) {}
          for (paramInt = 0;; paramInt = 4)
          {
            ((ImageView)localObject).setVisibility(paramInt);
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
            return paramView;
            paramViewGroup = (TroopBarPublishBarSelectActivity.MyBarListAdapter.ViewHolder)paramView.getTag();
            break;
          }
        }
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth((int)DeviceInfoUtil.f() >> 1);
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localTroopBarMyBar.z);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(BaseApplicationImpl.getContext().getResources().getColor(2131427854));
        return paramView;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\activity\TroopBarPublishBarSelectActivity$MyBarListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */