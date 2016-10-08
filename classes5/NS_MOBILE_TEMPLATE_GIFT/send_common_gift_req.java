package NS_MOBILE_TEMPLATE_GIFT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class send_common_gift_req
  extends JceStruct
{
  static s_send_gift_item cache_giftItem;
  public s_send_gift_item giftItem;
  
  public send_common_gift_req()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public send_common_gift_req(s_send_gift_item params_send_gift_item)
  {
    this.giftItem = params_send_gift_item;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_giftItem == null) {
      cache_giftItem = new s_send_gift_item();
    }
    this.giftItem = ((s_send_gift_item)paramJceInputStream.read(cache_giftItem, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.giftItem, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_TEMPLATE_GIFT\send_common_gift_req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */