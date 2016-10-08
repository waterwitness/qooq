package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.StringUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopFeedParserHelper$ProclamationFeedParser
  extends TroopFeedParserHelper.FeedParser
{
  public TroopFeedParserHelper$ProclamationFeedParser()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public TroopFeedItem a(JSONObject paramJSONObject)
  {
    TroopFeedItem localTroopFeedItem = super.a(paramJSONObject);
    if (localTroopFeedItem == null) {
      return null;
    }
    for (;;)
    {
      int i;
      int j;
      try
      {
        localTroopFeedItem.type = paramJSONObject.getInt("feed_type");
        JSONArray localJSONArray = paramJSONObject.getJSONArray("content");
        localTroopFeedItem.linkUrl = paramJSONObject.getString("open_url");
        i = 0;
        if (i >= localJSONArray.length()) {
          break label196;
        }
        paramJSONObject = localJSONArray.getJSONObject(i);
        j = paramJSONObject.getInt("type");
        if (j == 0)
        {
          localTroopFeedItem.content = paramJSONObject.getString("value");
        }
        else if (j == 3)
        {
          if (!paramJSONObject.has("pic_url")) {
            break label198;
          }
          localTroopFeedItem.picPath = (paramJSONObject.getString("pic_url") + "/109");
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return null;
      }
      if (j == 10)
      {
        localTroopFeedItem.title = paramJSONObject.getString("value");
      }
      else if ((j == 6) && (StringUtil.b(localTroopFeedItem.picPath)) && (paramJSONObject.has("pic_url")))
      {
        localTroopFeedItem.picPath = paramJSONObject.getString("pic_url");
        break label198;
        label196:
        return localTroopFeedItem;
      }
      label198:
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\data\TroopFeedParserHelper$ProclamationFeedParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */