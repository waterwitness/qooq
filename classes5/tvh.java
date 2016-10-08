import QQService.CARDSETTYPE;
import SummaryCardTaf.SSummaryCardSetReq;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.VipProfileCardBaseActivity;

public class tvh
  implements Runnable
{
  public tvh(VipProfileCardBaseActivity paramVipProfileCardBaseActivity, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = new SSummaryCardSetReq(2, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardBaseActivity.app.a()), 0L, "6.5.5", 109L, this.jdField_a_of_type_Long, this.b, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setEncodeName("utf-8");
    localUniPacket.setFuncName("set");
    localUniPacket.setServantName("MCardSvc");
    localUniPacket.put("req", localObject);
    localObject = localUniPacket.encode();
    this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardBaseActivity.a.a(this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardBaseActivity.app.a(), CARDSETTYPE.TYPE_SET_TEMPLATE.value(), (byte)0, null, null, null, null, (byte[])localObject);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tvh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */