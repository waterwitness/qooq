package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class mobile_sub_set_cover_req
  extends JceStruct
{
  public int controlBits;
  public String cover;
  public long coverScene;
  public String coverkey;
  public int iTransparency;
  public int iVideoHeight;
  public int iVideoWidth;
  public String strVideoPlay;
  public long syncflag;
  public String trace;
  public String type;
  public long uin;
  
  public mobile_sub_set_cover_req()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.cover = "";
    this.type = "";
    this.coverkey = "";
    this.trace = "";
    this.strVideoPlay = "";
  }
  
  public mobile_sub_set_cover_req(long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, long paramLong3, int paramInt1, String paramString4, int paramInt2, String paramString5, int paramInt3, int paramInt4)
  {
    this.cover = "";
    this.type = "";
    this.coverkey = "";
    this.trace = "";
    this.strVideoPlay = "";
    this.uin = paramLong1;
    this.cover = paramString1;
    this.type = paramString2;
    this.coverkey = paramString3;
    this.syncflag = paramLong2;
    this.coverScene = paramLong3;
    this.controlBits = paramInt1;
    this.trace = paramString4;
    this.iTransparency = paramInt2;
    this.strVideoPlay = paramString5;
    this.iVideoWidth = paramInt3;
    this.iVideoHeight = paramInt4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.cover = paramJceInputStream.readString(1, false);
    this.type = paramJceInputStream.readString(2, false);
    this.coverkey = paramJceInputStream.readString(3, false);
    this.syncflag = paramJceInputStream.read(this.syncflag, 4, false);
    this.coverScene = paramJceInputStream.read(this.coverScene, 5, false);
    this.controlBits = paramJceInputStream.read(this.controlBits, 6, false);
    this.trace = paramJceInputStream.readString(7, false);
    this.iTransparency = paramJceInputStream.read(this.iTransparency, 8, false);
    this.strVideoPlay = paramJceInputStream.readString(9, false);
    this.iVideoWidth = paramJceInputStream.read(this.iVideoWidth, 10, false);
    this.iVideoHeight = paramJceInputStream.read(this.iVideoHeight, 11, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.cover != null) {
      paramJceOutputStream.write(this.cover, 1);
    }
    if (this.type != null) {
      paramJceOutputStream.write(this.type, 2);
    }
    if (this.coverkey != null) {
      paramJceOutputStream.write(this.coverkey, 3);
    }
    paramJceOutputStream.write(this.syncflag, 4);
    paramJceOutputStream.write(this.coverScene, 5);
    paramJceOutputStream.write(this.controlBits, 6);
    if (this.trace != null) {
      paramJceOutputStream.write(this.trace, 7);
    }
    paramJceOutputStream.write(this.iTransparency, 8);
    if (this.strVideoPlay != null) {
      paramJceOutputStream.write(this.strVideoPlay, 9);
    }
    paramJceOutputStream.write(this.iVideoWidth, 10);
    paramJceOutputStream.write(this.iVideoHeight, 11);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_MAIN_PAGE\mobile_sub_set_cover_req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */