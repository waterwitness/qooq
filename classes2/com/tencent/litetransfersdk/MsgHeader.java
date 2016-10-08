package com.tencent.litetransfersdk;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class MsgHeader
{
  public int uint32_dst_app_id;
  public int uint32_dst_inst_id;
  public int uint32_dst_ter_type;
  public int uint32_dst_uin_type;
  public int uint32_src_app_id;
  public int uint32_src_inst_id;
  public int uint32_src_ter_type;
  public int uint32_src_uin_type;
  public long uint64_dst_uin;
  public long uint64_src_uin;
  
  public MsgHeader()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\litetransfersdk\MsgHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */