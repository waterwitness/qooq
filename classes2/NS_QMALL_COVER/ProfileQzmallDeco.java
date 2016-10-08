package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ProfileQzmallDeco
  extends JceStruct
{
  static QzmallCustomNavi cache_stCustomNavi = new QzmallCustomNavi();
  public QzmallCustomNavi stCustomNavi;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ProfileQzmallDeco() {}
  
  public ProfileQzmallDeco(QzmallCustomNavi paramQzmallCustomNavi)
  {
    this.stCustomNavi = paramQzmallCustomNavi;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stCustomNavi = ((QzmallCustomNavi)paramJceInputStream.read(cache_stCustomNavi, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stCustomNavi != null) {
      paramJceOutputStream.write(this.stCustomNavi, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\NS_QMALL_COVER\ProfileQzmallDeco.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */