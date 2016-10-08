import android.graphics.Rect;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.biz.widgets.ScannerView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jcj
  implements Runnable
{
  public jcj(ScannerActivity paramScannerActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Rect localRect = this.a.a();
    this.a.a.setViewFinder(localRect.left, localRect.top, localRect.right, localRect.bottom);
    if (!this.a.f) {
      this.a.a.b();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jcj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */