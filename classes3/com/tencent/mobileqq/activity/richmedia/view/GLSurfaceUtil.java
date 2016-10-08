package com.tencent.mobileqq.activity.richmedia.view;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.ImageFormat;
import android.opengl.GLES20;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class GLSurfaceUtil
{
  public static final int a = 4;
  public static final String a = "precision highp float;\nattribute vec4 position;\nattribute vec2 textureCoordinateIn;\nvarying   vec2 texturecoordinateOut;\nvoid main()\n{\ntexturecoordinateOut = textureCoordinateIn;\ngl_Position = position;\n}\n";
  private static final FloatBuffer jdField_a_of_type_JavaNioFloatBuffer;
  public static final boolean a = true;
  public static final float[] a;
  public static final String b = "precision mediump float;varying   vec2 texturecoordinateOut;\nuniform sampler2D SamplerY;\nuniform sampler2D SamplerU;\nuniform sampler2D SamplerV;\nvoid main()\n{\nvec3 yuv;\nvec3 rgb;\nvec4 rgba;\nyuv.x = texture2D(SamplerY, texturecoordinateOut).r;\nyuv.y = texture2D(SamplerU, texturecoordinateOut).r-0.5;\nyuv.z = texture2D(SamplerV, texturecoordinateOut).r-0.5;\nrgb = mat3(      1,       1,      1,\n0, \t\t-.34414, 1.772,\n1.402, \t-.71414, 0) * yuv;\nrgba = vec4(rgb, 1);\ngl_FragColor = rgba;\n}\n";
  public static boolean b = false;
  public static final float[] b;
  private static final int jdField_c_of_type_Int;
  private static final String jdField_c_of_type_JavaLangString = "GLSurfaceUtil";
  public static boolean c;
  public static final boolean e = false;
  public ByteBuffer a;
  private int[] jdField_a_of_type_ArrayOfInt = new int[3];
  public int b;
  public ByteBuffer b;
  private int[] b;
  public ByteBuffer c;
  private int d;
  public boolean d;
  private int e;
  private int f;
  private int g;
  private int h;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfFloat = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, 1.0F, 1.0F, -1.0F, 1.0F };
    jdField_b_of_type_ArrayOfFloat = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F };
    jdField_c_of_type_Int = jdField_a_of_type_ArrayOfFloat.length * 4 + jdField_b_of_type_ArrayOfFloat.length * 4;
    jdField_a_of_type_JavaNioFloatBuffer = ByteBuffer.allocateDirect(jdField_c_of_type_Int * 2).order(ByteOrder.nativeOrder()).asFloatBuffer();
    int i = jdField_a_of_type_JavaNioFloatBuffer.capacity();
    jdField_a_of_type_JavaNioFloatBuffer.limit(i);
    jdField_a_of_type_JavaNioFloatBuffer.position(0);
    jdField_a_of_type_JavaNioFloatBuffer.put(jdField_a_of_type_ArrayOfFloat);
    jdField_a_of_type_JavaNioFloatBuffer.put(jdField_b_of_type_ArrayOfFloat);
  }
  
  public GLSurfaceUtil()
  {
    this.jdField_b_of_type_ArrayOfInt = new int[1];
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "Unknow error";
    case 0: 
      return "GL_NO_ERROR";
    case 1280: 
      return "GL_INVALID_ENUM";
    case 1281: 
      return "GL_INVALID_VALUE";
    case 1282: 
      return "GL_INVALID_OPERATION";
    case 1285: 
      return "GL_OUT_OF_MEMORY";
    }
    return "GL_INVALID_FRAMEBUFFER_OPERATION";
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GLSurfaceUtil", 2, paramString);
    }
  }
  
  public static void a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    jdField_a_of_type_JavaNioFloatBuffer.position(0);
    GLES20.glGenBuffers(1, paramArrayOfInt, 0);
    GLES20.glBindBuffer(34962, paramArrayOfInt[0]);
    GLES20.glBufferData(34962, jdField_c_of_type_Int, jdField_a_of_type_JavaNioFloatBuffer, 35044);
    GLES20.glVertexAttribPointer(paramInt1, 2, 5126, false, 0, 0);
    GLES20.glEnableVertexAttribArray(paramInt1);
    GLES20.glVertexAttribPointer(paramInt2, 2, 5126, false, 0, jdField_a_of_type_ArrayOfFloat.length * 4);
    GLES20.glEnableVertexAttribArray(paramInt2);
  }
  
  private void b()
  {
    GLES20.glUseProgram(this.jdField_b_of_type_Int);
    this.jdField_d_of_type_Int = GLES20.glGetUniformLocation(this.jdField_b_of_type_Int, "SamplerY");
    this.e = GLES20.glGetUniformLocation(this.jdField_b_of_type_Int, "SamplerU");
    this.f = GLES20.glGetUniformLocation(this.jdField_b_of_type_Int, "SamplerV");
    this.g = GLES20.glGetAttribLocation(this.jdField_b_of_type_Int, "position");
    this.h = GLES20.glGetAttribLocation(this.jdField_b_of_type_Int, "textureCoordinateIn");
  }
  
  private void c()
  {
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.jdField_a_of_type_ArrayOfInt[0]);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glPixelStorei(3317, 1);
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(3553, this.jdField_a_of_type_ArrayOfInt[1]);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glPixelStorei(3317, 1);
    GLES20.glActiveTexture(33986);
    GLES20.glBindTexture(3553, this.jdField_a_of_type_ArrayOfInt[2]);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glPixelStorei(3317, 1);
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    return paramInt1 * paramInt2 * 3 / 2;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = ImageFormat.getBitsPerPixel(paramInt1);
    float f1 = paramInt1 * 1.0F / 8.0F;
    a("handleMessage:byteBufferProcessFrame:[getBufferSize]bitpixel=" + paramInt1 + " byteNum=" + f1);
    return (int)(paramInt2 * paramInt3 * f1);
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, byte[] paramArrayOfByte)
  {
    for (;;)
    {
      try
      {
        int i = a(paramInt1, paramInt4, paramInt5);
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= i)) {
          break label325;
        }
        bool1 = true;
        boolean bool2 = bool1;
        if (bool1)
        {
          bool2 = bool1;
          if (paramArrayOfByte.length == a(paramInt4, paramInt5)) {
            bool2 = false;
          }
        }
        if (bool2)
        {
          a("handleMessage:byteBufferProcessFrame:[data length error]dataLenErr=" + bool2 + " mPreviewWidth=" + paramInt4 + " mPreviewWidth" + paramInt4 + " mVideoFormat=" + paramInt1);
          a("handleMessage:byteBufferProcessFrame:[data length error]dataLenErr=" + bool2 + " totalSize=" + i + " data.length=" + paramArrayOfByte.length);
          return -1;
        }
        if ((this.jdField_a_of_type_JavaNioByteBuffer == null) || (!this.jdField_d_of_type_Boolean)) {
          jdField_c_of_type_Boolean = false;
        }
      }
      catch (UnsatisfiedLinkError paramArrayOfByte)
      {
        paramInt1 = 0;
        continue;
        a("handleMessage:byteBufferProcessFrame:panelY=" + this.jdField_a_of_type_JavaNioByteBuffer);
        return paramInt1;
      }
      try
      {
        CameraGLSurfaceView.initTotalBufferSize(paramInt4, paramInt5, paramInt1);
        jdField_c_of_type_Boolean = true;
        this.jdField_a_of_type_JavaNioByteBuffer = null;
        this.jdField_b_of_type_JavaNioByteBuffer = null;
        this.jdField_c_of_type_JavaNioByteBuffer = null;
        a(paramInt2, paramInt3);
        this.jdField_d_of_type_Boolean = true;
        paramInt1 = CameraGLSurfaceView.processVideoFrame(paramArrayOfByte, paramInt4, paramInt5, paramInt1, paramInt6, false, this.jdField_a_of_type_JavaNioByteBuffer, this.jdField_b_of_type_JavaNioByteBuffer, this.jdField_c_of_type_JavaNioByteBuffer, jdField_b_of_type_Boolean);
        if (this.jdField_a_of_type_JavaNioByteBuffer != null)
        {
          this.jdField_a_of_type_JavaNioByteBuffer.position(0);
          this.jdField_b_of_type_JavaNioByteBuffer.position(0);
          this.jdField_c_of_type_JavaNioByteBuffer.position(0);
          return paramInt1;
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        jdField_c_of_type_Boolean = false;
        continue;
      }
      label325:
      boolean bool1 = false;
    }
  }
  
  public Bitmap a(int paramInt1, int paramInt2)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    try
    {
      Object localObject1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.RGB_565);
      return (Bitmap)localObject1;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
    {
      try
      {
        if ((CameraGLSurfaceView.getBitmap((Bitmap)localObject1, this.jdField_a_of_type_JavaNioByteBuffer, this.jdField_b_of_type_JavaNioByteBuffer, this.jdField_c_of_type_JavaNioByteBuffer, paramInt1) == 0) || (localObject1 == null)) {
          return localObject1;
        }
        ((Bitmap)localObject1).recycle();
        return null;
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        for (;;) {}
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
      {
        for (;;) {}
      }
      localUnsatisfiedLinkError1 = localUnsatisfiedLinkError1;
      localObject1 = localObject2;
      localUnsatisfiedLinkError1.printStackTrace();
      return (Bitmap)localObject1;
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      localObject1 = localObject3;
      localOutOfMemoryError1.printStackTrace();
      return (Bitmap)localObject1;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ArrayOfInt[0] != 0)
    {
      GLES20.glDeleteTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
      this.jdField_a_of_type_ArrayOfInt[0] = 0;
      this.jdField_a_of_type_ArrayOfInt[1] = 0;
      this.jdField_a_of_type_ArrayOfInt[2] = 0;
    }
    if (this.jdField_b_of_type_ArrayOfInt[0] != 0)
    {
      GLES20.glDeleteBuffers(this.jdField_b_of_type_ArrayOfInt.length, this.jdField_b_of_type_ArrayOfInt, 0);
      this.jdField_b_of_type_ArrayOfInt[0] = 0;
    }
    GLES20.glDisableVertexAttribArray(this.g);
    GLES20.glDisableVertexAttribArray(this.h);
    GLES20.glDeleteProgram(this.jdField_b_of_type_Int);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = paramInt1 * paramInt2;
    if ((this.jdField_a_of_type_JavaNioByteBuffer == null) || (this.jdField_a_of_type_JavaNioByteBuffer.capacity() < i)) {
      this.jdField_a_of_type_JavaNioByteBuffer = GLSurfaceUtil.GLDirectAllocate.a(0, i);
    }
    i = 0 + i;
    paramInt1 = paramInt1 / 2 * (paramInt2 / 2);
    if ((this.jdField_b_of_type_JavaNioByteBuffer == null) || (this.jdField_b_of_type_JavaNioByteBuffer.capacity() < paramInt1)) {
      this.jdField_b_of_type_JavaNioByteBuffer = GLSurfaceUtil.GLDirectAllocate.a(i, paramInt1);
    }
    if ((this.jdField_c_of_type_JavaNioByteBuffer == null) || (this.jdField_c_of_type_JavaNioByteBuffer.capacity() < paramInt1)) {
      this.jdField_c_of_type_JavaNioByteBuffer = GLSurfaceUtil.GLDirectAllocate.a(i + paramInt1, paramInt1);
    }
  }
  
  public boolean a()
  {
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    this.jdField_b_of_type_Int = GLSurfaceUtil.GLVideoHelper.a();
    if (this.jdField_b_of_type_Int == 0)
    {
      CameraGLSurfaceView.a("GLVideoHelper.createShaderProgram: mGLProgram=" + this.jdField_b_of_type_Int);
      return false;
    }
    b();
    a(this.jdField_b_of_type_ArrayOfInt, this.g, this.h);
    GLES20.glGenTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
    c();
    return true;
  }
  
  public boolean a(boolean paramBoolean, int paramInt1, int paramInt2, ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, ByteBuffer paramByteBuffer3)
  {
    GLES20.glActiveTexture(33984);
    if (!paramBoolean) {
      GLES20.glTexImage2D(3553, 0, 6409, paramInt1, paramInt2, 0, 6409, 5121, null);
    }
    GLES20.glTexSubImage2D(3553, 0, 0, 0, paramInt1, paramInt2, 6409, 5121, paramByteBuffer1);
    GLES20.glUniform1i(this.jdField_d_of_type_Int, 0);
    GLES20.glActiveTexture(33985);
    if (!paramBoolean) {
      GLES20.glTexImage2D(3553, 0, 6409, paramInt1 / 2, paramInt2 / 2, 0, 6409, 5121, null);
    }
    GLES20.glTexSubImage2D(3553, 0, 0, 0, paramInt1 / 2, paramInt2 / 2, 6409, 5121, paramByteBuffer2);
    GLES20.glUniform1i(this.e, 1);
    GLES20.glActiveTexture(33986);
    boolean bool = paramBoolean;
    if (!paramBoolean)
    {
      GLES20.glTexImage2D(3553, 0, 6409, paramInt1 / 2, paramInt2 / 2, 0, 6409, 5121, null);
      bool = true;
    }
    GLES20.glTexSubImage2D(3553, 0, 0, 0, paramInt1 / 2, paramInt2 / 2, 6409, 5121, paramByteBuffer3);
    GLES20.glUniform1i(this.f, 2);
    GLES20.glDrawArrays(6, 0, 4);
    paramInt1 = GLES20.glGetError();
    if (paramInt1 != 0) {
      a("glDrawFrame:err=" + paramInt1 + " errname=" + a(paramInt1));
    }
    return bool;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\richmedia\view\GLSurfaceUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */