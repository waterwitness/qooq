import NearbyGroup.GroupArea;
import NearbyGroup.GroupInfo;
import NearbyGroup.RspActivity;
import NearbyGroup.RspGetAreaList;
import NearbyGroup.RspGetGroupInArea;
import NearbyGroup.RspGetNearbyGroup;
import NearbyGroup.RspTopic;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.NearbyTroopsBaseView.INearbyTroopContext;
import com.tencent.mobileqq.troop.activity.NearbyTroopsView;
import com.tencent.mobileqq.troop.activity.NearbyTroopsView.UIHandler;
import com.tencent.mobileqq.troop.data.GroupAreaWrapper;
import com.tencent.mobileqq.troop.data.NearbyTroopsExpandableListViewAdapter;
import com.tencent.mobileqq.troop.widget.NearbyTroopsExpandableListView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class vet
  extends LBSObserver
{
  public vet(NearbyTroopsView paramNearbyTroopsView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, RspGetNearbyGroup paramRspGetNearbyGroup)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyTroopsActivity.data", 2, "onGetGroups: iFilterId=" + paramInt + ", isFirst=" + paramBoolean2 + ", isSuccess=" + paramBoolean1 + ", mHasCache=" + this.a.h);
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext == null) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.d()))
    {
      break label89;
      break label89;
    }
    label89:
    while ((this.a == null) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter == null)) {
      return;
    }
    if (paramBoolean2) {
      this.a.a(paramBoolean1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("NearbyTroopsActivity", 2, "onGetGroups==>isSuccess:" + paramBoolean1 + "|mHasCache:" + this.a.h + "|iFilterId:" + paramInt);
    }
    if (!paramBoolean1)
    {
      if (this.a.h)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler.sendEmptyMessage(2);
        return;
      }
      if (!this.a.h)
      {
        this.a.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.a.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(null);
        this.a.jdField_f_of_type_AndroidViewView.setVisibility(8);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.jdField_c_of_type_Boolean = false;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.b(2);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.a(true);
        return;
      }
    }
    if (paramRspGetNearbyGroup == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyTroopsActivity", 2, "onGetGroups==>isSuccess:" + paramBoolean1 + "|rsp == null");
      }
      this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler.sendEmptyMessage(2);
      return;
    }
    Object localObject = paramRspGetNearbyGroup.vGroupArea;
    if (localObject == null)
    {
      i = 0;
      label349:
      if (QLog.isColorLevel()) {
        QLog.d("NearbyTroopsActivity.data", 2, "onGetGroups: areaListSize=" + i + ", isFirst=" + paramBoolean2 + ", mFirstLat=" + paramRspGetNearbyGroup.iLat + ", mFirstLon=" + paramRspGetNearbyGroup.iLon);
      }
      if ((paramRspGetNearbyGroup.dwFlag & 0x1) == 0) {
        break label823;
      }
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.a.j = true;
      label445:
      if (paramBoolean2)
      {
        if (localObject == null) {
          break label846;
        }
        this.a.jdField_a_of_type_JavaUtilArrayList = new ArrayList(((ArrayList)localObject).size());
        label473:
        this.a.e = paramRspGetNearbyGroup.iLat;
        this.a.jdField_f_of_type_Int = paramRspGetNearbyGroup.iLon;
        if ((this.a.e != 0) && (this.a.jdField_f_of_type_Int != 0)) {
          this.a.jdField_c_of_type_Boolean = true;
        }
        this.a.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.a.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(null);
        this.a.jdField_f_of_type_AndroidViewView.setVisibility(0);
        this.a.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this.a.jdField_a_of_type_AndroidViewView$OnFocusChangeListener);
        if (this.a.jdField_a_of_type_JavaUtilArrayList.size() != 0) {
          this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.a(this.a.jdField_a_of_type_JavaUtilArrayList);
        }
      }
      if (localObject == null) {
        break label863;
      }
      if ((this.a.D != 1) || (((ArrayList)localObject).size() <= 0) || (((ArrayList)localObject).get(0) == null) || (!((GroupArea)((ArrayList)localObject).get(0)).strAreaName.equals(this.a.r))) {
        break label1461;
      }
    }
    label823:
    label846:
    label863:
    label922:
    label941:
    label1249:
    label1254:
    label1262:
    label1453:
    label1461:
    for (int i = 1;; i = 0)
    {
      localObject = ((ArrayList)localObject).iterator();
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          GroupArea localGroupArea = (GroupArea)((Iterator)localObject).next();
          if (this.a.jdField_a_of_type_JavaUtilArrayList == null) {
            break;
          }
          this.a.jdField_a_of_type_JavaUtilArrayList.add(new GroupAreaWrapper(localGroupArea));
          if ((i != 0) && (localGroupArea.strAreaName.equals(this.a.r)))
          {
            GroupAreaWrapper localGroupAreaWrapper = (GroupAreaWrapper)this.a.jdField_a_of_type_JavaUtilArrayList.get(0);
            this.a.jdField_a_of_type_JavaUtilArrayList.set(0, new GroupAreaWrapper(localGroupArea));
            this.a.jdField_a_of_type_JavaUtilArrayList.set(this.a.jdField_a_of_type_JavaUtilArrayList.size() - 1, localGroupAreaWrapper);
            continue;
            i = ((ArrayList)localObject).size();
            break label349;
            this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            this.a.j = false;
            break label445;
            this.a.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
            break label473;
          }
        }
      }
      if ((paramRspGetNearbyGroup.stRspAct != null) && (paramRspGetNearbyGroup.stRspTopic != null) && (paramRspGetNearbyGroup.stRspAct.shShowPos > paramRspGetNearbyGroup.stRspTopic.shShowPos))
      {
        this.a.a(paramRspGetNearbyGroup.stRspAct);
        this.a.a(paramRspGetNearbyGroup.stRspTopic);
        localObject = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter;
        if (paramRspGetNearbyGroup.iCompletedFlag != 0) {
          break label1249;
        }
        paramBoolean1 = true;
        ((NearbyTroopsExpandableListViewAdapter)localObject).jdField_c_of_type_Boolean = paramBoolean1;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.d = false;
        if ((!paramBoolean2) || (this.a.jdField_a_of_type_JavaUtilArrayList.size() != 0)) {
          break label1262;
        }
        if (QLog.isColorLevel()) {
          QLog.d("NearbyTroopsActivity", 2, "onGetGroups==>isFirst && mGroupAreaWrapperListData.size() == 0");
        }
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(), "P_CliOper", "Grp_nearby", "", "nearbygrp_entry", "Clk_nearbygrp_blank", 0, 0, "", "", "", "");
        localObject = this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a();
        i = this.a.b;
        if (!this.a.k) {
          break label1254;
        }
      }
      for (paramRspGetNearbyGroup = "0";; paramRspGetNearbyGroup = "1")
      {
        ReportController.b((QQAppInterface)localObject, "P_CliOper", "Grp_nearby", "", "grp", "exp", 0, 0, String.valueOf(i), String.valueOf(paramInt), "0", paramRspGetNearbyGroup);
        if (paramInt == 0)
        {
          if (this.a.h) {
            break;
          }
          if (this.a.jdField_c_of_type_AndroidWidgetRelativeLayout != null) {
            this.a.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          }
          if (this.a.jdField_f_of_type_AndroidViewView != null)
          {
            this.a.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(null);
            this.a.jdField_f_of_type_AndroidViewView.setVisibility(8);
          }
          if (this.a.jdField_a_of_type_AndroidWidgetImageView != null) {
            this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          }
        }
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.b(1);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.a(true);
        return;
        this.a.a(paramRspGetNearbyGroup.stRspTopic);
        this.a.a(paramRspGetNearbyGroup.stRspAct);
        break label922;
        paramBoolean1 = false;
        break label941;
      }
      this.a.a(paramRspGetNearbyGroup);
      this.a.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.a.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(null);
      this.a.jdField_f_of_type_AndroidViewView.setVisibility(0);
      this.a.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this.a.jdField_a_of_type_AndroidViewView$OnFocusChangeListener);
      this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.a(this.a.jdField_a_of_type_JavaUtilArrayList);
      if (paramBoolean2)
      {
        this.a.j();
        localObject = this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a();
        i = this.a.b;
        if (!this.a.k) {
          break label1453;
        }
      }
      for (paramRspGetNearbyGroup = "0";; paramRspGetNearbyGroup = "1")
      {
        ReportController.b((QQAppInterface)localObject, "P_CliOper", "Grp_nearby", "", "grp", "exp", 0, 0, String.valueOf(i), String.valueOf(paramInt), "1", paramRspGetNearbyGroup);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.a(paramBoolean2);
        if (!paramBoolean2) {
          break;
        }
        ThreadManager.a(new veu(this), 5, null, false);
        return;
      }
    }
  }
  
  protected void a(boolean paramBoolean1, RspGetAreaList paramRspGetAreaList, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyTroopsActivity.data", 2, "onGetAreaList: isSuccess=" + paramBoolean1);
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext == null) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.d())) {}
    while ((this.a == null) || (!paramBoolean1) || (paramRspGetAreaList == null) || (paramRspGetAreaList.vGroupArea != null)) {
      return;
    }
  }
  
  protected void a(boolean paramBoolean, RspGetGroupInArea paramRspGetGroupInArea)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyTroopsActivity.data", 2, "onGetGroupInArea: isSuccess=" + paramBoolean);
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext == null) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.d())) {}
    label57:
    do
    {
      Object localObject2;
      do
      {
        int i;
        int j;
        GroupAreaWrapper localGroupAreaWrapper;
        do
        {
          do
          {
            Iterator localIterator;
            do
            {
              do
              {
                ;;;
                break label57;
                while ((this.a == null) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter == null) || (!paramBoolean) || (paramRspGetGroupInArea == null)) {}
                localObject1 = paramRspGetGroupInArea.stGroupArea;
              } while ((localObject1 == null) || (((GroupArea)localObject1).vGroupInfo == null) || (((GroupArea)localObject1).vGroupInfo.size() == 0) || (this.a.jdField_a_of_type_JavaUtilArrayList == null) || (this.a.jdField_a_of_type_JavaUtilArrayList.size() == 0));
              i = ((GroupArea)localObject1).iLat;
              j = ((GroupArea)localObject1).iLon;
              localObject2 = ((GroupArea)localObject1).strAreaName;
              if (QLog.isColorLevel()) {
                QLog.d("NearbyTroopsActivity.data", 2, "onGetGroupInArea: lat=" + i + ", lon=" + j + ", name=" + (String)localObject2 + ", mGroupAreaWrapperListData.size=" + this.a.jdField_a_of_type_JavaUtilArrayList.size());
              }
              localIterator = this.a.jdField_a_of_type_JavaUtilArrayList.iterator();
            } while (!localIterator.hasNext());
            localGroupAreaWrapper = (GroupAreaWrapper)localIterator.next();
          } while ((localGroupAreaWrapper.type != 0) || (localGroupAreaWrapper.groupArea == null));
          paramRspGetGroupInArea = localGroupAreaWrapper.groupArea;
        } while ((paramRspGetGroupInArea.iLat != i) || (paramRspGetGroupInArea.iLon != j) || (!paramRspGetGroupInArea.strAreaName.equals(localObject2)));
        localGroupAreaWrapper.isMoreClick = false;
      } while ((paramRspGetGroupInArea.vGroupInfo == null) || (paramRspGetGroupInArea.vGroupInfo.size() == 0));
      Object localObject1 = ((GroupArea)localObject1).vGroupInfo.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (GroupInfo)((Iterator)localObject1).next();
        paramRspGetGroupInArea.vGroupInfo.add(localObject2);
      }
    } while (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter == null);
    this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.a(this.a.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */