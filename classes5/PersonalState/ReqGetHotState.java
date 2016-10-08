package PersonalState;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ReqGetHotState
  extends JceStruct
{
  static BusiReqHead cache_oHead;
  public BusiReqHead oHead;
  
  public ReqGetHotState()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ReqGetHotState(BusiReqHead paramBusiReqHead)
  {
    this.oHead = paramBusiReqHead;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_oHead == null) {
      cache_oHead = new BusiReqHead();
    }
    this.oHead = ((BusiReqHead)paramJceInputStream.read(cache_oHead, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.oHead, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\PersonalState\ReqGetHotState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */