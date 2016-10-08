package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class PhotoInformation
  extends JceStruct
{
  public int iHight;
  public int iPhotoType;
  public int iWidth;
  public String sUrl;
  
  public PhotoInformation()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.sUrl = "";
  }
  
  public PhotoInformation(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.sUrl = "";
    this.sUrl = paramString;
    this.iWidth = paramInt1;
    this.iHight = paramInt2;
    this.iPhotoType = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sUrl = paramJceInputStream.readString(0, false);
    this.iWidth = paramJceInputStream.read(this.iWidth, 1, false);
    this.iHight = paramJceInputStream.read(this.iHight, 2, false);
    this.iPhotoType = paramJceInputStream.read(this.iPhotoType, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.sUrl != null) {
      paramJceOutputStream.write(this.sUrl, 0);
    }
    paramJceOutputStream.write(this.iWidth, 1);
    paramJceOutputStream.write(this.iHight, 2);
    paramJceOutputStream.write(this.iPhotoType, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_OPERATION\PhotoInformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */