package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class stPhotoTags
  extends JceStruct
{
  private static ArrayList<stPhotoTag> b = new ArrayList();
  private ArrayList<stPhotoTag> a = null;
  
  static
  {
    stPhotoTag localstPhotoTag = new stPhotoTag();
    b.add(localstPhotoTag);
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = ((ArrayList)paramJceInputStream.read(b, 0, false));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.a != null) {
      paramJceOutputStream.write(this.a, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\FileUpload\stPhotoTags.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */