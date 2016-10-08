package com.tencent.mobileqq.activity.aio.photo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.device.msg.activities.AIODevLittleVideoData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import nuv;

public abstract class AIORichMediaData
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new nuv();
  public static final String h = "I:N";
  public static final String i = "I:E";
  public long f;
  public long g;
  public long h;
  public String j;
  public int k;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static AIORichMediaData a(String paramString)
  {
    if (AIOImageData.class.getSimpleName().equals(paramString)) {
      return new AIOImageData();
    }
    if (AIOShortVideoData.class.getSimpleName().equals(paramString)) {
      return new AIOShortVideoData();
    }
    if (AIODevLittleVideoData.class.getSimpleName().equals(paramString)) {
      return new AIODevLittleVideoData();
    }
    if (AIOFilePicData.class.getSimpleName().equals(paramString)) {
      return new AIOFilePicData();
    }
    if (AIOFileVideoData.class.getSimpleName().equals(paramString)) {
      return new AIOFileVideoData();
    }
    throw new ClassNotFoundException();
  }
  
  public abstract int a(String paramString);
  
  public abstract File a(int paramInt);
  
  public abstract String a(int paramInt);
  
  public void a(Parcel paramParcel)
  {
    this.f = paramParcel.readLong();
    this.k = paramParcel.readInt();
    this.g = paramParcel.readLong();
    this.h = paramParcel.readLong();
  }
  
  public abstract boolean a(int paramInt);
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(getClass().getSimpleName());
    paramParcel.writeLong(this.f);
    paramParcel.writeInt(this.k);
    paramParcel.writeLong(this.g);
    paramParcel.writeLong(this.h);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\photo\AIORichMediaData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */