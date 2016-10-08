import android.content.Intent;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.app.CircleServlet;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;

public class pvi
  implements INetEngine.INetEngineListener
{
  private Intent jdField_a_of_type_AndroidContentIntent;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  public pvi(CircleServlet paramCircleServlet, Intent paramIntent, byte[] paramArrayOfByte)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  public void a(NetResp paramNetResp)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("CircleManager", 2, "CircleHttpCommnunicatorListener$onResp");
    }
    if ((paramNetResp == null) || (paramNetResp.e != 0))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("CircleHttpCommnunicatorListener$onResp | resp = ").append(paramNetResp).append(" | mResult=");
        if (paramNetResp != null) {
          i = paramNetResp.e;
        }
        QLog.d("CircleManager", 2, i);
      }
      CircleServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppCircleServlet, this.jdField_a_of_type_AndroidContentIntent, -10, null, new byte[1]);
      CircleServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppCircleServlet).a();
      return;
    }
    CircleServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppCircleServlet, this.jdField_a_of_type_AndroidContentIntent, 0, paramNetResp.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_ArrayOfByte);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pvi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */