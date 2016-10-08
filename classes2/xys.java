import android.content.Context;
import android.content.Intent;
import com.tencent.av.service.LBSInfo;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.c2b.C2BLBSHelper;
import java.util.Iterator;
import java.util.Vector;
import mqq.util.WeakReference;

public class xys
  extends LBSObserver
{
  private Vector jdField_a_of_type_JavaUtilVector;
  private WeakReference jdField_a_of_type_MqqUtilWeakReference;
  private WeakReference b;
  
  public xys(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilVector = new Vector();
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramContext);
    this.b = new WeakReference(paramQQAppInterface);
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_JavaUtilVector.add(paramIntent);
  }
  
  protected void a(boolean paramBoolean, LBSInfo paramLBSInfo)
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference.get() == null) || (this.b.get() == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d(C2BLBSHelper.jdField_a_of_type_JavaLangString, 2, "onGetUserLocation mContext.get() == null || mApp.get() == null");
      }
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilVector.iterator();
    while (localIterator.hasNext())
    {
      Intent localIntent = (Intent)localIterator.next();
      localIterator.remove();
      C2BLBSHelper.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), localIntent, paramBoolean, paramLBSInfo);
    }
    ((QQAppInterface)this.b.get()).b(C2BLBSHelper.jdField_a_of_type_Xys);
    C2BLBSHelper.jdField_a_of_type_Xys = null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xys.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */