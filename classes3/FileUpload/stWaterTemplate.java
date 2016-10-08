package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stWaterTemplate
  extends JceStruct
{
  private String a = "";
  private String b = "";
  
  public stWaterTemplate() {}
  
  public stWaterTemplate(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.readString(0, false);
    this.b = paramJceInputStream.readString(1, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.a != null) {
      paramJceOutputStream.write(this.a, 0);
    }
    if (this.b != null) {
      paramJceOutputStream.write(this.b, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\FileUpload\stWaterTemplate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */