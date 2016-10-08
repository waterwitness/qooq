package NS_MOBILE_MAIN_PAGE;

import NS_MOBILE_COMM.yellow_info;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class mobile_sub_get_cover_item_rsp
  extends JceStruct
{
  static CoverItem cache_item;
  static yellow_info cache_yellowInfo;
  public CoverItem item;
  public yellow_info yellowInfo;
  
  public mobile_sub_get_cover_item_rsp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public mobile_sub_get_cover_item_rsp(CoverItem paramCoverItem, yellow_info paramyellow_info)
  {
    this.item = paramCoverItem;
    this.yellowInfo = paramyellow_info;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_item == null) {
      cache_item = new CoverItem();
    }
    this.item = ((CoverItem)paramJceInputStream.read(cache_item, 0, false));
    if (cache_yellowInfo == null) {
      cache_yellowInfo = new yellow_info();
    }
    this.yellowInfo = ((yellow_info)paramJceInputStream.read(cache_yellowInfo, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.item != null) {
      paramJceOutputStream.write(this.item, 0);
    }
    if (this.yellowInfo != null) {
      paramJceOutputStream.write(this.yellowInfo, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_MAIN_PAGE\mobile_sub_get_cover_item_rsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */