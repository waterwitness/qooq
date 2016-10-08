package cooperation.huangye;

import android.os.AsyncTask.Status;
import android.text.TextUtils;
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
import ycp;
import ycq;

public class HYIvrBusinessManager
{
  public static final int a = -3;
  private static HYIvrBusinessManager jdField_a_of_type_CooperationHuangyeHYIvrBusinessManager;
  public static final int b = -2;
  public static final String b = "http://pubacc.mobile.qq.com/yellowpage/mqqweb/businessDetails";
  public static final int c = -1;
  public static final int d = 0;
  public static final int e = 1;
  private static final int f = 86400000;
  private long jdField_a_of_type_Long;
  private HYIvrBusinessCache jdField_a_of_type_CooperationHuangyeHYIvrBusinessCache;
  public String a;
  private Vector jdField_a_of_type_JavaUtilVector;
  public ycp a;
  private Vector b;
  
  public HYIvrBusinessManager()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = HYIvrBusinessManager.class.getSimpleName();
    this.jdField_a_of_type_JavaUtilVector = new Vector();
    this.b = new Vector();
    this.jdField_a_of_type_CooperationHuangyeHYIvrBusinessCache = new HYIvrBusinessCache();
    this.jdField_a_of_type_Ycp = null;
  }
  
  private int a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Ycp != null) && (this.jdField_a_of_type_Ycp.getStatus() == AsyncTask.Status.RUNNING))
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "IvrBizListDownloadTask is running. ");
      }
      return 1;
    }
    if (!NetworkUtil.h(BaseApplication.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "checkIvrBusinessList network is not available.");
      }
      return -1;
    }
    if ((paramBoolean) || (a()))
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Ycp = new ycp(this, null);
      ArrayList localArrayList = new ArrayList();
      DownloadParams localDownloadParams = new DownloadParams();
      localDownloadParams.jdField_a_of_type_JavaLangString = a();
      localDownloadParams.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      localDownloadParams.jdField_a_of_type_JavaUtilHashMap.put("Cookie", "uin=o" + paramString1 + ";skey=" + paramString2 + ";c2bkey=" + paramString2);
      localArrayList.add(localDownloadParams);
      this.jdField_a_of_type_Ycp.execute(new ArrayList[] { localArrayList });
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "checkIvrBusinessList start download.");
      }
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "checkIvrBusinessList doesn't need download ,it's " + (float)(System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000.0F + "s from the last download.");
    }
    return -2;
  }
  
  public static HYIvrBusinessManager a()
  {
    try
    {
      if (jdField_a_of_type_CooperationHuangyeHYIvrBusinessManager == null) {
        jdField_a_of_type_CooperationHuangyeHYIvrBusinessManager = new HYIvrBusinessManager();
      }
      HYIvrBusinessManager localHYIvrBusinessManager = jdField_a_of_type_CooperationHuangyeHYIvrBusinessManager;
      return localHYIvrBusinessManager;
    }
    finally {}
  }
  
  private boolean a()
  {
    return (TextUtils.isEmpty(this.jdField_a_of_type_CooperationHuangyeHYIvrBusinessCache.a())) || (System.currentTimeMillis() - this.jdField_a_of_type_Long > 86400000L);
  }
  
  public int a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    TicketManager localTicketManager = (TicketManager)paramQQAppInterface.getManager(2);
    String str = paramQQAppInterface.getAccount();
    if (localTicketManager != null) {}
    for (paramQQAppInterface = localTicketManager.getSkey(paramQQAppInterface.getAccount());; paramQQAppInterface = null)
    {
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramQQAppInterface))) {}
      for (int i = a(str, paramQQAppInterface, paramBoolean);; i = -3)
      {
        if (i < 0) {
          a(this.jdField_a_of_type_CooperationHuangyeHYIvrBusinessCache.a());
        }
        return i;
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_a_of_type_JavaLangString, 2, "account == null:" + TextUtils.isEmpty(str) + " or skey == null:" + TextUtils.isEmpty(paramQQAppInterface));
        }
      }
    }
  }
  
  String a()
  {
    Object localObject = HYSharedPref.a().a("FileConfigure", "");
    String str2 = "http://pubacc.mobile.qq.com/yellowpage/mqqweb/businessDetails";
    String str1 = str2;
    if (!((String)localObject).equals("")) {}
    try
    {
      localObject = new JSONObject((String)localObject);
      str1 = str2;
      if (((JSONObject)localObject).has("ivrmap_url")) {
        str1 = ((JSONObject)localObject).getString("ivrmap_url");
      }
      return str1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "http://pubacc.mobile.qq.com/yellowpage/mqqweb/businessDetails";
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, HYIvrBusinessManager.OnGetIvrBusinessListener paramOnGetIvrBusinessListener)
  {
    a(paramString, paramOnGetIvrBusinessListener);
    a(paramQQAppInterface, false);
  }
  
  public void a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilVector.iterator();
    if (localIterator.hasNext())
    {
      localObject = (ycq)localIterator.next();
      if (((ycq)localObject).jdField_a_of_type_JavaLangString != null)
      {
        HYIvrBusinessManager.OnGetIvrBusinessListener localOnGetIvrBusinessListener = ((ycq)localObject).jdField_a_of_type_CooperationHuangyeHYIvrBusinessManager$OnGetIvrBusinessListener;
        String str = ((ycq)localObject).jdField_a_of_type_JavaLangString;
        if (paramString != null)
        {
          localObject = this.jdField_a_of_type_CooperationHuangyeHYIvrBusinessCache.a(((ycq)localObject).jdField_a_of_type_JavaLangString, paramString);
          label63:
          localOnGetIvrBusinessListener.a(str, (String)localObject);
        }
      }
      for (;;)
      {
        localIterator.remove();
        break;
        localObject = null;
        break label63;
        ((ycq)localObject).jdField_a_of_type_CooperationHuangyeHYIvrBusinessManager$OnGetIvrBusinessListener.a(null, null);
      }
    }
    Object localObject = this.b.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((HYIvrBusinessManager.OnGetIvrBusinessContentListener)((Iterator)localObject).next()).a(paramString);
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str = this.jdField_a_of_type_CooperationHuangyeHYIvrBusinessCache.a();
    if (!TextUtils.isEmpty(str)) {
      return this.jdField_a_of_type_CooperationHuangyeHYIvrBusinessCache.a(paramString, str) != null;
    }
    a(paramQQAppInterface, true);
    return false;
  }
  
  public boolean a(HYIvrBusinessManager.OnGetIvrBusinessContentListener paramOnGetIvrBusinessContentListener)
  {
    if (this.b.contains(paramOnGetIvrBusinessContentListener)) {
      return false;
    }
    return this.b.add(paramOnGetIvrBusinessContentListener);
  }
  
  public boolean a(HYIvrBusinessManager.OnGetIvrBusinessListener paramOnGetIvrBusinessListener)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilVector.iterator();
    while (localIterator.hasNext()) {
      if (((ycq)localIterator.next()).jdField_a_of_type_CooperationHuangyeHYIvrBusinessManager$OnGetIvrBusinessListener == paramOnGetIvrBusinessListener)
      {
        localIterator.remove();
        return true;
      }
    }
    return false;
  }
  
  public boolean a(String paramString, HYIvrBusinessManager.OnGetIvrBusinessListener paramOnGetIvrBusinessListener)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilVector.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((ycq)((Iterator)localObject).next()).jdField_a_of_type_CooperationHuangyeHYIvrBusinessManager$OnGetIvrBusinessListener == paramOnGetIvrBusinessListener) {
        return false;
      }
    }
    localObject = new ycq(null);
    ((ycq)localObject).jdField_a_of_type_JavaLangString = paramString;
    ((ycq)localObject).jdField_a_of_type_CooperationHuangyeHYIvrBusinessManager$OnGetIvrBusinessListener = paramOnGetIvrBusinessListener;
    return this.jdField_a_of_type_JavaUtilVector.add(localObject);
  }
  
  public boolean b(HYIvrBusinessManager.OnGetIvrBusinessContentListener paramOnGetIvrBusinessContentListener)
  {
    return this.b.remove(paramOnGetIvrBusinessContentListener);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\huangye\HYIvrBusinessManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */