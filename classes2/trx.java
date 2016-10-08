import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;

public class trx
  implements Runnable
{
  public trx(ScanTorchActivity paramScanTorchActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ScanTorchActivity.d(this.a);
    ScanTorchActivity.e(this.a);
    ScanTorchActivity.f(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\trx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */