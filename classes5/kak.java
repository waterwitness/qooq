import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.device.msg.activities.DeviceTipActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

public class kak
  implements View.OnClickListener
{
  public kak(DeviceTipActivity paramDeviceTipActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.h(this.a)) {
      QQToast.a(this.a, "当前网络连接不可用，请确认后再使用", 2000).a();
    }
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\kak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */