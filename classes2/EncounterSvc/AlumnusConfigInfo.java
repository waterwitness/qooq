package EncounterSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class AlumnusConfigInfo
  extends JceStruct
{
  static byte[] cache_alumnus_pic_md5;
  static byte[] cache_alumnus_pic_url;
  public byte alumnus_entrance_open;
  public byte[] alumnus_pic_md5;
  public byte[] alumnus_pic_url;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_alumnus_pic_url = (byte[])new byte[1];
    ((byte[])cache_alumnus_pic_url)[0] = 0;
    cache_alumnus_pic_md5 = (byte[])new byte[1];
    ((byte[])cache_alumnus_pic_md5)[0] = 0;
  }
  
  public AlumnusConfigInfo() {}
  
  public AlumnusConfigInfo(byte paramByte, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.alumnus_entrance_open = paramByte;
    this.alumnus_pic_url = paramArrayOfByte1;
    this.alumnus_pic_md5 = paramArrayOfByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.alumnus_entrance_open = paramJceInputStream.read(this.alumnus_entrance_open, 0, false);
    this.alumnus_pic_url = ((byte[])paramJceInputStream.read(cache_alumnus_pic_url, 1, false));
    this.alumnus_pic_md5 = ((byte[])paramJceInputStream.read(cache_alumnus_pic_md5, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.alumnus_entrance_open, 0);
    if (this.alumnus_pic_url != null) {
      paramJceOutputStream.write(this.alumnus_pic_url, 1);
    }
    if (this.alumnus_pic_md5 != null) {
      paramJceOutputStream.write(this.alumnus_pic_md5, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\EncounterSvc\AlumnusConfigInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */