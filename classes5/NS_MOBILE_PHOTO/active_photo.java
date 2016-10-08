package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class active_photo
  extends JceStruct
{
  public String albumid;
  public String desc;
  public String photoid;
  public String title;
  
  public active_photo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.albumid = "";
    this.photoid = "";
    this.title = "";
    this.desc = "";
  }
  
  public active_photo(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.albumid = "";
    this.photoid = "";
    this.title = "";
    this.desc = "";
    this.albumid = paramString1;
    this.photoid = paramString2;
    this.title = paramString3;
    this.desc = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.albumid = paramJceInputStream.readString(0, true);
    this.photoid = paramJceInputStream.readString(1, true);
    this.title = paramJceInputStream.readString(2, true);
    this.desc = paramJceInputStream.readString(3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.albumid, 0);
    paramJceOutputStream.write(this.photoid, 1);
    paramJceOutputStream.write(this.title, 2);
    paramJceOutputStream.write(this.desc, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_PHOTO\active_photo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */