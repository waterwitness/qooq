import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class onn
  implements Runnable
{
  public onn(AvatarPendantActivity paramAvatarPendantActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Bitmap localBitmap2 = null;
    localObject1 = null;
    if (ProfileCardUtil.a()) {
      localBitmap1 = localBitmap2;
    }
    try
    {
      localObject1 = ProfileCardUtil.b();
      localBitmap1 = localBitmap2;
      Object localObject2 = new File((String)localObject1);
      localBitmap1 = localBitmap2;
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localBitmap1 = localBitmap2;
      localObject2 = new FileInputStream((File)localObject2);
      localBitmap1 = localBitmap2;
      localOptions.inSampleSize = ((int)ImageUtil.a((InputStream)localObject2, 120, 120));
      localBitmap1 = localBitmap2;
      ((InputStream)localObject2).close();
      localBitmap1 = localBitmap2;
      localBitmap2 = BitmapManager.a((String)localObject1, localOptions);
      localObject1 = localBitmap2;
      if (localBitmap2 != null)
      {
        localBitmap1 = localBitmap2;
        localObject1 = this.a.app.a(localBitmap2, localBitmap2.getWidth(), localBitmap2.getHeight());
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject1 = localBitmap1;
        if (QLog.isColorLevel())
        {
          QLog.d("AvatarPendantActivity", 2, localException.toString());
          localObject1 = localBitmap1;
        }
      }
    }
    this.a.runOnUiThread(new ono(this, (Bitmap)localObject1));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\onn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */