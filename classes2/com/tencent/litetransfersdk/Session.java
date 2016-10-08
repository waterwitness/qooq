package com.tencent.litetransfersdk;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class Session
{
  public ActionInfo actionInfo;
  public boolean bSend;
  public int dwGroupID;
  public int dwGroupIndex;
  public int dwGroupSize;
  public int emFileFrom;
  public int emFileType;
  public int emTaskStatus;
  public MsgHeader msgHeader;
  public byte[] pFileBuffer;
  public String strFileNameSrc;
  public String strFileNameThumb;
  public String strFilePathSrc;
  public String strFilePathThumb;
  public int uChannelType;
  public long uFileSizeSrc;
  public long uFileSizeThumb;
  public int uMsgTime;
  public long uOwnerUin;
  public long uSessionID;
  public byte[] vFileMD5Src;
  public byte[] vFileMD5Thumb;
  public byte[] vFileSHASrc;
  public byte[] vFileSHAThumb;
  public byte[] vFileTriSHASrc;
  public byte[] vFileTriSHAThumb;
  public byte[] vOfflineFileUUID;
  
  public Session()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\litetransfersdk\Session.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */