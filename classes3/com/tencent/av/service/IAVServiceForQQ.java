package com.tencent.av.service;

import android.app.Notification;
import android.graphics.Bitmap;
import android.os.IInterface;
import com.tencent.arrange.op.MeetingInfo;

public abstract interface IAVServiceForQQ
  extends IInterface
{
  public abstract int a(long paramLong, int paramInt);
  
  public abstract AVPbInfo a(byte[] paramArrayOfByte);
  
  public abstract void a(MeetingInfo paramMeetingInfo);
  
  public abstract void a(IAVServiceCallback paramIAVServiceCallback);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, Bitmap paramBitmap);
  
  public abstract void a(boolean paramBoolean, Notification paramNotification);
  
  public abstract void a(byte[] paramArrayOfByte);
  
  public abstract void b(byte[] paramArrayOfByte);
  
  public abstract void c(byte[] paramArrayOfByte);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\service\IAVServiceForQQ.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */