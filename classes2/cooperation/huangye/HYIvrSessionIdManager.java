package cooperation.huangye;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.huangye.download.DownloadParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import mqq.manager.TicketManager;
import org.json.JSONObject;
import ycs;
import yct;

public class HYIvrSessionIdManager
{
  public static final int a = -3;
  private static HYIvrSessionIdManager jdField_a_of_type_CooperationHuangyeHYIvrSessionIdManager;
  public static final int b = -1;
  public static final String b = "http://pubacc.mobile.qq.com/yellowpage/mqqweb/createsession";
  public static final int c = 0;
  public String a;
  private Vector jdField_a_of_type_JavaUtilVector;
  
  public HYIvrSessionIdManager()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = HYIvrSessionIdManager.class.getSimpleName();
    this.jdField_a_of_type_JavaUtilVector = new Vector();
  }
  
  private int a(String paramString1, String paramString2, String paramString3)
  {
    int i = 0;
    if (!NetworkUtil.h(BaseApplication.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "requestIvrSessionId network is not available.");
      }
      i = -1;
    }
    do
    {
      return i;
      ycs localycs = new ycs(this, null);
      ArrayList localArrayList = new ArrayList();
      DownloadParams localDownloadParams = new DownloadParams();
      localDownloadParams.jdField_a_of_type_JavaLangString = a(paramString1);
      localDownloadParams.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      localDownloadParams.jdField_a_of_type_JavaUtilHashMap.put("Cookie", a(paramString2, paramString3));
      localDownloadParams.jdField_a_of_type_JavaLangObject = paramString1;
      localArrayList.add(localDownloadParams);
      localycs.execute(new ArrayList[] { localArrayList });
    } while (!QLog.isColorLevel());
    QLog.i(this.jdField_a_of_type_JavaLangString, 2, "requestIvrSessionId start download.");
    return 0;
  }
  
  public static HYIvrSessionIdManager a()
  {
    try
    {
      if (jdField_a_of_type_CooperationHuangyeHYIvrSessionIdManager == null) {
        jdField_a_of_type_CooperationHuangyeHYIvrSessionIdManager = new HYIvrSessionIdManager();
      }
      HYIvrSessionIdManager localHYIvrSessionIdManager = jdField_a_of_type_CooperationHuangyeHYIvrSessionIdManager;
      return localHYIvrSessionIdManager;
    }
    finally {}
  }
  
  public int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    TicketManager localTicketManager = (TicketManager)paramQQAppInterface.getManager(2);
    String str = paramQQAppInterface.getAccount();
    if (localTicketManager != null) {}
    for (paramQQAppInterface = localTicketManager.getSkey(paramQQAppInterface.getAccount());; paramQQAppInterface = null)
    {
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramQQAppInterface))) {}
      for (int i = a(paramString, str, paramQQAppInterface);; i = -3)
      {
        if (i < 0) {
          a(paramString, null, null, null);
        }
        return i;
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_a_of_type_JavaLangString, 2, "account == null:" + TextUtils.isEmpty(str) + " or skey == null:" + TextUtils.isEmpty(paramQQAppInterface));
        }
      }
    }
  }
  
  String a(String paramString)
  {
    Object localObject = HYSharedPref.a().a("FileConfigure", "");
    str3 = "http://pubacc.mobile.qq.com/yellowpage/mqqweb/createsession";
    String str1 = str3;
    if (!((String)localObject).equals("")) {}
    try
    {
      localObject = new JSONObject((String)localObject);
      str1 = str3;
      if (((JSONObject)localObject).has("session_url")) {
        str1 = ((JSONObject)localObject).getString("session_url");
      }
    }
    catch (Exception localException)
    {
      String str2;
      for (;;)
      {
        localException.printStackTrace();
        str2 = str3;
      }
      return str2 + "?buin=" + paramString;
    }
    if (str1.contains("?")) {
      return str1 + "&buin=" + paramString;
    }
  }
  
  String a(String paramString1, String paramString2)
  {
    return "uin=o" + paramString1 + ";skey=" + paramString2 + ";c2bkey=" + paramString2 + ";apptype=" + 0 + ";appver=" + AppSetting.d() + ";os=android" + ";device=" + Build.MODEL + ";osver=" + Build.VERSION.RELEASE;
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, HYIvrSessionIdManager.OnGetIvrSessionIdListener paramOnGetIvrSessionIdListener)
  {
    if (a(paramString, paramOnGetIvrSessionIdListener)) {
      a(paramQQAppInterface, paramString);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilVector.iterator();
      while (localIterator.hasNext())
      {
        yct localyct = (yct)localIterator.next();
        if (localyct.jdField_a_of_type_JavaLangString.equals(paramString1))
        {
          localyct.jdField_a_of_type_CooperationHuangyeHYIvrSessionIdManager$OnGetIvrSessionIdListener.a(localyct.jdField_a_of_type_JavaLangString, paramString2, paramString3, paramString4);
          localIterator.remove();
        }
      }
    }
    finally {}
  }
  
  public boolean a(String paramString, HYIvrSessionIdManager.OnGetIvrSessionIdListener paramOnGetIvrSessionIdListener)
  {
    boolean bool = true;
    label110:
    label113:
    label116:
    for (;;)
    {
      try
      {
        Object localObject = this.jdField_a_of_type_JavaUtilVector.iterator();
        i = 0;
        if (((Iterator)localObject).hasNext())
        {
          yct localyct = (yct)((Iterator)localObject).next();
          if (!localyct.jdField_a_of_type_JavaLangString.equals(paramString)) {
            break label110;
          }
          if (localyct.jdField_a_of_type_CooperationHuangyeHYIvrSessionIdManager$OnGetIvrSessionIdListener != paramOnGetIvrSessionIdListener) {
            break label113;
          }
          return false;
        }
        localObject = new yct(null);
        ((yct)localObject).jdField_a_of_type_JavaLangString = paramString;
        ((yct)localObject).jdField_a_of_type_CooperationHuangyeHYIvrSessionIdManager$OnGetIvrSessionIdListener = paramOnGetIvrSessionIdListener;
        this.jdField_a_of_type_JavaUtilVector.add(localObject);
        if (i == 0) {
          break;
        }
        bool = false;
      }
      finally {}
      break;
      break label116;
      int i = 1;
    }
    return bool;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\huangye\HYIvrSessionIdManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */