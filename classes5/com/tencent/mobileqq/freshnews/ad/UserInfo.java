package com.tencent.mobileqq.freshnews.ad;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import appoint.define.appoint_define.UserInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;
import srq;

public class UserInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new srq();
  public int a;
  public long a;
  public String a;
  public int b;
  public String b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public UserInfo() {}
  
  public UserInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
  }
  
  public static UserInfo a(appoint_define.UserInfo paramUserInfo)
  {
    if (paramUserInfo == null) {
      return null;
    }
    UserInfo localUserInfo = new UserInfo();
    localUserInfo.jdField_a_of_type_Long = paramUserInfo.uint64_uin.get();
    localUserInfo.jdField_a_of_type_JavaLangString = paramUserInfo.bytes_nickname.get().toStringUtf8();
    localUserInfo.jdField_a_of_type_Int = paramUserInfo.uint32_age.get();
    localUserInfo.jdField_b_of_type_Int = paramUserInfo.uint32_gender.get();
    localUserInfo.jdField_b_of_type_JavaLangString = paramUserInfo.bytes_avatar.get().toStringUtf8();
    return localUserInfo;
  }
  
  public static UserInfo a(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = null;
    }
    for (;;)
    {
      return (UserInfo)localObject;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        paramString = new UserInfo();
        try
        {
          if (localJSONObject.has("uin")) {
            paramString.jdField_a_of_type_Long = localJSONObject.getLong("uin");
          }
          if (localJSONObject.has("nickName")) {
            paramString.jdField_a_of_type_JavaLangString = localJSONObject.getString("nickName");
          }
          if (localJSONObject.has("age")) {
            paramString.jdField_a_of_type_Int = localJSONObject.getInt("age");
          }
          if (localJSONObject.has("gender")) {
            paramString.jdField_b_of_type_Int = localJSONObject.getInt("gender");
          }
          localObject = paramString;
          if (localJSONObject.has("avatarURL"))
          {
            paramString.jdField_b_of_type_JavaLangString = localJSONObject.getString("avatarURL");
            return paramString;
          }
        }
        catch (JSONException localJSONException1) {}
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          paramString = null;
        }
      }
    }
    QLog.d("Q.nearby.freshNews", 2, "UserInfo unPackFromJSONString error." + localJSONException1);
    return paramString;
  }
  
  public static String a(UserInfo paramUserInfo)
  {
    if (paramUserInfo == null) {
      return "";
    }
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject();
        QLog.d("Q.nearby.freshNews", 2, "UserInfo pack2JSONString error." + localJSONException1);
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          localJSONObject.put("uin", paramUserInfo.jdField_a_of_type_Long);
          localJSONObject.put("nickName", paramUserInfo.jdField_a_of_type_JavaLangString);
          localJSONObject.put("age", paramUserInfo.jdField_a_of_type_Int);
          localJSONObject.put("gender", paramUserInfo.jdField_b_of_type_Int);
          localJSONObject.put("avatarURL", paramUserInfo.jdField_b_of_type_JavaLangString);
          paramUserInfo = localJSONObject;
          if (paramUserInfo != null) {
            break;
          }
          return "";
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            JSONObject localJSONObject;
            paramUserInfo = localJSONObject;
          }
        }
        localJSONException1 = localJSONException1;
        paramUserInfo = null;
      }
    }
    return paramUserInfo.toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin: ").append(this.jdField_a_of_type_Long);
    localStringBuilder.append("nickName: ").append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("age: ").append(this.jdField_a_of_type_Int);
    localStringBuilder.append("gender: ").append(this.jdField_b_of_type_Int);
    localStringBuilder.append("avatarURL: ").append(this.jdField_b_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\ad\UserInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */