package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class publish_active_album_rsp
  extends JceStruct
{
  public String fake_feeds_client_key;
  public String msg;
  public int ret;
  
  public publish_active_album_rsp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.msg = "";
    this.fake_feeds_client_key = "";
  }
  
  public publish_active_album_rsp(int paramInt, String paramString1, String paramString2)
  {
    this.msg = "";
    this.fake_feeds_client_key = "";
    this.ret = paramInt;
    this.msg = paramString1;
    this.fake_feeds_client_key = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, true);
    this.msg = paramJceInputStream.readString(1, true);
    this.fake_feeds_client_key = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    paramJceOutputStream.write(this.msg, 1);
    if (this.fake_feeds_client_key != null) {
      paramJceOutputStream.write(this.fake_feeds_client_key, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_PHOTO\publish_active_album_rsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */