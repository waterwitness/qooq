package com.tencent.biz;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import hfn;
import java.lang.ref.WeakReference;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public abstract class ProtoUtils$TroopProtocolObserver
  implements BusinessObserver
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = -1;
  public boolean a;
  public WeakReference b;
  public int d;
  
  public ProtoUtils$TroopProtocolObserver()
  {
    this.d = 1;
    this.b = new WeakReference(null);
    this.a = true;
  }
  
  public ProtoUtils$TroopProtocolObserver(boolean paramBoolean)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.d = 1;
    this.b = new WeakReference(null);
    this.a = paramBoolean;
  }
  
  private void a(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (!paramBoolean) {
      a(-1, null, paramBundle);
    }
    do
    {
      return;
      Object localObject = paramBundle.getByteArray("data");
      if (this.d == 1)
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        try
        {
          localObject = (oidb_sso.OIDBSSOPkg)localOIDBSSOPkg.mergeFrom((byte[])localObject);
          if ((localObject == null) || (!((oidb_sso.OIDBSSOPkg)localObject).uint32_result.has()) || (!((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.has()) || (((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get() == null))
          {
            a(-1, null, paramBundle);
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          a(-1, null, paramBundle);
          return;
        }
        a(localInvalidProtocolBufferMicroException.uint32_result.get(), localInvalidProtocolBufferMicroException.bytes_bodybuffer.get().toByteArray(), paramBundle);
        return;
      }
    } while (this.d != 2);
    a(0, localInvalidProtocolBufferMicroException, paramBundle);
  }
  
  public abstract void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle);
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (this.a)
    {
      a(paramInt, paramBoolean, paramBundle);
      return;
    }
    ThreadManager.a(new hfn(this, paramInt, paramBoolean, paramBundle), 5, null, false);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\ProtoUtils$TroopProtocolObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */