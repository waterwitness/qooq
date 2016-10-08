import android.os.Message;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.view.ProfileBaseView;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.troop.utils.HummerParser;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.nio.ByteBuffer;

public class llp
  extends TransProcessorHandler
{
  public llp(FriendProfileCardActivity paramFriendProfileCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject = (FileMsg)paramMessage.obj;
    if (((FileMsg)localObject).e == 35) {}
    switch (paramMessage.what)
    {
    default: 
    case 1003: 
      int j;
      do
      {
        do
        {
          return;
          this.a.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacks(this.a.jdField_b_of_type_JavaLangRunnable);
          this.a.x();
          this.a.a("上传成功", 2);
          paramMessage = ((FileMsg)localObject).a;
          if (paramMessage == null) {
            break label451;
          }
          localObject = ByteBuffer.wrap(paramMessage);
          j = ((ByteBuffer)localObject).get();
          if (j == 0) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("FriendProfileCardActivity", 2, "error retCode:" + j);
        return;
        byte[] arrayOfByte1 = new byte[4];
        byte[] arrayOfByte2 = new byte[4];
        j = 0;
        while (j < 4)
        {
          int i = ((ByteBuffer)localObject).get();
          arrayOfByte1[j] = i;
          arrayOfByte2[(3 - j)] = i;
          j += 1;
        }
        k = (int)HummerParser.a(arrayOfByte1);
        if (k <= paramMessage.length - 5)
        {
          j = k;
          if (k >= 0) {}
        }
        else
        {
          j = (int)HummerParser.a(arrayOfByte2);
        }
        if (QLog.isColorLevel()) {
          QLog.d("FriendProfileCardActivity", 2, "len:" + j + " bLength:" + HexUtil.a(arrayOfByte1) + " bFlipLength:" + HexUtil.a(arrayOfByte2));
        }
        if ((j <= paramMessage.length - 5) && (j >= 0)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("FriendProfileCardActivity", 2, "长度超出! len:" + j + " extraInfo.length:" + paramMessage.length);
      return;
      localObject = new byte[j];
      int k = 0;
      while (k < j)
      {
        localObject[k] = paramMessage[(k + 5)];
        k += 1;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.checkCoverUrl((byte[])localObject)) {
        this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.vCoverInfo = ((byte[])localObject);
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView)) {
        ((ProfileBaseView)this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView).a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, false);
      }
      ThreadManager.a(new llq(this), 5, null, false);
      return;
      label451:
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileCardActivity", 2, "send finish extraInfo is null");
      }
      FriendProfileCardActivity.a(this.a, 0L, null, null, false);
      return;
    }
    this.a.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacks(this.a.jdField_b_of_type_JavaLangRunnable);
    this.a.x();
    this.a.a("上传失败", 1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\llp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */