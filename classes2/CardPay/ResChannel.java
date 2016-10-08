package CardPay;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class ResChannel
  extends JceStruct
  implements Cloneable
{
  static ArrayList cache_vecChannel;
  public String msg;
  public int ret;
  public int subCmd;
  public ArrayList vecChannel;
  
  public ResChannel()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.msg = "";
  }
  
  public ResChannel(int paramInt1, int paramInt2, String paramString, ArrayList paramArrayList)
  {
    this.msg = "";
    this.subCmd = paramInt1;
    this.ret = paramInt2;
    this.msg = paramString;
    this.vecChannel = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.subCmd = paramJceInputStream.read(this.subCmd, 0, true);
    this.ret = paramJceInputStream.read(this.ret, 1, true);
    this.msg = paramJceInputStream.readString(2, true);
    if (cache_vecChannel == null)
    {
      cache_vecChannel = new ArrayList();
      Channel localChannel = new Channel();
      cache_vecChannel.add(localChannel);
    }
    this.vecChannel = ((ArrayList)paramJceInputStream.read(cache_vecChannel, 3, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.subCmd, 0);
    paramJceOutputStream.write(this.ret, 1);
    paramJceOutputStream.write(this.msg, 2);
    paramJceOutputStream.write(this.vecChannel, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\CardPay\ResChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */