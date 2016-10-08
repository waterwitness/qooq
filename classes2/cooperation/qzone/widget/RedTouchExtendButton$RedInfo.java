package cooperation.qzone.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import ysh;

public class RedTouchExtendButton$RedInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new ysh();
  public static final int a = 0;
  public static final int b = 3;
  public static final int c = 4;
  public static final int d = 100;
  public String a;
  public boolean a;
  public String b;
  public String c;
  public int e;
  public int f;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RedTouchExtendButton$RedInfo() {}
  
  public RedTouchExtendButton$RedInfo(Parcel paramParcel)
  {
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.e = paramParcel.readInt();
      this.f = paramParcel.readInt();
      this.jdField_a_of_type_JavaLangString = paramParcel.readString();
      this.b = paramParcel.readString();
      this.c = paramParcel.readString();
      return;
      bool = false;
    }
  }
  
  public RedTouchExtendButton$RedInfo(RedInfo paramRedInfo)
  {
    if (paramRedInfo != null)
    {
      this.jdField_a_of_type_Boolean = paramRedInfo.jdField_a_of_type_Boolean;
      this.e = paramRedInfo.e;
      this.f = paramRedInfo.f;
      this.jdField_a_of_type_JavaLangString = paramRedInfo.jdField_a_of_type_JavaLangString;
      this.b = paramRedInfo.b;
      this.c = paramRedInfo.c;
    }
  }
  
  private boolean a(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == null) && (paramObject2 == null)) {}
    while ((paramObject1 != null) && (paramObject1.equals(paramObject2))) {
      return true;
    }
    return false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
      } while (!(paramObject instanceof RedInfo));
      paramObject = (RedInfo)paramObject;
    } while ((!a(Boolean.valueOf(((RedInfo)paramObject).jdField_a_of_type_Boolean), Boolean.valueOf(this.jdField_a_of_type_Boolean))) || (!a(((RedInfo)paramObject).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString)) || (!a(Integer.valueOf(((RedInfo)paramObject).e), Integer.valueOf(this.e))) || (!a(((RedInfo)paramObject).b, this.b)) || (!a(((RedInfo)paramObject).c, this.c)) || (!a(Integer.valueOf(((RedInfo)paramObject).f), Integer.valueOf(this.f))));
    return true;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.e);
      paramParcel.writeInt(this.f);
      paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
      paramParcel.writeString(this.b);
      paramParcel.writeString(this.c);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\widget\RedTouchExtendButton$RedInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */