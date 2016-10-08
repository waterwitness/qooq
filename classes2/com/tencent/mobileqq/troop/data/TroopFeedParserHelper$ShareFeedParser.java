package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopFeedParserHelper$ShareFeedParser
  extends TroopFeedParserHelper.FeedParser
{
  public TroopFeedParserHelper$ShareFeedParser()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public TroopFeedItem a(JSONObject paramJSONObject)
  {
    TroopFeedItem localTroopFeedItem = super.a(paramJSONObject);
    if (localTroopFeedItem == null) {
      return null;
    }
    Object localObject;
    try
    {
      localObject = paramJSONObject.getJSONArray("content");
      if (((JSONArray)localObject).length() <= 0) {
        return localTroopFeedItem;
      }
      localObject = ((JSONArray)localObject).getJSONObject(0);
      int i = ((JSONObject)localObject).getInt("type");
      if (i == 5)
      {
        if (((JSONObject)localObject).has("file_path")) {
          localTroopFeedItem.linkUrl = ((JSONObject)localObject).getString("file_path");
        }
        localTroopFeedItem.type = 131;
        if (((JSONObject)localObject).has("sharesize")) {
          localTroopFeedItem.ex_1 = ("" + ((JSONObject)localObject).getLong("sharesize"));
        }
        boolean bool = ((JSONObject)localObject).has("bus_id");
        if (bool) {}
        try
        {
          localTroopFeedItem.content = ("" + ((JSONObject)localObject).getLong("bus_id"));
          if (((JSONObject)localObject).has("sharefile")) {
            localTroopFeedItem.title = ((JSONObject)localObject).getString("sharefile");
          }
          if (((JSONObject)localObject).has("shareexpire")) {
            localTroopFeedItem.shareExpire = ((JSONObject)localObject).getLong("shareexpire");
          }
          if (!((JSONObject)localObject).has("sharefromuin")) {
            return localTroopFeedItem;
          }
          localTroopFeedItem.shareFromUin = ((JSONObject)localObject).getString("sharefromuin");
        }
        catch (JSONException paramJSONObject)
        {
          for (;;)
          {
            localTroopFeedItem.content = ("" + ((JSONObject)localObject).getString("bus_id"));
          }
        }
      }
      if (i != 4) {
        return localTroopFeedItem;
      }
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      return null;
    }
    localTroopFeedItem.type = 132;
    localTroopFeedItem.linkUrl = paramJSONObject.getString("open_url");
    localTroopFeedItem.title = ((JSONObject)localObject).getString("musicname");
    localTroopFeedItem.ex_1 = ((JSONObject)localObject).getString("musicid");
    localTroopFeedItem.picPath = ((JSONObject)localObject).getString("pic_url");
    return localTroopFeedItem;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\data\TroopFeedParserHelper$ShareFeedParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */