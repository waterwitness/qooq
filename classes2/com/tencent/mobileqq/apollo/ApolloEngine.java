package com.tencent.mobileqq.apollo;

import android.graphics.RectF;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class ApolloEngine
{
  static final String jdField_a_of_type_JavaLangString = "ApolloEngine";
  public long a;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a();
  }
  
  public ApolloEngine()
  {
    this.jdField_a_of_type_Long = -1L;
  }
  
  public static void a()
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloEngine", 2, "Start to load apollo library,ApolloManager.sLoadEngineLibDone:" + ApolloManager.a);
        }
        boolean bool = ApolloManager.a;
        if (bool) {
          return;
        }
        try
        {
          if (!SoLoadUtil.a(BaseApplicationImpl.getContext(), "png-armeabi-v7a", 0, false)) {
            break label136;
          }
          if (!SoLoadUtil.a(BaseApplicationImpl.getContext(), "sava", 0, false)) {
            break label129;
          }
          ApolloManager.a = true;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          ApolloManager.a = false;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ApolloEngine", 2, "errInfo->fail to load apollo so. msg:" + localUnsatisfiedLinkError.getMessage());
        continue;
        ApolloManager.a = false;
      }
      finally {}
      label129:
      continue;
      label136:
      ApolloManager.a = false;
    }
  }
  
  private native long nativeCreateDirector(ApolloRender paramApolloRender);
  
  private native void nativeDiposeDirector(long paramLong);
  
  private native void nativeDrawFrame(long paramLong, double paramDouble);
  
  private native RectF nativeGetDressRect(long paramLong, String paramString);
  
  private native RectF nativeGetManRect(long paramLong);
  
  private native int nativeGetRoleNum(long paramLong);
  
  private native int nativeHittest(long paramLong, float paramFloat1, float paramFloat2);
  
  private native void nativeLoadScriptFile(long paramLong, String paramString);
  
  private native void nativeLoadScriptString(long paramLong, String paramString, int paramInt);
  
  private native int nativeOrganHittest(long paramLong, float paramFloat1, float paramFloat2, String paramString);
  
  private native void nativeScriptCreate(long paramLong, String paramString);
  
  private native void nativeSetDirectorRenderSize(long paramLong, float paramFloat1, float paramFloat2);
  
  private native void nativeSetDirectorScreenScale(long paramLong, float paramFloat);
  
  private native void nativeSetNodeHidden(long paramLong, String paramString, int paramInt);
  
  private native void nativeUpdateRenderObj(ApolloRender paramApolloRender);
  
  public int a()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloEngine", 2, "[getRoleNum], errInfo->initErr, mIsLoadSuccess:" + ApolloManager.a + ",mIsInit:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      }
      return 0;
    }
    return nativeGetRoleNum(this.jdField_a_of_type_Long);
  }
  
  public int a(float paramFloat1, float paramFloat2)
  {
    if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (!ApolloManager.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloEngine", 2, "[hittest], errInfo->initErr, mIsLoadSuccess:" + ApolloManager.a + ",mIsInit:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      }
      return -1;
    }
    return nativeHittest(this.jdField_a_of_type_Long, paramFloat1, paramFloat2);
  }
  
  public RectF a()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloEngine", 2, "[getManRect], errInfo->initErr, mIsLoadSuccess:" + ApolloManager.a + ",mIsInit:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      }
      return null;
    }
    return nativeGetManRect(this.jdField_a_of_type_Long);
  }
  
  public RectF a(String paramString)
  {
    if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (!ApolloManager.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloEngine", 2, "[getDressRect], errInfo->initErr, mIsLoadSuccess:" + ApolloManager.a + ",mIsInit:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      }
      return null;
    }
    return nativeGetDressRect(this.jdField_a_of_type_Long, paramString);
  }
  
  public void a(double paramDouble)
  {
    if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (!ApolloManager.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloEngine", 2, "[drawFrame], errInfo->initErr, mIsLoadSuccess:" + ApolloManager.a + ",mIsInit:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
      }
      return;
    }
    nativeDrawFrame(this.jdField_a_of_type_Long, paramDouble);
  }
  
  public void a(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloEngine", 2, "[setDirectorScreenScale], mIsInit:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
    }
    if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (!ApolloManager.a)) {
      return;
    }
    nativeSetDirectorScreenScale(this.jdField_a_of_type_Long, paramFloat);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloEngine", 2, "[setDirectorRenderSize], mIsInit:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean + ",this:" + this);
    }
    if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (!ApolloManager.a)) {
      return;
    }
    nativeSetDirectorRenderSize(this.jdField_a_of_type_Long, paramFloat1, paramFloat2);
  }
  
  public void a(ApolloRender paramApolloRender)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloEngine", 2, "[createDirector], render:" + paramApolloRender + ",mIsInit:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ",mIsLoadSuccess:" + ApolloManager.a);
    }
    if (!ApolloManager.a) {
      return;
    }
    this.jdField_a_of_type_Long = nativeCreateDirector(paramApolloRender);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloEngine", 2, "[execScriptFile]," + paramString);
    }
    if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (!ApolloManager.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloEngine", 2, "errInfo->initErr, mIsLoadSuccess:" + ApolloManager.a + ",mIsInit:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      }
      return;
    }
    nativeLoadScriptFile(this.jdField_a_of_type_Long, paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloEngine", 2, "[setNodeHidden], nodeName:" + paramString + ",value:" + paramInt);
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloEngine", 2, "[setNodeHidden], errInfo->initErr, mIsLoadSuccess:" + ApolloManager.a + ",mIsInit:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
      }
      return;
    }
    nativeSetNodeHidden(this.jdField_a_of_type_Long, paramString, paramInt);
  }
  
  public boolean a(float paramFloat1, float paramFloat2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloEngine", 2, "[isOrganTouched], x:" + paramFloat1 + ",y:" + paramFloat2 + ",organName:" + paramString);
    }
    if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (!ApolloManager.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloEngine", 2, "[isOrganTouched], errInfo->initErr, mIsLoadSuccess:" + ApolloManager.a + ",mIsInit:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      }
      return false;
    }
    int i = nativeOrganHittest(this.jdField_a_of_type_Long, paramFloat1, paramFloat2, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloEngine", 2, "ret:" + i);
    }
    return i == 1;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloEngine", 2, "[diposeDirector], mIsInit:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean + ",ApolloManager.sLoadEngineLibDone:" + ApolloManager.a);
    }
    if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (!ApolloManager.a)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    nativeDiposeDirector(this.jdField_a_of_type_Long);
  }
  
  public void b(ApolloRender paramApolloRender)
  {
    if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (!ApolloManager.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloEngine", 2, "[updateRenderObj], errInfo->initErr, mIsLoadSuccess:" + ApolloManager.a + ",mIsInit:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
      }
      return;
    }
    nativeUpdateRenderObj(paramApolloRender);
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloEngine", 2, "[execScriptString]," + paramString + ",this:" + this);
    }
    if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (!ApolloManager.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloEngine", 2, "errInfo->initErr, mIsLoadSuccess:" + ApolloManager.a + ",mIsInit:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      }
      return;
    }
    long l = this.jdField_a_of_type_Long;
    if (QLog.isColorLevel()) {}
    for (int i = 1;; i = 0)
    {
      nativeLoadScriptString(l, paramString, i);
      return;
    }
  }
  
  public void c(String paramString)
  {
    if (!ApolloManager.a)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloEngine", 2, "[createScript], errInfo->initErr, mIsLoadSuccess:" + ApolloManager.a + ",mIsInit:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      }
      return;
    }
    nativeScriptCreate(this.jdField_a_of_type_Long, paramString);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\ApolloEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */