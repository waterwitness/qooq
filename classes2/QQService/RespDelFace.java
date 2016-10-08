package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class RespDelFace
  extends JceStruct
{
  static RespHead cache_stHeader;
  public int iFaceNum;
  public RespHead stHeader;
  public int uFaceTimeStamp;
  
  public RespDelFace()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RespDelFace(RespHead paramRespHead, int paramInt1, int paramInt2)
  {
    this.stHeader = paramRespHead;
    this.uFaceTimeStamp = paramInt1;
    this.iFaceNum = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new RespHead();
    }
    this.stHeader = ((RespHead)paramJceInputStream.read(cache_stHeader, 0, true));
    this.uFaceTimeStamp = paramJceInputStream.read(this.uFaceTimeStamp, 1, true);
    this.iFaceNum = paramJceInputStream.read(this.iFaceNum, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.uFaceTimeStamp, 1);
    paramJceOutputStream.write(this.iFaceNum, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\RespDelFace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */