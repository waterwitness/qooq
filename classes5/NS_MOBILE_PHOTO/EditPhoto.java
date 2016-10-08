package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class EditPhoto
  extends JceStruct
{
  public String desc;
  public int modifytime;
  public String name;
  public int uploadtime;
  
  public EditPhoto()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.name = "";
    this.desc = "";
  }
  
  public EditPhoto(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.name = "";
    this.desc = "";
    this.name = paramString1;
    this.desc = paramString2;
    this.uploadtime = paramInt1;
    this.modifytime = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.name = paramJceInputStream.readString(0, false);
    this.desc = paramJceInputStream.readString(1, false);
    this.uploadtime = paramJceInputStream.read(this.uploadtime, 2, false);
    this.modifytime = paramJceInputStream.read(this.modifytime, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.name != null) {
      paramJceOutputStream.write(this.name, 0);
    }
    if (this.desc != null) {
      paramJceOutputStream.write(this.desc, 1);
    }
    paramJceOutputStream.write(this.uploadtime, 2);
    paramJceOutputStream.write(this.modifytime, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_PHOTO\EditPhoto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */