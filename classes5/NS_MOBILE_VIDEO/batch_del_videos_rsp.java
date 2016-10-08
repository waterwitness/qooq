package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class batch_del_videos_rsp
  extends JceStruct
{
  static ArrayList cache_summarys;
  public String msg;
  public int ret;
  public ArrayList summarys;
  
  public batch_del_videos_rsp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.msg = "";
  }
  
  public batch_del_videos_rsp(int paramInt, String paramString, ArrayList paramArrayList)
  {
    this.msg = "";
    this.ret = paramInt;
    this.msg = paramString;
    this.summarys = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.msg = paramJceInputStream.readString(1, false);
    if (cache_summarys == null)
    {
      cache_summarys = new ArrayList();
      DelVideoSummary localDelVideoSummary = new DelVideoSummary();
      cache_summarys.add(localDelVideoSummary);
    }
    this.summarys = ((ArrayList)paramJceInputStream.read(cache_summarys, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 1);
    }
    if (this.summarys != null) {
      paramJceOutputStream.write(this.summarys, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_VIDEO\batch_del_videos_rsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */