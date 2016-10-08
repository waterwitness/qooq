package com.tencent.litetransfersdk;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class SubCmd0x6ReqBody
{
  public byte[] bytes_file_md5;
  public byte[] bytes_uuid;
  public String str_file_name;
  public String str_src_file_path;
  public String str_src_parent_folder;
  public int uint32_client_type;
  public int uint32_dst_bus_id;
  public long uint64_dst_uin;
  public long uint64_file_size;
  public long uint64_src_uin;
  
  public SubCmd0x6ReqBody()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\litetransfersdk\SubCmd0x6ReqBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */