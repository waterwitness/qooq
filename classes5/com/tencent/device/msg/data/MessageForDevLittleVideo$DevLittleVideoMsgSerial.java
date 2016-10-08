package com.tencent.device.msg.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

class MessageForDevLittleVideo$DevLittleVideoMsgSerial
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public int busiType;
  public String coverKey2;
  public String fileKey2;
  public String fileSource;
  public int fileType;
  public int fromChatType;
  public int issend;
  public long lastModified;
  public String mThumbFilePath;
  public String mVideoFileSourceDir;
  public String md5;
  public String senderuin;
  public String thumbFileKey;
  public int thumbFileSize;
  public int thumbHeight;
  public String thumbMD5;
  public int thumbWidth;
  public int toChatType;
  public int uiOperatorFlag;
  public String uuid;
  public int videoFileFormat;
  public String videoFileKey;
  public String videoFileName;
  public int videoFileProgress;
  public int videoFileSize;
  public int videoFileStatus;
  public int videoFileTime;
  
  private MessageForDevLittleVideo$DevLittleVideoMsgSerial()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.fromChatType = -1;
    this.toChatType = -1;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\device\msg\data\MessageForDevLittleVideo$DevLittleVideoMsgSerial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */