package NS_MOBILE_AD_BANNER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public final class OneVideoInfo
  extends JceStruct
{
  static Map cache_extendinfo;
  public int actiontype;
  public String actionurl = "";
  public String clientkey = "";
  public String coverurl = "";
  public long createtime;
  public Map extendinfo;
  public int filetype;
  public int height;
  public String lloc = "";
  public byte playtype;
  public String shuoid = "";
  public String sloc = "";
  public String toast = "";
  public String videoid = "";
  public int videostatus;
  public long videotime;
  public byte videotype;
  public String videourl = "";
  public int width;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_extendinfo = new HashMap();
    cache_extendinfo.put("", "");
  }
  
  public OneVideoInfo() {}
  
  public OneVideoInfo(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, byte paramByte1, long paramLong1, long paramLong2, byte paramByte2, int paramInt3, String paramString6, Map paramMap, String paramString7, String paramString8, int paramInt4, int paramInt5, String paramString9)
  {
    this.videoid = paramString1;
    this.videourl = paramString2;
    this.coverurl = paramString3;
    this.actiontype = paramInt1;
    this.actionurl = paramString4;
    this.clientkey = paramString5;
    this.filetype = paramInt2;
    this.videotype = paramByte1;
    this.videotime = paramLong1;
    this.createtime = paramLong2;
    this.playtype = paramByte2;
    this.videostatus = paramInt3;
    this.toast = paramString6;
    this.extendinfo = paramMap;
    this.sloc = paramString7;
    this.lloc = paramString8;
    this.width = paramInt4;
    this.height = paramInt5;
    this.shuoid = paramString9;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.videoid = paramJceInputStream.readString(0, false);
    this.videourl = paramJceInputStream.readString(1, false);
    this.coverurl = paramJceInputStream.readString(2, false);
    this.actiontype = paramJceInputStream.read(this.actiontype, 3, false);
    this.actionurl = paramJceInputStream.readString(4, false);
    this.clientkey = paramJceInputStream.readString(5, false);
    this.filetype = paramJceInputStream.read(this.filetype, 6, false);
    this.videotype = paramJceInputStream.read(this.videotype, 7, false);
    this.videotime = paramJceInputStream.read(this.videotime, 8, false);
    this.createtime = paramJceInputStream.read(this.createtime, 9, false);
    this.playtype = paramJceInputStream.read(this.playtype, 10, false);
    this.videostatus = paramJceInputStream.read(this.videostatus, 11, false);
    this.toast = paramJceInputStream.readString(12, false);
    this.extendinfo = ((Map)paramJceInputStream.read(cache_extendinfo, 13, false));
    this.sloc = paramJceInputStream.readString(14, false);
    this.lloc = paramJceInputStream.readString(15, false);
    this.width = paramJceInputStream.read(this.width, 16, false);
    this.height = paramJceInputStream.read(this.height, 17, false);
    this.shuoid = paramJceInputStream.readString(18, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.videoid != null) {
      paramJceOutputStream.write(this.videoid, 0);
    }
    if (this.videourl != null) {
      paramJceOutputStream.write(this.videourl, 1);
    }
    if (this.coverurl != null) {
      paramJceOutputStream.write(this.coverurl, 2);
    }
    paramJceOutputStream.write(this.actiontype, 3);
    if (this.actionurl != null) {
      paramJceOutputStream.write(this.actionurl, 4);
    }
    if (this.clientkey != null) {
      paramJceOutputStream.write(this.clientkey, 5);
    }
    paramJceOutputStream.write(this.filetype, 6);
    paramJceOutputStream.write(this.videotype, 7);
    paramJceOutputStream.write(this.videotime, 8);
    paramJceOutputStream.write(this.createtime, 9);
    paramJceOutputStream.write(this.playtype, 10);
    paramJceOutputStream.write(this.videostatus, 11);
    if (this.toast != null) {
      paramJceOutputStream.write(this.toast, 12);
    }
    if (this.extendinfo != null) {
      paramJceOutputStream.write(this.extendinfo, 13);
    }
    if (this.sloc != null) {
      paramJceOutputStream.write(this.sloc, 14);
    }
    if (this.lloc != null) {
      paramJceOutputStream.write(this.lloc, 15);
    }
    paramJceOutputStream.write(this.width, 16);
    paramJceOutputStream.write(this.height, 17);
    if (this.shuoid != null) {
      paramJceOutputStream.write(this.shuoid, 18);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_AD_BANNER\OneVideoInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */