package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class s_schema
  extends JceStruct
{
  public int actiontype;
  public String actionurl;
  public String appid;
  public String downloadurl;
  public String postparams;
  public String schemapageurl;
  public byte usepost;
  
  public s_schema()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.actionurl = "";
    this.downloadurl = "";
    this.appid = "";
    this.postparams = "";
    this.schemapageurl = "";
  }
  
  public s_schema(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, byte paramByte, String paramString5)
  {
    this.actionurl = "";
    this.downloadurl = "";
    this.appid = "";
    this.postparams = "";
    this.schemapageurl = "";
    this.actiontype = paramInt;
    this.actionurl = paramString1;
    this.downloadurl = paramString2;
    this.appid = paramString3;
    this.postparams = paramString4;
    this.usepost = paramByte;
    this.schemapageurl = paramString5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.actiontype = paramJceInputStream.read(this.actiontype, 0, false);
    this.actionurl = paramJceInputStream.readString(1, false);
    this.downloadurl = paramJceInputStream.readString(2, false);
    this.appid = paramJceInputStream.readString(3, false);
    this.postparams = paramJceInputStream.readString(4, false);
    this.usepost = paramJceInputStream.read(this.usepost, 5, false);
    this.schemapageurl = paramJceInputStream.readString(6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.actiontype, 0);
    if (this.actionurl != null) {
      paramJceOutputStream.write(this.actionurl, 1);
    }
    if (this.downloadurl != null) {
      paramJceOutputStream.write(this.downloadurl, 2);
    }
    if (this.appid != null) {
      paramJceOutputStream.write(this.appid, 3);
    }
    if (this.postparams != null) {
      paramJceOutputStream.write(this.postparams, 4);
    }
    paramJceOutputStream.write(this.usepost, 5);
    if (this.schemapageurl != null) {
      paramJceOutputStream.write(this.schemapageurl, 6);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\s_schema.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */