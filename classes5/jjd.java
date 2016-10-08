import com.tencent.biz.widgets.ScannerView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.os.MqqHandler;

public class jjd
  implements Runnable
{
  public jjd(ScannerView paramScannerView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ScannerView.a(this.a, false);
    ScannerView.a(this.a, ScannerView.a(this.a));
    ThreadManager.c().post(new jje(this));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jjd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */