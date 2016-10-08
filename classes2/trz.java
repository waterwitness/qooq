import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;

public class trz
  implements Runnable
{
  public trz(ScanTorchActivity paramScanTorchActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ScanTorchActivity.a(this.a, true);
    ScanTorchActivity.f(this.a);
    ScanTorchActivity.c(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\trz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */