package com.tencent.av.service;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import gnb;

public abstract class IQQServiceForAV$Stub
  extends Binder
  implements IQQServiceForAV
{
  static final int A = 27;
  static final int B = 28;
  static final int C = 29;
  static final int D = 30;
  static final int E = 31;
  static final int F = 32;
  static final int G = 33;
  static final int H = 34;
  static final int I = 35;
  static final int J = 36;
  static final int K = 37;
  static final int L = 38;
  static final int M = 39;
  static final int N = 40;
  static final int O = 41;
  static final int P = 42;
  static final int Q = 43;
  static final int R = 44;
  static final int S = 45;
  static final int T = 46;
  static final int U = 47;
  static final int V = 48;
  static final int W = 49;
  static final int X = 50;
  static final int Y = 51;
  static final int Z = 52;
  static final int jdField_a_of_type_Int = 1;
  private static final String jdField_a_of_type_JavaLangString = "com.tencent.av.service.IQQServiceForAV";
  static final int aa = 53;
  static final int ab = 54;
  static final int ac = 55;
  static final int b = 2;
  static final int c = 3;
  static final int d = 4;
  static final int e = 5;
  static final int f = 6;
  static final int g = 7;
  static final int h = 8;
  static final int i = 9;
  static final int j = 10;
  static final int k = 11;
  static final int l = 12;
  static final int m = 13;
  static final int n = 14;
  static final int o = 15;
  static final int p = 16;
  static final int q = 17;
  static final int r = 18;
  static final int s = 19;
  static final int t = 20;
  static final int u = 21;
  static final int v = 22;
  static final int w = 23;
  static final int x = 24;
  static final int y = 25;
  static final int z = 26;
  
  public IQQServiceForAV$Stub()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    attachInterface(this, "com.tencent.av.service.IQQServiceForAV");
  }
  
  public static IQQServiceForAV a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.av.service.IQQServiceForAV");
    if ((localIInterface != null) && ((localIInterface instanceof IQQServiceForAV))) {
      return (IQQServiceForAV)localIInterface;
    }
    return new gnb(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    int i6 = 0;
    int i7 = 0;
    int i8 = 0;
    int i9 = 0;
    int i10 = 0;
    boolean bool1 = false;
    int i11 = 0;
    int i12 = 0;
    int i13 = 0;
    boolean bool2 = false;
    boolean bool3 = false;
    int i1 = 0;
    String str1;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.av.service.IQQServiceForAV");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      bool1 = a(paramParcel1.readString());
      paramParcel2.writeNoException();
      if (bool1) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        paramParcel2.writeInt(paramInt1);
        return true;
      }
    case 2: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      paramInt1 = paramParcel1.readInt();
      str1 = paramParcel1.readString();
      String str2 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0)
      {
        bool1 = true;
        if (paramParcel1.readInt() == 0) {
          break label649;
        }
      }
      for (bool2 = true;; bool2 = false)
      {
        paramParcel1 = a(paramInt1, str1, str2, bool1, bool2);
        paramParcel2.writeNoException();
        if (paramParcel1 == null) {
          break label655;
        }
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
        bool1 = false;
        break;
      }
      paramParcel2.writeInt(0);
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      paramParcel1 = a(paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      paramParcel1 = a(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      a(paramParcel1.readInt(), paramParcel1.readString());
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      a();
      return true;
    case 7: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      a(IQQServiceCallback.Stub.a(paramParcel1.readStrongBinder()));
      return true;
    case 8: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      b(IQQServiceCallback.Stub.a(paramParcel1.readStrongBinder()));
      return true;
    case 9: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      a(paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString());
      return true;
    case 10: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      b(paramParcel1.readInt(), paramParcel1.readString());
      return true;
    case 11: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      bool1 = a(paramParcel1.readLong());
      paramParcel2.writeNoException();
      paramInt1 = i1;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 12: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      paramInt1 = a(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 13: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      bool1 = a();
      paramParcel2.writeNoException();
      paramInt1 = i2;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 14: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      bool1 = b();
      paramParcel2.writeNoException();
      paramInt1 = i3;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 15: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      paramParcel1 = a(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeLongArray(paramParcel1);
      return true;
    case 16: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      a(paramParcel1.readLong());
      return true;
    case 17: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      bool1 = b(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramInt1 = i4;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 18: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      paramInt1 = b(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 19: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      paramInt1 = a();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 20: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      long l1 = a(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeLong(l1);
      return true;
    case 21: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      bool1 = a(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.createByteArray());
      paramParcel2.writeNoException();
      paramInt1 = i5;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 22: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      bool1 = b(paramParcel1.readLong());
      paramParcel2.writeNoException();
      paramInt1 = i6;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 23: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      bool1 = a(paramParcel1.readString(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramInt1 = i7;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 24: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      str1 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (bool1 = true;; bool1 = false)
      {
        bool1 = a(str1, bool1);
        paramParcel2.writeNoException();
        paramInt1 = i8;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      }
    case 25: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      a(IQQServiceLocationCallback.Stub.a(paramParcel1.readStrongBinder()));
      return true;
    case 26: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      b(IQQServiceLocationCallback.Stub.a(paramParcel1.readStrongBinder()));
      return true;
    case 27: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      paramParcel1 = a();
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 28: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      a(paramParcel1.readInt());
      return true;
    case 29: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      a(paramParcel1.readString());
      return true;
    case 30: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      bool1 = b(paramParcel1.readString(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramInt1 = i9;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 31: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      b(paramParcel1.readString());
      return true;
    case 32: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      c(paramParcel1.readString());
      return true;
    case 33: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      b();
      return true;
    case 34: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      c();
      return true;
    case 35: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      paramInt1 = c(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 36: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      a(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
      return true;
    case 37: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      a(paramParcel1.createLongArray(), paramParcel1.readString());
      return true;
    case 38: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      a(paramParcel1.readLong(), paramParcel1.readString(), paramParcel1.readInt());
      return true;
    case 39: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      bool1 = a(paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      paramInt1 = i10;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 40: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      paramParcel1 = b(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeLongArray(paramParcel1);
      return true;
    case 41: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      paramParcel1 = a(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeStringArray(paramParcel1);
      return true;
    case 42: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      paramParcel1 = b(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 43: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      a(bool1);
      return true;
    case 44: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      bool1 = c();
      paramParcel2.writeNoException();
      paramInt1 = i11;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 45: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      paramParcel1 = c(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 46: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      paramParcel1 = d(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 47: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      paramInt1 = b();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 48: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      paramInt1 = c();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 49: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      paramParcel1 = a();
      paramParcel2.writeNoException();
      paramParcel2.writeIntArray(paramParcel1);
      return true;
    case 50: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      bool1 = d();
      paramParcel2.writeNoException();
      paramInt1 = i12;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 51: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      bool1 = e();
      paramParcel2.writeNoException();
      paramInt1 = i13;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 52: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      paramInt1 = d();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 53: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      bool1 = bool2;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      b(bool1);
      return true;
    case 54: 
      label649:
      label655:
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      a(paramParcel1.readString(), paramParcel1.readLong());
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
    bool1 = bool3;
    if (paramParcel1.readInt() != 0) {
      bool1 = true;
    }
    c(bool1);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\service\IQQServiceForAV$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */