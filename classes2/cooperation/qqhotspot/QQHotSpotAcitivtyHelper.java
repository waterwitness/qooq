package cooperation.qqhotspot;

import android.content.Context;
import android.os.Bundle;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import mqq.app.AppRuntime;

public class QQHotSpotAcitivtyHelper
{
  public static final String a = "com.qqhotspot.activity.WiFiHotSpotListActivity";
  public static String[][] a;
  public static final String b = "com.qqhotspot.activity.WiFiConnectActivity";
  public static final String c = "com.qqhotspot.activity.WiFiConnErrorActivity";
  public static final String d = "com.qqhotspot.activity.WiFiHintActivity";
  private static final String e = "com.qqhotspot.base.QQHotSpotAppInterface";
  private static final String f = "QQHotSpotAcitivtyHelper";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    String[] arrayOfString = { "com.qqhotspot.activity.WiFiHotSpotListActivity", "com.qqhotspot.activity.WiFiHotSpotListActivity" };
    a = new String[][] { { "com.qqhotspot.activity.WiFiConnectActivity", "com.qqhotspot.activity.WiFiConnectActivity" }, { "com.qqhotspot.activity.WiFiConnErrorActivity", "com.qqhotspot.activity.WiFiConnErrorActivity" }, arrayOfString, { "com.qqhotspot.activity.WiFiHintActivity", "com.qqhotspot.activity.WiFiHintActivity" } };
  }
  
  public static AppRuntime a(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    if ((paramBaseApplicationImpl == null) || (paramString == null)) {
      return null;
    }
    try
    {
      paramString = Class.forName("com.qqhotspot.base.QQHotSpotAppInterface");
      paramBaseApplicationImpl = paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      for (;;)
      {
        try
        {
          QLog.e("QQHotSpotAcitivtyHelper", 1, "*createQQHotspotAppInterface load class fail");
          return null;
        }
        catch (ClassNotFoundException paramBaseApplicationImpl)
        {
          paramBaseApplicationImpl.printStackTrace();
        }
        paramString = paramString;
        paramString = PluginStatic.getOrCreateClassLoader(paramBaseApplicationImpl, "qqhotspot_plugin.apk");
        paramBaseApplicationImpl = paramString.loadClass("com.qqhotspot.base.QQHotSpotAppInterface");
        BasicClassTypeUtil.setClassLoader(true, paramString);
      }
      do
      {
        return null;
        paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      } while ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof AppRuntime)));
      paramBaseApplicationImpl = (AppRuntime)paramBaseApplicationImpl;
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
    if (paramBaseApplicationImpl != null) {}
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, Bundle paramBundle, int paramInt) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqhotspot\QQHotSpotAcitivtyHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */