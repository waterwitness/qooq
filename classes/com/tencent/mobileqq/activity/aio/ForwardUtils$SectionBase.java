package com.tencent.mobileqq.activity.aio;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import ndf;

public class ForwardUtils$SectionBase
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new ndf();
  public int a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected ForwardUtils$SectionBase() {}
  
  public ForwardUtils$SectionBase(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\ForwardUtils$SectionBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */