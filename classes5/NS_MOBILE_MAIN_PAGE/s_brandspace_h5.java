package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class s_brandspace_h5
  extends JceStruct
{
  public String frdfans_nick;
  public long frdfans_num;
  public String url;
  
  public s_brandspace_h5()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.frdfans_nick = "";
    this.url = "";
  }
  
  public s_brandspace_h5(long paramLong, String paramString1, String paramString2)
  {
    this.frdfans_nick = "";
    this.url = "";
    this.frdfans_num = paramLong;
    this.frdfans_nick = paramString1;
    this.url = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.frdfans_num = paramJceInputStream.read(this.frdfans_num, 0, true);
    this.frdfans_nick = paramJceInputStream.readString(1, false);
    this.url = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.frdfans_num, 0);
    if (this.frdfans_nick != null) {
      paramJceOutputStream.write(this.frdfans_nick, 1);
    }
    if (this.url != null) {
      paramJceOutputStream.write(this.url, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_MAIN_PAGE\s_brandspace_h5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */