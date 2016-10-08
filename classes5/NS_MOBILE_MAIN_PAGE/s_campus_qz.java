package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class s_campus_qz
  extends JceStruct
{
  public int is_campus_qz_bar;
  public int num_feeds;
  public int num_msg;
  
  public s_campus_qz()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public s_campus_qz(int paramInt1, int paramInt2, int paramInt3)
  {
    this.is_campus_qz_bar = paramInt1;
    this.num_msg = paramInt2;
    this.num_feeds = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.is_campus_qz_bar = paramJceInputStream.read(this.is_campus_qz_bar, 0, false);
    this.num_msg = paramJceInputStream.read(this.num_msg, 1, false);
    this.num_feeds = paramJceInputStream.read(this.num_feeds, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.is_campus_qz_bar, 0);
    paramJceOutputStream.write(this.num_msg, 1);
    paramJceOutputStream.write(this.num_feeds, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_MAIN_PAGE\s_campus_qz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */