package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class GetAlbumAbilityResp
  extends JceStruct
{
  static int cache_result;
  static ArrayList cache_vecAlbumAbiUins;
  public int result;
  public long uin;
  public ArrayList vecAlbumAbiUins;
  
  public GetAlbumAbilityResp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public GetAlbumAbilityResp(long paramLong, int paramInt, ArrayList paramArrayList)
  {
    this.uin = paramLong;
    this.result = paramInt;
    this.vecAlbumAbiUins = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.result = paramJceInputStream.read(this.result, 1, true);
    if (cache_vecAlbumAbiUins == null)
    {
      cache_vecAlbumAbiUins = new ArrayList();
      stAlbumAbiInfo localstAlbumAbiInfo = new stAlbumAbiInfo();
      cache_vecAlbumAbiUins.add(localstAlbumAbiInfo);
    }
    this.vecAlbumAbiUins = ((ArrayList)paramJceInputStream.read(cache_vecAlbumAbiUins, 2, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.result, 1);
    paramJceOutputStream.write(this.vecAlbumAbiUins, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\friendlist\GetAlbumAbilityResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */