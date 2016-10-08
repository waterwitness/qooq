package com.tencent.bitapp;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.bitapp.manager.BitAppInstanceManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BitAppExitBroadcastReceiver
  extends BroadcastReceiver
{
  private static BitAppExitBroadcastReceiver jdField_a_of_type_ComTencentBitappBitAppExitBroadcastReceiver;
  private static final String jdField_a_of_type_JavaLangString = "BitAppExitBroadcastReceiver";
  private static boolean jdField_a_of_type_Boolean = false;
  private static final String b = "com.tencent.process.exit";
  
  public BitAppExitBroadcastReceiver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private String a(ArrayList paramArrayList, boolean paramBoolean)
  {
    Time localTime = new Time();
    localTime.setToNow();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.process.exit");
    localStringBuilder.append(localTime.year).append(localTime.month + 1).append(localTime.monthDay);
    localStringBuilder.append(localTime.hour);
    if (paramBoolean)
    {
      localStringBuilder.append(localTime.minute - 1);
      if (paramArrayList != null) {
        break label142;
      }
    }
    label142:
    for (paramArrayList = "null";; paramArrayList = paramArrayList.toString())
    {
      localStringBuilder.append(paramArrayList);
      paramArrayList = MD5.toMD5(localStringBuilder.toString());
      return MD5.toMD5(paramArrayList + localStringBuilder.toString());
      localStringBuilder.append(localTime.minute);
      break;
    }
  }
  
  public static void a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BitAppExitBroadcastReceiver", 2, "registerReceiver");
    }
    if (jdField_a_of_type_ComTencentBitappBitAppExitBroadcastReceiver == null) {
      jdField_a_of_type_ComTencentBitappBitAppExitBroadcastReceiver = new BitAppExitBroadcastReceiver();
    }
    if ((jdField_a_of_type_ComTencentBitappBitAppExitBroadcastReceiver != null) && (!jdField_a_of_type_Boolean)) {
      jdField_a_of_type_Boolean = true;
    }
    try
    {
      paramContext.getApplicationContext().registerReceiver(jdField_a_of_type_ComTencentBitappBitAppExitBroadcastReceiver, new IntentFilter("com.tencent.process.exit"));
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private boolean a(Context paramContext, ArrayList paramArrayList)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      bool1 = true;
    }
    do
    {
      return bool1;
      paramContext = a(paramContext);
      bool1 = bool2;
    } while (TextUtils.isEmpty(paramContext));
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= paramArrayList.size()) {
        break;
      }
      if (paramContext.equals(paramArrayList.get(i))) {
        return true;
      }
      i += 1;
    }
  }
  
  private boolean a(String paramString, ArrayList paramArrayList)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while ((!paramString.equals(a(paramArrayList, false))) && (!paramString.equals(a(paramArrayList, true)))) {
      return false;
    }
    return true;
  }
  
  public static void b(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BitAppExitBroadcastReceiver", 2, "unregisterReceiver");
    }
    if ((jdField_a_of_type_ComTencentBitappBitAppExitBroadcastReceiver != null) && (jdField_a_of_type_Boolean)) {
      jdField_a_of_type_Boolean = false;
    }
    try
    {
      paramContext.getApplicationContext().unregisterReceiver(jdField_a_of_type_ComTencentBitappBitAppExitBroadcastReceiver);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  String a(Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (paramContext.hasNext()) {
      if ("com.tencent.mobileqq:lola".equals(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName)) {
        return "com.tencent.mobileqq:lola";
      }
    }
    return null;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject;
    if (paramIntent != null)
    {
      localObject = paramIntent.getAction();
      if (QLog.isColorLevel()) {
        QLog.d("BitAppExitBroadcastReceiver", 2, "onReceive: " + (String)localObject);
      }
      if ("com.tencent.process.exit".equals(localObject))
      {
        localObject = paramIntent.getExtras();
        if (localObject != null) {
          break label59;
        }
      }
    }
    label59:
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = ((Bundle)localObject).getStringArrayList("procNameList");
    } while ((!a(((Bundle)localObject).getString("verify"), localArrayList)) || (!a(paramContext, localArrayList)) || (paramIntent.getBooleanExtra("qq_mode_foreground", true)));
    BitAppInstanceManager.getInstance().onDestroy();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\bitapp\BitAppExitBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */