package cooperation.qzone.report;

import NS_MOBILE_FEEDS.mobile_online_report_item;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import yox;
import yoy;
import yoz;

public class QzoneOnlineTimeCollectRptService
{
  public static final int a = 0;
  private static QzoneOnlineTimeCollectRptService jdField_a_of_type_CooperationQzoneReportQzoneOnlineTimeCollectRptService;
  private static final String jdField_a_of_type_JavaLangString = QzoneOnlineTimeCollectRptService.class.getSimpleName();
  public static final int b = 1;
  private static final String jdField_b_of_type_JavaLangString = "QZonlinetime";
  public static final int c = 3;
  private static final String c = "QZonlinetimeLastRecord";
  public static final int d = 4;
  private static final String d = "QZonlinetime_web";
  private static final String jdField_e_of_type_JavaLangString = "QZonlinetimeLastRecord_web";
  private static final int jdField_f_of_type_Int = 3600;
  private static final String jdField_f_of_type_JavaLangString = "QZonlinetime_picture";
  private static final int jdField_g_of_type_Int = 1;
  private static final String jdField_g_of_type_JavaLangString = "QZonlinetimeLastRecord_picture";
  private static final int jdField_h_of_type_Int = 10000;
  private static final String jdField_h_of_type_JavaLangString = "QZonlinetime_video";
  private static final String jdField_i_of_type_JavaLangString = "QZonlinetimeLastRecord_video";
  public long a;
  private mobile_online_report_item jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Runnable jdField_a_of_type_JavaLangRunnable = new yoz(this);
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private volatile boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long = 0L;
  private ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  int jdField_e_of_type_Int;
  private int jdField_i_of_type_Int;
  private String j = "QZonlinetime";
  private String k = "QZonlinetimeLastRecord";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private QzoneOnlineTimeCollectRptService()
  {
    this.i = 10000;
    this.jdField_a_of_type_Long = 0L;
    this.e = 0;
  }
  
  public static final QzoneOnlineTimeCollectRptService a()
  {
    if (jdField_a_of_type_CooperationQzoneReportQzoneOnlineTimeCollectRptService == null) {
      jdField_a_of_type_CooperationQzoneReportQzoneOnlineTimeCollectRptService = new QzoneOnlineTimeCollectRptService();
    }
    return jdField_a_of_type_CooperationQzoneReportQzoneOnlineTimeCollectRptService;
  }
  
  private void a(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      paramArrayList = new ArrayList(paramArrayList);
      NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getContext(), QzoneOnlineTimeServlet.class);
      localNewIntent.putExtra("list", paramArrayList);
      BaseApplicationImpl.a().a().startServlet(localNewIntent);
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "There is no record to report!");
  }
  
  private boolean b()
  {
    boolean bool1 = false;
    boolean bool2 = true;
    QzoneConfig localQzoneConfig = QzoneConfig.a();
    if (this.jdField_b_of_type_Long != 0L)
    {
      if ((System.currentTimeMillis() / 1000L - this.jdField_b_of_type_Long > localQzoneConfig.a("ReportSetting", "OnlineReportInterval", 3600)) || (this.jdField_a_of_type_JavaUtilArrayList.size() >= localQzoneConfig.a("ReportSetting", "OnlineReportFrequency", 1))) {
        bool1 = true;
      }
      return bool1;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() >= localQzoneConfig.a("ReportSetting", "OnlineReportFrequency", 1)) {}
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Long == 0L) {
      return;
    }
    long l1 = this.jdField_a_of_type_Long;
    String str = LocalMultiProcConfig.a(this.j + "_" + l1, "");
    Object localObject2 = LocalMultiProcConfig.a(this.k + "_" + l1, "");
    long l2 = LocalMultiProcConfig.a("key_sp_qzone_crash_time_" + l1, 0L);
    QLog.d(jdField_a_of_type_JavaLangString, 1, "sp:" + this.j + " lost time:" + (String)localObject2 + " sp:" + this.k + " crash time:" + l2);
    Object localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      if (l2 != 0L)
      {
        localObject1 = localObject2;
        if (this.j.equals("QZonlinetime")) {
          localObject1 = ((String)localObject2).substring(0, ((String)localObject2).lastIndexOf(";")) + ";" + l2;
        }
      }
      localObject2 = localObject1;
      if (!TextUtils.isEmpty(str)) {
        localObject2 = str + ";" + (String)localObject1;
      }
      LocalMultiProcConfig.a(this.j + "_" + l1, (String)localObject2);
      LocalMultiProcConfig.a(this.k + "_" + l1, "");
    }
    for (;;)
    {
      LocalMultiProcConfig.a("key_sp_qzone_crash_time_" + l1, 0L);
      QLog.d(jdField_a_of_type_JavaLangString, 1, "s:" + (String)localObject2);
      localObject1 = ((String)localObject2).split(";");
      if ((localObject1 == null) || (localObject1.length <= 1)) {
        break;
      }
      int m = 0;
      try
      {
        while (m < localObject1.length)
        {
          localObject2 = new mobile_online_report_item(l1, Long.parseLong(localObject1[m]), Long.parseLong(localObject1[(m + 1)]));
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
          m += 2;
        }
        localObject2 = str;
      }
      catch (Exception localException)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "e:" + localException.toString());
        if ((this.jdField_a_of_type_JavaUtilArrayList.size() >= 1) && (this.jdField_a_of_type_JavaUtilArrayList.get(0) != null)) {
          this.jdField_b_of_type_Long = ((mobile_online_report_item)this.jdField_a_of_type_JavaUtilArrayList.get(0)).uptime;
        }
        g();
        return;
      }
    }
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        mobile_online_report_item localmobile_online_report_item = (mobile_online_report_item)localIterator.next();
        if (localmobile_online_report_item != null) {
          localStringBuilder.append(localmobile_online_report_item.uptime + ";" + localmobile_online_report_item.downtime + ";");
        }
      }
      if (localStringBuilder.length() == 0) {
        break label253;
      }
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      LocalMultiProcConfig.a(this.j + "_" + this.jdField_a_of_type_Long, localStringBuilder.toString());
      QLog.d(jdField_a_of_type_JavaLangString, 1, "saveData mReportItems size:" + this.jdField_a_of_type_JavaUtilArrayList.size() + " mLastReportTime:" + this.jdField_b_of_type_Long + " re:" + localStringBuilder.toString());
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    for (;;)
    {
      LocalMultiProcConfig.a(this.k + "_" + this.jdField_a_of_type_Long, "");
      return;
      label253:
      QLog.w(jdField_a_of_type_JavaLangString, 1, "re length:0");
    }
  }
  
  private void g()
  {
    try
    {
      if (b())
      {
        if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0) {
          this.jdField_b_of_type_JavaUtilArrayList.clear();
        }
        this.jdField_b_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        if (this.jdField_a_of_type_Long != 0L) {
          a(this.jdField_b_of_type_JavaUtilArrayList);
        }
      }
      return;
    }
    finally {}
  }
  
  public void a()
  {
    ThreadManager.b().post(new yoy(this));
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    case 0: 
      this.j = "QZonlinetime";
      this.k = "QZonlinetimeLastRecord";
      return;
    case 1: 
      this.j = "QZonlinetime_web";
      this.k = "QZonlinetimeLastRecord_web";
      return;
    case 3: 
      this.j = "QZonlinetime_picture";
      this.k = "QZonlinetimeLastRecord_picture";
      return;
    }
    this.j = "QZonlinetime_video";
    this.k = "QZonlinetimeLastRecord_video";
  }
  
  public void a(mobile_online_report_item parammobile_online_report_item)
  {
    if ((parammobile_online_report_item != null) && (parammobile_online_report_item.uptime != 0L) && (parammobile_online_report_item.downtime != 0L)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(parammobile_online_report_item);
    }
    g();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 339	cooperation/qzone/report/QzoneOnlineTimeCollectRptService:jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item	LNS_MOBILE_FEEDS/mobile_online_report_item;
    //   6: ifnonnull +31 -> 37
    //   9: aload_0
    //   10: new 250	NS_MOBILE_FEEDS/mobile_online_report_item
    //   13: dup
    //   14: invokespecial 340	NS_MOBILE_FEEDS/mobile_online_report_item:<init>	()V
    //   17: putfield 339	cooperation/qzone/report/QzoneOnlineTimeCollectRptService:jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item	LNS_MOBILE_FEEDS/mobile_online_report_item;
    //   20: aload_0
    //   21: getfield 339	cooperation/qzone/report/QzoneOnlineTimeCollectRptService:jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item	LNS_MOBILE_FEEDS/mobile_online_report_item;
    //   24: invokestatic 111	java/lang/System:currentTimeMillis	()J
    //   27: ldc2_w 165
    //   30: ldiv
    //   31: putfield 272	NS_MOBILE_FEEDS/mobile_online_report_item:uptime	J
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: aload_0
    //   38: getfield 339	cooperation/qzone/report/QzoneOnlineTimeCollectRptService:jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item	LNS_MOBILE_FEEDS/mobile_online_report_item;
    //   41: lconst_0
    //   42: putfield 290	NS_MOBILE_FEEDS/mobile_online_report_item:downtime	J
    //   45: aload_0
    //   46: getfield 339	cooperation/qzone/report/QzoneOnlineTimeCollectRptService:jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item	LNS_MOBILE_FEEDS/mobile_online_report_item;
    //   49: lconst_0
    //   50: putfield 343	NS_MOBILE_FEEDS/mobile_online_report_item:loginuin	J
    //   53: aload_0
    //   54: getfield 339	cooperation/qzone/report/QzoneOnlineTimeCollectRptService:jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item	LNS_MOBILE_FEEDS/mobile_online_report_item;
    //   57: lconst_0
    //   58: putfield 272	NS_MOBILE_FEEDS/mobile_online_report_item:uptime	J
    //   61: goto -41 -> 20
    //   64: astore_1
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_1
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	QzoneOnlineTimeCollectRptService
    //   64	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	64	finally
    //   20	34	64	finally
    //   37	61	64	finally
  }
  
  public void b(int paramInt)
  {
    a(paramInt);
    ThreadManager.b().post(new yox(this));
  }
  
  public void c()
  {
    try
    {
      if (this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item != null)
      {
        this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item.downtime = (System.currentTimeMillis() / 1000L);
        this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item.loginuin = this.jdField_a_of_type_Long;
        a(this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void c(int paramInt)
  {
    if (paramInt != 1000)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "QzoneOnlineTimeCollectRptService report failure resultCode:" + paramInt + " RetryTimes:" + this.e);
      if (this.e < 2)
      {
        a(this.jdField_b_of_type_JavaUtilArrayList);
        this.e += 1;
      }
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 1, "QzoneOnlineTimeCollectRptService task succeed!");
    this.e = 0;
    if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0))
    {
      paramInt = 0;
      while (paramInt < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "sp:" + this.j + " report uptime:" + ((mobile_online_report_item)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt)).uptime + " downtime:" + ((mobile_online_report_item)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt)).downtime);
        paramInt += 1;
      }
      this.jdField_b_of_type_JavaUtilArrayList.clear();
    }
    LocalMultiProcConfig.a(this.j + "_" + this.jdField_a_of_type_Long, "");
    LocalMultiProcConfig.a(this.k + "_" + this.jdField_a_of_type_Long, "");
  }
  
  public void d()
  {
    mobile_online_report_item localmobile_online_report_item;
    if (this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item != null)
    {
      if (this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item.uptime <= 0L) {
        break label186;
      }
      this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item.downtime = (System.currentTimeMillis() / 1000L);
      if (this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item.uptime == this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item.downtime) {
        localmobile_online_report_item = this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item;
      }
    }
    for (localmobile_online_report_item.downtime += 1L;; this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item.downtime = (this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item.uptime + 1L))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "update sp:" + this.k + " last time:" + this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item.downtime);
      }
      LocalMultiProcConfig.a(this.k + "_" + this.jdField_a_of_type_Long, this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item.uptime + ";" + this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item.downtime);
      return;
      label186:
      this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item.uptime = (System.currentTimeMillis() / 1000L);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\report\QzoneOnlineTimeCollectRptService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */