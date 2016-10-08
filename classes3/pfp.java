import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.FriendTeamListInnerFrame;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class pfp
  implements View.OnClickListener
{
  public pfp(FriendTeamListInnerFrame paramFriendTeamListInnerFrame)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    QLog.d("FriendTeamListInnerFrameNew", 2, "----->onBuddyListClick");
    pid localpid = (pid)paramView.getTag();
    String str;
    boolean bool;
    if ((localpid != null) && (localpid.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localpid.jdField_a_of_type_JavaLangObject != null))
    {
      str = "";
      if (!(localpid.jdField_a_of_type_JavaLangObject instanceof Friends)) {
        break label222;
      }
      str = ((Friends)localpid.jdField_a_of_type_JavaLangObject).getFriendNickWithAlias();
      if (localpid.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())
      {
        if (!localpid.b.startsWith("+")) {
          break label246;
        }
        bool = this.a.a.a(localpid.b, str, 4, "-1");
        label100:
        if (QLog.isDevelopLevel()) {
          QLog.d("FriendTeamListInnerFrameNew", 2, "----->onBuddyListClick = " + bool);
        }
        localpid.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
        if (AppSetting.j)
        {
          if (!localpid.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label269;
          }
          paramView.setContentDescription(localpid.d.getText().toString() + "已选中");
        }
      }
    }
    for (;;)
    {
      this.a.f();
      if (AppSetting.j) {
        paramView.postDelayed(new pfq(this, paramView), 2000L);
      }
      return;
      label222:
      if (!(localpid.jdField_a_of_type_JavaLangObject instanceof PhoneContact)) {
        break;
      }
      str = ((PhoneContact)localpid.jdField_a_of_type_JavaLangObject).name;
      break;
      label246:
      bool = this.a.a.a(localpid.b, str, 0, "-1");
      break label100;
      label269:
      paramView.setContentDescription(localpid.d.getText().toString() + "未选中");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pfp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */