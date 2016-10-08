package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public final class get_photo_list_ex_req
  extends JceStruct
{
  static Map cache_busi_param;
  public String albumid = "";
  public long albumtype;
  public int appid;
  public Map busi_param;
  public String curid = "";
  public String curlloc = "";
  public int get_comment;
  public long left;
  public String password = "";
  public long right;
  public int sheight;
  public int sort;
  public int swidth;
  public long type;
  public long uin;
  public String url = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_busi_param = new HashMap();
    cache_busi_param.put(Integer.valueOf(0), "");
  }
  
  public get_photo_list_ex_req() {}
  
  public get_photo_list_ex_req(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong4, String paramString4, Map paramMap, int paramInt5, String paramString5, long paramLong5)
  {
    this.uin = paramLong1;
    this.albumid = paramString1;
    this.curlloc = paramString2;
    this.left = paramLong2;
    this.right = paramLong3;
    this.password = paramString3;
    this.sort = paramInt1;
    this.get_comment = paramInt2;
    this.swidth = paramInt3;
    this.sheight = paramInt4;
    this.type = paramLong4;
    this.url = paramString4;
    this.busi_param = paramMap;
    this.appid = paramInt5;
    this.curid = paramString5;
    this.albumtype = paramLong5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.albumid = paramJceInputStream.readString(1, true);
    this.curlloc = paramJceInputStream.readString(2, true);
    this.left = paramJceInputStream.read(this.left, 3, true);
    this.right = paramJceInputStream.read(this.right, 4, true);
    this.password = paramJceInputStream.readString(5, true);
    this.sort = paramJceInputStream.read(this.sort, 6, true);
    this.get_comment = paramJceInputStream.read(this.get_comment, 7, true);
    this.swidth = paramJceInputStream.read(this.swidth, 8, false);
    this.sheight = paramJceInputStream.read(this.sheight, 9, false);
    this.type = paramJceInputStream.read(this.type, 10, false);
    this.url = paramJceInputStream.readString(11, false);
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 12, false));
    this.appid = paramJceInputStream.read(this.appid, 13, false);
    this.curid = paramJceInputStream.readString(14, false);
    this.albumtype = paramJceInputStream.read(this.albumtype, 15, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.albumid, 1);
    paramJceOutputStream.write(this.curlloc, 2);
    paramJceOutputStream.write(this.left, 3);
    paramJceOutputStream.write(this.right, 4);
    paramJceOutputStream.write(this.password, 5);
    paramJceOutputStream.write(this.sort, 6);
    paramJceOutputStream.write(this.get_comment, 7);
    paramJceOutputStream.write(this.swidth, 8);
    paramJceOutputStream.write(this.sheight, 9);
    paramJceOutputStream.write(this.type, 10);
    if (this.url != null) {
      paramJceOutputStream.write(this.url, 11);
    }
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 12);
    }
    paramJceOutputStream.write(this.appid, 13);
    if (this.curid != null) {
      paramJceOutputStream.write(this.curid, 14);
    }
    paramJceOutputStream.write(this.albumtype, 15);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_PHOTO\get_photo_list_ex_req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */