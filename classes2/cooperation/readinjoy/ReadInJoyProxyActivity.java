package cooperation.readinjoy;

import android.app.Activity;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.readinjoy.ReadInJoyHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;

public class ReadInJoyProxyActivity
  extends PluginProxyActivity
{
  public static final String a = "com.tencent.qqreadinjoy.ReadInJoyStartActivity";
  public static final String b = "com.tencent.qqreadinjoy.ReadInJoyVideoPlayerActivity";
  
  public ReadInJoyProxyActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected static Class a(String paramString)
  {
    if (paramString.equals("com.tencent.qqreadinjoy.ReadInJoyStartActivity")) {
      return ReadInJoyProxyActivity.ReadInJoyStartActivity.class;
    }
    if (paramString.equals("com.tencent.qqreadinjoy.ReadInJoyVideoPlayerActivity")) {
      return ReadInJoyProxyActivity.ReadInJoyLandscapeActivity.class;
    }
    return ReadInJoyProxyActivity.class;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, Intent paramIntent, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if ((paramQQAppInterface != null) && ((paramQQAppInterface instanceof QQAppInterface))) {
      ((ReadInJoyHandler)paramQQAppInterface.a(62)).a();
    }
    paramIntent.addFlags(67108864);
    paramIntent.putExtra("userQqResources", 2);
    paramIntent.putExtra("useSkinEngine", false);
    paramQQAppInterface = new IPluginManager.PluginParams(1);
    paramQQAppInterface.jdField_b_of_type_JavaLangString = "readinjoy_plugin.apk";
    paramQQAppInterface.d = paramActivity.getString(2131366416);
    paramQQAppInterface.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("account");
    paramQQAppInterface.e = "com.tencent.qqreadinjoy.ReadInJoyStartActivity";
    paramQQAppInterface.jdField_a_of_type_JavaLangClass = a("com.tencent.qqreadinjoy.ReadInJoyStartActivity");
    paramQQAppInterface.jdField_a_of_type_AndroidContentIntent = paramIntent;
    paramQQAppInterface.jdField_b_of_type_Int = paramInt;
    paramQQAppInterface.jdField_a_of_type_AndroidAppDialog = null;
    paramQQAppInterface.c = 10000;
    paramQQAppInterface.f = null;
    paramQQAppInterface.jdField_a_of_type_Boolean = false;
    IPluginManager.a(paramActivity, paramQQAppInterface);
  }
  
  protected Class getProxyActivity(String paramString)
  {
    return a(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\readinjoy\ReadInJoyProxyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */