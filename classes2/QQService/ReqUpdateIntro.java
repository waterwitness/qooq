package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ReqUpdateIntro
  extends JceStruct
{
  static ReqHead cache_stHeader;
  static Intro cache_stIntro;
  public ReqHead stHeader;
  public Intro stIntro;
  
  public ReqUpdateIntro()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ReqUpdateIntro(ReqHead paramReqHead, Intro paramIntro)
  {
    this.stHeader = paramReqHead;
    this.stIntro = paramIntro;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHead();
    }
    this.stHeader = ((ReqHead)paramJceInputStream.read(cache_stHeader, 0, true));
    if (cache_stIntro == null) {
      cache_stIntro = new Intro();
    }
    this.stIntro = ((Intro)paramJceInputStream.read(cache_stIntro, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.stIntro, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\ReqUpdateIntro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */