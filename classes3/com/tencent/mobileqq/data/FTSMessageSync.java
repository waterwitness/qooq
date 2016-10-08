package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.fts.FTSOptSync;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.utils.fts.FTSMessageCodec;
import com.tencent.mobileqq.utils.fts.FTSMessageCodec.MsgExts;

public class FTSMessageSync
  extends FTSOptSync
{
  public static final String MSG_SYNC_LOG_TABLE = "msg_sync_log";
  public int istroop;
  @notColumn
  public FTSMessageCodec.MsgExts msgExts;
  public byte[] msgExtsData;
  public int msgtype;
  public String senderuin;
  public long uin;
  
  public FTSMessageSync()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String getTableName()
  {
    return "msg_sync_log";
  }
  
  protected void postRead()
  {
    this.msgExts = ((FTSMessageCodec.MsgExts)FTSMessageCodec.a(this.msgExtsData, 1));
  }
  
  protected void prewrite()
  {
    this.msgExtsData = FTSMessageCodec.a(this.msgExts, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\FTSMessageSync.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */