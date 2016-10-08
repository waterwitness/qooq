package cooperation.thirdpay;

import CardPay.LBSInfo;
import android.content.SharedPreferences;
import android.nfc.NfcAdapter;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.CardPayHandler;
import com.tencent.mobileqq.app.CardPayObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import mqq.app.AppRuntime;
import ytk;

public class ThirdPayManager
{
  private static CardPayObserver a;
  protected static final String a = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCrkUA+dDEQT52svdheRw04+xrExuTvNj3g7pjcyUkH3+86FiYNhHtyWJc11BywUZ2Ey3RomCyTb/szl5qQEJqR7UC5z4mhLrhgXlbRI0BgmI/LhaMRsfskGM7ziyQ2ZpS0qbHX2xoum6ou/541/VePIwmcnIk6eWUx6GYnA4euZQIDAQAB";
  
  public ThirdPayManager()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static CardPayObserver a()
  {
    if (a == null) {
      a = new CardPayObserver();
    }
    return a;
  }
  
  public static AppRuntime a(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    int i = 0;
    if ((paramBaseApplicationImpl == null) || (paramString == null)) {
      return null;
    }
    try
    {
      localObject = BaseApplication.getContext();
      if (Build.VERSION.SDK_INT > 10) {
        i = 4;
      }
      SharedPreferences localSharedPreferences = ((BaseApplication)localObject).getSharedPreferences("mobileQQ", i);
      localObject = "";
      if (localSharedPreferences != null) {
        localObject = localSharedPreferences.getString("nfc_cur_pluginid", "");
      }
      if (QLog.isColorLevel()) {
        QLog.i("ThirdPayManager", 2, " processName=" + paramString + " curPluginId=" + (String)localObject);
      }
      try
      {
        paramString = Class.forName("com.tencent.mobileqq.thirdpay.ThirdPayInterface");
        paramBaseApplicationImpl = paramString;
      }
      catch (ClassNotFoundException paramString)
      {
        for (;;)
        {
          paramString = PluginStatic.getOrCreateClassLoader(paramBaseApplicationImpl, (String)localObject);
          paramBaseApplicationImpl = paramString.loadClass("com.tencent.mobileqq.thirdpay.ThirdPayInterface");
          BasicClassTypeUtil.setClassLoader(true, paramString);
        }
      }
      if (paramBaseApplicationImpl == null)
      {
        if (!QLog.isColorLevel()) {
          break label235;
        }
        QLog.e("ThirdPayManager", 2, "*createThirdPayAppInterface load class fail");
      }
    }
    catch (ClassNotFoundException paramBaseApplicationImpl)
    {
      Object localObject;
      paramBaseApplicationImpl.printStackTrace();
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
    label235:
    return null;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    SosoInterface.a(new ytk(3, true, true, 0L, false, false, "ThirdPayManager", paramQQAppInterface));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    if ((paramQQAppInterface == null) || (paramBundle == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ThirdPayManager", 2, "getPayOrder == app || null == params");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ThirdPayManager", 2, paramBundle.toString());
    }
    paramQQAppInterface = new CardPayHandler(paramQQAppInterface);
    paramOnInvokeFinishLinstener = new HashMap();
    paramOnInvokeFinishLinstener.put("subCmd", Integer.valueOf(1));
    paramOnInvokeFinishLinstener.put("payChannel", paramBundle.get("payChannel"));
    paramOnInvokeFinishLinstener.put("payChannelSubId", paramBundle.get("payChannelSubId"));
    paramOnInvokeFinishLinstener.put("orderId", paramBundle.get("orderId"));
    paramQQAppInterface.a("CardPayControl.queryPayOrder", paramOnInvokeFinishLinstener);
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ThirdPayManager", 2, "removeObserver");
      }
      paramQQAppInterface.b(a);
      a = null;
    }
    CardPayObserver.a();
  }
  
  private static void b(QQAppInterface paramQQAppInterface, LBSInfo paramLBSInfo)
  {
    if (paramQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ThirdPayManager", 2, "app init err");
      }
      return;
    }
    paramQQAppInterface = new CardPayHandler(paramQQAppInterface);
    HashMap localHashMap = new HashMap();
    localHashMap.put("subCmd", Integer.valueOf(1));
    localHashMap.put("pid", Integer.valueOf(0));
    localHashMap.put("lbsInfo", paramLBSInfo);
    if ((Build.VERSION.SDK_INT < 10) || (NfcAdapter.getDefaultAdapter(BaseApplicationImpl.getContext()) == null)) {
      localHashMap.put("nfc_sup", Integer.valueOf(0));
    }
    for (;;)
    {
      paramQQAppInterface.a("CardPayControl.queryChannel", localHashMap);
      return;
      localHashMap.put("nfc_sup", Integer.valueOf(1));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\thirdpay\ThirdPayManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */