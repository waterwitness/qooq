package com.tencent.litetransfersdk;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ApplyUploadHitRsp
{
  public byte[] bytes_upload_key;
  public byte[] bytes_uuid;
  public int int32_ret_code;
  public String str_ret_msg;
  public String str_upload_domain;
  public String str_upload_ip;
  public int uint32_upload_port;
  public long uint64_total_space;
  public long uint64_used_space;
  
  public ApplyUploadHitRsp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\litetransfersdk\ApplyUploadHitRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */