package com.tencent.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import xsy;

public class ExpandableListConnector$GroupMetadata
  implements Parcelable, Comparable
{
  public static final Parcelable.Creator CREATOR = new xsy();
  static final int jdField_a_of_type_Int = -1;
  long jdField_a_of_type_Long;
  int b;
  int c;
  int d;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static GroupMetadata a(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    GroupMetadata localGroupMetadata = new GroupMetadata();
    localGroupMetadata.b = paramInt1;
    localGroupMetadata.c = paramInt2;
    localGroupMetadata.d = paramInt3;
    localGroupMetadata.a = paramLong;
    return localGroupMetadata;
  }
  
  public int a(GroupMetadata paramGroupMetadata)
  {
    if (paramGroupMetadata == null) {
      throw new IllegalArgumentException();
    }
    return this.d - paramGroupMetadata.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeLong(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\ExpandableListConnector$GroupMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */