package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PicUploadControlInfo
  extends JceStruct
{
  private static UploadPicInfoReq a = new UploadPicInfoReq();
  public int iAlbumTypeID = 0;
  public int iNeedCheckAlbum = 0;
  public UploadPicInfoReq picinfoReq = null;
  public String sAlbumID = "";
  
  public PicUploadControlInfo() {}
  
  public PicUploadControlInfo(String paramString, int paramInt1, UploadPicInfoReq paramUploadPicInfoReq, int paramInt2)
  {
    this.sAlbumID = paramString;
    this.iAlbumTypeID = paramInt1;
    this.picinfoReq = paramUploadPicInfoReq;
    this.iNeedCheckAlbum = paramInt2;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.sAlbumID = paramJceInputStream.readString(0, false);
    this.iAlbumTypeID = paramJceInputStream.read(this.iAlbumTypeID, 1, false);
    this.picinfoReq = ((UploadPicInfoReq)paramJceInputStream.read(a, 2, false));
    this.iNeedCheckAlbum = paramJceInputStream.read(this.iNeedCheckAlbum, 3, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.sAlbumID != null) {
      paramJceOutputStream.write(this.sAlbumID, 0);
    }
    paramJceOutputStream.write(this.iAlbumTypeID, 1);
    if (this.picinfoReq != null) {
      paramJceOutputStream.write(this.picinfoReq, 2);
    }
    paramJceOutputStream.write(this.iNeedCheckAlbum, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\FileUpload\PicUploadControlInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */