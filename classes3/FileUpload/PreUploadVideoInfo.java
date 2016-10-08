package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PreUploadVideoInfo
  extends JceStruct
{
  private static UploadVideoInfoReq a = new UploadVideoInfoReq();
  public String seq = "";
  public String session = "";
  public UploadVideoInfoReq videoInfoReq = null;
  
  public PreUploadVideoInfo() {}
  
  public PreUploadVideoInfo(String paramString1, String paramString2, UploadVideoInfoReq paramUploadVideoInfoReq)
  {
    this.seq = paramString1;
    this.session = paramString2;
    this.videoInfoReq = paramUploadVideoInfoReq;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.seq = paramJceInputStream.readString(0, true);
    this.session = paramJceInputStream.readString(1, true);
    this.videoInfoReq = ((UploadVideoInfoReq)paramJceInputStream.read(a, 2, true));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.seq, 0);
    paramJceOutputStream.write(this.session, 1);
    paramJceOutputStream.write(this.videoInfoReq, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\FileUpload\PreUploadVideoInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */