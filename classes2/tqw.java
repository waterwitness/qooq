import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.olympic.OlympicHandler;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import tencent.im.oidb.olympic.MqqLbs.LBSInfo;
import tencent.im.oidb.olympic.OlympicTorchSvc.ReqDeliverTorch;

public class tqw
  extends SosoInterface.OnLocationListener
{
  public tqw(OlympicHandler paramOlympicHandler, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, boolean paramBoolean3, boolean paramBoolean4, String paramString, long paramLong2, int paramInt2, byte[] paramArrayOfByte)
  {
    super(paramInt1, paramBoolean1, paramBoolean2, paramLong1, paramBoolean3, paramBoolean4, paramString);
    paramBoolean1 = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt != 0) || (paramSosoLbsInfo == null) || (paramSosoLbsInfo.a == null))
    {
      OlympicUtil.b("OlympicHandler", new Object[] { "onDeliverTorch, onLocationFinish, errCode=", Integer.valueOf(paramInt), ", info==null || info.mLocation==null" });
      this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicHandler.a(1, false, new Object[] { Boolean.valueOf(false), Integer.valueOf(31), "", Integer.valueOf(0), Integer.valueOf(0), null });
      return;
    }
    OlympicUtil.b("OlympicHandler", new Object[] { "onDeliverTorch, onLocationFinish, errCode=", Integer.valueOf(paramInt), ", info=", paramSosoLbsInfo });
    Object localObject = OlympicUtil.a(paramSosoLbsInfo);
    paramSosoLbsInfo = new OlympicTorchSvc.ReqDeliverTorch();
    paramSosoLbsInfo.uint64_torch_id.set(this.jdField_a_of_type_Long);
    paramSosoLbsInfo.msg_lbs_info.set((MessageMicro)localObject);
    paramSosoLbsInfo.uint32_user_share.set(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_ArrayOfByte != null) {
      paramSosoLbsInfo.bytes_sig.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ArrayOfByte));
    }
    localObject = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicHandler.a.a(), "OlympicTorchSvc.ReqDeliverTorch");
    ((ToServiceMsg)localObject).putWupBuffer(paramSosoLbsInfo.toByteArray());
    this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicHandler.b((ToServiceMsg)localObject);
    long l = this.jdField_a_of_type_Long;
    paramInt = this.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_ArrayOfByte == null) {}
    for (paramSosoLbsInfo = "null";; paramSosoLbsInfo = this.jdField_a_of_type_ArrayOfByte)
    {
      OlympicUtil.b("OlympicHandler", new Object[] { "onDeliverTorch, onLocationFinish, sendPbReq, torchid=", Long.valueOf(l), ", usershare=", Integer.valueOf(paramInt), ", sig=", paramSosoLbsInfo });
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tqw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */