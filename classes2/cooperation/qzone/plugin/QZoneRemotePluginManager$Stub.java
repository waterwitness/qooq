package cooperation.qzone.plugin;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import yoo;

public abstract class QZoneRemotePluginManager$Stub
  extends Binder
  implements QZoneRemotePluginManager
{
  private static final String a = "cooperation.qzone.plugin.QZoneRemotePluginManager";
  static final int e = 1;
  static final int f = 2;
  static final int g = 3;
  static final int h = 4;
  static final int i = 5;
  static final int j = 6;
  
  public QZoneRemotePluginManager$Stub()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    attachInterface(this, "cooperation.qzone.plugin.QZoneRemotePluginManager");
  }
  
  public static QZoneRemotePluginManager a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("cooperation.qzone.plugin.QZoneRemotePluginManager");
    if ((localIInterface != null) && ((localIInterface instanceof QZoneRemotePluginManager))) {
      return (QZoneRemotePluginManager)localIInterface;
    }
    return new yoo(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int k = 0;
    boolean bool;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("cooperation.qzone.plugin.QZoneRemotePluginManager");
      return true;
    case 1: 
      paramParcel1.enforceInterface("cooperation.qzone.plugin.QZoneRemotePluginManager");
      bool = a();
      paramParcel2.writeNoException();
      paramInt1 = k;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 2: 
      paramParcel1.enforceInterface("cooperation.qzone.plugin.QZoneRemotePluginManager");
      bool = a(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramInt1 = m;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 3: 
      paramParcel1.enforceInterface("cooperation.qzone.plugin.QZoneRemotePluginManager");
      bool = a(paramParcel1.readString(), OnQZonePluginInstallListner.Stub.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      paramInt1 = n;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 4: 
      paramParcel1.enforceInterface("cooperation.qzone.plugin.QZoneRemotePluginManager");
      bool = b(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramInt1 = i1;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 5: 
      paramParcel1.enforceInterface("cooperation.qzone.plugin.QZoneRemotePluginManager");
      bool = c(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramInt1 = i2;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    }
    paramParcel1.enforceInterface("cooperation.qzone.plugin.QZoneRemotePluginManager");
    paramParcel1 = a(paramParcel1.readString());
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


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\plugin\QZoneRemotePluginManager$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */