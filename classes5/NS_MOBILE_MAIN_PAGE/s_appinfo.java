package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class s_appinfo
  extends JceStruct
{
  public int infonum;
  
  public s_appinfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public s_appinfo(int paramInt)
  {
    this.infonum = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.infonum = paramJceInputStream.read(this.infonum, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.infonum, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_MAIN_PAGE\s_appinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */