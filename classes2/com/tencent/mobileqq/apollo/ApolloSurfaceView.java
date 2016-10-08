package com.tencent.mobileqq.apollo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.opengl.GLSurfaceView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.barrage.ApolloBarrageUtil;
import com.tencent.mobileqq.apollo.barrage.BarrageUI;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
import com.tencent.mobileqq.apollo.view.ChatApolloViewListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import pqm;
import pqn;
import pqo;

public class ApolloSurfaceView
  extends GLSurfaceView
  implements ITriggerRenderCallback
{
  public static final float a = 20.0F;
  public static final int a = 10;
  public static final String a = "ApolloSurfaceView";
  public ApolloRender a;
  protected ApolloRenderDriver a;
  protected ApolloRenderInterfaceImpl a;
  private OnApolloViewListener a;
  protected WeakReference a;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private float c;
  private float d;
  
  public ApolloSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Int = -1;
    this.jdField_b_of_type_Float = super.getContext().getResources().getDisplayMetrics().density;
    super.setEGLContextClientVersion(2);
    super.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
    super.setZOrderOnTop(true);
    super.getHolder().setFormat(-2);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloSurfaceView", 2, "[ApolloSurfaceView] constructor");
    }
  }
  
  public float a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloSurfaceView", 2, "[onGetLittleManHeight]");
    }
    ReentrantLock localReentrantLock = ApolloActionManager.a().a();
    float f1 = 0.0F;
    localReentrantLock.lock();
    try
    {
      RectF localRectF = this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.a().a();
      if (localRectF != null)
      {
        float f2 = localRectF.top + localRectF.bottom;
        f1 = f2;
        if (QLog.isColorLevel())
        {
          QLog.d("ApolloSurfaceView", 2, "left:" + localRectF.left + ",top:" + localRectF.top + ",right:" + localRectF.right + ",bottom:" + localRectF.bottom);
          f1 = f2;
        }
      }
      localReentrantLock.unlock();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloSurfaceView", 2, "height:" + f1);
      }
      return f1;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.a.get();
  }
  
  public RectF a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloSurfaceView", 2, "[onGetDressRect], dressName:" + paramString);
    }
    RectF localRectF = new RectF();
    ReentrantLock localReentrantLock = ApolloActionManager.a().a();
    localReentrantLock.lock();
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender != null)
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.a().a(paramString);
        if (paramString != null)
        {
          paramString.left *= this.jdField_b_of_type_Float;
          paramString.top *= this.jdField_b_of_type_Float;
          paramString.right *= this.jdField_b_of_type_Float;
          paramString.bottom *= this.jdField_b_of_type_Float;
          localRectF.left = paramString.left;
          localRectF.bottom = paramString.top;
          paramString.top += paramString.bottom;
          float f = paramString.right;
          localRectF.right = (paramString.left + f);
          if (QLog.isColorLevel()) {
            QLog.d("ApolloSurfaceView", 2, "x:" + localRectF.left + ",deltaY:" + localRectF.top + ",width:" + localRectF.right + ",height:" + localRectF.bottom);
          }
        }
      }
      return localRectF;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public ApolloRender a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender;
  }
  
  public ApolloRenderDriver a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver;
  }
  
  public ApolloRenderInterfaceImpl a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderInterfaceImpl;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.a();
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloSurfaceView", 2, "[onApolloActionDone]");
    }
    if (!ApolloActionManager.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    ApolloActionManager localApolloActionManager;
    do
    {
      return;
      localApolloActionManager = ApolloActionManager.a();
      if ((!localApolloActionManager.jdField_a_of_type_JavaUtilVector.contains(localApolloActionManager.jdField_f_of_type_JavaLangString)) && (!localApolloActionManager.jdField_a_of_type_JavaUtilVector.contains(localApolloActionManager.g))) {
        break;
      }
    } while (localApolloActionManager.a(true, true) == null);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloSurfaceView", 2, "load new role.");
    }
    if ((paramInt != 0) && (paramInt == 21))
    {
      a().h();
      return;
    }
    a().d();
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.b(paramInt, paramString);
    }
  }
  
  public void a(OnApolloViewListener paramOnApolloViewListener)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloSurfaceView", 2, "[init], callback:" + paramOnApolloViewListener);
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloOnApolloViewListener = paramOnApolloViewListener;
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender = new ApolloRender(this.jdField_b_of_type_Float, this.jdField_a_of_type_ComTencentMobileqqApolloOnApolloViewListener);
      super.setEGLContextFactory(new pqo(this, null));
      super.setRenderer(this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender);
      super.setRenderMode(0);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver = new ApolloRenderDriver(this, this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.a());
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderInterfaceImpl = new ApolloRenderInterfaceImpl(this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver, this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender);
      return;
    }
    finally {}
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (!TextUtils.isEmpty(paramString2)))
    {
      BarrageUI localBarrageUI = (BarrageUI)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localBarrageUI != null) {
        ApolloBarrageUtil.a(localBarrageUI, BaseApplicationImpl.getContext(), paramString1, paramString2, paramBoolean);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      BarrageUI localBarrageUI = (BarrageUI)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localBarrageUI != null) {
        localBarrageUI.a(paramBoolean);
      }
    }
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloSurfaceView", 2, "[getRoleNum]");
    }
    ReentrantLock localReentrantLock = ApolloActionManager.a().a();
    localReentrantLock.lock();
    try
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.a().a();
      localReentrantLock.unlock();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloSurfaceView", 2, "roleNum:" + i);
      }
      return i;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public void b()
  {
    setStatus(9);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloOnApolloViewListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloOnApolloViewListener.a(a());
    }
  }
  
  public void c()
  {
    requestRender();
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloSurfaceView", 2, "[onApolloGetDown], mIsActionPlaying:1" + ApolloActionManager.a().jdField_c_of_type_Boolean);
    }
    if (a() != 8) {
      ThreadManager.a(new pqm(this), 5, null, true);
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloSurfaceView", 2, "[onApolloGetUp]");
    }
    if (1 != a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloSurfaceView", 2, "close or hide or action status.");
      }
      return;
    }
    ThreadManager.a(new pqn(this), 5, null, true);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = 0.0F;
    boolean bool = false;
    float f4;
    float f2;
    float f5;
    float f3;
    int i;
    switch (paramMotionEvent.getAction())
    {
    default: 
      bool = super.onTouchEvent(paramMotionEvent);
    case 0: 
      do
      {
        return bool;
        this.jdField_c_of_type_Float = paramMotionEvent.getY();
        this.d = paramMotionEvent.getX();
        f4 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        f5 = super.getBottom() - super.getTop() - f2;
      } while (this.jdField_a_of_type_ComTencentMobileqqApolloOnApolloViewListener == null);
      paramMotionEvent = ApolloActionManager.a();
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloOnApolloViewListener instanceof ChatApolloViewListener)) {
        if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.a.get() == 1)
        {
          f3 = paramMotionEvent.e + 15.0F * this.jdField_b_of_type_Float;
          i = paramMotionEvent.a();
          if (i != 0) {
            break label233;
          }
          f1 = paramMotionEvent.d;
          f2 = this.jdField_b_of_type_Float * (f1 - 25.0F);
          f1 = (paramMotionEvent.d + 25.0F) * this.jdField_b_of_type_Float;
        }
      }
      break;
    }
    for (;;)
    {
      label174:
      if ((f4 >= f2) && (f4 <= f1) && (f5 >= 10.0F) && (f5 <= f3))
      {
        this.jdField_b_of_type_Int = 100;
        label211:
        if (this.jdField_b_of_type_Int < 0) {
          break label370;
        }
        bool = true;
      }
      label233:
      label340:
      label370:
      for (;;)
      {
        return bool;
        f3 = paramMotionEvent.jdField_f_of_type_Float;
        break;
        if (1 != i) {
          break label484;
        }
        f1 = paramMotionEvent.jdField_b_of_type_Float;
        f2 = this.jdField_b_of_type_Float * (f1 - 25.0F);
        f1 = (paramMotionEvent.jdField_c_of_type_Float + 25.0F) * this.jdField_b_of_type_Float;
        break label174;
        this.jdField_b_of_type_Int = -1;
        break label211;
        paramMotionEvent = paramMotionEvent.a();
        paramMotionEvent.lock();
        try
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.a() != null)) {
            if (!this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.a().a(f4, f5, "Bubble")) {
              break label340;
            }
          }
          for (this.jdField_b_of_type_Int = 1000;; this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.a().a(f4, f5))
          {
            paramMotionEvent.unlock();
            break;
          }
          bool = false;
        }
        finally
        {
          paramMotionEvent.unlock();
        }
      }
      if ((this.jdField_b_of_type_Int < 0) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.a()) || (this.jdField_a_of_type_ComTencentMobileqqApolloOnApolloViewListener == null)) {
        break;
      }
      f1 = paramMotionEvent.getY();
      f2 = this.jdField_c_of_type_Float;
      f3 = paramMotionEvent.getX();
      f4 = this.d;
      if ((Math.abs(f1 - f2) > 20.0F) || (Math.abs(f3 - f4) > 20.0F)) {
        break;
      }
      if (this.jdField_b_of_type_Int == 1000)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloOnApolloViewListener.a(0);
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloOnApolloViewListener.a(1);
      break;
      label484:
      f2 = 0.0F;
    }
  }
  
  public void setBarrageView(BarrageUI paramBarrageUI)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBarrageUI);
  }
  
  public void setNodeHidden(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.a(paramString, paramInt);
    }
  }
  
  public void setStatus(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.a.set(paramInt);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\ApolloSurfaceView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */