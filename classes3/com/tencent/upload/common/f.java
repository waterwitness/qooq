package com.tencent.upload.common;

import android.content.Context;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.IUploadEnv;
import com.tencent.upload.uinterface.IUploadLog;
import com.tencent.upload.uinterface.IUploadReport;

public final class f
{
  private static Context a;
  private static IUploadConfig b;
  private static IUploadReport c;
  private static IUploadLog d;
  private static final IUploadReport e = new com.tencent.upload.a.f();
  private static IUploadEnv f;
  
  public static final Context a()
  {
    return a;
  }
  
  public static void a(Context paramContext, IUploadConfig paramIUploadConfig, IUploadLog paramIUploadLog, IUploadReport paramIUploadReport, IUploadEnv paramIUploadEnv)
  {
    if ((paramContext == null) || (paramIUploadConfig == null)) {
      throw new RuntimeException("upload组件init初始化参数错误！");
    }
    a = paramContext;
    b = paramIUploadConfig;
    c = paramIUploadReport;
    d = paramIUploadLog;
    f = paramIUploadEnv;
  }
  
  public static final IUploadConfig b()
  {
    return b;
  }
  
  public static IUploadReport c()
  {
    if (c == null) {
      return e;
    }
    return c;
  }
  
  public static final IUploadLog d()
  {
    return d;
  }
  
  public static final IUploadEnv e()
  {
    return f;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\common\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */