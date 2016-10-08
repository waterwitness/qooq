package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.View;
import android.widget.ListAdapter;
import com.tencent.biz.thridappshare.ThridAppShareHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.ShortcutRouterActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.WebAccelerator;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.lang.reflect.Field;
import java.util.List;
import ncf;
import ncg;

public final class AIOUtils
{
  public static final int a = 100;
  private static SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private static Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
  private static ThreadLocal jdField_a_of_type_JavaLangThreadLocal = new ncf();
  private static Field jdField_a_of_type_JavaLangReflectField;
  public static volatile boolean a = false;
  public static final int b = 1;
  public static volatile boolean b = false;
  public static final int c = 2;
  public static volatile boolean c = false;
  public static final int d = 3;
  public static volatile boolean d = false;
  public static final int e = 4;
  public static volatile boolean e = false;
  public static final int f = 5;
  public static volatile boolean f = false;
  public static final int g = 6;
  public static volatile boolean g = false;
  public static final int h = 1;
  public static volatile boolean h = false;
  public static final int i = 2;
  public static volatile boolean i = false;
  public static final int j = 3;
  public static volatile boolean j = false;
  public static final int k = 4;
  public static volatile boolean k = false;
  public static final int l = 5;
  public static boolean l;
  private static boolean m;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static final float a(int paramInt1, int paramInt2, Resources paramResources)
  {
    return TypedValue.applyDimension(paramInt1, paramInt2, paramResources.getDisplayMetrics());
  }
  
  public static final int a(float paramFloat, Resources paramResources)
  {
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static int a(int paramInt)
  {
    int n = 0;
    long l1 = 0L;
    int i1 = c(paramInt);
    if (QLog.isColorLevel()) {
      l1 = SystemClock.uptimeMillis();
    }
    for (;;)
    {
      try
      {
        if (m) {
          return b(paramInt);
        }
        Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.aio_config.name(), "-1|1=0,2=0,3=0,4=0,5=1");
        if (QLog.isColorLevel()) {
          QLog.d("AIOUtils", 2, "aioConfig:" + (String)localObject);
        }
        localObject = ((String)localObject).split("\\|");
        if (localObject.length > 1)
        {
          localObject = localObject[1].split(",");
          if (localObject != null)
          {
            int i2 = localObject.length;
            if (n < i2)
            {
              String[] arrayOfString = localObject[n].split("=");
              if ((arrayOfString == null) || (arrayOfString.length <= 1)) {
                break label261;
              }
              int i3 = Integer.valueOf(arrayOfString[0]).intValue();
              int i4 = Integer.valueOf(arrayOfString[1]).intValue();
              jdField_a_of_type_AndroidUtilSparseIntArray.put(i3, i4);
              break label261;
            }
          }
        }
        m = true;
        n = b(paramInt);
      }
      catch (Exception localException)
      {
        n = i1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("AIOUtils", 2, "AIOTime getAIOMsgMenuState dpc exception", localException);
        n = i1;
        continue;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("AIOUtils", 2, "AIOTime initAIOMsgMenuState|" + paramInt + "|" + n + "|" + (SystemClock.uptimeMillis() - l1));
        return n;
      }
      return n;
      label261:
      n += 1;
    }
  }
  
  public static int a(long paramLong, ListAdapter paramListAdapter)
  {
    int i1;
    if (paramListAdapter == null)
    {
      i1 = -1;
      return i1;
    }
    int n = 0;
    for (;;)
    {
      if (n >= paramListAdapter.getCount()) {
        break label65;
      }
      Object localObject = paramListAdapter.getItem(n);
      if ((localObject instanceof ChatMessage))
      {
        i1 = n;
        if (((ChatMessage)localObject).uniseq == paramLong) {
          break;
        }
      }
      n += 1;
    }
    label65:
    return -1;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Intent paramIntent)
  {
    if ((paramIntent.getBooleanExtra("open_chatfragment", false)) && ((paramFragmentActivity instanceof SplashActivity)))
    {
      Fragment localFragment = paramFragmentActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if ((localFragment != null) && (localFragment.isVisible()))
      {
        if (a(paramFragmentActivity, paramQQAppInterface, false, paramIntent)) {
          return 2;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 2, "openAIO by MT");
        }
        paramQQAppInterface = (ChatFragment)localFragment;
        paramIntent.putExtra("isBack2Root", true);
        paramFragmentActivity.setIntent(paramIntent);
        paramQQAppInterface.a(3);
        paramQQAppInterface.onPause();
        paramQQAppInterface.onStop();
        paramQQAppInterface.c();
        paramQQAppInterface.onStart();
        paramQQAppInterface.onResume();
        return 1;
      }
    }
    return 0;
  }
  
  public static Intent a(Intent paramIntent, int[] paramArrayOfInt)
  {
    paramIntent.putExtra("open_chatfragment", true);
    paramIntent.addFlags(67108864);
    if (paramArrayOfInt != null)
    {
      int i1 = paramArrayOfInt.length;
      int n = 0;
      if (n < i1)
      {
        switch (paramArrayOfInt[n])
        {
        }
        for (;;)
        {
          n += 1;
          break;
          paramIntent.putExtra("open_chatfragment_withanim", true);
          continue;
          paramIntent.addFlags(268435456);
        }
      }
    }
    return paramIntent;
  }
  
  public static final View a(ListView paramListView, int paramInt)
  {
    if ((paramInt >= paramListView.s()) && (paramInt <= paramListView.t())) {
      return paramListView.getChildAt(paramInt - paramListView.s());
    }
    return null;
  }
  
  @Deprecated
  public static final ChatMessage a(View paramView)
  {
    paramView = (ChatItemBuilder.BaseHolder)a(paramView);
    if (paramView != null) {
      return paramView.a;
    }
    return null;
  }
  
  public static final Object a(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    if ((paramView.getParent() == null) || ((paramView.getParent() instanceof ListView))) {
      return paramView.getTag();
    }
    return a((View)paramView.getParent());
  }
  
  public static StringBuilder a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      if (jdField_a_of_type_JavaLangBoolean.booleanValue())
      {
        jdField_a_of_type_JavaLangReflectField = StringBuilder.class.getSuperclass().getDeclaredField("value");
        jdField_a_of_type_JavaLangReflectField.setAccessible(true);
        jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
      }
      if (jdField_a_of_type_JavaLangReflectField != null) {
        jdField_a_of_type_JavaLangReflectField.set(localStringBuilder, jdField_a_of_type_JavaLangThreadLocal.get());
      }
      return localStringBuilder;
    }
    catch (Exception localException) {}
    return localStringBuilder;
  }
  
  public static final void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, ChatAdapter1 paramChatAdapter1, ChatMessage paramChatMessage)
  {
    int i3 = 0;
    Object localObject;
    boolean bool;
    if (WebAccelerator.l == -1)
    {
      localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.aio_gifplay.name());
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length > 3)
        {
          if ((!localObject[0].equals("1")) || (!localObject[1].equals("1"))) {
            break label133;
          }
          bool = true;
        }
      }
    }
    int n;
    for (;;)
    {
      WebAccelerator.b = bool;
      if (!"0".equals(localObject[3])) {}
      try
      {
        n = Integer.parseInt(localObject[3]);
        if (WebAccelerator.a)
        {
          WebAccelerator.l = n;
          if (WebAccelerator.l == -1) {
            WebAccelerator.l = 0;
          }
          if (WebAccelerator.l > 0) {
            break label153;
          }
          return;
          label133:
          bool = false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          n = 0;
          continue;
          n = 0;
        }
      }
    }
    label153:
    if (paramChatMessage == null)
    {
      paramChatAdapter1 = paramChatAdapter1.a();
      n = i3;
      if (paramChatAdapter1 != null)
      {
        n = i3;
        if (paramChatAdapter1.size() > 0)
        {
          i1 = paramChatAdapter1.size();
          if (WebAccelerator.l <= 1) {
            break label289;
          }
          n = WebAccelerator.l;
          if (i1 <= n) {
            break label296;
          }
          label210:
          if (!(paramBaseChatPie instanceof PublicAccountChatPie)) {
            break label349;
          }
        }
      }
    }
    label226:
    label289:
    label296:
    label303:
    label323:
    label347:
    label349:
    for (int i1 = 1;; i1 = 0)
    {
      int i2 = n - 1;
      n = i3;
      if (i2 > -1)
      {
        paramBaseChatPie = (ChatMessage)paramChatAdapter1.get(i2);
        if (i1 == 0) {
          break label303;
        }
        if (!WebAccelerator.a(paramBaseChatPie)) {
          break label323;
        }
        n = 1;
      }
      for (;;)
      {
        if (n == 0) {
          break label347;
        }
        ((WebProcessManager)paramQQAppInterface.getManager(12)).a(1, new ncg());
        return;
        n = 10;
        break;
        n = i1;
        break label210;
        if ((!paramBaseChatPie.isread) && (WebAccelerator.a(paramBaseChatPie)))
        {
          n = 1;
        }
        else
        {
          i2 -= 1;
          break label226;
          n = i3;
          if (WebAccelerator.a(paramChatMessage)) {
            n = 1;
          }
        }
      }
      break;
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, "AIOTime " + paramString2 + "|" + paramInt1 + "|" + paramInt2);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    i = paramBoolean;
    j = paramBoolean;
    k = paramBoolean;
  }
  
  public static boolean a()
  {
    return Build.MANUFACTURER.equalsIgnoreCase("Samsung");
  }
  
  public static boolean a(Context paramContext)
  {
    return paramContext.getResources().getConfiguration().hardKeyboardHidden == 1;
  }
  
  private static boolean a(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    try
    {
      String str = paramIntent.getStringExtra("uin");
      int n = paramIntent.getIntExtra("uintype", -1);
      if (str == null) {
        return false;
      }
      if (n == -1)
      {
        QQToast.a(paramBaseActivity, paramBaseActivity.getString(2131367504), 0).b(paramBaseActivity.getTitleBarHeight());
        return false;
      }
      if (paramIntent.hasExtra("account"))
      {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "Fast_launch", "Fast_launch_msg", 0, 0, "1", "", "", "");
        if (!((FriendsManager)paramQQAppInterface.getManager(50)).b(str))
        {
          paramIntent.removeExtra("account");
          paramIntent.putExtra("shotcut_forward", ChatActivity.class.getName());
          paramIntent.setClassName(paramBaseActivity, ShortcutRouterActivity.class.getName());
          paramBaseActivity.startActivity(paramIntent);
          return false;
        }
      }
      if ((paramIntent.getBooleanExtra("shortcut", false)) && (!((FriendsManager)paramQQAppInterface.getManager(50)).b(str)))
      {
        QQToast.a(paramBaseActivity.getApplicationContext(), paramBaseActivity.getString(2131367311), 0).b(paramBaseActivity.getTitleBarHeight());
        return false;
      }
      return true;
    }
    catch (RuntimeException paramBaseActivity)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.AIOUtils", 2, "RuntimeException isValidChat beforeEnterAIO.");
      }
    }
    return false;
  }
  
  public static boolean a(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, boolean paramBoolean, Intent paramIntent)
  {
    StartupTracker.a(null, "AIO_doOnCreate_BeforeEnterCost");
    if (!paramQQAppInterface.isLogin())
    {
      paramQQAppInterface = new Intent();
      paramQQAppInterface.setClass(paramBaseActivity, LoginActivity.class);
      paramQQAppInterface.addFlags(262144);
      paramBaseActivity.startActivity(paramQQAppInterface);
      paramBaseActivity.finish();
    }
    do
    {
      do
      {
        do
        {
          return true;
          if (paramBoolean)
          {
            if (a(paramBaseActivity, paramQQAppInterface, paramIntent)) {
              break label212;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.aio.AIOUtils", 2, " isValidChat 1 false");
            }
            paramBaseActivity.finish();
            return true;
          }
          if (!paramBaseActivity.isFinishing()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("Q.aio.AIOUtils", 2, "onNewIntent isFinishing");
        return true;
        if (!ThridAppShareHelper.a().a(paramIntent, paramBaseActivity, paramQQAppInterface)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.aio.AIOUtils", 2, "onNewIntent ThridApp to chatactivity");
      return true;
      Bundle localBundle = paramIntent.getExtras();
      if ((localBundle == null) || (!localBundle.getBoolean("back_from_emojimall", false))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.aio.AIOUtils", 2, "onNewIntent KEY_EMOJIMALL_CLOSE_BACK to chatactivity");
    return true;
    if (!a(paramBaseActivity, paramQQAppInterface, paramIntent))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.AIOUtils", 2, " isValidChat 2 false");
      }
      paramBaseActivity.finish();
      return true;
    }
    label212:
    StartupTracker.a("AIO_doOnCreate_BeforeEnterCost", null);
    return false;
  }
  
  private static int b(int paramInt)
  {
    int i1 = c(paramInt);
    try
    {
      n = jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt, i1);
      if (QLog.isColorLevel()) {
        QLog.d("AIOUtils", 2, "AIOTime getVisibilityFromCache|" + jdField_a_of_type_AndroidUtilSparseIntArray.toString() + "|" + paramInt + "|" + n);
      }
      return n;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int n = i1;
        if (QLog.isColorLevel())
        {
          QLog.e("AIOUtils", 2, "AIOTime getAIOMsgMenuState dpc exception", localException);
          n = i1;
        }
      }
    }
  }
  
  public static boolean b()
  {
    return (a()) && (b(BaseApplicationImpl.getContext())) && (!a(BaseApplicationImpl.getContext()));
  }
  
  public static boolean b(Context paramContext)
  {
    paramContext = paramContext.getPackageManager();
    return (paramContext.hasSystemFeature("com.sec.feature.folder_type")) && (paramContext.hasSystemFeature("com.sec.feature.dual_lcd"));
  }
  
  private static int c(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    default: 
      return 1;
    }
    return 0;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\AIOUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */