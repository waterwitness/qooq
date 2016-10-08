package NS_MOBILE_TEMPLATE_GIFT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class send_common_gift_rsp
  extends JceStruct
{
  static ArrayList cache_failList;
  public ArrayList failList;
  public String giftUrl;
  
  public send_common_gift_rsp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.giftUrl = "";
  }
  
  public send_common_gift_rsp(ArrayList paramArrayList, String paramString)
  {
    this.giftUrl = "";
    this.failList = paramArrayList;
    this.giftUrl = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_failList == null)
    {
      cache_failList = new ArrayList();
      send_gift_fail_item localsend_gift_fail_item = new send_gift_fail_item();
      cache_failList.add(localsend_gift_fail_item);
    }
    this.failList = ((ArrayList)paramJceInputStream.read(cache_failList, 0, false));
    this.giftUrl = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.failList != null) {
      paramJceOutputStream.write(this.failList, 0);
    }
    if (this.giftUrl != null) {
      paramJceOutputStream.write(this.giftUrl, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_TEMPLATE_GIFT\send_common_gift_rsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */