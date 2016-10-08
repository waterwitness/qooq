package com.tencent.mobileqq.shortvideo.util.videoconverter;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class TextureRender
{
  private static final int jdField_a_of_type_Int = 4;
  private static final String jdField_a_of_type_JavaLangString = "TextureRender";
  private static final int jdField_b_of_type_Int = 20;
  private static final String jdField_b_of_type_JavaLangString = "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
  private static final int jdField_c_of_type_Int = 0;
  private static final String jdField_c_of_type_JavaLangString = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
  private static final int d = 3;
  private FloatBuffer jdField_a_of_type_JavaNioFloatBuffer;
  private final float[] jdField_a_of_type_ArrayOfFloat;
  private float[] jdField_b_of_type_ArrayOfFloat;
  private float[] jdField_c_of_type_ArrayOfFloat;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  
  public TextureRender()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ArrayOfFloat = new float[] { -1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 1.0F, -1.0F, 0.0F, 1.0F, 0.0F, -1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
    this.b = new float[16];
    this.c = new float[16];
    this.f = 53191;
    this.jdField_a_of_type_JavaNioFloatBuffer = ByteBuffer.allocateDirect(this.jdField_a_of_type_ArrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.jdField_a_of_type_JavaNioFloatBuffer.put(this.jdField_a_of_type_ArrayOfFloat).position(0);
    Matrix.setIdentityM(this.c, 0);
  }
  
  private int a(int paramInt, String paramString)
  {
    int k = GLES20.glCreateShader(paramInt);
    b("glCreateShader type=" + paramInt);
    GLES20.glShaderSource(k, paramString);
    GLES20.glCompileShader(k);
    paramString = new int[1];
    GLES20.glGetShaderiv(k, 35713, paramString, 0);
    if (paramString[0] == 0)
    {
      Log.e("TextureRender", "Could not compile shader " + paramInt + ":");
      Log.e("TextureRender", " " + GLES20.glGetShaderInfoLog(k));
      GLES20.glDeleteShader(k);
      return 0;
    }
    return k;
  }
  
  private int a(String paramString1, String paramString2)
  {
    int k = a(35633, paramString1);
    if (k == 0) {}
    int m;
    do
    {
      return 0;
      m = a(35632, paramString2);
    } while (m == 0);
    int n = GLES20.glCreateProgram();
    b("glCreateProgram");
    if (n == 0) {
      Log.e("TextureRender", "Could not create program");
    }
    GLES20.glAttachShader(n, k);
    b("glAttachShader");
    GLES20.glAttachShader(n, m);
    b("glAttachShader");
    GLES20.glLinkProgram(n);
    paramString1 = new int[1];
    GLES20.glGetProgramiv(n, 35714, paramString1, 0);
    if (paramString1[0] != 1)
    {
      Log.e("TextureRender", "Could not link program: ");
      Log.e("TextureRender", GLES20.glGetProgramInfoLog(n));
      GLES20.glDeleteProgram(n);
      return 0;
    }
    return n;
  }
  
  public int a()
  {
    return this.f;
  }
  
  public void a()
  {
    this.e = a("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
    if (this.e == 0) {
      throw new RuntimeException("failed creating program");
    }
    this.i = GLES20.glGetAttribLocation(this.e, "aPosition");
    b("glGetAttribLocation aPosition");
    if (this.i == -1) {
      throw new RuntimeException("Could not get attrib location for aPosition");
    }
    this.j = GLES20.glGetAttribLocation(this.e, "aTextureCoord");
    b("glGetAttribLocation aTextureCoord");
    if (this.j == -1) {
      throw new RuntimeException("Could not get attrib location for aTextureCoord");
    }
    this.g = GLES20.glGetUniformLocation(this.e, "uMVPMatrix");
    b("glGetUniformLocation uMVPMatrix");
    if (this.g == -1) {
      throw new RuntimeException("Could not get attrib location for uMVPMatrix");
    }
    this.h = GLES20.glGetUniformLocation(this.e, "uSTMatrix");
    b("glGetUniformLocation uSTMatrix");
    if (this.h == -1) {
      throw new RuntimeException("Could not get attrib location for uSTMatrix");
    }
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    this.f = arrayOfInt[0];
    GLES20.glBindTexture(36197, this.f);
    b("glBindTexture mTextureID");
    GLES20.glTexParameterf(36197, 10241, 9728.0F);
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameteri(36197, 10242, 33071);
    GLES20.glTexParameteri(36197, 10243, 33071);
    b("glTexParameter");
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    b("onDrawFrame start");
    paramSurfaceTexture.getTransformMatrix(this.c);
    GLES20.glClearColor(0.0F, 1.0F, 0.0F, 1.0F);
    GLES20.glClear(16640);
    GLES20.glUseProgram(this.e);
    b("glUseProgram");
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(36197, this.f);
    this.jdField_a_of_type_JavaNioFloatBuffer.position(0);
    GLES20.glVertexAttribPointer(this.i, 3, 5126, false, 20, this.jdField_a_of_type_JavaNioFloatBuffer);
    b("glVertexAttribPointer maPosition");
    GLES20.glEnableVertexAttribArray(this.i);
    b("glEnableVertexAttribArray maPositionHandle");
    this.jdField_a_of_type_JavaNioFloatBuffer.position(3);
    GLES20.glVertexAttribPointer(this.j, 2, 5126, false, 20, this.jdField_a_of_type_JavaNioFloatBuffer);
    b("glVertexAttribPointer maTextureHandle");
    GLES20.glEnableVertexAttribArray(this.j);
    b("glEnableVertexAttribArray maTextureHandle");
    Matrix.setIdentityM(this.b, 0);
    GLES20.glUniformMatrix4fv(this.g, 1, false, this.b, 0);
    GLES20.glUniformMatrix4fv(this.h, 1, false, this.c, 0);
    GLES20.glDrawArrays(5, 0, 4);
    b("glDrawArrays");
    GLES20.glFinish();
  }
  
  public void a(String paramString)
  {
    GLES20.glDeleteProgram(this.e);
    this.e = a("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", paramString);
    if (this.e == 0) {
      throw new RuntimeException("failed creating program");
    }
  }
  
  public void b(String paramString)
  {
    int k = GLES20.glGetError();
    if (k != 0)
    {
      Log.e("TextureRender", paramString + ": glError " + k);
      throw new RuntimeException(paramString + ": glError " + k);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\util\videoconverter\TextureRender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */