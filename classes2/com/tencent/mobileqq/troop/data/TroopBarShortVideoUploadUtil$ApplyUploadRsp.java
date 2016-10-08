package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.json.JSONObject;

public class TroopBarShortVideoUploadUtil$ApplyUploadRsp
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  
  public TroopBarShortVideoUploadUtil$ApplyUploadRsp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public TroopBarShortVideoUploadUtil$ApplyUploadRsp(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optString("serverip", "");
    this.b = paramJSONObject.optString("serverport", "");
    this.c = paramJSONObject.optString("checkkey", "");
    this.d = paramJSONObject.optString("exists", "");
    this.e = paramJSONObject.optString("uin", "");
    this.f = paramJSONObject.optString("vid", "");
    this.g = paramJSONObject.optString("fid", "");
    this.h = paramJSONObject.optString("complete", "");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\data\TroopBarShortVideoUploadUtil$ApplyUploadRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */