import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.NearPeopleFilterActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.FormSimpleItem;

public class lwa
  implements DialogInterface.OnDismissListener
{
  public lwa(NearPeopleFilterActivity paramNearPeopleFilterActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.a.j == 0)
    {
      this.a.a.setRightTextColor(2);
      if (AppSetting.j) {
        this.a.a.setContentDescription("年龄" + com.tencent.mobileqq.activity.NearPeopleFilterActivity.NearPeopleFilters.a[this.a.jdField_c_of_type_Int] + ",连按两次来更改");
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (this.a.j != 1) {
            break;
          }
          this.a.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
        } while (!AppSetting.j);
        this.a.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("星座" + com.tencent.mobileqq.activity.NearPeopleFilterActivity.NearPeopleFilters.c[this.a.e] + ",连按两次来更改");
        return;
      } while (this.a.j != 2);
      this.a.b.setRightTextColor(2);
    } while (!AppSetting.j);
    this.a.b.setContentDescription("兴趣" + com.tencent.mobileqq.activity.NearPeopleFilterActivity.NearPeopleFilters.b[this.a.d] + ",连按两次来更改");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lwa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */