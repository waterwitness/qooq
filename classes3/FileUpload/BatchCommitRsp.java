package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class BatchCommitRsp
  extends JceStruct
{
  private static Map<String, UploadPicInfoRsp> c = new HashMap();
  private static Map<String, UploadVideoInfoRsp> d;
  public Map<String, UploadPicInfoRsp> a = null;
  private Map<String, UploadVideoInfoRsp> b = null;
  
  static
  {
    Object localObject = new UploadPicInfoRsp();
    c.put("", localObject);
    d = new HashMap();
    localObject = new UploadVideoInfoRsp();
    d.put("", localObject);
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = ((Map)paramJceInputStream.read(c, 0, true));
    this.b = ((Map)paramJceInputStream.read(d, 1, true));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\FileUpload\BatchCommitRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */