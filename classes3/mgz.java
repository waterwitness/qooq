import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.QQSettingSettingActivity;
import com.tencent.mobileqq.app.PhoneUnityBannerData;
import com.tencent.mobileqq.app.SecSvcObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

public class mgz
  extends SecSvcObserver
{
  public mgz(QQSettingSettingActivity paramQQSettingSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(Object paramObject)
  {
    boolean bool1;
    if (paramObject == null)
    {
      bool1 = true;
      boolean bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if ((paramObject instanceof PhoneUnityBannerData)) {
          bool2 = ((PhoneUnityBannerData)paramObject).b;
        }
      }
      paramObject = this.a.findViewById(2131302443);
      if (paramObject != null)
      {
        if (!bool2) {
          break label105;
        }
        ((View)paramObject).setVisibility(0);
        if (!this.a.jdField_a_of_type_Boolean) {
          break label84;
        }
        this.a.a(true);
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Boolean = false;
      return;
      bool1 = false;
      break;
      label84:
      if (this.a.jdField_a_of_type_Int == 0)
      {
        this.a.a(false);
        continue;
        label105:
        ((View)paramObject).setVisibility(8);
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    boolean bool = true;
    if (this.a.isFinishing()) {}
    label60:
    do
    {
      return;
      if (paramBoolean)
      {
        paramString = this.a;
        if (paramInt == 1)
        {
          paramBoolean = true;
          QQSettingSettingActivity.a(paramString, paramBoolean);
          paramString = this.a;
          if (paramInt != 1) {
            break label60;
          }
        }
        for (paramBoolean = bool;; paramBoolean = false)
        {
          paramString.b(paramBoolean);
          return;
          paramBoolean = false;
          break;
        }
      }
      this.a.b.setClickable(true);
      this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    } while (!this.a.isResume());
    paramString = this.a.getString(2131370739);
    QQToast.a(this.a.getApplicationContext(), paramString, 0).b(this.a.getTitleBarHeight());
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (this.a.isFinishing()) {
      return;
    }
    QQSettingSettingActivity.a(this.a, paramBoolean, paramBundle);
    paramBundle = this.a;
    paramBundle.jdField_a_of_type_Int -= 1;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mgz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */