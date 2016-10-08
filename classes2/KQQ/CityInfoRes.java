package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class CityInfoRes
  extends JceStruct
{
  public String city;
  public String province;
  public byte result;
  
  public CityInfoRes()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.city = "";
    this.province = "";
  }
  
  public CityInfoRes(byte paramByte, String paramString1, String paramString2)
  {
    this.city = "";
    this.province = "";
    this.result = paramByte;
    this.city = paramString1;
    this.province = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.result = paramJceInputStream.read(this.result, 1, true);
    this.city = paramJceInputStream.readString(2, true);
    this.province = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.result, 1);
    paramJceOutputStream.write(this.city, 2);
    if (this.province != null) {
      paramJceOutputStream.write(this.province, 3);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQ\CityInfoRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */