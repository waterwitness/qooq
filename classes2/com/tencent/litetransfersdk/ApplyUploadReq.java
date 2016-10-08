package com.tencent.litetransfersdk;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ApplyUploadReq
{
  public byte[] bytes_10m_md5;
  public byte[] bytes_sha;
  public String str_file_name;
  public String str_local_filepath;
  public int uint32_danger_level;
  public int uint32_file_type;
  public long uint64_file_size;
  public long uint64_recver_uin;
  public long uint64_sender_uin;
  public long uint64_total_space;
  
  public ApplyUploadReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\litetransfersdk\ApplyUploadReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */