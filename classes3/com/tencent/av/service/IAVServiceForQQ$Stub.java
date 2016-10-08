package com.tencent.av.service;

import android.app.Notification;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.arrange.op.MeetingInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import gmz;

public abstract class IAVServiceForQQ$Stub
  extends Binder
  implements IAVServiceForQQ
{
  static final int jdField_a_of_type_Int = 1;
  private static final String jdField_a_of_type_JavaLangString = "com.tencent.av.service.IAVServiceForQQ";
  static final int b = 2;
  static final int c = 3;
  static final int d = 4;
  static final int e = 5;
  static final int f = 6;
  static final int g = 7;
  static final int h = 8;
  static final int i = 9;
  static final int j = 10;
  
  public IAVServiceForQQ$Stub()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    attachInterface(this, "com.tencent.av.service.IAVServiceForQQ");
  }
  
  public static IAVServiceForQQ a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.av.service.IAVServiceForQQ");
    if ((localIInterface != null) && ((localIInterface instanceof IAVServiceForQQ))) {
      return (IAVServiceForQQ)localIInterface;
    }
    return new gmz(paramIBinder);
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
      paramParcel2.writeString("com.tencent.av.service.IAVServiceForQQ");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
      a(IAVServiceCallback.Stub.a(paramParcel1.readStrongBinder()));
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
      a(paramParcel1.createByteArray());
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
      b(paramParcel1.createByteArray());
      paramParcel2.writeNoException();
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
      c(paramParcel1.createByteArray());
      paramParcel2.writeNoException();
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
      boolean bool;
      if (paramParcel1.readInt() != 0)
      {
        bool = true;
        if (paramParcel1.readInt() == 0) {
          break label248;
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
    case 6: 
      paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (MeetingInfo)MeetingInfo.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 7: 
      paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
      paramParcel2 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Bitmap)Bitmap.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(paramParcel2, paramParcel1);
        return true;
      }
    case 8: 
      paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
      paramInt1 = a(paramParcel1.readLong(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 9: 
      label248:
      paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
      a(paramParcel1.readString());
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
    paramParcel1 = a(paramParcel1.createByteArray());
    paramParcel2.writeNoException();
    if (paramParcel1 != null)
    {
      paramParcel2.writeInt(1);
      paramParcel1.writeToParcel(paramParcel2, 1);
      return true;
    }
    paramParcel2.writeInt(0);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\service\IAVServiceForQQ$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */