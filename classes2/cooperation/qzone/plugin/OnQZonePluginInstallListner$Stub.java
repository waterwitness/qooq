package cooperation.qzone.plugin;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import yns;

public abstract class OnQZonePluginInstallListner$Stub
  extends Binder
  implements OnQZonePluginInstallListner
{
  static final int jdField_a_of_type_Int = 1;
  private static final String jdField_a_of_type_JavaLangString = "cooperation.qzone.plugin.OnQZonePluginInstallListner";
  static final int b = 2;
  static final int c = 3;
  static final int d = 4;
  
  public OnQZonePluginInstallListner$Stub()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    attachInterface(this, "cooperation.qzone.plugin.OnQZonePluginInstallListner");
  }
  
  public static OnQZonePluginInstallListner a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("cooperation.qzone.plugin.OnQZonePluginInstallListner");
    if ((localIInterface != null) && ((localIInterface instanceof OnQZonePluginInstallListner))) {
      return (OnQZonePluginInstallListner)localIInterface;
    }
    return new yns(paramIBinder);
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
      paramParcel2.writeString("cooperation.qzone.plugin.OnQZonePluginInstallListner");
      return true;
    case 1: 
      paramParcel1.enforceInterface("cooperation.qzone.plugin.OnQZonePluginInstallListner");
      a(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 2: 
      paramParcel1.enforceInterface("cooperation.qzone.plugin.OnQZonePluginInstallListner");
      a(paramParcel1.readString(), paramParcel1.readFloat(), paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("cooperation.qzone.plugin.OnQZonePluginInstallListner");
      b(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("cooperation.qzone.plugin.OnQZonePluginInstallListner");
    a(paramParcel1.readString(), paramParcel1.readInt());
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\plugin\OnQZonePluginInstallListner$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */