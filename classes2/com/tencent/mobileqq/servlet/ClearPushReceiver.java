package com.tencent.mobileqq.servlet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import java.util.HashMap;

public class ClearPushReceiver
  extends BroadcastReceiver
{
  public ClearPushReceiver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramInt <= 0)) {
      return;
    }
    Object localObject = new QZoneClickReport.ReportInfo();
    ((QZoneClickReport.ReportInfo)localObject).jdField_c_of_type_JavaLangString = "4";
    ((QZoneClickReport.ReportInfo)localObject).d = "0";
    ((QZoneClickReport.ReportInfo)localObject).b = 1;
    ((QZoneClickReport.ReportInfo)localObject).j = paramString;
    ((QZoneClickReport.ReportInfo)localObject).jdField_c_of_type_Int = paramInt;
    QZoneClickReport.startReportImediately(paramQQAppInterface.getAccount(), (QZoneClickReport.ReportInfo)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("pushReport", 2, "EXPOSE: uin: " + paramQQAppInterface.getAccount() + " pushstatkey: " + paramString);
    }
    localObject = new HashMap();
    ((HashMap)localObject).put("actiontype", "4");
    ((HashMap)localObject).put("pushstatkey", paramString);
    ((HashMap)localObject).put("mergenum", paramInt + "");
    StatisticCollector.a(BaseApplicationImpl.getContext()).a(paramQQAppInterface.getAccount(), "actQZPushDataReport", true, 0L, 0L, (HashMap)localObject, null);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    int i;
    do
    {
      return;
      paramContext = paramIntent.getStringExtra("pushstatkey");
      i = paramIntent.getIntExtra("mergenum", 0);
      localObject = BaseApplicationImpl.a();
    } while (localObject == null);
    Object localObject = (QQAppInterface)((BaseApplicationImpl)localObject).a();
    int j = paramIntent.getIntExtra("pushtype", 0);
    if ((j == 1) || (j == 300))
    {
      paramIntent = (QZoneManagerImp)((QQAppInterface)localObject).getManager(9);
      if (paramIntent != null) {
        paramIntent.a(1, 0);
      }
    }
    a((QQAppInterface)localObject, paramContext, i);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\servlet\ClearPushReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */