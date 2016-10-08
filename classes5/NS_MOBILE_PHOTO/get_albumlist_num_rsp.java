package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class get_albumlist_num_rsp
  extends JceStruct
{
  public long album_num;
  public String msg;
  public int ret;
  
  public get_albumlist_num_rsp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.msg = "";
  }
  
  public get_albumlist_num_rsp(long paramLong, int paramInt, String paramString)
  {
    this.msg = "";
    this.album_num = paramLong;
    this.ret = paramInt;
    this.msg = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.album_num = paramJceInputStream.read(this.album_num, 0, true);
    this.ret = paramJceInputStream.read(this.ret, 1, false);
    this.msg = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.album_num, 0);
    paramJceOutputStream.write(this.ret, 1);
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_PHOTO\get_albumlist_num_rsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */