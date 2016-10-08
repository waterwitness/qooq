package com.tencent.biz.qqstory.base.videoupload;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.json.JSONObject;

public class PreUploadRsp
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  
  public PreUploadRsp(JSONObject paramJSONObject)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
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


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\videoupload\PreUploadRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */