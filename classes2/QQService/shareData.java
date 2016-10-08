package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class shareData
  extends JceStruct
{
  public String msgtail;
  public String picurl;
  public String pkgname;
  public String url;
  
  public shareData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.pkgname = "";
    this.msgtail = "";
    this.picurl = "";
    this.url = "";
  }
  
  public shareData(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.pkgname = "";
    this.msgtail = "";
    this.picurl = "";
    this.url = "";
    this.pkgname = paramString1;
    this.msgtail = paramString2;
    this.picurl = paramString3;
    this.url = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.pkgname = paramJceInputStream.readString(0, true);
    this.msgtail = paramJceInputStream.readString(1, true);
    this.picurl = paramJceInputStream.readString(2, true);
    this.url = paramJceInputStream.readString(3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.pkgname, 0);
    paramJceOutputStream.write(this.msgtail, 1);
    paramJceOutputStream.write(this.picurl, 2);
    paramJceOutputStream.write(this.url, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\shareData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */