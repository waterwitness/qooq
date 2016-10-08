package ConfigPush;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class FileStorageServerListInfo
  extends JceStruct
{
  public int iPort;
  public String sIP;
  
  public FileStorageServerListInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.sIP = "";
  }
  
  public FileStorageServerListInfo(String paramString, int paramInt)
  {
    this.sIP = "";
    this.sIP = paramString;
    this.iPort = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sIP = paramJceInputStream.readString(1, true);
    this.iPort = paramJceInputStream.read(this.iPort, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.sIP, 1);
    paramJceOutputStream.write(this.iPort, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ConfigPush\FileStorageServerListInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */