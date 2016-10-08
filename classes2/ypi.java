import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.RDMEtraMsgCollector;
import cooperation.qzone.share.QZoneShareActivity;

public class ypi
  implements View.OnClickListener
{
  public ypi(QZoneShareActivity paramQZoneShareActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    RDMEtraMsgCollector.a().a(QZoneShareActivity.h, paramView);
    this.a.a(false);
    paramView = new Intent(BaseApplication.getContext(), SelectMemberActivity.class);
    paramView.putExtra("param_only_friends", true);
    paramView.putExtra("param_min", 1);
    this.a.startActivityForResult(paramView, 1000);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ypi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */