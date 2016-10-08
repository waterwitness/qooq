package com.tencent.tmdownloader.internal.downloadclient;

import android.content.Context;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistantbase.a.m;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.BatchSDKDownloadActionResponse;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.SubScribeSDKDownloadTaskByViaResponse;

public class b
{
  private static String a = "TMAssistantYYBManager";
  private com.tencent.tmassistantsdk.internal.b.b b;
  private com.tencent.tmdownloader.d c;
  private Context d;
  private String e;
  private String f;
  private com.tencent.tmassistantsdk.internal.b.a g = new c(this);
  private com.tencent.tmdownloader.a h = new e(this);
  
  public static byte[] a(JceStruct paramJceStruct, String paramString)
  {
    m.c(a, "jceStruct = " + paramJceStruct);
    paramJceStruct = com.tencent.tmassistantsdk.internal.openSDK.param.a.a(paramJceStruct, paramString);
    if (paramJceStruct != null)
    {
      paramJceStruct = com.tencent.tmassistantsdk.internal.openSDK.param.a.a(paramJceStruct);
      if ((paramJceStruct != null) && (paramJceStruct.length > 0))
      {
        m.c(a, "return sendData length = " + paramJceStruct.length);
        return paramJceStruct;
      }
      m.c(a, "handleUriAction sendData = null");
      return null;
    }
    m.c(a, "handleUriAction IPCRequest = null");
    return null;
  }
  
  public void a()
  {
    com.tencent.tmassistant.common.c.a().post(new d(this));
  }
  
  public void a(Context paramContext, String paramString)
  {
    this.d = paramContext;
    this.e = paramString;
    m.c(a, "initYYBClient yybOpenClient......" + this.b);
    if (this.b == null)
    {
      this.b = new com.tencent.tmassistantsdk.internal.b.b(paramContext, paramString, "com.tencent.android.qqdownloader.SDKService");
      if (this.b != null)
      {
        this.b.initTMAssistantDownloadSDK();
        this.b.a(this.g);
      }
    }
  }
  
  public void a(BatchSDKDownloadActionResponse paramBatchSDKDownloadActionResponse)
  {
    if (this.c == null)
    {
      this.c = new com.tencent.tmdownloader.d(this.d, this.f);
      this.c.a(this.h);
    }
    try
    {
      this.c.a(paramBatchSDKDownloadActionResponse);
      return;
    }
    catch (Exception paramBatchSDKDownloadActionResponse)
    {
      paramBatchSDKDownloadActionResponse.printStackTrace();
    }
  }
  
  public void a(SubScribeSDKDownloadTaskByViaResponse paramSubScribeSDKDownloadTaskByViaResponse)
  {
    if (this.c == null)
    {
      this.c = new com.tencent.tmdownloader.d(this.d, this.f);
      this.c.a(this.h);
    }
    try
    {
      this.c.a(paramSubScribeSDKDownloadTaskByViaResponse);
      return;
    }
    catch (Exception paramSubScribeSDKDownloadTaskByViaResponse)
    {
      paramSubScribeSDKDownloadTaskByViaResponse.printStackTrace();
    }
  }
  
  public void b(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      this.d = paramContext;
      this.f = paramString;
    } while (this.c != null);
    this.f = paramString;
    this.c = new com.tencent.tmdownloader.d(paramContext, paramString);
    this.c.a(this.h);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmdownloader\internal\downloadclient\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */