import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.selectmember.SelectMemberFromFriendGroup;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

class pif
  implements View.OnClickListener
{
  pif(pie parampie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = (pig)paramView.getTag();
    if (this.a.a.a.contains(paramView.jdField_a_of_type_ComTencentMobileqqDataGroups))
    {
      this.a.a.a.remove(paramView.jdField_a_of_type_ComTencentMobileqqDataGroups);
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      this.a.a.a(paramView.jdField_a_of_type_ComTencentMobileqqDataGroups, false);
      return;
    }
    this.a.a.a.add(paramView.jdField_a_of_type_ComTencentMobileqqDataGroups);
    paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
    this.a.a.a(paramView.jdField_a_of_type_ComTencentMobileqqDataGroups, true);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pif.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */