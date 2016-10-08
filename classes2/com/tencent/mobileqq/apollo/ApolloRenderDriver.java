package com.tencent.mobileqq.apollo;

import android.opengl.GLSurfaceView;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.task.ApolloActionHelper;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
import com.tencent.mobileqq.apollo.task.ApolloActionTask;
import com.tencent.mobileqq.apollo.task.ApolloTaskParam;
import com.tencent.mobileqq.apollo.task.IApolloTaskListener;
import com.tencent.mobileqq.apollo.task.OnDressDoneListener;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import pqg;
import pqh;
import pqi;
import pqj;
import pqk;
import pql;

public class ApolloRenderDriver
  implements Handler.Callback, IRenderCommInterface, IApolloTaskListener
{
  public static final int a = 20;
  public static final String a = "ApolloRenderDriver";
  public static final int b = 208;
  public static final int c = 1000;
  public static final int d = 1000000;
  public static final int e = 3;
  private static final int g = 15;
  HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public ApolloEngine a;
  public ITriggerRenderCallback a;
  public WeakReferenceHandler a;
  public AtomicBoolean a;
  public AtomicInteger a;
  public ReentrantLock a;
  private pqk jdField_a_of_type_Pqk;
  public int f;
  
  public ApolloRenderDriver(ITriggerRenderCallback paramITriggerRenderCallback, ApolloEngine paramApolloEngine)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, "[ApolloRenderDriver] constructor.");
    }
    if (paramApolloEngine == null) {
      throw new NullPointerException();
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloITriggerRenderCallback = paramITriggerRenderCallback;
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloEngine = paramApolloEngine;
    this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.a("cmshowRenderThread", 0);
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = ApolloActionManager.a().a();
    this.jdField_a_of_type_Pqk = new pqk(this);
  }
  
  public int a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, "[onLoadRole], roleId:" + paramInt2);
    }
    String str = ApolloActionHelper.a(paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3);
    if (TextUtils.isEmpty(str)) {
      return 1;
    }
    a(new pql(str, this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock, this.jdField_a_of_type_ComTencentMobileqqApolloApolloEngine));
    return 0;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, "[onExecAction], actionId:" + paramInt2);
    }
    paramString1 = ApolloActionHelper.a(paramInt1, paramInt2, paramInt3, paramString1, paramString2);
    if (paramString1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloRenderDriver", 2, "errInfo->luaParam is null.");
      }
      return 1;
    }
    a(new pqg(this, paramString1));
    return 0;
  }
  
  public int a(int paramInt, int[] paramArrayOfInt, OnDressDoneListener paramOnDressDoneListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, "[onChangeDress], roleType:" + paramInt);
    }
    if (paramArrayOfInt == null) {}
    do
    {
      return 1;
      paramArrayOfInt = ApolloActionHelper.a(paramInt, paramArrayOfInt);
    } while (paramArrayOfInt == null);
    a(new pqh(this, paramArrayOfInt, paramOnDressDoneListener));
    return 0;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, "[startLoop]. mIsLoopStart:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    }
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null)
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(15);
      if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(this.jdField_a_of_type_Pqk);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, "[exeShowAction], actionId:" + paramInt);
    }
    a();
    ApolloTaskParam localApolloTaskParam = new ApolloTaskParam();
    localApolloTaskParam.jdField_b_of_type_Int = paramInt;
    localApolloTaskParam.d = -1;
    localApolloTaskParam.f = (1000000 + paramInt);
    localApolloTaskParam.jdField_a_of_type_Boolean = true;
    localApolloTaskParam.jdField_a_of_type_Int = 0;
    localApolloTaskParam.e = ApolloActionManager.a().c;
    localApolloTaskParam.jdField_a_of_type_ComTencentMobileqqApolloIRenderCommInterface = this;
    localApolloTaskParam.jdField_a_of_type_ComTencentMobileqqApolloTaskIApolloTaskListener = this;
    localApolloTaskParam.jdField_a_of_type_JavaLangString = ApolloActionManager.a().f;
    localApolloTaskParam.jdField_b_of_type_JavaLangString = ApolloActionManager.a().g;
    if (("0".equals(localApolloTaskParam.jdField_a_of_type_JavaLangString)) || ("0".equals(localApolloTaskParam.jdField_b_of_type_JavaLangString))) {}
    for (localApolloTaskParam.c = 0;; localApolloTaskParam.c = 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloRenderDriver", 2, "SenderUin:" + localApolloTaskParam.jdField_a_of_type_JavaLangString + ",ReceiverUin:" + ApolloActionManager.a().g);
      }
      if (4 == paramInt) {
        ApolloActionManager.a().f();
      }
      new ApolloActionTask(localApolloTaskParam).run();
      return;
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, "[onTaskComplete], errCode:" + paramInt + ",usrData:" + paramObject);
    }
    if (ApolloActionManager.a().jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloRenderDriver", 2, "errInfo->surfaceView is NULL.");
      }
    }
    boolean bool;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramInt = ((Integer)paramObject).intValue();
            bool = ApolloActionManager.a().a();
          } while (bool);
          switch (paramInt - 1000000)
          {
          default: 
            return;
          case 1: 
            this.f += 1;
            if (this.f >= 3) {
              break label224;
            }
            a(1);
          }
        } while (this.f != 1);
        ApolloActionManager.a().f();
        return;
      } while (bool);
      a(3);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(3);
      return;
    } while (bool);
    a(1);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
    return;
    this.f += 1;
    if (this.f < 3)
    {
      a(3);
      return;
    }
    b();
    return;
    label224:
    b();
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, "[onRemoveBubble], roleType" + paramInt + ",bubbleName:" + paramString);
    }
    a(new pql(ApolloActionHelper.a(paramInt, paramString), this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock, this.jdField_a_of_type_ComTencentMobileqqApolloApolloEngine));
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null)
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(15);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(15, paramLong);
    }
  }
  
  public void a(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, "[onTaskStart], usrData" + paramObject);
    }
    int i = ((Integer)paramObject).intValue();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(i - 1000000);
  }
  
  public void a(Runnable paramRunnable)
  {
    if ((paramRunnable == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloITriggerRenderCallback == null)) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloITriggerRenderCallback instanceof GLSurfaceView))
      {
        ((GLSurfaceView)this.jdField_a_of_type_ComTencentMobileqqApolloITriggerRenderCallback).queueEvent(paramRunnable);
        return;
      }
    } while (!(this.jdField_a_of_type_ComTencentMobileqqApolloITriggerRenderCallback instanceof GLTextureView));
    ((GLTextureView)this.jdField_a_of_type_ComTencentMobileqqApolloITriggerRenderCallback).a(paramRunnable);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, "[onSetNodeHidded], nodeName:" + paramString + ",value:" + paramInt);
    }
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloRenderDriver", 2, "errInfo->nodeName is NULL.");
      }
      return;
    }
    a(new pqi(this, paramString, paramInt));
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 4) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2);
  }
  
  public int b(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, "[onAddBubble], bubbleType:" + paramInt1 + ",roleType:" + paramInt2 + ",text:" + paramString1 + ",roleId:" + paramInt3 + ",uin:" + paramString2);
    }
    if (TextUtils.isEmpty(paramString1)) {
      return 1;
    }
    paramString1 = paramString1.replace("\\", "").replace("'", "");
    if (TextUtils.isEmpty(paramString1)) {
      return 1;
    }
    Object localObject = Pattern.compile("\t|\r|\n").matcher(paramString1);
    if (localObject != null) {
      paramString1 = ((Matcher)localObject).replaceAll("");
    }
    for (;;)
    {
      int i = paramString1.length();
      if (1 == paramInt1)
      {
        if (ApolloActionManager.a().jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          break label388;
        }
        localObject = (ApolloManager)ApolloActionManager.a().jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
        if ((localObject != null) && (((ApolloManager)localObject).a(paramString2)) && ((ApolloUtil.b(0, 21)) || (ApolloUtil.b(paramInt3, 21)))) {
          paramInt1 = 21;
        }
      }
      for (;;)
      {
        if ((!ApolloUtil.b(paramInt3, paramInt1)) && (!ApolloUtil.b(0, paramInt1)))
        {
          return 2;
          paramInt1 = 20;
          continue;
          if (paramInt1 == 0)
          {
            paramInt1 = ApolloUtil.a(208.0F, paramString1);
          }
          else if (2 == paramInt1)
          {
            paramString2 = paramString1;
            if (i > 8) {
              paramString2 = paramString1.substring(0, 7) + "…";
            }
            paramInt1 = 16;
            paramString1 = paramString2;
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloRenderDriver", 2, "Other bubble type, NOT Handle.");
            }
            return 1;
          }
        }
        else
        {
          paramString1 = ApolloActionHelper.a(paramInt2, paramInt1, paramInt3, paramString1);
          if (TextUtils.isEmpty(paramString1))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloRenderDriver", 2, "errInfo->luaParam is NULL.");
            }
            return 1;
          }
          a(new pql(paramString1, this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock, this.jdField_a_of_type_ComTencentMobileqqApolloApolloEngine));
          return 0;
          label388:
          paramInt1 = 0;
        }
      }
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, "[stopLoop].");
    }
    if ((this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(15);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacks(this.jdField_a_of_type_Pqk);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, "[onRestoreAnimation], roleType" + paramInt);
    }
    a(new pqj(this, paramInt));
  }
  
  public void b(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, "[onRemoveAction], roleType" + paramInt + ",actionName:" + paramString + ",id:" + Thread.currentThread().getId());
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    a(new pql(ApolloActionHelper.b(paramInt, paramString), this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock, this.jdField_a_of_type_ComTencentMobileqqApolloApolloEngine));
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, "[onDestroy]");
    }
    b();
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread.interrupt();
      this.jdField_a_of_type_AndroidOsHandlerThread.quit();
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, "[onGetDown]");
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
    this.f = 0;
    a(2);
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, "[onStandUp]");
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(4);
    this.f = 0;
    a(4);
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, "[onWaiting]");
    }
    this.f = 0;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
    a(1);
  }
  
  public void g()
  {
    a(new pql("dispose();", this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock, this.jdField_a_of_type_ComTencentMobileqqApolloApolloEngine));
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, "[onThinking]");
    }
    this.f = 0;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(3);
    a(3);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 15) {
      b();
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\ApolloRenderDriver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */