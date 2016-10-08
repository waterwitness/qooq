package com.tencent.mobileqq.apollo;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint.FontMetricsInt;
import android.opengl.GLSurfaceView.Renderer;
import android.support.v4.util.MQLruCache;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.nio.IntBuffer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class ApolloRender
  implements GLSurfaceView.Renderer
{
  public static final int a = 4;
  public static final String a = "ApolloRender";
  public static final int b = 6;
  private float jdField_a_of_type_Float;
  long jdField_a_of_type_Long;
  private ApolloRender.ISnapShotCallback jdField_a_of_type_ComTencentMobileqqApolloApolloRender$ISnapShotCallback;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private WeakReference jdField_b_of_type_JavaLangRefWeakReference;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d;
  private int e;
  private ApolloEngine mSavaWrapper;
  
  public ApolloRender(float paramFloat, OnApolloViewListener paramOnApolloViewListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mSavaWrapper = new ApolloEngine();
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramOnApolloViewListener);
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = ApolloActionManager.a().a();
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRender", 2, "[ApolloRender] threadId:" + Thread.currentThread().getId());
    }
  }
  
  public static String a(String paramString, TextView paramTextView, float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRender", 2, "[getProperString], src:" + paramString + ",maxWidth:" + paramFloat);
    }
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramTextView != null) {
        break label60;
      }
      localObject = paramString;
    }
    label60:
    String str;
    int j;
    float f2;
    do
    {
      return (String)localObject;
      localObject = Pattern.compile("\\s*|\t|\r|\n");
      str = paramString;
      if (localObject != null)
      {
        localObject = ((Pattern)localObject).matcher(paramString);
        str = paramString;
        if (localObject != null) {
          str = ((Matcher)localObject).replaceAll("");
        }
      }
      paramTextView = paramTextView.getPaint();
      j = str.length();
      float f1 = paramTextView.measureText(str);
      f2 = paramTextView.measureText("…");
      if (f1 > paramFloat) {
        break;
      }
      localObject = str;
    } while (!QLog.isColorLevel());
    QLog.d("ApolloRender", 2, "[1] dst:" + str);
    return str;
    int i = 0;
    for (;;)
    {
      paramString = str;
      if (i <= j)
      {
        paramString = str.substring(0, i);
        if (paramTextView.measureText(paramString) <= paramFloat - f2) {
          break label280;
        }
        if (i != 0) {
          break label248;
        }
      }
      for (;;)
      {
        localObject = paramString;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ApolloRender", 2, "[2] dst:" + paramString);
        return paramString;
        label248:
        paramString = str.substring(0, i - 1) + "…";
      }
      label280:
      i += 1;
    }
  }
  
  private boolean a(GL10 paramGL10)
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender$ISnapShotCallback != null) && (this.c > 0) && (this.d > 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloRender", 2, "snapShot Request:");
      }
    }
    try
    {
      int[] arrayOfInt = new int[this.c * this.d];
      IntBuffer localIntBuffer = IntBuffer.wrap(arrayOfInt);
      localIntBuffer.position(0);
      paramGL10.glReadPixels(0, 0, this.c, this.d, 6408, 5121, localIntBuffer);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender$ISnapShotCallback.a(arrayOfInt, this.c, this.d, this.e, this.jdField_b_of_type_Long);
      return true;
    }
    catch (Exception paramGL10)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloRender", 2, paramGL10.getMessage());
      }
      return false;
    }
    catch (OutOfMemoryError paramGL10)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloRender", 2, paramGL10.getMessage());
        }
        this.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender$ISnapShotCallback = null;
      }
    }
    finally
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender$ISnapShotCallback = null;
    }
  }
  
  private void b()
  {
    if (BaseApplicationImpl.a() == null) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock != null) && (this.mSavaWrapper != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloRender", 2, "errInfo->null param. mLock:" + this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock + ",mSavaWrapper:" + this.mSavaWrapper);
    return;
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    for (;;)
    {
      try
      {
        File localFile = new File(ApolloConstant.k, "/def/scene.lua");
        boolean bool = localFile.exists();
        if (bool) {
          try
          {
            this.mSavaWrapper.a(this);
            this.mSavaWrapper.c(localFile.getAbsolutePath());
            this.mSavaWrapper.a(localFile.getAbsolutePath());
            this.mSavaWrapper.a(this.jdField_a_of_type_Float);
            return;
          }
          catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("ApolloRender", 2, "UnsatisfiedLinkError, err:" + localUnsatisfiedLinkError.getMessage());
            continue;
          }
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      }
      QLog.d("ApolloRender", 2, "errInfo->scene.lua file NOT loaded.");
    }
  }
  
  public static Bitmap drawTextOnBitmap(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRender", 2, "[drawTextOnBitmap], l:" + paramFloat1 + ",t:" + paramFloat2 + "w:" + paramFloat3 + ",h:" + paramFloat4 + ",bWidth:" + paramInt1 + ",bHeight:" + paramInt2 + ",text:" + paramString1 + ",slotName:" + paramString2 + ",rotate:" + paramInt3 + ",flip:" + paramInt4);
    }
    if ((TextUtils.isEmpty(paramString2)) || ((!"Bubble_Word".equals(paramString2)) && (!"Bubble_Name_Word".equals(paramString2))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloRender", 2, "errInfo->wrong slotName.");
      }
      return null;
    }
    Object localObject1 = null;
    Object localObject3 = "group_brand_" + paramInt1 + "_" + paramInt2;
    if (BaseApplicationImpl.a != null)
    {
      localObject2 = (Bitmap)BaseApplicationImpl.a.get(localObject3);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("ApolloRender", 2, "group brand ----> get bitmap from cache key: " + (String)localObject3);
          localObject1 = localObject2;
        }
      }
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {}
    for (;;)
    {
      try
      {
        localObject1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        localObject2 = localObject1;
        if (BaseApplicationImpl.a != null)
        {
          BaseApplicationImpl.a.put(localObject3, localObject1);
          localObject2 = localObject1;
        }
        localObject1 = new TextView(BaseApplicationImpl.getContext());
        localObject3 = new Paint.FontMetricsInt();
        ((TextView)localObject1).getPaint().getFontMetricsInt((Paint.FontMetricsInt)localObject3);
        paramInt1 = ((Paint.FontMetricsInt)localObject3).ascent - ((Paint.FontMetricsInt)localObject3).top;
        paramInt2 = paramInt1;
        if (paramInt1 == 0) {
          paramInt2 = (int)(2.0F * DeviceInfoUtil.jdField_a_of_type_Float);
        }
        ((TextView)localObject1).setGravity(17);
        k = ApolloActionManager.a().a.get();
        if (QLog.isColorLevel()) {
          QLog.d("ApolloRender", 2, "bubbleType:" + k);
        }
        i = 0;
        j = 3;
        if ((k == 0) || ((1 == k) && ("Bubble_Word".equals(paramString2))))
        {
          ((TextView)localObject1).setTextColor(-16777216);
          ((TextView)localObject1).setTextSize(51.0F / DeviceInfoUtil.jdField_a_of_type_Float);
          paramInt3 = 1;
          paramInt1 = 3;
          ((TextView)localObject1).setWidth((int)paramFloat3);
          ((TextView)localObject1).setHeight((int)paramFloat4 + paramInt2);
          ((TextView)localObject1).setText(ApolloUtil.a(((TextView)localObject1).getPaint(), paramFloat3, paramString1, paramInt1));
          ((TextView)localObject1).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
          i = ((TextView)localObject1).getMeasuredWidth();
          ((TextView)localObject1).layout(0, 0, i, ((TextView)localObject1).getMeasuredHeight());
          if (QLog.isColorLevel()) {
            QLog.d("ApolloRender", 2, "lineHeight" + ((TextView)localObject1).getLineHeight());
          }
          if (paramInt3 != 0)
          {
            if (((TextView)localObject1).getLineCount() != 0) {
              break label931;
            }
            ((TextView)localObject1).setLineSpacing(59.0F - ((TextView)localObject1).getLineHeight(), 1.0F);
          }
          paramInt1 = 1;
        }
        if (1 != k) {
          break label886;
        }
      }
      catch (OutOfMemoryError paramString1)
      {
        try
        {
          paramString1 = new Canvas((Bitmap)localObject2);
          paramString2 = new Matrix();
          if (1 == paramInt4)
          {
            paramString2.setValues(new float[] { -1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F });
            paramString2.postTranslate(paramFloat3, 0.0F);
            paramInt1 = -1;
          }
          paramString2.postTranslate(paramInt1 * (paramFloat3 - i) / 2.0F + paramFloat1, paramFloat2 - paramInt2);
          paramString1.setMatrix(paramString2);
          ((TextView)localObject1).draw(paramString1);
          return (Bitmap)localObject2;
        }
        catch (Exception paramString1)
        {
          int k;
          int i;
          int j;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ApolloRender", 2, "errInfo->canvas failure.");
        }
        paramString1 = paramString1;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloRender", 2, "errInfo->" + paramString1.getMessage());
        }
        return null;
      }
      catch (Exception paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloRender", 2, "errInfo->" + paramString1.getMessage());
        }
        return null;
      }
      if ("Bubble_Name_Word".equals(paramString2))
      {
        ((TextView)localObject1).setTextColor(-1);
        ((TextView)localObject1).setTextSize(36.0F / DeviceInfoUtil.jdField_a_of_type_Float);
        paramInt1 = 1;
        paramInt3 = i;
      }
      else
      {
        label886:
        paramInt1 = j;
        paramInt3 = i;
        if (2 == k)
        {
          ((TextView)localObject1).setTextColor(-16777216);
          ((TextView)localObject1).setTextSize(30.0F / DeviceInfoUtil.jdField_a_of_type_Float);
          paramInt1 = j;
          paramInt3 = i;
          continue;
          label931:
          ((TextView)localObject1).setLineSpacing((paramInt2 + paramFloat4) / ((TextView)localObject1).getLineCount() - ((TextView)localObject1).getLineHeight(), 1.0F);
        }
      }
    }
    return null;
  }
  
  public static Bitmap getApolloBitmap(String paramString, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRender", 2, "[getApolloBitmap], path:" + paramString + ",format:" + paramInt);
    }
    if (TextUtils.isEmpty(paramString))
    {
      paramString = (String)localObject1;
      if (QLog.isColorLevel())
      {
        QLog.d("ApolloRender", 2, "errInfo-> path is NULL.");
        paramString = (String)localObject1;
      }
    }
    do
    {
      for (;;)
      {
        return paramString;
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        if (4 == paramInt) {
          localOptions.inPreferredConfig = Bitmap.Config.ARGB_4444;
        }
        try
        {
          for (;;)
          {
            Bitmap localBitmap = BitmapFactory.decodeFile(paramString, localOptions);
            return localBitmap;
            if (6 == paramInt) {
              localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
            } else {
              localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
            }
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          localOptions.inJustDecodeBounds = true;
          try
          {
            localObject1 = BitmapFactory.decodeFile(paramString, localOptions);
            localObject2 = localObject1;
            paramInt = localOptions.outWidth;
          }
          catch (OutOfMemoryError paramString)
          {
            try
            {
              int i = localOptions.outHeight;
              paramString = (String)localObject1;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("ApolloRender", 2, "errInfo2->oom->" + localOutOfMemoryError.getMessage() + ",h:" + i + ",w:" + paramInt);
              return (Bitmap)localObject1;
            }
            catch (OutOfMemoryError paramString)
            {
              for (;;) {}
            }
            paramString = paramString;
            paramInt = 0;
            localObject1 = localObject2;
          }
          paramString = (String)localObject1;
          if (QLog.isColorLevel())
          {
            QLog.d("ApolloRender", 2, "errInfo1->oom->" + localOutOfMemoryError.getMessage() + ",h:" + 0 + ",w:" + paramInt);
            return (Bitmap)localObject1;
          }
        }
        catch (Exception localException)
        {
          paramString = (String)localObject1;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloRender", 2, "errInfo3->exception->" + localException.getMessage());
    return null;
  }
  
  public static String getRscPath(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRender", 2, "[getRscPath], name:" + paramString1 + ",type:" + paramString2);
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(96);
    if (paramString1.contains("def"))
    {
      localStringBuilder.append(ApolloConstant.k);
      if (!localStringBuilder.toString().endsWith("/")) {
        localStringBuilder.append("/");
      }
      localStringBuilder.append(paramString1);
      if (!"json".equals(paramString2)) {
        break label204;
      }
      localStringBuilder.append(".json");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloRender", 2, "ret:" + localStringBuilder.toString());
      }
      return localStringBuilder.toString();
      localStringBuilder.append(ApolloConstant.j);
      if (localStringBuilder.toString().endsWith("/")) {
        break;
      }
      localStringBuilder.append("/");
      break;
      label204:
      if ("atlas".equals(paramString2)) {
        localStringBuilder.append(".atlas");
      }
    }
  }
  
  public static void printNativeLog(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("sava_native_log", 2, "level:" + paramInt1 + ",code:" + paramInt2 + ",info1:" + paramString1 + ",info2:" + paramString2 + ",info3:" + paramString3);
    }
  }
  
  public ApolloEngine a()
  {
    return this.mSavaWrapper;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRender", 2, "[onDestroy]");
    }
    if ((this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock == null) || (this.mSavaWrapper == null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    try
    {
      this.mSavaWrapper.b();
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
  }
  
  public void a(ApolloRender.ISnapShotCallback paramISnapShotCallback, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender$ISnapShotCallback = paramISnapShotCallback;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_b_of_type_Long = paramLong;
    this.e = paramInt;
  }
  
  public void a(IRenderCallback paramIRenderCallback)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramIRenderCallback);
  }
  
  public void callbackFromJni(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRender", 2, "[callbackFromJni], eventCode:" + paramInt1 + ",roleName:" + paramString + ",taskId:" + paramInt2 + ",mSavaWrapper:" + this.mSavaWrapper);
    }
    IRenderCallback localIRenderCallback;
    if (paramInt1 == 0) {
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        localIRenderCallback = (IRenderCallback)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localIRenderCallback != null) {
          localIRenderCallback.a(paramInt2, paramString);
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (2 != paramInt1) {
            break;
          }
          localIRenderCallback = (IRenderCallback)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        } while (localIRenderCallback == null);
        localIRenderCallback.a(paramInt2, 0, paramString);
        return;
      } while ((1 != paramInt1) || (paramInt2 >= 1000000));
      if ("me".equals(paramString))
      {
        this.mSavaWrapper.b("me:restoreAnimationState();");
        return;
      }
    } while (!"friend".equals(paramString));
    this.mSavaWrapper.b("friend:restoreAnimationState();");
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    double d1;
    if ((this.mSavaWrapper != null) && (this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock != null) && (this.mSavaWrapper.jdField_a_of_type_Long != -1L))
    {
      long l = System.currentTimeMillis();
      double d2 = Math.min(l - this.jdField_a_of_type_Long, 50L) / 1000.0D;
      d1 = d2;
      if (this.jdField_b_of_type_Boolean)
      {
        d1 = d2;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender$ISnapShotCallback != null)
        {
          d1 = d2;
          if (this.c > 0)
          {
            d1 = d2;
            if (this.d > 0) {
              d1 = 0.0D;
            }
          }
        }
      }
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    }
    try
    {
      this.mSavaWrapper.a(d1);
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      a(paramGL10);
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRender", 2, "[onSurfaceChanged] width:" + paramInt1 + ",height:" + paramInt2 + ",mSavaWrapper:" + this.mSavaWrapper);
    }
    if (this.mSavaWrapper != null) {
      this.mSavaWrapper.a(paramInt1 / this.jdField_a_of_type_Float, paramInt2 / this.jdField_a_of_type_Float);
    }
    this.c = paramInt1;
    this.d = paramInt2;
    if ((this.jdField_b_of_type_JavaLangRefWeakReference != null) && (!this.jdField_a_of_type_Boolean))
    {
      paramGL10 = (OnApolloViewListener)this.jdField_b_of_type_JavaLangRefWeakReference.get();
      if (paramGL10 != null)
      {
        paramGL10.a(paramInt1, paramInt2);
        this.jdField_a_of_type_Boolean = true;
      }
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    b();
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel())
    {
      paramEGLConfig = new int[1];
      paramGL10.glGetIntegerv(3379, paramEGLConfig, 0);
      QLog.d("ApolloRender", 2, "[onSurfaceCreated]  GL_MAX_TEXTURE_SIZE: " + paramEGLConfig[0] + " threadId:" + Thread.currentThread().getId());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\ApolloRender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */