package com.tencent.litetransfersdk;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ReportItem
{
  public boolean bFileExist;
  public boolean bNetWorkChange;
  public boolean bSend;
  public boolean bUserRetry;
  public int dwClientIP;
  public int dwServerIP;
  public int emResult;
  public int nFailCode;
  public int nUserCode;
  public String sSuffix;
  public String strPcSessionId;
  public byte uChannelType;
  public int uDevType;
  public int uDstInstId;
  public long uDuration;
  public long uFileSize;
  public int uFileType;
  public long uNotifyTime;
  public int uRetryCount;
  public long uSessionID;
  public int uSrcInstId;
  public long uStartPos;
  public long uTaskEnd;
  public long uTaskStart;
  public short wServerPort;
  
  public ReportItem()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\litetransfersdk\ReportItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */