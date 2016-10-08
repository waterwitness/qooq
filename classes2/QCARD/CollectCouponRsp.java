package QCARD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class CollectCouponRsp
  extends JceStruct
{
  public int ret_code;
  public long sequence;
  
  public CollectCouponRsp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.ret_code = -1;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret_code = paramJceInputStream.read(this.ret_code, 0, true);
    this.sequence = paramJceInputStream.read(this.sequence, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret_code, 0);
    paramJceOutputStream.write(this.sequence, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QCARD\CollectCouponRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */