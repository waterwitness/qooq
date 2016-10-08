package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class FeedQzmallDeco
  extends JceStruct
{
  static QzmallCustomVip cache_stCustomVip = new QzmallCustomVip();
  static QzmallFeedAvatar cache_stFeedAvatar;
  public QzmallCustomVip stCustomVip;
  public QzmallFeedAvatar stFeedAvatar;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_stFeedAvatar = new QzmallFeedAvatar();
  }
  
  public FeedQzmallDeco() {}
  
  public FeedQzmallDeco(QzmallFeedAvatar paramQzmallFeedAvatar, QzmallCustomVip paramQzmallCustomVip)
  {
    this.stFeedAvatar = paramQzmallFeedAvatar;
    this.stCustomVip = paramQzmallCustomVip;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stFeedAvatar = ((QzmallFeedAvatar)paramJceInputStream.read(cache_stFeedAvatar, 0, false));
    this.stCustomVip = ((QzmallCustomVip)paramJceInputStream.read(cache_stCustomVip, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stFeedAvatar != null) {
      paramJceOutputStream.write(this.stFeedAvatar, 0);
    }
    if (this.stCustomVip != null) {
      paramJceOutputStream.write(this.stCustomVip, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\NS_QMALL_COVER\FeedQzmallDeco.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */