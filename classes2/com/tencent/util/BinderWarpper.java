package com.tencent.util;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import xrl;

public class BinderWarpper
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new xrl();
  public IBinder a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public BinderWarpper(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeStrongBinder(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\util\BinderWarpper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */