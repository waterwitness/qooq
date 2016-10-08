package com.tencent.mobileqq.precover;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PrecoverConfig;
import com.tencent.mobileqq.data.PrecoverResource;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.handler.PrecoverHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PrecoverReporter
{
  public static final String a = "PrecoverReporter";
  private PrecoverManager a;
  
  public PrecoverReporter(PrecoverManager paramPrecoverManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramPrecoverManager;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverReporter", 2, "reportResourceCover");
    }
    if (this.a == null) {
      return;
    }
    Object localObject3 = this.a.a();
    Object localObject2 = new HashSet();
    Object localObject4 = (String[])((HashMap)localObject3).keySet().toArray(new String[((HashMap)localObject3).keySet().size()]);
    int i = 0;
    Object localObject5;
    label101:
    Object localObject6;
    boolean bool1;
    if (i < localObject4.length)
    {
      localObject1 = localObject4[i];
      localObject5 = (List)((HashMap)localObject3).get(localObject1);
      if (localObject5 == null) {
        ((HashSet)localObject2).add(localObject1);
      }
      for (;;)
      {
        i += 1;
        break;
        localObject5 = ((List)localObject5).iterator();
        if (((Iterator)localObject5).hasNext())
        {
          localObject6 = (PrecoverResource)((Iterator)localObject5).next();
          bool1 = PrecoverUtils.a(((PrecoverResource)localObject6).businessId, ((PrecoverResource)localObject6).md5);
          if (QLog.isColorLevel()) {
            QLog.d("PrecoverReporter", 2, new Object[] { "reportResourceCover: exist=", Boolean.valueOf(bool1), ", res=", localObject6 });
          }
          if (bool1) {
            break label101;
          }
          ((HashSet)localObject2).add(localObject1);
        }
      }
    }
    int j;
    if (((HashSet)localObject2).size() == 0)
    {
      bool1 = true;
      j = PrecoverUtils.a(this.a.a().a(), this.a.a().a());
      localObject5 = new HashMap();
      ((HashMap)localObject5).put("config_version", String.valueOf(j));
      if (!bool1) {
        break label357;
      }
      localObject1 = "1";
      label275:
      ((HashMap)localObject5).put("id_all", localObject1);
      i = 0;
      label287:
      if (i >= localObject4.length) {
        break label369;
      }
      localObject1 = localObject4[i];
      localObject6 = "id_" + (String)localObject1;
      if (!((HashSet)localObject2).contains(localObject1)) {
        break label363;
      }
    }
    label357:
    label363:
    for (Object localObject1 = "0";; localObject1 = "1")
    {
      ((HashMap)localObject5).put(localObject6, localObject1);
      i += 1;
      break label287;
      bool1 = false;
      break;
      localObject1 = "0";
      break label275;
    }
    label369:
    StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.a.a().a(), "precover_res_cover", bool1, 0L, 0L, (HashMap)localObject5, "", false);
    localObject4 = this.a.a();
    if (bool1)
    {
      localObject1 = "1";
      ReportController.b((QQAppInterface)localObject4, "CliOper", "", "", "0X8007134", "0X8007134", 0, 0, String.valueOf(j), (String)localObject1, "id_all", "");
      localObject3 = ((HashMap)localObject3).keySet().iterator();
      label453:
      if (!((Iterator)localObject3).hasNext()) {
        break label554;
      }
      localObject4 = (String)((Iterator)localObject3).next();
      localObject5 = this.a.a();
      if (!((HashSet)localObject2).contains(localObject4)) {
        break label548;
      }
    }
    label548:
    for (localObject1 = "0";; localObject1 = "1")
    {
      ReportController.b((QQAppInterface)localObject5, "CliOper", "", "", "0X8007134", "0X8007134", 0, 0, String.valueOf(j), (String)localObject1, "id_" + (String)localObject4, "");
      break label453;
      localObject1 = "0";
      break;
    }
    for (;;)
    {
      try
      {
        label554:
        localObject1 = (EarlyDownloadManager)this.a.a().getManager(76);
        if (localObject1 == null) {
          break;
        }
        localObject1 = (PrecoverHandler)((EarlyDownloadManager)localObject1).a("qq.android.early.precover");
        if (localObject1 == null) {
          break;
        }
        bool1 = ((PrecoverHandler)localObject1).d();
        boolean bool2 = ((PrecoverHandler)localObject1).k();
        localObject2 = new HashMap();
        if (!bool1) {
          break label720;
        }
        localObject1 = "1";
        ((HashMap)localObject2).put("storage_exist", localObject1);
        if (!bool2) {
          break label738;
        }
        localObject1 = "1";
        ((HashMap)localObject2).put("backup_exist", localObject1);
        if ((!bool1) || (!bool2)) {
          break label726;
        }
        localObject1 = "1";
        ((HashMap)localObject2).put("all_exist", localObject1);
        localObject1 = StatisticCollector.a(BaseApplicationImpl.getContext());
        localObject3 = this.a.a().a();
        if ((!bool1) || (!bool2)) {
          break label732;
        }
        bool1 = true;
        ((StatisticCollector)localObject1).a((String)localObject3, "precover_handler", bool1, 0L, 0L, (HashMap)localObject2, "", false);
        return;
      }
      catch (Throwable localThrowable) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      localThrowable.printStackTrace();
      return;
      label720:
      String str = "0";
      continue;
      label726:
      str = "0";
      continue;
      label732:
      bool1 = false;
      continue;
      label738:
      str = "0";
    }
  }
  
  public void a(PrecoverResource paramPrecoverResource, int paramInt, String paramString1, String paramString2, long paramLong)
  {
    if (paramPrecoverResource == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverReporter", 2, "reportDownloadResult, res == null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverReporter", 2, new Object[] { "reportDownloadResult, res=", paramPrecoverResource, ", errCode=", Integer.valueOf(paramInt), ", errDesc=", paramString1, ", keyReason=", paramString2, ", size=", Long.valueOf(paramLong) });
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    localHashMap.put("url", PrecoverUtils.b(paramPrecoverResource.url));
    localHashMap.put("md5", paramPrecoverResource.md5);
    localHashMap.put("err_desc", paramString1);
    localHashMap.put("business_id", "id_" + paramPrecoverResource.businessId);
    localHashMap.put("netresp_param_reason", paramString2);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        localHashMap.put("file_size", String.format("%.3f", new Object[] { Float.valueOf((float)paramLong * 1.0F / 1048576.0F) }));
      }
      StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.a.a().a(), "precover_download_result", bool, 0L, paramLong, localHashMap, "", false);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverReporter", 2, "reportConfigCover");
    }
    if (this.a == null) {}
    for (;;)
    {
      return;
      int i = PrecoverUtils.a(this.a.a().a(), this.a.a().a());
      Object localObject2 = this.a.a(null, null, PrecoverConfig.class);
      HashMap localHashMap = new HashMap();
      localHashMap.put("config_version", String.valueOf(i));
      if ((localObject2 != null) && (((List)localObject2).size() > 0)) {}
      for (Object localObject1 = "1";; localObject1 = "0")
      {
        localHashMap.put("id_all", localObject1);
        if (localObject2 == null) {
          break;
        }
        localObject1 = ((List)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          PrecoverConfig localPrecoverConfig = (PrecoverConfig)((Iterator)localObject1).next();
          localHashMap.put("id_" + localPrecoverConfig.businessId, "1");
        }
      }
      StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.a.a().a(), "precover_config_cover", paramBoolean, 0L, 0L, localHashMap, "", false);
      ReportController.b(this.a.a(), "CliOper", "", "", "0X8007133 ", "0X8007133 ", 0, 0, String.valueOf(i), "", "id_all", "");
      if (localObject2 != null)
      {
        localObject1 = ((List)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (PrecoverConfig)((Iterator)localObject1).next();
          ReportController.b(this.a.a(), "CliOper", "", "", "0X8007133 ", "0X8007133 ", 0, 0, String.valueOf(i), "", "id_" + ((PrecoverConfig)localObject2).businessId, "");
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\precover\PrecoverReporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */