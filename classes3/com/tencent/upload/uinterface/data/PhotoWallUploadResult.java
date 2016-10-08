package com.tencent.upload.uinterface.data;

import com.tencent.upload.uinterface.AbstractUploadResult;

public class PhotoWallUploadResult
  extends AbstractUploadResult
{
  public String burl = "";
  public int ctime;
  public String filekey = "";
  public String murl = "";
  public int publish_code = 0;
  public String stackMsg = "";
  public String surl = "";
  public String url = "";
  
  public final String toString()
  {
    return "url=" + this.url + ",ctime=" + this.ctime + ",filekey=" + this.filekey + ",publish_code=" + this.publish_code + ",burl=" + this.burl + ",murl=" + this.murl + ",surl=" + this.surl;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\uinterface\data\PhotoWallUploadResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */