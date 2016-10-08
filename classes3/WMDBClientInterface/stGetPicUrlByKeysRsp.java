package WMDBClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stGetPicUrlByKeysRsp
  extends JceStruct
{
  public String picUrl = "";
  
  public stGetPicUrlByKeysRsp() {}
  
  public stGetPicUrlByKeysRsp(String paramString)
  {
    this.picUrl = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.picUrl = paramJceInputStream.readString(0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.picUrl, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\WMDBClientInterface\stGetPicUrlByKeysRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */