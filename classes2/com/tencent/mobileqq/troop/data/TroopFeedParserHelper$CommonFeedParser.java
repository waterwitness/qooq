package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopFeedParserHelper$CommonFeedParser
  extends TroopFeedParserHelper.FeedParser
{
  public TroopFeedParserHelper$CommonFeedParser()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public TroopFeedItem a(JSONObject paramJSONObject)
  {
    TroopFeedItem localTroopFeedItem = super.a(paramJSONObject);
    if (localTroopFeedItem == null) {
      return null;
    }
    localTroopFeedItem.type = 99;
    try
    {
      localTroopFeedItem.linkUrl = paramJSONObject.optString("open_url");
      if (paramJSONObject.has("app_id")) {
        localTroopFeedItem.ex_1 = ("" + paramJSONObject.getLong("app_id"));
      }
      paramJSONObject = paramJSONObject.getJSONObject("content");
      localTroopFeedItem.content = paramJSONObject.getString("body");
      localTroopFeedItem.title = paramJSONObject.getString("title");
      localTroopFeedItem.picPath = paramJSONObject.getString("pic_url");
      return localTroopFeedItem;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\data\TroopFeedParserHelper$CommonFeedParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */