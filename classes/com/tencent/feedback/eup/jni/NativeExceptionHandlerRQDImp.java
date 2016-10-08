package com.tencent.feedback.eup.jni;

import android.content.Context;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.v;
import com.tencent.feedback.eup.CrashHandleListener;

public class NativeExceptionHandlerRQDImp
  implements NativeExceptionHandler
{
  private static NativeExceptionHandlerRQDImp a;
  public static CrashHandleListener listener;
  private String b;
  
  private NativeExceptionHandlerRQDImp(Context paramContext) {}
  
  public static NativeExceptionHandlerRQDImp getInstance()
  {
    try
    {
      NativeExceptionHandlerRQDImp localNativeExceptionHandlerRQDImp = a;
      return localNativeExceptionHandlerRQDImp;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static NativeExceptionHandlerRQDImp getInstance(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new NativeExceptionHandlerRQDImp(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public String getTombDir()
  {
    try
    {
      String str = this.b;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void handleNativeException(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    handleNativeException(paramInt1, paramInt2, paramLong1, paramLong2, paramString1, paramString2, paramString3, paramString4, -1234567890, "", -1, -1, -1, "", "unknown");
  }
  
  public void handleNativeException(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt3, String paramString5, int paramInt4, int paramInt5, int paramInt6, String paramString6, String paramString7)
  {
    v.c("rqdp{  na eup p:} %d , t:%d , exT:%d ,exTMS: %d, exTP:%s ,exADD:%s ,parsed exSTA:%s, TMB:%s , si_code:%d , si_CodeType:%s , sPid:%d ,sUid:%d,siErr:%d,siErrMsg:%s,naVersion:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString1, paramString2, paramString3, paramString4, Integer.valueOf(paramInt3), paramString5, Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), paramString6, paramString7 });
    c.a().k().handleNativeException(paramInt1, paramInt2, paramLong1, paramLong2, paramString1, paramString2, paramString3, paramString4, paramInt3, paramString5, paramInt4, paramInt5, paramInt6, paramString6, paramString7);
  }
  
  public void handleNativeException(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt3, String paramString5, int paramInt4, int paramInt5, int paramInt6, String paramString6, String paramString7, String[] paramArrayOfString)
  {
    c.a().k().handleNativeException2(paramInt1, paramInt2, paramLong1, paramLong2, paramString1, paramString2, paramString3, paramString4, paramInt3, paramString5, paramInt4, paramInt5, paramInt6, paramString6, paramString7, paramArrayOfString);
  }
  
  public void setTombDir(String paramString)
  {
    try
    {
      this.b = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\feedback\eup\jni\NativeExceptionHandlerRQDImp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */