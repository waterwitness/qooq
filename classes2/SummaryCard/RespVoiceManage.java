package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class RespVoiceManage
  extends JceStruct
{
  static int cache_eOpType;
  public int eOpType;
  
  public RespVoiceManage()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RespVoiceManage(int paramInt)
  {
    this.eOpType = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.eOpType = paramJceInputStream.read(this.eOpType, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.eOpType, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SummaryCard\RespVoiceManage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */