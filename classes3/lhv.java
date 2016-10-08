import QQService.TagInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ToggleButton;
import com.tencent.mobileqq.activity.EditTagActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class lhv
  extends BaseAdapter
{
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  public lhv(EditTagActivity paramEditTagActivity, ArrayList paramArrayList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = new ToggleButton(paramViewGroup.getContext());
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, (int)(28.0F * this.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.jdField_a_of_type_Float)));
      paramView.setBackgroundResource(2130843396);
      ((ToggleButton)paramView).setGravity(17);
      ((ToggleButton)paramView).setTextSize(this.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.getResources().getInteger(2131623940));
      ((ToggleButton)paramView).setTextColor(Color.parseColor("#777777"));
    }
    for (;;)
    {
      ((ToggleButton)paramView).setOnCheckedChangeListener(null);
      ((ToggleButton)paramView).setChecked(this.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.a((TagInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), this.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.jdField_a_of_type_JavaUtilArrayList));
      ((ToggleButton)paramView).setOnCheckedChangeListener(new lhw(this, paramInt));
      ((ToggleButton)paramView).setText(((TagInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).strContent);
      ((ToggleButton)paramView).setTextOn(((TagInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).strContent);
      ((ToggleButton)paramView).setTextOff(((TagInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).strContent);
      return paramView;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lhv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */