import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.freshnews.FreshNewsFeedAdapter;
import com.tencent.mobileqq.freshnews.FreshNewsHandler;
import com.tencent.mobileqq.freshnews.FreshNewsInfo;
import com.tencent.mobileqq.freshnews.FreshNewsManager;
import com.tencent.mobileqq.freshnews.FreshNewsUtil;
import com.tencent.mobileqq.freshnews.data.FNBaseItemData;
import com.tencent.mobileqq.freshnews.data.FNDefaultItemData;
import com.tencent.mobileqq.freshnews.topic.NearbyTopicFeedActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.flat.canvas.AbstractUIElement;
import com.tencent.mobileqq.nearby.flat.canvas.AbstractUIElement.OnClickListener;
import com.tencent.qphone.base.util.QLog;

public class sqc
  implements View.OnClickListener, AbstractUIElement.OnClickListener
{
  public sqc(FreshNewsFeedAdapter paramFreshNewsFeedAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AbstractUIElement paramAbstractUIElement)
  {
    int j = -1;
    int i = j;
    if (paramAbstractUIElement.a(-1) != null)
    {
      localObject = paramAbstractUIElement.a(-1);
      i = j;
      if ((localObject instanceof Integer)) {
        i = ((Integer)localObject).intValue();
      }
    }
    Object localObject = this.a.a(i);
    if ((localObject == null) || (!(localObject instanceof FNDefaultItemData))) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby.freshNews", 2, "defaultItemOnClickLis, itemData =" + localObject + ",pos =" + i);
      }
    }
    do
    {
      do
      {
        return;
        localObject = (FNDefaultItemData)localObject;
        switch (paramAbstractUIElement.a())
        {
        default: 
          return;
        case 2131297019: 
          paramAbstractUIElement = ((FNDefaultItemData)localObject).jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo;
          if ((paramAbstractUIElement == null) && (QLog.isColorLevel())) {
            QLog.d("Q.nearby.freshNews", 2, "defaultItem click head|feed info is null");
          }
          FreshNewsUtil.a((NearbyAppInterface)this.a.jdField_a_of_type_ComTencentCommonAppAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramAbstractUIElement);
          this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.a("CliOper", "", "", "0X8005777", "0X8005777", 0, 0, "", "", "", "");
        }
      } while (((FNDefaultItemData)localObject).jdField_e_of_type_Int <= 0);
      this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.a("CliOper", "", "", "0X8005DED", "0X8005DED", ((FNDefaultItemData)localObject).jdField_e_of_type_Int, 0, "", "", "", "");
      return;
    } while ((!((FNDefaultItemData)localObject).jdField_e_of_type_Boolean) || (((FNDefaultItemData)localObject).jdField_a_of_type_ComTencentMobileqqFreshnewsTopicTopicInfo == null) || ((this.a.b != 0) && (this.a.b != 1)));
    NearbyTopicFeedActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ((FNDefaultItemData)localObject).jdField_a_of_type_ComTencentMobileqqFreshnewsTopicTopicInfo);
    this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.a("CliOper", "0X8005A1B");
    return;
    FreshNewsFeedAdapter.a(this.a, paramAbstractUIElement, (FNDefaultItemData)localObject, 0);
    return;
    FreshNewsFeedAdapter.a(this.a, paramAbstractUIElement, (FNDefaultItemData)localObject, 1);
    return;
    FreshNewsFeedAdapter.a(this.a, paramAbstractUIElement, (FNDefaultItemData)localObject, 2);
  }
  
  public void onClick(View paramView)
  {
    int j = -1;
    int i = j;
    if (paramView.getTag(-1) != null)
    {
      localObject1 = paramView.getTag(-1);
      i = j;
      if ((localObject1 instanceof Integer)) {
        i = ((Integer)localObject1).intValue();
      }
    }
    Object localObject1 = this.a.a(i);
    if (localObject1 == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby.freshNews", 2, "defaultItemOnClickLis, itemData is null|pos =" + i);
      }
    }
    label296:
    do
    {
      do
      {
        do
        {
          boolean bool;
          do
          {
            do
            {
              return;
              if ((localObject1 instanceof FNDefaultItemData)) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.d("Q.nearby.freshNews", 2, "defaultItemOnClickLis, itemData wrong type ,pos =" + i + ",class = " + localObject1.getClass().getName());
            return;
            localObject1 = (FNDefaultItemData)localObject1;
            switch (paramView.getId())
            {
            default: 
              return;
            case 2131296515: 
              localObject2 = (FreshNewsManager)this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(211);
              paramView = ((FNDefaultItemData)localObject1).jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo;
              bool = ((FNDefaultItemData)localObject1).jdField_e_of_type_Boolean;
              if (paramView != null) {
                break label296;
              }
            }
          } while (!QLog.isColorLevel());
          QLog.d("Q.nearby.freshNews", 2, "click content feedinfo is null, feedId is" + ((FNDefaultItemData)localObject1).jdField_e_of_type_JavaLangString);
          return;
          if (((FNDefaultItemData)localObject1).jdField_a_of_type_Int == 1)
          {
            ((FreshNewsManager)localObject2).jdField_e_of_type_Boolean = true;
            localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
            if (bool) {}
            for (i = 4;; i = 0)
            {
              FreshNewsUtil.a((Context)localObject1, paramView, i);
              this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.a("CliOper", "", "", "0X8005778", "0X8005778", 0, 0, "", "", "", "");
              if (paramView.commonId <= 0) {
                break;
              }
              this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.a("CliOper", "", "", "0X8005DEE", "0X8005DEE", paramView.commonId, 0, "", "", "", "");
              return;
            }
          }
        } while (((FNDefaultItemData)localObject1).jdField_a_of_type_Int != 3);
        ((FNDefaultItemData)localObject1).jdField_a_of_type_Int = 2;
        paramView.publishState = 2;
        ((FreshNewsManager)localObject2).a(paramView);
        this.a.a((FNBaseItemData)localObject1);
        this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.a("CliOper", "", "", "0X800577B", "0X800577B", 0, 0, "", "", "", "");
        return;
        if ((((FNDefaultItemData)localObject1).b) && (((FNDefaultItemData)localObject1).jdField_a_of_type_Int == 1))
        {
          this.a.b((FNBaseItemData)localObject1);
          this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.a("CliOper", "", "", "0X800577C", "0X800577C", 0, 0, "", "", "", "");
          return;
        }
        FreshNewsFeedAdapter.a(this.a, (FNBaseItemData)localObject1);
        return;
        this.a.b((FNBaseItemData)localObject1);
        this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.a("CliOper", "", "", "0X800577C", "0X800577C", 0, 0, "", "", "", "");
        return;
        if ((((FNDefaultItemData)localObject1).jdField_a_of_type_Int == 1) && (!TextUtils.isEmpty(((FNDefaultItemData)localObject1).jdField_e_of_type_JavaLangString))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.nearby.freshNews", 2, "praise fail|publishState:" + ((FNDefaultItemData)localObject1).jdField_a_of_type_Int + ",feedId:" + ((FNDefaultItemData)localObject1).jdField_e_of_type_JavaLangString);
      return;
      Object localObject2 = (FreshNewsHandler)this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.a(1);
      FreshNewsManager localFreshNewsManager = (FreshNewsManager)this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(211);
      if (((FNDefaultItemData)localObject1).f)
      {
        ((FreshNewsHandler)localObject2).a(((FNDefaultItemData)localObject1).jdField_e_of_type_JavaLangString, false);
        ((FNDefaultItemData)localObject1).f = false;
        ((FNDefaultItemData)localObject1).g -= 1;
        if (((FNDefaultItemData)localObject1).g < 0) {
          ((FNDefaultItemData)localObject1).g = 0;
        }
        localFreshNewsManager.a(((FNDefaultItemData)localObject1).jdField_e_of_type_JavaLangString, ((FNDefaultItemData)localObject1).g);
        localFreshNewsManager.a(((FNDefaultItemData)localObject1).jdField_e_of_type_JavaLangString, ((FNDefaultItemData)localObject1).f);
        this.a.a((FNBaseItemData)localObject1);
      }
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.a("CliOper", "", "", "0X8005779", "0X8005779", 0, 0, "", "", "", "");
        return;
        ((FreshNewsHandler)localObject2).a(((FNDefaultItemData)localObject1).jdField_e_of_type_JavaLangString, true);
        ((FNDefaultItemData)localObject1).f = true;
        ((FNDefaultItemData)localObject1).g += 1;
        localFreshNewsManager.a(((FNDefaultItemData)localObject1).jdField_e_of_type_JavaLangString, ((FNDefaultItemData)localObject1).g);
        localFreshNewsManager.a(((FNDefaultItemData)localObject1).jdField_e_of_type_JavaLangString, ((FNDefaultItemData)localObject1).f);
        this.a.a((FNBaseItemData)localObject1);
        FreshNewsFeedAdapter.a(this.a, paramView, (FNBaseItemData)localObject1);
      }
    } while (((FNDefaultItemData)localObject1).jdField_a_of_type_Int != 1);
    this.a.a(i, (FNDefaultItemData)localObject1);
    return;
    ThreadManager.a(new sqd(this, (FNDefaultItemData)localObject1), 10, null, false);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sqc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */