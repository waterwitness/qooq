package com.tencent.litetransfersdk;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class FileInfo
{
  public byte[] bytes_10m_md5;
  public byte[] bytes_sha;
  public byte[] bytes_uuid;
  public DownloadInfo msg_download_info;
  public String str_file_name;
  public int uint32_abs_file_type;
  public int uint32_client_type;
  public int uint32_danger_evel;
  public int uint32_expire_time;
  public int uint32_life_time;
  public int uint32_upload_time;
  public long uint64_file_size;
  public long uint64_owner_uin;
  public long uint64_peer_uin;
  public long uint64_uin;
  
  public FileInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\litetransfersdk\FileInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */