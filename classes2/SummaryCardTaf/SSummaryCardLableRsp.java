package SummaryCardTaf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class SSummaryCardLableRsp
  extends JceStruct
{
  static SUserLabel cache_likes;
  static int cache_ret;
  public SUserLabel likes;
  public String msg;
  public int ret;
  
  public SSummaryCardLableRsp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.msg = "";
  }
  
  public SSummaryCardLableRsp(int paramInt, String paramString, SUserLabel paramSUserLabel)
  {
    this.msg = "";
    this.ret = paramInt;
    this.msg = paramString;
    this.likes = paramSUserLabel;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, true);
    this.msg = paramJceInputStream.readString(1, false);
    if (cache_likes == null) {
      cache_likes = new SUserLabel();
    }
    this.likes = ((SUserLabel)paramJceInputStream.read(cache_likes, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 1);
    }
    if (this.likes != null) {
      paramJceOutputStream.write(this.likes, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SummaryCardTaf\SSummaryCardLableRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */