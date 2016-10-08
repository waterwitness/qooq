package com.tencent.mobileqq.freshnews.hotchat;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import appoint.define.appoint_define.FeedContent;
import appoint.define.appoint_define.FeedInfo;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.dating.NearbyTransitActivity;
import com.tencent.mobileqq.freshnews.FreshNewsInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import srv;

public class HotchatFeedInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new srv();
  public static final String a = "FreshNews HotchatFeedInfo";
  public static final String b = "http://sqimg.qq.com/qq_product_operations/playqq/anonymous/image/reliao0714.png";
  public String c;
  public String d;
  public String e;
  public String f;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public HotchatFeedInfo() {}
  
  public HotchatFeedInfo(Parcel paramParcel)
  {
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
  }
  
  public static String a(HotchatFeedInfo paramHotchatFeedInfo)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramHotchatFeedInfo != null) {}
    try
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("name", paramHotchatFeedInfo.e);
      ((JSONObject)localObject1).put("key", paramHotchatFeedInfo.d);
      ((JSONObject)localObject1).put("anno", paramHotchatFeedInfo.f);
      ((JSONObject)localObject1).put("url", paramHotchatFeedInfo.c);
      localObject1 = ((JSONObject)localObject1).toString();
      return (String)localObject1;
    }
    catch (Exception paramHotchatFeedInfo)
    {
      do
      {
        QLog.d("FreshNews HotchatFeedInfo", 2, "packedHotchatString, exception：" + paramHotchatFeedInfo.getMessage());
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      paramHotchatFeedInfo.printStackTrace();
    }
    return null;
  }
  
  public static void a(Context paramContext, HotchatFeedInfo paramHotchatFeedInfo)
  {
    if ((paramHotchatFeedInfo == null) || (TextUtils.isEmpty(paramHotchatFeedInfo.c)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FreshNews HotchatFeedInfo", 2, "jumpToHotChat, url = null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FreshNews HotchatFeedInfo", 2, "jumpToHotChat, url=" + paramHotchatFeedInfo.c);
    }
    Object localObject = paramHotchatFeedInfo.c;
    int i = ((String)localObject).lastIndexOf("hotnamecode=");
    if (i < 0) {}
    do
    {
      if (QLog.isColorLevel()) {
        QLog.i("FreshNews HotchatFeedInfo", 2, "jumpToHotChat, can not find hotnamecode, using old jump method");
      }
      localObject = new Intent(paramContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("hide_more_button", true);
      ((Intent)localObject).putExtra("ishiderefresh", true);
      ((Intent)localObject).putExtra("ishidebackforward", true);
      paramContext.startActivity(((Intent)localObject).putExtra("url", paramHotchatFeedInfo.c));
      return;
      localObject = ((String)localObject).substring(i + 12);
    } while (TextUtils.isEmpty((CharSequence)localObject));
    paramHotchatFeedInfo = new Intent(paramContext, NearbyTransitActivity.class);
    paramHotchatFeedInfo.putExtra("action", 1);
    paramHotchatFeedInfo.putExtra("hotnamecode", (String)localObject);
    paramHotchatFeedInfo.putExtra("enter_time", System.currentTimeMillis());
    paramContext.startActivity(paramHotchatFeedInfo);
  }
  
  public static void a(FreshNewsInfo paramFreshNewsInfo, appoint_define.FeedInfo paramFeedInfo)
  {
    if ((paramFreshNewsInfo == null) || (paramFeedInfo == null)) {
      return;
    }
    HotchatFeedInfo localHotchatFeedInfo = new HotchatFeedInfo();
    String str;
    if (paramFeedInfo.msg_feed_content.has())
    {
      paramFeedInfo = (appoint_define.FeedContent)paramFeedInfo.msg_feed_content.get();
      if (paramFeedInfo == null) {
        break label140;
      }
      if (!paramFeedInfo.str_href_url.has()) {
        break label122;
      }
      str = paramFeedInfo.str_href_url.get();
      label60:
      localHotchatFeedInfo.c = str;
      if (!paramFeedInfo.str_group_name.has()) {
        break label128;
      }
      str = paramFeedInfo.str_group_name.get();
      label83:
      localHotchatFeedInfo.e = str;
      if (!paramFeedInfo.str_group_bulletin.has()) {
        break label134;
      }
      paramFeedInfo = paramFeedInfo.str_group_bulletin.get();
    }
    label106:
    for (localHotchatFeedInfo.f = paramFeedInfo;; localHotchatFeedInfo.f = "")
    {
      paramFreshNewsInfo.hotchatInfo = localHotchatFeedInfo;
      return;
      paramFeedInfo = null;
      break;
      label122:
      str = "";
      break label60;
      label128:
      str = "";
      break label83;
      label134:
      paramFeedInfo = "";
      break label106;
      label140:
      localHotchatFeedInfo.c = "";
      localHotchatFeedInfo.e = "";
    }
  }
  
  public static void a(HotchatFeedInfo paramHotchatFeedInfo, String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        HotchatFeedInfo localHotchatFeedInfo = paramHotchatFeedInfo;
        if (paramHotchatFeedInfo == null) {
          localHotchatFeedInfo = new HotchatFeedInfo();
        }
        paramHotchatFeedInfo = new JSONObject(paramString);
        localHotchatFeedInfo.f = paramHotchatFeedInfo.getString("anno");
        localHotchatFeedInfo.e = paramHotchatFeedInfo.getString("name");
        localHotchatFeedInfo.d = paramHotchatFeedInfo.getString("key");
        localHotchatFeedInfo.c = paramHotchatFeedInfo.getString("url");
      }
      return;
    }
    catch (Exception paramHotchatFeedInfo)
    {
      do
      {
        QLog.d("FreshNews HotchatFeedInfo", 2, "parseHotchatJson, exception：" + paramHotchatFeedInfo.getMessage());
      } while (!QLog.isColorLevel());
      paramHotchatFeedInfo.printStackTrace();
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return a(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeSerializable(this.f);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\hotchat\HotchatFeedInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */