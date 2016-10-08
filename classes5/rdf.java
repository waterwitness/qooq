import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.data.DatingConfig;
import com.tencent.mobileqq.dating.DatingDestinationActivity;
import com.tencent.mobileqq.dating.DatingManager;
import com.tencent.mobileqq.dating.DatingObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.List;

public class rdf
  extends DatingObserver
{
  public rdf(DatingDestinationActivity paramDatingDestinationActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, DatingConfig paramDatingConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DatingDestinationActivity", 2, "onGetConfig:" + paramBoolean);
    }
    if (paramBoolean)
    {
      paramDatingConfig = ((DatingManager)this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(212)).a();
      this.a.runOnUiThread(new rdg(this, paramDatingConfig));
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DatingDestinationActivity", 2, "onGetHometownAndLocalCode|isSuccess:" + paramBoolean + ",hometownCode:" + paramString1 + ",localCode:" + paramString2);
    }
    if (paramBoolean) {
      if ((TextUtils.isEmpty(this.a.g)) || (!this.a.g.equals(paramString1)))
      {
        this.a.g = paramString1;
        if (!this.a.jdField_h_of_type_Boolean) {
          break label224;
        }
        paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a(this.a.g);
        this.a.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo = this.a.a(paramString1);
        this.a.b();
        this.a.a(this.a.g, paramString1, true);
      }
    }
    for (;;)
    {
      if ((TextUtils.isEmpty(this.a.jdField_h_of_type_JavaLangString)) || (!this.a.jdField_h_of_type_JavaLangString.equals(paramString2)))
      {
        this.a.jdField_h_of_type_JavaLangString = paramString2;
        if (this.a.jdField_h_of_type_Boolean) {
          this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a(this.a.g);
        }
      }
      return;
      label224:
      this.a.j = true;
    }
  }
  
  public void a(boolean paramBoolean1, List paramList1, List paramList2, ByteStringMicro paramByteStringMicro, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (((paramList1 != null) && (paramList1.size() > 0)) || ((paramList2 != null) && (paramList2.size() > 0)))) {
      if (this.a.jdField_a_of_type_Rdt != null)
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro == null)
        {
          this.a.jdField_a_of_type_Rdt = new rdt(this.a);
          this.a.jdField_a_of_type_Rdt.a(paramList1, paramList2);
          this.a.jdField_b_of_type_ComTencentWidgetXListView.setAdapter(this.a.jdField_a_of_type_Rdt);
        }
      }
      else
      {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.a.jdField_b_of_type_ComTencentWidgetXListView.setVisibility(0);
        this.a.jdField_b_of_type_ComTencentMobileqqPbByteStringMicro = this.a.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro;
        this.a.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = paramByteStringMicro;
        this.a.d = paramBoolean2;
        this.a.h();
      }
    }
    for (;;)
    {
      this.a.f = false;
      return;
      this.a.jdField_a_of_type_Rdt.b(paramList1, paramList2);
      break;
      if (this.a.e)
      {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.getString(2131368078));
        this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      else
      {
        this.a.g();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rdf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */