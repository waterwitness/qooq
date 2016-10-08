import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAlumniServlet;
import com.tencent.mobileqq.nearby.OldBigDataChannelManager;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;

public class thh
  implements INetEngine.INetEngineListener
{
  private Intent jdField_a_of_type_AndroidContentIntent;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  public thh(NearbyAlumniServlet paramNearbyAlumniServlet, Intent paramIntent, byte[] paramArrayOfByte)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  public void a(NetResp paramNetResp)
  {
    if (QLog.isColorLevel()) {
      QLog.i(NearbyAlumniServlet.a(), 2, "NearbyAlumniDownloadListener.onResp()");
    }
    if ((paramNetResp == null) || (paramNetResp.e != 0))
    {
      String str;
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        str = NearbyAlumniServlet.a();
        localStringBuilder = new StringBuilder().append("NearbyAlumniDownloadListener.onResp() | resp = ").append(paramNetResp).append(" | mResult=");
        if (paramNetResp == null) {
          break label116;
        }
      }
      label116:
      for (int i = paramNetResp.e;; i = -1)
      {
        QLog.i(str, 2, i);
        NearbyAlumniServlet.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAlumniServlet, this.jdField_a_of_type_AndroidContentIntent, -10, null, new byte[1]);
        paramNetResp = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAlumniServlet.a();
        if (paramNetResp != null) {
          paramNetResp.a();
        }
        return;
      }
    }
    NearbyAlumniServlet.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAlumniServlet, this.jdField_a_of_type_AndroidContentIntent, 0, paramNetResp.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_ArrayOfByte);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\thh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */