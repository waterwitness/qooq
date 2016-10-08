package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class mobile_get_uimbitmap_rsp
  extends JceStruct
{
  public boolean switch_flag;
  public long uin;
  
  public mobile_get_uimbitmap_rsp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.switch_flag = true;
  }
  
  public mobile_get_uimbitmap_rsp(long paramLong, boolean paramBoolean)
  {
    this.switch_flag = true;
    this.uin = paramLong;
    this.switch_flag = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.switch_flag = paramJceInputStream.read(this.switch_flag, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.switch_flag, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_MAIN_PAGE\mobile_get_uimbitmap_rsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */