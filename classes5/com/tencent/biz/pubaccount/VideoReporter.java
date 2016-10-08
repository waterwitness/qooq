package com.tencent.biz.pubaccount;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import hso;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class VideoReporter
{
  public static final int a = 1;
  public static final String a = "0";
  public static HashSet a;
  public static final int b = 2;
  public static final String b = "1";
  public static final int c = 3;
  public static final String c = "2";
  public static final int d = 4;
  public static final String d = "0";
  public static final int e = 5;
  public static final String e = "1";
  public static final int f = 6;
  public static final String f = "2";
  public static final int g = 7;
  public static final String g = "isFromKandian";
  public static final int h = -1;
  public static final String h = "sourceArticleId";
  public static final int i = 0;
  public static final String i = "innderId";
  public static final int j = 1;
  public static final String j = "channelID";
  public static final int k = 2;
  public static final String k = "algorithmID";
  public static final int l = 3;
  public static final String l = "strategyId";
  public static final int m = 4;
  public static final String m = "interactionType";
  
  public VideoReporter()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(int paramInt, String paramString)
  {
    int i1 = 1;
    int n;
    if (paramInt != 2)
    {
      n = i1;
      if (paramInt != 3) {}
    }
    else
    {
      n = i1;
      if (!TextUtils.isEmpty(paramString)) {
        n = paramString.hashCode();
      }
    }
    return n;
  }
  
  public static String a()
  {
    int n = NetworkUtil.b(BaseApplicationImpl.a().getApplicationContext());
    if (n == 1) {
      return "0";
    }
    if ((n == 3) || (n == 4)) {
      return "1";
    }
    return "2";
  }
  
  public static String a(int paramInt)
  {
    String str = "";
    if (paramInt == 1008) {
      str = "1";
    }
    if (paramInt == 0) {
      str = "2";
    }
    do
    {
      return str;
      if (paramInt == 1) {
        return "3";
      }
    } while (paramInt != 3000);
    return "4";
  }
  
  public static void a(long paramLong1, int paramInt1, int paramInt2, long paramLong2)
  {
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = ReadInJoyUtils.a();
    localReportInfo.mSource = 0;
    localReportInfo.mOpSource = 0;
    localReportInfo.mSourceArticleId = paramLong1;
    localReportInfo.mChannelId = paramInt1;
    localReportInfo.mOperation = paramInt2;
    localReportInfo.mPlayTimeLength = ((int)paramLong2);
    localArrayList.add(localReportInfo);
    new UserOperationModule(null, null, ReadInJoyMSFService.a(), null).a(localArrayList);
  }
  
  public static void a(VideoInfo paramVideoInfo)
  {
    if (a == null) {
      a = new HashSet();
    }
    if (a.contains(paramVideoInfo)) {
      return;
    }
    a.add(paramVideoInfo);
  }
  
  public static void a(String paramString)
  {
    ThreadManager.a(new hso(paramString), 5, null, true);
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = ReadInJoyUtils.a();
    localReportInfo.mSource = 0;
    localReportInfo.mOpSource = 5;
    localReportInfo.mSourceArticleId = -1L;
    localReportInfo.mInnerId = paramString;
    localReportInfo.mChannelId = paramInt1;
    localReportInfo.mAlgorithmId = paramInt2;
    localReportInfo.mStrategyId = paramInt3;
    localReportInfo.mOperation = paramInt4;
    localReportInfo.mPlayTimeLength = paramInt5;
    localArrayList.add(localReportInfo);
    new UserOperationModule(null, null, ReadInJoyMSFService.a(), null).a(localArrayList);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    String str = "";
    if (paramInt1 == 1008) {
      str = "1";
    }
    if (paramInt1 == 0) {
      str = "2";
    }
    for (;;)
    {
      ReportController.b(null, "CliOper", "", "", paramString1, paramString1, 0, 0, str, Integer.toString(paramInt2), paramString3, paramString2);
      return;
      if (paramInt1 == 1) {
        str = "3";
      } else if (paramInt1 == 3000) {
        str = "4";
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\VideoReporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */