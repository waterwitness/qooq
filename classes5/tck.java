import EncounterSvc.RespGetEncounterV2;
import EncounterSvc.UserData;
import NeighborComm.RespHeader;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.av.service.LBSInfo;
import com.tencent.mobileqq.activity.NearPeopleFilterActivity.NearPeopleFilters;
import com.tencent.mobileqq.adapter.PeopleAroundAdapter;
import com.tencent.mobileqq.app.NearbyObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.maproam.Utils;
import com.tencent.mobileqq.maproam.activity.VipMapRoamActivity;
import com.tencent.mobileqq.maproam.widget.RoamLocalSearchBar;
import com.tencent.mobileqq.maproam.widget.RoamingMapView;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x683.cmd0x683.RankListInfo;
import tencent.sso.roam.Roam.RoamRspHead;

public class tck
  extends NearbyObserver
{
  public tck(VipMapRoamActivity paramVipMapRoamActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, RespHeader paramRespHeader, RespGetEncounterV2 paramRespGetEncounterV2, cmd0x683.RankListInfo paramRankListInfo, ToServiceMsg paramToServiceMsg, List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipMapRoamActivity", 2, "onUpdateGetEncounter isSuccess=" + paramBoolean);
    }
    paramToServiceMsg.extraData.getInt("gender");
    boolean bool = paramToServiceMsg.extraData.getBoolean("first");
    long l = paramToServiceMsg.extraData.getLong("requestId");
    if (paramBoolean) {
      VipMapRoamActivity.a(this.a, paramToServiceMsg.extraData.getBoolean("hasEditInterest", false));
    }
    int i = paramToServiceMsg.extraData.getByte("interest", (byte)0).byteValue();
    paramToServiceMsg.getUin();
    if (l != this.a.jdField_a_of_type_Long) {
      return;
    }
    this.a.jdField_c_of_type_Boolean = false;
    if ((paramBoolean) && (paramRespGetEncounterV2 != null))
    {
      this.a.m = 0;
      NearbySPUtil.b(VipMapRoamActivity.a(this.a).getAccount(), true);
      if (bool)
      {
        this.a.jdField_a_of_type_JavaUtilList = new ArrayList(100);
        this.a.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.a(this.a.jdField_a_of_type_JavaUtilList, true);
      }
      if (paramList != null) {
        this.a.jdField_a_of_type_JavaUtilList.addAll(paramList);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.notifyDataSetChanged();
      this.a.jdField_b_of_type_Long = System.currentTimeMillis();
      if ((paramRespGetEncounterV2.stUserData.lNextGrid != -1L) && ((i == 0) || (VipMapRoamActivity.a(this.a))))
      {
        this.a.jdField_c_of_type_AndroidViewView.setVisibility(8);
        VipMapRoamActivity.a(this.a).setVisibility(8);
        this.a.jdField_d_of_type_AndroidViewView.setVisibility(0);
        paramRespHeader = this.a.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.a;
        if ((!this.a.jdField_a_of_type_JavaUtilList.isEmpty()) || (paramRespHeader == null)) {
          break label852;
        }
        this.a.jdField_b_of_type_AndroidViewView.setVisibility(8);
        if (!this.a.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.a()) {
          break label794;
        }
        paramRankListInfo = (TextView)paramRespHeader.findViewById(2131298153);
        paramRankListInfo.setText(this.a.getString(2131371562));
        paramRankListInfo.setTextColor(this.a.getResources().getColor(2131428302));
        paramRespHeader.findViewById(2131298160).setVisibility(4);
        paramRespHeader.setOnClickListener(null);
        label419:
        this.a.h();
        VipMapRoamActivity.a(this.a, false);
        if ((!StringUtil.b(paramRespGetEncounterV2.strSecurityTips)) && (!StringUtil.b(paramRespGetEncounterV2.strSecurityDetailUrl))) {
          this.a.a(paramRespGetEncounterV2.strSecurityTips, paramRespGetEncounterV2.strSecurityDetailUrl);
        }
        if (1 == this.a.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.a()) {
          this.a.g();
        }
        paramRespGetEncounterV2 = VipMapRoamActivity.a(this.a);
        if (!VipMapRoamActivity.a(this.a).a()) {
          break label889;
        }
        paramRespHeader = "1";
        label515:
        VipUtils.a(paramRespGetEncounterV2, "Vip_MapRoam", "0X8004A2F", "0X8004A2F", 0, 0, new String[] { paramRespHeader });
      }
    }
    for (;;)
    {
      this.a.b(paramBoolean, bool);
      return;
      if ((!VipMapRoamActivity.a(this.a)) && (i >= 1) && (i <= 7))
      {
        VipMapRoamActivity.a(this.a).setVisibility(0);
        this.a.jdField_c_of_type_AndroidViewView.setVisibility(8);
        this.a.jdField_d_of_type_AndroidViewView.setVisibility(8);
        if (VipMapRoamActivity.a(this.a) == null) {
          VipMapRoamActivity.a(this.a, this.a.getResources().getStringArray(2131230783));
        }
        paramRankListInfo = VipMapRoamActivity.a(this.a)[(i - 1)];
        paramRespHeader = String.format("附近还有更多%s爱好者哦", new Object[] { paramRankListInfo });
        paramRankListInfo = String.format("编辑%s兴趣,可以查看更多", new Object[] { paramRankListInfo });
        if (!VipMapRoamActivity.a(this.a).getText().toString().equals(paramRespHeader)) {
          VipMapRoamActivity.a(this.a).setText(paramRespHeader);
        }
        if (VipMapRoamActivity.a(this.a).getText().toString().equals(paramRankListInfo)) {
          break;
        }
        VipMapRoamActivity.a(this.a).setText(paramRankListInfo);
        break;
      }
      this.a.jdField_c_of_type_AndroidViewView.setVisibility(0);
      VipMapRoamActivity.a(this.a).setVisibility(8);
      this.a.jdField_d_of_type_AndroidViewView.setVisibility(8);
      break;
      label794:
      paramRankListInfo = (TextView)paramRespHeader.findViewById(2131298153);
      paramRankListInfo.setText("当前筛选条件下找不到附近的人");
      paramRankListInfo.setTextColor(this.a.getResources().getColor(2131428262));
      paramRespHeader.findViewById(2131298160).setVisibility(0);
      paramRespHeader.setOnClickListener(this.a);
      break label419;
      label852:
      if ((this.a.jdField_b_of_type_AndroidViewView == null) || (this.a.jdField_b_of_type_AndroidViewView.getVisibility() == 0)) {
        break label419;
      }
      this.a.jdField_b_of_type_AndroidViewView.setVisibility(0);
      break label419;
      label889:
      paramRespHeader = "0";
      break label515;
      if (paramRespHeader != null)
      {
        i = paramRespHeader.eReplyCode;
        this.a.m = i;
        this.a.e = paramRespHeader.strResult;
        if (i == 100500)
        {
          paramRespGetEncounterV2 = VipMapRoamActivity.a(this.a);
          if (VipMapRoamActivity.a(this.a).a())
          {
            paramRespHeader = "1";
            label959:
            VipUtils.a(paramRespGetEncounterV2, "Vip_MapRoam", "0X8004A30", "0X8004A30", 0, 0, new String[] { paramRespHeader });
            if (!TextUtils.isEmpty(this.a.e)) {
              break label1042;
            }
          }
          label1042:
          for (paramRespHeader = this.a.getResources().getString(2131371215);; paramRespHeader = this.a.e)
          {
            Utils.a(this.a.getApplication(), 2131367535, paramRespHeader, new tcl(this), null);
            break;
            paramRespHeader = "0";
            break label959;
          }
        }
        if (i == 100501) {
          QQToast.a(this.a.getApplication(), this.a.e, 0).b(this.a.getTitleBarHeight());
        } else {
          VipMapRoamActivity.b(this.a, 1, 2131371217);
        }
      }
      else
      {
        if (!NetworkUtil.e(this.a.getApplication()))
        {
          QQToast.a(this.a.getApplication(), this.a.getString(2131367256), 0).b(this.a.getTitleBarHeight());
          return;
        }
        VipMapRoamActivity.c(this.a, 1, 2131371217);
      }
    }
  }
  
  protected void a(boolean paramBoolean, LBSInfo paramLBSInfo)
  {
    String str;
    StringBuilder localStringBuilder1;
    double d1;
    double d2;
    if ((paramBoolean) && (paramLBSInfo != null))
    {
      str = paramLBSInfo.h();
      if (!TextUtils.isEmpty(str)) {
        this.a.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamLocalSearchBar.a(str);
      }
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(paramLBSInfo.e());
      localStringBuilder1.append(paramLBSInfo.h());
      localStringBuilder1.append(paramLBSInfo.f());
      localStringBuilder1.append(paramLBSInfo.b());
      localStringBuilder1.append(paramLBSInfo.d());
      d1 = paramLBSInfo.b();
      d2 = paramLBSInfo.c();
      paramLBSInfo = this.a.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.getMapCenter();
      if ((Math.abs(d1 - paramLBSInfo.getLatitudeE6()) >= 1.0D) || (Math.abs(d2 - paramLBSInfo.getLongitudeE6()) >= 1.0D)) {
        break label631;
      }
    }
    label631:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("isSuccess=" + paramBoolean);
        localStringBuilder2.append(",isCurrentAddress=" + bool);
        localStringBuilder2.append(",addressLat=" + d1);
        localStringBuilder2.append(",addressLng=" + d2);
        localStringBuilder2.append(",mapCenterLat=" + paramLBSInfo.getLatitudeE6());
        localStringBuilder2.append(",mapCenterLng=" + paramLBSInfo.getLongitudeE6());
        localStringBuilder2.append(",city=" + str);
        localStringBuilder2.append(",address=" + localStringBuilder1.toString());
        QLog.d("VipMapRoamActivity", 2, "onGetUserLocation " + localStringBuilder2.toString());
      }
      if (!TextUtils.isEmpty(localStringBuilder1.toString()))
      {
        this.a.jdField_d_of_type_Boolean = true;
        this.a.jdField_f_of_type_JavaLangString = localStringBuilder1.toString();
        this.a.h();
        if (1 == this.a.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.a())
        {
          if (this.a.jdField_f_of_type_Boolean)
          {
            this.a.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.jdField_f_of_type_JavaLangString);
            if (!this.a.jdField_b_of_type_Boolean)
            {
              this.a.jdField_b_of_type_Boolean = true;
              this.a.jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
              this.a.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.a);
              this.a.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130843183, 0);
            }
          }
          if (this.a.h) {
            this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          }
        }
      }
      if (!this.a.jdField_d_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VipMapRoamActivity", 2, "mRefreshBubbleView error because there is no address");
        }
        if (NetworkUtil.e(this.a.getApplication())) {
          break;
        }
        VipMapRoamActivity.b(this.a, 1, this.a.getString(2131369008));
      }
      return;
    }
    QQToast.a(this.a.getApplication(), this.a.getString(2131371220), 0).b(this.a.getTitleBarHeight());
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Roam.RoamRspHead)))
    {
      paramObject = (Roam.RoamRspHead)paramObject;
      if (paramObject != null)
      {
        this.a.m = ((Roam.RoamRspHead)paramObject).result.get();
        this.a.e = ((Roam.RoamRspHead)paramObject).msg.get();
        if (QLog.isColorLevel()) {
          QLog.d("VipMapRoamActivity", 2, "onGetRoamQualify respHead:isSuccess=true,result=" + this.a.m + ",msg=" + this.a.e);
        }
        if ((this.a.m == 0) && (!TextUtils.isEmpty(this.a.e))) {
          QQToast.a(this.a.getApplication(), this.a.e, 1).b(this.a.getTitleBarHeight());
        }
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("VipMapRoamActivity", 2, "onGetRoamQualify data is null or not RoamRspHead,isSuccess=" + paramBoolean);
  }
  
  public void a(boolean paramBoolean, String paramString1, List paramList, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.update_profile", 2, "onSetPersonalInterestTags");
    }
    if (paramBoolean)
    {
      this.a.a(1, "添加成功", 300);
      this.a.a(true, true);
      return;
    }
    this.a.a(2, "添加失败," + paramString2, 300);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */