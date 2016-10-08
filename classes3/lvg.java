import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.EditActivity;
import com.tencent.mobileqq.activity.ModifyFriendInfoActivity;
import com.tencent.mobileqq.activity.MoveToGroupActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lvg
  implements View.OnClickListener
{
  public lvg(ModifyFriendInfoActivity paramModifyFriendInfoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (2131296790 == i)
    {
      paramView = new ProfileActivity.AllInOne(this.a.jdField_a_of_type_JavaLangString, 1);
      paramView.h = this.a.jdField_b_of_type_JavaLangString;
      ProfileActivity.b(this.a, paramView);
    }
    do
    {
      return;
      if (2131298462 == i)
      {
        paramView = new Intent(this.a, EditActivity.class);
        paramView.putExtra("title", 2131369385).putExtra("limit", 96).putExtra("canPostNull", true).putExtra("hint", this.a.getResources().getString(2131369389)).putExtra("multiLine", false);
        if ((this.a.jdField_b_of_type_AndroidWidgetTextView.getText() != null) && (this.a.jdField_b_of_type_AndroidWidgetTextView.getText().length() > 0)) {
          paramView.putExtra("current", this.a.jdField_b_of_type_AndroidWidgetTextView.getText());
        }
        this.a.startActivityForResult(paramView, 1000);
        return;
      }
      if (2131298465 == i)
      {
        paramView = new Intent(this.a, MoveToGroupActivity.class).putExtra("friendUin", this.a.jdField_a_of_type_JavaLangString).putExtra("mgid", (byte)this.a.jdField_a_of_type_Int);
        this.a.startActivityForResult(paramView, 0);
        return;
      }
    } while (2131298468 != i);
    paramView = AIOUtils.a(new Intent(this.a, SplashActivity.class), null);
    paramView.putExtra("uin", this.a.jdField_a_of_type_JavaLangString);
    paramView.putExtra("uinname", this.a.jdField_b_of_type_JavaLangString);
    paramView.putExtra("uintype", 0);
    this.a.startActivity(paramView.addCategory("android.intent.category.CHAT").addFlags(536870912));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lvg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */