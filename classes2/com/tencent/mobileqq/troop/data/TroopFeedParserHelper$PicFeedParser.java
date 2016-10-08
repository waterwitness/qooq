package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.StringUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopFeedParserHelper$PicFeedParser
  extends TroopFeedParserHelper.FeedParser
{
  public TroopFeedParserHelper$PicFeedParser()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public TroopFeedItem a(JSONObject paramJSONObject)
  {
    int i = 0;
    TroopFeedItem localTroopFeedItem = super.a(paramJSONObject);
    if (localTroopFeedItem == null) {
      return null;
    }
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray("content");
        if (i >= paramJSONObject.length()) {
          break label267;
        }
        localJSONObject = paramJSONObject.getJSONObject(i);
        int j = localJSONObject.getInt("type");
        if (j == 5)
        {
          if (localJSONObject.has("file_path")) {
            localTroopFeedItem.linkUrl = localJSONObject.getString("file_path");
          }
          localTroopFeedItem.type = 0;
          if (localJSONObject.has("sharesize")) {
            localTroopFeedItem.ex_1 = ("" + localJSONObject.getLong("sharesize"));
          }
          boolean bool = localJSONObject.has("bus_id");
          if (bool) {}
          try
          {
            localTroopFeedItem.content = ("" + localJSONObject.getLong("bus_id"));
            if (!localJSONObject.has("sharefile")) {
              break label289;
            }
            localTroopFeedItem.title = localJSONObject.getString("sharefile");
          }
          catch (JSONException localJSONException)
          {
            localTroopFeedItem.content = ("" + localJSONObject.getString("bus_id"));
            continue;
          }
        }
        if (j != 3) {
          break label289;
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return null;
      }
      if (localJSONObject.has("pic_id"))
      {
        localTroopFeedItem.picPath = ("http://gdynamic.qpic.cn/gdynamic/" + localJSONObject.getString("pic_id") + "/109");
        break label289;
        label267:
        if ((StringUtil.b(localTroopFeedItem.linkUrl)) || (StringUtil.b(localTroopFeedItem.content))) {
          break;
        }
        return localTroopFeedItem;
      }
      label289:
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\data\TroopFeedParserHelper$PicFeedParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */