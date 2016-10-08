import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GesturePWDCreateActivity;
import com.tencent.mobileqq.activity.GesturePWDManualGuideActivity;
import com.tencent.mobileqq.activity.GesturePWDSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lnr
  implements View.OnClickListener
{
  public lnr(GesturePWDSettingActivity paramGesturePWDSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131298308: 
    case 2131298309: 
    case 2131298312: 
    case 2131298313: 
    default: 
      return;
    case 2131298307: 
      GesturePWDUtils.setGesturePWDMode(this.a, this.a.app.a(), 20);
      this.a.a();
      return;
    case 2131298311: 
      GesturePWDUtils.setGesturePWDMode(this.a, this.a.app.a(), 21);
      this.a.a();
      return;
    case 2131298310: 
      paramView = new Intent(this.a, GesturePWDManualGuideActivity.class);
      this.a.startActivity(paramView);
      return;
    }
    paramView = new Intent(this.a, GesturePWDCreateActivity.class);
    this.a.startActivityForResult(paramView, 11);
    this.a.overridePendingTransition(2130968592, 2130968589);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lnr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */