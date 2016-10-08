import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jbt
  implements Runnable
{
  public jbt(QRDisplayActivity paramQRDisplayActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = this.a.c.getHeight();
    int j = this.a.b.getHeight();
    View localView;
    LinearLayout.LayoutParams localLayoutParams;
    if (j < i)
    {
      localView = this.a.findViewById(2131300023);
      localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      if (this.a.g != 2) {
        break label74;
      }
      localLayoutParams.topMargin = 0;
      localLayoutParams.bottomMargin = 0;
    }
    for (;;)
    {
      localView.setLayoutParams(localLayoutParams);
      return;
      label74:
      if (this.a.g == 5)
      {
        int k = localLayoutParams.topMargin;
        localLayoutParams.topMargin = ((i - j) / 2 + k);
      }
      else
      {
        localLayoutParams.topMargin = 50;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jbt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */