package com.tencent.av.utils;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager;
import hbb;

public class InviteBaseData
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new hbb();
  public static final int a = 0;
  public static final int b = 1;
  public String a;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public InviteBaseData()
  {
    this.jdField_d_of_type_Int = 0;
    this.jdField_d_of_type_JavaLangString = "-1";
  }
  
  public InviteBaseData(Parcel paramParcel)
  {
    this.jdField_d_of_type_Int = 0;
    this.jdField_d_of_type_JavaLangString = "-1";
    this.a = paramParcel.readString();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_Int = paramParcel.readInt();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
  }
  
  public InviteBaseData(AVPhoneUserInfo paramAVPhoneUserInfo, QQAppInterface paramQQAppInterface)
  {
    this.jdField_d_of_type_Int = 0;
    this.jdField_d_of_type_JavaLangString = "-1";
    if (paramAVPhoneUserInfo == null) {}
    label181:
    for (;;)
    {
      return;
      this.a = String.valueOf(paramAVPhoneUserInfo.account);
      if (paramAVPhoneUserInfo.accountType == 1) {}
      for (this.jdField_c_of_type_Int = 0;; this.jdField_c_of_type_Int = 1006) {
        do
        {
          if (paramAVPhoneUserInfo.telInfo == null) {
            break label181;
          }
          this.jdField_c_of_type_JavaLangString = paramAVPhoneUserInfo.telInfo.mobile;
          paramQQAppInterface = ((PhoneContactManager)paramQQAppInterface.getManager(10)).b(this.jdField_c_of_type_JavaLangString);
          if (paramQQAppInterface == null) {
            break label189;
          }
          this.b = paramQQAppInterface.name;
          if (TextUtils.isEmpty(paramQQAppInterface.uin)) {
            break;
          }
          if (!paramQQAppInterface.uin.equals("0")) {
            break label183;
          }
          this.jdField_c_of_type_Int = 1006;
          this.jdField_c_of_type_JavaLangString = (paramAVPhoneUserInfo.telInfo.nation + paramAVPhoneUserInfo.telInfo.mobile);
          return;
        } while ((paramAVPhoneUserInfo.accountType != 2) && (paramAVPhoneUserInfo.accountType != 3));
      }
    }
    label183:
    this.jdField_c_of_type_Int = 0;
    return;
    label189:
    this.b = paramAVPhoneUserInfo.telInfo.mobile;
  }
  
  public InviteBaseData(DiscussionMemberInfo paramDiscussionMemberInfo)
  {
    this.jdField_d_of_type_Int = 0;
    this.jdField_d_of_type_JavaLangString = "-1";
    this.a = paramDiscussionMemberInfo.memberUin;
    this.jdField_c_of_type_Int = 0;
    this.b = paramDiscussionMemberInfo.getDiscussionMemberName();
    this.jdField_d_of_type_Int = 0;
    this.jdField_d_of_type_JavaLangString = paramDiscussionMemberInfo.discussionUin;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[uin=").append(this.a);
    localStringBuilder.append(",type=").append(this.jdField_c_of_type_Int);
    localStringBuilder.append(",phone=").append(this.jdField_c_of_type_JavaLangString).append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\utils\InviteBaseData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */