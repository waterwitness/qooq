package com.hiar.sdk.renderer;

import ahh;
import ahi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.widget.TextView;
import com.hiar.sdk.HSARToolkit;
import com.tencent.mobileqq.ar.ARDeviceController;
import com.tencent.mobileqq.ar.ARFragment;
import com.tencent.mobileqq.ar.ARGLSurfaceView;
import com.tencent.mobileqq.ar.ARListener;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.ar.ARRender;
import com.tencent.mobileqq.ar.ARScene3DScene;
import com.tencent.mobileqq.ar.ARSceneResConfig;
import com.tencent.mobileqq.ar.ARTarget;
import com.tencent.mobileqq.ar.FramePerformanceMonitor;
import com.tencent.mobileqq.ar.ReportUtil;
import com.tencent.mobileqq.ar.TraceUtil;
import com.tencent.mobileqq.ar.model.ArResourceInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class HSRenderer
  implements ARRender
{
  public static float a = 0.0F;
  public static int a = 0;
  static long jdField_a_of_type_Long = 0L;
  public static final boolean a = true;
  public static float[] a;
  public static int b;
  static int c = 1;
  Handler jdField_a_of_type_AndroidOsHandler;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private CameraRenderer jdField_a_of_type_ComHiarSdkRendererCameraRenderer;
  public ARFragment a;
  ARGLSurfaceView jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView;
  public ARListener a;
  public ARScene3DScene a;
  public FramePerformanceMonitor a;
  public HashMap a;
  public int d = 1;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Float = 1.0F;
  }
  
  public HSRenderer(Context paramContext, ARFragment paramARFragment, ARGLSurfaceView paramARGLSurfaceView, Handler paramHandler, ARListener paramARListener)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComHiarSdkRendererCameraRenderer = new CameraRenderer(paramARGLSurfaceView);
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView = paramARGLSurfaceView;
    this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor = new FramePerformanceMonitor();
    this.jdField_a_of_type_ComTencentMobileqqArARFragment = paramARFragment;
    this.jdField_a_of_type_ComTencentMobileqqArARListener = paramARListener;
  }
  
  private void a(GL10 paramGL10)
  {
    HSARToolkit localHSARToolkit = HSARToolkit.a();
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_ComHiarSdkRendererCameraRenderer.onDrawFrame(paramGL10);
    long l2 = System.currentTimeMillis();
    if (HSARToolkit.a().b()) {
      ReportUtil.a("camRender", 0, l2 - l1);
    }
    ARScene3DScene localARScene3DScene = this.jdField_a_of_type_ComTencentMobileqqArARScene3DScene;
    if ((localARScene3DScene != null) && (localARScene3DScene.a()))
    {
      GLES20.glEnable(2929);
      localHSARToolkit.a(localARScene3DScene, paramGL10);
      GLES20.glDisable(2929);
    }
    l2 = System.currentTimeMillis();
    TraceUtil.b("hsarToolkit.mState.renderWidgets cost = " + (l2 - l1));
  }
  
  public ARScene3DScene a(ARTarget paramARTarget)
  {
    String str = paramARTarget.a.f;
    if ((!new File(str).exists()) && (paramARTarget.a.c == 1)) {
      str = paramARTarget.a.g + File.separator + "basic.xml";
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HSRender", 2, "createOrGetScene md5 = " + paramARTarget.a.e);
      }
      ARScene3DScene localARScene3DScene2 = (ARScene3DScene)this.jdField_a_of_type_JavaUtilHashMap.get(paramARTarget.a.e);
      ARScene3DScene localARScene3DScene1 = localARScene3DScene2;
      if (localARScene3DScene2 == null)
      {
        localARScene3DScene1 = new ARScene3DScene(this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView, this, paramARTarget);
        localARScene3DScene1.a(ARSceneResConfig.a(paramARTarget.a.g, str));
        this.jdField_a_of_type_JavaUtilHashMap.put(paramARTarget.a.e, localARScene3DScene1);
      }
      return localARScene3DScene1;
    }
  }
  
  public void a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqArARFragment.a.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localArrayList.add(str);
      localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqArARFragment.a.get(str));
    }
    TraceUtil.a("ARActivity.onSurfaceCreated");
    localObject = this.jdField_a_of_type_ComTencentMobileqqArARScene3DScene;
    if (localObject != null) {
      ((ARScene3DScene)localObject).a().handleOnSurfaceCreate(localArrayList, jdField_a_of_type_Int, b);
    }
    TraceUtil.a("ARActivity.onSurfaceCreated.End");
    HSARToolkit.a().jdField_a_of_type_Int = ARDeviceController.a().b();
    if (ARDeviceController.a().e())
    {
      this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor.a(new ahh(this));
      this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor.a();
    }
    for (;;)
    {
      switch (HSARToolkit.a().jdField_a_of_type_Int)
      {
      default: 
        return;
        ReportUtil.a("render_quality", HSARToolkit.a().jdField_a_of_type_Int);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqArARFragment.a("config_light", "1");
    this.jdField_a_of_type_ComTencentMobileqqArARFragment.a("config_shadow", "1");
    return;
    this.jdField_a_of_type_ComTencentMobileqqArARFragment.a("config_light", "0");
    this.jdField_a_of_type_ComTencentMobileqqArARFragment.a("config_shadow", "0");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComHiarSdkRendererCameraRenderer.a(paramInt1, paramInt2);
  }
  
  public void a(int paramInt, SurfaceTexture paramSurfaceTexture)
  {
    this.jdField_a_of_type_ComHiarSdkRendererCameraRenderer.a(paramInt, paramSurfaceTexture);
  }
  
  public void a(int paramInt, ARTarget paramARTarget)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HSRender", 2, "onARStateChanged state = " + paramInt + ", " + paramARTarget);
    }
    if (paramARTarget != null)
    {
      ARScene3DScene localARScene3DScene = a(paramARTarget);
      localARScene3DScene.jdField_a_of_type_Int = jdField_a_of_type_Int;
      localARScene3DScene.b = b;
      localARScene3DScene.a(paramInt, paramARTarget);
      paramARTarget = this.jdField_a_of_type_ComTencentMobileqqArARScene3DScene;
      this.jdField_a_of_type_ComTencentMobileqqArARScene3DScene = localARScene3DScene;
      this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.queueEvent(new ahi(this, paramARTarget, localARScene3DScene));
    }
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext()) {
      ((ARScene3DScene)localIterator.next()).b();
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_ComTencentMobileqqArARScene3DScene = null;
    this.jdField_a_of_type_ComHiarSdkRendererCameraRenderer.f();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArARScene3DScene != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARScene3DScene.h();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArARScene3DScene != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARScene3DScene.i();
    }
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArARScene3DScene != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARScene3DScene.g();
    }
    long l1 = System.currentTimeMillis();
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glDepthMask(true);
    GLES20.glColorMask(true, true, true, true);
    GLES20.glClear(16640);
    GLES20.glDisable(2929);
    a(paramGL10);
    long l2 = System.currentTimeMillis();
    GLES20.glFinish();
    l2 = System.currentTimeMillis() - l2;
    TraceUtil.b("HSRenderer.onDrawFrame::GLES20.glFinish() cost = " + l2);
    paramGL10 = HSARToolkit.a();
    long l3 = System.currentTimeMillis();
    TraceUtil.b("HSRenderer.onDrawFrame cost = " + (l3 - l1));
    HSARToolkit.a().f = ((int)(l3 - l1));
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    l1 = l3 - l1;
    if (paramGL10.b())
    {
      this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor.a(l1);
      ReportUtil.a("glRender", paramGL10.jdField_a_of_type_Int, l2);
      ReportUtil.a("render", paramGL10.jdField_a_of_type_Int, l1);
    }
    jdField_a_of_type_Long = l1 + jdField_a_of_type_Long;
    c += 1;
    if (c % 100 == 0) {
      TraceUtil.b("renderTime = " + jdField_a_of_type_Long / c);
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    jdField_a_of_type_Int = paramInt1;
    b = paramInt2;
    this.jdField_a_of_type_ComHiarSdkRendererCameraRenderer.onSurfaceChanged(paramGL10, paramInt1, paramInt2);
    GLES20.glDisable(2884);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    ARDeviceController.a().a(paramGL10.glGetString(7937));
    this.jdField_a_of_type_ComHiarSdkRendererCameraRenderer.onSurfaceCreated(paramGL10, paramEGLConfig);
    paramGL10.glClearColor(0.0F, 0.0F, 0.0F, 0.5F);
    paramEGLConfig = new StringBuilder();
    if (QLog.isColorLevel()) {
      QLog.d("GPU_INFO", 2, "GL_RENDERER = " + paramGL10.glGetString(7937));
    }
    paramEGLConfig.append("GL_RENDERER = " + paramGL10.glGetString(7937));
    paramEGLConfig.append('\n');
    if (QLog.isColorLevel()) {
      QLog.d("GPU_INFO", 2, "GL_VENDOR = " + paramGL10.glGetString(7936));
    }
    paramEGLConfig.append("GL_VENDOR = " + paramGL10.glGetString(7936));
    paramEGLConfig.append('\n');
    if (QLog.isColorLevel()) {
      QLog.d("GPU_INFO", 2, "GL_VERSION = " + paramGL10.glGetString(7938));
    }
    paramEGLConfig.append("GL_VERSION = " + paramGL10.glGetString(7938));
    paramEGLConfig.append('\n');
    Object localObject = IntBuffer.allocate(20);
    paramGL10.glGetIntegerv(36347, (IntBuffer)localObject);
    paramEGLConfig.append("GL_MAX_VERTEX_UNIFORM_VECTORS = " + ((IntBuffer)localObject).get());
    paramEGLConfig.append('\n');
    localObject = IntBuffer.allocate(20);
    paramGL10.glGetIntegerv(35661, (IntBuffer)localObject);
    paramEGLConfig.append("GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS = " + ((IntBuffer)localObject).get());
    paramEGLConfig.append('\n');
    localObject = IntBuffer.allocate(20);
    paramGL10.glGetIntegerv(34076, (IntBuffer)localObject);
    paramEGLConfig.append("GL_MAX_CUBE_MAP_TEXTURE_SIZE = " + ((IntBuffer)localObject).get());
    paramEGLConfig.append('\n');
    localObject = IntBuffer.allocate(20);
    paramGL10.glGetIntegerv(34024, (IntBuffer)localObject);
    paramEGLConfig.append("GL_MAX_RENDERBUFFER_SIZE = " + ((IntBuffer)localObject).get());
    paramEGLConfig.append('\n');
    localObject = IntBuffer.allocate(20);
    paramGL10.glGetIntegerv(34930, (IntBuffer)localObject);
    paramEGLConfig.append("GL_MAX_TEXTURE_IMAGE_UNITS = " + ((IntBuffer)localObject).get());
    paramEGLConfig.append('\n');
    localObject = IntBuffer.allocate(20);
    paramGL10.glGetIntegerv(3379, (IntBuffer)localObject);
    paramEGLConfig.append("GL_MAX_TEXTURE_SIZE = " + ((IntBuffer)localObject).get());
    paramEGLConfig.append('\n');
    localObject = IntBuffer.allocate(20);
    paramGL10.glGetIntegerv(36349, (IntBuffer)localObject);
    paramEGLConfig.append("GL_MAX_FRAGMENT_UNIFORM_VECTORS = " + ((IntBuffer)localObject).get());
    paramEGLConfig.append('\n');
    localObject = IntBuffer.allocate(20);
    paramGL10.glGetIntegerv(34921, (IntBuffer)localObject);
    paramEGLConfig.append("GL_MAX_VERTEX_ATTRIBS = " + ((IntBuffer)localObject).get());
    paramEGLConfig.append('\n');
    localObject = IntBuffer.allocate(20);
    paramGL10.glGetIntegerv(36348, (IntBuffer)localObject);
    paramEGLConfig.append("GL_MAX_VARYING_VECTORS = " + ((IntBuffer)localObject).get());
    paramEGLConfig.append('\n');
    localObject = IntBuffer.allocate(20);
    paramGL10.glGetIntegerv(36349, (IntBuffer)localObject);
    paramEGLConfig.append("GL_MAX_FRAGMENT_UNIFORM_VECTORS = " + ((IntBuffer)localObject).get());
    paramEGLConfig.append('\n');
    paramEGLConfig = new StringBuilder();
    localObject = paramGL10.glGetString(7939).split(" ");
    int i = 0;
    while (i < localObject.length)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("GPU_INFO", 2, "GL_EXTENSIONS = " + localObject[i]);
        paramEGLConfig.append(localObject[i] + " ");
      }
      i += 1;
    }
    ReportUtil.a(paramGL10.glGetString(7937), paramGL10.glGetString(7936), paramGL10.glGetString(7938), paramEGLConfig.toString());
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\hiar\sdk\renderer\HSRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */