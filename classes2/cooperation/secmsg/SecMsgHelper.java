package cooperation.secmsg;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.ResultReceiver;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecMsgHandler;
import com.tencent.mobileqq.app.SecMsgManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;

public class SecMsgHelper
{
  public static final int a = 1;
  public static final String a = "SecMsgExtra.MQQ.Receiver";
  public static final int b = 1;
  public static final String b = "com.tencent.mobileqq.secmsg.PushMsg";
  public static final int c = 2;
  public static final String c = "com.tencent.mobileqq.secmsg.NetReconnect";
  public static final int d = 3;
  public static final String d = "key_activity_style";
  public static final int e = 4;
  public static final String e = "extra_from_msg_tab";
  public static final int f = 0;
  public static final String f = "extra_tab_mode";
  public static final int g = 1;
  private static final String g = "SecMsgHelper";
  private static final String h = "com.tencent.mobileqq.secmsg.SecMsgRuntime";
  
  public SecMsgHelper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static Dialog a(Activity paramActivity)
  {
    paramActivity = new QQProgressDialog(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131492908));
    paramActivity.a("正在加载...");
    return paramActivity;
  }
  
  public static PluginRuntime a(BaseApplicationImpl paramBaseApplicationImpl)
  {
    try
    {
      Class localClass = Class.forName("com.tencent.mobileqq.secmsg.SecMsgRuntime");
      paramBaseApplicationImpl = localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      try
      {
        ClassLoader localClassLoader = PluginStatic.getOrCreateClassLoader(paramBaseApplicationImpl, "secmsg_plugin.apk");
        paramBaseApplicationImpl = localClassLoader.loadClass("com.tencent.mobileqq.secmsg.SecMsgRuntime");
        BasicClassTypeUtil.setClassLoader(true, localClassLoader);
      }
      catch (ClassNotFoundException paramBaseApplicationImpl)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
      do
      {
        return null;
        paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      } while ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof PluginRuntime)));
      paramBaseApplicationImpl = (PluginRuntime)paramBaseApplicationImpl;
      return paramBaseApplicationImpl;
    }
    catch (IllegalArgumentException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (IllegalAccessException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InstantiationException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InvocationTargetException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (NoSuchMethodException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    if (paramBaseApplicationImpl == null) {
      return null;
    }
  }
  
  public static void a(Activity paramActivity, ResultReceiver paramResultReceiver, String paramString, Intent paramIntent)
  {
    if (paramIntent != null) {}
    for (Intent localIntent = new Intent(paramIntent);; localIntent = new Intent())
    {
      localIntent.putExtra("SecMsgExtra.MQQ.Receiver", paramResultReceiver);
      localIntent.putExtra("userQqResources", 2);
      localIntent.putExtra("useSkinEngine", true);
      localIntent.putExtra("param_plugin_gesturelock", true);
      IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(1);
      localPluginParams.b = "secmsg_plugin.apk";
      localPluginParams.d = "secmsg_plugin";
      localPluginParams.jdField_a_of_type_JavaLangString = paramString;
      localPluginParams.e = "com.tencent.mobileqq.secmsg.activity.SecMsgSessionListActivity";
      if (!a()) {
        localPluginParams.jdField_a_of_type_AndroidAppDialog = a(paramActivity);
      }
      paramString = SecMsgPluginProxyActivity.class;
      paramResultReceiver = paramString;
      if (paramIntent != null)
      {
        paramResultReceiver = paramString;
        if (paramIntent.getIntExtra("key_activity_style", 0) == 1) {
          paramResultReceiver = SecMsgPluginProxyTransparentActivity.class;
        }
      }
      localPluginParams.jdField_a_of_type_JavaLangClass = paramResultReceiver;
      localPluginParams.jdField_a_of_type_AndroidContentIntent = localIntent;
      IPluginManager.a(paramActivity, localPluginParams);
      return;
    }
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, int paramInt, Intent paramIntent)
  {
    Object localObject = (SecMsgHandler)paramQQAppInterface.a(40);
    if (SecMsgHandler.a)
    {
      QQToast.a(paramActivity, "正在下载插件...", 0).b(paramActivity.getResources().getDimensionPixelSize(2131492908));
      return;
    }
    IPluginManager localIPluginManager = (IPluginManager)paramQQAppInterface.getManager(26);
    if ((localIPluginManager != null) && (!localIPluginManager.isPlugininstalled("secmsg_plugin.apk")))
    {
      if (!SecMsgHandler.a)
      {
        SecMsgHandler.c = 3;
        ((SecMsgHandler)localObject).a();
      }
      QQToast.a(paramActivity, "正在下载插件...", 0).b(paramActivity.getResources().getDimensionPixelSize(2131492908));
      return;
    }
    localObject = (SecMsgManager)paramQQAppInterface.getManager(56);
    if (paramIntent != null)
    {
      paramIntent = new Intent(paramIntent);
      paramIntent.putExtra("SecMsgExtra.MQQ.Receiver", ((SecMsgManager)localObject).a);
      paramIntent.putExtra("userQqResources", 2);
      paramIntent.putExtra("useSkinEngine", true);
      paramIntent.putExtra("param_plugin_gesturelock", true);
      localObject = new IPluginManager.PluginParams(1);
      ((IPluginManager.PluginParams)localObject).b = "secmsg_plugin.apk";
      ((IPluginManager.PluginParams)localObject).d = "secmsg_plugin";
      ((IPluginManager.PluginParams)localObject).jdField_a_of_type_JavaLangString = paramQQAppInterface.a();
      if (paramInt != 1) {
        break label287;
      }
      ((IPluginManager.PluginParams)localObject).e = "com.tencent.mobileqq.secmsg.activity.SecMsgSessionListActivity";
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.w("SecMsgHelper", 2, "target component name=" + ((IPluginManager.PluginParams)localObject).e);
      }
      if (!a()) {
        ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidAppDialog = a(paramActivity);
      }
      ((IPluginManager.PluginParams)localObject).jdField_a_of_type_JavaLangClass = SecMsgPluginProxyActivity.class;
      ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent = paramIntent;
      IPluginManager.a(paramActivity, (IPluginManager.PluginParams)localObject);
      return;
      paramIntent = new Intent();
      break;
      label287:
      if (paramInt == 2)
      {
        ((IPluginManager.PluginParams)localObject).e = "com.tencent.mobileqq.secmsg.activity.SecMsgSessionCreateActivity";
      }
      else if (paramInt == 3)
      {
        ((IPluginManager.PluginParams)localObject).e = "com.tencent.mobileqq.secmsg.activity.JoinedSecGroupActivity";
      }
      else if (paramInt == 4)
      {
        ((IPluginManager.PluginParams)localObject).e = "com.tencent.mobileqq.secmsg.activity.SecGroupInvitationActivity";
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.w("SecMsgHelper", 2, "Invalid target component name, use default");
        }
        ((IPluginManager.PluginParams)localObject).e = "com.tencent.mobileqq.secmsg.activity.SecMsgSessionListActivity";
      }
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, Intent paramIntent)
  {
    if (paramIntent != null) {}
    for (Intent localIntent = new Intent(paramIntent);; localIntent = new Intent())
    {
      localIntent.setFlags(localIntent.getFlags() & 0xFBFFFFFF & 0xDFFFFFFF);
      localIntent.putExtra("userQqResources", 2);
      localIntent.putExtra("useSkinEngine", true);
      IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(1);
      localPluginParams.b = "secmsg_plugin.apk";
      localPluginParams.d = "secmsg_plugin";
      localPluginParams.jdField_a_of_type_JavaLangString = paramString2;
      localPluginParams.e = paramString1;
      if (!a()) {
        localPluginParams.jdField_a_of_type_AndroidAppDialog = a(paramActivity);
      }
      paramString2 = SecMsgPluginProxyActivity.class;
      paramString1 = paramString2;
      if (paramIntent != null)
      {
        paramString1 = paramString2;
        if (paramIntent.getIntExtra("key_activity_style", 0) == 1) {
          paramString1 = SecMsgPluginProxyTransparentActivity.class;
        }
      }
      localPluginParams.jdField_a_of_type_JavaLangClass = paramString1;
      localPluginParams.jdField_a_of_type_AndroidContentIntent = localIntent;
      IPluginManager.a(paramActivity, localPluginParams);
      return;
    }
  }
  
  public static boolean a()
  {
    Object localObject = ((ActivityManager)BaseApplicationImpl.a().getSystemService("activity")).getRunningAppProcesses();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        if ((localRunningAppProcessInfo.processName.startsWith("com.tencent.mobileqq")) && ("com.tencent.mobileqq:secmsg".equalsIgnoreCase(localRunningAppProcessInfo.processName))) {
          return true;
        }
      }
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\secmsg\SecMsgHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */