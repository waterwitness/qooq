package cooperation.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqreader.QRUtility;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import yed;
import yee;

public class PluginPreInstaller
{
  private static final int jdField_a_of_type_Int = 10;
  private static final String jdField_a_of_type_JavaLangString = "PluginPreInstaller";
  private static final SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyyMMdd");
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString;
  private static final int jdField_b_of_type_Int = 2;
  private static final String jdField_b_of_type_JavaLangString = "plugin_pre_install_qq_version";
  private static final String[] jdField_b_of_type_ArrayOfJavaLangString;
  private static final String jdField_c_of_type_JavaLangString = "total_retried_times_";
  private static final String[] jdField_c_of_type_ArrayOfJavaLangString;
  private static final String jdField_d_of_type_JavaLangString = "today_retried_times_";
  private static final String[] jdField_d_of_type_ArrayOfJavaLangString;
  private static final String e = "last_retry_day_";
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private OnPluginInstallListener jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener = new yed(this);
  private IPluginManager jdField_a_of_type_CooperationPluginIPluginManager;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "qlink_plugin.apk", "Photoplus.apk" };
    b = new String[] { "qqreaderplugin.apk", "comic_plugin.apk" };
    c = new String[] { "qqhotspot_plugin.apk" };
    d = new String[0];
  }
  
  public PluginPreInstaller(Context paramContext, IPluginManager paramIPluginManager, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_CooperationPluginIPluginManager = paramIPluginManager;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    c();
  }
  
  private int a(String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext).getInt("total_retried_times_" + paramString, 0);
  }
  
  private List a()
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int k = arrayOfString.length;
    int i = 0;
    while (i < k)
    {
      localArrayList.add(arrayOfString[i]);
      i += 1;
    }
    if (NetworkUtil.b(this.jdField_a_of_type_AndroidContentContext))
    {
      arrayOfString = b;
      k = arrayOfString.length;
      i = j;
      while (i < k)
      {
        localArrayList.add(arrayOfString[i]);
        i += 1;
      }
    }
    return localArrayList;
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PluginPreInstaller", 4, "installPlugin plugin = " + paramString + ", totalTimes = " + paramInt1 + ", todayTimes = " + paramInt2);
    }
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext).edit();
    Object localObject = new Date();
    localObject = jdField_a_of_type_JavaTextSimpleDateFormat.format((Date)localObject);
    localEditor.putInt("total_retried_times_" + paramString, paramInt1 + 1);
    localEditor.putInt("today_retried_times_" + paramString, paramInt2 + 1);
    localEditor.putString("last_retry_day_" + paramString, (String)localObject);
    localEditor.commit();
    this.jdField_a_of_type_CooperationPluginIPluginManager.installPlugin(paramString, this.jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener);
    if (("qqreaderplugin.apk".equals(paramString)) && (QRUtility.a(this.jdField_a_of_type_AndroidContentContext) == -1))
    {
      ThreadManager.a(new yee(this), 5, null, false);
      if (QLog.isColorLevel()) {
        QLog.e("PluginPreInstaller", 2, "");
      }
    }
  }
  
  private int b(String paramString)
  {
    int i = 0;
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext);
    Date localDate = new Date();
    if (jdField_a_of_type_JavaTextSimpleDateFormat.format(localDate).equals(localSharedPreferences.getString("last_retry_day_" + paramString, ""))) {
      i = localSharedPreferences.getInt("today_retried_times_" + paramString, 0);
    }
    return i;
  }
  
  private void c()
  {
    if (!PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext).getString("plugin_pre_install_qq_version", "").equals(DeviceInfoUtil.c()))
    {
      SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext).edit();
      Iterator localIterator = a().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localEditor.remove("total_retried_times_" + str);
      }
      localEditor.commit();
    }
  }
  
  public void a()
  {
    try
    {
      Iterator localIterator = a().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        try
        {
          if (this.jdField_a_of_type_CooperationPluginIPluginManager.isPlugininstalled(str)) {
            continue;
          }
          int i = a(str);
          if (i >= 10) {
            continue;
          }
          int j = b(str);
          if (j >= 2) {
            continue;
          }
          a(str, i, j);
        }
        catch (Exception localException) {}
        if (QLog.isColorLevel()) {
          QLog.e("PluginPreInstaller", 2, "preinstall plugin : " + str + " failed.", localException);
        }
      }
    }
    finally {}
  }
  
  public void b()
  {
    for (;;)
    {
      int i;
      try
      {
        if (AppNetConnInfo.isWifiConn())
        {
          if (QLog.isColorLevel()) {
            QLog.e("PluginPreInstaller", 2, "preinstall start,wifi_reinstall_only.");
          }
          String[] arrayOfString = d;
          int j = arrayOfString.length;
          i = 0;
          if (i < j)
          {
            String str = arrayOfString[i];
            try
            {
              if (!this.jdField_a_of_type_CooperationPluginIPluginManager.isPlugininstalled(str))
              {
                a(str, a(str), b(str));
              }
              else if ("QQWifiPlugin.apk".equals(str))
              {
                Intent localIntent = new Intent("com.tencent.mobileqq.cooperation.plugin." + str);
                localIntent.putExtra("plugin", str);
                this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
              }
            }
            catch (Exception localException)
            {
              if (!QLog.isColorLevel()) {
                break label180;
              }
            }
            QLog.e("PluginPreInstaller", 2, "preinstall plugin : " + str + " failed.", localException);
          }
        }
      }
      finally {}
      return;
      label180:
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\plugin\PluginPreInstaller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */