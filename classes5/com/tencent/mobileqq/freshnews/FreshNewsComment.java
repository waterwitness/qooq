package com.tencent.mobileqq.freshnews;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import appoint.define.appoint_define.Elem;
import appoint.define.appoint_define.Face;
import appoint.define.appoint_define.FeedComment;
import appoint.define.appoint_define.ReplyInfo;
import appoint.define.appoint_define.RichText;
import appoint.define.appoint_define.StrangerInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.message.MessageUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import soi;

public class FreshNewsComment
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new soi();
  public int a;
  public long a;
  public FreshNewsStranger a;
  public String a;
  public boolean a;
  public int b;
  public FreshNewsStranger b;
  public String b;
  public boolean b;
  public String c;
  public String d;
  public String e;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public FreshNewsComment()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public FreshNewsComment(Parcel paramParcel)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.c = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.d = paramParcel.readString();
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsStranger = ((FreshNewsStranger)paramParcel.readParcelable(FreshNewsComment.class.getClassLoader()));
    this.jdField_b_of_type_ComTencentMobileqqFreshnewsFreshNewsStranger = ((FreshNewsStranger)paramParcel.readParcelable(FreshNewsComment.class.getClassLoader()));
    this.e = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Int = paramParcel.readInt();
  }
  
  public static appoint_define.RichText a(String paramString)
  {
    appoint_define.RichText localRichText = new appoint_define.RichText();
    if (!TextUtils.isEmpty(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      Object localObject;
      if (i < paramString.length())
      {
        if (paramString.charAt(i) == '\024')
        {
          appoint_define.Elem localElem;
          if (localStringBuilder.length() > 0)
          {
            localObject = localStringBuilder.toString();
            localElem = new appoint_define.Elem();
            localElem.str_content.set((String)localObject);
            localRichText.rpt_msg_elems.add(localElem);
            localStringBuilder.delete(0, localStringBuilder.length());
          }
          j = i;
          if (i + 1 < paramString.length())
          {
            int k = paramString.charAt(i + 1);
            j = i;
            if (k >= 0)
            {
              j = i;
              if (k < MessageUtils.a.length)
              {
                localObject = new appoint_define.Face();
                ((appoint_define.Face)localObject).uint32_index.set(MessageUtils.a[k]);
                localElem = new appoint_define.Elem();
                localElem.msg_face_info.set((MessageMicro)localObject);
                localRichText.rpt_msg_elems.add(localElem);
              }
            }
          }
        }
        for (int j = i + 1;; j = i)
        {
          i = j + 1;
          break;
          localStringBuilder.append(paramString.charAt(i));
        }
      }
      if (localStringBuilder.length() > 0)
      {
        paramString = localStringBuilder.toString();
        localObject = new appoint_define.Elem();
        ((appoint_define.Elem)localObject).str_content.set(paramString);
        localRichText.rpt_msg_elems.add((MessageMicro)localObject);
        localStringBuilder.delete(0, localStringBuilder.length());
      }
    }
    return localRichText;
  }
  
  public static FreshNewsComment a(appoint_define.FeedComment paramFeedComment)
  {
    int j = 0;
    if ((paramFeedComment == null) || (TextUtils.isEmpty(paramFeedComment.str_comment_id.get()))) {
      return null;
    }
    FreshNewsComment localFreshNewsComment = new FreshNewsComment();
    localFreshNewsComment.jdField_a_of_type_JavaLangString = paramFeedComment.str_comment_id.get();
    localFreshNewsComment.jdField_b_of_type_JavaLangString = paramFeedComment.str_feed_id.get();
    localFreshNewsComment.jdField_a_of_type_Long = paramFeedComment.uint32_time.get();
    int i;
    if (paramFeedComment.msg_content.has())
    {
      localObject = (appoint_define.RichText)paramFeedComment.msg_content.get();
      localFreshNewsComment.c = FreshNewsUtil.a((appoint_define.RichText)localObject);
      localFreshNewsComment.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsStranger = FreshNewsStranger.a((appoint_define.StrangerInfo)paramFeedComment.msg_publisher_info.get());
      if (!paramFeedComment.uint32_flag.has()) {
        break label234;
      }
      i = paramFeedComment.uint32_flag.get();
      label128:
      localFreshNewsComment.jdField_a_of_type_Int = i;
      if (!paramFeedComment.msg_reply_info.has()) {
        break label239;
      }
    }
    label234:
    label239:
    for (Object localObject = (appoint_define.ReplyInfo)paramFeedComment.msg_reply_info.get();; localObject = null)
    {
      if (localObject != null)
      {
        localFreshNewsComment.d = ((appoint_define.ReplyInfo)localObject).str_comment_id.get();
        localFreshNewsComment.jdField_b_of_type_ComTencentMobileqqFreshnewsFreshNewsStranger = FreshNewsStranger.a((appoint_define.StrangerInfo)((appoint_define.ReplyInfo)localObject).msg_stranger_info.get());
      }
      localFreshNewsComment.e = FreshNewsUtil.a(Long.valueOf(localFreshNewsComment.jdField_a_of_type_Long), true);
      i = j;
      if (paramFeedComment.uint32_hot.has()) {
        i = paramFeedComment.uint32_hot.get();
      }
      localFreshNewsComment.jdField_b_of_type_Int = i;
      return localFreshNewsComment;
      localObject = null;
      break;
      i = 0;
      break label128;
    }
  }
  
  public static FreshNewsComment a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    FreshNewsComment localFreshNewsComment = new FreshNewsComment();
    try
    {
      localFreshNewsComment.jdField_a_of_type_JavaLangString = paramJSONObject.getString("commentId");
      localFreshNewsComment.jdField_b_of_type_JavaLangString = paramJSONObject.getString("feedId");
      localFreshNewsComment.c = paramJSONObject.getString("content");
      localFreshNewsComment.jdField_a_of_type_Long = paramJSONObject.getLong("time");
      localFreshNewsComment.d = paramJSONObject.getString("replyId");
      localFreshNewsComment.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsStranger = FreshNewsStranger.a(paramJSONObject.getJSONObject("puber"));
      localFreshNewsComment.jdField_b_of_type_ComTencentMobileqqFreshnewsFreshNewsStranger = FreshNewsStranger.a(paramJSONObject.getJSONObject("replyer"));
      localFreshNewsComment.jdField_a_of_type_Int = paramJSONObject.getInt("flag");
      return localFreshNewsComment;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return localFreshNewsComment;
  }
  
  public static String a(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return "";
    }
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      JSONObject localJSONObject = a((FreshNewsComment)paramList.next());
      if (localJSONObject == null) {
        break label84;
      }
      localJSONArray.put(localJSONObject);
      i += 1;
    }
    label84:
    for (;;)
    {
      if (i >= 20) {
        return localJSONArray.toString();
      }
      break;
    }
  }
  
  public static List a(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      FreshNewsComment localFreshNewsComment = a((appoint_define.FeedComment)paramList.next());
      if (localFreshNewsComment != null) {
        localArrayList.add(localFreshNewsComment);
      }
    }
    return localArrayList;
  }
  
  public static JSONObject a(FreshNewsComment paramFreshNewsComment)
  {
    if (paramFreshNewsComment == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("commentId", paramFreshNewsComment.jdField_a_of_type_JavaLangString);
      localJSONObject.put("feedId", paramFreshNewsComment.jdField_b_of_type_JavaLangString);
      localJSONObject.put("content", paramFreshNewsComment.c);
      localJSONObject.put("time", paramFreshNewsComment.jdField_a_of_type_Long);
      localJSONObject.put("replyId", paramFreshNewsComment.d);
      localJSONObject.put("puber", FreshNewsStranger.a(paramFreshNewsComment.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsStranger));
      localJSONObject.put("replyer", FreshNewsStranger.a(paramFreshNewsComment.jdField_b_of_type_ComTencentMobileqqFreshnewsFreshNewsStranger));
      localJSONObject.put("flag", paramFreshNewsComment.jdField_a_of_type_Int);
      return localJSONObject;
    }
    catch (JSONException paramFreshNewsComment)
    {
      paramFreshNewsComment.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static void a(List paramList, String paramString)
  {
    if ((paramList == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      try
      {
        paramString = new JSONArray(paramString);
        int j = paramString.length();
        int i = 0;
        while (i < j)
        {
          FreshNewsComment localFreshNewsComment = a(paramString.getJSONObject(i));
          if (localFreshNewsComment != null) {
            paramList.add(localFreshNewsComment);
          }
          i += 1;
        }
        return;
      }
      catch (JSONException paramList)
      {
        paramList.printStackTrace();
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.c);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.d);
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsStranger, 0);
    paramParcel.writeParcelable(this.jdField_b_of_type_ComTencentMobileqqFreshnewsFreshNewsStranger, 0);
    paramParcel.writeString(this.e);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\FreshNewsComment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */