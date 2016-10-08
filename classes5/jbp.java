import android.os.CountDownTimer;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class jbp
  extends CountDownTimer
{
  public jbp(QRDisplayActivity paramQRDisplayActivity, long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onFinish()
  {
    QRDisplayActivity.a(this.a, true);
    if (QRDisplayActivity.a(this.a) == null)
    {
      QRDisplayActivity.b(this.a);
      if (QLog.isColorLevel()) {
        QLog.d("QRDisplayActivity", 4, "enter longclick");
      }
    }
    do
    {
      do
      {
        return;
      } while (QRDisplayActivity.a(this.a) == null);
      QRDisplayActivity.c(this.a);
    } while (!QLog.isColorLevel());
    QLog.d("QRDisplayActivity", 4, "enter longclickstop");
  }
  
  public void onTick(long paramLong) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jbp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */