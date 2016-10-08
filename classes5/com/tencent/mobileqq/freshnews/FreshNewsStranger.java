package com.tencent.mobileqq.freshnews;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import appoint.define.appoint_define.StrangerInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import org.json.JSONException;
import org.json.JSONObject;
import sra;

public class FreshNewsStranger
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new sra();
  public int a;
  public long a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public FreshNewsStranger()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  public FreshNewsStranger(Parcel paramParcel)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
  }
  
  public static FreshNewsStranger a(appoint_define.StrangerInfo paramStrangerInfo)
  {
    Object localObject;
    if ((paramStrangerInfo == null) || (paramStrangerInfo.uint64_tinyid.get() == 0L)) {
      localObject = null;
    }
    FreshNewsStranger localFreshNewsStranger;
    do
    {
      return (FreshNewsStranger)localObject;
      localFreshNewsStranger = new FreshNewsStranger();
      if (paramStrangerInfo.uint64_tinyid.has()) {
        localFreshNewsStranger.jdField_a_of_type_Long = paramStrangerInfo.uint64_tinyid.get();
      }
      if (paramStrangerInfo.uint32_age.has()) {
        localFreshNewsStranger.jdField_a_of_type_Int = paramStrangerInfo.uint32_age.get();
      }
      if (paramStrangerInfo.uint32_gender.has()) {
        localFreshNewsStranger.jdField_b_of_type_Int = paramStrangerInfo.uint32_gender.get();
      }
      if (paramStrangerInfo.bytes_nickname.has()) {
        localFreshNewsStranger.jdField_a_of_type_JavaLangString = paramStrangerInfo.bytes_nickname.get().toStringUtf8();
      }
      if (paramStrangerInfo.str_constellation.has()) {
        localFreshNewsStranger.jdField_b_of_type_JavaLangString = paramStrangerInfo.str_constellation.get();
      }
      if (paramStrangerInfo.uint32_profession.has()) {
        localFreshNewsStranger.jdField_c_of_type_Int = paramStrangerInfo.uint32_profession.get();
      }
      if (paramStrangerInfo.uint32_marriage.has()) {
        localFreshNewsStranger.d = paramStrangerInfo.uint32_marriage.get();
      }
      localObject = localFreshNewsStranger;
    } while (!paramStrangerInfo.str_vipinfo.has());
    localFreshNewsStranger.jdField_c_of_type_JavaLangString = paramStrangerInfo.str_vipinfo.get();
    return localFreshNewsStranger;
  }
  
  public static FreshNewsStranger a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    localFreshNewsStranger = new FreshNewsStranger();
    for (;;)
    {
      try
      {
        localFreshNewsStranger.jdField_a_of_type_Long = paramJSONObject.getLong("tinyid");
        localFreshNewsStranger.jdField_a_of_type_JavaLangString = paramJSONObject.getString("nickname");
        localFreshNewsStranger.jdField_a_of_type_Int = paramJSONObject.getInt("age");
        localFreshNewsStranger.jdField_b_of_type_Int = paramJSONObject.getInt("gender");
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        paramJSONObject = null;
        continue;
      }
      try
      {
        localFreshNewsStranger.jdField_b_of_type_JavaLangString = paramJSONObject.getString("constellation");
        localFreshNewsStranger.jdField_c_of_type_Int = paramJSONObject.getInt("profession");
        localFreshNewsStranger.d = paramJSONObject.getInt("maritalstatus");
        localFreshNewsStranger.jdField_c_of_type_JavaLangString = paramJSONObject.getString("vip");
        paramJSONObject = localFreshNewsStranger;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        paramJSONObject = localFreshNewsStranger;
      }
    }
    return paramJSONObject;
  }
  
  public static JSONObject a(FreshNewsStranger paramFreshNewsStranger)
  {
    if (paramFreshNewsStranger == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("tinyid", paramFreshNewsStranger.jdField_a_of_type_Long);
      localJSONObject.put("nickname", paramFreshNewsStranger.jdField_a_of_type_JavaLangString);
      localJSONObject.put("age", paramFreshNewsStranger.jdField_a_of_type_Int);
      localJSONObject.put("gender", paramFreshNewsStranger.jdField_b_of_type_Int);
      localJSONObject.put("constellation", paramFreshNewsStranger.jdField_b_of_type_JavaLangString);
      localJSONObject.put("profession", paramFreshNewsStranger.jdField_c_of_type_Int);
      localJSONObject.put("maritalstatus", paramFreshNewsStranger.d);
      localJSONObject.put("vip", paramFreshNewsStranger.jdField_c_of_type_JavaLangString);
      return localJSONObject;
    }
    catch (JSONException paramFreshNewsStranger)
    {
      paramFreshNewsStranger.printStackTrace();
    }
    return localJSONObject;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeInt(this.d);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\FreshNewsStranger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */