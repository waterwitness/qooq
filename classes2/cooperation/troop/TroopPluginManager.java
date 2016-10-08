package cooperation.troop;

import android.app.Activity;
import android.app.Dialog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import cooperation.plugin.IPluginManager;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.manager.Manager;
import ytl;
import ytn;

public class TroopPluginManager
  implements Manager
{
  public static final int a = 0;
  public static final String a;
  public static final int b = 1;
  public static final int c = 2;
  QQAppInterface a;
  public IPluginManager a;
  public ConcurrentLinkedQueue a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = TroopPluginManager.class.getName();
  }
  
  public TroopPluginManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_CooperationPluginIPluginManager = ((IPluginManager)paramQQAppInterface.getManager(26));
  }
  
  public void a(Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2)
  {
    Dialog localDialog = TroopProxyActivity.a(paramActivity);
    localDialog.show();
    paramQQAppInterface.a(new ytl(this, paramString1, paramQQAppInterface, paramString2, paramInt1, paramString3, paramString4, localDialog, paramActivity, paramInt2));
    ((TroopHandler)paramQQAppInterface.a(20)).a(Long.parseLong(paramString1), Long.parseLong(paramString2));
  }
  
  public boolean a(String paramString, TroopPluginManager.TroopPluginCallback paramTroopPluginCallback)
  {
    if (this.jdField_a_of_type_CooperationPluginIPluginManager.isPlugininstalled(paramString))
    {
      paramTroopPluginCallback.a(0);
      return true;
    }
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(paramString)) && (paramTroopPluginCallback != null)) {
      paramTroopPluginCallback.a(1);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramString);
    ThreadManager.a(new ytn(this, paramTroopPluginCallback, paramString), 8, null, true);
    return false;
  }
  
  public void onDestroy()
  {
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if (localPluginCommunicationHandler != null)
    {
      localPluginCommunicationHandler.unregister("troop.troopmemcard.get_app_interface_data");
      localPluginCommunicationHandler.unregister("troop.manage.get_app_interface_data");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\troop\TroopPluginManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */