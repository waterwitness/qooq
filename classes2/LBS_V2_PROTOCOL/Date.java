package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class Date
  extends JceStruct
{
  public short _day;
  public short _mon;
  public short _year;
  
  public Date()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Date(short paramShort1, short paramShort2, short paramShort3)
  {
    this._year = paramShort1;
    this._mon = paramShort2;
    this._day = paramShort3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this._year = paramJceInputStream.read(this._year, 0, true);
    this._mon = paramJceInputStream.read(this._mon, 1, true);
    this._day = paramJceInputStream.read(this._day, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this._year, 0);
    paramJceOutputStream.write(this._mon, 1);
    paramJceOutputStream.write(this._day, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\LBS_V2_PROTOCOL\Date.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */