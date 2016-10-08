package com.tencent.av.report;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public class VideoSerializeData
  implements Serializable
{
  int errCode;
  long fromUin;
  long msgSeq;
  long msgType;
  long time;
  long toUin;
  String type;
  
  public VideoSerializeData(String paramString, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.type = paramString;
    this.msgType = paramLong1;
    this.msgSeq = paramLong2;
    this.time = paramLong3;
    this.toUin = paramLong4;
    this.fromUin = paramLong5;
    this.errCode = paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\report\VideoSerializeData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */