package com.tencent.av.opengl.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Process;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.effects.AbstractEffects;
import com.tencent.av.opengl.glrenderer.GLCanvas;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.av.opengl.program.TextureProgramFactory;
import com.tencent.av.opengl.texture.BasicTexture;
import com.tencent.av.opengl.texture.UploadedTexture;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import gjy;
import gjz;
import gka;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11;

public class GLRootView
  extends GLSurfaceView
  implements GLSurfaceView.Renderer
{
  static Context jdField_a_of_type_AndroidContentContext;
  private static final String jdField_a_of_type_JavaLangString = "GLRootView";
  private static final boolean jdField_b_of_type_Boolean = false;
  private static final boolean jdField_c_of_type_Boolean = false;
  private static final int jdField_d_of_type_Int = 1;
  private static final int jdField_e_of_type_Int = 2;
  int jdField_a_of_type_Int = 33;
  long jdField_a_of_type_Long = 0L;
  public AbstractEffects a;
  private GLCanvas jdField_a_of_type_ComTencentAvOpenglGlrendererGLCanvas;
  protected GLView a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new gjy(this);
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private final Condition jdField_a_of_type_JavaUtilConcurrentLocksCondition = this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.newCondition();
  private final ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
  private GL11 jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long;
  private int jdField_c_of_type_Int;
  private volatile boolean jdField_d_of_type_Boolean;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = 2;
  private boolean jdField_f_of_type_Boolean;
  private boolean g = true;
  
  public GLRootView(Context paramContext)
  {
    this(paramContext, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    GraphicRenderMgr.loadSo();
    jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    TextureProgram.setAppContext(jdField_a_of_type_AndroidContentContext);
  }
  
  public GLRootView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentAvOpenglEffectsAbstractEffects = null;
    CameraUtils.a(paramContext).a = this;
    GraphicRenderMgr.loadSo();
    jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    TextureProgram.setAppContext(jdField_a_of_type_AndroidContentContext);
    if (isInEditMode()) {
      return;
    }
    this.jdField_f_of_type_Int |= 0x1;
    setBackgroundDrawable(null);
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.B, 0, 0);
      if (paramAttributeSet == null) {}
    }
    try
    {
      this.jdField_a_of_type_Boolean = paramAttributeSet.getBoolean(0, false);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("GLRootView", 2, "GLRootView e = " + localException);
        }
        paramAttributeSet.recycle();
      }
    }
    finally
    {
      paramAttributeSet.recycle();
    }
    setEGLContextClientVersion(Utils.a(paramContext));
    if (this.jdField_a_of_type_Boolean) {
      setEGLConfigChooser(8, 8, 8, 8, 16, 0);
    }
    for (;;)
    {
      setRenderer(this);
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      getHolder().setFormat(-3);
      return;
      if (Utils.b) {
        setEGLConfigChooser(8, 8, 8, 0, 0, 0);
      } else {
        setEGLConfigChooser(5, 6, 5, 0, 0, 0);
      }
    }
    if (Utils.b)
    {
      getHolder().setFormat(3);
      return;
    }
    getHolder().setFormat(4);
  }
  
  public static Context a()
  {
    return jdField_a_of_type_AndroidContentContext;
  }
  
  private boolean a(GL10 paramGL10)
  {
    return a(paramGL10, "GL_OES_framebuffer_object");
  }
  
  private boolean a(GL10 paramGL10, String paramString)
  {
    return (" " + paramGL10.glGetString(7939) + " ").indexOf(" " + paramString + " ") >= 0;
  }
  
  private void h()
  {
    super.requestRender();
  }
  
  private void i()
  {
    this.jdField_f_of_type_Int &= 0xFFFFFFFD;
    int i = getWidth();
    int j = getHeight();
    if ((this.jdField_a_of_type_ComTencentAvOpenglUiGLView != null) && (i != 0) && (j != 0)) {
      this.jdField_a_of_type_ComTencentAvOpenglUiGLView.b(0, 0, i, j);
    }
  }
  
  private void j()
  {
    long l = System.nanoTime();
    if (this.jdField_b_of_type_Long == 0L) {
      this.jdField_b_of_type_Long = l;
    }
    for (;;)
    {
      this.c += 1;
      return;
      if (l - this.jdField_b_of_type_Long > 1000000000L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GLRootView", 2, "fps: " + this.c * 1.0E9D / (l - this.jdField_b_of_type_Long));
        }
        this.jdField_b_of_type_Long = l;
        this.c = 0;
      }
    }
  }
  
  protected void a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      if (localIterator.hasNext()) {
        ((GLRootView.OnEvent)localIterator.next()).a();
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(GL10 paramGL10)
  {
    this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLCanvas.d();
    UploadedTexture.g();
    this.d = false;
    if ((this.jdField_f_of_type_Int & 0x2) != 0) {
      i();
    }
    if (this.jdField_a_of_type_ComTencentAvOpenglUiGLView != null) {
      this.jdField_a_of_type_ComTencentAvOpenglUiGLView.c(this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLCanvas);
    }
    for (;;)
    {
      if (UploadedTexture.g()) {
        requestRender();
      }
      return;
      this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLCanvas.a();
    }
  }
  
  public void b()
  {
    h();
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    try
    {
      if (this.jdField_a_of_type_ComTencentAvOpenglUiGLView != null)
      {
        i = this.jdField_f_of_type_Int;
        if ((i & 0x2) == 0) {}
      }
      else
      {
        return;
      }
      int i = this.jdField_f_of_type_Int;
      if ((i & 0x1) == 0) {
        return;
      }
      this.jdField_f_of_type_Int |= 0x2;
      requestRender();
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    if (!isEnabled()) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    if ((i == 3) || (i == 1)) {
      this.jdField_f_of_type_Boolean = false;
    }
    do
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
      boolean bool1 = bool2;
      try
      {
        if (this.jdField_a_of_type_ComTencentAvOpenglUiGLView != null)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_ComTencentAvOpenglUiGLView.b(paramMotionEvent)) {
            bool1 = true;
          }
        }
        if ((i == 0) && (bool1)) {
          this.jdField_f_of_type_Boolean = true;
        }
        return bool1;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      }
    } while ((this.jdField_f_of_type_Boolean) || (i == 0));
    return false;
  }
  
  public void e()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
  }
  
  public void f()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    this.e = true;
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
  }
  
  protected void finalize()
  {
    try
    {
      this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLCanvas.a().a();
      try
      {
        g();
        return;
      }
      finally
      {
        super.finalize();
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    this.e = false;
    this.jdField_a_of_type_JavaUtilConcurrentLocksCondition.signalAll();
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
  }
  
  protected void onDetachedFromWindow()
  {
    g();
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      GLRootView.RendererCallback localRendererCallback = (GLRootView.RendererCallback)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localRendererCallback != null) {
        localRendererCallback.a();
      }
    }
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    AnimationTime.a();
    a();
    if (this.jdField_a_of_type_Boolean) {}
    for (float f1 = 0.0F;; f1 = 1.0F)
    {
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, f1);
      GLES20.glClear(16640);
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
      if (this.jdField_a_of_type_ComTencentAvOpenglEffectsAbstractEffects != null) {
        this.jdField_a_of_type_ComTencentAvOpenglEffectsAbstractEffects.a(this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLCanvas);
      }
      while (this.e) {
        this.jdField_a_of_type_JavaUtilConcurrentLocksCondition.awaitUninterruptibly();
      }
    }
    label111:
    try
    {
      if (this.jdField_b_of_type_Int > 0) {
        this.jdField_b_of_type_Int -= 1;
      }
    }
    finally {}
    try
    {
      a(paramGL10);
    }
    catch (Exception paramGL10)
    {
      paramGL10.printStackTrace();
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      break label111;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
    if ((this.g) && (this.jdField_a_of_type_ComTencentAvOpenglUiGLView != null))
    {
      this.g = false;
      this.jdField_a_of_type_ComTencentAvOpenglUiGLView.c();
    }
    if (this.jdField_a_of_type_ComTencentAvOpenglEffectsAbstractEffects != null) {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsAbstractEffects.b(this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLCanvas);
    }
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramBoolean) {
      c();
    }
  }
  
  public void onPause()
  {
    g();
    if (this.jdField_a_of_type_ComTencentAvOpenglEffectsAbstractEffects != null) {
      queueEvent(new gjz(this));
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.d = false;
    CameraUtils.a(jdField_a_of_type_AndroidContentContext).a = this;
    if (this.jdField_a_of_type_ComTencentAvOpenglEffectsAbstractEffects != null) {
      setOnEvent(new gka(this));
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GLRootView", 2, "onSurfaceChanged: " + paramInt1 + "x" + paramInt2 + ", gl10: " + paramGL10.toString());
    }
    Process.setThreadPriority(-4);
    this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLCanvas.a(paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLCanvas.a(paramInt1, paramInt2);
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      paramGL10 = (GLRootView.RendererCallback)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramGL10 != null) {
        paramGL10.b(this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLCanvas);
      }
    }
  }
  
  /* Error */
  public void onSurfaceCreated(GL10 paramGL10, javax.microedition.khronos.egl.EGLConfig paramEGLConfig)
  {
    // Byte code:
    //   0: aload_1
    //   1: checkcast 434	javax/microedition/khronos/opengles/GL11
    //   4: astore_1
    //   5: aload_0
    //   6: getfield 436	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11	Ljavax/microedition/khronos/opengles/GL11;
    //   9: ifnull +48 -> 57
    //   12: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15: ifeq +42 -> 57
    //   18: ldc 11
    //   20: iconst_2
    //   21: new 171	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   28: ldc_w 438
    //   31: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_0
    //   35: getfield 436	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11	Ljavax/microedition/khronos/opengles/GL11;
    //   38: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   41: ldc_w 440
    //   44: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload_1
    //   48: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 253	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: aload_0
    //   58: getfield 78	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   61: invokevirtual 300	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   64: aload_0
    //   65: aload_1
    //   66: putfield 436	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11	Ljavax/microedition/khronos/opengles/GL11;
    //   69: aload_0
    //   70: invokevirtual 443	com/tencent/av/opengl/ui/GLRootView:getContext	()Landroid/content/Context;
    //   73: invokevirtual 54	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   76: invokestatic 143	com/tencent/av/opengl/utils/Utils:a	(Landroid/content/Context;)I
    //   79: iconst_2
    //   80: if_icmplt +116 -> 196
    //   83: new 445	com/tencent/av/opengl/glrenderer/GLES20Canvas
    //   86: dup
    //   87: invokespecial 446	com/tencent/av/opengl/glrenderer/GLES20Canvas:<init>	()V
    //   90: astore_1
    //   91: aload_0
    //   92: aload_1
    //   93: putfield 278	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_ComTencentAvOpenglGlrendererGLCanvas	Lcom/tencent/av/opengl/glrenderer/GLCanvas;
    //   96: invokestatic 449	com/tencent/av/opengl/texture/BasicTexture:d	()V
    //   99: aload_0
    //   100: getfield 78	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   103: invokevirtual 303	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   106: aload_0
    //   107: getfield 278	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_ComTencentAvOpenglGlrendererGLCanvas	Lcom/tencent/av/opengl/glrenderer/GLCanvas;
    //   110: invokeinterface 323 1 0
    //   115: invokevirtual 326	com/tencent/av/opengl/program/TextureProgramFactory:a	()V
    //   118: aload_0
    //   119: iconst_0
    //   120: invokevirtual 452	com/tencent/av/opengl/ui/GLRootView:setRenderMode	(I)V
    //   123: aload_0
    //   124: getfield 339	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   127: ifnull +28 -> 155
    //   130: aload_0
    //   131: getfield 339	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   134: invokevirtual 344	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   137: checkcast 346	com/tencent/av/opengl/ui/GLRootView$RendererCallback
    //   140: astore_1
    //   141: aload_1
    //   142: ifnull +13 -> 155
    //   145: aload_1
    //   146: aload_0
    //   147: getfield 278	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_ComTencentAvOpenglGlrendererGLCanvas	Lcom/tencent/av/opengl/glrenderer/GLCanvas;
    //   150: invokeinterface 453 2 0
    //   155: getstatic 56	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   158: invokestatic 108	com/tencent/av/camera/CameraUtils:a	(Landroid/content/Context;)Lcom/tencent/av/camera/CameraUtils;
    //   161: aload_0
    //   162: putfield 111	com/tencent/av/camera/CameraUtils:a	Landroid/opengl/GLSurfaceView;
    //   165: aload_0
    //   166: getfield 88	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_ComTencentAvOpenglEffectsAbstractEffects	Lcom/tencent/av/opengl/effects/AbstractEffects;
    //   169: ifnull +26 -> 195
    //   172: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   175: ifeq +13 -> 188
    //   178: getstatic 457	com/tencent/av/opengl/effects/EffectsRenderController:a	Ljava/lang/String;
    //   181: iconst_2
    //   182: ldc_w 459
    //   185: invokestatic 253	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   188: aload_0
    //   189: getfield 88	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_ComTencentAvOpenglEffectsAbstractEffects	Lcom/tencent/av/opengl/effects/AbstractEffects;
    //   192: invokevirtual 460	com/tencent/av/opengl/effects/AbstractEffects:a	()V
    //   195: return
    //   196: new 462	com/tencent/av/opengl/glrenderer/GLES11Canvas
    //   199: dup
    //   200: aload_1
    //   201: invokespecial 465	com/tencent/av/opengl/glrenderer/GLES11Canvas:<init>	(Ljavax/microedition/khronos/opengles/GL11;)V
    //   204: astore_1
    //   205: goto -114 -> 91
    //   208: astore_1
    //   209: aload_0
    //   210: getfield 78	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   213: invokevirtual 303	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   216: aload_1
    //   217: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	this	GLRootView
    //   0	218	1	paramGL10	GL10
    //   0	218	2	paramEGLConfig	javax.microedition.khronos.egl.EGLConfig
    // Exception table:
    //   from	to	target	type
    //   64	91	208	finally
    //   91	99	208	finally
    //   196	205	208	finally
  }
  
  public void requestRender()
  {
    if (this.d) {
      return;
    }
    this.d = true;
    long l = SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long;
    if ((l > 0L) && (l < this.jdField_a_of_type_Int))
    {
      try
      {
        if (this.jdField_b_of_type_Int >= 2) {
          return;
        }
      }
      finally {}
      this.jdField_b_of_type_Int += 1;
      super.postDelayed(this.jdField_a_of_type_JavaLangRunnable, l);
      return;
    }
    if (Utils.L)
    {
      postOnAnimation(this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    super.requestRender();
  }
  
  public void setContentPane(GLView paramGLView)
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglUiGLView == paramGLView) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentAvOpenglUiGLView != null)
      {
        if (this.jdField_f_of_type_Boolean)
        {
          long l = SystemClock.uptimeMillis();
          MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
          this.jdField_a_of_type_ComTencentAvOpenglUiGLView.b(localMotionEvent);
          localMotionEvent.recycle();
          this.jdField_f_of_type_Boolean = false;
        }
        this.jdField_a_of_type_ComTencentAvOpenglUiGLView.w();
        BasicTexture.c();
      }
      this.jdField_a_of_type_ComTencentAvOpenglUiGLView = paramGLView;
    } while (paramGLView == null);
    paramGLView.a(this);
    c();
  }
  
  public void setEffects(AbstractEffects paramAbstractEffects)
  {
    this.jdField_a_of_type_ComTencentAvOpenglEffectsAbstractEffects = paramAbstractEffects;
  }
  
  public void setGlAlpha(float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLCanvas != null) {
      this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLCanvas.a(paramFloat);
    }
  }
  
  public void setMaxFps(int paramInt)
  {
    if (paramInt > 0) {
      this.jdField_a_of_type_Int = ((int)Math.ceil(1000.0F / paramInt));
    }
    if (this.jdField_a_of_type_Int < 16) {
      this.jdField_a_of_type_Int = 16;
    }
    if (this.jdField_a_of_type_Int > 200) {
      this.jdField_a_of_type_Int = 200;
    }
  }
  
  public void setOnEvent(GLRootView.OnEvent paramOnEvent)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.add(paramOnEvent);
      requestRender();
      return;
    }
  }
  
  public void setRenderCallback(GLRootView.RendererCallback paramRendererCallback)
  {
    if (paramRendererCallback == null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramRendererCallback);
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    g();
    super.surfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    g();
    super.surfaceCreated(paramSurfaceHolder);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    g();
    super.surfaceDestroyed(paramSurfaceHolder);
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      paramSurfaceHolder = (GLRootView.RendererCallback)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramSurfaceHolder != null) {
        paramSurfaceHolder.a();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\opengl\ui\GLRootView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */