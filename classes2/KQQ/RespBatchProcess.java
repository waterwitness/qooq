package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class RespBatchProcess
  extends JceStruct
{
  static ArrayList cache_batch_response_list;
  public ArrayList batch_response_list;
  
  public RespBatchProcess()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RespBatchProcess(ArrayList paramArrayList)
  {
    this.batch_response_list = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_batch_response_list == null)
    {
      cache_batch_response_list = new ArrayList();
      BatchResponse localBatchResponse = new BatchResponse();
      cache_batch_response_list.add(localBatchResponse);
    }
    this.batch_response_list = ((ArrayList)paramJceInputStream.read(cache_batch_response_list, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.batch_response_list != null) {
      paramJceOutputStream.write(this.batch_response_list, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQ\RespBatchProcess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */