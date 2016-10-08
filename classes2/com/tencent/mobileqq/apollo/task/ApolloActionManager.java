package com.tencent.mobileqq.apollo.task;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Message;
import android.os.Vibrator;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloRenderDriver;
import com.tencent.mobileqq.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.IRenderCallback;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ChatApolloViewListener;
import com.tencent.mobileqq.app.CheckPttListener;
import com.tencent.mobileqq.app.CheckPtvListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import psd;
import pse;
import psf;
import psg;
import psh;
import psi;
import psj;

public class ApolloActionManager
  implements IRenderCallback, ITaskStatusChangedCallback
{
  public static final int a = 3;
  private static ApolloActionManager jdField_a_of_type_ComTencentMobileqqApolloTaskApolloActionManager;
  public static final String a = "ApolloActionManager";
  public static boolean a;
  public float a;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  public SharedPreferences a;
  public MediaPlayer a;
  public Vibrator a;
  public ApolloSurfaceView a;
  public ApolloTaskExecutor a;
  private ApolloDaoManager jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloDaoManager;
  public ChatApolloViewListener a;
  public QQAppInterface a;
  public Vector a;
  public AtomicBoolean a;
  public AtomicInteger a;
  private ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
  public psj a;
  public int[] a;
  public float b;
  public int b;
  public String b;
  private AtomicBoolean b;
  public boolean b;
  public float c;
  public int c;
  public String c;
  public boolean c;
  public float d;
  public int d;
  public String d;
  public boolean d;
  public float e;
  public int e;
  public String e;
  public boolean e;
  public float f;
  public int f;
  public String f;
  public String g;
  public String h;
  
  private ApolloActionManager()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_c_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = "-1";
    this.jdField_c_of_type_JavaLangString = "-1";
    this.jdField_a_of_type_Psj = new psj();
    this.jdField_e_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilVector = new Vector();
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new psd(this);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionManager", 2, "[ApolloActionManager] constructor.");
    }
    long l1 = DeviceInfoUtil.h();
    long l2 = DeviceInfoUtil.i();
    long l3;
    if (l1 > l2)
    {
      l3 = l2;
      l2 = l1;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
      if ((this.jdField_a_of_type_AndroidContentSharedPreferences != null) && (BaseApplicationImpl.a != null) && (BaseApplicationImpl.a.a() != null))
      {
        String str = BaseApplicationImpl.a.a().getAccount();
        if (!TextUtils.isEmpty(str))
        {
          this.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("is_apollo_hide" + str, false);
          jdField_a_of_type_Boolean = true;
        }
      }
      this.jdField_a_of_type_Float = ((float)l2 / 7.0F / 368.0F);
      this.jdField_f_of_type_Float = ((float)l2 / 7.0F);
      float f1 = (float)l3 / DeviceInfoUtil.jdField_a_of_type_Float;
      float f2 = this.jdField_a_of_type_Float * 330.0F / DeviceInfoUtil.jdField_a_of_type_Float;
      this.jdField_b_of_type_Float = ((f1 - f2) / 2.0F);
      this.jdField_c_of_type_Float = (f2 + this.jdField_b_of_type_Float);
      this.jdField_d_of_type_Float = (f1 / 2.0F);
      this.jdField_e_of_type_Float = ((float)l2 / 7.0F / 2.24F);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionManager", 2, "density:" + DeviceInfoUtil.jdField_a_of_type_Float + ",sWidth:" + l3 + ",sHeight:" + l2 + ",mScale:" + this.jdField_a_of_type_Float + ",mLeftManXPos:" + this.jdField_b_of_type_Float + ",mRightManXPos:" + this.jdField_c_of_type_Float + ",mCenterManXPos:" + this.jdField_d_of_type_Float);
      }
      this.jdField_a_of_type_AndroidOsVibrator = ((Vibrator)BaseApplicationImpl.getContext().getSystemService("vibrator"));
      return;
      l3 = l1;
    }
  }
  
  public static ApolloActionManager a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqApolloTaskApolloActionManager == null) {
        jdField_a_of_type_ComTencentMobileqqApolloTaskApolloActionManager = new ApolloActionManager();
      }
      ApolloActionManager localApolloActionManager = jdField_a_of_type_ComTencentMobileqqApolloTaskApolloActionManager;
      return localApolloActionManager;
    }
    finally {}
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionManager", 2, "[getTroopOwenrUin], troopUin:" + paramString);
    }
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      paramQQAppInterface = "";
    }
    Object localObject;
    do
    {
      return paramQQAppInterface;
      localObject = ((TroopManager)paramQQAppInterface.getManager(51)).a(paramString);
      paramString = "";
      if (localObject != null) {
        paramString = ((TroopInfo)localObject).troopowneruin;
      }
      localObject = paramString;
      if (TextUtils.isEmpty(paramString)) {
        localObject = paramQQAppInterface.a();
      }
      paramQQAppInterface = (QQAppInterface)localObject;
    } while (!QLog.isColorLevel());
    QLog.d("ApolloActionManager", 2, "troopOwnerUin:" + (String)localObject);
    return (String)localObject;
  }
  
  private void b(int paramInt)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionManager", 2, "[showAudioClosedTip], sessionType:" + paramInt);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    if (1 == this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d()) {
      if ((paramInt == 1) || (paramInt == 3000))
      {
        bool1 = bool2;
        if (1 == this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b()) {}
      }
      else
      {
        if (paramInt != 0) {
          break label281;
        }
      }
    }
    label281:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionManager", 2, "isAudioSwitchOpen:" + bool1);
      }
      if (bool1) {
        break;
      }
      if (this.jdField_a_of_type_AndroidContentSharedPreferences != null)
      {
        paramInt = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("msg_notice_closed_tip_times" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloActionManager", 2, "totalTimes:" + paramInt);
        }
        if (3 == paramInt) {
          break;
        }
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("msg_notice_closed_tip_times" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramInt + 1).commit();
      }
      MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatActivity.class);
      if (localMqqHandler == null) {
        break;
      }
      localMqqHandler.post(new psh(this));
      return;
    }
  }
  
  private void b(ApolloTaskParam paramApolloTaskParam)
  {
    if ((paramApolloTaskParam == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskExecutor == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionManager", 2, "[addTask], param:" + paramApolloTaskParam + ",mTaskManager:" + this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskExecutor);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionManager", 2, "param info:" + paramApolloTaskParam.toString() + ",threadId:" + Thread.currentThread().getId() + ",surfaceView:" + this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView);
    }
    if (paramApolloTaskParam.f == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionManager", 2, " taskId = -1, build one for it.");
      }
      paramApolloTaskParam.f = this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskExecutor.a();
    }
    ApolloActionTask localApolloActionTask = new ApolloActionTask(paramApolloTaskParam);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) {
      localApolloActionTask.a.jdField_a_of_type_ComTencentMobileqqApolloIRenderCommInterface = this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskExecutor.a(paramApolloTaskParam.f, localApolloActionTask);
  }
  
  private void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionManager", 2, "[doActionDirectly]");
    }
    if (a(false) != 0) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskExecutor != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskExecutor.c();
      }
    } while ((this.jdField_a_of_type_AndroidContentSharedPreferences == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("is_click_me_bubble_on" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false)));
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("is_click_me_bubble_on" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), true).commit();
  }
  
  public int a()
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionManager", 2, "[getRoleNum], mIsHide:" + this.jdField_b_of_type_Boolean + ",mFuncSwitch:" + this.jdField_e_of_type_Int);
    }
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_e_of_type_Int != 1)) {
      i = -1;
    }
    while (this.jdField_c_of_type_Int == 0) {
      return i;
    }
    return this.jdField_b_of_type_Int;
  }
  
  public int a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionManager", 2, "[showAndDoAction], isHidden:" + paramBoolean + ",actionID:" + paramInt + ",mFuncSwitch:" + this.jdField_e_of_type_Int);
    }
    if ((a(paramBoolean) != 0) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView == null)) {}
    ApolloRenderInterfaceImpl localApolloRenderInterfaceImpl;
    do
    {
      return -1;
      localApolloRenderInterfaceImpl = this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a();
    } while (localApolloRenderInterfaceImpl == null);
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      localApolloRenderInterfaceImpl.f();
      continue;
      localApolloRenderInterfaceImpl.h();
      continue;
      localApolloRenderInterfaceImpl.e();
    }
  }
  
  public int a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionManager", 2, "[loadRoleIfNeeded], isHidden:" + paramBoolean + ",mFuncSwitch:" + this.jdField_e_of_type_Int);
    }
    boolean bool = c();
    if ((1 != this.jdField_e_of_type_Int) || (bool)) {}
    do
    {
      MqqHandler localMqqHandler;
      do
      {
        do
        {
          return -1;
          if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) && (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloActionManager", 2, "surfaceview is null, create it.");
          }
        } while ((this.jdField_a_of_type_ComTencentMobileqqApolloViewChatApolloViewListener == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloViewChatApolloViewListener.a == null));
        localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatActivity.class);
      } while (localMqqHandler == null);
      localMqqHandler.post(new psg(this));
      return -1;
      if (a(true, paramBoolean) != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloActionManager", 2, "errInfo:roleId is null.");
    return -1;
    return 0;
  }
  
  public ApolloActionManager a(ApolloSurfaceView paramApolloSurfaceView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionManager", 2, "[registerSurfaceView] mSurfaceView:" + this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView);
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView = paramApolloSurfaceView;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a().a(this);
    }
    return this;
  }
  
  public ApolloActionManager a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionManager", 2, "[setAppInterface] app:" + paramQQAppInterface);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloDaoManager = ((ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154));
      if ((!jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidContentSharedPreferences != null))
      {
        this.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("is_apollo_hide" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false);
        jdField_a_of_type_Boolean = true;
      }
      ThreadManager.a(new psf(this, paramQQAppInterface), 5, null, true);
    }
    return this;
  }
  
  public ApolloActionTask a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskExecutor == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskExecutor.a;
  }
  
  public ApolloTaskParam a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionManager", 2, "[stopAllTask]");
    }
    ApolloActionTask localApolloActionTask = a();
    if ((localApolloActionTask == null) || (localApolloActionTask.a == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionManager", 2, "not running task, return.");
      }
      return null;
    }
    localApolloActionTask.a.jdField_d_of_type_Int = 3;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskExecutor != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskExecutor.a();
    }
    a(localApolloActionTask.a.f, 4, "me");
    if (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskExecutor != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskExecutor.a = null;
    }
    return localApolloActionTask.a;
  }
  
  public ReentrantLock a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionManager", 2, "[getLock].");
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloActionManager", 2, "create lock.");
        }
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
      }
      ReentrantLock localReentrantLock = this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
      return localReentrantLock;
    }
    finally {}
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionManager", 2, "[unregisterSurfaceView]");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a().a(null);
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionManager", 2, "[onTaskStatusChanged], status:" + paramInt);
    }
    switch (paramInt)
    {
    default: 
    case 1: 
      do
      {
        return;
        this.jdField_c_of_type_Boolean = false;
      } while (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView == null);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.b();
      return;
    }
    this.jdField_c_of_type_Boolean = true;
  }
  
  /* Error */
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    // Byte code:
    //   0: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +49 -> 52
    //   6: ldc 15
    //   8: iconst_2
    //   9: new 148	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 485
    //   19: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: iload_2
    //   23: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   26: ldc_w 487
    //   29: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_3
    //   33: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc_w 489
    //   39: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: iload_1
    //   43: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   46: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: aload_0
    //   53: getfield 333	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView	Lcom/tencent/mobileqq/apollo/ApolloSurfaceView;
    //   56: ifnull +20 -> 76
    //   59: aload_0
    //   60: getfield 55	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   63: invokevirtual 396	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   66: ifeq +10 -> 76
    //   69: aload_0
    //   70: getfield 306	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskExecutor	Lcom/tencent/mobileqq/apollo/task/ApolloTaskExecutor;
    //   73: ifnonnull +52 -> 125
    //   76: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   79: ifeq +45 -> 124
    //   82: ldc 15
    //   84: iconst_2
    //   85: new 148	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   92: ldc_w 491
    //   95: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload_0
    //   99: getfield 333	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView	Lcom/tencent/mobileqq/apollo/ApolloSurfaceView;
    //   102: invokevirtual 311	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   105: ldc_w 493
    //   108: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_0
    //   112: getfield 55	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   115: invokevirtual 311	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   124: return
    //   125: iload_1
    //   126: ldc_w 494
    //   129: if_icmple +29 -> 158
    //   132: ldc_w 458
    //   135: aload_3
    //   136: invokevirtual 500	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   139: ifeq -15 -> 124
    //   142: aload_0
    //   143: getfield 333	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView	Lcom/tencent/mobileqq/apollo/ApolloSurfaceView;
    //   146: invokevirtual 503	com/tencent/mobileqq/apollo/ApolloSurfaceView:a	()Lcom/tencent/mobileqq/apollo/ApolloRenderDriver;
    //   149: iload_2
    //   150: iload_1
    //   151: invokestatic 509	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   154: invokevirtual 514	com/tencent/mobileqq/apollo/ApolloRenderDriver:a	(ILjava/lang/Object;)V
    //   157: return
    //   158: aload_0
    //   159: getfield 306	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskExecutor	Lcom/tencent/mobileqq/apollo/task/ApolloTaskExecutor;
    //   162: getfield 445	com/tencent/mobileqq/apollo/task/ApolloTaskExecutor:a	Lcom/tencent/mobileqq/apollo/task/ApolloActionTask;
    //   165: astore_3
    //   166: aload_3
    //   167: ifnull +17 -> 184
    //   170: aload_3
    //   171: getfield 348	com/tencent/mobileqq/apollo/task/ApolloActionTask:a	Lcom/tencent/mobileqq/apollo/task/ApolloTaskParam;
    //   174: ifnull +10 -> 184
    //   177: aload_0
    //   178: getfield 333	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView	Lcom/tencent/mobileqq/apollo/ApolloSurfaceView;
    //   181: ifnonnull +19 -> 200
    //   184: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   187: ifeq -63 -> 124
    //   190: ldc 15
    //   192: iconst_2
    //   193: ldc_w 516
    //   196: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   199: return
    //   200: aload_0
    //   201: getfield 79	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_Psj	Lpsj;
    //   204: iload_1
    //   205: aload_3
    //   206: getfield 348	com/tencent/mobileqq/apollo/task/ApolloActionTask:a	Lcom/tencent/mobileqq/apollo/task/ApolloTaskParam;
    //   209: getfield 517	com/tencent/mobileqq/apollo/task/ApolloTaskParam:jdField_c_of_type_Int	I
    //   212: invokevirtual 520	psj:b	(II)Z
    //   215: ifne +34 -> 249
    //   218: iconst_4
    //   219: iload_2
    //   220: if_icmpeq +29 -> 249
    //   223: iconst_3
    //   224: iload_2
    //   225: if_icmpeq +24 -> 249
    //   228: iconst_5
    //   229: iload_2
    //   230: if_icmpeq +19 -> 249
    //   233: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   236: ifeq -112 -> 124
    //   239: ldc 15
    //   241: iconst_2
    //   242: ldc_w 522
    //   245: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   248: return
    //   249: invokestatic 209	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   252: iconst_0
    //   253: invokestatic 527	com/tencent/mobileqq/utils/AudioUtil:a	(Landroid/content/Context;Z)Z
    //   256: pop
    //   257: aload_0
    //   258: getfield 333	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView	Lcom/tencent/mobileqq/apollo/ApolloSurfaceView;
    //   261: ifnull +15 -> 276
    //   264: aload_0
    //   265: getfield 333	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView	Lcom/tencent/mobileqq/apollo/ApolloSurfaceView;
    //   268: iconst_1
    //   269: aload_0
    //   270: getfield 529	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   273: invokevirtual 532	com/tencent/mobileqq/apollo/ApolloSurfaceView:a	(ILjava/lang/String;)V
    //   276: aload_0
    //   277: getfield 333	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView	Lcom/tencent/mobileqq/apollo/ApolloSurfaceView;
    //   280: ifnull +15 -> 295
    //   283: aload_0
    //   284: getfield 333	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView	Lcom/tencent/mobileqq/apollo/ApolloSurfaceView;
    //   287: iconst_2
    //   288: aload_0
    //   289: getfield 534	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   292: invokevirtual 532	com/tencent/mobileqq/apollo/ApolloSurfaceView:a	(ILjava/lang/String;)V
    //   295: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   298: ifeq +45 -> 343
    //   301: ldc 15
    //   303: iconst_2
    //   304: new 148	java/lang/StringBuilder
    //   307: dup
    //   308: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   311: ldc_w 536
    //   314: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: iload_1
    //   318: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   321: ldc_w 538
    //   324: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: aload_3
    //   328: getfield 348	com/tencent/mobileqq/apollo/task/ApolloActionTask:a	Lcom/tencent/mobileqq/apollo/task/ApolloTaskParam;
    //   331: getfield 539	com/tencent/mobileqq/apollo/task/ApolloTaskParam:jdField_b_of_type_Int	I
    //   334: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   337: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   343: aload_3
    //   344: getfield 348	com/tencent/mobileqq/apollo/task/ApolloActionTask:a	Lcom/tencent/mobileqq/apollo/task/ApolloTaskParam;
    //   347: getfield 540	com/tencent/mobileqq/apollo/task/ApolloTaskParam:jdField_e_of_type_Int	I
    //   350: iconst_1
    //   351: if_icmpeq +16 -> 367
    //   354: aload_3
    //   355: getfield 348	com/tencent/mobileqq/apollo/task/ApolloActionTask:a	Lcom/tencent/mobileqq/apollo/task/ApolloTaskParam;
    //   358: getfield 540	com/tencent/mobileqq/apollo/task/ApolloTaskParam:jdField_e_of_type_Int	I
    //   361: sipush 3000
    //   364: if_icmpne +45 -> 409
    //   367: aload_0
    //   368: getfield 333	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView	Lcom/tencent/mobileqq/apollo/ApolloSurfaceView;
    //   371: ifnull +17 -> 388
    //   374: aload_0
    //   375: getfield 333	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView	Lcom/tencent/mobileqq/apollo/ApolloSurfaceView;
    //   378: invokevirtual 353	com/tencent/mobileqq/apollo/ApolloSurfaceView:a	()Lcom/tencent/mobileqq/apollo/ApolloRenderInterfaceImpl;
    //   381: iconst_2
    //   382: ldc_w 542
    //   385: invokevirtual 543	com/tencent/mobileqq/apollo/ApolloRenderInterfaceImpl:a	(ILjava/lang/String;)V
    //   388: aload_0
    //   389: getfield 333	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView	Lcom/tencent/mobileqq/apollo/ApolloSurfaceView;
    //   392: ifnull +17 -> 409
    //   395: aload_0
    //   396: getfield 333	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView	Lcom/tencent/mobileqq/apollo/ApolloSurfaceView;
    //   399: invokevirtual 353	com/tencent/mobileqq/apollo/ApolloSurfaceView:a	()Lcom/tencent/mobileqq/apollo/ApolloRenderInterfaceImpl;
    //   402: iconst_1
    //   403: ldc_w 542
    //   406: invokevirtual 543	com/tencent/mobileqq/apollo/ApolloRenderInterfaceImpl:a	(ILjava/lang/String;)V
    //   409: bipush 6
    //   411: iload_2
    //   412: if_icmpeq +79 -> 491
    //   415: aload_3
    //   416: getfield 348	com/tencent/mobileqq/apollo/task/ApolloActionTask:a	Lcom/tencent/mobileqq/apollo/task/ApolloTaskParam;
    //   419: getfield 546	com/tencent/mobileqq/apollo/task/ApolloTaskParam:jdField_a_of_type_ComTencentMobileqqApolloTaskIApolloTaskListener	Lcom/tencent/mobileqq/apollo/task/IApolloTaskListener;
    //   422: ifnull +69 -> 491
    //   425: aload_0
    //   426: getfield 548	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   429: ifnull +10 -> 439
    //   432: aload_0
    //   433: getfield 548	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   436: invokevirtual 553	android/media/MediaPlayer:stop	()V
    //   439: aload_0
    //   440: getfield 221	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_AndroidOsVibrator	Landroid/os/Vibrator;
    //   443: ifnull +10 -> 453
    //   446: aload_0
    //   447: getfield 221	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_AndroidOsVibrator	Landroid/os/Vibrator;
    //   450: invokevirtual 556	android/os/Vibrator:cancel	()V
    //   453: aload_3
    //   454: getfield 348	com/tencent/mobileqq/apollo/task/ApolloActionTask:a	Lcom/tencent/mobileqq/apollo/task/ApolloTaskParam;
    //   457: getfield 546	com/tencent/mobileqq/apollo/task/ApolloTaskParam:jdField_a_of_type_ComTencentMobileqqApolloTaskIApolloTaskListener	Lcom/tencent/mobileqq/apollo/task/IApolloTaskListener;
    //   460: iload_2
    //   461: aload_3
    //   462: getfield 348	com/tencent/mobileqq/apollo/task/ApolloActionTask:a	Lcom/tencent/mobileqq/apollo/task/ApolloTaskParam;
    //   465: getfield 559	com/tencent/mobileqq/apollo/task/ApolloTaskParam:jdField_a_of_type_Long	J
    //   468: invokestatic 564	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   471: invokeinterface 567 3 0
    //   476: aload_0
    //   477: getfield 333	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView	Lcom/tencent/mobileqq/apollo/ApolloSurfaceView;
    //   480: ifnull +11 -> 491
    //   483: aload_0
    //   484: getfield 333	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView	Lcom/tencent/mobileqq/apollo/ApolloSurfaceView;
    //   487: iconst_1
    //   488: invokevirtual 569	com/tencent/mobileqq/apollo/ApolloSurfaceView:a	(Z)V
    //   491: aload_0
    //   492: getfield 306	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskExecutor	Lcom/tencent/mobileqq/apollo/task/ApolloTaskExecutor;
    //   495: aload_3
    //   496: getfield 348	com/tencent/mobileqq/apollo/task/ApolloActionTask:a	Lcom/tencent/mobileqq/apollo/task/ApolloTaskParam;
    //   499: getfield 335	com/tencent/mobileqq/apollo/task/ApolloTaskParam:f	I
    //   502: invokevirtual 571	com/tencent/mobileqq/apollo/task/ApolloTaskExecutor:a	(I)V
    //   505: aload_3
    //   506: getfield 348	com/tencent/mobileqq/apollo/task/ApolloActionTask:a	Lcom/tencent/mobileqq/apollo/task/ApolloTaskParam;
    //   509: getfield 572	com/tencent/mobileqq/apollo/task/ApolloTaskParam:jdField_c_of_type_Boolean	Z
    //   512: ifeq -388 -> 124
    //   515: aload_0
    //   516: getfield 306	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskExecutor	Lcom/tencent/mobileqq/apollo/task/ApolloTaskExecutor;
    //   519: invokevirtual 366	com/tencent/mobileqq/apollo/task/ApolloTaskExecutor:c	()V
    //   522: return
    //   523: astore 4
    //   525: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   528: ifeq -89 -> 439
    //   531: ldc 15
    //   533: iconst_2
    //   534: new 148	java/lang/StringBuilder
    //   537: dup
    //   538: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   541: ldc_w 574
    //   544: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: aload 4
    //   549: invokevirtual 577	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   552: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   558: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   561: goto -122 -> 439
    //   564: astore 4
    //   566: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   569: ifeq -130 -> 439
    //   572: ldc 15
    //   574: iconst_2
    //   575: new 148	java/lang/StringBuilder
    //   578: dup
    //   579: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   582: ldc_w 574
    //   585: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: aload 4
    //   590: invokevirtual 578	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   593: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   599: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   602: goto -163 -> 439
    //   605: astore 4
    //   607: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   610: ifeq -157 -> 453
    //   613: ldc 15
    //   615: iconst_2
    //   616: new 148	java/lang/StringBuilder
    //   619: dup
    //   620: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   623: ldc_w 580
    //   626: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: aload 4
    //   631: invokevirtual 578	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   634: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   640: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   643: goto -190 -> 453
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	646	0	this	ApolloActionManager
    //   0	646	1	paramInt1	int
    //   0	646	2	paramInt2	int
    //   0	646	3	paramString	String
    //   523	25	4	localIllegalStateException	IllegalStateException
    //   564	25	4	localThrowable1	Throwable
    //   605	25	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   432	439	523	java/lang/IllegalStateException
    //   432	439	564	java/lang/Throwable
    //   446	453	605	java/lang/Throwable
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionManager", 2, "[onStartRender], taskId:" + paramInt + ",roleName:" + paramString);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView == null) || (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionManager", 2, "mSurfaceView is null, mSurfaceView:" + this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView + ",mIsInit:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a().a();
          if ((paramInt <= 1000000) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView == null)) {
            break;
          }
        } while (!"me".equals(paramString));
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a().a(Integer.valueOf(paramInt));
        return;
        paramString = this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskExecutor.a(paramInt);
      } while ((paramString == null) || (paramString.a == null) || (!paramString.a.jdField_c_of_type_Boolean));
      if (this.jdField_a_of_type_Psj.a(paramInt, paramString.a.jdField_c_of_type_Int)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloActionManager", 2, "start_callback NOT all ready.");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionManager", 2, "DO start callback, taskId:" + paramInt + ",actionId:" + paramString.a.jdField_b_of_type_Int);
    }
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloDaoManager.a(paramString.a.jdField_b_of_type_Int);
      ApolloActionHelper.a((ApolloActionData)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localObject != null)
      {
        if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
          this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
        }
        if ((!((ApolloActionData)localObject).hasSound) || (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) || (1 != this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d()) || (((paramString.a.jdField_e_of_type_Int == 1) || (paramString.a.jdField_e_of_type_Int == 3000)) && (((1 != this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b()) && (paramString.a.jdField_e_of_type_Int != 0)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.k()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.l()) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.m()) || (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b()) || ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f())) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d()) || ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g()))))) {
          break label898;
        }
      }
    }
    try
    {
      boolean bool = ((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio")).isMusicActive();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionManager", 2, "isMusicActive:" + bool);
      }
      AudioUtil.a(BaseApplicationImpl.getContext(), true);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(ApolloConstant.l + paramString.a.jdField_b_of_type_Int + "/" + "music.amr");
      this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloActionManager", 2, "play,oom->errInfo:" + localOutOfMemoryError.getMessage());
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloActionManager", 2, "play, other->errInfo:" + localThrowable.getMessage());
        }
      }
    }
    if ((1 == this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e()) && (((paramString.a.jdField_e_of_type_Int != 1) && (paramString.a.jdField_e_of_type_Int != 3000)) || (((1 == this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) || (paramString.a.jdField_e_of_type_Int == 0)) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.l()))))
    {
      localObject = ApolloActionHelper.a(((ApolloActionData)localObject).vibrate);
      if ((localObject == null) || (localObject.length <= 0) || (this.jdField_a_of_type_AndroidOsVibrator == null)) {
        break label919;
      }
      this.jdField_a_of_type_AndroidOsVibrator.vibrate((long[])localObject, -1);
    }
    for (;;)
    {
      if (paramString.a.jdField_a_of_type_ComTencentMobileqqApolloTaskIApolloTaskListener != null)
      {
        paramString.a.jdField_a_of_type_ComTencentMobileqqApolloTaskIApolloTaskListener.a(Long.valueOf(paramString.a.jdField_a_of_type_Long));
        if ((paramString.a.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)) {
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a("", paramString.a.jdField_c_of_type_JavaLangString, true);
        }
      }
      this.jdField_d_of_type_Int += 1;
      this.g = paramString.a.jdField_b_of_type_JavaLangString;
      this.jdField_f_of_type_JavaLangString = paramString.a.jdField_a_of_type_JavaLangString;
      return;
      label898:
      if (!((ApolloActionData)localObject).hasSound) {
        break;
      }
      b(paramString.a.jdField_e_of_type_Int);
      break;
      label919:
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionManager", 2, "No vibrate data.");
      }
    }
  }
  
  public void a(long paramLong)
  {
    ApolloActionTask localApolloActionTask = a();
    if ((localApolloActionTask != null) && (localApolloActionTask.a != null))
    {
      if (localApolloActionTask.a.jdField_a_of_type_Long == paramLong)
      {
        a();
        f();
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionManager", 2, "[stopTaskIfNeeded], NO running task.");
    }
    f();
  }
  
  public void a(ApolloTaskParam paramApolloTaskParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionManager", 2, "[execApolloAction]");
    }
    if (paramApolloTaskParam == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionManager", 2, "errInfo->param is null. mSurfaceView:" + this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView);
      }
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_AndroidContentSharedPreferences != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("is_apollo_hide" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false).commit();
      }
      this.jdField_b_of_type_Boolean = false;
      paramApolloTaskParam.jdField_d_of_type_Boolean = false;
      b(paramApolloTaskParam);
      a(4, true);
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      String str = Integer.toString(ApolloUtil.a(this.jdField_c_of_type_Int));
      if (paramApolloTaskParam.jdField_d_of_type_Int == 2) {}
      for (paramApolloTaskParam = "1";; paramApolloTaskParam = "2")
      {
        VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "aio_double_show_clk", 0, 0, new String[] { str, paramApolloTaskParam });
        return;
      }
    }
    b(paramApolloTaskParam);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionManager", 2, "[onSurfaceReadyNotify], leftManUin:" + paramString1 + ",rightManUin:" + paramString2 + ",sessionType:" + paramInt + ",mHasMsgAction:" + this.jdField_d_of_type_Boolean);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionManager", 2, "errInfo-> null param. mApp:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      return;
    }
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    if (!ApolloManager.a(BaseApplicationImpl.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionManager", 2, "Apollo switch NOT open.");
      }
      h();
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    for (;;)
    {
      boolean bool;
      try
      {
        if (!this.jdField_d_of_type_Boolean)
        {
          this.jdField_f_of_type_JavaLangString = paramString2;
          if ((1 == paramInt) || (3000 == paramInt)) {
            this.g = "0";
          }
        }
        else
        {
          this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
          if (1 != paramInt) {
            break label510;
          }
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
          this.h = paramString1;
          this.jdField_e_of_type_Boolean = AnonymousChatHelper.a().a(this.h);
          if ((this.jdField_a_of_type_AndroidContentSharedPreferences == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
            break label603;
          }
          bool = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("is_apollo_hide" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false);
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
            break;
          }
          this.jdField_e_of_type_Int = ApolloActionHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (QLog.isColorLevel()) {
            QLog.d("ApolloActionManager", 2, "funcSwitch:" + this.jdField_e_of_type_Int + ",mIsAnonymousChat:" + this.jdField_e_of_type_Boolean);
          }
          paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatActivity.class);
          if ((bool) || (1 != this.jdField_e_of_type_Int) || (this.jdField_e_of_type_Boolean)) {
            break label568;
          }
          if (!this.jdField_d_of_type_Boolean) {
            break label558;
          }
          i();
          paramInt = 61;
          if ((paramString2 != null) && (paramInt > -1)) {
            paramString2.sendEmptyMessage(paramInt);
          }
          if (1 != this.jdField_e_of_type_Int) {
            break;
          }
          paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (!bool) {
            break label593;
          }
          paramInt = 1;
          VipUtils.a(paramString2, "cmshow", "Apollo", "aio_show", paramInt, 0, new String[] { Integer.toString(ApolloUtil.a(this.jdField_c_of_type_Int)), "", "", paramString1 });
          return;
        }
        this.g = paramString1;
        continue;
        if (paramInt != 0) {
          break label530;
        }
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      }
      label510:
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      this.jdField_e_of_type_Boolean = false;
      continue;
      label530:
      if (3000 == paramInt)
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
        this.h = paramString1;
        this.jdField_e_of_type_Boolean = false;
        continue;
        label558:
        a(1, true);
        continue;
        label568:
        if ((2 == this.jdField_e_of_type_Int) || (this.jdField_e_of_type_Boolean))
        {
          h();
          paramInt = 62;
          continue;
          label593:
          paramInt = 0;
        }
        else
        {
          paramInt = -1;
          continue;
          label603:
          bool = false;
        }
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionManager", 2, "[onApolloVisibilityChanged], isHide:" + paramBoolean1 + ",isRecordPref:" + paramBoolean2 + ",panelType:" + paramInt + ",mApp:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    MqqHandler localMqqHandler;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if ((paramBoolean2) && (this.jdField_a_of_type_AndroidContentSharedPreferences != null)) {
              this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("is_apollo_hide" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramBoolean1).commit();
            }
            localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatActivity.class);
            if (localMqqHandler != null) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("ApolloActionManager", 2, "errInfo->null obj. uiHandler:" + localMqqHandler);
          return;
          if (paramBoolean1)
          {
            e();
            localMqqHandler.sendEmptyMessage(62);
            return;
          }
          paramBoolean1 = c();
        } while ((this.jdField_e_of_type_Int != 1) || (paramBoolean1));
        if (paramInt != 21) {
          break;
        }
      } while (a(3, false) != 0);
      localMqqHandler.obtainMessage(47, (int)((float)DeviceInfoUtil.g() / 7.0F) + 40, 0).sendToTarget();
      return;
    } while (a(1, true) != 0);
    localMqqHandler.obtainMessage(47, (int)((float)DeviceInfoUtil.g() / 7.0F / 2.84D) + 40, 0).sendToTarget();
  }
  
  public void a(boolean paramBoolean1, ApolloRoleLoadParam[] paramArrayOfApolloRoleLoadParam, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionManager", 2, "[execLoadApolloRole], roleParams:" + paramArrayOfApolloRoleLoadParam + ",isReloadRole:" + paramBoolean1);
    }
    if ((paramArrayOfApolloRoleLoadParam == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView == null) || (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
      return;
    }
    int j = paramArrayOfApolloRoleLoadParam.length;
    int i = 0;
    label71:
    ApolloRoleLoadParam localApolloRoleLoadParam;
    if (i < j)
    {
      localApolloRoleLoadParam = paramArrayOfApolloRoleLoadParam[i];
      if (localApolloRoleLoadParam != null) {
        break label98;
      }
    }
    label98:
    label238:
    label266:
    for (;;)
    {
      i += 1;
      break label71;
      break;
      if ((paramBoolean1) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a().a(localApolloRoleLoadParam.jdField_b_of_type_Int, localApolloRoleLoadParam.jdField_a_of_type_Int, localApolloRoleLoadParam.jdField_a_of_type_Float, localApolloRoleLoadParam.jdField_b_of_type_Float, localApolloRoleLoadParam.jdField_c_of_type_Float);
        if (paramBoolean2)
        {
          if ((localApolloRoleLoadParam.jdField_b_of_type_Int != 1) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView == null)) {
            break label238;
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setNodeHidden("me", 1);
        }
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView == null) || (localApolloRoleLoadParam.jdField_a_of_type_ArrayOfInt == null) || (localApolloRoleLoadParam.jdField_a_of_type_ArrayOfInt.length <= 0) || (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
          break label266;
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a().a(localApolloRoleLoadParam.jdField_b_of_type_Int, localApolloRoleLoadParam.jdField_a_of_type_ArrayOfInt, null);
        break;
        if ((localApolloRoleLoadParam.jdField_b_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)) {
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setNodeHidden("friend", 1);
        }
      }
    }
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionManager", 2, "[execTaskIsExist], mTaskManager:" + this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskExecutor);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a() == 8)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloActionManager", 2, "Action is being performed. Return");
        }
        return true;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a() != 4) {
        break label124;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setStatus(0);
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskExecutor == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskExecutor.b() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionManager", 2, "NO task");
      }
      return false;
      label124:
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a() == 2) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setStatus(1);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskExecutor.c();
    return true;
  }
  
  public int[] a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionManager", 2, "[reLoadRole], isDispose:" + paramBoolean1 + ",isHidden:" + paramBoolean2);
    }
    return a(paramBoolean1, paramBoolean2, this.jdField_f_of_type_JavaLangString, this.g);
  }
  
  public int[] a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionManager", 2, "[reLoadRole], senderUin:" + paramString1 + ",recUin:" + paramString2 + ",isDispose:" + paramBoolean1);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView == null) || (!this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionManager", 2, "errInfo-> app is null or surface NOT ready.");
      }
      return null;
    }
    String str = null;
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a().b();
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a().g();
    }
    if ("0".equals(paramString2))
    {
      bool1 = this.jdField_a_of_type_JavaUtilVector.contains(paramString1);
      if ((!paramBoolean1) && (paramString1.equals(this.jdField_b_of_type_JavaLangString)) && (!bool1)) {
        return this.jdField_a_of_type_ArrayOfInt;
      }
      paramString2 = new int[2];
      paramString2[0] = ApolloActionTask.a(1, paramString1, this.jdField_d_of_type_Float, 0.0F, this.jdField_a_of_type_Float, paramBoolean1, paramBoolean2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionManager", 2, "load SINGLE role, isUpdate:" + bool1);
      }
      if (bool1) {
        this.jdField_a_of_type_JavaUtilVector.remove(paramString1);
      }
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_ArrayOfInt = paramString2;
      this.jdField_c_of_type_JavaLangString = "0";
      this.jdField_b_of_type_JavaLangString = paramString1;
      return paramString2;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionManager", 2, "errInfo->mApp is null.");
      }
      return null;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    boolean bool1 = ((String)localObject).equals(paramString1);
    boolean bool2 = ((String)localObject).equals(paramString2);
    if ((this.jdField_a_of_type_ArrayOfInt != null) && (this.jdField_a_of_type_ArrayOfInt.length == 2))
    {
      localObject = this.jdField_a_of_type_ArrayOfInt;
      if (((bool1) || (bool2)) && (!bool1)) {
        break label646;
      }
    }
    for (;;)
    {
      bool1 = this.jdField_a_of_type_JavaUtilVector.contains(paramString2);
      bool2 = this.jdField_a_of_type_JavaUtilVector.contains(paramString1);
      if ((paramBoolean1) || (bool2) || ((!TextUtils.isEmpty(paramString1)) && (!"0".equals(paramString1)) && (!paramString1.equals(this.jdField_b_of_type_JavaLangString))))
      {
        localObject[0] = ApolloActionTask.a(1, paramString1, this.jdField_c_of_type_Float, 0.0F, this.jdField_a_of_type_Float, paramBoolean1, paramBoolean2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloActionManager", 2, "load RIGHT role, isRightUpdate:" + bool2);
        }
        if (bool2) {
          this.jdField_a_of_type_JavaUtilVector.remove(paramString1);
        }
      }
      if ((paramBoolean1) || (bool1) || ((!TextUtils.isEmpty(paramString2)) && (!"0".equals(paramString2)) && (!paramString2.equals(this.jdField_c_of_type_JavaLangString))))
      {
        localObject[1] = ApolloActionTask.a(2, paramString2, this.jdField_b_of_type_Float, 0.0F, this.jdField_a_of_type_Float, paramBoolean1, paramBoolean2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloActionManager", 2, "load LEFT role, isLeftUpdate:" + bool1);
        }
        if (bool1) {
          this.jdField_a_of_type_JavaUtilVector.remove(paramString2);
        }
      }
      this.jdField_b_of_type_Int = 1;
      this.jdField_a_of_type_ArrayOfInt = ((int[])localObject);
      this.jdField_c_of_type_JavaLangString = paramString2;
      this.jdField_b_of_type_JavaLangString = paramString1;
      return (int[])localObject;
      localObject = new int[2];
      break;
      label646:
      if (bool2)
      {
        str = paramString1;
        paramString1 = paramString2;
        paramString2 = str;
      }
      else
      {
        paramString2 = null;
        paramString1 = str;
      }
    }
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionManager", 2, "[getTaskId], mTaskManager:" + this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskExecutor);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskExecutor == null) {
      return -1;
    }
    return this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskExecutor.a();
  }
  
  public ApolloActionManager b()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionManager", 2, "[init] mIsInit:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      }
      if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        if (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskExecutor == null) {
          this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskExecutor = new ApolloTaskExecutor(this);
        }
        this.jdField_d_of_type_Int = 0;
        this.jdField_b_of_type_Int = -1;
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloActionManager", 2, "mIsHide:" + this.jdField_b_of_type_Boolean);
        }
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
        if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
        {
          this.jdField_a_of_type_AndroidContentBroadcastReceiver = new pse(this);
          BaseApplicationImpl.getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
        }
      }
      return this;
    }
    finally {}
  }
  
  public void b()
  {
    String str1 = null;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionManager", 2, "[justChangeDress]" + this.jdField_f_of_type_JavaLangString + ",recUin:" + this.g);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView == null) || (!this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (TextUtils.isEmpty(this.g)) || (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionManager", 2, "errInfo-> app is null or surface NOT ready.");
      }
      return;
    }
    if ("0".equals(this.g))
    {
      ApolloActionTask.a(1, this.jdField_f_of_type_JavaLangString, this.jdField_d_of_type_Float, 0.0F, this.jdField_a_of_type_Float, false, false, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    boolean bool1 = str2.equals(this.jdField_f_of_type_JavaLangString);
    boolean bool2 = str2.equals(this.g);
    if (((!bool1) && (!bool2)) || (bool1))
    {
      str1 = this.jdField_f_of_type_JavaLangString;
      str2 = this.g;
    }
    for (;;)
    {
      ApolloActionTask.a(1, str1, this.jdField_c_of_type_Float, 0.0F, this.jdField_a_of_type_Float, false, false, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ApolloActionTask.a(2, str2, this.jdField_b_of_type_Float, 0.0F, this.jdField_a_of_type_Float, false, false, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (a() != null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a().a(1000L);
      return;
      if (bool2)
      {
        str1 = this.g;
        str2 = this.jdField_f_of_type_JavaLangString;
      }
      else
      {
        str2 = null;
      }
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView == null) {
      return false;
    }
    return this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionManager", 2, "[doOnResume]");
    }
    ApolloActionTask localApolloActionTask = a();
    if ((localApolloActionTask == null) || (localApolloActionTask.a == null)) {}
    do
    {
      for (;;)
      {
        return;
        if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
          try
          {
            AudioUtil.a(BaseApplicationImpl.getContext(), true);
            this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
            return;
          }
          catch (IllegalStateException localIllegalStateException)
          {
            if (QLog.isColorLevel())
            {
              QLog.d("ApolloActionManager", 2, "errInfo->" + localIllegalStateException.getMessage());
              return;
            }
          }
          catch (Throwable localThrowable) {}
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloActionManager", 2, "errInfo->" + localThrowable.getMessage());
  }
  
  public boolean c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionManager", 2, "[getIsAnonymousChat]");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewChatApolloViewListener == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloViewChatApolloViewListener.a == null)) {}
    BaseChatPie localBaseChatPie;
    do
    {
      return false;
      localBaseChatPie = (BaseChatPie)this.jdField_a_of_type_ComTencentMobileqqApolloViewChatApolloViewListener.a.get();
    } while ((localBaseChatPie == null) || (localBaseChatPie.a.jdField_a_of_type_Int == 0) || (localBaseChatPie.a.jdField_a_of_type_Int == 3000));
    if (localBaseChatPie.a.jdField_a_of_type_Int == 1) {}
    for (boolean bool = AnonymousChatHelper.a().a(localBaseChatPie.a.jdField_a_of_type_JavaLangString);; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionManager", 2, "isAnonymousChat:" + bool);
      }
      return bool;
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean != null) && (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {}
    do
    {
      do
      {
        ApolloActionTask localApolloActionTask;
        do
        {
          return;
          localApolloActionTask = a();
        } while ((localApolloActionTask == null) || (localApolloActionTask.a == null));
        if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
        {
          this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
          AudioUtil.a(BaseApplicationImpl.getContext(), false);
        }
      } while (this.jdField_a_of_type_AndroidOsVibrator == null);
      try
      {
        this.jdField_a_of_type_AndroidOsVibrator.cancel();
        return;
      }
      catch (Throwable localThrowable) {}
    } while (!QLog.isColorLevel());
    QLog.d("ApolloActionManager", 2, "cancel->errInfo:" + localThrowable.getMessage());
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionManager", 2, "[hideAndStop], mTaskManager:" + this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskExecutor);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskExecutor == null) {
      return;
    }
    ApolloActionTask localApolloActionTask = this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskExecutor.a;
    if ((localApolloActionTask != null) && (localApolloActionTask.a != null) && (localApolloActionTask.a.jdField_a_of_type_ComTencentMobileqqApolloTaskIApolloTaskListener != null)) {
      localApolloActionTask.a.jdField_a_of_type_ComTencentMobileqqApolloTaskIApolloTaskListener.a(5, Long.valueOf(localApolloActionTask.a.jdField_a_of_type_Long));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a(false);
    }
    h();
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionManager", 2, "[removeMsgBubble], mSurfaceView:" + this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a().a(2, "Bubble");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a().a(1, "Bubble");
    }
  }
  
  /* Error */
  public void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +35 -> 40
    //   8: ldc 15
    //   10: iconst_2
    //   11: new 148	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 972
    //   21: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: getfield 55	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   28: invokevirtual 396	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   31: invokevirtual 268	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   34: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   40: aload_0
    //   41: aconst_null
    //   42: putfield 258	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   45: aload_0
    //   46: aconst_null
    //   47: putfield 400	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_ComTencentMobileqqApolloViewChatApolloViewListener	Lcom/tencent/mobileqq/apollo/view/ChatApolloViewListener;
    //   50: aload_0
    //   51: iconst_0
    //   52: putfield 758	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_d_of_type_Boolean	Z
    //   55: aload_0
    //   56: getfield 55	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   59: invokevirtual 396	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   62: istore_2
    //   63: iload_2
    //   64: ifne +6 -> 70
    //   67: aload_0
    //   68: monitorexit
    //   69: return
    //   70: aload_0
    //   71: getfield 57	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   74: iconst_0
    //   75: invokevirtual 763	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   78: aload_0
    //   79: getfield 55	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   82: iconst_0
    //   83: invokevirtual 763	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   86: aload_0
    //   87: iconst_m1
    //   88: putfield 59	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_b_of_type_Int	I
    //   91: aload_0
    //   92: getfield 333	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView	Lcom/tencent/mobileqq/apollo/ApolloSurfaceView;
    //   95: ifnull +17 -> 112
    //   98: aload_0
    //   99: getfield 333	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView	Lcom/tencent/mobileqq/apollo/ApolloSurfaceView;
    //   102: invokevirtual 353	com/tencent/mobileqq/apollo/ApolloSurfaceView:a	()Lcom/tencent/mobileqq/apollo/ApolloRenderInterfaceImpl;
    //   105: invokevirtual 973	com/tencent/mobileqq/apollo/ApolloRenderInterfaceImpl:c	()V
    //   108: aload_0
    //   109: invokevirtual 974	com/tencent/mobileqq/apollo/task/ApolloActionManager:a	()V
    //   112: aload_0
    //   113: getfield 306	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskExecutor	Lcom/tencent/mobileqq/apollo/task/ApolloTaskExecutor;
    //   116: ifnull +18 -> 134
    //   119: aload_0
    //   120: getfield 306	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskExecutor	Lcom/tencent/mobileqq/apollo/task/ApolloTaskExecutor;
    //   123: invokevirtual 456	com/tencent/mobileqq/apollo/task/ApolloTaskExecutor:a	()V
    //   126: aload_0
    //   127: getfield 306	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskExecutor	Lcom/tencent/mobileqq/apollo/task/ApolloTaskExecutor;
    //   130: aconst_null
    //   131: putfield 445	com/tencent/mobileqq/apollo/task/ApolloTaskExecutor:a	Lcom/tencent/mobileqq/apollo/task/ApolloActionTask;
    //   134: aload_0
    //   135: getfield 548	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   138: astore_1
    //   139: aload_1
    //   140: ifnull +22 -> 162
    //   143: aload_0
    //   144: getfield 548	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   147: invokevirtual 553	android/media/MediaPlayer:stop	()V
    //   150: aload_0
    //   151: getfield 548	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   154: invokevirtual 977	android/media/MediaPlayer:release	()V
    //   157: aload_0
    //   158: aconst_null
    //   159: putfield 548	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   162: invokestatic 209	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   165: iconst_0
    //   166: invokestatic 527	com/tencent/mobileqq/utils/AudioUtil:a	(Landroid/content/Context;Z)Z
    //   169: pop
    //   170: aload_0
    //   171: getfield 221	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_AndroidOsVibrator	Landroid/os/Vibrator;
    //   174: astore_1
    //   175: aload_1
    //   176: ifnull +10 -> 186
    //   179: aload_0
    //   180: getfield 221	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_AndroidOsVibrator	Landroid/os/Vibrator;
    //   183: invokevirtual 556	android/os/Vibrator:cancel	()V
    //   186: aload_0
    //   187: getfield 86	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_JavaUtilVector	Ljava/util/Vector;
    //   190: ifnull +10 -> 200
    //   193: aload_0
    //   194: getfield 86	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_JavaUtilVector	Ljava/util/Vector;
    //   197: invokevirtual 980	java/util/Vector:clear	()V
    //   200: aload_0
    //   201: getfield 93	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   204: astore_1
    //   205: aload_1
    //   206: ifnull +18 -> 224
    //   209: invokestatic 209	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   212: aload_0
    //   213: getfield 93	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   216: invokevirtual 984	com/tencent/qphone/base/util/BaseApplication:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   219: aload_0
    //   220: aconst_null
    //   221: putfield 93	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   224: aload_0
    //   225: aconst_null
    //   226: putfield 333	com/tencent/mobileqq/apollo/task/ApolloActionManager:jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView	Lcom/tencent/mobileqq/apollo/ApolloSurfaceView;
    //   229: goto -162 -> 67
    //   232: astore_1
    //   233: aload_0
    //   234: monitorexit
    //   235: aload_1
    //   236: athrow
    //   237: astore_1
    //   238: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   241: ifeq -79 -> 162
    //   244: ldc 15
    //   246: iconst_2
    //   247: new 148	java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   254: ldc_w 941
    //   257: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: aload_1
    //   261: invokevirtual 578	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   264: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   273: goto -111 -> 162
    //   276: astore_1
    //   277: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   280: ifeq -94 -> 186
    //   283: ldc 15
    //   285: iconst_2
    //   286: new 148	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   293: ldc_w 580
    //   296: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload_1
    //   300: invokevirtual 578	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   303: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   312: goto -126 -> 186
    //   315: astore_1
    //   316: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   319: ifeq -95 -> 224
    //   322: ldc 15
    //   324: iconst_2
    //   325: new 148	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   332: ldc_w 986
    //   335: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: aload_1
    //   339: invokevirtual 987	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   342: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   351: goto -127 -> 224
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	354	0	this	ApolloActionManager
    //   138	68	1	localObject1	Object
    //   232	4	1	localObject2	Object
    //   237	24	1	localThrowable1	Throwable
    //   276	24	1	localThrowable2	Throwable
    //   315	24	1	localIllegalArgumentException	IllegalArgumentException
    //   62	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	40	232	finally
    //   40	63	232	finally
    //   70	112	232	finally
    //   112	134	232	finally
    //   134	139	232	finally
    //   143	162	232	finally
    //   162	175	232	finally
    //   179	186	232	finally
    //   186	200	232	finally
    //   200	205	232	finally
    //   209	224	232	finally
    //   224	229	232	finally
    //   238	273	232	finally
    //   277	312	232	finally
    //   316	351	232	finally
    //   143	162	237	java/lang/Throwable
    //   179	186	276	java/lang/Throwable
    //   209	224	315	java/lang/IllegalArgumentException
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionManager", 2, "closeApolloFunc");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskExecutor != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskExecutor.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskExecutor != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskExecutor.a = null;
    }
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      if (this.jdField_a_of_type_AndroidOsVibrator == null) {}
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        do
        {
          this.jdField_a_of_type_AndroidOsVibrator.cancel();
          this.jdField_b_of_type_Int = -1;
          if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) && (b()) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
          {
            this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a().g();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatActivity.class).postDelayed(new psi(this), 150L);
            if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) {
              this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setStatus(0);
            }
          }
          AudioUtil.a(BaseApplicationImpl.getContext(), false);
          return;
          localThrowable1 = localThrowable1;
        } while (!QLog.isColorLevel());
        QLog.d("ApolloActionManager", 2, "errInfo->" + localThrowable1.getMessage());
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloActionManager", 2, "cancel->errInfo:" + localThrowable2.getMessage());
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\task\ApolloActionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */