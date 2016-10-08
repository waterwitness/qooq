package VipRecommend.MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class CommPayInfo
  extends JceStruct
{
  static ArrayList cache_payParams;
  static RecParam cache_recParam;
  public ArrayList payParams;
  public RecParam recParam;
  
  public CommPayInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public CommPayInfo(ArrayList paramArrayList, RecParam paramRecParam)
  {
    this.payParams = paramArrayList;
    this.recParam = paramRecParam;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_payParams == null)
    {
      cache_payParams = new ArrayList();
      PayParam localPayParam = new PayParam();
      cache_payParams.add(localPayParam);
    }
    this.payParams = ((ArrayList)paramJceInputStream.read(cache_payParams, 1, true));
    if (cache_recParam == null) {
      cache_recParam = new RecParam();
    }
    this.recParam = ((RecParam)paramJceInputStream.read(cache_recParam, 2, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.payParams, 1);
    paramJceOutputStream.write(this.recParam, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\VipRecommend\MQQ\CommPayInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */