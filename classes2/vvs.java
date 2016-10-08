import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troopreward.OrientationAdapterImageView;
import com.tencent.qphone.base.util.QLog;

public class vvs
  extends Handler
{
  public vvs(OrientationAdapterImageView paramOrientationAdapterImageView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      this.a.invalidate();
    }
    if (QLog.isColorLevel()) {
      QLog.d("OrientationAdapterImageView", 2, "handleMessage:" + this.a.jdField_a_of_type_Int + "," + this.a.jdField_a_of_type_AndroidGraphicsBitmap);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vvs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */