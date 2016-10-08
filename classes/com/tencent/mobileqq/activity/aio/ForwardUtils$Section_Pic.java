package com.tencent.mobileqq.activity.aio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import ndg;

public final class ForwardUtils$Section_Pic
  extends ForwardUtils.SectionBase
{
  public static final Parcelable.Creator CREATOR = new ndg();
  public String a;
  public String b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ForwardUtils$Section_Pic()
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  public ForwardUtils$Section_Pic(Parcel paramParcel)
  {
    super(paramParcel);
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\ForwardUtils$Section_Pic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */