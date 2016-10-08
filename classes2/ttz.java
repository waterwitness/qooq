import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.portal.HongBaoShareActivity;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.IOException;
import java.lang.ref.WeakReference;

public class ttz
  implements Runnable
{
  public ttz(HongBaoShareActivity paramHongBaoShareActivity, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Bitmap localBitmap2 = null;
    Object localObject6 = null;
    Object localObject7 = null;
    Bitmap localBitmap1 = null;
    localBitmap3 = localBitmap2;
    localObject4 = localObject6;
    localObject5 = localObject7;
    try
    {
      byte[] arrayOfByte = HttpUtil.a(BaseApplication.getContext(), this.jdField_a_of_type_JavaLangString, "GET", null, null);
      if (arrayOfByte != null)
      {
        localBitmap3 = localBitmap2;
        localObject4 = localObject6;
        localObject5 = localObject7;
        localBitmap2 = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length);
        localBitmap1 = localBitmap2;
        if (localBitmap2 != null)
        {
          localBitmap3 = localBitmap2;
          localObject4 = localBitmap2;
          localObject5 = localBitmap2;
          int i = localBitmap2.getWidth();
          localBitmap3 = localBitmap2;
          localObject4 = localBitmap2;
          localObject5 = localBitmap2;
          int j = localBitmap2.getHeight();
          localBitmap1 = localBitmap2;
          if (i * j > 8000)
          {
            localBitmap3 = localBitmap2;
            localObject4 = localBitmap2;
            localObject5 = localBitmap2;
            double d1 = Math.sqrt(8000.0D / (i * j));
            localBitmap3 = localBitmap2;
            localObject4 = localBitmap2;
            localObject5 = localBitmap2;
            localBitmap1 = Bitmap.createScaledBitmap(localBitmap2, (int)(i * d1), (int)(j * d1), true);
            localBitmap3 = localBitmap2;
            localObject4 = localBitmap2;
            localObject5 = localBitmap2;
            localBitmap2.recycle();
          }
          localBitmap3 = localBitmap1;
          localObject4 = localBitmap1;
          localObject5 = localBitmap1;
          this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoShareActivity.a = new WeakReference(localBitmap1);
        }
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        localIllegalArgumentException.printStackTrace();
        Object localObject1 = localBitmap3;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        Object localObject2 = localObject4;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Object localObject3 = localObject5;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoShareActivity.runOnUiThread(new tua(this, localBitmap1));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ttz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */