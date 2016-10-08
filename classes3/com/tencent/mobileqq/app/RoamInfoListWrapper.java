package com.tencent.mobileqq.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import qfk;

public class RoamInfoListWrapper
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new qfk();
  public ArrayList a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RoamInfoListWrapper() {}
  
  public RoamInfoListWrapper(ArrayList paramArrayList)
  {
    this.a = paramArrayList;
  }
  
  public ArrayList a()
  {
    return this.a;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeList(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\RoamInfoListWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */