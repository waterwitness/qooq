package com.tencent.mobileqq.filemanager.data;

import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public class FMTransC2CMsgInfo
  implements Serializable
{
  public int busiType;
  public int cmd;
  public FileManagerEntity entity;
  public FileTransferObserver fileTransferObserver;
  public long msgSeq;
  public long msgUid;
  public long observerSeq;
  public long queueSeq;
  public long sessionId;
  public int subCmd;
  public String toUin;
  public long uniseq;
  public String uuid;
  
  public FMTransC2CMsgInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.toUin = "";
    this.msgSeq = -1L;
    this.queueSeq = -1L;
    this.msgUid = -1L;
    this.uniseq = 0L;
    this.uuid = "";
    this.sessionId = 0L;
    this.sessionId = -1L;
    this.observerSeq = -1L;
    this.fileTransferObserver = null;
  }
  
  public String toString()
  {
    return "msgSeq[" + this.msgSeq + "] msgUid[" + this.msgUid + "] subCmd[" + this.subCmd + "] sessionId[" + this.sessionId + "] uuid[" + this.uuid + "] busiType[" + this.busiType + "] uniseq" + this.uniseq;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\data\FMTransC2CMsgInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */