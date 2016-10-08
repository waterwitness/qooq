package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class TroopFeedParserHelper$FeedParser
{
  public TroopFeedParserHelper$FeedParser()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public TroopFeedItem a(JSONObject paramJSONObject)
  {
    TroopFeedItem localTroopFeedItem = new TroopFeedItem();
    try
    {
      localTroopFeedItem.id = paramJSONObject.getString("feed_id");
      localTroopFeedItem.feedTime = paramJSONObject.getString("mod_time");
      localTroopFeedItem.tag = paramJSONObject.getString("tag");
      if (paramJSONObject.has("pub_uin")) {
        localTroopFeedItem.publishUin = paramJSONObject.getString("pub_uin");
      }
      return localTroopFeedItem;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return localTroopFeedItem;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\data\TroopFeedParserHelper$FeedParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */