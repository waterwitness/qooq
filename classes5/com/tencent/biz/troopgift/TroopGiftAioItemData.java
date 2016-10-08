package com.tencent.biz.troopgift;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopGiftAioItemData
{
  public static final String a = "goodsWord";
  public static final String b = "gifUrl";
  public static final String c = "pngUrl";
  public static final String d = "packageID";
  public static final String e = "playRule";
  public static final String f = "quantity";
  public static final String g = "selectedWording";
  public static final String h = "giftValue";
  public int a;
  public boolean a;
  public int b;
  public int c;
  public int d;
  public int e;
  public String i;
  public String j;
  public String k;
  public String l;
  
  public TroopGiftAioItemData(String paramString, int paramInt)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.i = paramString.optString("goodsWord");
      this.j = paramString.optString("gifUrl");
      this.k = paramString.optString("pngUrl");
      this.a = paramString.optInt("packageID");
      this.b = paramString.optInt("quantity");
      this.c = paramString.optInt("playRule");
      this.l = paramString.optString("selectedWording");
      this.d = paramString.optInt("giftValue");
      this.e = paramInt;
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public TroopGiftAioItemData(JSONObject paramJSONObject, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.i = paramJSONObject.optString("goodsWord");
    this.j = paramJSONObject.optString("gifUrl");
    this.k = paramJSONObject.optString("pngUrl");
    this.a = paramJSONObject.optInt("packageID");
    this.b = paramJSONObject.optInt("quantity");
    this.c = paramJSONObject.optInt("playRule");
    this.l = paramJSONObject.optString("selectedWording");
    this.d = paramJSONObject.optInt("giftValue");
    this.e = paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\troopgift\TroopGiftAioItemData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */