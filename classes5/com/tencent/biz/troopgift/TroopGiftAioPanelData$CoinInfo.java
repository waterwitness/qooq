package com.tencent.biz.troopgift;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.json.JSONObject;

public class TroopGiftAioPanelData$CoinInfo
{
  public String a;
  public String b;
  public String c;
  
  public TroopGiftAioPanelData$CoinInfo(JSONObject paramJSONObject)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramJSONObject.optString("icon");
    this.b = paramJSONObject.optString("iconGrid");
    this.c = paramJSONObject.optString("jumpUrl");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\troopgift\TroopGiftAioPanelData$CoinInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */