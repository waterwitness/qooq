package com.tencent.mobileqq.activity.qwallet.preload;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;
import org.json.JSONObject;

public class PreloadResource
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public String downloadTime;
  public String invalidTime;
  public String md5;
  public boolean needReplace;
  public String netType;
  public int type;
  public String url;
  public String urlPath;
  
  public PreloadResource()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static PreloadResource parsePreloadResource(JSONObject paramJSONObject)
  {
    PreloadResource localPreloadResource = new PreloadResource();
    try
    {
      localPreloadResource.url = paramJSONObject.optString("url");
      localPreloadResource.urlPath = paramJSONObject.optString("url_path");
      localPreloadResource.type = paramJSONObject.optInt("type");
      localPreloadResource.md5 = paramJSONObject.optString("md5");
      localPreloadResource.downloadTime = paramJSONObject.optString("download_time");
      localPreloadResource.invalidTime = paramJSONObject.optString("invalid_time");
      localPreloadResource.netType = paramJSONObject.optString("net_type");
      return localPreloadResource;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return localPreloadResource;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof PreloadResource)))
    {
      paramObject = (PreloadResource)paramObject;
      if (((this.url != null) && (this.url.equals(((PreloadResource)paramObject).url))) || ((this.urlPath != null) && (this.urlPath.equals(((PreloadResource)paramObject).urlPath)))) {
        return true;
      }
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qwallet\preload\PreloadResource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */