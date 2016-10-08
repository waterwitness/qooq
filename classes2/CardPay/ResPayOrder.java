package CardPay;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ResPayOrder
  extends JceStruct
  implements Cloneable
{
  static Order cache_order;
  public String msg;
  public Order order;
  public int ret;
  public int subCmd;
  
  public ResPayOrder()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.msg = "";
  }
  
  public ResPayOrder(int paramInt1, int paramInt2, String paramString, Order paramOrder)
  {
    this.msg = "";
    this.subCmd = paramInt1;
    this.ret = paramInt2;
    this.msg = paramString;
    this.order = paramOrder;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.subCmd = paramJceInputStream.read(this.subCmd, 0, true);
    this.ret = paramJceInputStream.read(this.ret, 1, true);
    this.msg = paramJceInputStream.readString(2, true);
    if (cache_order == null) {
      cache_order = new Order();
    }
    this.order = ((Order)paramJceInputStream.read(cache_order, 3, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.subCmd, 0);
    paramJceOutputStream.write(this.ret, 1);
    paramJceOutputStream.write(this.msg, 2);
    paramJceOutputStream.write(this.order, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\CardPay\ResPayOrder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */