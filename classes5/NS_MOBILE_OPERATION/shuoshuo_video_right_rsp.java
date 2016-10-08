package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class shuoshuo_video_right_rsp
  extends JceStruct
{
  public boolean isverified;
  public String msg;
  public int remain_times;
  public int ret;
  
  public shuoshuo_video_right_rsp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.msg = "";
    this.isverified = true;
  }
  
  public shuoshuo_video_right_rsp(int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    this.msg = "";
    this.isverified = true;
    this.ret = paramInt1;
    this.msg = paramString;
    this.isverified = paramBoolean;
    this.remain_times = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.msg = paramJceInputStream.readString(1, false);
    this.isverified = paramJceInputStream.read(this.isverified, 2, false);
    this.remain_times = paramJceInputStream.read(this.remain_times, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 1);
    }
    paramJceOutputStream.write(this.isverified, 2);
    paramJceOutputStream.write(this.remain_times, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_OPERATION\shuoshuo_video_right_rsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */