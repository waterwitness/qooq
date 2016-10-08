import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.olympic.OlympicManager;

public class trg
  implements Runnable
{
  public trg(OlympicManager paramOlympicManager, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    synchronized (OlympicManager.a(this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager))
    {
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager.a.getPreferences();
      if (localSharedPreferences != null) {
        localSharedPreferences.edit().putInt("isTorchbearer", this.jdField_a_of_type_Int).commit();
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\trg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */