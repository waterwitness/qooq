package com.tencent.mobileqq.util;

import AvatarInfo.QQHeadInfo;
import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import java.util.ArrayList;
import vxw;

public class FaceDecoder
{
  FaceDecoderBase a;
  
  public FaceDecoder(Context paramContext, AppInterface paramAppInterface)
  {
    this(paramAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public FaceDecoder(AppInterface paramAppInterface)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      this.a = new FaceDecoderImpl((QQAppInterface)paramAppInterface);
    }
    while (this.a == null)
    {
      throw new NullPointerException("can not Instantiation FaceDecoder");
      if ((paramAppInterface instanceof NearbyAppInterface)) {
        this.a = new NearbyFaceDecoder((NearbyAppInterface)paramAppInterface);
      }
    }
  }
  
  protected static void a(QQAppInterface paramQQAppInterface, FaceInfo paramFaceInfo)
  {
    if ((paramQQAppInterface == null) || (paramFaceInfo == null)) {
      return;
    }
    ThreadManager.a(new vxw(paramFaceInfo, paramQQAppInterface), 10, null, true);
  }
  
  public Bitmap a(int paramInt, String paramString)
  {
    if (paramInt == 32) {
      return null;
    }
    byte b = 3;
    if ((paramInt == 101) || (paramInt == 1001)) {
      b = 1;
    }
    return this.a.a(paramInt, paramString, 0, b);
  }
  
  public Bitmap a(int paramInt1, String paramString, int paramInt2)
  {
    return a(paramInt1, paramString, paramInt2, (byte)3);
  }
  
  public Bitmap a(int paramInt1, String paramString, int paramInt2, byte paramByte)
  {
    return this.a.a(paramInt1, paramString, paramInt2, paramByte);
  }
  
  public void a()
  {
    this.a.c();
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, long paramLong)
  {
    this.a.a(paramInt1, paramString, paramInt2, paramLong);
  }
  
  public void a(AppInterface paramAppInterface)
  {
    this.a.a(paramAppInterface);
  }
  
  public void a(FaceDecoder.DecodeTaskCompletionListener paramDecodeTaskCompletionListener)
  {
    this.a.a(paramDecodeTaskCompletionListener);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.a(paramBoolean);
  }
  
  public boolean a()
  {
    return this.a.b();
  }
  
  public boolean a(String paramString, int paramInt, boolean paramBoolean)
  {
    return this.a.a(paramString, 200, false, paramInt, paramBoolean, (byte)0, 3);
  }
  
  public boolean a(String paramString, int paramInt, boolean paramBoolean, byte paramByte)
  {
    return this.a.a(paramString, 200, false, paramInt, paramBoolean, paramByte, 3);
  }
  
  public boolean a(String paramString, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, byte paramByte, int paramInt3)
  {
    return this.a.a(paramString, paramInt1, paramBoolean1, paramInt2, paramBoolean2, paramByte, paramInt3);
  }
  
  public boolean a(String paramString, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, byte paramByte, int paramInt3, QQHeadInfo paramQQHeadInfo)
  {
    return this.a.a(paramString, paramInt1, paramBoolean1, paramInt2, paramBoolean2, paramByte, paramInt3, paramQQHeadInfo);
  }
  
  public boolean a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return this.a.a(paramString, paramInt, paramBoolean1, 32, paramBoolean2, (byte)1, 3);
  }
  
  public boolean a(ArrayList paramArrayList)
  {
    return this.a.a(paramArrayList);
  }
  
  public void b()
  {
    this.a.b();
  }
  
  public void b(boolean paramBoolean)
  {
    this.a.b(paramBoolean);
  }
  
  public boolean b()
  {
    return this.a.a();
  }
  
  public boolean b(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return this.a.a(paramString, paramInt, paramBoolean1, 32, paramBoolean2, (byte)1, 1);
  }
  
  public void c()
  {
    this.a.a();
  }
  
  public boolean c(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return this.a.a(paramString, paramInt, paramBoolean1, 16, paramBoolean2, (byte)1, 3);
  }
  
  public void d()
  {
    this.a.d();
  }
  
  public boolean d(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return this.a.a(paramString, paramInt, paramBoolean1, 16, paramBoolean2, (byte)1, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\util\FaceDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */