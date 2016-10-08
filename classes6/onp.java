import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class onp
  implements View.OnClickListener
{
  public onp(AvatarPendantActivity paramAvatarPendantActivity, String paramString1, String paramString2, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.a(this.jdField_a_of_type_JavaLangString, this.b, true, this.jdField_a_of_type_Int);
    paramView = "0";
    if (!TextUtils.isEmpty(this.b)) {
      if (!"QQ会员".equals(this.b)) {
        break label78;
      }
    }
    label78:
    for (paramView = "0";; paramView = "1")
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.app, "CliOper", "", "", "0X8005FD2", "0X8005FD2", 0, 0, paramView, "", "", "");
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\onp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */