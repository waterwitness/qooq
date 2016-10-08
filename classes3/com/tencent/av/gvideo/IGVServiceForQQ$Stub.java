package com.tencent.av.gvideo;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.arrange.op.MeetingInfo;
import com.tencent.av.service.IAVServiceCallback.Stub;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import gjj;

public abstract class IGVServiceForQQ$Stub
  extends Binder
  implements IGVServiceForQQ
{
  static final int jdField_a_of_type_Int = 1;
  private static final String jdField_a_of_type_JavaLangString = "com.tencent.av.gvideo.IGVServiceForQQ";
  static final int b = 2;
  static final int c = 3;
  static final int d = 4;
  static final int e = 5;
  static final int f = 6;
  
  public IGVServiceForQQ$Stub()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    attachInterface(this, "com.tencent.av.gvideo.IGVServiceForQQ");
  }
  
  public static IGVServiceForQQ a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.av.gvideo.IGVServiceForQQ");
    if ((localIInterface != null) && ((localIInterface instanceof IGVServiceForQQ))) {
      return (IGVServiceForQQ)localIInterface;
    }
    return new gjj(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.av.gvideo.IGVServiceForQQ");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.av.gvideo.IGVServiceForQQ");
      a(IAVServiceCallback.Stub.a(paramParcel1.readStrongBinder()));
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.tencent.av.gvideo.IGVServiceForQQ");
      a(paramParcel1.createByteArray());
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.tencent.av.gvideo.IGVServiceForQQ");
      boolean bool;
      if (paramParcel1.readInt() != 0)
      {
        bool = true;
        if (paramParcel1.readInt() == 0) {
          break label176;
        }
      }
      for (paramParcel1 = (Notification)Notification.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(bool, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        bool = false;
        break;
      }
    case 4: 
      paramParcel1.enforceInterface("com.tencent.av.gvideo.IGVServiceForQQ");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (MeetingInfo)MeetingInfo.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 5: 
      label176:
      paramParcel1.enforceInterface("com.tencent.av.gvideo.IGVServiceForQQ");
      paramInt1 = a(paramParcel1.readLong(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.av.gvideo.IGVServiceForQQ");
    a();
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\gvideo\IGVServiceForQQ$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */