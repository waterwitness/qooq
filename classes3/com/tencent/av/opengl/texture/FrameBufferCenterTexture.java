package com.tencent.av.opengl.texture;

import android.opengl.GLES20;
import com.tencent.av.opengl.glrenderer.GLCanvas;
import com.tencent.av.opengl.glrenderer.GLES20Canvas;
import com.tencent.av.opengl.program.SharpenProgram;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.av.opengl.program.TextureProgramFactory;
import com.tencent.av.opengl.shader.ShaderParameter;
import com.tencent.av.opengl.utils.AVGLUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class FrameBufferCenterTexture
{
  private static FrameBufferCenterTexture jdField_a_of_type_ComTencentAvOpenglTextureFrameBufferCenterTexture;
  public static final String a = "FrameBufferCenterTexture";
  private static int b = -1;
  int jdField_a_of_type_Int;
  private FloatBuffer jdField_a_of_type_JavaNioFloatBuffer;
  boolean jdField_a_of_type_Boolean = true;
  private int c;
  private int d;
  private int e = b;
  private int f = b;
  private int g = b;
  private int h = b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = this.e;
    if (this.e == b)
    {
      int[] arrayOfInt = new int[1];
      GLES20.glGenFramebuffers(1, arrayOfInt, 0);
      i = arrayOfInt[0];
    }
    for (;;)
    {
      GLES20.glBindFramebuffer(36160, i);
      GLES20.glBindTexture(3553, paramInt3);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
      GLES20.glBindTexture(3553, 0);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt3, 0);
      GLES20.glBindFramebuffer(36160, 0);
      return i;
    }
  }
  
  public static FrameBufferCenterTexture a()
  {
    if (jdField_a_of_type_ComTencentAvOpenglTextureFrameBufferCenterTexture == null) {
      jdField_a_of_type_ComTencentAvOpenglTextureFrameBufferCenterTexture = new FrameBufferCenterTexture();
    }
    return jdField_a_of_type_ComTencentAvOpenglTextureFrameBufferCenterTexture;
  }
  
  private int b(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = this.g;
    if (this.g == b)
    {
      int[] arrayOfInt = new int[1];
      GLES20.glGenFramebuffers(1, arrayOfInt, 0);
      i = arrayOfInt[0];
    }
    for (;;)
    {
      GLES20.glBindFramebuffer(36160, i);
      GLES20.glBindTexture(3553, paramInt3);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
      GLES20.glBindTexture(3553, 0);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt3, 0);
      GLES20.glBindFramebuffer(36160, 0);
      return i;
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaNioFloatBuffer != null) {
      return;
    }
    float[] arrayOfFloat = new float[8];
    arrayOfFloat[0] = (-0.5F + 0.0F);
    arrayOfFloat[1] = (-0.5F + 0.0F);
    arrayOfFloat[2] = (0.5F + 0.0F);
    arrayOfFloat[3] = (-0.5F + 0.0F);
    arrayOfFloat[4] = (-0.5F + 0.0F);
    arrayOfFloat[5] = (0.5F + 0.0F);
    arrayOfFloat[6] = (0.5F + 0.0F);
    arrayOfFloat[7] = (0.5F + 0.0F);
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(arrayOfFloat.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.jdField_a_of_type_JavaNioFloatBuffer = localByteBuffer.asFloatBuffer();
    this.jdField_a_of_type_JavaNioFloatBuffer.put(arrayOfFloat);
    this.jdField_a_of_type_JavaNioFloatBuffer.position(0);
  }
  
  private void c()
  {
    if (this.h == b)
    {
      int[] arrayOfInt = new int[1];
      GLES20.glGenTextures(1, arrayOfInt, 0);
      this.h = arrayOfInt[0];
    }
    this.g = b(this.c, this.d, this.h);
  }
  
  private void d()
  {
    if (this.f == b)
    {
      int[] arrayOfInt = new int[1];
      GLES20.glGenTextures(1, arrayOfInt, 0);
      this.f = arrayOfInt[0];
    }
    this.e = a(this.c, this.d, this.f);
  }
  
  public void a()
  {
    if (this.e != b)
    {
      GLES20.glDeleteFramebuffers(2, new int[] { this.e, this.g }, 0);
      GLES20.glDeleteTextures(2, new int[] { this.f, this.h }, 0);
    }
    this.e = b;
    this.f = b;
    this.g = b;
    this.h = b;
  }
  
  public void a(GLCanvas paramGLCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      paramGLCanvas = paramGLCanvas.a().a(BasicTexture.class);
      GLES20.glUseProgram(paramGLCanvas.a());
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.h);
      GLES20.glUniform1i(paramGLCanvas.a()[4].a, 0);
      GLES20.glUniform1f(paramGLCanvas.a()[2].a, 1.0F);
    }
  }
  
  public void a(GLCanvas paramGLCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOfFloat, int paramInt8, int paramInt9)
  {
    if ((this.c != paramInt1 * 2) || (this.e == b))
    {
      this.c = (paramInt1 * 2);
      this.d = (paramInt2 * 2);
      d();
      c();
      b();
    }
    GLES20.glBindFramebuffer(36160, this.e);
    GLES20.glViewport(0, 0, this.c, this.d);
    GLES20.glClearColor(0.4F, 0.4F, 0.4F, 1.0F);
    GLES20.glClear(16640);
    TextureProgram localTextureProgram = paramGLCanvas.a().a(YuvFboTexture.class);
    ShaderParameter[] arrayOfShaderParameter = localTextureProgram.a();
    GLES20.glUseProgram(localTextureProgram.a());
    GLES20.glUniform1f(localTextureProgram.a()[7].a, paramInt1);
    GLES20.glUniform1f(localTextureProgram.a()[8].a, paramInt2);
    GLES20.glUniformMatrix4fv(localTextureProgram.a()[9].a, 1, false, paramArrayOfFloat, 0);
    GLES20.glUniform1i(localTextureProgram.a()[10].a, paramInt8);
    GLES20.glUniform1i(localTextureProgram.a()[11].a, paramInt9);
    GLES20Canvas.a(false);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt5);
    GLES20.glUniform1i(arrayOfShaderParameter[4].a, 0);
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(3553, paramInt6);
    GLES20.glUniform1i(arrayOfShaderParameter[5].a, 1);
    GLES20.glActiveTexture(33986);
    GLES20.glBindTexture(3553, paramInt7);
    GLES20.glUniform1i(arrayOfShaderParameter[6].a, 2);
    GLES20.glUniform1f(arrayOfShaderParameter[2].a, 1.0F);
    GLES20.glUniformMatrix4fv(arrayOfShaderParameter[1].a, 1, false, AVGLUtils.b, 0);
    GLES20.glUniformMatrix4fv(arrayOfShaderParameter[3].a, 1, false, AVGLUtils.a, 0);
    GLES20.glVertexAttribPointer(arrayOfShaderParameter[0].a, 2, 5126, false, 8, this.jdField_a_of_type_JavaNioFloatBuffer);
    GLES20.glEnableVertexAttribArray(arrayOfShaderParameter[0].a);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDisableVertexAttribArray(arrayOfShaderParameter[0].a);
    GLES20.glBindFramebuffer(36160, this.g);
    GLES20.glViewport(0, 0, this.c, this.d);
    GLES20.glClearColor(0.4F, 0.4F, 0.4F, 1.0F);
    GLES20.glClear(16640);
    localTextureProgram = paramGLCanvas.a().a(SharpenProgram.class);
    arrayOfShaderParameter = localTextureProgram.a();
    GLES20.glUseProgram(localTextureProgram.a());
    GLES20.glUniform1f(localTextureProgram.a()[7].a, paramInt1);
    GLES20.glUniform1f(localTextureProgram.a()[8].a, paramInt2);
    GLES20.glUniformMatrix4fv(localTextureProgram.a()[9].a, 1, false, paramArrayOfFloat, 0);
    GLES20.glUniform1i(localTextureProgram.a()[10].a, paramInt8);
    GLES20.glUniform1i(localTextureProgram.a()[11].a, paramInt9);
    GLES20Canvas.a(false);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.f);
    GLES20.glUniform1i(arrayOfShaderParameter[4].a, 0);
    GLES20.glUniform1f(arrayOfShaderParameter[2].a, 1.0F);
    GLES20.glUniformMatrix4fv(arrayOfShaderParameter[1].a, 1, false, AVGLUtils.b, 0);
    GLES20.glUniformMatrix4fv(arrayOfShaderParameter[3].a, 1, false, AVGLUtils.a, 0);
    GLES20.glVertexAttribPointer(arrayOfShaderParameter[0].a, 2, 5126, false, 8, this.jdField_a_of_type_JavaNioFloatBuffer);
    GLES20.glEnableVertexAttribArray(arrayOfShaderParameter[0].a);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDisableVertexAttribArray(arrayOfShaderParameter[0].a);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glViewport(0, 0, paramInt3, paramInt4);
    a(paramGLCanvas, paramInt1, paramInt2, paramInt5, paramInt6, paramInt7);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\opengl\texture\FrameBufferCenterTexture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */