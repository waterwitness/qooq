package com.tencent.mobileqq.servlet;

import NS_UNDEAL_COUNT.count_info;
import NS_UNDEAL_COUNT.feed_host_info;
import NS_UNDEAL_COUNT.single_count;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.mobileqq.service.qzone.QZoneUnreadServletLogic;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.WebEventListener;
import cooperation.qzone.util.QZoneLogTags;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import mqq.os.MqqHandler;
import upo;

public class QZoneNotifyServlet
  extends MSFServlet
  implements WebEventListener
{
  public static final String a = "getUndealCount";
  public static final boolean a = false;
  public static final String b = "Qzone_Get_NewAndUnread_Count";
  public static long c = 0L;
  public static final String c = "Qzone_Refresh_UI";
  public static long d = 0L;
  public static final String d = "qzone_send_by_time";
  public static final String e = "scene";
  private static final String f = "Q.lebatab." + QZoneLogTags.jdField_b_of_type_JavaLangString + "QZoneNotifyServlet";
  public long a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new upo(this);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  public long b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QZoneNotifyServlet()
  {
    this.jdField_a_of_type_Long = 180000L;
    this.jdField_b_of_type_Long = 5000L;
  }
  
  private MqqHandler a()
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler == null) {}
    try
    {
      if (this.jdField_a_of_type_MqqOsMqqHandler == null)
      {
        HandlerThread localHandlerThread = ThreadManager.a("QZONE_UNDEALCOUNT", 0);
        localHandlerThread.start();
        this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(localHandlerThread.getLooper());
      }
      return this.jdField_a_of_type_MqqOsMqqHandler;
    }
    finally {}
  }
  
  private void a()
  {
    a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, this.jdField_a_of_type_Long);
  }
  
  protected void onCreate()
  {
    super.onCreate();
    RemoteHandleManager.a().a(this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    RemoteHandleManager.a().b(this);
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d(f, 4, "QZoneNotifyServlet onDestroy" + System.currentTimeMillis());
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_MqqOsMqqHandler.getLooper().quit();
    }
    this.jdField_a_of_type_MqqOsMqqHandler = null;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = getAppRuntime();
    if (localObject == null) {}
    while (!(localObject instanceof QQAppInterface)) {
      return;
    }
    localObject = (QQAppInterface)localObject;
    d = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d(f, 2, "onReceive onReceive: " + d);
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      LocalMultiProcConfig.a("qzone_passive_undeal_readtime", "", ((QQAppInterface)localObject).getLongAccountUin());
      QZoneUnreadServletLogic.a(paramIntent, paramFromServiceMsg, (QQAppInterface)localObject, this);
      return;
    }
    QZoneUnreadServletLogic.a((QQAppInterface)localObject, paramIntent, paramFromServiceMsg, this);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d(f, 2, "onSend.begin.");
    }
    if (paramIntent == null) {}
    do
    {
      do
      {
        return;
      } while (!"Qzone_Get_NewAndUnread_Count".equals(paramIntent.getAction()));
      localObject1 = getAppRuntime();
    } while ((localObject1 == null) || (!(localObject1 instanceof QQAppInterface)));
    Object localObject1 = (QQAppInterface)localObject1;
    int i = 3;
    int k = paramIntent.getIntExtra("scene", 102);
    int j = paramIntent.getIntExtra("qzone_send_by_time", 4);
    if (QLog.isColorLevel()) {
      QLog.d(f, 2, "QzoneNotifyServlet onSend byTimeType:" + j + ",isBackground_Pause:" + ((QQAppInterface)localObject1).isBackground_Pause);
    }
    if (j == 2)
    {
      i = 2;
      long l = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d(f, 2, "GETFEEDUNREADTYPE_SWITCHTOFORGROUND nowtime: " + l + ",lastGetFeedTime:" + c + ",lastGetFeedTime:" + c + "difference: " + (l - c));
      }
      if (l - c < this.jdField_b_of_type_Long)
      {
        if (QLog.isColorLevel()) {
          QLog.d(f, 2, "onSend.interval time is not enough,schedule task.byTimeType:2");
        }
        a();
        return;
      }
    }
    if (((j == 1) || (j == 4) || (j == 5) || (j == 6) || (j == 7) || (j == 8)) && (((QQAppInterface)localObject1).isBackground_Pause))
    {
      if (QLog.isColorLevel()) {
        QLog.d(f, 2, "onSend app.isBackground_Pause: " + ((QQAppInterface)localObject1).isBackground_Pause + " not send request,schedule task");
      }
      a();
      return;
    }
    if (j == 3) {
      i = 4;
    }
    if (j == 1) {
      i = 1;
    }
    if (j == 4) {
      i = 3;
    }
    if (j == 2) {
      i = 2;
    }
    if (j == 5) {
      i = 5;
    }
    if (j == 6) {
      i = 6;
    }
    if (j == 7) {
      i = 7;
    }
    if (j == 8) {
      i = 8;
    }
    int m = ((QQAppInterface)localObject1).a().getResources().getDisplayMetrics().widthPixels;
    int n = ((QQAppInterface)localObject1).a().getResources().getDisplayMetrics().heightPixels;
    paramIntent = new ConcurrentHashMap();
    Object localObject2 = (QZoneManagerImp)((QQAppInterface)localObject1).getManager(9);
    if ((localObject2 != null) && (((QZoneManagerImp)localObject2).a != null))
    {
      j = 1;
      while (j <= 2)
      {
        QZoneCountInfo localQZoneCountInfo = (QZoneCountInfo)((QZoneManagerImp)localObject2).a.get(Integer.valueOf(j));
        if (localQZoneCountInfo != null)
        {
          single_count localsingle_count = new single_count(localQZoneCountInfo.jdField_a_of_type_Long, (byte)localQZoneCountInfo.jdField_a_of_type_Int);
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(new feed_host_info(localQZoneCountInfo.jdField_b_of_type_Long, "", localQZoneCountInfo.jdField_a_of_type_JavaLangString));
          paramIntent.put(Integer.valueOf(j), new count_info(localsingle_count, localArrayList, localQZoneCountInfo.jdField_b_of_type_JavaLangString));
        }
        j += 1;
      }
    }
    localObject2 = LocalMultiProcConfig.a("qzone_passive_undeal_readtime", "", ((QQAppInterface)localObject1).getLongAccountUin());
    paramIntent = QZoneUnreadServletLogic.a(Long.valueOf(((QQAppInterface)localObject1).a()).longValue(), null, m, n, i, k, paramIntent, (String)localObject2);
    if (paramIntent == null)
    {
      paramIntent = new byte[4];
      notifyObserver(null, 1000, false, new Bundle(), QZoneObserver.class);
    }
    for (;;)
    {
      a();
      return;
      paramPacket.setTimeout(30000L);
      if (QLog.isDevelopLevel()) {
        QLog.d(QZoneLogTags.d + f, 4, "onSend cmd: " + "SQQzoneSvc." + "getUndealCount" + " iVisitQZoneType: " + i);
      }
      paramPacket.setSSOCommand("SQQzoneSvc." + "getUndealCount");
      paramPacket.putSendData(paramIntent);
      c = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d(f, 2, "onSend send success,send request time: " + c);
      }
    }
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ((!paramString.equals("cmd.pre.getpassivefeeds")) || (paramBundle == null) || (!paramBundle.containsKey("data"))) {}
    int i;
    do
    {
      return;
      paramString = paramBundle.getBundle("data");
      i = paramString.getInt("param.preget_seqid");
      paramBundle = getAppRuntime();
    } while ((paramBundle == null) || (!(paramBundle instanceof QQAppInterface)));
    long l = paramString.getLong("param.preget_undealcount", -1L);
    QZoneUnreadServletLogic.a((QQAppInterface)paramBundle, i, Long.valueOf(l));
  }
  
  public void service(Intent paramIntent)
  {
    if (paramIntent.getAction().equals("Qzone_Refresh_UI"))
    {
      int i = paramIntent.getIntExtra("notify_type", -1);
      paramIntent = new Bundle();
      paramIntent.putBoolean("new", true);
      paramIntent.putInt("notify_type", i);
      notifyObserver(null, 1000, true, paramIntent, QZoneObserver.class);
      return;
    }
    super.service(paramIntent);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\servlet\QZoneNotifyServlet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */