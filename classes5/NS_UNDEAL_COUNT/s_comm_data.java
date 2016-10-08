package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class s_comm_data
  extends JceStruct
{
  static byte[] cache_vecData;
  public int iHasDataFlag;
  public String strAttachInfo;
  public byte[] vecData;
  
  public s_comm_data()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strAttachInfo = "";
  }
  
  public s_comm_data(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    this.strAttachInfo = "";
    this.iHasDataFlag = paramInt;
    this.strAttachInfo = paramString;
    this.vecData = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iHasDataFlag = paramJceInputStream.read(this.iHasDataFlag, 0, false);
    this.strAttachInfo = paramJceInputStream.readString(1, false);
    if (cache_vecData == null)
    {
      cache_vecData = (byte[])new byte[1];
      ((byte[])cache_vecData)[0] = 0;
    }
    this.vecData = ((byte[])paramJceInputStream.read(cache_vecData, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iHasDataFlag, 0);
    if (this.strAttachInfo != null) {
      paramJceOutputStream.write(this.strAttachInfo, 1);
    }
    if (this.vecData != null) {
      paramJceOutputStream.write(this.vecData, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_UNDEAL_COUNT\s_comm_data.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */