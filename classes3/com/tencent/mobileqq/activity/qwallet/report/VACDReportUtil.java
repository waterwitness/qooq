package com.tencent.mobileqq.activity.qwallet.report;

import VACDReport.ReportHeader;
import VACDReport.ReportItem;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class VACDReportUtil
{
  public VACDReportUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static long a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6)
  {
    return a(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt, paramString6, SystemClock.uptimeMillis());
  }
  
  public static long a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, long paramLong)
  {
    paramString3 = a(paramString2, paramString3);
    if (!TextUtils.isEmpty(paramString4))
    {
      paramString2 = new ReportItem();
      paramString2.step = paramString4;
      paramString2.params = paramString5;
      paramString2.result = paramInt;
      paramString2.failReason = paramString6;
      paramString2.createTime = paramLong;
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        paramString4 = new StringBuilder(128);
        paramString4.append("startReport header=" + paramString3.toString());
        if (paramString2 != null) {
          paramString4.append(" ,item=" + paramString2.toString());
        }
        paramString4.append(" ,createTime=").append(paramString3.serverTime);
        QLog.d("VACDReport", 2, paramString4.toString());
      }
      paramString4 = BaseApplicationImpl.a().a();
      if ((paramString4 instanceof QQAppInterface)) {
        ((VACDReportMgr)((QQAppInterface)paramString4).getManager(147)).a(paramString1, paramString3, paramString2);
      }
      for (;;)
      {
        return paramString3.seqno;
        paramString4 = new Intent(BaseApplicationImpl.a(), VACDReportReceiver.class);
        paramString4.putExtra("vacdReport_extra:header", paramString3);
        paramString4.putExtra("vacdReport_extra:seqno", paramString3.seqno);
        paramString4.putExtra("vacdReport_extra:sKey", paramString1);
        paramString4.putExtra("vacdReport_extra:step", "vacdReport_step:start");
        if (paramString2 != null) {
          paramString4.putExtra("vacdReport_extra:item", paramString2);
        }
        BaseApplicationImpl.a().sendBroadcast(paramString4);
      }
      paramString2 = null;
    }
  }
  
  private static ReportHeader a(String paramString1, String paramString2)
  {
    ReportHeader localReportHeader = new ReportHeader();
    StringBuilder localStringBuilder = new StringBuilder("Android|");
    localStringBuilder.append(Build.VERSION.RELEASE);
    localStringBuilder.append("|").append(Build.MODEL);
    localReportHeader.platform = localStringBuilder.toString();
    localReportHeader.sModule = paramString1;
    localReportHeader.sAction = paramString2;
    localReportHeader.version = "6.5.5";
    long l = NetConnInfoCenter.getServerTimeMillis();
    localReportHeader.seqno = l;
    try
    {
      localReportHeader.uin = Long.parseLong(BaseApplicationImpl.a().a().getAccount());
      localReportHeader.iNetType = NetworkUtil.a(BaseApplicationImpl.a());
      localReportHeader.result = 0;
      localReportHeader.createTime = SystemClock.uptimeMillis();
      localReportHeader.serverTime = l;
      return localReportHeader;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        localReportHeader.uin = 10000L;
      }
    }
  }
  
  public static void a(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    ReportItem localReportItem = null;
    if (!TextUtils.isEmpty(paramString1))
    {
      localReportItem = new ReportItem();
      localReportItem.step = paramString1;
      localReportItem.params = paramString2;
      localReportItem.result = paramInt;
      localReportItem.failReason = paramString3;
      localReportItem.createTime = SystemClock.uptimeMillis();
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder(128);
      paramString1.append("endReport seqno=").append(paramLong);
      if (localReportItem != null) {
        paramString1.append(" ,item=").append(localReportItem.toString());
      }
      paramString1.append(" ,createTime=").append(NetConnInfoCenter.getServerTimeMillis());
      QLog.d("VACDReport", 2, paramString1.toString());
    }
    paramString1 = new Intent(BaseApplicationImpl.a(), VACDReportReceiver.class);
    paramString1.putExtra("vacdReport_extra:step", "vacdReport_step:end");
    paramString1.putExtra("vacdReport_extra:seqno", paramLong);
    if (localReportItem != null) {
      paramString1.putExtra("vacdReport_extra:item", localReportItem);
    }
    BaseApplicationImpl.a().sendBroadcast(paramString1);
  }
  
  public static void a(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    ReportItem localReportItem = new ReportItem();
    localReportItem.step = paramString2;
    localReportItem.params = paramString3;
    localReportItem.result = paramInt;
    localReportItem.failReason = paramString4;
    localReportItem.createTime = SystemClock.uptimeMillis();
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder(128);
      paramString2.append("addReportItem seqno=").append(paramLong);
      if (localReportItem != null) {
        paramString2.append(" ,item=").append(localReportItem.toString());
      }
      paramString2.append(" ,createTime=").append(NetConnInfoCenter.getServerTimeMillis());
      QLog.d("VACDReport", 2, paramString2.toString());
    }
    paramString2 = BaseApplicationImpl.a().a();
    if ((paramString2 instanceof QQAppInterface))
    {
      ((VACDReportMgr)((QQAppInterface)paramString2).getManager(147)).a(paramLong, paramString1, localReportItem);
      return;
    }
    paramString2 = new Intent(BaseApplicationImpl.a(), VACDReportReceiver.class);
    paramString2.putExtra("vacdReport_extra:step", "vacdReport_step:add");
    paramString2.putExtra("vacdReport_extra:seqno", paramLong);
    paramString2.putExtra("vacdReport_extra:sKey", paramString1);
    paramString2.putExtra("vacdReport_extra:item", localReportItem);
    BaseApplicationImpl.a().sendBroadcast(paramString2);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6)
  {
    paramString2 = a(paramString2, paramString3);
    paramString3 = new ReportItem();
    paramString3.step = paramString4;
    paramString3.params = paramString5;
    paramString3.result = paramInt;
    paramString3.failReason = paramString6;
    paramString3.createTime = paramString2.createTime;
    if (QLog.isColorLevel())
    {
      paramString4 = new StringBuilder(128);
      paramString4.append("singleReport header=" + paramString2.toString());
      if (paramString3 != null) {
        paramString4.append(" ,item=" + paramString3.toString());
      }
      paramString4.append(" ,createTime=").append(paramString2.serverTime);
      QLog.d("VACDReport", 2, paramString4.toString());
    }
    paramString4 = BaseApplicationImpl.a().a();
    if ((paramString4 instanceof QQAppInterface))
    {
      ((VACDReportMgr)((QQAppInterface)paramString4).getManager(147)).b(paramString1, paramString2, paramString3);
      return;
    }
    paramString4 = new Intent(BaseApplicationImpl.a(), VACDReportReceiver.class);
    paramString4.putExtra("vacdReport_extra:header", paramString2);
    paramString4.putExtra("vacdReport_extra:seqno", paramString2.seqno);
    paramString4.putExtra("vacdReport_extra:sKey", paramString1);
    paramString4.putExtra("vacdReport_extra:step", "vacdReport_step:single");
    paramString4.putExtra("vacdReport_extra:item", paramString3);
    BaseApplicationImpl.a().sendBroadcast(paramString4);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qwallet\report\VACDReportUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */