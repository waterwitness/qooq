import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.redtouch.RedTouchTextView;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import java.io.File;

public class ufe
  implements Runnable
{
  public ufe(RedTouchTextView paramRedTouchTextView, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = new File(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchTextView.getContext().getFilesDir(), this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchTextView.b);
    Bitmap localBitmap;
    if (((File)localObject).exists())
    {
      localBitmap = this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchTextView.a((File)localObject);
      localObject = localBitmap;
      if (this.jdField_a_of_type_Int == 1) {
        localObject = ImageUtil.a(localBitmap, localBitmap.getWidth(), localBitmap.getWidth(), localBitmap.getHeight());
      }
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchTextView.a = new BitmapDrawable((Bitmap)localObject);
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchTextView.a();
    }
    while (RedTouchTextView.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchTextView)) {
      return;
    }
    RedTouchTextView.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchTextView, true);
    if (HttpDownloadUtil.a(null, this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchTextView.b, (File)localObject))
    {
      localBitmap = this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchTextView.a((File)localObject);
      localObject = localBitmap;
      if (this.jdField_a_of_type_Int == 1) {
        localObject = ImageUtil.a(localBitmap, localBitmap.getWidth(), localBitmap.getWidth(), localBitmap.getHeight());
      }
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchTextView.a = new BitmapDrawable((Bitmap)localObject);
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchTextView.a();
    }
    RedTouchTextView.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchTextView, false);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ufe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */