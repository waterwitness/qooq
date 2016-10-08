package com.tencent.mobileqq.activity.aio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import ndh;

public final class ForwardUtils$Section_Text
  extends ForwardUtils.SectionBase
{
  public static final Parcelable.Creator CREATOR = new ndh();
  public String a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ForwardUtils$Section_Text()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public ForwardUtils$Section_Text(Parcel paramParcel)
  {
    super(paramParcel);
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
  }
  
  public ForwardUtils$Section_Text(String paramString)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\ForwardUtils$Section_Text.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */