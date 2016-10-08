package com.tencent.litetransfersdk;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class DeleteFileReq
{
  public String bytes_uuid;
  public int uint32_delete_type;
  public long uint64_peer_uin;
  public long uint64_uin;
  
  public DeleteFileReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\litetransfersdk\DeleteFileReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */