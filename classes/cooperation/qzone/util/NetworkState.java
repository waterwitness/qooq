package cooperation.qzone.util;

import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ypq;

public class NetworkState
{
  public static final int a = 0;
  private static INetEventHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler;
  private static final String jdField_a_of_type_JavaLangString;
  private static List jdField_a_of_type_JavaUtilList;
  private static Map jdField_a_of_type_JavaUtilMap;
  public static final int b = 1;
  private static String b;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = NetworkState.class.getSimpleName();
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_JavaUtilList = new ArrayList();
    jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = new ypq();
    jdField_a_of_type_JavaUtilMap.put("unknown", Integer.valueOf(0));
    jdField_a_of_type_JavaUtilMap.put("cmnet", Integer.valueOf(1));
    jdField_a_of_type_JavaUtilMap.put("cmwap", Integer.valueOf(2));
    jdField_a_of_type_JavaUtilMap.put("3gnet", Integer.valueOf(3));
    jdField_a_of_type_JavaUtilMap.put("3gwap", Integer.valueOf(4));
    jdField_a_of_type_JavaUtilMap.put("uninet", Integer.valueOf(5));
    jdField_a_of_type_JavaUtilMap.put("uniwap", Integer.valueOf(6));
    jdField_a_of_type_JavaUtilMap.put("wifi", Integer.valueOf(7));
    jdField_a_of_type_JavaUtilMap.put("ctwap", Integer.valueOf(8));
    jdField_a_of_type_JavaUtilMap.put("ctnet", Integer.valueOf(9));
    jdField_a_of_type_JavaUtilMap.put("cmcc", Integer.valueOf(10));
    jdField_a_of_type_JavaUtilMap.put("unicom", Integer.valueOf(11));
    jdField_a_of_type_JavaUtilMap.put("cmct", Integer.valueOf(12));
    a();
  }
  
  public static int a()
  {
    if (!AppNetConnInfo.isNetSupport()) {}
    NetworkInfo localNetworkInfo;
    do
    {
      return 0;
      localNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
    } while ((localNetworkInfo == null) || (!localNetworkInfo.isConnectedOrConnecting()));
    if (1 == localNetworkInfo.getType()) {
      return 4;
    }
    int i = 5;
    if (jdField_a_of_type_JavaUtilMap.get(localNetworkInfo.getExtraInfo()) != null) {
      i = ((Integer)jdField_a_of_type_JavaUtilMap.get(localNetworkInfo.getExtraInfo())).intValue();
    }
    switch (i)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      return i;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
    }
  }
  
  public static String a()
  {
    String str;
    if (TextUtils.isEmpty(b))
    {
      str = ((TelephonyManager)BaseApplication.getContext().getSystemService("phone")).getSubscriberId();
      if ((str != null) && (!"".equals(str))) {
        break label46;
      }
      b = "unknown";
    }
    for (;;)
    {
      return b;
      label46:
      if ((str.startsWith("46000")) || (str.startsWith("46002"))) {
        b = "ChinaMobile";
      } else if (str.startsWith("46001")) {
        b = "ChinaUnicom";
      } else if (str.startsWith("46003")) {
        b = "ChinaTelecom";
      } else {
        b = "unknown";
      }
    }
  }
  
  public static String a(int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramInt & 0xFF).append(".").append(paramInt >> 8 & 0xFF).append(".").append(paramInt >> 16 & 0xFF).append(".").append(paramInt >> 24 & 0xFF);
    return localStringBuffer.toString();
  }
  
  public static void a()
  {
    try
    {
      AppNetConnInfo.registerNetChangeReceiver(BaseApplication.getContext(), jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static void a(NetworkState.NetworkStateListener paramNetworkStateListener)
  {
    if (paramNetworkStateListener == null) {
      return;
    }
    synchronized (jdField_a_of_type_JavaUtilList)
    {
      if (!jdField_a_of_type_JavaUtilList.contains(paramNetworkStateListener)) {
        jdField_a_of_type_JavaUtilList.add(paramNetworkStateListener);
      }
      return;
    }
  }
  
  public static boolean a()
  {
    if (AppNetConnInfo.isMobileConn())
    {
      try
      {
        i = ((Integer)jdField_a_of_type_JavaUtilMap.get(AppNetConnInfo.getCurrentAPN())).intValue();
        switch (i)
        {
        default: 
          return false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          int i = 5;
        }
        return true;
      }
      return false;
    }
    return false;
  }
  
  public static int b()
  {
    int i = 0;
    if (AppNetConnInfo.isWifiConn()) {
      i = 1;
    }
    while (!AppNetConnInfo.isMobileConn()) {
      return i;
    }
    switch (AppNetConnInfo.getMobileInfo())
    {
    default: 
      return 0;
    case 0: 
      return 3;
    case 1: 
      return 2;
    }
    return 4;
  }
  
  public static String b()
  {
    Object localObject;
    if (AppNetConnInfo.isWifiConn()) {
      localObject = "wifi";
    }
    String str;
    do
    {
      return (String)localObject;
      str = AppNetConnInfo.getCurrentAPN();
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    return "unknown";
  }
  
  public static void b(NetworkState.NetworkStateListener paramNetworkStateListener)
  {
    synchronized (jdField_a_of_type_JavaUtilList)
    {
      jdField_a_of_type_JavaUtilList.remove(paramNetworkStateListener);
      return;
    }
  }
  
  private static void b(boolean paramBoolean)
  {
    synchronized (jdField_a_of_type_JavaUtilList)
    {
      NetworkState.NetworkStateListener[] arrayOfNetworkStateListener = new NetworkState.NetworkStateListener[jdField_a_of_type_JavaUtilList.size()];
      jdField_a_of_type_JavaUtilList.toArray(arrayOfNetworkStateListener);
      if (arrayOfNetworkStateListener != null)
      {
        int j = arrayOfNetworkStateListener.length;
        int i = 0;
        if (i < j)
        {
          arrayOfNetworkStateListener[i].a(paramBoolean);
          i += 1;
        }
      }
    }
  }
  
  public static boolean b()
  {
    return AppNetConnInfo.isMobileConn();
  }
  
  public static boolean c()
  {
    return AppNetConnInfo.isWifiConn();
  }
  
  public static boolean d()
  {
    return AppNetConnInfo.isNetSupport();
  }
  
  public static boolean e()
  {
    String str = b();
    if (TextUtils.isEmpty(str)) {}
    while ((!str.equalsIgnoreCase("UNIWAP")) && (!str.equalsIgnoreCase("UNINET")) && (!str.equalsIgnoreCase("3GWAP")) && (!str.equalsIgnoreCase("3GNET")) && (!str.equalsIgnoreCase("WONET"))) {
      return false;
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\cooperation\qzone\util\NetworkState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */