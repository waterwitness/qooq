package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ReqChangeDiscussName
  extends JceStruct
{
  public long DiscussUin;
  public String NewName;
  
  public ReqChangeDiscussName()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.NewName = "";
  }
  
  public ReqChangeDiscussName(long paramLong, String paramString)
  {
    this.NewName = "";
    this.DiscussUin = paramLong;
    this.NewName = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.DiscussUin = paramJceInputStream.read(this.DiscussUin, 0, true);
    this.NewName = paramJceInputStream.readString(1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.DiscussUin, 0);
    paramJceOutputStream.write(this.NewName, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\ReqChangeDiscussName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */