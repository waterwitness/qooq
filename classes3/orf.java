import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.AsyncTask;
import android.os.Handler;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.activity.PortraitImageview;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;
import com.tencent.mobileqq.activity.photo.RegionView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.bitmapcreator.ExifBitmapCreator;
import com.tencent.mobileqq.widget.QQToast;

public class orf
  extends AsyncTask
{
  private int jdField_a_of_type_Int;
  
  private orf(PhotoCropActivity paramPhotoCropActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = 1;
    int j = 1;
    int m = j;
    if (paramInt1 != 0)
    {
      m = j;
      if (paramInt2 != 0)
      {
        m = j;
        if (paramInt1 != -1)
        {
          if (paramInt2 != -1) {
            break label43;
          }
          m = j;
        }
      }
    }
    label43:
    int k;
    label55:
    do
    {
      return m;
      j = paramOptions.outHeight;
      k = paramOptions.outWidth;
      if (j > paramInt2) {
        break;
      }
      m = i;
    } while (k <= paramInt1);
    int n = Math.round(j / paramInt2);
    m = Math.round(k / paramInt1);
    if (n > m) {}
    for (;;)
    {
      m = i;
      if (n < 2) {
        break;
      }
      k /= 2;
      j /= 2;
      i *= 2;
      break label55;
      n = m;
    }
  }
  
  protected Bitmap a(Void... paramVarArgs)
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_Boolean) {}
      for (paramVarArgs = Bitmap.Config.ARGB_8888;; paramVarArgs = Bitmap.Config.RGB_565)
      {
        localOptions.inPreferredConfig = paramVarArgs;
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_c_of_type_JavaLangString, localOptions);
        localOptions.inSampleSize = a(localOptions, 1280, 1280);
        localOptions.inJustDecodeBounds = false;
        paramVarArgs = BitmapFactory.decodeFile(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_c_of_type_JavaLangString, localOptions);
        return new ExifBitmapCreator(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_c_of_type_JavaLangString).a(paramVarArgs);
      }
      return null;
    }
    catch (OutOfMemoryError paramVarArgs)
    {
      this.jdField_a_of_type_Int = 1;
      return null;
    }
    catch (Exception paramVarArgs)
    {
      this.jdField_a_of_type_Int = 2;
    }
  }
  
  protected void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview.setRestrict(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.b, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview.setImageBitmap(paramBitmap);
      paramBitmap = new ViewGroup.LayoutParams(-1, -1);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoRegionView = new RegionView(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.d, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.e, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.f, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview, paramBitmap);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoRegionView, paramBitmap);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(-1, 250L);
      }
      return;
    }
    if (this.jdField_a_of_type_Int == 1) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity, "内存不足，加载失败", 0).a();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.finish();
      return;
      if (this.jdField_a_of_type_Int == 2) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity, "图片加载失败", 0).a();
      } else {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity, "图片加载失败，图片可能已损坏", 0).a();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\orf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */