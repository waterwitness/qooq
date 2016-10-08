import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ToggleButton;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.ProfileLabelInfo;
import com.tencent.mobileqq.profile.view.ProfileLabelPanel.LabelStatusManager;
import com.tencent.mobileqq.profile.view.ProfileLabelPanelAdapter;
import java.util.List;

public class twu
  extends BaseAdapter
{
  List jdField_a_of_type_JavaUtilList;
  
  private twu(ProfileLabelPanelAdapter paramProfileLabelPanelAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ProfileLabelInfo localProfileLabelInfo;
    if (paramView == null)
    {
      paramView = new ToggleButton(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanelAdapter.jdField_a_of_type_AndroidContentContext);
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, (int)(28.0F * this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanelAdapter.jdField_a_of_type_Float)));
      paramView.setBackgroundResource(2130843396);
      paramViewGroup = (ToggleButton)paramView;
      paramViewGroup.setGravity(17);
      paramViewGroup.setTextSize(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanelAdapter.jdField_a_of_type_AndroidContentContext.getResources().getInteger(2131623940));
      paramViewGroup.setTextColor(Color.parseColor("#777777"));
      paramViewGroup.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanelAdapter);
      localProfileLabelInfo = (ProfileLabelInfo)getItem(paramInt);
      if (localProfileLabelInfo == null) {
        break label204;
      }
      paramViewGroup.setTag(localProfileLabelInfo);
      if (localProfileLabelInfo.labelStatus != ProfileLabelInfo.STATUS_CHECKED) {
        break label198;
      }
    }
    label198:
    for (boolean bool = true;; bool = false)
    {
      paramViewGroup.setChecked(bool);
      paramViewGroup.setText(localProfileLabelInfo.labelName);
      paramViewGroup.setTextOn(localProfileLabelInfo.labelName);
      paramViewGroup.setTextOff(localProfileLabelInfo.labelName);
      if (localProfileLabelInfo.labelStatus == ProfileLabelInfo.STATUS_CHECKED) {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanelAdapter.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanel$LabelStatusManager.a(localProfileLabelInfo, paramViewGroup);
      }
      return paramView;
      paramViewGroup = (ToggleButton)paramView;
      break;
    }
    label204:
    paramViewGroup.setVisibility(8);
    return paramView;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\twu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */