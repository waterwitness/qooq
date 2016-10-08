package NS_MOBILE_AD_BANNER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class MultiBanner
  extends JceStruct
{
  public String coverurl;
  public long createtime;
  public String jmpUrl;
  public int num;
  public String roomid;
  public String schemaurl;
  public String strNicks;
  public String summary;
  public long uUin;
  
  public MultiBanner()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strNicks = "";
    this.roomid = "";
    this.coverurl = "";
    this.summary = "";
    this.schemaurl = "";
    this.jmpUrl = "";
  }
  
  public MultiBanner(String paramString1, long paramLong1, String paramString2, long paramLong2, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6)
  {
    this.strNicks = "";
    this.roomid = "";
    this.coverurl = "";
    this.summary = "";
    this.schemaurl = "";
    this.jmpUrl = "";
    this.strNicks = paramString1;
    this.uUin = paramLong1;
    this.roomid = paramString2;
    this.createtime = paramLong2;
    this.coverurl = paramString3;
    this.num = paramInt;
    this.summary = paramString4;
    this.schemaurl = paramString5;
    this.jmpUrl = paramString6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strNicks = paramJceInputStream.readString(0, false);
    this.uUin = paramJceInputStream.read(this.uUin, 1, false);
    this.roomid = paramJceInputStream.readString(2, false);
    this.createtime = paramJceInputStream.read(this.createtime, 3, false);
    this.coverurl = paramJceInputStream.readString(4, false);
    this.num = paramJceInputStream.read(this.num, 5, false);
    this.summary = paramJceInputStream.readString(6, false);
    this.schemaurl = paramJceInputStream.readString(7, false);
    this.jmpUrl = paramJceInputStream.readString(8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.strNicks != null) {
      paramJceOutputStream.write(this.strNicks, 0);
    }
    paramJceOutputStream.write(this.uUin, 1);
    if (this.roomid != null) {
      paramJceOutputStream.write(this.roomid, 2);
    }
    paramJceOutputStream.write(this.createtime, 3);
    if (this.coverurl != null) {
      paramJceOutputStream.write(this.coverurl, 4);
    }
    paramJceOutputStream.write(this.num, 5);
    if (this.summary != null) {
      paramJceOutputStream.write(this.summary, 6);
    }
    if (this.schemaurl != null) {
      paramJceOutputStream.write(this.schemaurl, 7);
    }
    if (this.jmpUrl != null) {
      paramJceOutputStream.write(this.jmpUrl, 8);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_AD_BANNER\MultiBanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */