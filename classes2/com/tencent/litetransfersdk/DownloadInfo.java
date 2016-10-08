package com.tencent.litetransfersdk;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class DownloadInfo
{
  public byte[] bytes_download_key;
  public String[] rpt_str_downloadip_list;
  public int rpt_str_downloadip_list_count;
  public String str_cookie;
  public String str_download_domain;
  public String str_download_ip;
  public String str_download_url;
  public int uint32_port;
  
  public DownloadInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\litetransfersdk\DownloadInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */