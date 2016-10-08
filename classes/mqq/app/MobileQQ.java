package mqq.app;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.utils.MonitorSocketStat;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.util.WeakReference;

public abstract class MobileQQ
  extends BaseApplication
  implements Handler.Callback
{
  public static final String ACTION_MAIN_PROCESS_ALIVE = "com.tencent.mobileqq__alive";
  public static final int BROADCAST_INFO_LIST_SIZE = 5;
  public static final String KEY_UIN = "uin";
  private static final int MSG_ACCOUNT = 1;
  protected static final int MSG_LAST_UIN = 3;
  private static final int MSG_MONITOR = 2;
  public static final String PACKAGE_NAME = "com.tencent.mobileqq";
  private static final String PREF_KEY = "currentAccount";
  private static final String PREF_SHARE = "share";
  private static final String PROPERTY_NAME = "Properties";
  public static final int STATE_EMPTY = 1;
  public static final int STATE_INITING = 2;
  public static final int STATE_READY = 3;
  public static String processName;
  public static String sInjectResult;
  public static MobileQQ sMobileQQ;
  private boolean accountChanged;
  private final List<WeakReference<BaseActivity>> activitys = new ArrayList();
  protected final ArrayList<WeakReference<AppActivity>> appActivities = new ArrayList();
  protected final ArrayList<WeakReference<AppService>> appServices = new ArrayList();
  public Queue<Pair<Long, String>> broadcastInfoQueue = new LinkedList();
  private Runnable doExit = new Runnable()
  {
    public void run()
    {
      if ((MobileQQ.this.activitys.isEmpty()) && (MobileQQ.this.appActivities.isEmpty()) && (MobileQQ.this.otherTypeActivitys.isEmpty()))
      {
        localObject1 = new Intent("mqq.intent.action.EXIT_" + MobileQQ.processName);
        MobileQQ.this.sendBroadcast((Intent)localObject1);
        if (MobileQQ.this.getProcessName().endsWith(":video"))
        {
          MobileQQ.this.mService.msfSub.unbindMsfService();
          MobileQQ.this.mAppRuntime.onDestroy();
        }
        MobileQQ.this.mHandler.postDelayed(new Runnable()
        {
          public void run()
          {
            if (MobileQQ.this.stopMSF)
            {
              MobileQQ.this.mService.msfSub.stopMsfService();
              MobileQQ.killProcess(BaseApplication.getContext(), "com.tencent.mobileqq:MSF");
            }
            if (QLog.isColorLevel())
            {
              QLog.i("mqq", 2, String.format("Application(%s) exit.", new Object[] { MobileQQ.processName }));
              QLog.i("mqq", 2, "===========================================================");
            }
            System.exit(0);
          }
        }, 300L);
        return;
      }
      Object localObject1 = new StringBuffer();
      Iterator localIterator = MobileQQ.this.activitys.iterator();
      Object localObject2;
      while (localIterator.hasNext())
      {
        localObject2 = (BaseActivity)((WeakReference)localIterator.next()).get();
        if (localObject2 != null)
        {
          ((StringBuffer)localObject1).append(localObject2.getClass().getSimpleName());
          ((StringBuffer)localObject1).append(",");
        }
      }
      localIterator = MobileQQ.this.appActivities.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (AppActivity)((WeakReference)localIterator.next()).get();
        if (localObject2 != null)
        {
          ((StringBuffer)localObject1).append(localObject2.getClass().getSimpleName());
          ((StringBuffer)localObject1).append(",");
        }
      }
      localIterator = MobileQQ.this.otherTypeActivitys.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (Activity)((WeakReference)localIterator.next()).get();
        if (localObject2 != null)
        {
          ((StringBuffer)localObject1).append(localObject2.getClass().getSimpleName());
          ((StringBuffer)localObject1).append(",");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("mqq", 2, "do exit ->" + ((StringBuffer)localObject1).toString());
      }
      ((StringBuffer)localObject1).delete(0, ((StringBuffer)localObject1).length());
      MobileQQ.this.mHandler.postDelayed(this, 50L);
    }
  };
  private boolean isCrashed;
  public boolean isPCActive;
  private AppRuntime mAppRuntime;
  final Handler mHandler = new Handler(this);
  private volatile AtomicInteger mRuntimeState = new AtomicInteger(1);
  private MainService mService;
  protected final ArrayList<WeakReference<Activity>> otherTypeActivitys = new ArrayList();
  private final Properties properties = new Properties();
  List<SimpleAccount> sortAccountList = null;
  public String startComponentInfo;
  private boolean stopMSF;
  private boolean stopMsfOnCrash;
  private Handler subHandler;
  
  private void exit(final boolean paramBoolean1, boolean paramBoolean2)
  {
    this.stopMSF = paramBoolean2;
    Object localObject;
    if (getProcessName().endsWith(":video"))
    {
      localObject = this.mService.msfSub;
      if (paramBoolean1) {
        break label126;
      }
    }
    label126:
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      ((MsfServiceSdk)localObject).unRegisterMsfService(Boolean.valueOf(paramBoolean2));
      this.mService.reportMSFCallBackCost(-1L, true);
      closeAllActivitys();
      QLog.d("mqq", 1, "exit isCrashed=" + this.isCrashed + " stopMsfOnCrash=" + this.stopMsfOnCrash);
      localObject = new Runnable()
      {
        public void run()
        {
          try
          {
            if (MobileQQ.this.mAppRuntime == null) {
              MobileQQ.this.waitAppRuntime(null);
            }
            if (!MobileQQ.this.getProcessName().endsWith(":video"))
            {
              MobileQQ.this.mAppRuntime.onDestroy();
              if (!paramBoolean1) {
                MobileQQ.this.mService.msfSub.unRegisterMsfService();
              }
              MobileQQ.this.mService.msfSub.unbindMsfService();
            }
            if (MobileQQ.this.isCrashed)
            {
              Object localObject = new Intent("mqq.intent.action.EXIT_" + MobileQQ.processName);
              MobileQQ.this.sendBroadcast((Intent)localObject);
              localObject = MobileQQ.this.getProcessName();
              if ((((String)localObject).equals("com.tencent.mobileqq")) && (MobileQQ.this.stopMsfOnCrash))
              {
                QLog.d("mqq", 1, "stop and kill msf service");
                MobileQQ.this.mService.msfSub.stopMsfService();
                MobileQQ.killProcess(BaseApplication.getContext(), "com.tencent.mobileqq:MSF");
                System.exit(0);
                return;
              }
              if (((String)localObject).endsWith(":video")) {
                MobileQQ.this.mAppRuntime.onDestroy();
              }
              System.exit(0);
              return;
            }
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel()) {
              QLog.d("mqq", 2, "exit exception=" + localException);
            }
            System.exit(0);
            return;
          }
          MobileQQ.this.doExit.run();
        }
      };
      if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
        break;
      }
      this.mHandler.postAtFrontOfQueue((Runnable)localObject);
      return;
    }
    ((Runnable)localObject).run();
  }
  
  public static MobileQQ getMobileQQ()
  {
    return sMobileQQ;
  }
  
  public static String getShortUinStr(String paramString)
  {
    String str;
    if (paramString == null) {
      str = "";
    }
    do
    {
      return str;
      str = paramString;
    } while (paramString.length() <= 4);
    return paramString.substring(0, 4);
  }
  
  public static boolean killProcess(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null)) {}
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    do
    {
      while (!paramContext.hasNext())
      {
        do
        {
          return false;
          paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
        } while (paramContext == null);
        paramContext = paramContext.iterator();
      }
      localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
    } while (!localRunningAppProcessInfo.processName.equals(paramString));
    Process.killProcess(localRunningAppProcessInfo.pid);
    return true;
  }
  
  private void loadProperites()
  {
    Object localObject7 = null;
    Object localObject8 = null;
    Object localObject1 = null;
    Object localObject6 = null;
    for (;;)
    {
      try
      {
        localFileInputStream = openFileInput("Properties");
        localObject6 = localFileInputStream;
        localObject7 = localFileInputStream;
        localObject8 = localFileInputStream;
        localObject1 = localFileInputStream;
        this.properties.load(localFileInputStream);
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        FileInputStream localFileInputStream;
        Object localObject2 = localObject6;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject2 = localObject6;
        QLog.d("mqq", 2, "can not loadProperites => file not found");
        localObject2 = localObject6;
        localFileNotFoundException.printStackTrace();
        if (localObject6 == null) {
          continue;
        }
        try
        {
          ((InputStream)localObject6).close();
          return;
        }
        catch (IOException localIOException2)
        {
          localIOException2.printStackTrace();
          return;
        }
      }
      catch (IOException localIOException6)
      {
        Object localObject3 = localObject7;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject3 = localObject7;
        QLog.d("mqq", 2, "can not loadProperites => IOException");
        localObject3 = localObject7;
        localIOException6.printStackTrace();
        if (localObject7 == null) {
          continue;
        }
        try
        {
          ((InputStream)localObject7).close();
          return;
        }
        catch (IOException localIOException3)
        {
          localIOException3.printStackTrace();
          return;
        }
      }
      catch (Exception localException)
      {
        Object localObject4 = localObject8;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject4 = localObject8;
        QLog.d("mqq", 2, "can not loadProperites ");
        localObject4 = localObject8;
        localException.printStackTrace();
        if (localObject8 == null) {
          continue;
        }
        try
        {
          ((InputStream)localObject8).close();
          return;
        }
        catch (IOException localIOException4)
        {
          localIOException4.printStackTrace();
          return;
        }
      }
      finally
      {
        if (localIOException4 == null) {
          break label192;
        }
      }
      try
      {
        localFileInputStream.close();
        return;
      }
      catch (IOException localIOException1)
      {
        localIOException1.printStackTrace();
        return;
      }
    }
    try
    {
      localIOException4.close();
      label192:
      throw ((Throwable)localObject5);
    }
    catch (IOException localIOException5)
    {
      for (;;)
      {
        localIOException5.printStackTrace();
      }
    }
  }
  
  public void QQProcessExit(boolean paramBoolean)
  {
    exit(false, paramBoolean);
  }
  
  void addActivity(BaseActivity paramBaseActivity)
  {
    this.activitys.add(0, new WeakReference(paramBaseActivity));
  }
  
  public void addOtherTypeActivity(Activity paramActivity) {}
  
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
    sMobileQQ = this;
  }
  
  public void closeAllActivitys()
  {
    Runnable local2 = new Runnable()
    {
      public void run()
      {
        try
        {
          i = MobileQQ.this.activitys.size();
          QLog.d("mqq", 1, "closeAllActivitys...BaseActivity count: " + i);
          i -= 1;
          if (i < 0) {
            break label163;
          }
          Object localObject1 = (WeakReference)MobileQQ.this.activitys.get(i);
          if (localObject1 == null) {
            break label408;
          }
          localObject1 = (BaseActivity)((WeakReference)localObject1).get();
          label75:
          if (localObject1 == null) {
            MobileQQ.this.activitys.remove(i);
          } else if (!((Activity)localObject1).isFinishing()) {
            ((Activity)localObject1).finish();
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("mqq", 2, "closeAllActivitys: " + localException.getMessage());
          }
        }
        label145:
        return;
        MobileQQ.this.activitys.remove(i);
        break label401;
        label163:
        int i = MobileQQ.this.appActivities.size();
        QLog.d("mqq", 1, "closeAllActivitys...AppActivity count: " + i);
        i -= 1;
        label203:
        if (i >= 0)
        {
          localObject2 = (WeakReference)MobileQQ.this.appActivities.get(i);
          if (localObject2 == null) {
            break label420;
          }
          localObject2 = (AppActivity)((WeakReference)localObject2).get();
          label234:
          if (localObject2 == null) {
            MobileQQ.this.appActivities.remove(i);
          } else if (!((Activity)localObject2).isFinishing()) {
            ((Activity)localObject2).finish();
          } else {
            MobileQQ.this.appActivities.remove(i);
          }
        }
        else
        {
          i = MobileQQ.this.otherTypeActivitys.size();
          QLog.d("mqq", 1, "closeAllActivitys...other Activity count: " + i);
          i -= 1;
          label322:
          if (i < 0) {
            break label430;
          }
          localObject2 = (WeakReference)MobileQQ.this.otherTypeActivitys.get(i);
          if (localObject2 == null) {
            break label432;
          }
        }
        label401:
        label408:
        label420:
        label425:
        label430:
        label432:
        for (Object localObject2 = (Activity)((WeakReference)localObject2).get();; localObject2 = null)
        {
          if (localObject2 == null)
          {
            MobileQQ.this.otherTypeActivitys.remove(i);
          }
          else if (!((Activity)localObject2).isFinishing())
          {
            ((Activity)localObject2).finish();
          }
          else
          {
            MobileQQ.this.otherTypeActivitys.remove(i);
            break label425;
            i -= 1;
            break;
            localObject2 = null;
            break label75;
            i -= 1;
            break label203;
            localObject2 = null;
            break label234;
          }
          i -= 1;
          break label322;
          break label145;
        }
      }
    };
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      this.mHandler.postAtFrontOfQueue(local2);
      return;
    }
    local2.run();
  }
  
  public void crashed()
  {
    this.isCrashed = true;
  }
  
  void createNewRuntime(final SimpleAccount paramSimpleAccount, final boolean paramBoolean1, final boolean paramBoolean2, final int paramInt, final String paramString)
  {
    QLog.d("MobileQQ", 1, "createNewRuntime, " + paramBoolean2 + paramBoolean1 + paramInt + paramString);
    paramSimpleAccount = new Runnable()
    {
      public void run()
      {
        if (MobileQQ.this.mAppRuntime == null) {}
        for (int i = 1;; i = 0)
        {
          localObject1 = MobileQQ.this.createRuntime(MobileQQ.processName);
          if (localObject1 != null) {
            break;
          }
          QLog.i("mqq", 1, MobileQQ.processName + " needn't AppRuntime!");
          return;
        }
        ((AppRuntime)localObject1).init(MobileQQ.this, MobileQQ.this.mService, paramSimpleAccount);
        if (!MobileQQ.this.getProcessName().endsWith(":video")) {
          ((AppRuntime)localObject1).getService().msfSub.registerMsfService();
        }
        long l3;
        long l1;
        long l2;
        if ((paramSimpleAccount != null) && (paramSimpleAccount.isLogined()))
        {
          boolean bool = true;
          if (paramInt != 2) {
            bool = ((AppRuntime)localObject1).canAutoLogin(paramSimpleAccount.getUin());
          }
          if ((paramBoolean1) || (bool)) {
            ((AppRuntime)localObject1).setLogined();
          }
          QLog.d("MobileQQ", 1, "createNewRuntime, canAutoOK: " + bool);
          MobileQQ.access$702(MobileQQ.this, ((AppRuntime)localObject1).isLogin());
          if (!((AppRuntime)localObject1).isLogin()) {
            break label591;
          }
          if (MobileQQ.this.mAppRuntime != null)
          {
            MobileQQ.this.mAppRuntime.logout(Constants.LogoutReason.switchAccount, true);
            MobileQQ.this.mAppRuntime.onDestroy();
          }
          if (paramBoolean2)
          {
            localObject2 = MobileQQ.this.getFirstSimpleAccount();
            l3 = System.currentTimeMillis();
            l1 = l3;
            if (localObject2 != null) {
              l2 = l3;
            }
          }
        }
        try
        {
          long l4 = MobileQQ.this.string2Long(MobileQQ.this.getProperty(((SimpleAccount)localObject2).getUin() + Constants.Key._logintime));
          l1 = l3;
          if (l3 <= l4)
          {
            l3 = l4 + 1L;
            l1 = l3;
            l2 = l3;
            if (QLog.isColorLevel())
            {
              l2 = l3;
              QLog.d("mqq", 2, "CNR account savetime => system time is error..shit");
              l1 = l3;
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            l1 = l2;
          }
        }
        Object localObject2 = ((AppRuntime)localObject1).getAccount();
        if ((localObject2 != null) && (MobileQQ.this.getProcessName().equals(MobileQQ.this.getPackageName())))
        {
          localObject2 = MobileQQ.this.mHandler.obtainMessage(3, localObject2);
          MobileQQ.this.mHandler.sendMessageDelayed((Message)localObject2, 1000L);
        }
        MobileQQ.this.setProperty(((AppRuntime)localObject1).getAccount() + Constants.Key._logintime, String.valueOf(l1));
        ((AppRuntime)localObject1).onCreate(null);
        MobileQQ.access$002(MobileQQ.this, (AppRuntime)localObject1);
        label465:
        Object localObject1 = MobileQQ.this.mHandler.obtainMessage(1);
        if (i != 0) {}
        for (i = 1;; i = 0)
        {
          ((Message)localObject1).arg2 = i;
          ((Message)localObject1).arg1 = paramInt;
          ((Message)localObject1).obj = paramString;
          if (Looper.getMainLooper() != Looper.myLooper()) {
            break label623;
          }
          MobileQQ.this.mHandler.dispatchMessage((Message)localObject1);
          return;
          if (paramSimpleAccount != null)
          {
            QLog.d("MobileQQ", 1, "CNR account != null and account.isLogined =" + paramSimpleAccount.isLogined());
            break;
          }
          QLog.d("MobileQQ", 1, "CNR account == null");
          break;
          label591:
          if (MobileQQ.this.mAppRuntime != null) {
            break label465;
          }
          ((AppRuntime)localObject1).onCreate(null);
          MobileQQ.access$002(MobileQQ.this, (AppRuntime)localObject1);
          break label465;
        }
        label623:
        MobileQQ.this.mHandler.sendMessage((Message)localObject1);
      }
    };
    if (this.mAppRuntime == null)
    {
      paramSimpleAccount.run();
      return;
    }
    this.mHandler.post(paramSimpleAccount);
  }
  
  public abstract AppRuntime createRuntime(String paramString);
  
  void dispatchAccountEvent(Constants.LogoutReason paramLogoutReason, int paramInt, boolean paramBoolean, String paramString)
  {
    int j = this.activitys.size();
    int i;
    label24:
    Object localObject;
    if (paramLogoutReason != null)
    {
      i = 1;
      j -= 1;
      if (j < 0) {
        break label159;
      }
      localObject = (BaseActivity)((WeakReference)this.activitys.get(j)).get();
      if (localObject != null) {
        break label83;
      }
      this.activitys.remove(j);
    }
    for (;;)
    {
      j -= 1;
      break label24;
      i = 0;
      break;
      label83:
      if (i == 0)
      {
        ((BaseActivity)localObject).setAppRuntime(this.mAppRuntime);
        if (this.accountChanged)
        {
          QLog.d("MobileQQ", 1, "dispatchAE  onAccountChanged");
          ((BaseActivity)localObject).onAccountChanged();
        }
        else
        {
          QLog.d("MobileQQ", 1, "dispatchAE  onAccoutChangeFailed");
          ((BaseActivity)localObject).onAccoutChangeFailed();
        }
      }
      else
      {
        QLog.d("MobileQQ", 1, "dispatchAE  onLogou");
        ((BaseActivity)localObject).onLogout(paramLogoutReason);
      }
    }
    label159:
    j = this.appActivities.size() - 1;
    if (j >= 0)
    {
      localObject = (AppActivity)((WeakReference)this.appActivities.get(j)).get();
      if (localObject == null) {
        this.appActivities.remove(j);
      }
      for (;;)
      {
        j -= 1;
        break;
        if (i == 0)
        {
          ((AppActivity)localObject).setAppRuntime(this.mAppRuntime);
          if (this.accountChanged)
          {
            QLog.d("MobileQQ", 1, "dispatchAE  onAccountChanged");
            ((AppActivity)localObject).onAccountChanged();
          }
          else
          {
            QLog.d("MobileQQ", 1, "dispatchAE  onAccoutChangeFailed");
            ((AppActivity)localObject).onAccoutChangeFailed();
          }
        }
        else
        {
          QLog.d("MobileQQ", 1, "dispatchAE  onLogou");
          ((AppActivity)localObject).onLogout(paramLogoutReason);
        }
      }
    }
    j = this.appServices.size() - 1;
    if (j >= 0)
    {
      localObject = (AppService)((WeakReference)this.appServices.get(j)).get();
      if (localObject == null) {
        this.appServices.remove(j);
      }
      for (;;)
      {
        j -= 1;
        break;
        if (i == 0)
        {
          ((AppService)localObject).setAppRuntime(this.mAppRuntime);
          if (this.accountChanged)
          {
            QLog.d("MobileQQ", 1, "dispatchAE S onAccountChanged");
            ((AppService)localObject).onAccountChanged();
          }
          else
          {
            QLog.d("MobileQQ", 1, "dispatchAE S onAccoutChangeFailed");
            ((AppService)localObject).onAccoutChangeFailed();
          }
        }
        else
        {
          QLog.d("MobileQQ", 1, "dispatchAE S onLogou");
          ((AppService)localObject).onLogout(paramLogoutReason);
        }
      }
    }
    Foreground.updateRuntimeState(this.mAppRuntime);
    if (getPackageName().equals(getProcessName()))
    {
      if (i != 0) {
        break label594;
      }
      if (this.accountChanged)
      {
        if (paramBoolean) {
          break label571;
        }
        paramLogoutReason = new Intent("mqq.intent.action.ACCOUNT_CHANGED");
        paramLogoutReason.putExtra("account", this.mAppRuntime.getAccount());
        paramLogoutReason.putExtra("type", paramInt);
        paramLogoutReason.setPackage("com.tencent.mobileqq");
        sendBroadcast(paramLogoutReason);
        paramLogoutReason = new Intent("mqq.intent.action.EXIT_" + getMobileQQ().getPackageName());
        paramLogoutReason.putExtra("K_EXCEP", paramString);
        paramLogoutReason.setPackage("com.tencent.mobileqq");
        sendBroadcast(paramLogoutReason);
      }
    }
    return;
    label571:
    paramLogoutReason = new Intent("com.tencent.mobileqq__alive");
    paramLogoutReason.setPackage("com.tencent.mobileqq");
    sendBroadcast(paramLogoutReason);
    return;
    label594:
    sendBroadcast(new Intent("mqq.intent.action.LOGOUT"));
  }
  
  /* Error */
  public final void doInit(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 126	mqq/app/MobileQQ:mRuntimeState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   4: iconst_1
    //   5: iconst_2
    //   6: invokevirtual 512	java/util/concurrent/atomic/AtomicInteger:compareAndSet	(II)Z
    //   9: ifne +4 -> 13
    //   12: return
    //   13: aload_0
    //   14: getstatic 513	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   17: invokevirtual 516	mqq/app/MobileQQ:isNeedMSF	(Ljava/lang/String;)Z
    //   20: istore 6
    //   22: ldc -42
    //   24: iconst_1
    //   25: new 216	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   32: ldc_w 518
    //   35: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: getstatic 513	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   41: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: getstatic 513	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   53: ldc_w 520
    //   56: invokevirtual 185	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   59: ifne +238 -> 297
    //   62: iload 6
    //   64: ifeq +233 -> 297
    //   67: aload_0
    //   68: invokespecial 522	mqq/app/MobileQQ:loadProperites	()V
    //   71: aload_0
    //   72: new 187	mqq/app/MainService
    //   75: dup
    //   76: aload_0
    //   77: aload_0
    //   78: getstatic 513	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   81: invokevirtual 526	mqq/app/MobileQQ:getAppId	(Ljava/lang/String;)I
    //   84: aload_0
    //   85: getstatic 513	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   88: invokevirtual 529	mqq/app/MobileQQ:getBootBroadcastName	(Ljava/lang/String;)Ljava/lang/String;
    //   91: iload_1
    //   92: invokespecial 532	mqq/app/MainService:<init>	(Lmqq/app/MobileQQ;ILjava/lang/String;Z)V
    //   95: putfield 151	mqq/app/MobileQQ:mService	Lmqq/app/MainService;
    //   98: aload_0
    //   99: invokevirtual 177	mqq/app/MobileQQ:getProcessName	()Ljava/lang/String;
    //   102: ldc -77
    //   104: invokevirtual 185	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   107: ifne +13 -> 120
    //   110: aload_0
    //   111: getfield 151	mqq/app/MobileQQ:mService	Lmqq/app/MainService;
    //   114: getfield 191	mqq/app/MainService:msfSub	Lcom/tencent/mobileqq/msf/sdk/MsfServiceSdk;
    //   117: invokevirtual 535	com/tencent/mobileqq/msf/sdk/MsfServiceSdk:initMsfService	()V
    //   120: aload_0
    //   121: invokevirtual 538	mqq/app/MobileQQ:getAllAccounts	()Ljava/util/List;
    //   124: astore_2
    //   125: aload_2
    //   126: ifnull +250 -> 376
    //   129: aload_2
    //   130: iconst_0
    //   131: invokeinterface 410 2 0
    //   136: checkcast 540	com/tencent/qphone/base/remote/SimpleAccount
    //   139: astore_2
    //   140: aload_2
    //   141: astore_3
    //   142: aload_2
    //   143: ifnonnull +130 -> 273
    //   146: ldc -42
    //   148: iconst_1
    //   149: ldc_w 542
    //   152: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   155: aload_0
    //   156: ldc 49
    //   158: iconst_0
    //   159: invokevirtual 546	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   162: astore 5
    //   164: aload_2
    //   165: astore_3
    //   166: aload 5
    //   168: ifnull +105 -> 273
    //   171: aload 5
    //   173: ldc 46
    //   175: aconst_null
    //   176: invokeinterface 552 3 0
    //   181: astore 4
    //   183: invokestatic 353	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   186: ifeq +30 -> 216
    //   189: ldc -42
    //   191: iconst_1
    //   192: new 216	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   199: ldc_w 554
    //   202: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload 4
    //   207: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   216: aload_2
    //   217: astore_3
    //   218: aload 4
    //   220: ifnull +53 -> 273
    //   223: aload 5
    //   225: invokeinterface 558 1 0
    //   230: ldc 46
    //   232: invokeinterface 563 2 0
    //   237: invokeinterface 566 1 0
    //   242: pop
    //   243: new 540	com/tencent/qphone/base/remote/SimpleAccount
    //   246: dup
    //   247: invokespecial 567	com/tencent/qphone/base/remote/SimpleAccount:<init>	()V
    //   250: astore_3
    //   251: aload_3
    //   252: aload 4
    //   254: invokevirtual 570	com/tencent/qphone/base/remote/SimpleAccount:setUin	(Ljava/lang/String;)V
    //   257: aload_3
    //   258: invokevirtual 573	com/tencent/qphone/base/remote/SimpleAccount:isLogined	()Z
    //   261: pop
    //   262: aload_3
    //   263: ldc_w 575
    //   266: iconst_1
    //   267: invokestatic 578	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   270: invokevirtual 582	com/tencent/qphone/base/remote/SimpleAccount:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   273: iconst_0
    //   274: istore_1
    //   275: getstatic 513	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   278: ldc 43
    //   280: invokevirtual 320	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   283: ifeq +5 -> 288
    //   286: iconst_1
    //   287: istore_1
    //   288: aload_0
    //   289: aload_3
    //   290: iconst_0
    //   291: iload_1
    //   292: iconst_5
    //   293: aconst_null
    //   294: invokevirtual 584	mqq/app/MobileQQ:createNewRuntime	(Lcom/tencent/qphone/base/remote/SimpleAccount;ZZILjava/lang/String;)V
    //   297: aload_0
    //   298: new 468	android/content/Intent
    //   301: dup
    //   302: new 216	java/lang/StringBuilder
    //   305: dup
    //   306: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   309: ldc_w 586
    //   312: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: getstatic 513	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   318: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: invokespecial 473	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   327: invokevirtual 497	mqq/app/MobileQQ:sendBroadcast	(Landroid/content/Intent;)V
    //   330: aload_0
    //   331: getfield 126	mqq/app/MobileQQ:mRuntimeState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   334: astore_2
    //   335: aload_2
    //   336: monitorenter
    //   337: aload_0
    //   338: getfield 126	mqq/app/MobileQQ:mRuntimeState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   341: iconst_3
    //   342: invokevirtual 589	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   345: aload_0
    //   346: getfield 126	mqq/app/MobileQQ:mRuntimeState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   349: invokevirtual 594	java/lang/Object:notifyAll	()V
    //   352: aload_2
    //   353: monitorexit
    //   354: ldc -42
    //   356: iconst_1
    //   357: ldc_w 596
    //   360: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   363: aload_0
    //   364: getfield 133	mqq/app/MobileQQ:mHandler	Landroid/os/Handler;
    //   367: iconst_2
    //   368: ldc2_w 597
    //   371: invokevirtual 602	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   374: pop
    //   375: return
    //   376: aconst_null
    //   377: astore_2
    //   378: goto -238 -> 140
    //   381: astore_3
    //   382: aload_2
    //   383: monitorexit
    //   384: aload_3
    //   385: athrow
    //   386: astore_2
    //   387: ldc -42
    //   389: iconst_1
    //   390: ldc_w 604
    //   393: aload_2
    //   394: invokestatic 608	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   397: new 610	java/lang/RuntimeException
    //   400: dup
    //   401: aload_2
    //   402: invokespecial 613	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   405: athrow
    //   406: astore_3
    //   407: aload_0
    //   408: getfield 126	mqq/app/MobileQQ:mRuntimeState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   411: astore_2
    //   412: aload_2
    //   413: monitorenter
    //   414: aload_0
    //   415: getfield 126	mqq/app/MobileQQ:mRuntimeState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   418: iconst_3
    //   419: invokevirtual 589	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   422: aload_0
    //   423: getfield 126	mqq/app/MobileQQ:mRuntimeState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   426: invokevirtual 594	java/lang/Object:notifyAll	()V
    //   429: aload_2
    //   430: monitorexit
    //   431: ldc -42
    //   433: iconst_1
    //   434: ldc_w 596
    //   437: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   440: aload_0
    //   441: getfield 133	mqq/app/MobileQQ:mHandler	Landroid/os/Handler;
    //   444: iconst_2
    //   445: ldc2_w 597
    //   448: invokevirtual 602	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   451: pop
    //   452: aload_3
    //   453: athrow
    //   454: astore_3
    //   455: aload_2
    //   456: monitorexit
    //   457: aload_3
    //   458: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	459	0	this	MobileQQ
    //   0	459	1	paramBoolean	boolean
    //   386	16	2	localThrowable	Throwable
    //   141	149	3	localObject2	Object
    //   381	4	3	localObject3	Object
    //   406	47	3	localObject4	Object
    //   454	4	3	localObject5	Object
    //   181	72	4	str	String
    //   162	62	5	localSharedPreferences	SharedPreferences
    //   20	43	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   337	354	381	finally
    //   382	384	381	finally
    //   13	62	386	java/lang/Throwable
    //   67	120	386	java/lang/Throwable
    //   120	125	386	java/lang/Throwable
    //   129	140	386	java/lang/Throwable
    //   146	164	386	java/lang/Throwable
    //   171	216	386	java/lang/Throwable
    //   223	273	386	java/lang/Throwable
    //   275	286	386	java/lang/Throwable
    //   288	297	386	java/lang/Throwable
    //   297	330	386	java/lang/Throwable
    //   13	62	406	finally
    //   67	120	406	finally
    //   120	125	406	finally
    //   129	140	406	finally
    //   146	164	406	finally
    //   171	216	406	finally
    //   223	273	406	finally
    //   275	286	406	finally
    //   288	297	406	finally
    //   297	330	406	finally
    //   387	406	406	finally
    //   414	431	454	finally
    //   455	457	454	finally
  }
  
  public List<SimpleAccount> getAllAccounts()
  {
    if (this.sortAccountList == null)
    {
      ArrayList localArrayList = MsfSdkUtils.getLoginedAccountList();
      if ((localArrayList != null) && (!localArrayList.isEmpty())) {
        this.sortAccountList = localArrayList;
      }
    }
    if ((this.sortAccountList != null) && (this.sortAccountList.size() > 0))
    {
      Collections.sort(this.sortAccountList, new Comparator()
      {
        public int compare(SimpleAccount paramAnonymousSimpleAccount1, SimpleAccount paramAnonymousSimpleAccount2)
        {
          long l1 = MobileQQ.this.string2Long(MobileQQ.this.getProperty(paramAnonymousSimpleAccount1.getUin() + Constants.Key._logintime));
          long l2 = MobileQQ.this.string2Long(MobileQQ.this.getProperty(paramAnonymousSimpleAccount2.getUin() + Constants.Key._logintime));
          if (paramAnonymousSimpleAccount1 != null) {
            QLog.d("mqq", 1, "a1.getUin() = " + MsfSdkUtils.getShortUin(paramAnonymousSimpleAccount1.getUin()) + ";key.time = " + l1 + ", isLogined=" + paramAnonymousSimpleAccount1.isLogined());
          }
          if (paramAnonymousSimpleAccount2 != null) {
            QLog.d("mqq", 1, "a2.getUin() = " + MsfSdkUtils.getShortUin(paramAnonymousSimpleAccount2.getUin()) + ";key.time = " + l2 + ", isLogined=" + paramAnonymousSimpleAccount2.isLogined());
          }
          if (l2 > l1) {
            return 1;
          }
          return -1;
        }
      });
      return Collections.unmodifiableList(this.sortAccountList);
    }
    if (QLog.isColorLevel()) {
      QLog.w("mqq", 2, "Account list is NULL!");
    }
    return null;
  }
  
  public List<SimpleAccount> getAllNotSynAccountList()
  {
    return this.sortAccountList;
  }
  
  public abstract int getAppId(String paramString);
  
  public AppRuntime getAppRuntime(String paramString)
    throws AccountNotMatchException
  {
    AppRuntime localAppRuntime = waitAppRuntime(null);
    if ((paramString != null) && (paramString.equals(localAppRuntime.getAccount()))) {}
    while (paramString == localAppRuntime.getAccount()) {
      return localAppRuntime;
    }
    throw new AccountNotMatchException(localAppRuntime.getAccount(), paramString);
  }
  
  public abstract String getBootBroadcastName(String paramString);
  
  public SimpleAccount getFirstSimpleAccount()
  {
    List localList = getAllAccounts();
    if ((localList == null) || (localList.size() == 0)) {
      return null;
    }
    return (SimpleAccount)localList.get(0);
  }
  
  public String getProcessName()
  {
    if (processName == null)
    {
      int i = 0;
      String str2;
      do
      {
        str2 = MsfSdkUtils.getProcessName(this);
        i += 1;
      } while ((i < 3) && ("unknown".equals(str2)));
      String str1 = str2;
      if ("unknown".equals(str2)) {
        str1 = "com.tencent.mobileqq";
      }
      processName = str1;
    }
    return processName;
  }
  
  public String getProperty(String paramString)
  {
    return this.properties.getProperty(paramString);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    SharedPreferences localSharedPreferences;
    do
    {
      return true;
      int i = paramMessage.arg1;
      if (paramMessage.arg2 == 1) {}
      for (boolean bool = true;; bool = false)
      {
        dispatchAccountEvent(null, i, bool, (String)paramMessage.obj);
        return true;
      }
      monitor.setProcessName(processName);
      try
      {
        monitor.start();
        return true;
      }
      catch (Throwable paramMessage)
      {
        QLog.d("mqq", 1, "", paramMessage);
        return true;
      }
      paramMessage = (String)paramMessage.obj;
      localSharedPreferences = getSharedPreferences("Last_Login", 4);
    } while (localSharedPreferences.getString("uin", "").equals(paramMessage));
    localSharedPreferences.edit().putString("uin", paramMessage).commit();
    return true;
  }
  
  public abstract boolean isNeedMSF(String paramString);
  
  public boolean isRuntimeReady()
  {
    return this.mRuntimeState.get() == 3;
  }
  
  public boolean onActivityCreate(Object paramObject, Intent paramIntent)
  {
    return false;
  }
  
  public void onActivityFocusChanged(AppActivity paramAppActivity, boolean paramBoolean) {}
  
  public void onCreate()
  {
    sMobileQQ = this;
    super.onCreate();
  }
  
  public void otherProcessExit(boolean paramBoolean)
  {
    exit(paramBoolean, false);
  }
  
  public List<SimpleAccount> refreAccountList()
  {
    ArrayList localArrayList = MsfSdkUtils.getLoginedAccountList();
    if ((localArrayList != null) && (!localArrayList.isEmpty())) {
      this.sortAccountList = localArrayList;
    }
    if ((this.sortAccountList != null) && (this.sortAccountList.size() > 0))
    {
      Collections.sort(this.sortAccountList, new Comparator()
      {
        public int compare(SimpleAccount paramAnonymousSimpleAccount1, SimpleAccount paramAnonymousSimpleAccount2)
        {
          long l = MobileQQ.this.string2Long(MobileQQ.this.getProperty(paramAnonymousSimpleAccount1.getUin() + Constants.Key._logintime));
          if (MobileQQ.this.string2Long(MobileQQ.this.getProperty(paramAnonymousSimpleAccount2.getUin() + Constants.Key._logintime)) > l) {
            return 1;
          }
          return -1;
        }
      });
      return Collections.unmodifiableList(this.sortAccountList);
    }
    if (QLog.isColorLevel()) {
      QLog.d("mqq", 2, "refreAccountList Account list is NULL!");
    }
    return this.sortAccountList;
  }
  
  void removeActivity(BaseActivity paramBaseActivity)
  {
    this.activitys.remove(new WeakReference(paramBaseActivity));
  }
  
  public void removeOtherTypeActivity(Activity paramActivity) {}
  
  public void reportPCActive(String paramString, int paramInt) {}
  
  public void setAutoLogin(boolean paramBoolean)
  {
    if ((this.mAppRuntime != null) && (this.mAppRuntime.getAccount() != null) && (this.mAppRuntime.getAccount().length() > 0)) {
      this.mAppRuntime.setAutoLogin(paramBoolean);
    }
  }
  
  public void setProperty(String arg1, String paramString2)
  {
    this.properties.setProperty(???, paramString2);
    if (this.subHandler == null) {}
    synchronized (this.properties)
    {
      if (this.subHandler == null)
      {
        paramString2 = new HandlerThread("property-saver");
        paramString2.start();
        this.subHandler = new Handler(paramString2.getLooper());
      }
      this.subHandler.post(new Runnable()
      {
        public void run()
        {
          Object localObject3 = null;
          Object localObject1 = null;
          for (;;)
          {
            try
            {
              localFileOutputStream = MobileQQ.this.openFileOutput("Properties", 0);
              localObject1 = localFileOutputStream;
              localObject3 = localFileOutputStream;
              MobileQQ.this.properties.store(localFileOutputStream, null);
              localObject1 = localFileOutputStream;
              localObject3 = localFileOutputStream;
              localFileOutputStream.flush();
            }
            catch (Exception localException)
            {
              FileOutputStream localFileOutputStream;
              localObject3 = localIOException1;
              localException.printStackTrace();
              if (localIOException1 == null) {
                continue;
              }
              try
              {
                localIOException1.close();
                return;
              }
              catch (IOException localIOException2)
              {
                localIOException2.printStackTrace();
                return;
              }
            }
            finally
            {
              if (localObject3 == null) {
                break label85;
              }
            }
            try
            {
              localFileOutputStream.close();
              return;
            }
            catch (IOException localIOException1)
            {
              localIOException1.printStackTrace();
              return;
            }
          }
          try
          {
            ((OutputStream)localObject3).close();
            label85:
            throw ((Throwable)localObject2);
          }
          catch (IOException localIOException3)
          {
            for (;;)
            {
              localIOException3.printStackTrace();
            }
          }
        }
      });
      return;
    }
  }
  
  public void setSortAccountList(List<SimpleAccount> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Collections.sort(paramList, new Comparator()
      {
        public int compare(SimpleAccount paramAnonymousSimpleAccount1, SimpleAccount paramAnonymousSimpleAccount2)
        {
          long l = MobileQQ.this.string2Long(MobileQQ.this.getProperty(paramAnonymousSimpleAccount1.getUin() + Constants.Key._logintime));
          if (MobileQQ.this.string2Long(MobileQQ.this.getProperty(paramAnonymousSimpleAccount2.getUin() + Constants.Key._logintime)) > l) {
            return 1;
          }
          return -1;
        }
      });
      this.sortAccountList = paramList;
    }
    if (QLog.isColorLevel()) {
      QLog.d("mqq", 2, "sort AccountList" + this.sortAccountList);
    }
  }
  
  public void startActivity(Intent paramIntent)
  {
    paramIntent.putExtra("preAct", getClass().getSimpleName());
    paramIntent.putExtra("preAct_time", System.currentTimeMillis());
    super.startActivity(paramIntent);
  }
  
  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    paramIntent.putExtra("preAct", getClass().getSimpleName());
    paramIntent.putExtra("preAct_time", System.currentTimeMillis());
    super.startActivity(paramIntent, paramBundle);
  }
  
  public void startService()
  {
    if (this.mService != null) {
      this.mService.start();
    }
  }
  
  public void stopMsfOnCrash(boolean paramBoolean)
  {
    this.stopMsfOnCrash = paramBoolean;
    if (this.stopMsfOnCrash) {
      QLog.d("mqq", 1, "stop and kill msf stopMsfOnCrash=" + this.stopMsfOnCrash);
    }
    try
    {
      this.mService.msfSub.unRegisterMsfService();
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        for (;;)
        {
          this.mService.msfSub.unbindMsfService();
          this.mService.msfSub.stopMsfService();
          try
          {
            killProcess(getContext(), "com.tencent.mobileqq:MSF");
            return;
          }
          catch (Throwable localThrowable3)
          {
            localThrowable3.printStackTrace();
          }
          localThrowable1 = localThrowable1;
          localThrowable1.printStackTrace();
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          localThrowable2.printStackTrace();
        }
      }
    }
  }
  
  public long string2Long(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.w("mqq", 2, "string2Long number is empty");
      }
      return 0L;
    }
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.w("mqq", 2, "string2Long catch exception");
      }
      paramString.printStackTrace();
    }
    return 0L;
  }
  
  public AppRuntime waitAppRuntime(BaseActivity arg1)
  {
    int i = this.mRuntimeState.get();
    if (i != 3) {
      if (i == 1)
      {
        QLog.e("mqq", 1, "waitInit when empty: ", new RuntimeException(""));
        doInit(true);
      }
    }
    synchronized (this.mRuntimeState)
    {
      i = this.mRuntimeState.get();
      if (i == 2) {}
      try
      {
        this.mRuntimeState.wait();
        return this.mAppRuntime;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
          QLog.e("mqq", 1, "waitInit failed", localInterruptedException);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\mqq\app\MobileQQ.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */