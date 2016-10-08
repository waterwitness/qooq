package cooperation.troop;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;

public class TroopManageProxyActivity
  extends TroopBaseProxyActivity
{
  public static final String a = "troop_manage_plugin.apk";
  public static final String b = "com.tencent.mobileqq.activity.TroopManageActivity";
  public static final String c = "com.tencent.mobileqq.activity.SetTroopAdminsActivity";
  public static final String d = "com.tencent.mobileqq.activity.TroopSetJoinTypeActivity";
  
  public TroopManageProxyActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(String paramString1, String paramString2, Class paramClass, Activity paramActivity, Intent paramIntent, Dialog paramDialog, String paramString3, String paramString4, int paramInt)
  {
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(1);
    localPluginParams.jdField_b_of_type_JavaLangString = paramString1;
    localPluginParams.d = paramString2;
    localPluginParams.jdField_a_of_type_JavaLangString = paramString4;
    localPluginParams.e = paramString3;
    localPluginParams.jdField_a_of_type_JavaLangClass = paramClass;
    localPluginParams.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localPluginParams.jdField_a_of_type_AndroidAppDialog = paramDialog;
    paramIntent.putExtra("userQqResources", 1);
    paramIntent.putExtra("param_plugin_gesturelock", true);
    localPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("useSkinEngine", true);
    localPluginParams.jdField_b_of_type_Int = paramInt;
    localPluginParams.c = 10000;
    localPluginParams.f = null;
    IPluginManager.a(paramActivity, localPluginParams);
    ReportController.b(null, "P_CliOper", "BizTechReport", "", "troop_manage_plugin", "load_plugin_v2", 0, 0, null, null, null, null);
  }
  
  public String getPluginID()
  {
    return "troop_manage_plugin.apk";
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\troop\TroopManageProxyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */