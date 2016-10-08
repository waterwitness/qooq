import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class tii
  extends MessageObserver
{
  public tii(NearbyProxy paramNearbyProxy)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramInt != 1) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(NearbyProxy.jdField_a_of_type_JavaLangString, 2, "onRemoveFromBlackList from nearby");
    }
    if (paramBoolean)
    {
      ShieldMsgManger localShieldMsgManger = (ShieldMsgManger)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(paramString));
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.a.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
      localShieldMsgManger.b(1001, localArrayList, 1);
      return;
    }
    NearbyProxy.a(this.a, 4118, new Object[] { Boolean.valueOf(false) });
  }
  
  protected void a(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (((Integer)paramArrayOfObject[0]).intValue() != 1) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(NearbyProxy.jdField_a_of_type_JavaLangString, 2, "onInsertIntoBlackList from nearby");
    }
    if ((paramBoolean) && (paramArrayOfObject.length == 4))
    {
      ((Long)paramArrayOfObject[1]).longValue();
      String str = (String)paramArrayOfObject[2];
      int i = ((Integer)paramArrayOfObject[3]).intValue();
      NearbySPUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "blacklist_sequence", Integer.valueOf(i));
      paramArrayOfObject = new ArrayList();
      paramArrayOfObject.add(Long.valueOf(str));
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.a.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
      ((ShieldMsgManger)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15)).a(1001, paramArrayOfObject, 1);
      return;
    }
    NearbyProxy.a(this.a, 4117, new Object[] { Boolean.valueOf(false) });
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tii.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */