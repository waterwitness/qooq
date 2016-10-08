import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.dingdong.DingdongOpenIdProvider;
import cooperation.dingdong.DingdongOpenIdProvider.Callback;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x589.oidb_0x589.GetUserOpenIdReq;
import tencent.im.oidb.cmd0x589.oidb_0x589.GetUserOpenIdRsp;

public class yax
{
  public DingdongOpenIdProvider.Callback a;
  public List a;
  public boolean a;
  public List b;
  
  public yax(DingdongOpenIdProvider paramDingdongOpenIdProvider, List paramList, DingdongOpenIdProvider.Callback paramCallback, boolean paramBoolean)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    int j = paramList.size();
    this.jdField_a_of_type_JavaUtilList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      paramDingdongOpenIdProvider = new oidb_0x589.GetUserOpenIdRsp();
      paramDingdongOpenIdProvider.setHasFlag(true);
      paramDingdongOpenIdProvider.msg_req_id.set((MessageMicro)paramList.get(i), true);
      paramDingdongOpenIdProvider.uint32_result.set(-1);
      this.jdField_a_of_type_JavaUtilList.add(paramDingdongOpenIdProvider);
      i += 1;
    }
    this.jdField_a_of_type_CooperationDingdongDingdongOpenIdProvider$Callback = paramCallback;
    this.b = new ArrayList(paramList.size());
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(oidb_0x589.GetUserOpenIdRsp paramGetUserOpenIdRsp)
  {
    this.b.add(paramGetUserOpenIdRsp);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */