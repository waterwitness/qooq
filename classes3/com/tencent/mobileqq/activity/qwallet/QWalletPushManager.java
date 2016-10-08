package com.tencent.mobileqq.activity.qwallet;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Vibrator;
import android.text.TextUtils;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQCardHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.NoDisturbUtil;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.qwallet.plugin.QWalletLockScreenActivity;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import otp;
import tencent.im.s2c.msgtype0x210.submsgtype0x66.submsgtype0x66.MsgBody;

public class QWalletPushManager
{
  private static final int jdField_a_of_type_Int = 1;
  public static long a = 0L;
  private static ArrayList jdField_a_of_type_JavaUtilArrayList;
  private static final long[] jdField_a_of_type_ArrayOfLong = { 100L, 200L, 200L, 100L };
  private static final int jdField_b_of_type_Int = 2;
  private static long jdField_b_of_type_Long = 0L;
  private static ArrayList jdField_b_of_type_JavaUtilArrayList;
  private static final int c = 3;
  private static final int d = 4;
  private static final int e = 5;
  private static final int f = 6;
  private static final int g = 7;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static int a()
  {
    if (jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    int i = 0;
    int k;
    for (int j = 0; i < jdField_a_of_type_JavaUtilArrayList.size(); j = k)
    {
      QWalletPushManager.PCPayData localPCPayData = (QWalletPushManager.PCPayData)jdField_a_of_type_JavaUtilArrayList.get(i);
      k = j;
      if (localPCPayData != null)
      {
        k = j;
        if (localPCPayData.f == 0) {
          k = j + 1;
        }
      }
      i += 1;
    }
    return j;
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
      return 9;
    case 2: 
      return 4;
    case 3: 
      return 11;
    case 4: 
      return 8;
    case 5: 
      return 7;
    case 6: 
      return 6;
    }
    return 14;
  }
  
  private static QWalletPushManager.PCPayData a()
  {
    Object localObject;
    if (jdField_a_of_type_JavaUtilArrayList == null)
    {
      localObject = null;
      return (QWalletPushManager.PCPayData)localObject;
    }
    int i = 0;
    for (;;)
    {
      if (i >= jdField_a_of_type_JavaUtilArrayList.size()) {
        break label54;
      }
      QWalletPushManager.PCPayData localPCPayData = (QWalletPushManager.PCPayData)jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localPCPayData != null)
      {
        localObject = localPCPayData;
        if (localPCPayData.f == 1) {
          break;
        }
      }
      i += 1;
    }
    label54:
    return null;
  }
  
  public static QWalletPushManager.PCPayData a(boolean paramBoolean)
  {
    Object localObject;
    if (jdField_a_of_type_JavaUtilArrayList == null)
    {
      localObject = null;
      return (QWalletPushManager.PCPayData)localObject;
    }
    QWalletPushManager.PCPayData localPCPayData;
    if (paramBoolean)
    {
      i = jdField_a_of_type_JavaUtilArrayList.size() - 1;
      for (;;)
      {
        if (i < 0) {
          break label101;
        }
        localPCPayData = (QWalletPushManager.PCPayData)jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localPCPayData != null)
        {
          localObject = localPCPayData;
          if (localPCPayData.f == 0) {
            break;
          }
        }
        i -= 1;
      }
    }
    int i = 0;
    for (;;)
    {
      if (i >= jdField_a_of_type_JavaUtilArrayList.size()) {
        break label101;
      }
      localPCPayData = (QWalletPushManager.PCPayData)jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localPCPayData != null)
      {
        localObject = localPCPayData;
        if (localPCPayData.f == 0) {
          break;
        }
      }
      i += 1;
    }
    label101:
    return null;
  }
  
  public static void a()
  {
    if (jdField_a_of_type_JavaUtilArrayList == null) {}
    for (;;)
    {
      return;
      int i = jdField_a_of_type_JavaUtilArrayList.size() - 1;
      while (i >= 0)
      {
        QWalletPushManager.PCPayData localPCPayData = (QWalletPushManager.PCPayData)jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localPCPayData == null) || (localPCPayData.f == 1)) {
          jdField_a_of_type_JavaUtilArrayList.remove(i);
        }
        i -= 1;
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, QWalletPushManager.PCPayData paramPCPayData)
  {
    String str1;
    boolean bool1;
    if (QQUtils.a(paramQQAppInterface.a()))
    {
      ((PowerManager)paramQQAppInterface.a().getSystemService("power")).newWakeLock(268435462, "Q.qwallet.push").acquire(10000L);
      String str2 = String.format(BaseApplication.getContext().getString(2131366523), new Object[] { Integer.valueOf(a()) });
      if (!TextUtils.isEmpty(paramPCPayData.jdField_c_of_type_JavaLangString))
      {
        str1 = paramPCPayData.jdField_c_of_type_JavaLangString;
        Intent localIntent = new Intent(paramQQAppInterface.a(), QWalletLockScreenActivity.class);
        localIntent.addFlags(67108864);
        localIntent.addFlags(268435456);
        localIntent.addFlags(262144);
        localIntent.addFlags(1073741824);
        localIntent.putExtra("title", str2);
        localIntent.putExtra("content", str1);
        localIntent.putExtra("time", TimeFormatterUtils.c(BaseApplication.getContext(), paramPCPayData.jdField_b_of_type_Long));
        paramQQAppInterface.a().startActivity(localIntent);
      }
    }
    else
    {
      bool1 = paramQQAppInterface.h();
      bool2 = PhoneStatusTools.e(paramQQAppInterface.a());
      boolean bool3 = paramQQAppInterface.d();
      boolean bool4 = paramQQAppInterface.q();
      boolean bool5 = NoDisturbUtil.a(paramQQAppInterface.a().getApplicationContext(), paramQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qwallet.push", 2, "isRingerSilent=" + bool1 + ",isCalling=" + bool2 + ",isVideoChatting=" + bool3 + ",isRecordingPtt=" + bool4 + ",canDisturb=" + bool5);
      }
      if ((bool5) && (!bool2) && (!bool1) && (!bool3) && (!bool4))
      {
        if (paramQQAppInterface.d() != 0) {
          break label473;
        }
        bool1 = false;
        label314:
        if (paramQQAppInterface.e() != 0) {
          break label479;
        }
      }
    }
    label473:
    label479:
    for (boolean bool2 = false;; bool2 = true)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qwallet.push", 2, "canPlaySound=" + bool1 + ",canVibrator=" + bool2);
      }
      if (bool2)
      {
        paramQQAppInterface = (Vibrator)paramQQAppInterface.a().getSystemService("vibrator");
        if (paramQQAppInterface != null) {
          paramQQAppInterface.vibrate(jdField_a_of_type_ArrayOfLong, -1);
        }
      }
      if (bool1)
      {
        paramQQAppInterface = ThemeUtil.getThemeVoiceRootPath();
        if (paramQQAppInterface == null) {
          break label485;
        }
        paramQQAppInterface = new File(paramQQAppInterface + File.separatorChar + "message.mp3");
        if (!paramQQAppInterface.exists()) {
          break label485;
        }
        AudioUtil.a(Uri.fromFile(paramQQAppInterface), false, true);
      }
      return;
      str1 = BaseApplication.getContext().getString(2131366524);
      break;
      bool1 = true;
      break label314;
    }
    label485:
    AudioUtil.a(2131165214, false);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i = 4;
    int k = 0;
    int j = 0;
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel())
      {
        QLog.d("Q.qwallet.push", 2, "PCPayData is empty.");
        break label29;
      }
    }
    label29:
    while (paramQQAppInterface == null) {
      return;
    }
    for (;;)
    {
      int m;
      int n;
      try
      {
        paramString = new JSONObject(paramString);
        m = paramString.optInt("module", 0);
        n = paramString.optInt("action", 0);
        if ((m < 1) || (m > 2) || (n < 1) || (n > 2)) {
          break label29;
        }
        if ((m != 1) || (n != 1)) {
          break label205;
        }
        paramString = paramQQAppInterface.a();
        if (Build.VERSION.SDK_INT <= 10) {
          break label200;
        }
        paramString = paramString.getSharedPreferences("qwallet_multi", i);
        if (paramString == null) {
          break label397;
        }
        paramString.edit().putBoolean("is_refresh_home", true).commit();
      }
      catch (JSONException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
      }
      if ((i == 0) || (!QWalletHelper.a(paramQQAppInterface.a()))) {
        break;
      }
      if (m == 1)
      {
        paramString = "com.qwallet.refresh.home";
        b(paramQQAppInterface, paramString);
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.qwallet.push", 2, "Parsing PCPAYDATA throws JSONException.");
        return;
        label200:
        i = 0;
        continue;
        label205:
        if ((m == 1) && (n == 2))
        {
          FileUtils.d(paramQQAppInterface.a().getFilesDir() + "/" + QWalletHelper.d(paramQQAppInterface.a()));
          i = 1;
          continue;
        }
        if ((m == 2) && (n == 1))
        {
          paramString = paramQQAppInterface.a();
          i = k;
          if (Build.VERSION.SDK_INT > 10) {
            i = 4;
          }
          paramString = paramString.getSharedPreferences("qwallet_multi", i);
          if (paramString == null) {
            break label402;
          }
          paramString.edit().putBoolean("is_refresh_center", true).commit();
          break label402;
        }
        i = j;
        if (m != 2) {
          continue;
        }
        i = j;
        if (n != 2) {
          continue;
        }
        FileUtils.d(paramQQAppInterface.a().getFilesDir() + "/" + QWalletHelper.b(paramQQAppInterface.a()));
        i = 1;
        continue;
      }
      paramString = "com.qwallet.refresh.center";
      continue;
      label397:
      i = 1;
      continue;
      label402:
      i = 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.push", 2, "onQQForeground isFromGestureLock=" + paramBoolean);
    }
    if (paramQQAppInterface == null) {
      break label36;
    }
    label36:
    while (a(false) == null) {
      return;
    }
    if (paramBoolean) {}
    for (int i = 5;; i = 1000)
    {
      MqqHandler localMqqHandler = ThreadManager.b();
      if (localMqqHandler == null) {
        break;
      }
      localMqqHandler.postDelayed(new otp(paramQQAppInterface), i);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      break label4;
    }
    label4:
    while (a(paramArrayOfByte)) {
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        paramArrayOfByte = (submsgtype0x66.MsgBody)new submsgtype0x66.MsgBody().mergeFrom(paramArrayOfByte);
        if (!paramArrayOfByte.uint32_type.has()) {
          break label296;
        }
        i = paramArrayOfByte.uint32_type.get();
        j = i;
      }
      catch (Exception paramArrayOfByte)
      {
        try
        {
          if (!paramArrayOfByte.bytes_push_data.has()) {
            continue;
          }
          paramArrayOfByte = paramArrayOfByte.bytes_push_data.get();
          j = i;
          if (paramArrayOfByte == null) {
            continue;
          }
          paramArrayOfByte = paramArrayOfByte.toByteArray();
          if ((i == -1) || (paramArrayOfByte == null)) {
            break label4;
          }
          if (QLog.isColorLevel()) {
            QLog.d("QWalletOnlinePush", 2, "push type = " + i);
          }
          switch (i)
          {
          default: 
            if (!QLog.isColorLevel()) {
              break label4;
            }
            QLog.d("Q.qwallet.push", 2, "Unknow pushType.");
            return;
          }
        }
        catch (Exception paramArrayOfByte)
        {
          int j;
          continue;
        }
        paramArrayOfByte = paramArrayOfByte;
        i = -1;
        paramArrayOfByte.printStackTrace();
        j = i;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.qwallet.push", 2, "Parsing Msg0x210Sub0x66 data throws Exception.");
          j = i;
        }
        paramArrayOfByte = null;
        i = j;
        continue;
        try
        {
          c(paramQQAppInterface, new String(paramArrayOfByte, "UTF-8"));
          return;
        }
        catch (Exception paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
        }
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.qwallet.push", 2, "Coverting pushData to String throws Exception.");
      return;
      try
      {
        a(paramQQAppInterface, new String(paramArrayOfByte, "UTF-8"));
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.qwallet.push", 2, "Coverting pushData to String throws Exception.");
      return;
      paramQQAppInterface = (QQCardHandler)paramQQAppInterface.a(69);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface.a(8, true, null);
        continue;
        label296:
        i = -1;
      }
    }
  }
  
  protected static boolean a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return true;
    }
    long l = System.currentTimeMillis();
    int i = jdField_b_of_type_JavaUtilArrayList.size();
    if ((i > 0) && (Math.abs(l - jdField_b_of_type_Long) > 1800000L)) {
      jdField_b_of_type_JavaUtilArrayList.clear();
    }
    int j = ByteBuffer.wrap(paramArrayOfByte).hashCode();
    i -= 1;
    while (i >= 0)
    {
      if (((Integer)jdField_b_of_type_JavaUtilArrayList.get(i)).intValue() == j) {
        return true;
      }
      i -= 1;
    }
    jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(j));
    jdField_b_of_type_Long = l;
    return false;
  }
  
  public static void b()
  {
    if (jdField_a_of_type_JavaUtilArrayList == null) {
      return;
    }
    jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  private static void b(QQAppInterface paramQQAppInterface)
  {
    boolean bool1 = false;
    if ((paramQQAppInterface == null) || (jdField_a_of_type_JavaUtilArrayList == null)) {}
    label394:
    label399:
    for (;;)
    {
      return;
      boolean bool2 = QQUtils.a(paramQQAppInterface.a());
      if (QLog.isColorLevel()) {
        QLog.d("Q.qwallet.push", 2, "startForegroundPay isScreenLock=" + bool2);
      }
      if (!bool2)
      {
        QWalletPushManager.PCPayData localPCPayData = a();
        int i;
        if (localPCPayData == null)
        {
          if (jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
            continue;
          }
          localPCPayData = (QWalletPushManager.PCPayData)jdField_a_of_type_JavaUtilArrayList.get(0);
          if (localPCPayData == null)
          {
            jdField_a_of_type_JavaUtilArrayList.remove(0);
            b(paramQQAppInterface);
            return;
          }
          i = a(localPCPayData.e);
          if (i == 0)
          {
            jdField_a_of_type_JavaUtilArrayList.remove(0);
            b(paramQQAppInterface);
            return;
          }
          bool2 = PayBridgeActivity.a();
          if ((!bool2) || (QWalletHelper.a(paramQQAppInterface.getApplication().getApplicationContext()))) {
            break label394;
          }
        }
        for (;;)
        {
          if (bool1) {
            break label399;
          }
          try
          {
            localPCPayData.f = 1;
            paramQQAppInterface = new Intent(BaseApplication.getContext(), PayBridgeActivity.class);
            paramQQAppInterface.addFlags(268435456);
            Bundle localBundle = new Bundle();
            localBundle.putString("json", localPCPayData.jdField_b_of_type_JavaLangString);
            localBundle.putString("callbackSn", "0");
            localBundle.putBoolean("payparmas_from_pcpush", true);
            paramQQAppInterface.addFlags(67108864);
            paramQQAppInterface.addFlags(536870912);
            paramQQAppInterface.putExtras(localBundle);
            paramQQAppInterface.putExtra("pay_requestcode", i);
            paramQQAppInterface.putExtra("payparmas_paytype", 2);
            paramQQAppInterface.putExtra("vacreport_key_seq", jdField_a_of_type_Long);
            BaseApplication.getContext().startActivity(paramQQAppInterface);
            return;
          }
          catch (Exception paramQQAppInterface)
          {
            paramQQAppInterface.printStackTrace();
            localPCPayData.f = 2;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.qwallet.push", 2, "Starting pay throws Exception.");
          return;
          bool2 = PayBridgeActivity.a();
          bool1 = bool2;
          if (bool2)
          {
            bool1 = bool2;
            if (!QWalletHelper.a(paramQQAppInterface.getApplication().getApplicationContext())) {
              bool1 = false;
            }
          }
          bool2 = bool1;
          if (bool1)
          {
            long l = System.currentTimeMillis();
            bool2 = bool1;
            if (43200L * 1000L + localPCPayData.jdField_c_of_type_Long > l) {
              bool2 = false;
            }
          }
          if (bool2) {
            break;
          }
          localPCPayData.f = 2;
          b(paramQQAppInterface);
          return;
          bool1 = bool2;
        }
      }
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, QWalletPushManager.PCPayData paramPCPayData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.push", 2, "startBackgroundPay");
    }
    if ((paramQQAppInterface == null) || (paramQQAppInterface.a() == null) || (paramPCPayData == null)) {}
    Object localObject1;
    do
    {
      return;
      String str = String.format(BaseApplication.getContext().getString(2131366523), new Object[] { Integer.valueOf(a()) });
      localObject1 = paramPCPayData.jdField_c_of_type_JavaLangString;
      paramPCPayData = (QWalletPushManager.PCPayData)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramPCPayData = BaseApplication.getContext().getString(2131366524);
      }
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("callbackSn", "0");
      ((Bundle)localObject1).putBoolean("payparmas_from_pcpush", true);
      ((Bundle)localObject1).putInt("pay_requestcode", 12);
      ((Bundle)localObject1).putInt("payparmas_paytype", 2);
      ((Bundle)localObject1).putLong("vacreport_key_seq", jdField_a_of_type_Long);
      Object localObject2 = new Intent(paramQQAppInterface.a(), PayBridgeActivity.class);
      ((Intent)localObject2).addFlags(268435456);
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      localObject2 = PendingIntent.getActivity(paramQQAppInterface.a(), 12, (Intent)localObject2, 1073741824);
      localObject1 = new Notification(2130838718, str, System.currentTimeMillis());
      ((Notification)localObject1).flags = 16;
      ((Notification)localObject1).setLatestEventInfo(paramQQAppInterface.a(), str, paramPCPayData, (PendingIntent)localObject2);
      paramQQAppInterface = (NotificationManager)paramQQAppInterface.a().getSystemService("notification");
    } while (paramQQAppInterface == null);
    paramQQAppInterface.cancel(128);
    paramQQAppInterface.notify(128, (Notification)localObject1);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = new Intent(paramString);
    paramQQAppInterface.a().sendBroadcast(paramString);
  }
  
  /* Error */
  public static void b(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_1
    //   6: invokestatic 388	com/tencent/mobileqq/activity/qwallet/QWalletPushManager:a	([B)Z
    //   9: ifne -5 -> 4
    //   12: new 603	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$MsgBody
    //   15: dup
    //   16: invokespecial 604	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$MsgBody:<init>	()V
    //   19: aload_1
    //   20: invokevirtual 605	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   23: checkcast 603	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$MsgBody
    //   26: astore_1
    //   27: aload_1
    //   28: getfield 609	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$MsgBody:msg_online_push	Ltencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$WalletMsgPush;
    //   31: invokevirtual 612	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$WalletMsgPush:has	()Z
    //   34: ifeq -30 -> 4
    //   37: aload_1
    //   38: getfield 609	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$MsgBody:msg_online_push	Ltencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$WalletMsgPush;
    //   41: invokevirtual 615	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$WalletMsgPush:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   44: checkcast 611	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$WalletMsgPush
    //   47: astore 4
    //   49: aload 4
    //   51: ifnull -47 -> 4
    //   54: iconst_m1
    //   55: istore 6
    //   57: iconst_m1
    //   58: istore 7
    //   60: ldc_w 617
    //   63: astore_3
    //   64: ldc_w 617
    //   67: astore_1
    //   68: iconst_m1
    //   69: istore 8
    //   71: aload 4
    //   73: getfield 620	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$WalletMsgPush:uint32_action	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   76: invokevirtual 404	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   79: ifeq +13 -> 92
    //   82: aload 4
    //   84: getfield 620	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$WalletMsgPush:uint32_action	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   87: invokevirtual 406	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   90: istore 6
    //   92: aload 4
    //   94: getfield 623	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$WalletMsgPush:uint32_timestamp	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   97: invokevirtual 404	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   100: ifeq +13 -> 113
    //   103: aload 4
    //   105: getfield 623	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$WalletMsgPush:uint32_timestamp	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   108: invokevirtual 406	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   111: istore 7
    //   113: aload_3
    //   114: astore_2
    //   115: aload 4
    //   117: getfield 626	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$WalletMsgPush:bytes_extend	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   120: invokevirtual 413	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   123: ifeq +36 -> 159
    //   126: aload 4
    //   128: getfield 626	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$WalletMsgPush:bytes_extend	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   131: invokevirtual 416	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   134: astore 5
    //   136: aload_3
    //   137: astore_2
    //   138: aload 5
    //   140: ifnull +19 -> 159
    //   143: new 124	java/lang/String
    //   146: dup
    //   147: aload 5
    //   149: invokevirtual 422	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   152: ldc_w 436
    //   155: invokespecial 439	java/lang/String:<init>	([BLjava/lang/String;)V
    //   158: astore_2
    //   159: aload 4
    //   161: getfield 630	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$WalletMsgPush:str_serialno	Lcom/tencent/mobileqq/pb/PBStringField;
    //   164: invokevirtual 633	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   167: ifeq +12 -> 179
    //   170: aload 4
    //   172: getfield 630	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$WalletMsgPush:str_serialno	Lcom/tencent/mobileqq/pb/PBStringField;
    //   175: invokevirtual 635	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   178: astore_1
    //   179: aload 4
    //   181: getfield 638	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$WalletMsgPush:str_billno	Lcom/tencent/mobileqq/pb/PBStringField;
    //   184: invokevirtual 633	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   187: ifeq +12 -> 199
    //   190: aload 4
    //   192: getfield 638	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$WalletMsgPush:str_billno	Lcom/tencent/mobileqq/pb/PBStringField;
    //   195: invokevirtual 635	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   198: astore_1
    //   199: aload 4
    //   201: getfield 641	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$WalletMsgPush:str_appinfo	Lcom/tencent/mobileqq/pb/PBStringField;
    //   204: invokevirtual 633	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   207: ifeq +12 -> 219
    //   210: aload 4
    //   212: getfield 641	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$WalletMsgPush:str_appinfo	Lcom/tencent/mobileqq/pb/PBStringField;
    //   215: invokevirtual 635	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   218: astore_1
    //   219: aload 4
    //   221: getfield 644	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$WalletMsgPush:uint32_amount	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   224: invokevirtual 404	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   227: ifeq +13 -> 240
    //   230: aload 4
    //   232: getfield 644	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$WalletMsgPush:uint32_amount	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   235: invokevirtual 406	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   238: istore 8
    //   240: aload 4
    //   242: getfield 647	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$WalletMsgPush:str_jumpurl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   245: invokevirtual 633	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   248: ifeq +12 -> 260
    //   251: aload 4
    //   253: getfield 647	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$WalletMsgPush:str_jumpurl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   256: invokevirtual 635	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   259: astore_1
    //   260: new 288	org/json/JSONObject
    //   263: dup
    //   264: invokespecial 648	org/json/JSONObject:<init>	()V
    //   267: astore_3
    //   268: new 288	org/json/JSONObject
    //   271: dup
    //   272: invokespecial 648	org/json/JSONObject:<init>	()V
    //   275: astore 4
    //   277: new 288	org/json/JSONObject
    //   280: dup
    //   281: aload_2
    //   282: invokespecial 289	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   285: astore 5
    //   287: aload 4
    //   289: ldc_w 297
    //   292: iload 6
    //   294: invokevirtual 652	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   297: pop
    //   298: aload 4
    //   300: ldc_w 654
    //   303: aload 5
    //   305: invokevirtual 657	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   308: pop
    //   309: aload_3
    //   310: ldc_w 659
    //   313: aload_0
    //   314: invokevirtual 348	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   317: invokevirtual 657	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   320: pop
    //   321: aload_3
    //   322: ldc_w 661
    //   325: ldc_w 663
    //   328: invokevirtual 657	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   331: pop
    //   332: aload_3
    //   333: ldc_w 665
    //   336: ldc_w 667
    //   339: invokevirtual 657	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   342: pop
    //   343: aload_3
    //   344: ldc_w 669
    //   347: aload 4
    //   349: invokevirtual 657	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   352: pop
    //   353: aload_0
    //   354: invokevirtual 76	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   357: astore 5
    //   359: getstatic 302	android/os/Build$VERSION:SDK_INT	I
    //   362: bipush 10
    //   364: if_icmple +447 -> 811
    //   367: iconst_4
    //   368: istore 9
    //   370: aload 5
    //   372: ldc_w 304
    //   375: iload 9
    //   377: invokevirtual 308	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   380: astore 5
    //   382: aload 5
    //   384: ifnull +89 -> 473
    //   387: aload_0
    //   388: invokevirtual 348	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   391: astore_0
    //   392: aload 5
    //   394: new 202	java/lang/StringBuilder
    //   397: dup
    //   398: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   401: ldc_w 671
    //   404: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: aload_0
    //   408: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: lconst_0
    //   415: invokeinterface 675 4 0
    //   420: lstore 10
    //   422: invokestatic 680	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   425: ldc2_w 553
    //   428: ldiv
    //   429: lstore 12
    //   431: lload 12
    //   433: lload 10
    //   435: lcmp
    //   436: ifge +276 -> 712
    //   439: aload 5
    //   441: invokeinterface 314 1 0
    //   446: new 202	java/lang/StringBuilder
    //   449: dup
    //   450: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   453: ldc_w 671
    //   456: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: aload_0
    //   460: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: lconst_0
    //   467: invokeinterface 683 4 0
    //   472: pop
    //   473: new 511	android/os/Bundle
    //   476: dup
    //   477: invokespecial 512	android/os/Bundle:<init>	()V
    //   480: astore_0
    //   481: aload_0
    //   482: ldc_w 514
    //   485: aload_3
    //   486: invokevirtual 684	org/json/JSONObject:toString	()Ljava/lang/String;
    //   489: invokevirtual 520	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   492: aload_0
    //   493: ldc_w 522
    //   496: ldc_w 524
    //   499: invokevirtual 520	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   502: new 139	android/content/Intent
    //   505: dup
    //   506: invokestatic 109	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   509: ldc_w 500
    //   512: invokespecial 144	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   515: astore 4
    //   517: aload 4
    //   519: ldc -106
    //   521: invokevirtual 149	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   524: pop
    //   525: aload 4
    //   527: aload_0
    //   528: invokevirtual 534	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   531: pop
    //   532: aload 4
    //   534: ldc_w 536
    //   537: iconst_5
    //   538: invokevirtual 539	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   541: pop
    //   542: invokestatic 109	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   545: aload 4
    //   547: invokevirtual 173	com/tencent/qphone/base/util/BaseApplication:startActivity	(Landroid/content/Intent;)V
    //   550: invokestatic 687	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   553: ifeq -549 -> 4
    //   556: ldc 94
    //   558: iconst_4
    //   559: new 202	java/lang/StringBuilder
    //   562: dup
    //   563: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   566: ldc_w 689
    //   569: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: iload 6
    //   574: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   577: ldc_w 691
    //   580: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: iload 7
    //   585: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   588: ldc_w 693
    //   591: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: aload_2
    //   595: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: ldc_w 695
    //   601: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: aload_1
    //   605: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: ldc_w 697
    //   611: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: ldc_w 617
    //   617: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: ldc_w 699
    //   623: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: ldc_w 617
    //   629: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: ldc_w 701
    //   635: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: iload 8
    //   640: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   643: ldc_w 703
    //   646: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: ldc_w 617
    //   652: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: ldc_w 705
    //   658: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: aload_3
    //   662: invokevirtual 684	org/json/JSONObject:toString	()Ljava/lang/String;
    //   665: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   671: invokestatic 708	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   674: return
    //   675: astore_0
    //   676: aload_0
    //   677: invokevirtual 432	java/lang/Exception:printStackTrace	()V
    //   680: invokestatic 200	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   683: ifeq -679 -> 4
    //   686: ldc 94
    //   688: iconst_2
    //   689: ldc_w 710
    //   692: invokestatic 227	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   695: return
    //   696: astore 5
    //   698: invokestatic 687	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   701: ifeq -348 -> 353
    //   704: aload 5
    //   706: invokevirtual 432	java/lang/Exception:printStackTrace	()V
    //   709: goto -356 -> 353
    //   712: lload 12
    //   714: lload 10
    //   716: lsub
    //   717: ldc2_w 711
    //   720: lcmp
    //   721: ifge -248 -> 473
    //   724: new 288	org/json/JSONObject
    //   727: dup
    //   728: invokespecial 648	org/json/JSONObject:<init>	()V
    //   731: astore_0
    //   732: aload_0
    //   733: ldc_w 714
    //   736: iconst_0
    //   737: invokevirtual 652	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   740: pop
    //   741: aload_0
    //   742: ldc_w 716
    //   745: ldc_w 617
    //   748: invokevirtual 657	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   751: pop
    //   752: aload_0
    //   753: ldc_w 718
    //   756: iconst_4
    //   757: invokevirtual 652	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   760: pop
    //   761: aload_0
    //   762: ldc_w 720
    //   765: aload 4
    //   767: invokevirtual 657	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   770: pop
    //   771: new 722	com/tencent/mobileqq/openapi/sdk/QQResult$QQStringResult
    //   774: dup
    //   775: iconst_4
    //   776: iconst_0
    //   777: aload_0
    //   778: invokevirtual 684	org/json/JSONObject:toString	()Ljava/lang/String;
    //   781: invokespecial 725	com/tencent/mobileqq/openapi/sdk/QQResult$QQStringResult:<init>	(IILjava/lang/String;)V
    //   784: astore_0
    //   785: invokestatic 730	com/tencent/mobileqq/openapi/OpenApiManager:a	()Lcom/tencent/mobileqq/openapi/OpenApiManager;
    //   788: aload_0
    //   789: invokevirtual 733	com/tencent/mobileqq/openapi/OpenApiManager:a	(Lcom/tencent/mobileqq/openapi/sdk/QQResult$QQStringResult;)V
    //   792: goto -319 -> 473
    //   795: astore 4
    //   797: invokestatic 687	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   800: ifeq -29 -> 771
    //   803: aload 4
    //   805: invokevirtual 432	java/lang/Exception:printStackTrace	()V
    //   808: goto -37 -> 771
    //   811: iconst_0
    //   812: istore 9
    //   814: goto -444 -> 370
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	817	0	paramQQAppInterface	QQAppInterface
    //   0	817	1	paramArrayOfByte	byte[]
    //   114	481	2	localObject1	Object
    //   63	599	3	localObject2	Object
    //   47	719	4	localObject3	Object
    //   795	9	4	localException1	Exception
    //   134	306	5	localObject4	Object
    //   696	9	5	localException2	Exception
    //   55	518	6	i	int
    //   58	526	7	j	int
    //   69	570	8	k	int
    //   368	445	9	m	int
    //   420	295	10	l1	long
    //   429	284	12	l2	long
    // Exception table:
    //   from	to	target	type
    //   12	49	675	java/lang/Exception
    //   71	92	675	java/lang/Exception
    //   92	113	675	java/lang/Exception
    //   115	136	675	java/lang/Exception
    //   143	159	675	java/lang/Exception
    //   159	179	675	java/lang/Exception
    //   179	199	675	java/lang/Exception
    //   199	219	675	java/lang/Exception
    //   219	240	675	java/lang/Exception
    //   240	260	675	java/lang/Exception
    //   260	277	675	java/lang/Exception
    //   353	367	675	java/lang/Exception
    //   370	382	675	java/lang/Exception
    //   387	431	675	java/lang/Exception
    //   439	473	675	java/lang/Exception
    //   473	674	675	java/lang/Exception
    //   698	709	675	java/lang/Exception
    //   724	732	675	java/lang/Exception
    //   771	792	675	java/lang/Exception
    //   797	808	675	java/lang/Exception
    //   277	353	696	java/lang/Exception
    //   732	771	795	java/lang/Exception
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = BaseApplicationImpl.a();
    if (localObject1 == null) {
      return false;
    }
    boolean bool = GesturePWDUtils.getGestureLocking((Context)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.push", 2, "isQQForeground isQQLock=" + bool);
    }
    if ((paramQQAppInterface == null) || (bool)) {
      return false;
    }
    if (!paramQQAppInterface.isBackground_Pause) {
      return true;
    }
    try
    {
      Object localObject2 = (ActivityManager)((Context)localObject1).getApplicationContext().getSystemService("activity");
      if (localObject2 == null) {
        return false;
      }
      paramQQAppInterface = ((Context)localObject1).getApplicationContext().getPackageName();
      if (TextUtils.isEmpty(paramQQAppInterface)) {
        return false;
      }
      localObject1 = ((ActivityManager)localObject2).getRunningAppProcesses();
      if (localObject1 == null) {
        return false;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
        if ((((ActivityManager.RunningAppProcessInfo)localObject2).importance == 100) && (((ActivityManager.RunningAppProcessInfo)localObject2).processName != null))
        {
          if (((ActivityManager.RunningAppProcessInfo)localObject2).processName.equals(paramQQAppInterface + ":video")) {
            return false;
          }
          if (!((ActivityManager.RunningAppProcessInfo)localObject2).processName.equals(paramQQAppInterface))
          {
            bool = ((ActivityManager.RunningAppProcessInfo)localObject2).processName.startsWith(paramQQAppInterface + ":");
            if (!bool) {
              break;
            }
          }
          else
          {
            return true;
          }
        }
      }
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      return false;
    }
    return false;
  }
  
  private static void c(QQAppInterface paramQQAppInterface, String arg1)
  {
    if (TextUtils.isEmpty(???)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qwallet.push", 2, "PCPayData is empty.");
      }
    }
    while ((paramQQAppInterface == null) || (jdField_a_of_type_JavaUtilArrayList == null)) {
      return;
    }
    for (;;)
    {
      QWalletPushManager.PCPayData localPCPayData;
      try
      {
        localPCPayData = new QWalletPushManager.PCPayData();
        localPCPayData.jdField_b_of_type_Long = System.currentTimeMillis();
        ??? = new JSONObject(???);
        localPCPayData.jdField_a_of_type_Long = ???.optLong("tradeTime", 0L);
        localPCPayData.d = ???.optInt("expTime", 0);
        localPCPayData.e = ???.optInt("payType", 0);
        localPCPayData.jdField_c_of_type_JavaLangString = ???.optString("notifyText");
        ??? = ???.optJSONObject("payData");
        if (??? != null) {
          localPCPayData.jdField_b_of_type_JavaLangString = ???.toString();
        }
        if ((localPCPayData.e < 1) || (localPCPayData.e > 6) || (TextUtils.isEmpty(localPCPayData.jdField_b_of_type_JavaLangString))) {
          break;
        }
        if (localPCPayData.e == 1) {
          jdField_a_of_type_Long = VACDReportUtil.a(null, "qqwallet", "pay-pcpush", "payinvoke", null, 0, null);
        }
        synchronized (jdField_a_of_type_JavaUtilArrayList)
        {
          jdField_a_of_type_JavaUtilArrayList.add(localPCPayData);
          if (!b(paramQQAppInterface)) {
            break label262;
          }
          if (jdField_a_of_type_Long != 0L) {
            VACDReportUtil.a(jdField_a_of_type_Long, null, "startForegroundPay", null, 0, null);
          }
          b(paramQQAppInterface);
          jdField_a_of_type_Long = 0L;
          a(paramQQAppInterface, localPCPayData);
          return;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (JSONException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
      }
      QLog.d("Q.qwallet.push", 2, "Parsing PCPAYDATA throws JSONException.");
      return;
      label262:
      if (jdField_a_of_type_Long != 0L) {
        VACDReportUtil.a(jdField_a_of_type_Long, null, "startBackgroundPay", null, 0, null);
      }
      b(paramQQAppInterface, localPCPayData);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qwallet\QWalletPushManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */