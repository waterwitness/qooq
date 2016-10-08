package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stPhotoSepcInfo
  extends JceStruct
{
  public long iPhotoHeight = 0L;
  public long iPhotoSize = 0L;
  public long iPhotoType = 0L;
  public long iPhotoWidth = 0L;
  
  public stPhotoSepcInfo() {}
  
  public stPhotoSepcInfo(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this.iPhotoSize = paramLong1;
    this.iPhotoWidth = paramLong2;
    this.iPhotoHeight = paramLong3;
    this.iPhotoType = paramLong4;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.iPhotoSize = paramJceInputStream.read(this.iPhotoSize, 0, true);
    this.iPhotoWidth = paramJceInputStream.read(this.iPhotoWidth, 1, true);
    this.iPhotoHeight = paramJceInputStream.read(this.iPhotoHeight, 2, true);
    this.iPhotoType = paramJceInputStream.read(this.iPhotoType, 3, true);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iPhotoSize, 0);
    paramJceOutputStream.write(this.iPhotoWidth, 1);
    paramJceOutputStream.write(this.iPhotoHeight, 2);
    paramJceOutputStream.write(this.iPhotoType, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\FileUpload\stPhotoSepcInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */