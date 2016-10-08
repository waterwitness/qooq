import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x5RspBQRecommend;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class tev
  implements Runnable
{
  public tev(EmoticonManager paramEmoticonManager, EmosmPb.SubCmd0x5RspBQRecommend paramSubCmd0x5RspBQRecommend)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentPbEmosmEmosmPb$SubCmd0x5RspBQRecommend == null) {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManager", 2, "recommendresp is null");
      }
    }
    List localList;
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.jdField_a_of_type_ComTencentPbEmosmEmosmPb$SubCmd0x5RspBQRecommend = this.jdField_a_of_type_ComTencentPbEmosmEmosmPb$SubCmd0x5RspBQRecommend;
      int i = this.jdField_a_of_type_ComTencentPbEmosmEmosmPb$SubCmd0x5RspBQRecommend.int32_exposure_num.get();
      if (i > 0) {
        EmoticonManager.d = i;
      }
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManager", 2, "saveAndUpdateRecommendEmosInfo maxexposenum = " + EmoticonManager.d);
      }
      localList = this.jdField_a_of_type_ComTencentPbEmosmEmosmPb$SubCmd0x5RspBQRecommend.st_new_tab_info.get();
    } while ((localList == null) || (!QLog.isColorLevel()));
    QLog.d("EmoticonManager", 2, "saveAndUpdateRecommendEmosInfo recommend emotion num = " + localList.size());
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tev.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */