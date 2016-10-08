package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class ReqBatchProcess
  extends JceStruct
{
  static ArrayList cache_batch_request_list;
  public ArrayList batch_request_list;
  
  public ReqBatchProcess()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ReqBatchProcess(ArrayList paramArrayList)
  {
    this.batch_request_list = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_batch_request_list == null)
    {
      cache_batch_request_list = new ArrayList();
      BatchRequest localBatchRequest = new BatchRequest();
      cache_batch_request_list.add(localBatchRequest);
    }
    this.batch_request_list = ((ArrayList)paramJceInputStream.read(cache_batch_request_list, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.batch_request_list != null) {
      paramJceOutputStream.write(this.batch_request_list, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQ\ReqBatchProcess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */