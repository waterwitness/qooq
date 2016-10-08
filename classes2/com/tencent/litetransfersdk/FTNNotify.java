package com.tencent.litetransfersdk;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class FTNNotify
{
  public byte[] bytes_file_md5;
  public byte[] bytes_originfile_md5;
  public ActionInfo msg_ActionInfo;
  public String str_file_index;
  public String str_file_name;
  public int uint32_batchID;
  public int uint32_group_curindex;
  public int uint32_group_id;
  public int uint32_group_size;
  public int uint32_groupflag;
  public int uint32_originfiletype;
  public long uint64_file_len;
  public long uint64_sessionid;
  
  public FTNNotify()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\litetransfersdk\FTNNotify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */