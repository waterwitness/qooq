package com.dataline.util;

import com.tencent.litetransfersdk.ReportItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class QualityReportUtil
{
  public static int a = 19;
  public static final String a = "dlFileTransfer.Quality";
  public static int b = 1;
  public static final String b = "actFAFileUp";
  public static int c = 21;
  public static final String c = "actFAFileDown";
  public static int d = 9;
  public static final String d = "actFAFileConnection";
  private static final int e = 2;
  public static final String e = "sessionid";
  private static final int f = 1;
  public static final String f = "mobileterm";
  public static final String g = "otherterm";
  public static final String h = "channeltype";
  public static final String i = "networktype";
  public static final String j = "filesize";
  public static final String k = "fileexist";
  public static final String l = "startpos";
  public static final String m = "duration";
  public static final String n = "suffix";
  public static final String o = "result";
  public static final String p = "failcode";
  public static final String q = "usercode";
  public static final String r = "clientip";
  public static final String s = "serverip";
  public static final String t = "serverport";
  public static final String u = "taskstart";
  public static final String v = "taskend";
  public static final String w = "notifytime";
  public static final String x = "userretry";
  public static final String y = "qqstate";
  public static final String z = "filetye";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static short a()
  {
    if (NetworkUtil.i(BaseApplication.getContext())) {
      return 18;
    }
    if (NetworkUtil.d(BaseApplication.getContext())) {
      return 19;
    }
    if (NetworkUtil.h(BaseApplication.getContext())) {
      return 20;
    }
    return 17;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ReportItem paramReportItem, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    String str;
    boolean bool;
    label62:
    long l2;
    long l3;
    long l4;
    long l1;
    label129:
    HashMap localHashMap;
    if (paramReportItem.bSend)
    {
      str = "actFAFileUp";
      if ((paramReportItem.emResult != 2) && (paramReportItem.emResult != 26) && (paramReportItem.emResult != 30) && (paramReportItem.emResult != 31) && (paramReportItem.emResult != 34)) {
        break label661;
      }
      bool = true;
      l2 = paramReportItem.uDuration;
      l3 = paramReportItem.uFileSize;
      l4 = paramReportItem.uStartPos;
      l1 = paramInt;
      if ((paramQQAppInterface != null) && (paramInt == b)) {
        ((RegisterProxySvcPackHandler)paramQQAppInterface.a(10)).a();
      }
      l1 = 1L;
      if ((paramReportItem.uDevType != 0) && (paramReportItem.uDevType != 1)) {
        break label667;
      }
      l1 = 1L;
      if (!paramReportItem.bSend) {
        paramReportItem.uSessionID &= 0xEFFFFFFFFFFFFFFF;
      }
      localHashMap = new HashMap();
      localHashMap.put("sessionid", String.valueOf(paramReportItem.uSessionID));
      localHashMap.put("mobileterm", String.valueOf(a));
      localHashMap.put("otherterm", String.valueOf(l1));
      localHashMap.put("channeltype", String.valueOf(paramReportItem.uChannelType));
      localHashMap.put("networktype", String.valueOf(a()));
      localHashMap.put("filesize", String.valueOf(paramReportItem.uFileSize));
      if (!paramReportItem.bFileExist) {
        break label683;
      }
      paramInt = 1;
      label252:
      localHashMap.put("fileexist", String.valueOf(paramInt));
      localHashMap.put("startpos", String.valueOf(paramReportItem.uStartPos));
      localHashMap.put("duration", String.valueOf(paramReportItem.uDuration));
      localHashMap.put("suffix", paramReportItem.sSuffix);
      localHashMap.put("result", String.valueOf(paramReportItem.emResult));
      localHashMap.put("failcode", String.valueOf(paramReportItem.nFailCode));
      localHashMap.put("usercode", String.valueOf(paramReportItem.nUserCode));
      localHashMap.put("filetye", String.valueOf(paramReportItem.uFileType));
      if (!paramQQAppInterface.e) {
        break label688;
      }
      paramInt = 2;
      label375:
      localHashMap.put("qqstate", String.valueOf(paramInt));
      if (paramReportItem.dwClientIP < 0) {
        break label693;
      }
      l1 = paramReportItem.dwClientIP;
      label401:
      localHashMap.put("clientip", String.valueOf(l1));
      if (paramReportItem.dwServerIP < 0) {
        break label707;
      }
      l1 = paramReportItem.dwServerIP;
      label428:
      localHashMap.put("serverip", String.valueOf(l1));
      if (paramReportItem.wServerPort < 0) {
        break label721;
      }
      paramInt = paramReportItem.wServerPort;
      label453:
      localHashMap.put("serverport", String.valueOf(paramInt));
      localHashMap.put("taskstart", String.valueOf(paramReportItem.uTaskStart / 1000L));
      localHashMap.put("taskend", String.valueOf(paramReportItem.uTaskEnd / 1000L));
      localHashMap.put("notifytime", String.valueOf(paramReportItem.uNotifyTime / 1000L));
      if (!paramReportItem.bUserRetry) {
        break label733;
      }
    }
    label661:
    label667:
    label683:
    label688:
    label693:
    label707:
    label721:
    label733:
    for (paramInt = 1;; paramInt = 0)
    {
      localHashMap.put("userretry", String.valueOf(paramInt));
      if (QLog.isColorLevel()) {
        QLog.d("StatisticCollector", 2, "dataline event report: " + str + "session id = " + (String)localHashMap.get("sessionid") + " FILEASSISTANT_MOBILETERM = " + (String)localHashMap.get("mobileterm") + "  Report FILEASSISTANT_OTHERTERM  =  " + (String)localHashMap.get("otherterm"));
      }
      StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface.a(), str, bool, l2, l3 - l4, localHashMap, null);
      return;
      str = "actFAFileDown";
      break;
      bool = false;
      break label62;
      if (paramReportItem.uDevType != 3) {
        break label129;
      }
      l1 = 21L;
      break label129;
      paramInt = 0;
      break label252;
      paramInt = 1;
      break label375;
      l1 = paramReportItem.dwClientIP + 4294967295L;
      break label401;
      l1 = paramReportItem.dwServerIP + 4294967295L;
      break label428;
      paramInt = paramReportItem.wServerPort + 65535;
      break label453;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    for (;;)
    {
      Object localObject;
      int i1;
      try
      {
        localObject = new String[4];
        i1 = NetworkUtil.a(paramQQAppInterface.getApplication().getApplicationContext());
        if (i1 == 1)
        {
          if (paramBoolean2)
          {
            localObject[0] = "param_WIFIFAFileUploadFlow";
            break label212;
            localObject[3] = "param_Flow";
            paramQQAppInterface.a(paramQQAppInterface.getAccount(), (String[])localObject, paramLong);
            if (!QLog.isColorLevel()) {
              break label229;
            }
            localObject = new StringBuilder().append("addFlowCount ").append(paramLong).append(" for ");
            if (!paramBoolean1) {
              break label257;
            }
            paramQQAppInterface = "nfc";
            localObject = ((StringBuilder)localObject).append(paramQQAppInterface).append(" ");
            if (!paramBoolean2) {
              break label264;
            }
            paramQQAppInterface = "upload";
            localObject = ((StringBuilder)localObject).append(paramQQAppInterface).append(", netType is ");
            if (i1 != 1) {
              break label187;
            }
            paramQQAppInterface = "wifi";
            QLog.d("dlFileTransfer.Quality", 2, paramQQAppInterface);
            return;
          }
          localObject[0] = "param_WIFIFAFileDownloadFlow";
        }
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return;
      }
      if (paramBoolean2)
      {
        localObject[0] = "param_XGFAFileUploadFlow";
        break label230;
        label187:
        paramQQAppInterface = "nonwifi : " + i1;
        continue;
        label212:
        localObject[1] = "param_WIFIFileFlow";
        localObject[2] = "param_WIFIFlow";
        continue;
        label229:
        return;
      }
      for (;;)
      {
        label230:
        localObject[1] = "param_XGFileFlow";
        localObject[2] = "param_XGFlow";
        break;
        localObject[0] = "param_XGFAFileDownloadFlow";
      }
      label257:
      paramQQAppInterface = "ftn";
      continue;
      label264:
      paramQQAppInterface = "download";
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\dataline\util\QualityReportUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */