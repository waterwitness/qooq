import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.util.MQLruCache;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.VipProfileCardPreviewActivity;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class tvp
  implements Runnable
{
  public tvp(VipProfileCardPreviewActivity paramVipProfileCardPreviewActivity, String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    for (;;)
    {
      int i;
      int j;
      int k;
      int m;
      try
      {
        localObject3 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject3).inJustDecodeBounds = true;
        localResources = this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.app.a().getResources();
        BitmapFactory.decodeFile(this.jdField_a_of_type_JavaLangString, (BitmapFactory.Options)localObject3);
        ((BitmapFactory.Options)localObject3).inJustDecodeBounds = false;
        ((BitmapFactory.Options)localObject3).inPreferredConfig = Bitmap.Config.RGB_565;
        ((BitmapFactory.Options)localObject3).inSampleSize = VipProfileCardPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity, (BitmapFactory.Options)localObject3, this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.aB, this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.aA);
        localObject1 = BitmapFactory.decodeFile(this.jdField_a_of_type_JavaLangString, (BitmapFactory.Options)localObject3);
        if (localObject1 == null) {
          return;
        }
        i = ((Bitmap)localObject1).getHeight();
        j = ((Bitmap)localObject1).getWidth();
        float f = this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.I / this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.H;
        k = Math.min(j, (int)(i * f));
        m = (int)(k / f);
        if (!QLog.isColorLevel()) {
          break label409;
        }
        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "image info imageWidth=" + k + ",imageHeight=" + m + ", sampleSize = " + ((BitmapFactory.Options)localObject3).inSampleSize);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        Resources localResources;
        Object localObject1;
        if (!QLog.isColorLevel()) {
          break label408;
        }
        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "OutOfMemoryError" + localOutOfMemoryError.getMessage());
        return;
        Object localObject3 = Bitmap.createBitmap(localOutOfMemoryError, 0, 0, k, m);
        localOutOfMemoryError.recycle();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "Background size not match screen size, create a new one to resize");
        Object localObject2 = localObject3;
        continue;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          break label408;
        }
        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "Exception when init background:" + localException.getMessage());
      }
      if (localObject1 != null)
      {
        i = Utils.a((Bitmap)localObject1);
        localObject1 = new BitmapDrawable(localResources, (Bitmap)localObject1);
        ((BitmapDrawable)localObject1).setTargetDensity(localResources.getDisplayMetrics());
        if (this.b != null) {
          BaseApplicationImpl.a.put(this.b, new Pair(((BitmapDrawable)localObject1).getConstantState(), Integer.valueOf(i)));
        }
        this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)localObject1);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.jdField_a_of_type_AndroidOsHandler != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(27);
        return;
      }
      label408:
      return;
      label409:
      if ((j != k) || (i != m)) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tvp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */