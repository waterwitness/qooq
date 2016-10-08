import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class phh
  implements View.OnClickListener
{
  public phh(SelectMemberActivity paramSelectMemberActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.a.onBackEvent();
    if (AppSetting.j) {
      this.a.c.post(new phi(this));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\phh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */