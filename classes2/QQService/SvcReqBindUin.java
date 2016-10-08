package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class SvcReqBindUin
  extends JceStruct
{
  static ArrayList cache_vecBindUin;
  public byte cCmd;
  public ArrayList vecBindUin;
  
  public SvcReqBindUin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SvcReqBindUin(byte paramByte, ArrayList paramArrayList)
  {
    this.cCmd = paramByte;
    this.vecBindUin = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cCmd = paramJceInputStream.read(this.cCmd, 0, true);
    if (cache_vecBindUin == null)
    {
      cache_vecBindUin = new ArrayList();
      BindUin localBindUin = new BindUin();
      cache_vecBindUin.add(localBindUin);
    }
    this.vecBindUin = ((ArrayList)paramJceInputStream.read(cache_vecBindUin, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cCmd, 0);
    paramJceOutputStream.write(this.vecBindUin, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\SvcReqBindUin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */