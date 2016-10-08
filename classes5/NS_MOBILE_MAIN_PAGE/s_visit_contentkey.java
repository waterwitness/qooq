package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class s_visit_contentkey
  extends JceStruct
{
  public long appid;
  public String contentid;
  public long tid;
  
  public s_visit_contentkey()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.contentid = "";
  }
  
  public s_visit_contentkey(long paramLong1, long paramLong2, String paramString)
  {
    this.contentid = "";
    this.tid = paramLong1;
    this.appid = paramLong2;
    this.contentid = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.tid = paramJceInputStream.read(this.tid, 0, true);
    this.appid = paramJceInputStream.read(this.appid, 1, true);
    this.contentid = paramJceInputStream.readString(2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.tid, 0);
    paramJceOutputStream.write(this.appid, 1);
    paramJceOutputStream.write(this.contentid, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_MAIN_PAGE\s_visit_contentkey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */