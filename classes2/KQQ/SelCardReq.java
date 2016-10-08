package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class SelCardReq
  extends JceStruct
{
  public long m_LastOthMsg;
  public long m_LastPic;
  
  public SelCardReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SelCardReq(long paramLong1, long paramLong2)
  {
    this.m_LastPic = paramLong1;
    this.m_LastOthMsg = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.m_LastPic = paramJceInputStream.read(this.m_LastPic, 0, true);
    this.m_LastOthMsg = paramJceInputStream.read(this.m_LastOthMsg, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.m_LastPic, 0);
    paramJceOutputStream.write(this.m_LastOthMsg, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQ\SelCardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */