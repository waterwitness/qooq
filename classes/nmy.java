import android.os.IBinder;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.troop.utils.TroopTopicMgr;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class nmy
  implements IAIOImageProviderCallBack
{
  public nmy(PicItemBuilder paramPicItemBuilder, AIOImageData paramAIOImageData, MessageForPic paramMessageForPic)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean) {}
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    if ((paramLong == this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.f) && (paramInt1 == this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.k) && (1 == paramInt3))
    {
      if (QLog.isColorLevel()) {
        QLog.i("zivonchen", 2, "downloadImage id = " + paramLong + ", subId = " + paramInt1 + ", type = " + paramInt2 + ", result = " + paramInt3 + ", resultStr = " + paramString + ", isPart = " + paramBoolean);
      }
      TroopTopicMgr localTroopTopicMgr = (TroopTopicMgr)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPicItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(97);
      if ((localTroopTopicMgr != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPicItemBuilder.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)))
      {
        TroopBarUtils.a.clear();
        localTroopTopicMgr.a(((FragmentActivity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPicItemBuilder.jdField_a_of_type_AndroidContentContext).getChatFragment().a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPicItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, paramString, 4);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPicItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_talk", "", "pub_talk", "Clk_bubble", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPicItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "2", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("IAIOImageProviderCallBack", 2, "image has new downloaded!");
        }
      }
    }
  }
  
  public void a(AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt) {}
  
  public IBinder asBinder()
  {
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nmy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */