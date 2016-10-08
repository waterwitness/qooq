package com.tencent.biz.TroopMemberLbs;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.lbs.LbsInfoMgr;
import com.tencent.mobileqq.app.lbs.LbsInfoMgr.LocationInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import hfo;
import hfp;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TroopMemberLbsHelper
{
  protected static final double a = 6378137.0D;
  public static final int a = 1;
  public static final String a = "TroopMemberLbsHelper";
  public static final int b = 1;
  
  public TroopMemberLbsHelper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private static double a(double paramDouble)
  {
    return 3.141592653589793D * paramDouble / 180.0D;
  }
  
  public static double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    double d1 = paramDouble1 / 1000000.0D;
    paramDouble1 = paramDouble2 / 1000000.0D;
    double d2 = paramDouble3 / 1000000.0D;
    paramDouble3 = paramDouble4 / 1000000.0D;
    paramDouble2 = a(d1);
    paramDouble4 = a(d2);
    paramDouble1 = a(paramDouble1);
    paramDouble3 = a(paramDouble3);
    d1 = Math.pow(Math.sin((paramDouble2 - paramDouble4) / 2.0D), 2.0D);
    return Math.round(Math.asin(Math.sqrt(Math.cos(paramDouble2) * Math.cos(paramDouble4) * Math.pow(Math.sin((paramDouble1 - paramDouble3) / 2.0D), 2.0D) + d1)) * 2.0D * 6378137.0D * 10000.0D) / 10000L;
  }
  
  public static double a(double paramDouble1, double paramDouble2, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = a(paramQQAppInterface);
    if (paramQQAppInterface == null) {}
    while ((paramQQAppInterface.b == 0L) && (paramQQAppInterface.a == 0L)) {
      return -100.0D;
    }
    return a(paramDouble1, paramDouble2, paramQQAppInterface.b, paramQQAppInterface.a);
  }
  
  public static LbsInfoMgr.LocationInfo a(QQAppInterface paramQQAppInterface)
  {
    return ((LbsInfoMgr)paramQQAppInterface.getManager(65)).a();
  }
  
  public static Boolean a(String paramString, QQAppInterface paramQQAppInterface)
  {
    return Boolean.valueOf(((TroopInfoManager)paramQQAppInterface.getManager(36)).c(paramString));
  }
  
  public static CharSequence a(String paramString1, String paramString2, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(51);
    double d = paramQQAppInterface.a(paramString1, paramString2);
    long l = paramQQAppInterface.a(paramString1, paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("Q.troopMemberDistance", 2, "getDiatanceToSelf: troopUin=" + paramString1 + ", memberUin=" + paramString2 + ", distance=" + d + ", timestamp=" + l);
    }
    if (d == -1001.0D) {
      return null;
    }
    if (l == 0L) {
      return null;
    }
    if (l > 0L) {}
    for (l = System.currentTimeMillis() - l;; l = 0L)
    {
      if ((d != -100.0D) && (d != -1000.0D) && (l < 7200000L)) {}
      for (int i = 1;; i = 0)
      {
        if ((d != -1000.0D) && (l >= 7200000L)) {
          paramQQAppInterface.a(paramString1, paramString2, null, -100, null, null, -100, -100, -100, -100L, (byte)-100, -100L, -1000.0D);
        }
        if ((i != 0) && (d >= 0.0D)) {
          break;
        }
        return null;
      }
      paramString1 = a(d);
      paramString1 = "  [icon]" + " " + paramString1;
      paramString2 = new ImageSpan(paramContext, 2130839389, 1);
      paramString1 = new SpannableString(paramString1);
      paramString1.setSpan(paramString2, 2, "  [icon]".length(), 17);
      return paramString1;
    }
  }
  
  public static String a(double paramDouble)
  {
    if (paramDouble < 10.0D) {
      return "0.01km";
    }
    if (paramDouble < 10000.0D)
    {
      DecimalFormat localDecimalFormat = new DecimalFormat("0.00");
      return localDecimalFormat.format(Math.round(paramDouble / 10.0D) * 0.01D) + "km";
    }
    return String.valueOf(Math.round(paramDouble / 1000.0D)) + "km";
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    ((TroopInfoManager)paramQQAppInterface.getManager(36)).a();
  }
  
  public static void a(String paramString, QQAppInterface paramQQAppInterface)
  {
    ((TroopInfoManager)paramQQAppInterface.getManager(36)).b(paramString);
  }
  
  public static void a(String paramString1, String paramString2, long paramLong1, long paramLong2, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (TroopInfoManager)paramQQAppInterface.getManager(36);
    LbsInfoMgr.LocationInfo localLocationInfo = new LbsInfoMgr.LocationInfo();
    localLocationInfo.b = paramLong1;
    localLocationInfo.a = paramLong2;
    paramString1 = paramString1 + "|" + paramString2;
    paramQQAppInterface.a(paramString1, localLocationInfo);
    if (QLog.isColorLevel()) {
      QLog.i("TroopMemberLbsHelper", 2, "cacheTroopMemberLocation:  key = " + paramString1);
    }
  }
  
  public static void a(String paramString, boolean paramBoolean, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    paramQQAppInterface = (BizTroopHandler)paramQQAppInterface.a(22);
    if (!paramBoolean)
    {
      DialogUtil.a(paramContext, 230).setTitle(paramContext.getResources().getString(2131367535)).setMessage(paramContext.getResources().getString(2131364889)).setNegativeButton(paramContext.getResources().getString(2131364890), new hfp(paramQQAppInterface, paramString)).setPositiveButton(paramContext.getResources().getString(2131364891), new hfo()).show();
      return;
    }
    paramQQAppInterface.c(paramString, paramBoolean);
  }
  
  public static boolean a(String paramString, QQAppInterface paramQQAppInterface)
  {
    return ((TroopInfoManager)paramQQAppInterface.getManager(36)).a(paramString);
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    TroopInfoManager localTroopInfoManager = (TroopInfoManager)paramQQAppInterface.getManager(36);
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(51);
    Object localObject1 = localTroopInfoManager.a();
    if ((localObject1 == null) || (((ConcurrentHashMap)localObject1).size() == 0)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopMemberLbsHelper", 2, "calculateChachedTroopMemberDistance:  mapChachedMemLocation.size = " + ((ConcurrentHashMap)localObject1).size());
    }
    a(paramQQAppInterface);
    localObject1 = ((ConcurrentHashMap)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      LbsInfoMgr.LocationInfo localLocationInfo = (LbsInfoMgr.LocationInfo)((Map.Entry)localObject2).getValue();
      if (localLocationInfo != null)
      {
        localObject2 = (String)((Map.Entry)localObject2).getKey();
        if (QLog.isColorLevel()) {
          QLog.i("TroopMemberLbsHelper", 2, "calculateChachedTroopMemberDistance:  key = " + (String)localObject2);
        }
        Object localObject3 = ((String)localObject2).split("\\|");
        if (localObject3.length >= 2)
        {
          localObject2 = localObject3[0];
          localObject3 = localObject3[1];
          if (QLog.isColorLevel()) {
            QLog.i("TroopMemberLbsHelper", 2, "calculateChachedTroopMemberDistance:  lat = " + localLocationInfo.b + " lon = " + localLocationInfo.a);
          }
          double d = a(localLocationInfo.b, localLocationInfo.a, paramQQAppInterface);
          localTroopManager.a((String)localObject2, (String)localObject3, null, -100, null, null, -100, -100, -100, -100L, (byte)-100, -100L, d);
          if (QLog.isColorLevel()) {
            QLog.i("TroopMemberLbsHelper", 2, "saveTroopMemberEx:  troopCode = " + (String)localObject2 + " troopMemberUin = " + (String)localObject3 + " distance = " + d);
          }
        }
      }
    }
    localTroopInfoManager.a();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\TroopMemberLbs\TroopMemberLbsHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */