import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.webviewplugin.OfflineWebResManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jhr
  implements Runnable
{
  public jhr(OfflineWebResManager paramOfflineWebResManager, SharedPreferences paramSharedPreferences)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    OfflineWebResManager.a(this.jdField_a_of_type_ComTencentBizWebviewpluginOfflineWebResManager);
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("Last_Check_Cache", System.currentTimeMillis()).commit();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jhr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */