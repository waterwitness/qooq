package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class SvcRspBindUin
  extends JceStruct
{
  static ArrayList cache_vecResult;
  public ArrayList vecResult;
  
  public SvcRspBindUin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SvcRspBindUin(ArrayList paramArrayList)
  {
    this.vecResult = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vecResult == null)
    {
      cache_vecResult = new ArrayList();
      BindUinResult localBindUinResult = new BindUinResult();
      cache_vecResult.add(localBindUinResult);
    }
    this.vecResult = ((ArrayList)paramJceInputStream.read(cache_vecResult, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vecResult, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\SvcRspBindUin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */