import android.graphics.Rect;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.olympic.view.ScanTorchViewFinder;

public class trw
  implements Runnable
{
  public trw(ScanTorchActivity paramScanTorchActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = this.a.a.getRight();
    int j = this.a.a.getBottom();
    Rect localRect = new Rect();
    localRect.left = AIOUtils.a(20.0F, this.a.getResources());
    localRect.top = AIOUtils.a(83.0F, this.a.getResources());
    localRect.right = (i - AIOUtils.a(20.0F, this.a.getResources()));
    localRect.bottom = (j - AIOUtils.a(63.0F, this.a.getResources()));
    this.a.a.setViewFinderRect(localRect);
    ScanTorchActivity.c(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\trw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */