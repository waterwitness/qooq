package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopFeedParserHelper$VideoFeedParser
  extends TroopFeedParserHelper.FeedParser
{
  public TroopFeedParserHelper$VideoFeedParser()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public TroopFeedItem a(JSONObject paramJSONObject)
  {
    TroopFeedItem localTroopFeedItem = super.a(paramJSONObject);
    if (localTroopFeedItem == null) {
      return null;
    }
    localTroopFeedItem.type = 10;
    try
    {
      paramJSONObject = paramJSONObject.getJSONArray("content");
      if (paramJSONObject.length() > 0)
      {
        paramJSONObject = paramJSONObject.getJSONObject(0);
        localTroopFeedItem.linkUrl = paramJSONObject.getString("videourl");
        localTroopFeedItem.title = paramJSONObject.getString("videointro");
        localTroopFeedItem.picPath = paramJSONObject.getString("videoid");
      }
      return localTroopFeedItem;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\data\TroopFeedParserHelper$VideoFeedParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */