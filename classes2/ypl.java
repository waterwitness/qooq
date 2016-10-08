import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.share.QZoneShareActivity;

public class ypl
  implements View.OnClickListener
{
  public ypl(QZoneShareActivity paramQZoneShareActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (!this.a.c)
    {
      this.a.f();
      return;
    }
    this.a.h();
    this.a.a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ypl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */