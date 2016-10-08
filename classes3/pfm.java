import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.FriendTabView;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class pfm
  implements View.OnClickListener
{
  public pfm(FriendTabView paramFriendTabView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    QLog.d("FriendTabView", 2, "----->onBuddyListClick");
    pid localpid = (pid)paramView.getTag();
    String str;
    boolean bool;
    if ((localpid != null) && (localpid.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localpid.jdField_a_of_type_JavaLangObject != null))
    {
      str = "";
      if (!(localpid.jdField_a_of_type_JavaLangObject instanceof Friends)) {
        break label224;
      }
      str = ((Friends)localpid.jdField_a_of_type_JavaLangObject).getFriendNickWithAlias();
      if (localpid.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())
      {
        if (!localpid.b.startsWith("+")) {
          break label248;
        }
        bool = this.a.a.a(localpid.b, str, 4, "-1", "");
        label102:
        if (QLog.isDevelopLevel()) {
          QLog.d("FriendTabView", 2, "----->onBuddyListClick = " + bool);
        }
        localpid.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
        if (AppSetting.j)
        {
          if (!localpid.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label273;
          }
          paramView.setContentDescription(localpid.d.getText().toString() + "已选中,双击取消");
        }
      }
    }
    for (;;)
    {
      this.a.c();
      if (AppSetting.j) {
        paramView.postDelayed(new pfn(this, paramView), 2000L);
      }
      return;
      label224:
      if (!(localpid.jdField_a_of_type_JavaLangObject instanceof PhoneContact)) {
        break;
      }
      str = ((PhoneContact)localpid.jdField_a_of_type_JavaLangObject).name;
      break;
      label248:
      bool = this.a.a.a(localpid.b, str, 0, "-1", "");
      break label102;
      label273:
      paramView.setContentDescription(localpid.d.getText().toString() + "未选中,双击选中");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pfm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */