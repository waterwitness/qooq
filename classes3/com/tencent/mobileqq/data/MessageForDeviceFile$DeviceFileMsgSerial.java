package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

class MessageForDeviceFile$DeviceFileMsgSerial
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public int copies;
  public int duplexMode;
  public int fileFrom;
  public String filePath;
  public long fileSize;
  public String fileUuid;
  public int groupId;
  public int groupIndex;
  public int groupSize;
  public byte[] md5;
  public int msgStatus;
  public int nFileMsgType;
  public int nFileStatus;
  public int nOpType;
  public long nServerIp;
  public long nServerPort;
  public float progress;
  public String serverPath;
  public String srcFileName;
  public String strCoverKey;
  public String strCoverKey2;
  public String strFileKey2;
  public String strMediaKey;
  public String strRecentMsg;
  public String strServiceName;
  public String thumbPath;
  public int uChannelType;
  public long uOwnerUin;
  public long uSessionID;
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
  public byte[] vOfflineFileUUID;
  public byte[] vServiceInfo;
  public byte[] vTokenKey;
  public byte[] vUrlNotify;
  
  private MessageForDeviceFile$DeviceFileMsgSerial()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\MessageForDeviceFile$DeviceFileMsgSerial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */