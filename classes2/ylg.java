import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DisplayUtils;
import cooperation.qzone.QzoneGiftFullScreenViewController;

public class ylg
  implements Runnable
{
  public ylg(QzoneGiftFullScreenViewController paramQzoneGiftFullScreenViewController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.a.a.getLayoutParams();
    localLayoutParams.rightMargin = ((int)DisplayUtils.a(QzoneGiftFullScreenViewController.a(this.a), 10.0F));
    this.a.a.setLayoutParams(localLayoutParams);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ylg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */