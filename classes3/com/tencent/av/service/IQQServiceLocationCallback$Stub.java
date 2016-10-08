package com.tencent.av.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import gnc;

public abstract class IQQServiceLocationCallback$Stub
  extends Binder
  implements IQQServiceLocationCallback
{
  static final int jdField_a_of_type_Int = 1;
  private static final String jdField_a_of_type_JavaLangString = "com.tencent.av.service.IQQServiceLocationCallback";
  static final int b = 2;
  
  public IQQServiceLocationCallback$Stub()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    attachInterface(this, "com.tencent.av.service.IQQServiceLocationCallback");
  }
  
  public static IQQServiceLocationCallback a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.av.service.IQQServiceLocationCallback");
    if ((localIInterface != null) && ((localIInterface instanceof IQQServiceLocationCallback))) {
      return (IQQServiceLocationCallback)localIInterface;
    }
    return new gnc(paramIBinder);
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
      paramParcel2.writeString("com.tencent.av.service.IQQServiceLocationCallback");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceLocationCallback");
      a(paramParcel1.readInt(), paramParcel1.readString());
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceLocationCallback");
    boolean bool;
    if (paramParcel1.readInt() != 0)
    {
      bool = true;
      if (paramParcel1.readInt() == 0) {
        break label125;
      }
    }
    label125:
    for (paramParcel1 = (LBSInfo)LBSInfo.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      a(bool, paramParcel1);
      return true;
      bool = false;
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\service\IQQServiceLocationCallback$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */