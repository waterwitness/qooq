package com.tencent.av.gvideo;

import android.app.Notification;
import android.os.IInterface;
import com.tencent.arrange.op.MeetingInfo;
import com.tencent.av.service.IAVServiceCallback;

public abstract interface IGVServiceForQQ
  extends IInterface
{
  public abstract int a(long paramLong, int paramInt);
  
  public abstract void a();
  
  public abstract void a(MeetingInfo paramMeetingInfo);
  
  public abstract void a(IAVServiceCallback paramIAVServiceCallback);
  
  public abstract void a(boolean paramBoolean, Notification paramNotification);
  
  public abstract void a(byte[] paramArrayOfByte);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\gvideo\IGVServiceForQQ.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */