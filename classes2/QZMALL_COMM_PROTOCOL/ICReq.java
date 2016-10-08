package QZMALL_COMM_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ICReq
  extends JceStruct
{
  public String device_info;
  public String qua;
  public int scence;
  public long uObjUin;
  public long uUin;
  
  public ICReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.device_info = "";
    this.qua = "";
  }
  
  public ICReq(long paramLong1, long paramLong2, int paramInt, String paramString1, String paramString2)
  {
    this.device_info = "";
    this.qua = "";
    this.uUin = paramLong1;
    this.uObjUin = paramLong2;
    this.scence = paramInt;
    this.device_info = paramString1;
    this.qua = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uUin = paramJceInputStream.read(this.uUin, 0, false);
    this.uObjUin = paramJceInputStream.read(this.uObjUin, 1, false);
    this.scence = paramJceInputStream.read(this.scence, 2, false);
    this.device_info = paramJceInputStream.readString(3, false);
    this.qua = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uUin, 0);
    paramJceOutputStream.write(this.uObjUin, 1);
    paramJceOutputStream.write(this.scence, 2);
    if (this.device_info != null) {
      paramJceOutputStream.write(this.device_info, 3);
    }
    if (this.qua != null) {
      paramJceOutputStream.write(this.qua, 4);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QZMALL_COMM_PROTOCOL\ICReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */