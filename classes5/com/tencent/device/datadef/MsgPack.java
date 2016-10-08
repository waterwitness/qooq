package com.tencent.device.datadef;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public class MsgPack
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public boolean bIsSelf;
  public boolean bSendResult;
  public byte[] buffer;
  public int dwMsgSequence;
  public int length;
  public String strText;
  public long uRecvUin;
  public long uSendUin;
  
  public MsgPack()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void initRawMsg(int paramInt1, long paramLong, byte[] paramArrayOfByte, int paramInt2)
  {
    this.dwMsgSequence = paramInt1;
    this.uSendUin = paramLong;
    this.buffer = paramArrayOfByte;
    this.length = paramInt2;
  }
  
  public void initReceivedMsg(int paramInt, long paramLong, String paramString)
  {
    this.dwMsgSequence = paramInt;
    this.uRecvUin = paramLong;
    this.strText = paramString;
  }
  
  public void initSendMsgResult(int paramInt, long paramLong, boolean paramBoolean)
  {
    this.dwMsgSequence = paramInt;
    this.uSendUin = paramLong;
    this.bSendResult = paramBoolean;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\device\datadef\MsgPack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */