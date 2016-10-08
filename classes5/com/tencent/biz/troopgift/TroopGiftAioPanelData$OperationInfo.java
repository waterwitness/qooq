package com.tencent.biz.troopgift;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.json.JSONObject;

public class TroopGiftAioPanelData$OperationInfo
{
  public String a;
  public String b;
  
  public TroopGiftAioPanelData$OperationInfo(JSONObject paramJSONObject)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramJSONObject.optString("icon");
    this.b = paramJSONObject.optString("jumpUrl");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\troopgift\TroopGiftAioPanelData$OperationInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */