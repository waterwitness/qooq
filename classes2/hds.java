import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.bitapp.BitAppBaseViewCache.BitAppGetViewListener;
import com.tencent.bitapp.BitAppMsgItemBuilder;
import com.tencent.bitapp.BitAppViewGroup;
import com.tencent.bitapp.MessageForBitApp;
import com.tencent.bitapp.pre.PreConst;
import com.tencent.bitapp.view.BitAppBaseView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class hds
  extends BitAppBaseViewCache.BitAppGetViewListener
{
  public hds(BitAppViewGroup paramBitAppViewGroup)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    BitAppViewGroup.a(this.a, this.a.getContext());
  }
  
  public void a(String paramString, int paramInt)
  {
    super.a(paramString, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("BitAppViewGroup", 4, "loadBitAppView ... onLoadFail - msg: " + this.a.jdField_a_of_type_ComTencentBitappMessageForBitApp);
    }
    this.a.jdField_a_of_type_ComTencentBitappBitAppMsgItemBuilder.a(paramString);
    if (TextUtils.equals(paramString, String.valueOf(this.a.jdField_a_of_type_ComTencentBitappMessageForBitApp.uniseq)))
    {
      this.a.b();
      this.a.k();
    }
  }
  
  public void a(String paramString, BitAppBaseView paramBitAppBaseView)
  {
    super.a(paramString, paramBitAppBaseView);
    if ((PreConst.isTestPerformance) && (QLog.isColorLevel())) {
      QLog.d("BitAppViewGroup", 4, "loadBitAppView ... onLoadSuccess - msg: " + this.a.jdField_a_of_type_ComTencentBitappMessageForBitApp);
    }
    paramString = "";
    paramBitAppBaseView = paramBitAppBaseView.getExtra();
    if (paramBitAppBaseView != null) {
      paramString = paramBitAppBaseView.getString("msgid");
    }
    if (TextUtils.equals(String.valueOf(this.a.jdField_a_of_type_ComTencentBitappMessageForBitApp.uniseq), paramString)) {
      this.a.i();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\hds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */