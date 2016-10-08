package com.tencent.mobileqq.freshnews.topic;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import appoint.define.appoint_define.NearbyTopic;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import org.json.JSONException;
import org.json.JSONObject;
import ssl;

public class TopicInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new ssl();
  public int a;
  public long a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public String d;
  public String e;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public TopicInfo() {}
  
  public TopicInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.d = paramParcel.readString();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.e = paramParcel.readString();
  }
  
  public static appoint_define.NearbyTopic a(TopicInfo paramTopicInfo)
  {
    if (paramTopicInfo == null) {
      return null;
    }
    appoint_define.NearbyTopic localNearbyTopic = new appoint_define.NearbyTopic();
    if (paramTopicInfo.d != null) {
      localNearbyTopic.str_attendee_info.set(paramTopicInfo.d);
    }
    if (paramTopicInfo.jdField_c_of_type_JavaLangString != null) {
      localNearbyTopic.str_background_src.set(paramTopicInfo.jdField_c_of_type_JavaLangString);
    }
    if (paramTopicInfo.e != null) {
      localNearbyTopic.str_button_src.set(paramTopicInfo.e);
    }
    localNearbyTopic.uint32_button_style.set(paramTopicInfo.jdField_c_of_type_Int);
    if (paramTopicInfo.jdField_b_of_type_JavaLangString != null) {
      localNearbyTopic.str_foreword.set(paramTopicInfo.jdField_b_of_type_JavaLangString);
    }
    localNearbyTopic.uint32_create_time.set(paramTopicInfo.jdField_a_of_type_Int);
    localNearbyTopic.uint64_topic_id.set(paramTopicInfo.jdField_a_of_type_Long);
    localNearbyTopic.uint32_update_time.set(paramTopicInfo.jdField_b_of_type_Int);
    if (paramTopicInfo.jdField_a_of_type_JavaLangString != null) {
      localNearbyTopic.str_topic.set(paramTopicInfo.jdField_a_of_type_JavaLangString);
    }
    localNearbyTopic.setHasFlag(true);
    return localNearbyTopic;
  }
  
  public static TopicInfo a(appoint_define.NearbyTopic paramNearbyTopic)
  {
    int j = -1;
    if (paramNearbyTopic == null) {
      return null;
    }
    TopicInfo localTopicInfo = new TopicInfo();
    String str;
    label58:
    label81:
    int i;
    label104:
    label127:
    label150:
    long l;
    if (paramNearbyTopic.str_attendee_info.has())
    {
      str = paramNearbyTopic.str_attendee_info.get();
      localTopicInfo.d = str;
      if (!paramNearbyTopic.str_background_src.has()) {
        break label237;
      }
      str = paramNearbyTopic.str_background_src.get();
      localTopicInfo.jdField_c_of_type_JavaLangString = str;
      if (!paramNearbyTopic.str_button_src.has()) {
        break label243;
      }
      str = paramNearbyTopic.str_button_src.get();
      localTopicInfo.e = str;
      if (!paramNearbyTopic.uint32_button_style.has()) {
        break label249;
      }
      i = paramNearbyTopic.uint32_button_style.get();
      localTopicInfo.jdField_c_of_type_Int = i;
      if (!paramNearbyTopic.str_foreword.has()) {
        break label254;
      }
      str = paramNearbyTopic.str_foreword.get();
      localTopicInfo.jdField_b_of_type_JavaLangString = str;
      if (!paramNearbyTopic.uint32_create_time.has()) {
        break label260;
      }
      i = paramNearbyTopic.uint32_create_time.get();
      localTopicInfo.jdField_a_of_type_Int = i;
      if (!paramNearbyTopic.uint64_topic_id.has()) {
        break label265;
      }
      l = paramNearbyTopic.uint64_topic_id.get();
      label174:
      localTopicInfo.jdField_a_of_type_Long = l;
      i = j;
      if (paramNearbyTopic.uint32_update_time.has()) {
        i = paramNearbyTopic.uint32_update_time.get();
      }
      localTopicInfo.jdField_b_of_type_Int = i;
      if (!paramNearbyTopic.str_topic.has()) {
        break label273;
      }
    }
    label237:
    label243:
    label249:
    label254:
    label260:
    label265:
    label273:
    for (paramNearbyTopic = paramNearbyTopic.str_topic.get();; paramNearbyTopic = "")
    {
      localTopicInfo.jdField_a_of_type_JavaLangString = paramNearbyTopic;
      return localTopicInfo;
      str = "";
      break;
      str = "";
      break label58;
      str = "";
      break label81;
      i = -1;
      break label104;
      str = "";
      break label127;
      i = -1;
      break label150;
      l = -1L;
      break label174;
    }
  }
  
  public static TopicInfo a(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = null;
    }
    for (;;)
    {
      return (TopicInfo)localObject;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        paramString = new TopicInfo();
        try
        {
          if (localJSONObject.has("id")) {
            paramString.jdField_a_of_type_Long = localJSONObject.getLong("id");
          }
          if (localJSONObject.has("topic")) {
            paramString.jdField_a_of_type_JavaLangString = localJSONObject.getString("topic");
          }
          if (localJSONObject.has("foreword")) {
            paramString.jdField_b_of_type_JavaLangString = localJSONObject.getString("foreword");
          }
          if (localJSONObject.has("createTime")) {
            paramString.jdField_a_of_type_Int = localJSONObject.getInt("createTime");
          }
          if (localJSONObject.has("updateTime")) {
            paramString.jdField_b_of_type_Int = localJSONObject.getInt("updateTime");
          }
          if (localJSONObject.has("bgSrc")) {
            paramString.jdField_c_of_type_JavaLangString = localJSONObject.getString("bgSrc");
          }
          if (localJSONObject.has("attendedInfo")) {
            paramString.d = localJSONObject.getString("attendedInfo");
          }
          if (localJSONObject.has("buttonStyle")) {
            paramString.jdField_c_of_type_Int = localJSONObject.getInt("buttonStyle");
          }
          localObject = paramString;
          if (localJSONObject.has("buttonSrc"))
          {
            paramString.e = localJSONObject.getString("buttonSrc");
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
    localJSONException1.printStackTrace();
    return paramString;
  }
  
  public static String a(TopicInfo paramTopicInfo)
  {
    if (paramTopicInfo == null) {
      return "";
    }
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject();
        localJSONException1.printStackTrace();
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          localJSONObject.put("id", paramTopicInfo.jdField_a_of_type_Long);
          localJSONObject.put("topic", paramTopicInfo.jdField_a_of_type_JavaLangString);
          localJSONObject.put("foreWord", paramTopicInfo.jdField_b_of_type_JavaLangString);
          localJSONObject.put("createTime", paramTopicInfo.jdField_a_of_type_Int);
          localJSONObject.put("updateTime", paramTopicInfo.jdField_b_of_type_Int);
          localJSONObject.put("bgSrc", paramTopicInfo.jdField_c_of_type_JavaLangString);
          localJSONObject.put("attendedInfo", paramTopicInfo.d);
          localJSONObject.put("buttonStyle", paramTopicInfo.jdField_c_of_type_Int);
          localJSONObject.put("buttonSrc", paramTopicInfo.e);
          paramTopicInfo = localJSONObject;
          if (paramTopicInfo != null) {
            break;
          }
          return "";
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            JSONObject localJSONObject;
            paramTopicInfo = localJSONObject;
          }
        }
        localJSONException1 = localJSONException1;
        paramTopicInfo = null;
      }
    }
    return paramTopicInfo.toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id: ").append(this.jdField_a_of_type_Long);
    localStringBuilder.append("attendInfo: ").append(this.d);
    localStringBuilder.append("bgSrc: ").append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append("buttonSrc: ").append(this.e);
    localStringBuilder.append("buttonStyle: ").append(this.jdField_c_of_type_Int);
    localStringBuilder.append("foreWord: ").append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("createTime: ").append(this.jdField_a_of_type_Int);
    localStringBuilder.append("updateTime: ").append(this.jdField_b_of_type_Int);
    localStringBuilder.append("topic: ").append(this.jdField_a_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeString(this.e);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\topic\TopicInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */