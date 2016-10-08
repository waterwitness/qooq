package QCARD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class GetCollectItemMobileRsp
  extends JceStruct
{
  static ArrayList cache_folder_list;
  static CouponMobileItem cache_item;
  public ArrayList folder_list;
  public CouponMobileItem item;
  public String next_card_uid = "";
  public int ret_code = -1;
  public long sequence;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_item = new CouponMobileItem();
    cache_folder_list = new ArrayList();
    CouponMobileFolder localCouponMobileFolder = new CouponMobileFolder();
    cache_folder_list.add(localCouponMobileFolder);
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret_code = paramJceInputStream.read(this.ret_code, 0, true);
    this.item = ((CouponMobileItem)paramJceInputStream.read(cache_item, 1, true));
    this.next_card_uid = paramJceInputStream.readString(2, true);
    this.sequence = paramJceInputStream.read(this.sequence, 3, true);
    this.folder_list = ((ArrayList)paramJceInputStream.read(cache_folder_list, 4, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret_code, 0);
    paramJceOutputStream.write(this.item, 1);
    paramJceOutputStream.write(this.next_card_uid, 2);
    paramJceOutputStream.write(this.sequence, 3);
    paramJceOutputStream.write(this.folder_list, 4);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QCARD\GetCollectItemMobileRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */