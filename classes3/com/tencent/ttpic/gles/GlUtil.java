package com.tencent.ttpic.gles;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class GlUtil
{
  public static final float[] IDENTITY_MATRIX = new float[16];
  private static final int SIZEOF_FLOAT = 4;
  public static final String TAG = "Grafika";
  
  static
  {
    Matrix.setIdentityM(IDENTITY_MATRIX, 0);
  }
  
  public static void checkGlError(String paramString)
  {
    int i = GLES20.glGetError();
    if (i != 0)
    {
      paramString = paramString + ": glError 0x" + Integer.toHexString(i);
      Log.e("Grafika", paramString);
      throw new RuntimeException(paramString);
    }
  }
  
  public static void checkLocation(int paramInt, String paramString)
  {
    if (paramInt < 0) {
      throw new RuntimeException("Unable to locate '" + paramString + "' in program");
    }
  }
  
  public static FloatBuffer createFloatBuffer(float[] paramArrayOfFloat)
  {
    Object localObject = ByteBuffer.allocateDirect(paramArrayOfFloat.length * 4);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    localObject = ((ByteBuffer)localObject).asFloatBuffer();
    ((FloatBuffer)localObject).put(paramArrayOfFloat);
    ((FloatBuffer)localObject).position(0);
    return (FloatBuffer)localObject;
  }
  
  public static int createImageTexture(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3)
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    int i = arrayOfInt[0];
    checkGlError("glGenTextures");
    GLES20.glBindTexture(3553, i);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10240, 9729);
    checkGlError("loadImageTexture");
    GLES20.glTexImage2D(3553, 0, paramInt3, paramInt1, paramInt2, 0, paramInt3, 5121, paramByteBuffer);
    checkGlError("loadImageTexture");
    return i;
  }
  
  public static int createProgram(String paramString1, String paramString2)
  {
    int i = loadShader(35633, paramString1);
    if (i == 0) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      int k = loadShader(35632, paramString2);
      if (k == 0) {
        return 0;
      }
      j = GLES20.glCreateProgram();
      checkGlError("glCreateProgram");
      if (j == 0) {
        Log.e("Grafika", "Could not create program");
      }
      GLES20.glAttachShader(j, i);
      checkGlError("glAttachShader");
      GLES20.glAttachShader(j, k);
      checkGlError("glAttachShader");
      GLES20.glLinkProgram(j);
      paramString1 = new int[1];
      GLES20.glGetProgramiv(j, 35714, paramString1, 0);
      i = j;
    } while (paramString1[0] == 1);
    Log.e("Grafika", "Could not link program: ");
    Log.e("Grafika", GLES20.glGetProgramInfoLog(j));
    GLES20.glDeleteProgram(j);
    return 0;
  }
  
  public static int loadShader(int paramInt, String paramString)
  {
    int j = GLES20.glCreateShader(paramInt);
    checkGlError("glCreateShader type=" + paramInt);
    GLES20.glShaderSource(j, paramString);
    GLES20.glCompileShader(j);
    paramString = new int[1];
    GLES20.glGetShaderiv(j, 35713, paramString, 0);
    int i = j;
    if (paramString[0] == 0)
    {
      Log.e("Grafika", "Could not compile shader " + paramInt + ":");
      Log.e("Grafika", " " + GLES20.glGetShaderInfoLog(j));
      GLES20.glDeleteShader(j);
      i = 0;
    }
    return i;
  }
  
  public static void logVersionInfo()
  {
    Log.i("Grafika", "vendor  : " + GLES20.glGetString(7936));
    Log.i("Grafika", "renderer: " + GLES20.glGetString(7937));
    Log.i("Grafika", "version : " + GLES20.glGetString(7938));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\gles\GlUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */