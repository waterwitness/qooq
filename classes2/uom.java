import android.os.Handler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.secspy.SecSpyFileManager;
import com.tencent.mobileqq.secspy.SecSpyFileManager.UploadProgressInfo;
import com.tencent.mobileqq.unifiedebug.UnifiedDebugManager;

public class uom
  implements Runnable
{
  public uom(SecSpyFileManager paramSecSpyFileManager, SecSpyFileManager.UploadProgressInfo paramUploadProgressInfo, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (SecSpyFileManager.UploadProgressInfo.a(this.jdField_a_of_type_ComTencentMobileqqSecspySecSpyFileManager$UploadProgressInfo)) {
      return;
    }
    float f = SecSpyFileManager.UploadProgressInfo.a(this.jdField_a_of_type_ComTencentMobileqqSecspySecSpyFileManager$UploadProgressInfo) / SecSpyFileManager.UploadProgressInfo.b(this.jdField_a_of_type_ComTencentMobileqqSecspySecSpyFileManager$UploadProgressInfo);
    this.jdField_a_of_type_ComTencentMobileqqSecspySecSpyFileManager.a(this.jdField_a_of_type_Long, 3, new Object[] { Integer.valueOf((int)(f * 100.0F)) });
    this.jdField_a_of_type_ComTencentMobileqqSecspySecSpyFileManager.a.a().postDelayed(this, 20000L);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */