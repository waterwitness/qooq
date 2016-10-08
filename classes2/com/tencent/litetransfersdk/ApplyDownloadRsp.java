package com.tencent.litetransfersdk;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ApplyDownloadRsp
{
  public int int32_ret_code;
  public DownloadInfo msg_download_info;
  public FileInfo msg_file_info;
  public String str_ret_msg;
  
  public ApplyDownloadRsp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\litetransfersdk\ApplyDownloadRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */