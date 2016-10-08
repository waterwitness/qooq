package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class cancelPacket
  extends JceStruct
{
  private static ArrayList<FileId> b = new ArrayList();
  private ArrayList<FileId> a = null;
  
  static
  {
    FileId localFileId = new FileId();
    b.add(localFileId);
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = ((ArrayList)paramJceInputStream.read(b, 0, true));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\FileUpload\cancelPacket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */