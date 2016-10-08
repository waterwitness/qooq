package com.tencent.litetransfersdk;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ApplyCopyToReq
{
  public byte[] bytes_uuid;
  public String str_file_name;
  public String str_local_filepath;
  public int uint32_dst_svcid;
  public long uint64_dst_id;
  public long uint64_dst_uin;
  public long uint64_file_size;
  public long uint64_src_uin;
  
  public ApplyCopyToReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\litetransfersdk\ApplyCopyToReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */