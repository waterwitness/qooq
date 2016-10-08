import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vas.VasExtensionObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.Calendar;

public class prh
  extends VasExtensionObserver
{
  public prh(ApolloGuestsStateActivity paramApolloGuestsStateActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void c(boolean paramBoolean, Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGuestsStateActivity", 2, "set zanCount = " + paramObject);
        }
        if (!paramBoolean) {
          break;
        }
        try
        {
          this.a.a(((Integer)paramObject).intValue());
          paramObject = ApolloGuestsStateActivity.a(this.a).getSharedPreferences("cmshow_zan", 0);
          localCalendar = Calendar.getInstance();
          ((SharedPreferences)paramObject).edit().putBoolean(ApolloGuestsStateActivity.a(this.a).a() + "apollo_today_has_vote" + this.a.g + localCalendar.get(1) + localCalendar.get(2) + localCalendar.get(5), true).commit();
          paramObject = (TextView)this.a.jdField_a_of_type_AndroidViewView.findViewById(2131297069);
          ((TextView)paramObject).setText("+1");
          ((TextView)paramObject).setVisibility(0);
          ((TextView)paramObject).startAnimation(AnimationUtils.loadAnimation(this.a, 2130968597));
          return;
        }
        catch (Exception paramObject) {}
      } while (!QLog.isColorLevel());
      QLog.e("ApolloGuestsStateActivity", 2, "set zanCount error= " + ((Exception)paramObject).toString());
      return;
    } while (((Long)paramObject).longValue() != -501010L);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGuestsStateActivity", 2, "today has vote to " + this.a.g);
    }
    paramObject = ApolloGuestsStateActivity.b(this.a).getSharedPreferences("cmshow_zan", 0);
    Calendar localCalendar = Calendar.getInstance();
    ((SharedPreferences)paramObject).edit().putBoolean(ApolloGuestsStateActivity.b(this.a).a() + "apollo_today_has_vote" + this.a.g + localCalendar.get(1) + localCalendar.get(2) + localCalendar.get(5), true).commit();
  }
  
  protected void d(boolean paramBoolean, Object paramObject)
  {
    if ((!paramBoolean) || (paramObject == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGuestsStateActivity", 2, "get zanCount = " + paramObject);
    }
    SharedPreferences localSharedPreferences = ApolloGuestsStateActivity.c(this.a).getSharedPreferences("cmshow_zan", 0);
    if (((Integer)paramObject).intValue() <= 999)
    {
      if (this.a.jdField_a_of_type_Boolean) {
        this.a.a(this.a.l, ((Integer)paramObject).intValue());
      }
      for (;;)
      {
        this.a.l = ((Integer)paramObject).intValue();
        localSharedPreferences.edit().putInt("apollo_zan_count" + this.a.g, ((Integer)paramObject).intValue()).commit();
        return;
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText("" + (Integer)paramObject);
      }
    }
    if (this.a.jdField_a_of_type_Boolean) {
      this.a.a(this.a.l, 999);
    }
    for (;;)
    {
      this.a.l = 999;
      break;
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText("999");
    }
  }
  
  protected void e(boolean paramBoolean, Object paramObject)
  {
    if (ApolloGuestsStateActivity.c(this.a) == null) {}
    do
    {
      do
      {
        return;
        if (this.a.c != null) {
          this.a.c.setVisibility(8);
        }
      } while ((paramObject == null) || (!paramBoolean));
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGuestsStateActivity", 2, "myCmshow open response status=" + paramObject.toString());
      }
    } while ((((Integer)((Pair)paramObject).second).intValue() != 1) || (this.a.jdField_a_of_type_AndroidWidgetButton == null));
    this.a.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
    this.a.jdField_a_of_type_AndroidWidgetButton.setText("邀请好友送花");
  }
  
  protected void f(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (QLog.isColorLevel()))
    {
      QLog.d("ApolloGuestsStateActivity", 2, "ApolloDressChange uin=" + paramObject);
      if (this.a.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderInterfaceImpl != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderInterfaceImpl.g();
      }
      this.a.b();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\prh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */