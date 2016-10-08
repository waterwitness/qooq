package com.tencent.mobileqq.utils.fts;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class FTSMessageCodec$TextMsgExts
  extends FTSMessageCodec.MsgExts
  implements Cloneable
{
  public long shmsgseq;
  public long time;
  
  public FTSMessageCodec$TextMsgExts()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public FTSMessageCodec$TextMsgExts(long paramLong1, long paramLong2)
  {
    this.time = paramLong1;
    this.shmsgseq = paramLong2;
  }
  
  protected Object clone()
  {
    return super.clone();
  }
  
  public String toString()
  {
    return "TextMsgExts{time=" + this.time + ", shmsgseq=" + this.shmsgseq + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\fts\FTSMessageCodec$TextMsgExts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */