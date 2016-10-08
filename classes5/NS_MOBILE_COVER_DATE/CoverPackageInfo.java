package NS_MOBILE_COVER_DATE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class CoverPackageInfo
  extends JceStruct
{
  static int cache_coverStyle;
  static int cache_weather;
  public String PackageUrl;
  public int coverStyle;
  public short daytime;
  public String md5;
  public String prePic;
  public int weather;
  
  public CoverPackageInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.prePic = "";
    this.PackageUrl = "";
    this.md5 = "";
  }
  
  public CoverPackageInfo(String paramString1, String paramString2, String paramString3, int paramInt1, short paramShort, int paramInt2)
  {
    this.prePic = "";
    this.PackageUrl = "";
    this.md5 = "";
    this.prePic = paramString1;
    this.PackageUrl = paramString2;
    this.md5 = paramString3;
    this.weather = paramInt1;
    this.daytime = paramShort;
    this.coverStyle = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.prePic = paramJceInputStream.readString(0, false);
    this.PackageUrl = paramJceInputStream.readString(1, false);
    this.md5 = paramJceInputStream.readString(2, false);
    this.weather = paramJceInputStream.read(this.weather, 3, false);
    this.daytime = paramJceInputStream.read(this.daytime, 4, false);
    this.coverStyle = paramJceInputStream.read(this.coverStyle, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.prePic != null) {
      paramJceOutputStream.write(this.prePic, 0);
    }
    if (this.PackageUrl != null) {
      paramJceOutputStream.write(this.PackageUrl, 1);
    }
    if (this.md5 != null) {
      paramJceOutputStream.write(this.md5, 2);
    }
    paramJceOutputStream.write(this.weather, 3);
    paramJceOutputStream.write(this.daytime, 4);
    paramJceOutputStream.write(this.coverStyle, 5);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_COVER_DATE\CoverPackageInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */