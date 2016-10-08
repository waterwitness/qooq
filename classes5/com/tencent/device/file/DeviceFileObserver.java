package com.tencent.device.file;

import android.os.Bundle;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class DeviceFileObserver
  implements BusinessObserver
{
  public static final int a = 100;
  public static final int b = 101;
  public static final int c = 102;
  public static final int d = 103;
  public static final int e = 104;
  public static final int f = 105;
  
  public DeviceFileObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 100: 
      a((Session)paramObject);
      return;
    case 101: 
      b((Session)paramObject);
      return;
    case 102: 
      paramObject = (Object[])paramObject;
      a((Session)paramObject[0], ((Float)paramObject[1]).floatValue());
      return;
    case 103: 
      a((Session)paramObject, paramBoolean);
      return;
    case 104: 
      a((Bundle)paramObject);
      return;
    }
    b((Bundle)paramObject);
  }
  
  public void a(Bundle paramBundle) {}
  
  public void a(Session paramSession) {}
  
  public void a(Session paramSession, float paramFloat) {}
  
  public void a(Session paramSession, boolean paramBoolean) {}
  
  public void a(MessageRecord paramMessageRecord, float paramFloat) {}
  
  public void a(MessageRecord paramMessageRecord, Boolean paramBoolean) {}
  
  public void b(Bundle paramBundle) {}
  
  public void b(Session paramSession) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\device\file\DeviceFileObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */