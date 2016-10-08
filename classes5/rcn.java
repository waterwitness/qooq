import android.support.v4.util.LruCache;
import com.tencent.mobileqq.dating.AnchorageManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;

public class rcn
  extends TimerTask
{
  public rcn(AnchorageManager paramAnchorageManager, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_ComTencentMobileqqDatingAnchorageManager.jdField_a_of_type_JavaLangString, 2, "autoRemoveAnchorage key:" + this.jdField_a_of_type_JavaLangString);
    }
    synchronized (this.jdField_a_of_type_ComTencentMobileqqDatingAnchorageManager)
    {
      AnchorageManager.a(this.jdField_a_of_type_ComTencentMobileqqDatingAnchorageManager).remove(this.jdField_a_of_type_JavaLangString);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rcn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */