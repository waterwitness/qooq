package com.tencent.mobileqq.shortvideo.util;

import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import com.tencent.maxvideo.common.AVIOStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

public class PtvFilterUtils
{
  public static final int a = 0;
  public static final String a = "PtvFilterUtils";
  private static Method a;
  public static final boolean a;
  public static final int b = 1;
  
  static
  {
    boolean bool1 = false;
    boolean bool2 = NotVerifyClass.DO_VERIFY_CLASS;
    if (Build.VERSION.SDK_INT >= 14) {
      bool1 = a("android.graphics.SurfaceTexture", "release", new Class[0]);
    }
    jdField_a_of_type_Boolean = bool1;
    try
    {
      jdField_a_of_type_JavaLangReflectMethod = HandlerThread.class.getDeclaredMethod("quitSafely", new Class[0]);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ByteBuffer paramByteBuffer)
  {
    int i = 6408;
    if (paramInt4 == 3) {
      i = 6407;
    }
    if (paramInt1 != 0)
    {
      int[] arrayOfInt = new int[1];
      GLES20.glGenFramebuffers(1, arrayOfInt, 0);
      GLES20.glBindFramebuffer(36160, arrayOfInt[0]);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt1, 0);
      GLES20.glReadPixels(0, 0, paramInt2, paramInt3, i, 5121, paramByteBuffer);
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glDeleteFramebuffers(1, arrayOfInt, 0);
      arrayOfInt[0] = 0;
      return 0;
    }
    GLES20.glReadPixels(0, 0, paramInt2, paramInt3, i, 5121, paramByteBuffer);
    return 0;
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4, AVIOStruct paramAVIOStruct, int paramInt5, boolean paramBoolean3, int paramInt6)
  {
    try
    {
      paramInt1 = writeSharedMemtoFile(paramInt1, paramInt2, paramInt3, paramBoolean1, paramBoolean2, paramInt4, paramAVIOStruct, paramInt5, paramBoolean3, paramInt6);
      return paramInt1;
    }
    catch (UnsatisfiedLinkError paramAVIOStruct)
    {
      paramAVIOStruct.printStackTrace();
    }
    return -2;
  }
  
  public static long a()
  {
    return System.nanoTime();
  }
  
  public static ByteBuffer a()
  {
    try
    {
      ByteBuffer localByteBuffer = allocate();
      return localByteBuffer;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
    return null;
  }
  
  public static void a(int paramInt)
  {
    try
    {
      setBeautyKind(paramInt);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
  
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      GLES20.glFinish();
      return;
    }
    GLES20.glFlush();
  }
  
  public static boolean a(HandlerThread paramHandlerThread)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (jdField_a_of_type_JavaLangReflectMethod != null) {}
    try
    {
      jdField_a_of_type_JavaLangReflectMethod.invoke(paramHandlerThread, new Object[0]);
      bool1 = true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        bool1 = bool2;
      }
    }
    if (!bool1)
    {
      paramHandlerThread.quit();
      return true;
    }
    return bool1;
  }
  
  private static boolean a(String paramString1, String paramString2, Class... paramVarArgs)
  {
    try
    {
      Class.forName(paramString1).getDeclaredMethod(paramString2, paramVarArgs);
      return true;
    }
    catch (Throwable paramString1) {}
    return false;
  }
  
  private static native ByteBuffer allocate();
  
  public static native ByteBuffer allocateSharedMem(long paramLong);
  
  public static void b(int paramInt)
  {
    try
    {
      setVideoClipThreadNum(paramInt);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
  
  public static void b(boolean paramBoolean)
  {
    try
    {
      setSupportBeauty(paramBoolean);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
  
  public static void c(boolean paramBoolean)
  {
    try
    {
      setEnableAsyncClipVideo(paramBoolean);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
  
  private static native int getGLFrameBufferData(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public static native long getNativePtrIndex(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public static native int processVideoFrame(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, ByteBuffer paramByteBuffer);
  
  private static native void setBeautyKind(int paramInt);
  
  private static native void setEnableAsyncClipVideo(boolean paramBoolean);
  
  private static native void setSupportBeauty(boolean paramBoolean);
  
  private static native void setVideoClipThreadNum(int paramInt);
  
  private static native int writeSharedMemtoFile(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4, AVIOStruct paramAVIOStruct, int paramInt5, boolean paramBoolean3, int paramInt6);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\util\PtvFilterUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */