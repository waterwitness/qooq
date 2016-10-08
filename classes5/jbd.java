import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jbd
  implements Runnable
{
  public jbd(QRDisplayActivity paramQRDisplayActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    String str = "temp_qrcode_share_" + this.a.h + ".png";
    try
    {
      str = QRUtils.a(this.a.getApplicationContext(), str, this.a.b);
      this.a.runOnUiThread(new jbf(this, str));
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      this.a.runOnUiThread(new jbe(this));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jbd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */