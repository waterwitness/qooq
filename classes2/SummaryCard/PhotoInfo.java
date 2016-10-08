package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class PhotoInfo
  extends JceStruct
{
  public String strPicUrl;
  public long uPhotoTimestamp;
  
  public PhotoInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strPicUrl = "";
  }
  
  public PhotoInfo(String paramString, long paramLong)
  {
    this.strPicUrl = "";
    this.strPicUrl = paramString;
    this.uPhotoTimestamp = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strPicUrl = paramJceInputStream.readString(0, true);
    this.uPhotoTimestamp = paramJceInputStream.read(this.uPhotoTimestamp, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strPicUrl, 0);
    paramJceOutputStream.write(this.uPhotoTimestamp, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SummaryCard\PhotoInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */