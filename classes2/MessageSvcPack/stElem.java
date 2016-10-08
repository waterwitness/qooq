package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class stElem
  extends JceStruct
{
  static stFace cache_face;
  static stText cache_text;
  public stFace face;
  public stText text;
  
  public stElem()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public stElem(stText paramstText, stFace paramstFace)
  {
    this.text = paramstText;
    this.face = paramstFace;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_text == null) {
      cache_text = new stText();
    }
    this.text = ((stText)paramJceInputStream.read(cache_text, 0, false));
    if (cache_face == null) {
      cache_face = new stFace();
    }
    this.face = ((stFace)paramJceInputStream.read(cache_face, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.text != null) {
      paramJceOutputStream.write(this.text, 0);
    }
    if (this.face != null) {
      paramJceOutputStream.write(this.face, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\MessageSvcPack\stElem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */