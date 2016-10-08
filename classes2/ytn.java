import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.plugin.IPluginManager;
import cooperation.troop.TroopPluginManager;
import cooperation.troop.TroopPluginManager.TroopPluginCallback;

public class ytn
  implements Runnable
{
  public static final int a = 1001;
  public static final int b = 1002;
  Handler jdField_a_of_type_AndroidOsHandler;
  TroopPluginManager.TroopPluginCallback jdField_a_of_type_CooperationTroopTroopPluginManager$TroopPluginCallback;
  String jdField_a_of_type_JavaLangString;
  
  public ytn(TroopPluginManager paramTroopPluginManager, TroopPluginManager.TroopPluginCallback paramTroopPluginCallback, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsHandler = new yto(this, Looper.getMainLooper());
    this.jdField_a_of_type_CooperationTroopTroopPluginManager$TroopPluginCallback = paramTroopPluginCallback;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_CooperationTroopTroopPluginManager.a == null) {
      return;
    }
    this.jdField_a_of_type_CooperationTroopTroopPluginManager.a.a(this.jdField_a_of_type_JavaLangString, false, new ytp(this));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ytn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */