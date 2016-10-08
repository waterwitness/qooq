package com.tencent.mobileqq.freshnews.ad;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import appoint.define.appoint_define.HotTopic;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import srp;

public class HotTopic
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new srp();
  public long a;
  public String a;
  public long b;
  public String b;
  public long c;
  public String c;
  public long d;
  public String d;
  public long e;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public HotTopic() {}
  
  public HotTopic(Parcel paramParcel)
  {
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.jdField_c_of_type_Long = paramParcel.readLong();
    this.jdField_d_of_type_Long = paramParcel.readLong();
    this.e = paramParcel.readLong();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
  }
  
  public static HotTopic a(appoint_define.HotTopic paramHotTopic)
  {
    long l2 = 0L;
    if (paramHotTopic == null) {
      return null;
    }
    HotTopic localHotTopic = new HotTopic();
    long l1;
    String str;
    if (paramHotTopic.uint64_id.has())
    {
      l1 = paramHotTopic.uint64_id.get();
      localHotTopic.jdField_a_of_type_Long = l1;
      if (!paramHotTopic.str_title.has()) {
        break label234;
      }
      str = paramHotTopic.str_title.get();
      label58:
      localHotTopic.jdField_a_of_type_JavaLangString = str;
      if (!paramHotTopic.uint64_topic_type.has()) {
        break label240;
      }
      l1 = paramHotTopic.uint64_topic_type.get();
      label81:
      localHotTopic.jdField_b_of_type_Long = l1;
      if (!paramHotTopic.uint64_total.has()) {
        break label245;
      }
      l1 = paramHotTopic.uint64_total.get();
      label104:
      localHotTopic.jdField_c_of_type_Long = l1;
      if (!paramHotTopic.uint64_times.has()) {
        break label250;
      }
      l1 = paramHotTopic.uint64_times.get();
      label127:
      localHotTopic.jdField_d_of_type_Long = l1;
      l1 = l2;
      if (paramHotTopic.uint64_history_times.has()) {
        l1 = paramHotTopic.uint64_history_times.get();
      }
      localHotTopic.e = l1;
      if (!paramHotTopic.str_bg_url.has()) {
        break label255;
      }
      str = paramHotTopic.str_bg_url.get();
      label176:
      localHotTopic.jdField_b_of_type_JavaLangString = str;
      if (!paramHotTopic.str_url.has()) {
        break label261;
      }
      str = paramHotTopic.str_url.get();
      label199:
      localHotTopic.jdField_c_of_type_JavaLangString = str;
      if (!paramHotTopic.str_extra_info.has()) {
        break label267;
      }
    }
    label234:
    label240:
    label245:
    label250:
    label255:
    label261:
    label267:
    for (paramHotTopic = paramHotTopic.str_extra_info.get();; paramHotTopic = "")
    {
      localHotTopic.jdField_d_of_type_JavaLangString = paramHotTopic;
      return localHotTopic;
      l1 = 0L;
      break;
      str = "";
      break label58;
      l1 = 0L;
      break label81;
      l1 = 0L;
      break label104;
      l1 = 0L;
      break label127;
      str = "";
      break label176;
      str = "";
      break label199;
    }
  }
  
  public static String a(List paramList)
  {
    if (paramList == null) {
      return "";
    }
    localJSONArray = new JSONArray();
    int i = 0;
    try
    {
      while (i < paramList.size())
      {
        HotTopic localHotTopic = (HotTopic)paramList.get(i);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("id", localHotTopic.jdField_a_of_type_Long);
        localJSONObject.put("title", localHotTopic.jdField_a_of_type_JavaLangString);
        localJSONObject.put("type", localHotTopic.jdField_b_of_type_Long);
        localJSONObject.put("totalMember", localHotTopic.jdField_c_of_type_Long);
        localJSONObject.put("playRoomNum", localHotTopic.jdField_d_of_type_Long);
        localJSONObject.put("historyPlayRoomNum", localHotTopic.e);
        localJSONObject.put("backImgURL", localHotTopic.jdField_b_of_type_JavaLangString);
        localJSONObject.put("actionURL", localHotTopic.jdField_c_of_type_JavaLangString);
        localJSONObject.put("extraInfo", localHotTopic.jdField_d_of_type_JavaLangString);
        localJSONArray.put(localJSONObject);
        i += 1;
      }
      return localJSONArray.toString();
    }
    catch (JSONException paramList)
    {
      QLog.d("Q.nearby.freshNews", 2, "HotTopic pack2JSONString error." + paramList);
      if (localJSONArray.length() > 0) {
        return "";
      }
    }
  }
  
  public static List a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramString = new JSONArray(paramString);
      int i = 0;
      while (i < paramString.length())
      {
        JSONObject localJSONObject = (JSONObject)paramString.get(i);
        HotTopic localHotTopic = new HotTopic();
        if (localJSONObject.has("id")) {
          localHotTopic.jdField_a_of_type_Long = localJSONObject.getLong("id");
        }
        if (localJSONObject.has("title")) {
          localHotTopic.jdField_a_of_type_JavaLangString = localJSONObject.getString("title");
        }
        if (localJSONObject.has("type")) {
          localHotTopic.jdField_b_of_type_Long = localJSONObject.getLong("type");
        }
        if (localJSONObject.has("totalMember")) {
          localHotTopic.jdField_c_of_type_Long = localJSONObject.getLong("totalMember");
        }
        if (localJSONObject.has("playRoomNum")) {
          localHotTopic.jdField_d_of_type_Long = localJSONObject.getLong("playRoomNum");
        }
        if (localJSONObject.has("historyPlayRoomNum")) {
          localHotTopic.e = localJSONObject.getLong("historyPlayRoomNum");
        }
        if (localJSONObject.has("backImgURL")) {
          localHotTopic.jdField_b_of_type_JavaLangString = localJSONObject.getString("backImgURL");
        }
        if (localJSONObject.has("actionURL")) {
          localHotTopic.jdField_c_of_type_JavaLangString = localJSONObject.getString("actionURL");
        }
        if (localJSONObject.has("extraInfo")) {
          localHotTopic.jdField_d_of_type_JavaLangString = localJSONObject.getString("extraInfo");
        }
        localArrayList.add(localHotTopic);
        i += 1;
      }
      if (localArrayList.size() <= 0) {}
    }
    catch (JSONException paramString)
    {
      QLog.d("Q.nearby.freshNews", 2, "HotTopic unPackFromJSONString error." + paramString);
    }
    for (paramString = localArrayList;; paramString = null) {
      return paramString;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id: ").append(this.jdField_a_of_type_Long);
    localStringBuilder.append("title: ").append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("type: ").append(this.jdField_b_of_type_Long);
    localStringBuilder.append("totalMember: ").append(this.jdField_c_of_type_Long);
    localStringBuilder.append("playRoomNum: ").append(this.jdField_d_of_type_Long);
    localStringBuilder.append("historyPlayRoomNum: ").append(this.e);
    localStringBuilder.append("backImgURL: ").append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("actionURL: ").append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append("extraInfo: ").append(this.jdField_d_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeLong(this.jdField_c_of_type_Long);
    paramParcel.writeLong(this.jdField_d_of_type_Long);
    paramParcel.writeLong(this.e);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\ad\HotTopic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */