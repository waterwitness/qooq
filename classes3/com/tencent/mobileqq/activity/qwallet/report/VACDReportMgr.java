package com.tencent.mobileqq.activity.qwallet.report;

import VACDReport.ReportHeader;
import VACDReport.ReportItem;
import VACDReport.ReportReq;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;
import ovb;
import ovc;
import ovd;
import ove;
import ovf;
import ovg;
import ovh;

public class VACDReportMgr
  implements Manager
{
  public static final int a = 668808;
  public static final long a = 2100000L;
  static final String jdField_a_of_type_JavaLangString = "VACDReport";
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private static final int jdField_b_of_type_Int = 8;
  private static final int jdField_c_of_type_Int = 700;
  private static final int d = 1;
  private static final int e = 2;
  private static final int f = 3;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private Map jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap(8));
  private BusinessObserver jdField_a_of_type_MqqObserverBusinessObserver = new ovg(this);
  private ovb jdField_a_of_type_Ovb = new ovb(BaseApplicationImpl.a());
  private Handler jdField_b_of_type_AndroidOsHandler;
  private HandlerThread jdField_b_of_type_AndroidOsHandlerThread;
  private Handler jdField_c_of_type_AndroidOsHandler;
  private HandlerThread jdField_c_of_type_AndroidOsHandlerThread;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a()
  {
    if (this.jdField_b_of_type_AndroidOsHandlerThread == null)
    {
      this.jdField_b_of_type_AndroidOsHandlerThread = new HandlerThread("LocalTimeOut");
      this.jdField_b_of_type_AndroidOsHandlerThread.start();
      this.jdField_b_of_type_AndroidOsHandler = new Handler(this.jdField_b_of_type_AndroidOsHandlerThread.getLooper());
      this.jdField_b_of_type_AndroidOsHandler.postDelayed(new ovc(this), 2100000L);
    }
  }
  
  private void a(List paramList)
  {
    ReportReq localReportReq = new ReportReq();
    localReportReq.reports = new ArrayList(paramList);
    paramList = BaseApplicationImpl.a().a();
    NewIntent localNewIntent = new NewIntent(paramList.getApplication(), VACDReportServlet.class);
    localNewIntent.putExtra("req", localReportReq);
    localNewIntent.putExtra("cmd_type", 1);
    localNewIntent.setObserver(this.jdField_a_of_type_MqqObserverBusinessObserver);
    paramList.startServlet(localNewIntent);
  }
  
  private void b()
  {
    if (this.jdField_c_of_type_AndroidOsHandlerThread == null)
    {
      this.jdField_c_of_type_AndroidOsHandlerThread = new HandlerThread("ReportCache");
      this.jdField_c_of_type_AndroidOsHandlerThread.start();
      this.jdField_c_of_type_AndroidOsHandler = new ovd(this, this.jdField_c_of_type_AndroidOsHandlerThread.getLooper());
    }
  }
  
  private void b(List paramList)
  {
    ThreadManager.a(new ovh(this, paramList), 10, null, true);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidOsHandlerThread == null)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("Write");
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
      this.jdField_a_of_type_AndroidOsHandler.post(new ove(this));
    }
  }
  
  private void d()
  {
    Map localMap = this.jdField_a_of_type_Ovb.a();
    if ((localMap != null) && (!localMap.isEmpty())) {
      a(new ArrayList(localMap.values()));
    }
  }
  
  void a(long paramLong, ReportItem paramReportItem)
  {
    if (this.jdField_c_of_type_AndroidOsHandler != null)
    {
      Message localMessage = this.jdField_c_of_type_AndroidOsHandler.obtainMessage();
      if (localMessage != null)
      {
        localMessage.arg1 = 3;
        localMessage.obj = new Object[] { Long.valueOf(paramLong), paramReportItem };
        this.jdField_c_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 10000L);
      }
    }
  }
  
  void a(long paramLong, String paramString, ReportItem paramReportItem)
  {
    if (paramReportItem == null) {
      if (QLog.isColorLevel()) {
        QLog.d("VACDReport", 2, "addReportItem seqno=" + paramLong + "  item is null return.");
      }
    }
    Message localMessage;
    do
    {
      do
      {
        return;
      } while (this.jdField_c_of_type_AndroidOsHandler == null);
      localMessage = this.jdField_c_of_type_AndroidOsHandler.obtainMessage();
    } while (localMessage == null);
    localMessage.arg1 = 2;
    localMessage.obj = new Object[] { Long.valueOf(paramLong), paramString, paramReportItem };
    this.jdField_c_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  void a(String paramString, ReportHeader paramReportHeader, ReportItem paramReportItem)
  {
    if (paramReportHeader == null) {
      if (QLog.isColorLevel()) {
        QLog.d("VACDReport", 2, "startReport header is null return");
      }
    }
    Message localMessage;
    do
    {
      do
      {
        do
        {
          return;
          if (paramReportHeader.seqno > 0L) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("VACDReport", 2, "startReport header seqno=" + paramReportHeader.seqno + " is illegal!");
        return;
        c();
        b();
        a();
      } while (this.jdField_c_of_type_AndroidOsHandler == null);
      localMessage = this.jdField_c_of_type_AndroidOsHandler.obtainMessage();
    } while (localMessage == null);
    localMessage.arg1 = 1;
    localMessage.obj = new Object[] { paramString, paramReportHeader, paramReportItem };
    this.jdField_c_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  void b(String paramString, ReportHeader paramReportHeader, ReportItem paramReportItem)
  {
    if (paramReportHeader == null) {
      if (QLog.isColorLevel()) {
        QLog.i("VACDReport", 2, "singleReport:header is null return");
      }
    }
    do
    {
      do
      {
        return;
        if (paramReportHeader.seqno > 0L) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("VACDReport", 2, "singleReport header seqno=" + paramReportHeader.seqno + " is illegal!");
      return;
      if (paramReportItem != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("VACDReport", 2, "singleReport:item is null return");
    return;
    ThreadManager.a(new ovf(this, paramString, paramReportHeader, paramReportItem), 10, null, true);
  }
  
  public void onDestroy()
  {
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (this.jdField_c_of_type_AndroidOsHandler != null) {
        this.jdField_c_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      }
      if (this.jdField_c_of_type_AndroidOsHandlerThread != null) {
        this.jdField_c_of_type_AndroidOsHandlerThread.quit();
      }
      if (this.jdField_a_of_type_JavaUtilMap != null) {
        this.jdField_a_of_type_JavaUtilMap.clear();
      }
      if (this.jdField_a_of_type_AndroidOsHandlerThread != null) {
        this.jdField_a_of_type_AndroidOsHandlerThread.quit();
      }
      if (this.jdField_b_of_type_AndroidOsHandler != null) {
        this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      }
      if (this.jdField_b_of_type_AndroidOsHandlerThread != null) {
        this.jdField_b_of_type_AndroidOsHandlerThread.quit();
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qwallet\report\VACDReportMgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */