import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonTabAdapter;
import com.tencent.mobileqq.emoticonview.EmoticonTabAdapter.EmoticonTabItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.qphone.base.util.QLog;

public class rkn
  implements Runnable
{
  public rkn(EmoticonTabAdapter paramEmoticonTabAdapter, EmoticonTabAdapter.EmoticonTabItem paramEmoticonTabItem)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.w("EmoticonTabAdapter", 2, "package lossY");
    }
    EmoticonManager localEmoticonManager = (EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonTabAdapter.a.getManager(13);
    EmoticonPackage localEmoticonPackage = localEmoticonManager.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonTabAdapter$EmoticonTabItem.a);
    if (localEmoticonPackage != null)
    {
      localEmoticonPackage.status = 0;
      localEmoticonManager.a(localEmoticonPackage);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rkn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */