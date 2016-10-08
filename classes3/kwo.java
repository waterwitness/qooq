import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

public class kwo
  extends TroopObserver
{
  public kwo(ChatHistoryFileActivity paramChatHistoryFileActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    int i = 1;
    this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
    {
      HashMap localHashMap = new HashMap();
      if ((!paramBoolean) && ((paramObject instanceof Integer))) {
        i = ((Integer)paramObject).intValue();
      }
      for (;;)
      {
        localHashMap.put("result", i + "");
        localHashMap.put("netType", NetworkUtil.a(BaseApplication.getContext()) + "");
        StatisticCollector.a(BaseApplication.getContext()).a(this.a.app.a(), "multiMsgNickTimeoutR", false, 30000L, 0L, localHashMap, "");
        return;
        if (paramBoolean) {
          i = 0;
        }
      }
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    MultiMsgManager.a().b.clear();
    if ((paramBoolean) && (paramObject != null))
    {
      MultiMsgManager.a().b.putAll((Map)paramObject);
      if (QLog.isDevelopLevel()) {
        QLog.d("MultiMsg", 4, "onBatchTroopCardDefaultNick = " + paramObject);
      }
    }
    while (MultiMsgManager.a().b.size() == 0)
    {
      QQToast.a(this.a, 2131367671, 0).b(this.a.getTitleBarHeight());
      return;
      if (QLog.isDevelopLevel()) {
        QLog.d("MultiMsg", 4, "onBatchTroopCardDefaultNick failed");
      }
    }
    this.a.a((Map)paramObject, MultiMsgManager.a().a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kwo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */