package cooperation.troop;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.statistics.ReportController;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.troop.troopmemcard.TroopMemCardCmd;

public class TroopMemberCardProxyActivity
  extends TroopBaseProxyActivity
{
  public static final String a = "troop_member_card_plugin.apk";
  public static final String b = "com.tencent.mobileqq.memcard.plugin.TroopMemberCardMoreInfoActivity";
  public static final String c = "com.tencent.mobileqq.memcard.plugin.RecentSaidActivity";
  public static final String d = "com.tencent.mobileqq.memcard.plugin.TroopMemberGagActivity";
  public static final String e = "com.tencent.mobileqq.memcard.plugin.TroopMemberTitleActivity";
  public static final String f = "troop_uin";
  public static final String g = "member_uin";
  public static final String h = "member_is_shield";
  public static final String i = "param_key_troopUin";
  public static final String j = "param_key_memberUin";
  
  public TroopMemberCardProxyActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, Intent paramIntent, String paramString, int paramInt)
  {
    Object localObject = new TroopMemCardCmd(paramQQAppInterface);
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if (localPluginCommunicationHandler != null) {
      localPluginCommunicationHandler.register((RemoteCommand)localObject);
    }
    localObject = new IPluginManager.PluginParams(1);
    ((IPluginManager.PluginParams)localObject).jdField_b_of_type_JavaLangString = "troop_member_card_plugin.apk";
    ((IPluginManager.PluginParams)localObject).d = "群成员名片更多";
    ((IPluginManager.PluginParams)localObject).jdField_a_of_type_JavaLangString = paramQQAppInterface.a();
    ((IPluginManager.PluginParams)localObject).e = paramString;
    ((IPluginManager.PluginParams)localObject).jdField_a_of_type_JavaLangClass = TroopMemberCardProxyActivity.class;
    paramQQAppInterface = paramIntent;
    if (paramIntent == null) {
      paramQQAppInterface = new Intent();
    }
    ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent = paramQQAppInterface;
    ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidAppDialog = a(paramActivity);
    ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent.putExtra("userQqResources", 2);
    ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent.putExtra("param_plugin_gesturelock", true);
    ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent.putExtra("useSkinEngine", true);
    ((IPluginManager.PluginParams)localObject).jdField_b_of_type_Int = paramInt;
    ((IPluginManager.PluginParams)localObject).c = 10000;
    ((IPluginManager.PluginParams)localObject).f = null;
    IPluginManager.a(paramActivity, (IPluginManager.PluginParams)localObject);
    ReportController.b(null, "P_CliOper", "BizTechReport", "", "troop_member_card_plugin", "load_plugin", 0, 1, null, null, null, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, Class paramClass, Activity paramActivity, Intent paramIntent, Dialog paramDialog, String paramString3, String paramString4, int paramInt)
  {
    paramQQAppInterface = new TroopMemCardCmd(paramQQAppInterface);
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if (localPluginCommunicationHandler != null) {
      localPluginCommunicationHandler.register(paramQQAppInterface);
    }
    paramQQAppInterface = new IPluginManager.PluginParams(1);
    paramQQAppInterface.jdField_b_of_type_JavaLangString = paramString1;
    paramQQAppInterface.d = paramString2;
    paramQQAppInterface.jdField_a_of_type_JavaLangString = paramString4;
    paramQQAppInterface.e = paramString3;
    paramQQAppInterface.jdField_a_of_type_JavaLangClass = paramClass;
    paramQQAppInterface.jdField_a_of_type_AndroidContentIntent = paramIntent;
    paramQQAppInterface.jdField_a_of_type_AndroidAppDialog = paramDialog;
    paramQQAppInterface.jdField_a_of_type_AndroidContentIntent.putExtra("userQqResources", 2);
    paramQQAppInterface.jdField_a_of_type_AndroidContentIntent.putExtra("param_plugin_gesturelock", true);
    paramQQAppInterface.jdField_a_of_type_AndroidContentIntent.putExtra("useSkinEngine", true);
    paramQQAppInterface.jdField_b_of_type_Int = paramInt;
    paramQQAppInterface.c = 10000;
    paramQQAppInterface.f = null;
    IPluginManager.a(paramActivity, paramQQAppInterface);
    ReportController.b(null, "P_CliOper", "BizTechReport", "", "troop_member_card_plugin", "load_plugin", 0, 0, null, null, null, null);
  }
  
  public String getPluginID()
  {
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\troop\TroopMemberCardProxyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */