import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;

public class wyf
  extends SosoInterface.OnLocationListener
{
  public wyf(QidianManager paramQidianManager, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    super(paramInt1, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString1);
    paramBoolean1 = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    double d2 = 0.0D;
    if (QLog.isColorLevel()) {
      QLog.d(QidianManager.jdField_a_of_type_JavaLangString, 2, "onLocationFinish(): BEGIN errCode=" + paramInt);
    }
    String str;
    double d1;
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null)) {
      if (paramSosoLbsInfo.a.jdField_b_of_type_JavaLangString != null)
      {
        str = paramSosoLbsInfo.a.jdField_b_of_type_JavaLangString;
        if (QLog.isColorLevel()) {
          QLog.d(QidianManager.jdField_a_of_type_JavaLangString, 2, "onLocationFinish() latitude=" + paramSosoLbsInfo.a.a + ", longitude=" + paramSosoLbsInfo.a.jdField_b_of_type_Double + ", address=" + str);
        }
        d1 = paramSosoLbsInfo.a.a;
        d2 = paramSosoLbsInfo.a.jdField_b_of_type_Double;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentQidianQidianManager.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, true, d1, d2, this.d);
      return;
      str = "";
      break;
      d1 = 0.0D;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wyf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */