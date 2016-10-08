import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.drawable.PngGifEngine;
import com.tencent.qphone.base.util.QLog;

public class taq
  implements Runnable
{
  public taq(PngGifEngine paramPngGifEngine)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(PngGifEngine.a(), 2, "func run begins.");
    }
    Object localObject1 = PngGifEngine.a(this.a);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    long l2 = SystemClock.uptimeMillis();
    Object localObject2 = PngGifEngine.a((String)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d(PngGifEngine.a(), 2, "func run, bitmap:" + localObject2);
    }
    localObject1 = this.a;
    if (localObject2 != null) {}
    for (;;)
    {
      long l1;
      try
      {
        if ((!((Bitmap)localObject2).isRecycled()) && (PngGifEngine.a(this.a) != null))
        {
          l1 = SystemClock.uptimeMillis();
          l2 += PngGifEngine.a(this.a).b;
          localObject2 = PngGifEngine.a(this.a).obtainMessage(1, localObject2);
          if (l1 > l2) {
            PngGifEngine.a(this.a).sendMessage((Message)localObject2);
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      PngGifEngine.a(this.a).sendMessageDelayed(localMessage, l2 - l1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\taq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */