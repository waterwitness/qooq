import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.av.utils.PstnUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.PhoneContactTabView;
import com.tencent.mobileqq.activity.selectmember.SelectActivityViewHolder;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class pgi
  implements View.OnClickListener
{
  pgi(pgh parampgh)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    Object localObject2;
    if (paramView.getId() == 2131297784)
    {
      paramView = PstnUtils.b(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2);
      localObject1 = PstnUtils.c(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2);
      localObject2 = PstnUtils.d(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2);
      DialogUtil.a(this.a.a.jdField_a_of_type_AndroidContentContext, paramView, (String)localObject1, (String)localObject2, new pgj(this), this.a.a.jdField_a_of_type_AndroidContentContext.getString(2131364005), new pgk(this)).show();
    }
    do
    {
      do
      {
        return;
        localObject1 = (SelectActivityViewHolder)paramView.getTag();
      } while ((localObject1 == null) || (((SelectActivityViewHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox == null) || (((SelectActivityViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataPhoneContact == null));
      localObject2 = ((SelectActivityViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
    } while (!((SelectActivityViewHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.isEnabled());
    boolean bool;
    if (((SelectActivityViewHolder)localObject1).jdField_a_of_type_Boolean) {
      bool = this.a.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(((SelectActivityViewHolder)localObject1).b, ((PhoneContact)localObject2).name, 5, "-1", ((PhoneContact)localObject2).mobileNo);
    }
    for (;;)
    {
      ((SelectActivityViewHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
      if (!AppSetting.j) {
        break;
      }
      if (!((SelectActivityViewHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        break label371;
      }
      if (!((SelectActivityViewHolder)localObject1).jdField_a_of_type_Boolean) {
        break label336;
      }
      paramView.setContentDescription(((SelectActivityViewHolder)localObject1).c.getText() + this.a.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131370205));
      return;
      if (((SelectActivityViewHolder)localObject1).b.startsWith("+")) {
        bool = this.a.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(((SelectActivityViewHolder)localObject1).b, ((PhoneContact)localObject2).name, 4, "-1", ((PhoneContact)localObject2).mobileNo);
      } else {
        bool = this.a.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(((SelectActivityViewHolder)localObject1).b, ((PhoneContact)localObject2).name, 0, "-1", ((PhoneContact)localObject2).mobileNo);
      }
    }
    label336:
    paramView.setContentDescription(((SelectActivityViewHolder)localObject1).c.getText().toString() + "已选中,双击取消");
    return;
    label371:
    if (((SelectActivityViewHolder)localObject1).jdField_a_of_type_Boolean) {}
    for (int i = this.a.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(((SelectActivityViewHolder)localObject1).b);; i = 0)
    {
      if ((((SelectActivityViewHolder)localObject1).jdField_a_of_type_Boolean) && (i != 0))
      {
        paramView.setContentDescription(((SelectActivityViewHolder)localObject1).c.getText() + this.a.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(i));
        return;
      }
      paramView.setContentDescription(((SelectActivityViewHolder)localObject1).c.getText().toString() + "未选中,双击选中");
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pgi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */