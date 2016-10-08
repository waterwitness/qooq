package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class AdvInfo
  extends JceStruct
{
  static ArrayList cache_appid;
  static ArrayList cache_appid_blk;
  static ArrayList cache_spid;
  static ArrayList cache_spid_blk;
  public ArrayList appid;
  public ArrayList appid_blk;
  public long begin;
  public long bid;
  public long end;
  public long id;
  public String images = "";
  public long limit_click;
  public long limit_days;
  public long limit_expo;
  public String message = "";
  public ArrayList spid;
  public ArrayList spid_blk;
  public int type;
  public String urls = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_spid = new ArrayList();
    cache_spid.add("");
    cache_spid_blk = new ArrayList();
    cache_spid_blk.add("");
    cache_appid = new ArrayList();
    cache_appid.add("");
    cache_appid_blk = new ArrayList();
    cache_appid_blk.add("");
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.id = paramJceInputStream.read(this.id, 0, true);
    this.bid = paramJceInputStream.read(this.bid, 1, true);
    this.type = paramJceInputStream.read(this.type, 2, true);
    this.begin = paramJceInputStream.read(this.begin, 3, true);
    this.end = paramJceInputStream.read(this.end, 4, true);
    this.message = paramJceInputStream.readString(5, false);
    this.images = paramJceInputStream.readString(6, false);
    this.urls = paramJceInputStream.readString(7, false);
    this.limit_expo = paramJceInputStream.read(this.limit_expo, 8, false);
    this.limit_click = paramJceInputStream.read(this.limit_click, 9, false);
    this.limit_days = paramJceInputStream.read(this.limit_days, 10, false);
    this.spid = ((ArrayList)paramJceInputStream.read(cache_spid, 11, false));
    this.spid_blk = ((ArrayList)paramJceInputStream.read(cache_spid_blk, 12, false));
    this.appid = ((ArrayList)paramJceInputStream.read(cache_appid, 13, false));
    this.appid_blk = ((ArrayList)paramJceInputStream.read(cache_appid_blk, 14, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.id, 0);
    paramJceOutputStream.write(this.bid, 1);
    paramJceOutputStream.write(this.type, 2);
    paramJceOutputStream.write(this.begin, 3);
    paramJceOutputStream.write(this.end, 4);
    if (this.message != null) {
      paramJceOutputStream.write(this.message, 5);
    }
    if (this.images != null) {
      paramJceOutputStream.write(this.images, 6);
    }
    if (this.urls != null) {
      paramJceOutputStream.write(this.urls, 7);
    }
    paramJceOutputStream.write(this.limit_expo, 8);
    paramJceOutputStream.write(this.limit_click, 9);
    paramJceOutputStream.write(this.limit_days, 10);
    if (this.spid != null) {
      paramJceOutputStream.write(this.spid, 11);
    }
    if (this.spid_blk != null) {
      paramJceOutputStream.write(this.spid_blk, 12);
    }
    if (this.appid != null) {
      paramJceOutputStream.write(this.appid, 13);
    }
    if (this.appid_blk != null) {
      paramJceOutputStream.write(this.appid_blk, 14);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\Wallet\AdvInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */