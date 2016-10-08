import android.os.Bundle;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import java.nio.ByteBuffer;
import mqq.os.MqqHandler;

class ujp
  implements Runnable
{
  ujp(ujo paramujo, boolean paramBoolean, Bundle paramBundle)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject3 = (FriendsManager)StatusManager.a(this.jdField_a_of_type_Ujo.a).getManager(50);
    Object localObject2;
    Object localObject1;
    int i;
    if (localObject3 != null)
    {
      localObject2 = ((FriendsManager)localObject3).a(StatusManager.a(this.jdField_a_of_type_Ujo.a).a());
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ExtensionInfo();
        ((ExtensionInfo)localObject1).uin = StatusManager.a(this.jdField_a_of_type_Ujo.a).a();
      }
      if (this.jdField_a_of_type_Boolean)
      {
        localObject2 = this.jdField_a_of_type_AndroidOsBundle.getByteArray("k_rspbody");
        if (localObject2 != null)
        {
          localObject2 = ByteBuffer.wrap((byte[])localObject2);
          ((ByteBuffer)localObject2).get();
          i = ((ByteBuffer)localObject2).getInt();
          byte[] arrayOfByte = new byte[((ByteBuffer)localObject2).getShort()];
          ((ByteBuffer)localObject2).get(arrayOfByte);
          if (((ExtensionInfo)localObject1).timestamp != i)
          {
            ((ExtensionInfo)localObject1).setRichBuffer(arrayOfByte, i);
            ((FriendsManager)localObject3).a((ExtensionInfo)localObject1);
          }
        }
      }
      localObject2 = ((ExtensionInfo)localObject1).getRichStatus();
      if (this.jdField_a_of_type_Boolean)
      {
        localObject3 = StatusManager.a(this.jdField_a_of_type_Ujo.a);
        if (((RichStatus)localObject2).tplId != 0) {
          break label280;
        }
        localObject1 = "1";
        ReportController.b((QQAppInterface)localObject3, "CliOper", "", "", "signiture", "set_clk_save_succ", 0, 0, (String)localObject1, "", "", "");
      }
    }
    for (;;)
    {
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidOsBundle != null))
      {
        i = this.jdField_a_of_type_AndroidOsBundle.getInt("k_auth_code", -1);
        if (i == -210011) {
          localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("k_act_url");
        }
      }
      for (;;)
      {
        StatusManager.a(this.jdField_a_of_type_Ujo.a, null);
        ThreadManager.c().post(new ujq(this, i, (RichStatus)localObject2, (String)localObject1));
        return;
        label280:
        localObject1 = "0";
        break;
        localObject1 = null;
        continue;
        i = 100;
        localObject1 = null;
      }
      localObject2 = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ujp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */