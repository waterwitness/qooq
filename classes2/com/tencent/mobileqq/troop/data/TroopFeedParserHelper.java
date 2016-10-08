package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopFeedParserHelper
{
  public static final String a = "TroopFeedParserHelper";
  
  public TroopFeedParserHelper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static TroopFeedParserHelper.FeedParser a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 10: 
      return new TroopFeedParserHelper.VideoFeedParser();
    case 12: 
      return new TroopFeedParserHelper.VoteFeedParser();
    case 18: 
      return new TroopFeedParserHelper.AblumFeedParser();
    case 5: 
    case 19: 
      return new TroopFeedParserHelper.ProclamationFeedParser();
    case 4: 
      return new TroopFeedParserHelper.ShareFeedParser();
    case 99: 
      return new TroopFeedParserHelper.CommonFeedParser();
    }
    return new TroopFeedParserHelper.PicFeedParser();
  }
  
  public static String a(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    Date localDate = new Date(1000L * paramLong);
    localCalendar.setTime(localDate);
    return new SimpleDateFormat("MM月dd日").format(localDate);
  }
  
  public static Object[] a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (paramJSONObject != null) {
      try
      {
        Object localObject;
        int i;
        if (paramJSONObject.has("fids"))
        {
          localObject = paramJSONObject.getJSONArray("fids");
          i = 0;
          while (i < ((JSONArray)localObject).length())
          {
            localArrayList1.add(((JSONArray)localObject).getJSONObject(i).getString("fid"));
            i += 1;
          }
        }
        if (paramJSONObject.has("feeds"))
        {
          paramJSONObject = paramJSONObject.getJSONArray("feeds");
          i = 0;
          while (i < paramJSONObject.length())
          {
            localObject = paramJSONObject.getJSONObject(i);
            int j = ((JSONObject)localObject).getInt("feed_type");
            TroopFeedParserHelper.FeedParser localFeedParser = a(j);
            if (localFeedParser != null)
            {
              localObject = localFeedParser.a((JSONObject)localObject);
              if ((localObject != null) && (((TroopFeedItem)localObject).isVaild()))
              {
                ((TroopFeedItem)localObject).orginType = j;
                ((TroopFeedItem)localObject).currentUin = paramString2;
                ((TroopFeedItem)localObject).troopUin = paramString1;
                localArrayList2.add(localObject);
              }
            }
            i += 1;
          }
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
    tmp205_202[0] = localArrayList1;
    Object[] tmp209_205 = tmp205_202;
    tmp209_205[1] = localArrayList2;
    return tmp209_205;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\data\TroopFeedParserHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */