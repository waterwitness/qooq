package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UploadCoverPicInfoRsp
  extends JceStruct
{
  private String a = "";
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.readString(0, true);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\FileUpload\UploadCoverPicInfoRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */