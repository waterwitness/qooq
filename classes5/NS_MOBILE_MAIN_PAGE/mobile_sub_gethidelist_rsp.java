package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class mobile_sub_gethidelist_rsp
  extends JceStruct
{
  static s_hidelist cache_hidelist;
  public s_hidelist hidelist;
  
  public mobile_sub_gethidelist_rsp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public mobile_sub_gethidelist_rsp(s_hidelist params_hidelist)
  {
    this.hidelist = params_hidelist;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_hidelist == null) {
      cache_hidelist = new s_hidelist();
    }
    this.hidelist = ((s_hidelist)paramJceInputStream.read(cache_hidelist, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.hidelist != null) {
      paramJceOutputStream.write(this.hidelist, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_MAIN_PAGE\mobile_sub_gethidelist_rsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */