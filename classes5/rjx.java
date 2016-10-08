import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;

public class rjx
  implements Runnable
{
  public rjx(EmoticonMainPanel paramEmoticonMainPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "preloadWebProcess");
    }
    try
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        return;
      }
      WebProcessManager localWebProcessManager = (WebProcessManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12);
      if (localWebProcessManager != null)
      {
        SharedPreferences localSharedPreferences = this.a.jdField_a_of_type_AndroidContentContext.getSharedPreferences("emoticon_panel_" + this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
        long l = localSharedPreferences.getLong("sp_key_market_open_time", 0L);
        if (System.currentTimeMillis() - l < -1702967296L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonMainPanel", 2, "preloadWebProcess, startWebProcess for market open strategy");
          }
          localWebProcessManager.a(-1, new rjy(this));
          return;
        }
        l = localSharedPreferences.getLong("sp_key_send_h5_magic_face_time", 0L);
        if (System.currentTimeMillis() - l >= -1702967296L) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonMainPanel", 2, "preloadWebProcess, startWebProcess for h5 magic send strategy");
        }
        localWebProcessManager.a(-1, new rjz(this));
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("EmoticonMainPanel", 1, "preloadWebProcess, exception=" + MsfSdkUtils.getStackTraceString(localException));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "preloadWebProcess, web process alive already");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rjx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */