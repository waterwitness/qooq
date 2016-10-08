import android.content.ContentValues;
import android.text.TextUtils;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qne
  implements Runnable
{
  public qne(DataLineMsgProxy paramDataLineMsgProxy, long paramLong, String paramString, byte[] paramArrayOfByte)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    DataLineMsgRecord localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy.a(this.jdField_a_of_type_Long);
    ContentValues localContentValues = new ContentValues();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      localContentValues.put("serverPath", this.jdField_a_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length > 0)) {
      localContentValues.put("md5", this.jdField_a_of_type_ArrayOfByte);
    }
    if (localDataLineMsgRecord != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy.a(this.jdField_a_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy.jdField_a_of_type_JavaLangString, localContentValues, "msgId=?", new String[] { String.valueOf(localDataLineMsgRecord.msgId) }, null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qne.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */