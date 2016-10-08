import com.tencent.mobileqq.activity.aio.item.TroopRewardItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.troop.utils.TroopRewardMgr;
import com.tencent.mobileqq.utils.HexUtil;
import java.io.File;

public class nru
  implements Runnable
{
  public nru(TroopRewardItemBuilder paramTroopRewardItemBuilder, MessageForTroopReward paramMessageForTroopReward, nse paramnse, String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    File localFile = new File(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward.mediaPath);
    if (!localFile.exists()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward.title = localFile.getName();
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward.sha = HexUtil.a(FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward.mediaPath)).toLowerCase();
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward.md5 = HexUtil.a(FileManagerUtil.c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward.mediaPath)).toLowerCase();
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward.videoSize = localFile.length();
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward.videoDuration = ((int)(ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward.mediaPath) / 1000L));
    ((TroopRewardMgr)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder.a.getManager(151)).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward, new nrv(this));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nru.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */