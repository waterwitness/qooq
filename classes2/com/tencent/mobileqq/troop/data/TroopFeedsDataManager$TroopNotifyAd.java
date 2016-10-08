package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.json.JSONObject;

public class TroopFeedsDataManager$TroopNotifyAd
{
  public String a;
  public String b;
  public String c;
  
  public TroopFeedsDataManager$TroopNotifyAd()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static TroopNotifyAd a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      TroopNotifyAd localTroopNotifyAd = new TroopNotifyAd();
      localTroopNotifyAd.a = paramJSONObject.optString("apurl");
      localTroopNotifyAd.c = paramJSONObject.optString("img");
      localTroopNotifyAd.b = paramJSONObject.optString("rl");
      return localTroopNotifyAd;
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\data\TroopFeedsDataManager$TroopNotifyAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */