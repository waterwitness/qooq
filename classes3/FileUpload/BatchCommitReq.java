package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class BatchCommitReq
  extends JceStruct
{
  private static ArrayList<PreuploadPicInfo> c = new ArrayList();
  private static ArrayList<PreUploadVideoInfo> d;
  public ArrayList<PreuploadPicInfo> a = null;
  private ArrayList<PreUploadVideoInfo> b = null;
  
  static
  {
    Object localObject = new PreuploadPicInfo();
    c.add(localObject);
    d = new ArrayList();
    localObject = new PreUploadVideoInfo();
    d.add(localObject);
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = ((ArrayList)paramJceInputStream.read(c, 0, true));
    this.b = ((ArrayList)paramJceInputStream.read(d, 1, true));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\FileUpload\BatchCommitReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */