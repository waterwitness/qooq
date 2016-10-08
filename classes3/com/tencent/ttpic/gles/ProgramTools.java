package com.tencent.ttpic.gles;

import android.content.Context;
import android.content.res.Resources;
import android.opengl.GLES20;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProgramTools
{
  public static int createProgram(String paramString1, String paramString2)
  {
    int i = GLES20.glCreateShader(35633);
    int j = GLES20.glCreateShader(35632);
    GLES20.glShaderSource(i, paramString1);
    GLES20.glShaderSource(j, paramString2);
    paramString1 = new int[1];
    GLES20.glCompileShader(i);
    GLES20.glGetShaderiv(i, 35713, paramString1, 0);
    if (paramString1[0] == 0) {
      throw new RuntimeException("vertext shader compile,failed:" + GLES20.glGetShaderInfoLog(i));
    }
    GLES20.glCompileShader(j);
    GLES20.glGetShaderiv(j, 35713, paramString1, 0);
    if (paramString1[0] == 0) {
      throw new RuntimeException("fragment shader compile,failed:" + GLES20.glGetShaderInfoLog(j));
    }
    int k = GLES20.glCreateProgram();
    GLES20.glAttachShader(k, i);
    GLES20.glAttachShader(k, j);
    GLES20.glLinkProgram(k);
    GLES20.glGetProgramiv(k, 35714, paramString1, 0);
    if (paramString1[0] == 0) {
      throw new RuntimeException("link program,failed:" + GLES20.glGetProgramInfoLog(k));
    }
    return k;
  }
  
  public static void createTexture(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
  {
    GLES20.glGenTextures(1, paramArrayOfInt, 0);
    GLES20.glBindTexture(3553, paramArrayOfInt[0]);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glTexParameteri(3553, 10241, 9728);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexImage2D(3553, 0, paramInt3, paramInt1, paramInt2, 0, paramInt3, 5121, null);
  }
  
  private static String readTextFile(Context paramContext, int paramInt)
  {
    paramContext = new BufferedReader(new InputStreamReader(paramContext.getResources().openRawResource(paramInt)));
    localStringBuilder = new StringBuilder();
    try
    {
      for (;;)
      {
        String str = paramContext.readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str);
        localStringBuilder.append("\n");
      }
      return localStringBuilder.toString();
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\gles\ProgramTools.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */