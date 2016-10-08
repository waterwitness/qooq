package MOBILE_QZMALL_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class Margin
  extends JceStruct
{
  public int iBottom;
  public int iLeft;
  public int iRight;
  public int iToRightBorderMargin;
  public int iToTopBorderMargin;
  public int iTop;
  
  public Margin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Margin(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.iLeft = paramInt1;
    this.iRight = paramInt2;
    this.iTop = paramInt3;
    this.iBottom = paramInt4;
    this.iToRightBorderMargin = paramInt5;
    this.iToTopBorderMargin = paramInt6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iLeft = paramJceInputStream.read(this.iLeft, 0, false);
    this.iRight = paramJceInputStream.read(this.iRight, 1, false);
    this.iTop = paramJceInputStream.read(this.iTop, 2, false);
    this.iBottom = paramJceInputStream.read(this.iBottom, 3, false);
    this.iToRightBorderMargin = paramJceInputStream.read(this.iToRightBorderMargin, 4, false);
    this.iToTopBorderMargin = paramJceInputStream.read(this.iToTopBorderMargin, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iLeft, 0);
    paramJceOutputStream.write(this.iRight, 1);
    paramJceOutputStream.write(this.iTop, 2);
    paramJceOutputStream.write(this.iBottom, 3);
    paramJceOutputStream.write(this.iToRightBorderMargin, 4);
    paramJceOutputStream.write(this.iToTopBorderMargin, 5);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\MOBILE_QZMALL_PROTOCOL\Margin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */