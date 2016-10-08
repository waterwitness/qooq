package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class mobile_get_urlinfo_rsp
  extends JceStruct
{
  static ArrayList cache_images;
  public ArrayList images;
  public int ret;
  public String summary = "";
  public String title = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_images = new ArrayList();
    cache_images.add("");
  }
  
  public mobile_get_urlinfo_rsp() {}
  
  public mobile_get_urlinfo_rsp(int paramInt, String paramString1, String paramString2, ArrayList paramArrayList)
  {
    this.ret = paramInt;
    this.title = paramString1;
    this.summary = paramString2;
    this.images = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, true);
    this.title = paramJceInputStream.readString(1, false);
    this.summary = paramJceInputStream.readString(2, false);
    this.images = ((ArrayList)paramJceInputStream.read(cache_images, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.title != null) {
      paramJceOutputStream.write(this.title, 1);
    }
    if (this.summary != null) {
      paramJceOutputStream.write(this.summary, 2);
    }
    if (this.images != null) {
      paramJceOutputStream.write(this.images, 3);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\NS_MOBILE_EXTRA\mobile_get_urlinfo_rsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */