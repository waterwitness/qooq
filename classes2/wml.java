import android.os.Handler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.ImageViewTouchBase;

public class wml
  implements Runnable
{
  public wml(ImageViewTouchBase paramImageViewTouchBase, float paramFloat1, long paramLong, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    long l = System.currentTimeMillis();
    float f1 = Math.min(this.jdField_a_of_type_Float, (float)(l - this.jdField_a_of_type_Long));
    float f2 = this.b;
    float f3 = this.c;
    this.jdField_a_of_type_ComTencentMobileqqWidgetImageViewTouchBase.zoomTo(f2 + f3 * f1, this.d, this.e);
    if (f1 < this.jdField_a_of_type_Float) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetImageViewTouchBase.mHandler.post(this);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wml.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */