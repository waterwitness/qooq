import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.unifiedebug.SnapshotService;
import com.tencent.qphone.base.util.QLog;

public class vwl
  implements Runnable
{
  public vwl(SnapshotService paramSnapshotService, Bitmap paramBitmap, vwp paramvwp, vwr paramvwr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i(SnapshotService.a(), 2, "ScreenShot Finish Callback");
    }
    SnapshotService.a(this.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService, this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Vwp, this.jdField_a_of_type_Vwr);
    this.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService.a.post(new vwm(this));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vwl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */