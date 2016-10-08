package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class master_info
  extends JceStruct
{
  public long host_unimbitmap;
  public int iLevel;
  public String strMessage;
  
  public master_info()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strMessage = "";
  }
  
  public master_info(int paramInt, String paramString, long paramLong)
  {
    this.strMessage = "";
    this.iLevel = paramInt;
    this.strMessage = paramString;
    this.host_unimbitmap = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iLevel = paramJceInputStream.read(this.iLevel, 0, false);
    this.strMessage = paramJceInputStream.readString(1, false);
    this.host_unimbitmap = paramJceInputStream.read(this.host_unimbitmap, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iLevel, 0);
    if (this.strMessage != null) {
      paramJceOutputStream.write(this.strMessage, 1);
    }
    paramJceOutputStream.write(this.host_unimbitmap, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_UNDEAL_COUNT\master_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */