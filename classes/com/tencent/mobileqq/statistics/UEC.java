package com.tencent.mobileqq.statistics;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.Fragment.IFragmentAttachCallback;
import android.support.v4.app.Fragment.IFragmentLifecycleCallback;
import android.support.v4.app.FragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadOptimizer;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;

public final class UEC
  implements Application.ActivityLifecycleCallbacks, Fragment.IFragmentAttachCallback, Fragment.IFragmentLifecycleCallback
{
  public static UEC a;
  public static final String a = "preAct";
  public static final String b = "preAct_time";
  private int jdField_a_of_type_Int;
  private LinkedHashMap jdField_a_of_type_JavaUtilLinkedHashMap;
  private final boolean jdField_a_of_type_Boolean;
  
  public UEC()
  {
    boolean bool2 = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap(8);
    if (BaseApplicationImpl.i == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool1;
      jdField_a_of_type_ComTencentMobileqqStatisticsUEC = this;
      this.jdField_a_of_type_Int = 0;
      return;
      bool1 = false;
    }
  }
  
  private String a(Activity paramActivity, boolean paramBoolean)
  {
    if (paramActivity == null) {
      paramActivity = "null";
    }
    String str1;
    do
    {
      do
      {
        return paramActivity;
        String str2 = paramActivity.getClass().getSimpleName();
        str1 = str2;
        if ((paramActivity instanceof PluginProxyActivity))
        {
          paramActivity = a(((PluginProxyActivity)paramActivity).getPluginActivity());
          str1 = str2 + "_" + paramActivity;
        }
        paramActivity = str1;
      } while (!this.jdField_a_of_type_Boolean);
      paramActivity = str1;
    } while (paramBoolean);
    return str1 + "_" + ThreadOptimizer.a().a();
  }
  
  private String a(Fragment paramFragment)
  {
    if (paramFragment == null) {
      paramFragment = "null";
    }
    String str;
    do
    {
      return paramFragment;
      str = a(paramFragment.getActivity(), true);
      paramFragment = paramFragment.getClass().getSimpleName();
      str = str + "_fg_" + paramFragment;
      paramFragment = str;
    } while (!this.jdField_a_of_type_Boolean);
    return str + "_" + ThreadOptimizer.a().a();
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.contains("."))
      {
        str = paramString;
        if (!paramString.endsWith(".")) {
          str = paramString.substring(paramString.lastIndexOf('.') + 1, paramString.length());
        }
      }
    }
    return str;
  }
  
  private String a(String paramString, Activity paramActivity)
  {
    paramActivity = a(paramActivity, true);
    paramActivity = paramActivity + "_fm_" + paramString;
    paramString = paramActivity;
    if (this.jdField_a_of_type_Boolean) {
      paramString = paramActivity + "_" + ThreadOptimizer.a().a();
    }
    return paramString;
  }
  
  public static String a(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    if (paramString2 != null)
    {
      str1 = paramString2;
      if (!paramString2.equals("")) {}
    }
    else
    {
      str1 = "preActNull";
    }
    paramString2 = a(str1);
    if ((paramString1 == null) || (paramString1.equals(""))) {
      return paramString2 + "+" + paramInt + ":" + paramLong;
    }
    if (!paramString1.contains(paramString2)) {
      return paramString1 + "|" + paramString2 + "+" + paramInt + ":" + paramLong;
    }
    String str2 = paramString1.substring(paramString1.indexOf(paramString2));
    int k = str2.indexOf("+");
    int m = str2.indexOf(":");
    int j = str2.indexOf("|");
    int i = j;
    if (j == -1) {
      i = str2.length();
    }
    String str1 = str2.substring(k + 1, m);
    str2 = str2.substring(m + 1, i);
    i = Integer.valueOf(str1).intValue();
    long l = Long.valueOf(str2).longValue();
    paramLong = (i * l / (i + paramInt) + 0.5D + (paramInt * paramLong / (i + paramInt) + 0.5D));
    return paramString1.replace(paramString2 + "+" + i + ":" + l, paramString2 + "+" + (i + paramInt) + ":" + paramLong);
  }
  
  private void a()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilLinkedHashMap;
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap(8);
    ArrayList localArrayList = new ArrayList(((LinkedHashMap)localObject).size());
    localObject = ((LinkedHashMap)localObject).values().iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add((UEC.UECItem)((Iterator)localObject).next());
    }
    if (this.jdField_a_of_type_Boolean)
    {
      a(localArrayList);
      return;
    }
    localObject = new Intent();
    ((Intent)localObject).putParcelableArrayListExtra("UECData", localArrayList);
    ((Intent)localObject).setClass(BaseApplicationImpl.a, UECReceiver.class);
    BaseApplicationImpl.a.sendBroadcast((Intent)localObject);
  }
  
  private void a(Object paramObject, String paramString, boolean paramBoolean)
  {
    int i = paramObject.hashCode();
    if (paramBoolean)
    {
      a(paramString, i);
      return;
    }
    a(paramString, null, 0L, i, null);
    b(paramString, i);
  }
  
  public UEC.UECItem a(String paramString1, String paramString2, long paramLong, int paramInt, Bundle paramBundle)
  {
    paramBundle = (UEC.UECItem)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramString1);
    if (paramBundle == null)
    {
      paramBundle = new UEC.UECItem();
      paramBundle.jdField_a_of_type_JavaLangString = paramString1;
      paramBundle.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramString1, paramBundle);
    }
    for (paramString1 = paramBundle;; paramString1 = paramBundle)
    {
      paramString1.jdField_b_of_type_JavaLangString = a(paramString1.jdField_b_of_type_JavaLangString, paramString2, 1, paramLong);
      return paramString1;
      paramBundle.jdField_a_of_type_Int += 1;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    UEC.UECItem localUECItem2 = (UEC.UECItem)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramString);
    UEC.UECItem localUECItem1 = localUECItem2;
    if (localUECItem2 == null) {
      localUECItem1 = a(paramString, null, 0L, paramInt, null);
    }
    if ((paramInt == localUECItem1.c) && (localUECItem1.jdField_b_of_type_Long > 0L))
    {
      localUECItem1.jdField_a_of_type_Long = (SystemClock.uptimeMillis() - localUECItem1.jdField_b_of_type_Long + localUECItem1.jdField_a_of_type_Long);
      localUECItem1.jdField_b_of_type_Long = 0L;
    }
  }
  
  public void a(String paramString, Activity paramActivity, boolean paramBoolean)
  {
    if (paramString != null) {
      a(paramString, a(paramString, paramActivity), paramBoolean);
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (!"Success".equals(BaseApplicationImpl.sInjectResult)) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = (QQAppInterface)BaseApplicationImpl.a.a();
        if (localObject != null)
        {
          UEC.IReporter localIReporter = (UEC.IReporter)((QQAppInterface)localObject).getManager(133);
          if (localIReporter != null) {
            localIReporter.a(paramArrayList);
          }
        }
      } while (localObject == null);
      localObject = (UEC.IReporter)((QQAppInterface)localObject).getManager(157);
    } while (localObject == null);
    ((UEC.IReporter)localObject).a(paramArrayList);
  }
  
  public void b(String paramString, int paramInt)
  {
    UEC.UECItem localUECItem2 = (UEC.UECItem)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramString);
    UEC.UECItem localUECItem1 = localUECItem2;
    if (localUECItem2 == null) {
      localUECItem1 = a(paramString, null, 0L, paramInt, null);
    }
    localUECItem1.c = paramInt;
    localUECItem1.jdField_b_of_type_Int += 1;
    localUECItem1.jdField_b_of_type_Long = SystemClock.uptimeMillis();
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    long l1 = 0L;
    Object localObject1 = paramActivity.getIntent();
    if (localObject1 != null) {}
    for (;;)
    {
      try
      {
        localObject1 = ((Intent)localObject1).getExtras();
        if (localObject1 == null) {
          break label111;
        }
        String str = ((Bundle)localObject1).getString("preAct");
        long l2 = ((Bundle)localObject1).getLong("preAct_time", 0L);
        localObject1 = str;
        if (l2 != 0L)
        {
          l1 = System.currentTimeMillis();
          l1 -= l2;
          localObject1 = str;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        localObject2 = null;
        l1 = 0L;
        continue;
      }
      if ((paramActivity instanceof FragmentActivity)) {
        ((FragmentActivity)paramActivity).setFragmentAttachListener(this);
      }
      a(a(paramActivity, false), (String)localObject1, l1, paramActivity.hashCode(), paramBundle);
      return;
      label111:
      Object localObject2 = null;
    }
  }
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity)
  {
    a(a(paramActivity, false), paramActivity.hashCode());
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    b(a(paramActivity, false), paramActivity.hashCode());
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    this.jdField_a_of_type_Int += 1;
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    this.jdField_a_of_type_Int -= 1;
    if (this.jdField_a_of_type_Int == 0) {
      a();
    }
  }
  
  public void onFragmentAttached(Fragment paramFragment)
  {
    if (paramFragment != null) {
      paramFragment.setFragmentLifecycleCallback(this);
    }
  }
  
  public void onFragmentHiddenChanged(Fragment paramFragment, boolean paramBoolean)
  {
    if (paramFragment != null) {
      a(paramFragment, a(paramFragment), paramBoolean);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\statistics\UEC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */