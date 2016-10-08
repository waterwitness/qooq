package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class QzmallFeedAvatar
  extends JceStruct
{
  static int cache_eAvatarType = 0;
  public int eAvatarType = 1;
  public int iItemId = -1;
  public String strAvatarJumpUrl = "";
  public String strAvatarUrl = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QzmallFeedAvatar() {}
  
  public QzmallFeedAvatar(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    this.iItemId = paramInt1;
    this.strAvatarUrl = paramString1;
    this.strAvatarJumpUrl = paramString2;
    this.eAvatarType = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iItemId = paramJceInputStream.read(this.iItemId, 0, true);
    this.strAvatarUrl = paramJceInputStream.readString(1, false);
    this.strAvatarJumpUrl = paramJceInputStream.readString(2, false);
    this.eAvatarType = paramJceInputStream.read(this.eAvatarType, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iItemId, 0);
    if (this.strAvatarUrl != null) {
      paramJceOutputStream.write(this.strAvatarUrl, 1);
    }
    if (this.strAvatarJumpUrl != null) {
      paramJceOutputStream.write(this.strAvatarJumpUrl, 2);
    }
    paramJceOutputStream.write(this.eAvatarType, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\NS_QMALL_COVER\QzmallFeedAvatar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */