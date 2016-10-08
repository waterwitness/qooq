package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopFeedParserHelper$VoteFeedParser
  extends TroopFeedParserHelper.FeedParser
{
  public TroopFeedParserHelper$VoteFeedParser()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public TroopFeedItem a(JSONObject paramJSONObject)
  {
    int j = 0;
    TroopFeedItem localTroopFeedItem = super.a(paramJSONObject);
    if (localTroopFeedItem == null) {
      return null;
    }
    localTroopFeedItem.type = 12;
    for (;;)
    {
      int i;
      try
      {
        localTroopFeedItem.linkUrl = paramJSONObject.getString("open_url");
        paramJSONObject = paramJSONObject.getJSONObject("vote");
        if (paramJSONObject != null)
        {
          JSONArray localJSONArray = paramJSONObject.getJSONArray("opts");
          i = 0;
          if ((i >= localJSONArray.length()) || (j > 1))
          {
            paramJSONObject = paramJSONObject.getJSONArray("title");
            if (paramJSONObject.length() > 0) {
              localTroopFeedItem.title = paramJSONObject.getJSONObject(0).getString("value");
            }
          }
          else
          {
            Object localObject = localJSONArray.getJSONArray(i);
            k = j;
            if (((JSONArray)localObject).length() <= 0) {
              break label174;
            }
            localObject = ((JSONArray)localObject).getJSONObject(0);
            if (j == 0) {
              localTroopFeedItem.content = ((JSONObject)localObject).getString("value");
            } else {
              localTroopFeedItem.ex_1 = ((JSONObject)localObject).getString("value");
            }
          }
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return null;
      }
      return localTroopFeedItem;
      int k = j + 1;
      label174:
      i += 1;
      j = k;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\data\TroopFeedParserHelper$VoteFeedParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */