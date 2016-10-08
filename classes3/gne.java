import android.graphics.Bitmap;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.av.service.QavWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class gne
  implements FaceDecoder.DecodeTaskCompletionListener
{
  public gne(QQServiceForAV paramQQServiceForAV)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "onDecodeTaskCompleted");
    }
    if (this.a.a == null) {
      this.a.a = ((QQAppInterface)this.a.a());
    }
    new QavWrapper(this.a.a.a().getApplicationContext()).a(new gnf(this, paramString, paramBitmap));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gne.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */