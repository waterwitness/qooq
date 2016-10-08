package com.tencent.mobileqq.ar;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import qoz;
import qpa;
import qpb;
import qpc;

public class ARScene
{
  public int a;
  public long a;
  public ARGLSurfaceView a;
  public ARSceneResConfig a;
  public ArrayList a;
  public int b;
  
  public ARScene(ARGLSurfaceView paramARGLSurfaceView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView = paramARGLSurfaceView;
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine", 2, getClass().getSimpleName() + " preloadScene");
    }
    long l1 = System.currentTimeMillis();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqArARSceneResConfig.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      a(this.jdField_a_of_type_ComTencentMobileqqArARSceneResConfig.jdField_a_of_type_JavaLangString + (String)localObject2);
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqArARSceneResConfig.b.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ARSceneResConfig.Texture)((Iterator)localObject1).next();
      a(this.jdField_a_of_type_ComTencentMobileqqArARSceneResConfig.jdField_a_of_type_JavaLangString + ((ARSceneResConfig.Texture)localObject2).jdField_a_of_type_JavaLangString, ((ARSceneResConfig.Texture)localObject2).jdField_a_of_type_Int, ((ARSceneResConfig.Texture)localObject2).b);
    }
    localObject1 = new HashSet();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqArARSceneResConfig.c.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      ARSceneResConfig.Clip localClip = (ARSceneResConfig.Clip)((Iterator)localObject2).next();
      ((HashSet)localObject1).add(localClip.jdField_b_of_type_JavaLangString);
      a(this.jdField_a_of_type_ComTencentMobileqqArARSceneResConfig.jdField_a_of_type_JavaLangString + localClip.jdField_a_of_type_JavaLangString, localClip.jdField_b_of_type_JavaLangString, localClip.jdField_a_of_type_Long, localClip.jdField_b_of_type_Long);
    }
    localObject1 = ((HashSet)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (!((String)localObject2).equals("ClipIdle2")) {
        this.jdField_a_of_type_Long += this.jdField_a_of_type_ComTencentMobileqqArARSceneResConfig.a((String)localObject2);
      }
    }
    d();
    a(new qpb(this));
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("AREngine", 2, getClass().getSimpleName() + " preloadScene cost = " + (l2 - l1));
    }
  }
  
  public ARNativeBridge a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.a;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine", 2, getClass().getSimpleName() + "initScene");
    }
    this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.a.createEngine();
    a("setBasePath", this.jdField_a_of_type_ComTencentMobileqqArARSceneResConfig.jdField_a_of_type_JavaLangString);
    StringBuilder localStringBuilder = new StringBuilder().append("");
    if (this.jdField_a_of_type_ComTencentMobileqqArARSceneResConfig.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 0)
    {
      a("setOfflinePoster", i);
      ThreadManager.a(new qoz(this), 8, null, true);
      return;
    }
  }
  
  public void a(ARSceneResConfig paramARSceneResConfig)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARSceneResConfig = paramARSceneResConfig;
    this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.a.basePath = paramARSceneResConfig.jdField_a_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("AREngine", 2, getClass().getSimpleName() + "setSceneConfig " + paramARSceneResConfig);
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.queueEvent(paramRunnable);
  }
  
  protected void a(String paramString)
  {
    a("addGpbFilePath", paramString);
  }
  
  protected void a(String paramString, int paramInt1, int paramInt2)
  {
    a("addTextureFilePath", paramString + ":" + paramInt1 + ":" + paramInt2);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.a.config(paramString1, paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("AREngine", 2, getClass().getSimpleName() + "nativeConfig " + paramString1 + "," + paramString2);
    }
  }
  
  protected void a(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    a("addAnimationClip", paramString1 + ":" + paramString2 + ":" + paramLong1 + ":" + paramLong2);
  }
  
  void a(qpc paramqpc)
  {
    if (paramqpc == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.a.setupActionCallback(null);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.a.setupActionCallback(new qpa(this, paramqpc));
  }
  
  public void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.a.handleDrawFrame(paramArrayOfFloat1, paramArrayOfFloat2);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.a.onDestroy();
  }
  
  protected void b(String paramString)
  {
    a("attacthFireOnNode", paramString);
  }
  
  protected void b(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    a("playAnimationClip", str + ":" + paramString1);
  }
  
  public void c()
  {
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.a.handleOnSurfaceCreate(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Int, this.b);
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("AREngine", 2, getClass().getSimpleName() + "setupScene cost = " + (l2 - l1));
    }
  }
  
  protected void d()
  {
    a("prepareResource", "");
  }
  
  protected void e()
  {
    a("clearAllAnimation", "");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ar\ARScene.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */