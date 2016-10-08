import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.olympic.OlympicHandler;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.olympic.TorchInfo;
import java.io.ByteArrayOutputStream;

public class trh
  implements Runnable
{
  public trh(OlympicManager paramOlympicManager, TorchInfo paramTorchInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    synchronized (OlympicManager.b(this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager))
    {
      new ByteArrayOutputStream();
      OlympicManager.a(this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager);
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager.a.getPreferences().getBoolean("olympic_setting_ever_fetch_flag_switch_here", false);
      if ((this.jdField_a_of_type_ComTencentMobileqqOlympicTorchInfo.transfer_num == 1L) || (!bool)) {
        ((OlympicHandler)this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager.a.a(94)).c();
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\trh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */