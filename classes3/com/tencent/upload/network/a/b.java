package com.tencent.upload.network.a;

import FileUpload.FileUploadHandShakeRsp;
import FileUpload.IpInfo;
import FileUpload.SvcResponsePacket;
import android.util.Log;
import com.tencent.upload.network.b.m;
import com.tencent.upload.uinterface.IUploadAction;
import java.util.ArrayList;

public class b
  implements IUploadAction
{
  private final int a;
  private final int b;
  private final int c;
  private m d;
  private String e;
  private long f;
  private long g;
  private int h;
  private final a i;
  
  public b(int paramInt1, int paramInt2, a parama)
  {
    this.i = parama;
    this.a = paramInt1;
    this.b = paramInt1;
    this.c = paramInt2;
    this.h = 0;
  }
  
  private final boolean a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return true;
    }
    try
    {
      localObject2 = (FileUploadHandShakeRsp)com.tencent.upload.b.a.a.a(FileUploadHandShakeRsp.class.getSimpleName(), paramArrayOfByte);
      localObject1 = null;
    }
    catch (Exception localException)
    {
      Object localObject3;
      for (;;)
      {
        Object localObject2;
        localObject1 = Log.getStackTraceString(localException);
        com.tencent.upload.a.b.a(b.class.getSimpleName(), localException);
        localObject3 = null;
      }
      paramArrayOfByte = ((FileUploadHandShakeRsp)localObject3).a;
      if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0)) {
        break label215;
      }
      paramArrayOfByte = (IpInfo)paramArrayOfByte.get(0);
      Object localObject1 = new StringBuffer();
      ((StringBuffer)localObject1).append(paramArrayOfByte.ip >>> 24).append(".");
      ((StringBuffer)localObject1).append(paramArrayOfByte.ip >> 16 & 0xFF).append(".");
      ((StringBuffer)localObject1).append(paramArrayOfByte.ip >> 8 & 0xFF).append(".");
      ((StringBuffer)localObject1).append(paramArrayOfByte.ip & 0xFF);
      this.d = new m(((StringBuffer)localObject1).toString(), paramArrayOfByte.port, null, 0, ((FileUploadHandShakeRsp)localObject3).b, 2);
      label215:
      if (((FileUploadHandShakeRsp)localObject3).d == 0L) {
        break label316;
      }
      paramArrayOfByte = new StringBuffer();
      paramArrayOfByte.append(((FileUploadHandShakeRsp)localObject3).d >> 24 & 0xFF).append(".");
      paramArrayOfByte.append(((FileUploadHandShakeRsp)localObject3).d >> 16 & 0xFF).append(".");
      paramArrayOfByte.append(((FileUploadHandShakeRsp)localObject3).d >> 8 & 0xFF).append(".");
      paramArrayOfByte.append(((FileUploadHandShakeRsp)localObject3).d & 0xFF);
      this.e = paramArrayOfByte.toString();
      label316:
      if (((FileUploadHandShakeRsp)localObject3).c <= 0L) {
        break label344;
      }
      this.f = ((FileUploadHandShakeRsp)localObject3).c;
      this.g = (System.currentTimeMillis() / 1000L);
    }
    if (localObject2 == null)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "decodeContent() unpack FileUploadHandShakeRsp=null. " + paramArrayOfByte;
      }
      com.tencent.upload.a.b.e(b.class.getSimpleName(), (String)localObject2);
      return false;
    }
    label344:
    return true;
  }
  
  public final m a()
  {
    return this.d;
  }
  
  public final String b()
  {
    return this.e;
  }
  
  public final long[] c()
  {
    if (this.f <= 0L) {
      return null;
    }
    return new long[] { this.f, this.g };
  }
  
  public int getActionSequence()
  {
    return this.a;
  }
  
  public int getSendState()
  {
    return this.h;
  }
  
  public int getServerCategory()
  {
    return 0;
  }
  
  public void onCancel(int paramInt)
  {
    this.h = 0;
  }
  
  public void onConnecting() {}
  
  public void onError(com.tencent.upload.network.c.a parama, int paramInt, String paramString, boolean paramBoolean)
  {
    paramBoolean = false;
    this.h = 0;
    if (this.i != null)
    {
      if (30300 == paramInt) {
        this.i.a();
      }
    }
    else {
      return;
    }
    parama = this.i;
    if (paramInt == 35000) {
      paramBoolean = true;
    }
    parama.a(paramBoolean);
  }
  
  public void onRequest(com.tencent.upload.network.c.a parama, d paramd)
  {
    if (paramd.g() != 1000) {
      return;
    }
    this.h = 2;
  }
  
  public void onResponse(com.tencent.upload.network.c.a parama, a parama1)
  {
    int k = 0;
    int j = k;
    if (this.h == 2)
    {
      j = k;
      if (parama1 != null)
      {
        parama = parama1.a();
        j = k;
        if (parama != null)
        {
          j = k;
          if (parama.e == 1000)
          {
            j = k;
            if (a(parama1.a().f)) {
              j = 1;
            }
          }
        }
      }
    }
    if (j == 0) {
      if (this.i != null) {
        this.i.a();
      }
    }
    do
    {
      return;
      this.h = 3;
    } while (this.i == null);
    this.i.a(this);
  }
  
  public boolean onSend(com.tencent.upload.network.c.a parama)
  {
    if (this.h != 0) {}
    while (!parama.a(new c(this.a, this.b, this.c))) {
      return false;
    }
    this.h = 1;
    return true;
  }
  
  public void onTimeout(com.tencent.upload.network.c.a parama, d paramd)
  {
    if (this.i != null) {
      this.i.a(false);
    }
  }
  
  public void setSessionService$191f3d4e(com.tencent.upload.network.b.b paramb) {}
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(b paramb);
    
    public abstract void a(boolean paramBoolean);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\network\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */