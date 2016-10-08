import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.widget.QQProgressDialog;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

public final class vyz
  implements Runnable
{
  public vyz(int paramInt, String paramString1, BaseActivity paramBaseActivity, String paramString2, QQProgressDialog paramQQProgressDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    for (;;)
    {
      int i;
      int j;
      Object localObject3;
      StringBuilder localStringBuilder;
      MessageRecord localMessageRecord;
      Object localObject4;
      try
      {
        int k;
        if (this.jdField_a_of_type_Int == 1102)
        {
          i = 20;
          j = 1;
          if (((this.jdField_a_of_type_Int != 1101) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) && (this.jdField_a_of_type_Int != 10000)) {
            continue;
          }
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().a(this.jdField_a_of_type_JavaLangString, 1, 100);
          if (localObject3 != null)
          {
            localObject1 = localObject3;
            if (!((List)localObject3).isEmpty()) {}
          }
          else
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().a(this.jdField_a_of_type_JavaLangString, 3000, 100);
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("chatmsg:");
          Iterator localIterator = ((List)localObject1).iterator();
          k = 0;
          if (localIterator.hasNext())
          {
            localMessageRecord = (MessageRecord)localIterator.next();
            if (k <= i) {
              continue;
            }
          }
          localObject3 = URLEncoder.encode(localStringBuilder.toString(), "UTF-8");
          localObject1 = "";
        }
        switch (this.jdField_a_of_type_Int)
        {
        default: 
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("system=android");
          ((StringBuilder)localObject4).append("&");
          ((StringBuilder)localObject4).append("version=" + Build.VERSION.RELEASE);
          ((StringBuilder)localObject4).append("&");
          ((StringBuilder)localObject4).append("uintype=1");
          ((StringBuilder)localObject4).append("&");
          ((StringBuilder)localObject4).append("eviluin=" + this.b);
          ((StringBuilder)localObject4).append("&");
          ((StringBuilder)localObject4).append("appname=KQQ");
          ((StringBuilder)localObject4).append("&");
          ((StringBuilder)localObject4).append("appid=2400002");
          ((StringBuilder)localObject4).append("&");
          ((StringBuilder)localObject4).append("subapp=" + (String)localObject1);
          ((StringBuilder)localObject4).append("&");
          if (this.jdField_a_of_type_Int != 10000) {
            break label1044;
          }
          ((StringBuilder)localObject4).append("scene=1105");
          ((StringBuilder)localObject4).append("&");
          ((StringBuilder)localObject4).append("srv_para=" + (String)localObject3);
          if (this.jdField_a_of_type_Int != 1101) {
            break label1074;
          }
          if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
            ((StringBuilder)localObject4).append("|groupid:" + this.jdField_a_of_type_JavaLangString);
          }
          localObject1 = ((StringBuilder)localObject4).toString();
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new vza(this, (String)localObject1));
          return;
          if (this.jdField_a_of_type_Int == 1107)
          {
            i = 20;
            j = 3000;
            continue;
          }
          if (this.jdField_a_of_type_Int != 10000) {
            break label1121;
          }
          i = 20;
          j = 1;
          continue;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().a(this.b, j, 50);
          continue;
          if ((localMessageRecord == null) || ((this.jdField_a_of_type_Int == 1101) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.equals(localMessageRecord.senderuin, this.b))) || ((this.jdField_a_of_type_Int == 10000) && (!TextUtils.equals(localMessageRecord.senderuin, this.b)))) {
            continue;
          }
          if ((localMessageRecord instanceof MessageForPic))
          {
            localObject1 = (MessageForPic)localMessageRecord;
            ((MessageForPic)localObject1).parse();
            localObject3 = ((MessageForPic)localObject1).uuid;
            localObject4 = "2";
            j = 0;
            k += 1;
            localObject1 = localObject3;
            if (j == 0) {
              localObject1 = localObject3;
            }
          }
          break;
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new vzb(this, localException));
        return;
      }
      Object localObject2;
      try
      {
        localObject3 = ((String)localObject3).replace("\"", "\\\"");
        localObject1 = localObject3;
        localObject3 = ((String)localObject3).replace("'", "\\'");
        localObject1 = localObject3;
        localObject3 = ((String)localObject3).replace("|", "\\|");
        localObject1 = localObject3;
        localObject3 = ((String)localObject3).replace(":", "\\:");
        localObject1 = localObject3;
        localObject3 = ((String)localObject3).replace(";", "\\;");
        localObject1 = localObject3;
        localObject3 = ((String)localObject3).replace("[", "\\[");
        localObject1 = localObject3;
        localObject3 = ((String)localObject3).replace("]", "\\]");
        localObject1 = localObject3;
        localObject3 = ((String)localObject3).replace("=", "\\=");
        localObject1 = localObject3;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        continue;
        localStringBuilder.append("uin=" + localMessageRecord.senderuin);
        continue;
      }
      localStringBuilder.append("[");
      if ((this.jdField_a_of_type_Int == 1101) && (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
      {
        localStringBuilder.append("uin=" + localMessageRecord.frienduin);
        localStringBuilder.append(";");
        localStringBuilder.append("content=" + (String)localObject1);
        localStringBuilder.append(";");
        localStringBuilder.append("type=" + (String)localObject4);
        localStringBuilder.append("]");
        continue;
        if (((localMessageRecord instanceof MessageForText)) || ((localMessageRecord instanceof MessageForLongMsg)))
        {
          if (localMessageRecord.msgtype == 64536)
          {
            localObject3 = localMessageRecord.msg;
            localObject4 = "1";
            j = 0;
          }
        }
        else if ((localMessageRecord instanceof MessageForStructing))
        {
          localObject2 = ((MessageForStructing)localMessageRecord).structingMsg;
          if (localObject2 != null)
          {
            localObject3 = ((AbsStructMsg)localObject2).getXml();
            localObject4 = "3";
            j = 1;
          }
        }
      }
      else
      {
        label1044:
        ((StringBuilder)localObject4).append("scene=" + this.jdField_a_of_type_Int);
        continue;
        label1074:
        if (this.jdField_a_of_type_Int == 10000)
        {
          ((StringBuilder)localObject4).append("|groupid:" + this.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject4).append("|SubEntrence:4");
          continue;
          label1121:
          i = 10;
          j = 0;
          continue;
          continue;
          localObject2 = "c2c";
          continue;
          localObject2 = "group";
          continue;
          localObject2 = "discuss";
          continue;
          localObject2 = "nearby";
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vyz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */