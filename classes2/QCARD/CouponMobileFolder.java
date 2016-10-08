package QCARD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class CouponMobileFolder
  extends JceStruct
{
  static ArrayList cache_coupon_list;
  public int aboutexpire_num;
  public ArrayList coupon_list;
  public int coupons_num;
  public int folder_id;
  public String icon_url = "";
  public String name = "";
  public String unavailable_url = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_coupon_list = new ArrayList();
    CouponMobileItem localCouponMobileItem = new CouponMobileItem();
    cache_coupon_list.add(localCouponMobileItem);
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.folder_id = paramJceInputStream.read(this.folder_id, 0, true);
    this.name = paramJceInputStream.readString(1, true);
    this.icon_url = paramJceInputStream.readString(2, false);
    this.coupon_list = ((ArrayList)paramJceInputStream.read(cache_coupon_list, 3, true));
    this.unavailable_url = paramJceInputStream.readString(4, true);
    this.coupons_num = paramJceInputStream.read(this.coupons_num, 5, true);
    this.aboutexpire_num = paramJceInputStream.read(this.aboutexpire_num, 6, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.folder_id, 0);
    paramJceOutputStream.write(this.name, 1);
    if (this.icon_url != null) {
      paramJceOutputStream.write(this.icon_url, 2);
    }
    paramJceOutputStream.write(this.coupon_list, 3);
    paramJceOutputStream.write(this.unavailable_url, 4);
    paramJceOutputStream.write(this.coupons_num, 5);
    paramJceOutputStream.write(this.aboutexpire_num, 6);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QCARD\CouponMobileFolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */