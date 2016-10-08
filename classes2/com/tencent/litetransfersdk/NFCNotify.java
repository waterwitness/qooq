package com.tencent.litetransfersdk;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class NFCNotify
{
  public byte[] bytes_file_md5;
  public byte[] bytes_originfile_md5;
  public byte[] bytes_tokenkey;
  public byte[] bytes_url_notify;
  public int fixed32_ip;
  public ActionInfo msg_ActionInfo;
  public String str_file_name;
  public int uint32_batchID;
  public int uint32_group_curindex;
  public int uint32_group_id;
  public int uint32_group_size;
  public int uint32_groupflag;
  public int uint32_originfiletype;
  public int uint32_port;
  public long uint64_file_len;
  public long uint64_sessionid;
  
  public NFCNotify()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\litetransfersdk\NFCNotify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */