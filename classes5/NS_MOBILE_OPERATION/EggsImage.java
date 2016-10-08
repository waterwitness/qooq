package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class EggsImage
  extends JceStruct
{
  static ImageIterm cache_big;
  static ImageIterm cache_middle;
  static ImageIterm cache_original;
  static ImageIterm cache_small;
  public ImageIterm big;
  public ImageIterm middle;
  public ImageIterm original;
  public ImageIterm small;
  
  public EggsImage()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public EggsImage(ImageIterm paramImageIterm1, ImageIterm paramImageIterm2, ImageIterm paramImageIterm3, ImageIterm paramImageIterm4)
  {
    this.original = paramImageIterm1;
    this.big = paramImageIterm2;
    this.middle = paramImageIterm3;
    this.small = paramImageIterm4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_original == null) {
      cache_original = new ImageIterm();
    }
    this.original = ((ImageIterm)paramJceInputStream.read(cache_original, 0, false));
    if (cache_big == null) {
      cache_big = new ImageIterm();
    }
    this.big = ((ImageIterm)paramJceInputStream.read(cache_big, 1, false));
    if (cache_middle == null) {
      cache_middle = new ImageIterm();
    }
    this.middle = ((ImageIterm)paramJceInputStream.read(cache_middle, 2, false));
    if (cache_small == null) {
      cache_small = new ImageIterm();
    }
    this.small = ((ImageIterm)paramJceInputStream.read(cache_small, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.original != null) {
      paramJceOutputStream.write(this.original, 0);
    }
    if (this.big != null) {
      paramJceOutputStream.write(this.big, 1);
    }
    if (this.middle != null) {
      paramJceOutputStream.write(this.middle, 2);
    }
    if (this.small != null) {
      paramJceOutputStream.write(this.small, 3);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_OPERATION\EggsImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */