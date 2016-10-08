package com.tencent.mobileqq.olympic.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.os.Build;
import android.provider.Settings.System;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoCell;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoWifi;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.olympic.OlympicDPC;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.olympic.OlympicResources;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarTintManager;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.InflaterInputStream;
import tencent.im.oidb.olympic.MqqLbs.Cell;
import tencent.im.oidb.olympic.MqqLbs.GPS;
import tencent.im.oidb.olympic.MqqLbs.LBSInfo;
import tencent.im.oidb.olympic.MqqLbs.Wifi;
import tsb;
import tsc;

public class OlympicUtil
{
  public static final int a = 658;
  public static final String a = "olympic";
  static SimpleDateFormat a;
  public static final int b = 1134;
  public static final int c = 750;
  public static final int d = 1500;
  public static final int e = 0;
  public static final int f = 1;
  public static final int g = 2;
  public static final int h = -55;
  private static int i = -1;
  private static int j = -1;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static final int a(Context paramContext)
  {
    int k = 0;
    if (i != -1) {
      return i;
    }
    boolean bool;
    if (Build.MANUFACTURER.equals("Meizu")) {
      if (Settings.System.getInt(paramContext.getContentResolver(), "mz_smartbar_auto_hide", 0) == 1)
      {
        bool = true;
        if (!bool) {
          break label163;
        }
        label46:
        i = paramContext.getResources().getDisplayMetrics().heightPixels - k;
        if (QLog.isColorLevel()) {
          QLog.d("Q.olympic", 2, "OlympicUtil|Meizu,autoHideSmartBar:" + bool + ",smartBarHeight:" + k);
        }
      }
    }
    for (;;)
    {
      if (ImmersiveUtils.isSupporImmersive() != 1) {
        i -= ImmersiveUtils.a(paramContext);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.olympic", 2, "OlympicUtil|getContentViewHeight:" + i);
      }
      return i;
      bool = false;
      break;
      try
      {
        label163:
        Class localClass = Class.forName("com.android.internal.R$dimen");
        Object localObject = localClass.newInstance();
        k = Integer.parseInt(localClass.getField("mz_action_button_min_height").get(localObject).toString());
        k = paramContext.getResources().getDimensionPixelSize(k);
      }
      catch (Throwable localThrowable)
      {
        k = SystemBarTintManager.a(paramContext);
      }
      break label46;
      i = paramContext.getResources().getDisplayMetrics().heightPixels;
    }
  }
  
  public static long a(String paramString)
  {
    if (a == null)
    {
      a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
      a.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    }
    long l2 = -1L;
    try
    {
      l1 = a.parse(paramString).getTime();
      if (QLog.isColorLevel()) {
        QLog.d("OlympicUtil", 2, "data2Millis, date = " + paramString + ",millionSeconds = " + l1);
      }
      return l1;
    }
    catch (ParseException localParseException)
    {
      for (;;)
      {
        long l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.d("OlympicUtil", 2, "", localParseException);
          l1 = l2;
        }
      }
    }
  }
  
  public static SharedPreferences a(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = "";
    }
    return SharedPreferencesProxyManager.getInstance().getProxy(str + paramString2, 0);
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat)
  {
    if ((paramBitmap == null) || (paramFloat == 1.0F) || (paramBitmap.getWidth() <= 0) || (paramBitmap.getHeight() <= 0)) {}
    do
    {
      return paramBitmap;
      Object localObject = new Matrix();
      ((Matrix)localObject).postScale(paramFloat, paramFloat);
      try
      {
        localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
        return (Bitmap)localObject;
      }
      catch (OutOfMemoryError localOutOfMemoryError) {}
    } while (!QLog.isColorLevel());
    QLog.e("OlympicUtil", 2, "scaleBitmap,", localOutOfMemoryError);
    return paramBitmap;
  }
  
  public static Bitmap a(String paramString)
  {
    Object localObject = "olympic_" + paramString;
    paramString = (Bitmap)BaseApplicationImpl.a.get(localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("getBitmapFromCache|key:").append((String)localObject).append(" cache is exists:");
      if (paramString == null) {
        break label85;
      }
    }
    label85:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("Q.olympic.cache", 2, bool);
      return paramString;
    }
  }
  
  public static Bitmap a(String paramString, OlympicManager paramOlympicManager)
  {
    Bitmap localBitmap2 = a(paramString);
    Bitmap localBitmap1;
    if (localBitmap2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OlympicUtil", 2, "getBgBitmap cache not exist");
      }
      localBitmap1 = (Bitmap)a(paramString, OlympicResources.a() + paramString, paramOlympicManager.a(), 1).second;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OlympicUtil", 2, "getBgBitmap bgMD5 = " + paramString + ",om = " + paramOlympicManager + ",result = " + localBitmap1);
      }
      return localBitmap1;
      localBitmap1 = localBitmap2;
      if (QLog.isColorLevel())
      {
        QLog.d("OlympicUtil", 2, "getBgBitmap cache exist");
        localBitmap1 = localBitmap2;
      }
    }
  }
  
  public static Pair a(String paramString1, String paramString2, OlympicDPC paramOlympicDPC, int paramInt)
  {
    localObject1 = null;
    n = 0;
    if (TextUtils.isEmpty(paramString2)) {
      return null;
    }
    for (;;)
    {
      try
      {
        localObject2 = new BitmapFactory.Options();
        if (paramOlympicDPC == null) {
          continue;
        }
        ((BitmapFactory.Options)localObject2).inPurgeable = true;
        ((BitmapFactory.Options)localObject2).inInputShareable = true;
        if (!paramOlympicDPC.d) {
          continue;
        }
        ((BitmapFactory.Options)localObject2).inPreferredConfig = Bitmap.Config.ARGB_8888;
        if (!paramOlympicDPC.b) {
          continue;
        }
        ((BitmapFactory.Options)localObject2).inSampleSize = 2;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        Object localObject2;
        if ((paramOlympicDPC == null) || (paramOlympicDPC.b)) {
          break label531;
        }
        paramOlympicDPC.b = true;
        if ((paramInt == 1) && (paramOlympicDPC.c)) {
          break label531;
        }
        localObject1 = a(paramString1, paramString2, paramOlympicDPC, paramInt);
        paramOlympicDPC = (Bitmap)((Pair)localObject1).second;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.olympic", 2, "decodeBitmap OOM|url:" + paramString1);
        k = 0;
        m = 1;
        continue;
        if ((paramInt != 1) || (!paramOlympicDPC.c)) {
          continue;
        }
        localOutOfMemoryError.inSampleSize = 2;
        continue;
      }
      catch (Exception paramOlympicDPC)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.olympic", 2, "decodeBitmap Exception:" + paramOlympicDPC.toString() + ",filePath:" + paramString2);
        paramOlympicDPC = null;
        localObject1 = null;
        int k = 1;
        int m = 0;
        continue;
        localOutOfMemoryError.inSampleSize = 1;
        continue;
        localOutOfMemoryError.inPurgeable = true;
        localOutOfMemoryError.inInputShareable = true;
        localOutOfMemoryError.inSampleSize = 1;
        localOutOfMemoryError.inPreferredConfig = Bitmap.Config.RGB_565;
        localOutOfMemoryError.inDither = true;
        continue;
        paramInt = ((Integer)((Pair)localObject1).first).intValue();
        continue;
        if (m == 0) {
          continue;
        }
        paramInt = 2;
        continue;
        paramInt = n;
        if (k == 0) {
          continue;
        }
        paramInt = 3;
        continue;
        l = paramOlympicDPC.getRowBytes() * paramOlympicDPC.getHeight() / 1024;
        continue;
      }
      localObject2 = BitmapFactory.decodeFile(paramString2, (BitmapFactory.Options)localObject2);
      paramOlympicDPC = (OlympicDPC)localObject2;
      localObject1 = null;
      k = 0;
      m = 0;
      if (paramOlympicDPC != null) {
        a(paramString1, paramOlympicDPC);
      }
      if (localObject1 == null) {
        continue;
      }
      if (((Integer)((Pair)localObject1).first).intValue() != 0) {
        continue;
      }
      paramInt = 1;
      if ((paramOlympicDPC == null) && (m == 0) && (k == 0)) {}
      try
      {
        paramString1 = new File(paramString2);
        if (paramString1.exists()) {
          paramString1.delete();
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.olympic", 2, "decodeBitmap| file.delete()");
        }
      }
      catch (Exception paramString1)
      {
        long l;
        continue;
        Object localObject3 = null;
        paramOlympicDPC = (OlympicDPC)localObject1;
        localObject1 = localObject3;
        continue;
      }
      paramString1 = new Pair(Integer.valueOf(paramInt), paramOlympicDPC);
      if (QLog.isColorLevel())
      {
        if (paramOlympicDPC != null) {
          continue;
        }
        l = 0L;
        QLog.d("Q.olympic", 2, "decodeBitmap|size:" + l + "KB" + ",errCode:" + paramInt);
      }
      return paramString1;
      ((BitmapFactory.Options)localObject2).inPreferredConfig = Bitmap.Config.RGB_565;
      ((BitmapFactory.Options)localObject2).inDither = true;
    }
  }
  
  public static String a(long paramLong)
  {
    if (a == null)
    {
      a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
      a.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    }
    Object localObject2 = null;
    try
    {
      localObject1 = a.format(Long.valueOf(paramLong));
      if (QLog.isColorLevel()) {
        QLog.d("OlympicUtil", 2, "millis2Date, milliseconds = " + paramLong + ",result = " + (String)localObject1);
      }
      return (String)localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("OlympicUtil", 2, "millis2Date, milliseconds = " + paramLong + ",exception = " + localException.getMessage());
          localObject1 = localObject2;
        }
      }
    }
  }
  
  public static String a(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    do
    {
      return str;
      if (paramString.startsWith("http://hb.url.cn/myapp/qq_desk/")) {
        return paramString.substring("http://hb.url.cn/myapp/qq_desk/".length());
      }
      str = paramString;
    } while (!paramString.startsWith("http://"));
    return paramString.substring("http://".length());
  }
  
  public static MqqLbs.LBSInfo a(SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramSosoLbsInfo == null) {}
    for (Object localObject1 = "null";; localObject1 = paramSosoLbsInfo)
    {
      b("OlympicUtil", new Object[] { "parseSosoLbsInfo(), info=", localObject1 });
      if (paramSosoLbsInfo != null) {
        break;
      }
      return null;
    }
    localObject1 = new MqqLbs.LBSInfo();
    Object localObject2 = new MqqLbs.GPS();
    ((MqqLbs.GPS)localObject2).int32_lat.set((int)(paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.c * 1000000.0D));
    ((MqqLbs.GPS)localObject2).int32_lon.set((int)(paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.d * 1000000.0D));
    ((MqqLbs.GPS)localObject2).int32_alt.set((int)paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.e);
    ((MqqLbs.GPS)localObject2).int32_type.set(0);
    ((MqqLbs.GPS)localObject2).uint32_precision.set((int)paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.a);
    ((MqqLbs.LBSInfo)localObject1).msg_gps.set((MessageMicro)localObject2);
    b("OlympicUtil", new Object[] { "parseSosoLbsInfo(),lat=", Integer.valueOf(((MqqLbs.GPS)localObject2).int32_lat.get()), ", lon=", Integer.valueOf(((MqqLbs.GPS)localObject2).int32_lon.get()), ", alt=", Integer.valueOf(((MqqLbs.GPS)localObject2).int32_alt.get()) });
    localObject2 = new ArrayList();
    Object localObject3;
    Object localObject4;
    if (paramSosoLbsInfo.b != null)
    {
      localObject3 = paramSosoLbsInfo.b.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (SosoInterface.SosoWifi)((Iterator)localObject3).next();
        if (localObject4 != null)
        {
          MqqLbs.Wifi localWifi = new MqqLbs.Wifi();
          localWifi.int32_rssi.set(((SosoInterface.SosoWifi)localObject4).jdField_a_of_type_Int);
          localWifi.uint64_mac.set(((SosoInterface.SosoWifi)localObject4).jdField_a_of_type_Long);
          ((List)localObject2).add(localWifi);
          b("OlympicUtil", new Object[] { "parseSosoLbsInfo(), wifi:rssi=", Integer.valueOf(localWifi.int32_rssi.get()), ", mac=", Long.valueOf(localWifi.uint64_mac.get()) });
        }
      }
    }
    ((MqqLbs.LBSInfo)localObject1).rpt_msg_wifis.set((List)localObject2);
    localObject2 = new ArrayList();
    if (paramSosoLbsInfo.jdField_a_of_type_JavaUtilArrayList != null)
    {
      paramSosoLbsInfo = paramSosoLbsInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramSosoLbsInfo.hasNext())
      {
        localObject3 = (SosoInterface.SosoCell)paramSosoLbsInfo.next();
        if (localObject3 != null)
        {
          localObject4 = new MqqLbs.Cell();
          ((MqqLbs.Cell)localObject4).int32_cellid.set(((SosoInterface.SosoCell)localObject3).d);
          ((MqqLbs.Cell)localObject4).int32_lac.set(((SosoInterface.SosoCell)localObject3).c);
          ((MqqLbs.Cell)localObject4).int32_mcc.set(((SosoInterface.SosoCell)localObject3).jdField_a_of_type_Int);
          ((MqqLbs.Cell)localObject4).int32_mnc.set(((SosoInterface.SosoCell)localObject3).b);
          ((MqqLbs.Cell)localObject4).int32_rssi.set(((SosoInterface.SosoCell)localObject3).e);
          ((List)localObject2).add(localObject4);
          b("OlympicUtil", new Object[] { "parseSosoLbsInfo(), cell: cellid=", Integer.valueOf(((MqqLbs.Cell)localObject4).int32_cellid.get()), ", lac=", Integer.valueOf(((MqqLbs.Cell)localObject4).int32_lac.get()), ", mcc=", Integer.valueOf(((MqqLbs.Cell)localObject4).int32_mcc.get()), ", mnc=", Integer.valueOf(((MqqLbs.Cell)localObject4).int32_mnc.get()), ", rssi=", Integer.valueOf(((MqqLbs.Cell)localObject4).int32_rssi.get()) });
        }
      }
    }
    ((MqqLbs.LBSInfo)localObject1).rpt_msg_cells.set((List)localObject2);
    return (MqqLbs.LBSInfo)localObject1;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences("olympic", 0).edit().putLong(paramString, System.currentTimeMillis()).commit();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    paramContext.getSharedPreferences("olympic", 0).edit().putInt("scanner_popup_" + paramString, paramInt).commit();
  }
  
  public static void a(AppInterface paramAppInterface, String paramString, int paramInt)
  {
    a(paramAppInterface, paramString, paramInt, "");
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, int paramInt, String paramString2)
  {
    paramAppInterface.a("CliOper", "", paramString2, paramString1, paramString1, 0, 0, "" + paramInt, "", "", "");
  }
  
  public static void a(String paramString, Bitmap paramBitmap)
  {
    paramString = "olympic_" + paramString;
    BaseApplicationImpl.a.put(paramString, paramBitmap);
    if (QLog.isColorLevel()) {
      QLog.d("Q.olympic.cache", 2, "putBitmapToCache|key:" + paramString + ",size:" + paramBitmap.getRowBytes() * paramBitmap.getHeight() / 1024 + "KB");
    }
  }
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (QLog.isColorLevel()))
    {
      int k = 0;
      while (k < paramVarArgs.length)
      {
        if (paramVarArgs[k] == null) {
          paramVarArgs[k] = "null";
        }
        k += 1;
      }
      QLog.d(paramString, 2, paramVarArgs);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    BaseApplicationImpl.getContext().getSharedPreferences("olympic", 0).edit().putBoolean("dpc_ar_entrance", paramBoolean).commit();
  }
  
  public static boolean a()
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("olympic", 0).getBoolean("dpc_ar_entrance", true);
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = Calendar.getInstance(TimeZone.getTimeZone("GMT+08"));
    localCalendar1.setTimeInMillis(paramLong1);
    Calendar localCalendar2 = Calendar.getInstance(TimeZone.getTimeZone("GMT+08"));
    localCalendar2.setTimeInMillis(paramLong2);
    return (localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) == localCalendar2.get(6));
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    boolean bool = false;
    if (Math.abs(System.currentTimeMillis() - paramContext.getSharedPreferences("olympic", 0).getLong(paramString, -1L)) > 86400000L) {
      bool = true;
    }
    return bool;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      paramArrayOfByte = new InflaterInputStream(new ByteArrayInputStream(paramArrayOfByte));
      byte[] arrayOfByte = new byte['Ā'];
      for (;;)
      {
        int k = paramArrayOfByte.read(arrayOfByte);
        if (-1 == k) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, k);
      }
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    }
    catch (Throwable paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("OlympicUtil", 2, "inflateConfigString");
        paramArrayOfByte.printStackTrace();
      }
      return null;
    }
    return paramArrayOfByte;
  }
  
  public static float[] a(Context paramContext)
  {
    if (paramContext == null) {
      return new float[] { 658.0F, 1134.0F, 1.0F };
    }
    return a(paramContext, b(paramContext), a(paramContext));
  }
  
  public static float[] a(Context paramContext, int paramInt1, int paramInt2)
  {
    float[] arrayOfFloat = new float[3];
    float[] tmp7_5 = arrayOfFloat;
    tmp7_5[0] = 658.0F;
    float[] tmp13_7 = tmp7_5;
    tmp13_7[1] = 1134.0F;
    float[] tmp19_13 = tmp13_7;
    tmp19_13[2] = 1.0F;
    tmp19_13;
    if (paramContext == null) {
      return arrayOfFloat;
    }
    float f1 = 0.0F;
    float f2;
    if (750 * paramInt2 > paramInt1 * 1500)
    {
      f2 = paramInt2 / 'ל';
      float f3 = paramInt1;
      f3 = 'ˮ';
    }
    for (;;)
    {
      arrayOfFloat[0] = ((int)(658.0F * f2 + f1));
      arrayOfFloat[1] = ((int)(f1 + 1134.0F * f2));
      arrayOfFloat[2] = f2;
      if (QLog.isColorLevel()) {
        QLog.d("OlympicUtil", 2, "calculateTorchPos=" + paramInt2 + "," + paramInt1 + "," + arrayOfFloat[0] + "," + arrayOfFloat[1] + "," + arrayOfFloat[2]);
      }
      return arrayOfFloat;
      f2 = paramInt1 / 'ˮ';
      f1 = (paramInt2 - 'ל' * f2) * 0.5F;
    }
  }
  
  public static final int b(Context paramContext)
  {
    if (j != -1) {
      return j;
    }
    j = paramContext.getResources().getDisplayMetrics().widthPixels;
    if (QLog.isColorLevel()) {
      QLog.d("Q.olympic", 2, "OlympicUtil|getContentViewWidth:" + j);
    }
    return j;
  }
  
  public static Bitmap b(String paramString)
  {
    paramString = "olympic_" + paramString;
    return (Bitmap)BaseApplicationImpl.a.remove(paramString);
  }
  
  public static void b(AppInterface paramAppInterface, String paramString, int paramInt)
  {
    ThreadManager.a(new tsb(paramAppInterface, paramString, paramInt), 2, null, true);
  }
  
  public static void b(AppInterface paramAppInterface, String paramString1, int paramInt, String paramString2)
  {
    ThreadManager.a(new tsc(paramAppInterface, paramString1, paramInt, paramString2), 2, null, true);
  }
  
  public static void b(String paramString, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString, 2, paramVarArgs);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\olympic\utils\OlympicUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */