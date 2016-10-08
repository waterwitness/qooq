package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class OperBanner
  extends JceStruct
{
  static MaterialFile cache_stFile = new MaterialFile();
  public MaterialFile stFile;
  public String strH5JumpUrl = "";
  public String strSchema = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public OperBanner() {}
  
  public OperBanner(MaterialFile paramMaterialFile, String paramString1, String paramString2)
  {
    this.stFile = paramMaterialFile;
    this.strSchema = paramString1;
    this.strH5JumpUrl = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stFile = ((MaterialFile)paramJceInputStream.read(cache_stFile, 0, false));
    this.strSchema = paramJceInputStream.readString(1, false);
    this.strH5JumpUrl = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stFile != null) {
      paramJceOutputStream.write(this.stFile, 0);
    }
    if (this.strSchema != null) {
      paramJceOutputStream.write(this.strSchema, 1);
    }
    if (this.strH5JumpUrl != null) {
      paramJceOutputStream.write(this.strH5JumpUrl, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\NS_MOBILE_MATERIAL\OperBanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */