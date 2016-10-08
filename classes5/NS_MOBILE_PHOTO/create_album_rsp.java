package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class create_album_rsp
  extends JceStruct
{
  public String albumid;
  
  public create_album_rsp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.albumid = "";
  }
  
  public create_album_rsp(String paramString)
  {
    this.albumid = "";
    this.albumid = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.albumid = paramJceInputStream.readString(0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.albumid, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_PHOTO\create_album_rsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */