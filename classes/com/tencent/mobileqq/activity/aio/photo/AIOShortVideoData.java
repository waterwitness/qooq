package com.tencent.mobileqq.activity.aio.photo;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;

public class AIOShortVideoData
  extends AIORichMediaData
  implements Parcelable
{
  public static final int a = 0;
  public static final int b = 1;
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  public int c;
  public int d;
  
  public AIOShortVideoData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = "I:N";
    this.b = "I:N";
  }
  
  public int a(String paramString)
  {
    if (paramString == null) {}
    while ((paramString.equals(this.a)) || (!paramString.equals(this.b))) {
      return 0;
    }
    return 1;
  }
  
  public File a(int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    default: 
      localObject = null;
    }
    while ((localObject != null) && (!((String)localObject).equals("I:N")))
    {
      localObject = new File((String)localObject);
      if (!((File)localObject).exists()) {
        break;
      }
      return (File)localObject;
      localObject = this.a;
      continue;
      localObject = this.b;
    }
    return null;
  }
  
  public String a(int paramInt)
  {
    Object localObject2 = null;
    String str;
    switch (paramInt)
    {
    default: 
      str = null;
    }
    for (;;)
    {
      Object localObject1 = localObject2;
      if (str != null)
      {
        localObject1 = localObject2;
        if (!str.equals("I:N"))
        {
          if (str.startsWith("/")) {
            break;
          }
          localObject1 = "file:/" + str;
        }
      }
      return (String)localObject1;
      str = this.a;
      continue;
      str = this.b;
    }
    if (str.startsWith("//")) {
      return "file:" + str;
    }
    return "file:" + str;
  }
  
  public void a(Parcel paramParcel)
  {
    super.a(paramParcel);
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
  }
  
  public boolean a(int paramInt)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      bool = false;
    }
    do
    {
      do
      {
        return bool;
      } while (!this.a.equals("I:N"));
      return false;
    } while (!this.b.equals("I:N"));
    return false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\photo\AIOShortVideoData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */