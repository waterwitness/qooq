import com.tencent.biz.widgets.ScannerView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.os.MqqHandler;

public class jja
  implements Runnable
{
  public jja(ScannerView paramScannerView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    boolean bool = ScannerView.a(this.a);
    ThreadManager.c().post(new jjb(this, bool));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jja.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */