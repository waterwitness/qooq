package com.tencent.mobileqq.ar.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import qpr;

public abstract class IArRemoteCallback$Stub
  extends Binder
  implements IArRemoteCallback
{
  static final int jdField_a_of_type_Int = 1;
  private static final String jdField_a_of_type_JavaLangString = "com.tencent.mobileqq.ar.aidl.IArRemoteCallback";
  static final int b = 2;
  static final int c = 3;
  static final int d = 4;
  
  public IArRemoteCallback$Stub()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    attachInterface(this, "com.tencent.mobileqq.ar.aidl.IArRemoteCallback");
  }
  
  public static IArRemoteCallback a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.ar.aidl.IArRemoteCallback");
    if ((localIInterface != null) && ((localIInterface instanceof IArRemoteCallback))) {
      return (IArRemoteCallback)localIInterface;
    }
    return new qpr(paramIBinder);
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
      paramParcel2.writeString("com.tencent.mobileqq.ar.aidl.IArRemoteCallback");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArRemoteCallback");
      a();
      paramParcel2.writeNoException();
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArRemoteCallback");
      a(paramParcel1.readLong(), paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArRemoteCallback");
      a(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArRemoteCallback");
    ArConfigInfo localArConfigInfo;
    if (paramParcel1.readInt() != 0)
    {
      localArConfigInfo = (ArConfigInfo)ArConfigInfo.CREATOR.createFromParcel(paramParcel1);
      if (paramParcel1.readInt() == 0) {
        break label196;
      }
    }
    label196:
    for (paramParcel1 = (ArEffectConfig)ArEffectConfig.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      a(localArConfigInfo, paramParcel1);
      paramParcel2.writeNoException();
      return true;
      localArConfigInfo = null;
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ar\aidl\IArRemoteCallback$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */