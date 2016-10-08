package NS_MOBILE_COMM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ParasiticUnit
  extends JceStruct
{
  static byte[] cache_vecData;
  public int iDataEdit;
  public int iDataType;
  public String strSubCmdCode = "";
  public byte[] vecData;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_vecData = (byte[])new byte[1];
    ((byte[])cache_vecData)[0] = 0;
  }
  
  public ParasiticUnit() {}
  
  public ParasiticUnit(int paramInt1, int paramInt2, String paramString, byte[] paramArrayOfByte)
  {
    this.iDataType = paramInt1;
    this.iDataEdit = paramInt2;
    this.strSubCmdCode = paramString;
    this.vecData = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iDataType = paramJceInputStream.read(this.iDataType, 0, false);
    this.iDataEdit = paramJceInputStream.read(this.iDataEdit, 1, false);
    this.strSubCmdCode = paramJceInputStream.readString(2, false);
    this.vecData = ((byte[])paramJceInputStream.read(cache_vecData, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iDataType, 0);
    paramJceOutputStream.write(this.iDataEdit, 1);
    if (this.strSubCmdCode != null) {
      paramJceOutputStream.write(this.strSubCmdCode, 2);
    }
    if (this.vecData != null) {
      paramJceOutputStream.write(this.vecData, 3);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_COMM\ParasiticUnit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */