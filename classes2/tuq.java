import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public final class tuq
  implements INetEngine.IBreakDownFix
{
  public tuq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(NetReq paramNetReq, NetResp paramNetResp)
  {
    if ((paramNetReq == null) || (paramNetResp == null)) {}
    do
    {
      do
      {
        return;
      } while (!(paramNetReq instanceof HttpNetReq));
      paramNetReq = (HttpNetReq)paramNetReq;
      paramNetReq.jdField_a_of_type_Long += paramNetResp.c;
      paramNetResp.c = 0L;
      paramNetResp = "bytes=" + paramNetReq.jdField_a_of_type_Long + "-";
      paramNetReq.jdField_a_of_type_JavaUtilHashMap.put("Range", paramNetResp);
      paramNetResp = paramNetReq.jdField_a_of_type_JavaLangString;
      if (paramNetResp.contains("range="))
      {
        String str = paramNetResp.substring(0, paramNetResp.lastIndexOf("range="));
        paramNetReq.jdField_a_of_type_JavaLangString = (str + "range=" + paramNetReq.jdField_a_of_type_Long);
      }
    } while (!QLog.isColorLevel());
    QLog.i("PrecoverResDownloader", 2, "IBreakDownFix, " + paramNetResp);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tuq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */