package com.tencent.mobileqq.nearby.interestTag;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import appoint.define.appoint_define.InterestItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;
import tjy;

public class InterestTagInfo
  extends Entity
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new tjy();
  public String tagBgColor;
  public String tagIconUrl;
  public long tagId;
  public String tagJumpUrl;
  public String tagName;
  public String tagTextColor;
  public int tagType = -1;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public InterestTagInfo() {}
  
  public InterestTagInfo(Parcel paramParcel)
  {
    this.tagId = paramParcel.readLong();
    this.tagName = paramParcel.readString();
    this.tagIconUrl = paramParcel.readString();
    this.tagJumpUrl = paramParcel.readString();
    this.tagTextColor = paramParcel.readString();
    this.tagBgColor = paramParcel.readString();
  }
  
  public static InterestTagInfo convertFrom(appoint_define.InterestItem paramInterestItem)
  {
    Object localObject;
    if (paramInterestItem == null) {
      localObject = null;
    }
    InterestTagInfo localInterestTagInfo;
    do
    {
      return (InterestTagInfo)localObject;
      localInterestTagInfo = new InterestTagInfo();
      if (paramInterestItem.str_tag_back_color.has()) {
        localInterestTagInfo.tagBgColor = paramInterestItem.str_tag_back_color.get();
      }
      if (paramInterestItem.str_tag_font_color.has()) {
        localInterestTagInfo.tagTextColor = paramInterestItem.str_tag_font_color.get();
      }
      if (paramInterestItem.str_tag_icon_url.has()) {
        localInterestTagInfo.tagIconUrl = paramInterestItem.str_tag_icon_url.get();
      }
      if (paramInterestItem.str_tag_name.has()) {
        localInterestTagInfo.tagName = paramInterestItem.str_tag_name.get();
      }
      if (paramInterestItem.str_tag_href.has()) {
        localInterestTagInfo.tagJumpUrl = paramInterestItem.str_tag_href.get();
      }
      localObject = localInterestTagInfo;
    } while (!paramInterestItem.uint64_tag_id.has());
    localInterestTagInfo.tagId = paramInterestItem.uint64_tag_id.get();
    return localInterestTagInfo;
  }
  
  public static InterestTagInfo convertFrom(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      InterestTagInfo localInterestTagInfo = new InterestTagInfo();
      try
      {
        if (paramJSONObject.has("tagId")) {
          localInterestTagInfo.tagId = paramJSONObject.getLong("tagId");
        }
        if (paramJSONObject.has("tagName")) {
          localInterestTagInfo.tagName = paramJSONObject.getString("tagName");
        }
        if (paramJSONObject.has("tagIconUrl")) {
          localInterestTagInfo.tagIconUrl = paramJSONObject.getString("tagIconUrl");
        }
        if (paramJSONObject.has("tagJumpUrl")) {
          localInterestTagInfo.tagJumpUrl = paramJSONObject.getString("tagJumpUrl");
        }
        if (paramJSONObject.has("tagTextColor")) {
          localInterestTagInfo.tagTextColor = paramJSONObject.getString("tagTextColor");
        }
        if (paramJSONObject.has("tagBgColor")) {
          localInterestTagInfo.tagBgColor = paramJSONObject.getString("tagBgColor");
        }
        return localInterestTagInfo;
      }
      catch (JSONException paramJSONObject)
      {
        if (QLog.isColorLevel()) {
          QLog.i("InterestTag", 2, paramJSONObject.toString());
        }
      }
    }
    return null;
  }
  
  public JSONObject convertTo()
  {
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject2.put("tagId", this.tagId);
      if (!TextUtils.isEmpty(this.tagName)) {
        localJSONObject2.put("tagName", this.tagName);
      }
      if (!TextUtils.isEmpty(this.tagIconUrl)) {
        localJSONObject2.put("tagIconUrl", this.tagIconUrl);
      }
      if (!TextUtils.isEmpty(this.tagJumpUrl)) {
        localJSONObject2.put("tagJumpUrl", this.tagJumpUrl);
      }
      if (!TextUtils.isEmpty(this.tagTextColor)) {
        localJSONObject2.put("tagTextColor", this.tagTextColor);
      }
      localJSONObject1 = localJSONObject2;
      if (!TextUtils.isEmpty(this.tagBgColor))
      {
        localJSONObject2.put("tagBgColor", this.tagBgColor);
        localJSONObject1 = localJSONObject2;
      }
    }
    catch (JSONException localJSONException)
    {
      do
      {
        JSONObject localJSONObject1 = null;
      } while (!QLog.isColorLevel());
      QLog.i("InterestTag", 2, localJSONException.toString());
    }
    return localJSONObject1;
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while ((paramObject.getClass() != getClass()) || (((InterestTagInfo)paramObject).tagId != this.tagId)) {
      return false;
    }
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(" tagName: ").append(this.tagName);
    localStringBuilder.append(" tagIconUrl: ").append(this.tagIconUrl);
    localStringBuilder.append(" tagId: ").append(this.tagId);
    localStringBuilder.append(" tagBgColor: ").append(this.tagBgColor);
    localStringBuilder.append(" tagTextColor: ").append(this.tagTextColor);
    localStringBuilder.append(" iconJumpUrl: ").append(this.tagJumpUrl);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.tagId);
    paramParcel.writeString(this.tagName);
    paramParcel.writeString(this.tagIconUrl);
    paramParcel.writeString(this.tagJumpUrl);
    paramParcel.writeString(this.tagTextColor);
    paramParcel.writeString(this.tagBgColor);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\interestTag\InterestTagInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */