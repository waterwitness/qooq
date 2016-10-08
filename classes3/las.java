import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.StackBlur;
import com.tencent.qphone.base.util.QLog;

public class las
  implements Runnable
{
  public las(ChatSettingForTroop paramChatSettingForTroop)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    for (Object localObject1 = null;; localObject1 = ((TroopMemberCardInfo)localObject2).name) {
      for (;;)
      {
        try
        {
          localObject2 = DBUtils.a().a(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.a.app.a());
          if (localObject2 == null)
          {
            localObject2 = DBUtils.a().a(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.a.app.a());
            if (localObject2 != null) {
              localObject1 = ((TroopMemberInfo)localObject2).troopnick;
            }
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCard = ((String)localObject1);
              this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
            }
            this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nUnreadMsgNum = DBUtils.a(this.a.app.a(), "troop_photo_message", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
            this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nNewPhotoNum = DBUtils.a(this.a.app.a(), "troop_photo_new", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
            this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
            if (QLog.isColorLevel()) {
              QLog.i("Q.chatopttroop", 2, "初始化，群空间未读计数， troopuin = " + this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin + ", unreadmsgnum = " + this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nUnreadMsgNum + ", newphotonum = " + this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nNewPhotoNum);
            }
            if (QLog.isColorLevel()) {
              QLog.i("Q.chatopttroop", 2, "init(),getTroopMemberCard,getMutiTroopInfo,refreshTroopFace");
            }
            this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nNewFileMsgNum = DBUtils.a(this.a.app.a(), "troop_file_new", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
            this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nUnreadFileMsgnum = 0;
            this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
            this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mNewTroopNotificationNum = DBUtils.a(this.a.app.a(), "troop_notification_new", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
            this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(9);
            this.a.c();
            this.a.s();
            this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(19);
            this.a.app.c(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          Object localObject2;
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.e("Q.chatopttroop", 4, localNumberFormatException.toString());
          return;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.e("Q.chatopttroop", 4, localIllegalArgumentException.toString());
          return;
        }
        catch (Exception localException)
        {
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.e("Q.chatopttroop", 4, localException.toString());
          return;
        }
        catch (Error localError)
        {
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.e("Q.chatopttroop", 4, localError.toString());
        }
        try
        {
          localObject2 = this.a.app.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, (byte)1, false, false);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = ImageUtil.a();
          }
          localObject1 = ChatSettingForTroop.a(this.a.jdField_a_of_type_AndroidUtilDisplayMetrics, (Bitmap)localObject1);
          if (localObject1 != null)
          {
            StackBlur.a((Bitmap)localObject1, 10);
            localObject1 = new BitmapDrawable((Bitmap)localObject1);
            this.a.runOnUiThread(new lat(this, (BitmapDrawable)localObject1));
          }
          return;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.chatopttroop", 2, "fast blur OOM");
          return;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\las.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */