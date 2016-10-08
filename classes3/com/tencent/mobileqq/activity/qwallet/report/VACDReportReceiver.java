package com.tencent.mobileqq.activity.qwallet.report;

import VACDReport.ReportHeader;
import VACDReport.ReportItem;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class VACDReportReceiver
  extends BroadcastReceiver
{
  static final String a = "vacdReport_step:start";
  static final String b = "vacdReport_step:add";
  static final String c = "vacdReport_step:end";
  static final String d = "vacdReport_step:single";
  static final String e = "vacdReport_extra:step";
  static final String f = "vacdReport_extra:seqno";
  static final String g = "vacdReport_extra:sKey";
  static final String h = "vacdReport_extra:header";
  static final String i = "vacdReport_extra:item";
  
  public VACDReportReceiver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    String str;
    ReportItem localReportItem;
    label150:
    label159:
    do
    {
      return;
      str = paramIntent.getStringExtra("vacdReport_extra:step");
      long l = paramIntent.getLongExtra("vacdReport_extra:seqno", -1L);
      localReportItem = (ReportItem)paramIntent.getSerializableExtra("vacdReport_extra:item");
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("onReceive:").append(l).append("|");
        if (localReportItem != null) {
          break label150;
        }
      }
      for (paramContext = "item is null";; paramContext = localReportItem.toString())
      {
        QLog.i("VACDReport", 2, paramContext);
        paramContext = BaseApplicationImpl.a().a();
        if (!(paramContext instanceof QQAppInterface)) {
          break;
        }
        paramContext = (VACDReportMgr)((QQAppInterface)paramContext).getManager(147);
        if (paramContext == null) {
          break;
        }
        if (!"vacdReport_step:start".equals(str)) {
          break label159;
        }
        paramContext.a(paramIntent.getStringExtra("vacdReport_extra:sKey"), (ReportHeader)paramIntent.getSerializableExtra("vacdReport_extra:header"), localReportItem);
        return;
      }
      if ("vacdReport_step:add".equals(str))
      {
        paramContext.a(l, paramIntent.getStringExtra("vacdReport_extra:sKey"), localReportItem);
        return;
      }
      if ("vacdReport_step:end".equals(str))
      {
        paramContext.a(l, localReportItem);
        return;
      }
    } while (!"vacdReport_step:single".equals(str));
    paramContext.b(paramIntent.getStringExtra("vacdReport_extra:sKey"), (ReportHeader)paramIntent.getSerializableExtra("vacdReport_extra:header"), localReportItem);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qwallet\report\VACDReportReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */